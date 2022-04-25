package com.assoft.web.config.listener;

import java.io.File;
import java.io.IOException;

import org.apache.log4j.xml.DOMConfigurator;

import com.assoft.report.util.log.LogRecord;
import com.assoft.web.config.ConfigInfo;
import com.assoft.web.config.ConfigInfoLoader;
import com.assoft.web.config.DbInfo;
import com.assoft.web.config.LocalEnv;
import com.assoft.web.config.LogInfo;
import com.assoft.web.config.SystemConfig;
import com.assoft.web.config.WebInfo;
import com.assoft.web.config.WebPathInfo;
import com.assoft.web.config.mq.MqInfo;
import com.assoft.web.config.mq.MqServer;

public abstract class AsopCmsServer<T extends SystemConfig> {

	protected T systemConfig = null;

	protected LogRecord logger = LogRecord.getLogRecord(this.getClass());
	protected LocalEnv<T> env = null;

	/* 
	 * 1. beforeInitEnv 什么也没有做 留做接口备用
	 * 2，buildEnv 
	 * 		a. 读取wconfig下的 systemconfig.xml 初始化了LocalEnv<T>对象里的ConfigInfo<T>属性对象
	 * 		b. 通过ConfigInfo<T>的属性初始化springcontext.xml里配置的bean对象，包括数据DataSource信息
	 * 3. 设置LocalEnv<T>对象的WebappName属性
	 * 4. 将LocalEnv<T>对象的serverInfo属性赋给了systemConfig变量
	 * 5. 初始化LocalEnv<T>对象的MqServer信息
	 * 6. 启动spring，需要子类（LocalServer）实现
	 * */
	public void execute(WebPathInfo webPathInfo) throws Exception {
		beforeInitEnv(webPathInfo);
		env = initEnv(webPathInfo, gainConfigClass());
		env.getWebInfo().setAppName(webPathInfo.getAppName());
		systemConfig = env.gainSystemInfo();
		MqInfo mqInfo = systemConfig.getMqInfo();
		if (mqInfo != null) {
			MqServer mqServer = MqServer.startServer(mqInfo.getTcpPort(), mqInfo.getManageContextPort(),
					webPathInfo.getMqFilePath());
			env.setMqServer(mqServer);
		}
		// startLucene(env.getRootPath()+"/files",env.getWebInfo().getWebRootPath());
		initStart(systemConfig, env);
	}

	/**
	 * 起始，包括初始化spring等
	 * 
	 * @param config
	 * @param env
	 */
	public abstract void initStart(T config, LocalEnv<T> env);

	/**
	 * 关闭
	 */
	public abstract void executeStop(T config, LocalEnv<T> env);

	/**
	 * hook
	 */
	public void beforeInitEnv(WebPathInfo webPathInfo) {

	}

	public abstract Class<T> gainConfigClass();

	public void stop() {
		try {
			// 关闭mq
			if (env != null && env.getMqServer() != null) {
				env.getMqServer().stop();
			}

			executeStop(systemConfig, env);
			// 关闭lucene

			// 关闭spring
//			if(applicationContext!=null){
//			applicationContext.close();
//		}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error(e.getMessage());

		}

	}

	public LocalEnv<T> initEnv(WebPathInfo webPathInfo, Class<T> clazz) throws IOException {
		LocalEnv<T> env = buildEnv(false, webPathInfo, clazz);
		SystemConfig systemConfig = env.gainSystemInfo();
		
		
		
		String xmlName = "systemContext.xml";

		DbInfo dbInfo = systemConfig.getDbInfo();
		if (dbInfo != null) {
			// dbInfo=buildH2DbInfo(webPathInfo.getRootPath());
			systemConfig.setDbInfo(dbInfo);
			System.setProperty("asopform.dbInfo.driverClassName", dbInfo.getDriverClassName());
			System.setProperty("asopform.dbInfo.url", dbInfo.getUrl());
			System.setProperty("asopform.dbInfo.username", dbInfo.getUserName());
			System.setProperty("asopform.dbInfo.password", dbInfo.getPassword());
			String dialect = dbInfo.getDialect();
			if (dialect != null) {
				System.setProperty("asopform.dbInfo.dialect", dbInfo.getDialect());
			}
		}

		env.setSpringXmlPath(webPathInfo.getRootPath() + "/config/spring/" + xmlName);

		return env;
	}

	private DbInfo buildH2DbInfo(String rootPath) {
		DbInfo info = new DbInfo();
		String dbPath = rootPath + "/files/data/db";
		File file = new File(dbPath);
		if (!file.exists()) {
			file.mkdirs();
		}
		dbPath += "/asopFile";
		info.setDriverClassName("org.h2.Driver");
		// info.setUrl("jdbc:h2:"+dbPath+";");
		info.setUrl("jdbc:h2:" + dbPath + ";MVCC=TRUE");
		info.setUserName("sa");
		info.setPassword("");
		return info;
	}
	
	/* 
	 * 
	 *  */
	private LocalEnv<T> buildEnv(boolean server, WebPathInfo pathInfo, Class<T> clazz) throws IOException {
		String rootPath = pathInfo.getRootPath();
		LocalEnv<T> env = new LocalEnv();
		env.setRootPath(rootPath);

		env.setLogInfo(initLog4j(rootPath));
		ConfigInfo configInfo = null;

		String xmlName = "systemConfig.xml";
		String configXmlPath = rootPath + "/config/" + xmlName;
		configInfo = ConfigInfoLoader.buildConfigInfo(configXmlPath, clazz);

		env.setConfigInfo(configInfo);

		env.setWebInfo(buildWebInfo(pathInfo));
		return env;
	}

	private WebInfo buildWebInfo(WebPathInfo pathInfo) {

		WebInfo info = new WebInfo();

		info.setAppName(pathInfo.getAppName());
		info.setWebRootPath(pathInfo.getAppWebRealPath());

		return info;
	}

	private LogInfo initLog4j(String rootPath) {
		LogInfo info = new LogInfo();
		String logConfigPath = rootPath + "/config/log4j.xml";

		String logRootPath = rootPath + "/logs";
		System.setProperty("webapp.root", rootPath);

		info.init(logRootPath);
		DOMConfigurator.configure(logConfigPath);// 加载.xml文件

		return info;
	}

	public T getSystemConfig() {
		return systemConfig;
	}

	public void setSystemConfig(T systemConfig) {
		this.systemConfig = systemConfig;
	}

}
