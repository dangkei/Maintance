package com.assoft.aspweb.action.webmain;

import java.io.FileReader;
import java.util.Map;
import java.util.Properties;

import org.apache.jcs.engine.control.CompositeCacheManager;
import org.apache.velocity.app.Velocity;
import org.apache.xbean.spring.context.FileSystemXmlApplicationContext;

import com.assoft.asopUtil.common.tool.util.jedis.RedisBootStrapUtil;
import com.assoft.aspweb.common.config.LocalConfig;
import com.assoft.web.config.LocalEnv;
import com.assoft.web.config.listener.AsopCmsServer;
import com.soft.cms.spring.SpringContext;

/*
 * AsopCmsServer的实现类实现了父类的 initStart方法
 * 
 * */
public class LocalServer extends AsopCmsServer<LocalConfig> {

	FileSystemXmlApplicationContext applicationContext = null;

	BootStrap bootStrap;

	/*
	 * 1. 启动redis连接池,如果systemconfig里没有redis配置的话初始化磁盘jcscache 
	 * 2. 初始化ApplicationContext，启动spring容器！！
	 * 3. 执行BootStrap方法的start执行应用内自定义初始化行为（容器完全启动成功）
	 * */
	@Override
	public void initStart(LocalConfig config, LocalEnv<LocalConfig> env) {
		try {
			System.out.println("=================initStart  now!!!===============");
			Velocity.init();// 初始化velocity  

			String configFileName = env.getRootPath() + "/config/cache.ccf";
			String cacheDiskPath = env.getRootPath() + "/jcscache";
			Map<String, String> map = config.getRedisMap();
			if (map != null) {
				RedisBootStrapUtil.startRedis(map); 
			} else {
				initJcs(configFileName, cacheDiskPath);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("=================Start spring now!!!===============" + env.getSpringXmlPath());
		// 启动spring
		applicationContext = new FileSystemXmlApplicationContext("file:" + env.getSpringXmlPath());

		String mode = config.getMode();
		if (LocalConfig.MODE_SERVER.equals(mode)) {// 服务端模式
			bootStrap = (BootStrap) SpringContext.getBean("serverBootStrapService");
		} else {// 客户端模式或者混合模式
			bootStrap = (BootStrap) SpringContext.getBean("bootStrapService");
		}
		System.out.println("=================bootstarp start now!!!===============");

		bootStrap.start(config, env);

	}

	private void initJcs(final String configFilename, String cacheDiskPath) {
		if (configFilename != null) {
			try {
				FileReader fileReader = new FileReader(configFilename);
				Properties props = new Properties();
				props.load(fileReader);
				props.setProperty("jcs.auxiliary.DC.attributes.DiskPath", cacheDiskPath);
				CompositeCacheManager ccm = CompositeCacheManager.getUnconfiguredInstance();
				ccm.configure(props);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	@Override
	public void executeStop(LocalConfig config, LocalEnv<LocalConfig> env) {

		if (bootStrap != null) {
			bootStrap.stop(config, env);
		}

		if (applicationContext != null) {
			applicationContext.close();
		}

	}

	@Override
	public Class<LocalConfig> gainConfigClass() {
		return LocalConfig.class;
	}

}
