package ftp;

import com.lowagie.text.Cell;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Rectangle;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfWriter;

import java.io.*;
import java.sql.*;
import java.util.*;
import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.DriverManager;
import java.text.SimpleDateFormat;
import java.util.Properties;
import java.util.UUID;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import lotus.domino.Database;
import lotus.domino.DocumentCollection;
import lotus.domino.EmbeddedObject;
import lotus.domino.Item;
import lotus.domino.Name;
import lotus.domino.NotesException;
import lotus.domino.NotesFactory;
import lotus.domino.RichTextItem;
import lotus.domino.Session;
import lotus.domino.View;
import lotus.domino.ViewEntry;
import lotus.domino.ViewEntryCollection;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class SynchronizeArchives extends Thread
{
  static Logger logger = Logger.getLogger(SynchronizeArchives.class.getName());
  static final int TYPE_INT = 1;
  static final int TYPE_FLOAT = 2;
  static final int TYPE_VARCHAR = 3;
  static final int TYPE_DATE = 4;
  static final int TYPE_FUNC = 5;
  public lotus.domino.Document docBaseSet;
  public String strRDBType;
  public String strRDBName;
  public String strRDBIP;
  public String strRDBPort;
  public String strRDBUserName;
  public String strRDBUserPwd;
  public String strRDBUrl;
  public String strRDBDriver;
  public String strView;
  public String strTable;
  public String strIds;
  public String strDelorMor;
  public String strAttachFile;
  public String strRDBAttach;
  public String strAttachView;
  public String strAttachInNewTable;
  public String strAttTable;
  public String strMainkey;
  public String strAttkey;
  public String strAttNo;
  public String strAttFileName;
  public String strAttFileNameAll;
  public String strAttEXT;
  public String strAttPZM;
  public String strAttPath;
  public String strFieldIdsAtt;
  public String strAllAttach;
  public String TDocType;
  public int intNum = 0;
  public Connection con;
  public Statement stmt;
  public ResultSet rs;
  public String strRDBattachFiled;
  String strNotesServer;
  String strUserName;
  String strPSW;
  String strApp;
  String strConfigDBName;
  String strDataDBPath;
  Database NdbArchives = null;

  Database NdbConfig = null;
  InitParameter initParam;

  public SynchronizeArchives()
  {
    PropertyConfigurator.configure("log.properties");
    try
    {
      Properties prop = new Properties();
      prop.load(new FileInputStream("DomSerConfig.ini"));
      String strTmpNotesSever = prop.getProperty("NotesServer");
      String strTmpNotesUserName = prop.getProperty("UserName");
      String strTmpNotesPSW = prop.getProperty("PSW");
      String strTmpNotesApp = prop.getProperty("App");
      String strTmpNotesConfigDBName = prop.getProperty("ConfigDBName");
      String strFilePathLocal = prop.getProperty("StrFilePathLocal");
      String strFilePathFtp = prop.getProperty("StrFilePathFtp");
      String strFtpIP = prop.getProperty("StrFtpIP");
      String strFtpUser = prop.getProperty("StrFtpUser");
      String strFtpPwd = prop.getProperty("StrFtpPwd");
      int strFtpPort = Integer.parseInt(prop.getProperty("StrFtpPort"));
      int intRecyclTime = Integer.parseInt(prop.getProperty("IntervalTime"));
      this.initParam = new InitParameter();
      this.initParam.setStrNotesServer(strTmpNotesSever);
      this.initParam.setStrNotesUserName(strTmpNotesUserName);
      this.initParam.setStrNotesPSW(strTmpNotesPSW);
      this.initParam.setStrNotesApp(strTmpNotesApp);
      this.initParam.setStrNotesConfigDBName(strTmpNotesConfigDBName);
      this.initParam.setStrNotesConfigDBName(strTmpNotesConfigDBName);
      this.initParam.setStrFilePathLocal(strFilePathLocal);
      this.initParam.setStrFilePathFtp(strFilePathFtp);
      this.initParam.setStrFtpIP(strFtpIP);
      this.initParam.setStrFtpUser(strFtpUser);
      this.initParam.setStrFtpPwd(strFtpPwd);
      this.initParam.setStrFtpPort(strFtpPort);
      InitParameter.setRecycleTime(intRecyclTime);
    }
    catch (Exception e)
    {
      logger.error(e);
    }
  }

  public void mainTheard()
  {
    try
    {
      Session session = null;

      if (!(ConnectDomServer()))
        return;
      session = this.initParam.getNSession();

      String strDomDBPath = this.initParam.getStrNotesApp() + "/" + 
        this.initParam.getStrNotesConfigDBName();
      Database tmpNdbConfig = ConnectDomDB("", strDomDBPath);

      this.initParam.setNdbConfig(tmpNdbConfig);

      if (tmpNdbConfig == null)
        return;
      View vwBaseSet = tmpNdbConfig.getView("vwTabletoVw");
      lotus.domino.Document docBaseSet = vwBaseSet.getFirstDocument();

      while (docBaseSet != null)
      {
        this.initParam.setDocBaseSet(docBaseSet);

        analyseNDoc();

        strDomDBPath = this.initParam.getStrDataDBPath();
        Database tmpNdbArchives = ConnectDomDB(this.initParam.getStrCurrentServerName(), strDomDBPath);
        this.initParam.setNdbArchives(tmpNdbArchives);
        initRelatDBParam();
        if (openRelationDb()) {
          setKeyMap(tmpNdbConfig);
          NDBToRDB();
        }

        this.initParam.removeAttachFieldMap();
        this.initParam.removeVKeyFieldMap();
        this.initParam.removeVSpecialField();
        docBaseSet = vwBaseSet.getNextDocument(docBaseSet);
      }

    }
    catch (Exception e)
    {
      logger.error(e);
    }
  }

  public boolean ConnectDomServer()
  {
    boolean blnConnect = false;
    Session session = null;
    try
    {
      session = ConnectDomServer(this.initParam.getStrNotesServer(), 
        this.initParam.getStrNotesUserName(), this.initParam.getStrNotesPSW());
      if (session != null)
      {
        this.initParam.setNSession(session);
        blnConnect = true;
        showMSG(getTime() + "�ɹ����ӵ�Domino������", "");
      }
    } catch (Exception e) {
      showMSG(getTime() + "����Domino������ʧ�ܣ�1����������Ϣ����", "");
      logger.error(e);
    }
    return blnConnect;
  }

  public Session ConnectDomServer(String hostName, String userName, String password)
  {
    Session session = null;
    try
    {
      showMSG(getTime() + "------------ConnectDomServer------------", "");
      showMSG(hostName, "");
      showMSG(userName, "");
      showMSG(password, "");

      session = NotesFactory.createSession(hostName, userName, password);
      if (session != null)
      {
        showMSG(getTime() + "�ɹ����ӵ�Domino������", "");
      }
    } catch (Exception e) {
      showMSG(getTime() + "����Domino������ʧ�ܣ�2����������Ϣ����", "");
      logger.error(e);
    }
    return session;
  }

  private Database ConnectDomDB(String hostName, String strDomDBPath)
  {
    Database tmpNdb = null;
    try
    {
      Session tmpSession;
      if (hostName.equals("")) {
        tmpSession = this.initParam.getNSession();
      } else {
        tmpSession = ConnectDomServer(hostName, 
          this.initParam.getStrNotesUserName(), this.initParam.getStrNotesPSW());
        if (tmpSession != null)
          this.initParam.setNSession(tmpSession);
        else {
          return null;
        }

      }

      if (tmpSession != null)
      {
        showMSG(getTime() + "-----------ConnectDomDB-----------", "");
        showMSG(tmpSession.getServerName(), "");
        showMSG(tmpSession.getUserName(), "");
        showMSG(strDomDBPath, "");
        tmpNdb = tmpSession.getDatabase(tmpSession.getServerName(), strDomDBPath);
        if (tmpNdb.isOpen())
        {
          showMSG(
            getTime() + "\t���ʵ����ÿ�:" + tmpNdb.getTitle(), 
            "");

          return tmpNdb;
        }

        showMSG(
          getTime() + "\t���ʵ����ÿ�:" + strDomDBPath, 
          "ʧ��");
      }
    }
    catch (Exception e) {
      showMSG(getTime() + "����Domino������ʧ�ܣ�����������Ϣ����", "");
      logger.error(e);
    }
    return tmpNdb;
  }

  public void SynUser(Session session, lotus.domino.Document doc, Database NdbArchives)
  {
    try
    {
      String strTableName = doc.getItemValueString("fldTableName");
      String strdocIds = doc.getItemValueString("fldFieldIds");
      String strUser = doc.getItemValueString("fldUser");

      Vector vUserlist = doc.getItemValue("fldUserOut");

      this.strRDBType = doc.getItemValueString("fldRDBType");
      this.strRDBName = doc.getItemValueString("fldRDBName");
      this.strRDBIP = doc.getItemValueString("fldRDBIP");
      this.strRDBPort = doc.getItemValueString("fldRDBPort");
      this.strRDBUserName = doc.getItemValueString("fldRDBUserName");
      this.strRDBUserPwd = doc.getItemValueString("fldRDBUserPwd");
      if (this.strRDBType.equalsIgnoreCase("odbc")) {
        this.strRDBDriver = "sun.jdbc.odbc.JdbcOdbcDriver";
        this.strRDBUrl = "jdbc:odbc:" + this.strRDBName;
      }
     /* if (this.strRDBType.equalsIgnoreCase("mssql")) {
        this.strRDBDriver = "com.microsoft.jdbc.sqlserver.SQLServerDriver";
        this.strRDBUrl = "jdbc:microsoft:sqlserver://" + this.strRDBIP + 
          ";databasename=" + this.strRDBName;
      }*/
      if (strRDBType.equalsIgnoreCase("mssql")) {
    	  Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); 
          strRDBUrl = "jdbc:sqlserver://" + strRDBIP + ":" + strRDBPort + 
            ";databasename=" + strRDBName;
        }

      
      if (this.strRDBType.equalsIgnoreCase("oracle")) {
        this.strRDBDriver = "oracle.jdbc.driver.OracleDriver";
        this.strRDBUrl = "jdbc:oracle:thin:@" + this.strRDBIP + ":" + this.strRDBPort + 
          ":" + this.strRDBName;
      }
      if (this.strRDBType.equalsIgnoreCase("mysql")) {
        this.strRDBDriver = "org.gjt.mm.mysql.Driver";
        this.strRDBUrl = "jdbc:mysql://" + this.strRDBIP + "/" + this.strRDBName;
      }

      if (openDb())
      {
        String strRDBfield;
        String strNotesValue;
        Database indiNames = session.getDatabase("", 
          "indishare/indinames.nsf");
        View vwABbyName = indiNames.getView("vwABbyName");

        if (strUser.equalsIgnoreCase("1")) {
          for (int i = 0; i < vUserlist.size(); ++i) {
            String strname = vUserlist.elementAt(i).toString();
            Name name = session.createName(strname);
            lotus.domino.Document docUser = vwABbyName.getDocumentByKey(
              name.getCommon());

            String strInsert = "INSERT INTO " + strTableName + "(";
            String strValue = "VALUES (";
            String[] strdocid = strdocIds.split(",");
            for (int j = 0; j < strdocid.length; ++j) {
              View vwFieldtoF = NdbArchives.getView("vwFieldtoF");
              lotus.domino.Document docFieldtoF = vwFieldtoF
                .getDocumentByKey(strdocid[j]);
              strRDBfield = docFieldtoF
                .getItemValueString("fldRdbF");
              strNotesValue = docFieldtoF
                .getItemValueString("fldDomF");
              String strDateType = docFieldtoF
                .getItemValueString("fldDateType");

              Vector v = session.evaluate(strNotesValue, docUser);
              String strV = v.firstElement().toString();

              if ((this.strRDBType.equalsIgnoreCase("Oracle")) && 
                (strDateType.equalsIgnoreCase("Date"))) {
                strV = "to_date('" + strV + 
                  "','YYYY-MM-DD HH24:MI:SS')";
              }
              if (strdocid.length - j == 1) {
                if ((this.strRDBType.equalsIgnoreCase("Oracle")) && 
                  (strDateType.equalsIgnoreCase("Date")))
                  strValue = strValue + strV;
                else {
                  strValue = strValue + "'" + strV + "'";
                }
              }
              else if ((this.strRDBType.equalsIgnoreCase("Oracle")) && 
                (strDateType.equalsIgnoreCase("Date")))
                strValue = strValue + strV + ",";
              else {
                strValue = strValue + "'" + strV + "',";
              }

              if (strdocid.length - j == 1)
                strInsert = strInsert + strRDBfield;
              else {
                strInsert = strInsert + strRDBfield + ",";
              }
            }
            strInsert = strInsert + ")" + strValue + ")";
            update(strInsert);
          }
        } else {
          lotus.domino.Document docallUser = vwABbyName.getFirstDocument();
          while (docallUser != null)
          {
            String strInsert = "INSERT INTO " + strTableName + "(";
            String strValue = "VALUES (";
            String[] strdocid = strdocIds.split(",");
            for (int j = 0; j < strdocid.length; ++j) {
              View vwFieldtoF = NdbArchives.getView("vwFieldtoF");
              lotus.domino.Document docFieldtoF = vwFieldtoF
                .getDocumentByKey(strdocid[j]);
              strRDBfield = docFieldtoF
                .getItemValueString("fldRdbF");
              strNotesValue = docFieldtoF
                .getItemValueString("fldDomF");
              String strDateType = docFieldtoF
                .getItemValueString("fldDateType");

              Vector v = session.evaluate(strNotesValue, 
                docallUser);
              String strV = v.firstElement().toString();

              if ((this.strRDBType.equalsIgnoreCase("Oracle")) && 
                (strDateType.equalsIgnoreCase("Date"))) {
                strV = "to_date('" + strV + 
                  "','YYYY-MM-DD HH24:MI:SS')";
              }
              if (strdocid.length - j == 1) {
                if ((this.strRDBType.equalsIgnoreCase("Oracle")) && 
                  (strDateType.equalsIgnoreCase("Date")))
                  strValue = strValue + strV;
                else {
                  strValue = strValue + "'" + strV + "'";
                }
              }
              else if ((this.strRDBType.equalsIgnoreCase("Oracle")) && 
                (strDateType.equalsIgnoreCase("Date")))
                strValue = strValue + strV + ",";
              else {
                strValue = strValue + "'" + strV + "',";
              }

              if (strdocid.length - j == 1)
                strInsert = strInsert + strRDBfield;
              else {
                strInsert = strInsert + strRDBfield + ",";
              }
            }
            strInsert = strInsert + ")" + strValue + ")";
            update(strInsert);
            docallUser = vwABbyName.getNextDocument(docallUser);
          }
        }
      }

      doc.replaceItemValue("fldNote", "2");
      if (doc.save())
        logger.info(getTime() + "�ɹ������û���");
    }
    catch (Exception e) {
    	e.printStackTrace();
      logger.error(e);
    }
  }

  public void getBaseSet(lotus.domino.Document doc)
  {
    try
    {
      this.docBaseSet = doc;

      this.strRDBType = this.docBaseSet.getItemValueString("fldRDBType");
      this.strRDBName = this.docBaseSet.getItemValueString("fldRDBName");
      this.strRDBIP = this.docBaseSet.getItemValueString("fldRDBIP");
      this.strRDBPort = this.docBaseSet.getItemValueString("fldRDBPort");
      this.strRDBUserName = this.docBaseSet.getItemValueString("fldRDBUserName");
      this.strRDBUserPwd = this.docBaseSet.getItemValueString("fldRDBUserPwd");
      this.TDocType = this.docBaseSet.getItemValueString("TDocType");
      if (this.strRDBType.equalsIgnoreCase("odbc")) {
        this.strRDBDriver = "sun.jdbc.odbc.JdbcOdbcDriver";
        this.strRDBUrl = "jdbc:odbc:" + this.strRDBName;
      }
      if (this.strRDBType.equalsIgnoreCase("mssql")) {
        this.strRDBDriver = "com.microsoft.jdbc.sqlserver.SQLServerDriver";
        this.strRDBUrl = "jdbc:microsoft:sqlserver://" + this.strRDBIP + 
          ";databasename=" + this.strRDBName;
      }
      if (this.strRDBType.equalsIgnoreCase("oracle")) {
        this.strRDBDriver = "oracle.jdbc.driver.OracleDriver";
        this.strRDBUrl = "jdbc:oracle:thin:@" + this.strRDBIP + ":" + this.strRDBPort + 
          ":" + this.strRDBName;
      }
      if (this.strRDBType.equalsIgnoreCase("mysql")) {
        this.strRDBDriver = "org.gjt.mm.mysql.Driver";
        this.strRDBUrl = "jdbc:mysql://" + this.strRDBIP + "/" + this.strRDBName;
      }

      this.strView = this.docBaseSet.getItemValueString("fldView");
      this.strTable = this.docBaseSet.getItemValueString("fldTable");
      this.strIds = this.docBaseSet.getItemValueString("fldFieldIds");
      this.strDelorMor = this.docBaseSet.getItemValueString("fldDelorMov");
      this.strAttachFile = this.docBaseSet.getItemValueString("fldAttachFile");
      this.strAttachView = this.docBaseSet.getItemValueString("fldAttView");
      this.strRDBAttach = this.docBaseSet.getItemValueString("fldRDBAttach");

      this.strAttachInNewTable = 
        this.docBaseSet.getItemValueString("fldAttachInNewTable");
      this.strAttTable = this.docBaseSet.getItemValueString("fldAttTable");
      this.strMainkey = this.docBaseSet.getItemValueString("fldMainkey");
      this.strAttkey = this.docBaseSet.getItemValueString("fldAttkey");
      this.strAttNo = this.docBaseSet.getItemValueString("fldAttNo");
      this.strAttFileName = this.docBaseSet.getItemValueString("fldAttFileName");
      this.strAttFileNameAll = 
        this.docBaseSet.getItemValueString("fldAttFileNameAll");
      this.strAttEXT = this.docBaseSet.getItemValueString("fldAttEXT");
      this.strAttPZM = this.docBaseSet.getItemValueString("fldAttPZM");
      this.strAttPath = this.docBaseSet.getItemValueString("fldAttPath");
      this.strFieldIdsAtt = this.docBaseSet.getItemValueString("fldFieldIdsAtt");
    }
    catch (Exception e) {
      logger.error(e);
    }
  }

  public void initRelatDBParam()
  {
    try
    {
      lotus.domino.Document docBaseSet = this.initParam.getDocBaseSet();
      String strRDBDriver = "";
      String strRDBUrl = "";

      String strRDBType = docBaseSet.getItemValueString("fldRDBType");
      this.initParam.setStrRDBType(strRDBType);
      String strRDBName = docBaseSet.getItemValueString("fldRDBName");
      this.initParam.setStrRDBName(strRDBName);

      String strRDBIP = docBaseSet.getItemValueString("fldRDBIP");
      this.initParam.setStrRDBIP(strRDBIP);
      String strRDBPort = docBaseSet.getItemValueString("fldRDBPort");
      this.initParam.setStrRDBPort(strRDBPort);
      this.initParam.setStrRDBUserName(
        docBaseSet.getItemValueString("fldRDBUserName"));
      this.initParam.setStrRDBUserPwd(
        docBaseSet.getItemValueString("fldRDBUserPwd"));

      this.initParam.setTDocType(docBaseSet.getItemValueString("TDocType"));
      if (strRDBType.equalsIgnoreCase("odbc")) {
        strRDBDriver = "sun.jdbc.odbc.JdbcOdbcDriver";
        strRDBUrl = "jdbc:odbc:" + strRDBName;
      }
      if (strRDBType.equalsIgnoreCase("mssql2003")) {
        strRDBDriver = "com.microsoft.jdbc.sqlserver.SQLServerDriver";
        strRDBUrl = "jdbc:microsoft:sqlserver://" + strRDBIP + 
          ";databasename=" + strRDBName;
      }
      if (strRDBType.equalsIgnoreCase("mssql")) {
//    	  System.out.println("2005����");
//    	  strRDBDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver"; 
//          strRDBUrl = "jdbc:sqlserver://" + strRDBIP + ":" + strRDBPort + 
//            ";databaseName=" + strRDBName;
    	  System.out.println("2005����");
    	  strRDBDriver = "net.sourceforge.jtds.jdbc.Driver"; 
          strRDBUrl = "jdbc:jtds:sqlserver://" + strRDBIP + ":" + strRDBPort + 
            "/" + strRDBName;
        }
      if (strRDBType.equalsIgnoreCase("oracle")) {
        strRDBDriver = "oracle.jdbc.driver.OracleDriver";
        strRDBUrl = "jdbc:oracle:thin:@" + strRDBIP + ":" + strRDBPort + 
          ":" + strRDBName;
      }
      if (strRDBType.equalsIgnoreCase("mysql")) {
        strRDBDriver = "org.gjt.mm.mysql.Driver";

        strRDBUrl = "jdbc:mysql://" + strRDBIP + ":" + strRDBPort + "/" + 
          strRDBName;
      }
      showMSG(strRDBDriver, "");
      showMSG(strRDBUrl, "");
      this.initParam.setStrRDBDriver(strRDBDriver);
      this.initParam.setStrRDBURL(strRDBUrl);
    } catch (Exception e) {
      logger.error(e);
    }
  }

  private void changeKeyType(Vector vKeyValue, int intKeyRelType, String strRelDBType)
  {
  }

  private String getDateSql(String strDate)
  {
    String strDateSql = "";

    String strRDBType = this.initParam.getStrRDBType();

    if (strRDBType.equalsIgnoreCase("Oracle"))
      strDateSql = "to_date('" + strDate + "','YYYY-MM-DD HH24:MI:SS')";
    else {
      strDateSql = strDate;
    }
    return strDateSql;
  }

  private Vector setKeyValue(lotus.domino.Document NKeyMapDoc)
  {
    String fldDataFrom = null;

    Vector vKeyMap = new Vector();
    try
    {
      String strKeyName = NKeyMapDoc.getItemValueString("fldMarker");
      String strKeyText = NKeyMapDoc.getItemValueString("fldDomF");
      String strRelFieldName = NKeyMapDoc.getItemValueString("fldRdbF");
      String strRelFieldType = NKeyMapDoc.getItemValueString("fldDateType");
      fldDataFrom = NKeyMapDoc.getItemValueString("fldDataFrom");

      if (fldDataFrom == null) {
        fldDataFrom = "0";
      }
      showMSG(strKeyName,"");
      vKeyMap.add(0, "travelsky");
      vKeyMap.add(1, strKeyName);
      vKeyMap.add(2, strRelFieldName);
      vKeyMap.add(3, strKeyText);
      vKeyMap.add(4, strRelFieldType);
      vKeyMap.add(5, fldDataFrom);
    }
    catch (Exception e)
    {
      logger.error(e);
    }
    return vKeyMap;
  }

  private Vector getKeyValue(lotus.domino.Document NDataDoc, String strKeyText)
  {
    Vector vTmpKeyValue = null;
    Session session = this.initParam.getNSession();
    try {
      if (!(findSpecialKey(strKeyText))) {
        vTmpKeyValue = session.evaluate(strKeyText, NDataDoc); 
        return vTmpKeyValue;
      }
      vTmpKeyValue = NDataDoc.getItemValue(strKeyText);
    }
    catch (Exception e) {
      showMSG(strKeyText + " ����������!", "");
      logger.error(e);
    }
    return vTmpKeyValue;
  }

  private String getKeyValue(lotus.domino.Document NDataDoc, String strKeyText, String strFilePath)
  {
    String strFileName = "";
    try {
      if (!(strKeyText.equalsIgnoreCase(""))) {
        strFileName = extractFile(NDataDoc, strFilePath);
      }

    }
    catch (Exception e)
    {
      showMSG(strKeyText + " ����������!", "");
      logger.error(e);
    }
    return strFileName;
  }

  public boolean NDocToTable(lotus.domino.Document dataDoc)
  {
    Vector tmpVKeyMap = new Vector();
    Vector tmpVKeyItem = new Vector();
    Vector tmpVKeyValue = null;
    Vector VAttachFieldMap = null;

    Vector tmpVRDBKeyItems = null;
    Vector tmpVRDBAttachKeyItems = null;

    String strKeyText = "";
    String tmpStrKeyValue = "";
    String tmpSepcialKeyValue = "";

    String strFileSeparator = "";
    String strAttachInNewTable = "";
    String strTableName = "";
    String strAttachTableName = "";

    String strMainKey = "";
    String strAttachForeignKey = "";

    String strIsUnique = "0";
    String strIsNull = "0";

    int intExportAttitude = 0;
    String strSql = "";

    int j = 0;
    int exitSpecailKey = 0;
    int intMainKeyNum = 1000000;

    String strKeyWord = "KEYWORD";
    strFileSeparator = this.initParam.getStrSepretor();
    strAttachInNewTable = this.initParam.getStrAttachInNewTable();

    tmpVKeyMap = this.initParam.getVKeyFieldMap();
    VAttachFieldMap = this.initParam.getVAttachFieldMap();

    strTableName = this.initParam.getStrTable();
    String strFilePath = this.initParam.getStrAttachFilePath();
    intExportAttitude = this.initParam.getIntExportAttitude();

    boolean blnAttachIsNewTable = strAttachInNewTable.equalsIgnoreCase("1");
    tmpVRDBKeyItems = new Vector();
    String strGuid = getGuid();

    Vector vNewItemMap = null;
    Vector vNewAttachItemMap = null;

    if (!(blnAttachIsNewTable)) {
      if (intExportAttitude == 1)
        vNewItemMap = dealDocYJ(dataDoc, tmpVKeyMap);
      else
        vNewItemMap = tmpVKeyMap;
    } else {
      vNewItemMap = tmpVKeyMap;
      if (intExportAttitude == 1)
        vNewAttachItemMap = dealDocYJ(dataDoc, VAttachFieldMap);
      else {
        vNewAttachItemMap = VAttachFieldMap;
      }
    }
    strMainKey = this.initParam.getStrMainkey();

    for (int i = 0; i < vNewItemMap.size(); ++i) {
      tmpVKeyValue = new Vector();
      tmpVKeyItem = (Vector)vNewItemMap.get(i);

      tmpVKeyValue = getItemValue(dataDoc, tmpVKeyItem, strTableName);
      if (tmpVKeyValue.get(1).toString().equalsIgnoreCase(strMainKey))
        this.initParam.setStrPrimaryKeyValue(tmpVKeyValue.get(2).toString());
      tmpVRDBKeyItems.add(tmpVKeyValue);
    }
    try
    {
      strSql = makeStrSQL(strTableName, tmpVRDBKeyItems);
      System.out.println(strSql);
      update(strSql);

      if (blnAttachIsNewTable) {
        Vector tmpVAttchKeyValue = new Vector();
        tmpVRDBAttachKeyItems = new Vector();

        DocumentCollection AttachDocs = getAttachDoc(dataDoc);
        strAttachTableName = this.initParam.getStrAttTable();

        lotus.domino.Document tmpAttachDoc = AttachDocs.getFirstDocument();
        String AttachForeignKey = this.initParam.getStrAttachForeignKey();
        if ((AttachForeignKey != "") && (AttachForeignKey != null)) {
          this.initParam.setStrAttachForeignKeyValue(this.initParam.getStrPrimaryKeyValue());
        }
       
        while (tmpAttachDoc != null) {
          if (tmpAttachDoc.hasItem("$file"))
          {
        	  
        	  showMSG(tmpAttachDoc.getItemValueString("FileName"),"");
        	 
        	  extractFile(tmpAttachDoc,this.initParam.getStrFilePathLocal());
            tmpVRDBAttachKeyItems = getAttachKeyMap(tmpAttachDoc, vNewAttachItemMap);
            strSql = makeStrSQL(strAttachTableName,tmpVRDBAttachKeyItems);
            System.out.println(strSql);
            update(strSql);
          }
          tmpAttachDoc = AttachDocs.getNextDocument(tmpAttachDoc);
        }
        String strFilePathFtp =  this.initParam.getStrFilePathFtp();
       	String strFilePathLocal = this.initParam.getStrFilePathLocal() + "/";
        String strFtpIP = this.initParam.getStrFtpIP();
        String strFtpUser = this.initParam.getStrFtpUser();
        String strFtpPwd = this.initParam.getStrFtpPwd();
        int	strFtpPort = this.initParam.getStrFtpPort();
        UploadFile.runUpload(strFilePathLocal
				.replace("\\", "/"), strFilePathFtp,
				strFtpIP,
				strFtpUser,
				strFtpPwd,strFtpPort);
      }

    }
    catch (Exception e)
    {
      logger.error(e);
      return false;
    }
    return true;
  }

  private String makeStrSQL(String strTableName, Vector vKeyMap)
  {
    String strSql = "";

    String tmpInsertKeyItem = "";
    String tmpInsertValues = "";

    Vector tmpVKeyMap = null;

    String tmpInsertSql = "INSERT INTO " + strTableName;
    String tmpValue = " VALUES ";
    try {
      for (int i = 0; i < vKeyMap.size(); ++i) {
        tmpVKeyMap = (Vector)vKeyMap.get(i);
        tmpInsertKeyItem = tmpInsertKeyItem + 
          tmpVKeyMap.get(1).toString();

        switch (stringToInt(tmpVKeyMap.get(3).toString()))
        {
        case 3:
          tmpInsertValues = tmpInsertValues + "'" + 
            tmpVKeyMap.get(2).toString() + "'";
          break;
        case 4:
          tmpInsertValues = tmpInsertValues + 
            getDateSql(tmpVKeyMap.get(2).toString());
          break;
        default:
          tmpInsertValues = tmpInsertValues + 
            tmpVKeyMap.get(2).toString();
        }
        if (i < vKeyMap.size() - 1) {
          tmpInsertKeyItem = tmpInsertKeyItem + ",";
          tmpInsertValues = tmpInsertValues + ",";
        }
      }
      tmpInsertKeyItem = "(" + tmpInsertKeyItem + ")";
      tmpInsertValues = "(" + tmpInsertValues + ")";
      strSql = tmpInsertSql + tmpInsertKeyItem + tmpValue + 
        tmpInsertValues;
      vKeyMap = null;
    } catch (Exception e) {
      showMSG(tmpVKeyMap.get(1).toString() + "��������", "");
      logger.error(e);
    }
    //showMSG(strSql, "hidden");
    return strSql;
  }

  public void NDBToRDB()
  {
    try
    {
      Database dataDB = this.initParam.getNdbArchives();
      String strViewName = this.initParam.getStrDataView();
      View dataView = dataDB.getView(strViewName);
      logger.info(dataDB.getFilePath());
      logger.info(strViewName);
      ViewEntryCollection dataDocs = dataView.getAllEntries();

      ViewEntry tmpEnty = dataDocs.getFirstEntry();

      logger.info(Integer.valueOf(dataDocs.getCount()));
      while (tmpEnty != null) {
        lotus.domino.Document tmpDoc = tmpEnty.getDocument();
        boolean blnHadOut = NDocToTable(tmpDoc);

        dealDoc(tmpDoc, blnHadOut);
        tmpEnty = dataDocs.getNextEntry(tmpEnty);
      }
    } catch (NullPointerException e) {
      logger.error(e);
    }
    catch (NotesException e) {
      logger.error(e);
    }
  }

  private Vector getItemValue(lotus.domino.Document doc, Vector VKeyItem, String strTableName)
  {
    Vector tmpVKeyValue = new Vector();
    Vector tmpKeyValue = new Vector();
    String strKeyText = "";
    String fldDataFrom = "0";
    String tmpStrKeyValue = "";
    String tmpDataType = "";

    tmpVKeyValue.add(0, "travelsky");
    tmpVKeyValue.add(1, VKeyItem.get(2));
    strKeyText = VKeyItem.get(3).toString();

    fldDataFrom = VKeyItem.get(5).toString();

    tmpDataType = VKeyItem.get(4).toString();

    if (!(findSpecialKey(strKeyText)))
    {
      if ((fldDataFrom.equalsIgnoreCase("1")) && (stringToInt(tmpDataType) == 1)) {
        tmpStrKeyValue = intToString(getMainKeyID(strTableName, VKeyItem.get(2).toString()));
      }
      else if ((fldDataFrom.equalsIgnoreCase("1")) && (stringToInt(tmpDataType) == 3)) {
        tmpStrKeyValue = getGuid();
      } else {
        tmpKeyValue = getKeyValue(doc, strKeyText);
        tmpStrKeyValue = tmpKeyValue.firstElement().toString();
      }

    }
    else
    {
      tmpStrKeyValue = getSpecialKeyValue(doc, strKeyText, VKeyItem.get(2).toString());
    }
    if (tmpStrKeyValue != "") {
      tmpVKeyValue.add(2, tmpStrKeyValue);
      tmpVKeyValue.add(3, VKeyItem.get(4));
    } else {
      showMSG(strKeyText + "����Ϊ��!", "");
    }
    return tmpVKeyValue;
  }

  private void dealDoc(lotus.domino.Document doc, boolean blnErr)
  {
    String intDelOrMoveDoc = new String("0");
    intDelOrMoveDoc = this.initParam.getStrDelorMor();
    try
    {
      if (blnErr) {
        if (intDelOrMoveDoc.equals("1")) {
          doc.remove(true);
          showMSG(doc.getUniversalID() + "�Ѿ�ɾ��", ""); return;
        }

        doc.replaceItemValue("StatOut", "�ѵ���");

        doc.save(true);

        showMSG(
          doc.getUniversalID() + "������ͼ��vwDocHadOut��", 
          "");

        return;
      }

      doc.getFirstItem("StatOut").setValueString("�����쳣");
      doc.save(true);
      showMSG(doc.getUniversalID() + "������ͼ��vwDocHaveErr��", "");
    }
    catch (NotesException e)
    {
      logger.error(e);
    }
  }

  private int getMainKeyID(String tableName, String strKeyItems)
  {
    String strMainKey = "";
    String strRDBType = "";
    String strSelectSql = "";
    int intKeyNum = 0;

    strMainKey = strKeyItems;
    strRDBType = this.initParam.getStrRDBType();
    strSelectSql = "select top 1 * from " + tableName + " order by " + 
      strMainKey + " desc";

    if (strRDBType.equalsIgnoreCase("oracle")) {
      strSelectSql = "select * from (select * from " + tableName + 
        " order by " + strMainKey + " desc) where rownum<2";
    }
    if (strRDBType.equalsIgnoreCase("mysql"))
      strSelectSql = "select * from " + tableName + " order by " + 
        strMainKey + " desc limit 0,1";
    try
    {
      query(strSelectSql);
      if (this.rs.next())
        intKeyNum = this.rs.getInt(strMainKey);
      ++intKeyNum;
    } catch (Exception e) {
      logger.error(e);
    }
    return intKeyNum;
  }

  private int getMainKeyID(String tableName) {
    String strMainKey = "";
    String strRDBType = "";
    String strSelectSql = "";
    int intKeyNum = 0;
    strMainKey = this.initParam.getStrMainkey();
    strRDBType = this.initParam.getStrRDBType();
    strSelectSql = "select top 1 * from " + tableName + " order by " + 
      strMainKey + " desc";

    if (strRDBType.equalsIgnoreCase("oracle")) {
      strSelectSql = "select * from (select * from " + tableName + 
        " order by " + strMainKey + " desc) where rownum<2";
    }
    if (strRDBType.equalsIgnoreCase("mysql"))
      strSelectSql = "select * from " + tableName + " order by " + 
        strMainKey + " desc limit 0,1";
    try
    {
      query(strSelectSql);
      if (this.rs.next())
        intKeyNum = this.rs.getInt(strMainKey);
      ++intKeyNum;
    } catch (Exception e) {
      logger.error(e);
    }
    return intKeyNum;
  }

  private String getSpecialKeyValue(lotus.domino.Document dataDoc, String strKeyText, String strRDBKeyItem)
  {
    String tmpFolder = getGuid();
    String strResult = this.initParam.getStrRDBAttach() + File.separator + 
      tmpFolder + File.separator;
    Database db = this.initParam.getNdbArchives();
    String strAttachViewName = this.initParam.getStrAttachView();
    String strFilePath = this.initParam.getStrAttachFilePath();

    showMSG("-------------test------------", "");
    strFilePath = strFilePath + File.separator + tmpFolder;

    String strFileSeparator = this.initParam.getStrSepretor();
    try {
      if (strKeyText.equalsIgnoreCase("$file")) {
        View vwAttachment = db.getView(strAttachViewName);

        String UID = dataDoc.getItemValueString("idx_MainDocUNID")
          .toString();
        String unid = dataDoc.getUniversalID();
        if (UID.equals("")) {
          UID = "25F664E926B1E945482571Dwangshixi";
        }

        DocumentCollection dc = vwAttachment.getAllDocumentsByKey(UID);

        lotus.domino.Document docAttach = dc.getFirstDocument();
        dc.getCount();
        int intFileName = 0;
        while (docAttach != null) {
          if (docAttach.hasItem("$File")) {
            ++intFileName;
            String strFileName = docAttach
              .getItemValueString("FileName");
            String strName = docAttach.getItemValueString("$File");

            String strSaveName = intFileName + 
              strName.substring(strName.lastIndexOf("."), 
              strName.length());

            String lastPath = strFilePath + File.separatorChar + 
              strSaveName;

            showMSG(strName, "");

            makeDerectory(strFilePath);

            EmbeddedObject eo = docAttach.getAttachment(strName);
            eo.extractFile(lastPath);
            strResult = strResult + strSaveName + 
              strFileSeparator;
          }

          docAttach = dc.getNextDocument(docAttach);
        }
        if (strResult != "") {
          int x = strResult.length() - strFileSeparator.length();
          strResult = strResult.substring(0, x); 
          return strResult; 
          }
      }
      if (strKeyText.equalsIgnoreCase("ID"))
      {
        String tmpMainKey = intToString(
          getMainKeyID(this.initParam.getStrTable(), strRDBKeyItem));
        this.initParam.setStrMainkey(tmpMainKey);
        strResult = tmpMainKey;
      }

    }
    catch (Exception e)
    {
      logger.error(e);
    }

    return strResult;
  }

  private void createAttachToMaindoc(lotus.domino.Document maindoc, String strFilePath, String fileName)
  {
    Database db = null;
    lotus.domino.Document doc = null;
    String strFileName = "";
    String strQuery = "";

    try {
      strFileName = fileName;
      db = maindoc.getParentDatabase();
      String UID = maindoc.getItemValueString("idx_MainDocUNID");

      doc = db.createDocument();
      strQuery = "<file_unid>" + fileName.replace(".pdf", "") + 
        "</file_unid><file_name>" + strFileName + "</file_name>";
      doc.appendItemValue("Form", "frmIndiDocs");
      doc.appendItemValue("MainDocUnid", UID);
      doc.appendItemValue("FileUnid", fileName.replace(".pdf", ""));
      doc.appendItemValue("querystring", strQuery);
      doc.appendItemValue("FileName", strFileName);
      doc.appendItemValue("$PublicAccess", "1");

      RichTextItem body = doc.createRichTextItem("Body");
      body.addNewLine(2);
      strFilePath = strFilePath.replaceAll("/", "\\\\");
      String strSep = getPlatformSep(getServerPlatform());
      strFilePath = strFilePath.replaceAll("\\\\", strSep);
      showMSG("123456","");
      showMSG(strFilePath, "");

      body.embedObject(1454, null, 
        strFilePath, strFileName);

      doc.save(true);
    }
    catch (NotesException e)
    {
      logger.error(e); }
  }

  private String getServerPlatform() {
    Session session = this.initParam.getNSession();
    String strPlatform = "";
    try {
      strPlatform = session.getPlatform();
    }
    catch (NotesException e) {
      logger.error(e);
    }
    showMSG(strPlatform, "");

    return strPlatform; }

  private String getPlatformSep(String platform) {
    String strSep = "\\\\";
    if ((platform.equalsIgnoreCase("UNIX")) || (platform.equalsIgnoreCase("AIX/64"))) {
      strSep = "/";
    }
    return strSep;
  }

  private String getFileName(String strFilePath)
  {
    String strFileName = "";

    if (strFilePath.contains("\\")) {
      strFilePath = strFilePath.replaceAll("\\\\", "/");
    }

    String[] strArray = strFilePath.split("/");
    strFileName = strArray[(strArray.length - 1)];
    return strFileName;
  }

  private DocumentCollection getAttachDoc(lotus.domino.Document mainDoc) {
    DocumentCollection attachDocs = null;

    Database db = this.initParam.getNdbArchives();
    try
    {
      String strAttachViewName = this.initParam.getStrAttachView();
      showMSG(strAttachViewName,"");
      View vwAttachment = db.getView(strAttachViewName);
      String UID = mainDoc.getItemValueString("idx_MainDocUNID");
      showMSG(UID,"");
      if (UID.equals("")) {
        UID = "25F664E926B1E945482571Dwangshixi";
      }
    
      attachDocs = vwAttachment.getAllDocumentsByKey(UID);
     
    } catch (NullPointerException e) {
      logger.error(e);
    } catch (Exception e) {
      logger.error(e);
    }
    return attachDocs;
  }

  private Vector getAttachKeyMap(lotus.domino.Document docAttach, Vector VAttachKeyMap)
  {
    Vector VAttachKeyValueMap = new Vector();

    Vector tmpVKeyValue = null;
    Vector tmpVRDBKeyItems = new Vector();
    Vector tmpVKeyItem = null;

    String strAttachForeignKeyValue = this.initParam.getStrAttachForeignKeyValue();
    String strAttachForeignKey = this.initParam.getStrAttachForeignKey();
    String strAttachTableName = this.initParam.getStrAttTable();
    String strMappingPath = this.initParam.getStrRDBAttach();

    String strFilePath = this.initParam.getStrAttachFilePath();
    try
    {
      for (int i = 0; i < VAttachKeyMap.size(); ++i) {
        tmpVKeyValue = new Vector();
        tmpVKeyItem = (Vector)VAttachKeyMap.get(i);
        tmpVKeyValue.add(0, "44444");
        tmpVKeyValue.add(1, tmpVKeyItem.get(2));
        String strText = tmpVKeyItem.get(3).toString();

        if (strText.equalsIgnoreCase("$file")) {
          String filePath = "";
          filePath = getKeyValue(docAttach, strText, 
            strFilePath);

          strMappingPath = strMappingPath + getFileName(filePath);

          tmpVKeyValue.add(2, strMappingPath);

          tmpVKeyValue.add(3, tmpVKeyItem.get(4));
        } else if (strText.equalsIgnoreCase("fldyj")) {
          showMSG("fldyj ��û�д���", "");
        }
        else if (strText.equalsIgnoreCase(strAttachForeignKey)) {
          tmpVKeyValue.add(2, strAttachForeignKeyValue);
          tmpVKeyValue.add(3, tmpVKeyItem.get(4));
        }
        else
        {
          tmpVKeyValue = getItemValue(docAttach, tmpVKeyItem, strAttachTableName);
        }
        if (tmpVKeyValue == null)
          continue;
        tmpVRDBKeyItems.add(i, tmpVKeyValue);
      }
    }
    catch (Exception e) {
      logger.error(e);
    }

    VAttachKeyValueMap = tmpVRDBKeyItems;
    return VAttachKeyValueMap;
  }

  private String extractFile(lotus.domino.Document docAttach, String strFilePath)
  {
    String strResult = "";
    try {
      if ((docAttach != null) && 
        (docAttach.hasItem("$FILE"))) {
        String strFileName = docAttach
          .getItemValueString("FileName");
        String strName = docAttach.getItemValueString("$File");
        String strFileID = docAttach.getItemValueString("FileUnid");       
        String strSaveName = strFileID+strFileName.substring(strFileName.lastIndexOf("."),strFileName.length());
        
        //String strSaveName = strFileID + "-" + strFileName;
        String lastPath = strFilePath + File.separatorChar + 
          strSaveName;

        makeDerectory(strFilePath);

        if (fileExist(strFilePath)) {
          EmbeddedObject eo = docAttach.getAttachment(strName);
          eo.extractFile(lastPath);
        }
        strResult = lastPath;
      }
    }
    catch (Exception e) {
      logger.error(e);
    }

    return strResult;
  }

  public String makeSPYJToPDF(String strSPYJ, String strFilePath)
  {
    Session session = this.initParam.getNSession();
    String tmpStrFileName = "";
    try {
      if (!(strSPYJ.equals("")))
      {
        Rectangle rectPageSize = new Rectangle(PageSize.A4);

        com.lowagie.text.Document docPDF = new com.lowagie.text.Document(
          rectPageSize, 50.0F, 50.0F, 50.0F, 50.0F);
        try {
          Pattern patternCLR;
          tmpStrFileName = new Long(new java.util.Date().getTime()).toString() + 
            "�������_att.pdf";

          makeDerectory(strFilePath);
          String strFileName = strFilePath + File.separatorChar + 
            tmpStrFileName;
          PdfWriter.getInstance(docPDF, 
            new FileOutputStream(strFileName));
          docPDF.open();

          BaseFont bfChinese = BaseFont.createFont(
            "c:\\windows\\fonts\\STFANGSO.TTF", 
            "Identity-H", false);
          Font FontChinese = new Font(bfChinese, 12.0F, 0);

          String[] strSPcount = strSPYJ.split("<tr");
          int intSPnum = strSPcount.length / 2;
          int intTr = intSPnum * 3;
          Table table = new Table(6, intTr);
          table.setAutoFillEmptyCells(true);
          table.setBorderWidth(1.0F);
          table.setPadding(2.0F);
          table.setSpacing(0.0F);
          Cell cell = new Cell(new Paragraph("�������", FontChinese));
          cell.setHeader(true);
          cell.setBackgroundColor(new Color(192, 192, 192));
          cell.setColspan(6);
          cell.setHorizontalAlignment(1);
          table.addCell(cell);
          table.endHeaders();
          for (int intCell = 0; intCell < intSPnum; ++intCell) {
            Cell cellCLR = new Cell(
              new Paragraph("�����ˣ�", 
              FontChinese));
            cellCLR.setBackgroundColor(new Color(192, 192, 192));
            table.addCell(cellCLR, 1 + intCell * 3, 0);
            Cell cellCLTime = new Cell(
              new Paragraph("����ʱ�䣺", 
              FontChinese));
            cellCLTime.setBackgroundColor(
              new Color(192, 192, 
              192));
            table.addCell(cellCLTime, 1 + intCell * 3, 2);
            Cell cellCLZT = new Cell(
              new Paragraph("����״̬��", 
              FontChinese));
            cellCLZT
              .setBackgroundColor(new Color(192, 192, 192));
            table.addCell(cellCLZT, 1 + intCell * 3, 4);
            Cell cellCLYJ = new Cell(
              new Paragraph("�� ����", 
              FontChinese));
            cellCLYJ
              .setBackgroundColor(new Color(192, 192, 192));
            table.addCell(cellCLYJ, 2 + intCell * 3, 0);
            Cell cellCLSXPS = new Cell(
              new Paragraph("��д��ʾ��", 
              FontChinese));
            cellCLSXPS.setBackgroundColor(
              new Color(192, 192, 
              192));
            table.addCell(cellCLSXPS, 3 + intCell * 3, 0);
          }

          String strConcent = "";

          if (strSPYJ.indexOf("userName") == -1)
          {
            patternCLR = 
              Pattern.compile("�� �� ��</td><td(?:.|\\s)*?>(?:&nbsp;)*(.*?)<");
          }
          else {
            patternCLR = 
              Pattern.compile("<span class='userName'>([^<]*)</span>");
          }
          Matcher matcherCLR = patternCLR.matcher(strSPYJ);
          int intCell = 0;
          while (matcherCLR.find()) {
            strConcent = matcherCLR.group(1);
            Name name = session.createName(strConcent);
            strConcent = name.getCommon();
            Cell cellCLR2 = new Cell(
              new Paragraph(strConcent, 
              FontChinese));
            table.addCell(cellCLR2, 1 + intCell * 3, 1);
            ++intCell;
          }

          Pattern patternCLTime = 
            Pattern.compile("(\\d{2,4}-\\d{1,2}-\\d{1,2}\\s*\\d{1,2}:\\d{1,2}:\\d{1,2})");
          Matcher matcherCLTime = patternCLTime.matcher(strSPYJ);
          intCell = 0;
          while (matcherCLTime.find()) {
            strConcent = matcherCLTime.group(1);

            Cell cellCLTime2 = new Cell(
              new Paragraph(strConcent, 
              FontChinese));
            table.addCell(cellCLTime2, 1 + intCell * 3, 3);
            ++intCell;
          }

          Pattern patternCLZT = 
            Pattern.compile("����״̬</td><td(?:.|\\s)*?>(?:&nbsp;)*(.*?)<");
          Matcher matcherCLZT = patternCLZT.matcher(strSPYJ);
          intCell = 0;
          while (matcherCLZT.find())
          {
            strConcent = matcherCLZT.group(1);
            Cell cellCLZT2 = new Cell(
              new Paragraph(strConcent, 
              FontChinese));
            table.addCell(cellCLZT2, 1 + intCell * 3, 5);
            ++intCell;
          }

          Pattern patternYJ = 
            Pattern.compile("colsPan=5 class=yjContent>&nbsp;(([^<])*)<");

          Matcher matcherYJ = patternYJ.matcher(strSPYJ);
          intCell = 0;
          while (matcherYJ.find()) {
            strConcent = matcherYJ.group(1);
            Cell cellyjContent = new Cell(
              new Paragraph(strConcent, 
              FontChinese));
            cellyjContent.setColspan(5);
            table.addCell(cellyjContent, 2 + intCell * 3, 1);
            ++intCell;
          }

          Pattern patternYJImage = Pattern.compile("file/(.*?).jpg");
          Matcher matcherYJImage = patternYJImage.matcher(strSPYJ);
          while (matcherYJImage.find()) {
            String strExg = matcherYJImage.group(1) + "-(.*?).jpg";
            Pattern patternImageName = Pattern.compile(strExg);

            Matcher matcherImageName = patternImageName
              .matcher("value (");
            while (matcherImageName.find()) {
              String strImageName = matcherImageName.group();
              strImageName = strFilePath + File.separatorChar + 
                strImageName;
              Image img = Image.getInstance(strImageName);
              int intR = 0;
              String[] Strarray = (String[])null;
              Strarray = strImageName.split("_");
              String strR = Strarray[1];
              intR = Integer.parseInt(strR);
              Cell cellImage = new Cell(img);
              cellImage.setColspan(5);
              table.addCell(cellImage, 3 + intR * 3, 1);
            }
          }

          docPDF.add(table);
        } catch (DocumentException de) {
          logger.error(de.getMessage());
        } catch (IOException ioe) {
          logger.error(ioe.getMessage());
        }
        docPDF.close();
      }
      return tmpStrFileName;
    } catch (Exception e) {
      logger.error(e); }
    return "";
  }

  private void makeDerectory(String strFilePath)
  {
    try
    {
      File myFile = new File(strFilePath);
      if (!(myFile.isDirectory()))
        myFile.mkdirs();
    }
    catch (Exception e) {
      logger.error(e);
    }
  }

  private boolean fileExist(String strFilePath)
  {
    boolean blnFileExist = false;
    try {
      File myFile = new File(strFilePath);
      blnFileExist = myFile.exists();
    }
    catch (Exception e) {
      logger.error(e);
    }
    return blnFileExist;
  }

  public void delAllFile(String path)
  {
    File file = new File(path);
    if (!(file.exists())) {
      return;
    }
    if (!(file.isDirectory())) {
      return;
    }
    String[] tempList = file.list();
    File temp = null;
    for (int i = 0; i < tempList.length; ++i) {
      if (path.endsWith(File.separator))
        temp = new File(path + tempList[i]);
      else {
        temp = new File(path + File.separator + tempList[i]);
      }
      if (temp.isFile()) {
        temp.delete();
      }
      if (temp.isDirectory()) {
        delAllFile(path + "/" + tempList[i]);
        delFolder(path + "/" + tempList[i]);
      }
    }
  }

  public void delFolder(String folderPath)
  {
    try
    {
      delAllFile(folderPath);
      String filePath = folderPath;
      filePath = filePath.toString();
      File myFilePath = new File(filePath);
      myFilePath.delete();
    } catch (Exception e) {
      logger.info("ɾ���ļ��в�������");
      logger.error(e);
    }
  }

  private boolean findSpecialKey(String strKeyText)
  {
    Vector tmpVSpecialKey = null;
    boolean blnFindSKey = false;

    tmpVSpecialKey = this.initParam.getVSpecialField();
    for (int i = 0; i < tmpVSpecialKey.size(); ++i)
    {
      String tmpStrKeyText = tmpVSpecialKey.get(i).toString();
      if (strKeyText.equalsIgnoreCase(tmpStrKeyText)) {
        blnFindSKey = true;
        break;
      }
    }
    return blnFindSKey;
  }

  public String fnSPYJtoRDB(String stryj, String strValue, Session session)
  {
    String strV = "";
    try {
      if (!(stryj.equals("")))
      {
        Rectangle rectPageSize = new Rectangle(PageSize.A4);

        com.lowagie.text.Document docPDF = new com.lowagie.text.Document(
          rectPageSize, 50.0F, 50.0F, 50.0F, 50.0F);
        try {
          Pattern patternCLR;
          strV = new Long(new java.util.Date().getTime()).toString() + 
            "�������.pdf";

          File myFile = new File(this.strAttachFile);
          if (!(myFile.isDirectory())) {
            myFile.mkdirs();
          }
          String strFileName = this.strAttachFile + File.separatorChar + 
            strV;
          PdfWriter.getInstance(docPDF, 
            new FileOutputStream(strFileName));
          docPDF.open();

          BaseFont bfChinese = BaseFont.createFont(
            "c:\\windows\\fonts\\STFANGSO.TTF", 
            "Identity-H", false);
          Font FontChinese = new Font(bfChinese, 12.0F, 0);

          String[] strSPcount = stryj.split("<tr");
          int intSPnum = strSPcount.length / 2;
          int intTr = intSPnum * 3;
          Table table = new Table(6, intTr);
          table.setAutoFillEmptyCells(true);
          table.setBorderWidth(1.0F);
          table.setPadding(2.0F);
          table.setSpacing(0.0F);
          Cell cell = new Cell(new Paragraph("�������", FontChinese));
          cell.setHeader(true);
          cell.setBackgroundColor(new Color(192, 192, 192));
          cell.setColspan(6);
          cell.setHorizontalAlignment(1);
          table.addCell(cell);
          table.endHeaders();
          for (int intCell = 0; intCell < intSPnum; ++intCell) {
            Cell cellCLR = new Cell(
              new Paragraph("�����ˣ�", 
              FontChinese));
            cellCLR.setBackgroundColor(new Color(192, 192, 192));
            table.addCell(cellCLR, 1 + intCell * 3, 0);
            Cell cellCLTime = new Cell(
              new Paragraph("����ʱ�䣺", 
              FontChinese));
            cellCLTime.setBackgroundColor(
              new Color(192, 192, 
              192));
            table.addCell(cellCLTime, 1 + intCell * 3, 2);
            Cell cellCLZT = new Cell(
              new Paragraph("����״̬��", 
              FontChinese));
            cellCLZT
              .setBackgroundColor(new Color(192, 192, 192));
            table.addCell(cellCLZT, 1 + intCell * 3, 4);
            Cell cellCLYJ = new Cell(
              new Paragraph("�� ����", 
              FontChinese));
            cellCLYJ
              .setBackgroundColor(new Color(192, 192, 192));
            table.addCell(cellCLYJ, 2 + intCell * 3, 0);
            Cell cellCLSXPS = new Cell(
              new Paragraph("��д��ʾ��", 
              FontChinese));
            cellCLSXPS.setBackgroundColor(
              new Color(192, 192, 
              192));
            table.addCell(cellCLSXPS, 3 + intCell * 3, 0);
          }

          String strConcent = "";

          if (stryj.indexOf("userName") == -1)
          {
            patternCLR = 
              Pattern.compile("�� �� ��</td><td(?:.|\\s)*?>(?:&nbsp;)*(.*?)<");
          }
          else {
            patternCLR = 
              Pattern.compile("<span class='userName'>([^<]*)</span>");
          }
          Matcher matcherCLR = patternCLR.matcher(stryj);
          int intCell = 0;
          while (matcherCLR.find()) {
            strConcent = matcherCLR.group(1);
            Name name = session.createName(strConcent);
            strConcent = name.getCommon();
            Cell cellCLR2 = new Cell(
              new Paragraph(strConcent, 
              FontChinese));
            table.addCell(cellCLR2, 1 + intCell * 3, 1);
            ++intCell;
          }

          Pattern patternCLTime = 
            Pattern.compile("(\\d{2,4}-\\d{1,2}-\\d{1,2}\\s*\\d{1,2}:\\d{1,2}:\\d{1,2})");
          Matcher matcherCLTime = patternCLTime.matcher(stryj);
          intCell = 0;
          while (matcherCLTime.find()) {
            strConcent = matcherCLTime.group(1);

            Cell cellCLTime2 = new Cell(
              new Paragraph(strConcent, 
              FontChinese));
            table.addCell(cellCLTime2, 1 + intCell * 3, 3);
            ++intCell;
          }

          Pattern patternCLZT = 
            Pattern.compile("����״̬</td><td(?:.|\\s)*?>(?:&nbsp;)*(.*?)<");
          Matcher matcherCLZT = patternCLZT.matcher(stryj);
          intCell = 0;
          while (matcherCLZT.find())
          {
            strConcent = matcherCLZT.group(1);
            Cell cellCLZT2 = new Cell(
              new Paragraph(strConcent, 
              FontChinese));
            table.addCell(cellCLZT2, 1 + intCell * 3, 5);
            ++intCell;
          }

          Pattern patternYJ = 
            Pattern.compile("colsPan=5 class=yjContent>&nbsp;(([^<])*)<");

          Matcher matcherYJ = patternYJ.matcher(stryj);
          intCell = 0;
          while (matcherYJ.find()) {
            strConcent = matcherYJ.group(1);
            Cell cellyjContent = new Cell(
              new Paragraph(strConcent, 
              FontChinese));
            cellyjContent.setColspan(5);
            table.addCell(cellyjContent, 2 + intCell * 3, 1);
            ++intCell;
          }

          Pattern patternYJImage = Pattern.compile("file/(.*?).jpg");
          Matcher matcherYJImage = patternYJImage.matcher(stryj);
          while (matcherYJImage.find()) {
            String strExg = matcherYJImage.group(1) + "-(.*?).jpg";
            Pattern patternImageName = Pattern.compile(strExg);
            Matcher matcherImageName = patternImageName
              .matcher(strValue);
            while (matcherImageName.find()) {
              String strImageName = matcherImageName.group();
              strImageName = this.strAttachFile + File.separatorChar + 
                strImageName;
              Image img = Image.getInstance(strImageName);
              int intR = 0;
              String[] Strarray = (String[])null;
              Strarray = strImageName.split("_");
              String strR = Strarray[1];
              intR = Integer.parseInt(strR);
              Cell cellImage = new Cell(img);
              cellImage.setColspan(5);
              table.addCell(cellImage, 3 + intR * 3, 1);
            }
          }

          docPDF.add(table);
        } catch (DocumentException de) {
          logger.error(de.getMessage());
        } catch (IOException ioe) {
          logger.error(ioe.getMessage());
        }
        docPDF.close();
      }
      return strV;
    } catch (Exception e) {
      logger.error(e); }
    return "";
  }

  public boolean openDb()
  {
    try
    {
      Driver driver = (Driver)Class.forName(this.strRDBDriver).newInstance();

      Properties prop = new Properties();
      prop.put("user", this.strRDBUserName);
      prop.put("password", this.strRDBUserPwd);

      this.con = driver.connect(this.strRDBUrl, prop);

      if (this.con != null) {
        this.stmt = this.con.createStatement();
        if (this.stmt != null) {
          logger.info(getTime() + "���ӵ���ϵ���ݿ⣡");
          return true;
        }
        return false;
      }

      return false;
    }
    catch (ClassNotFoundException cnfe) {
      logger.error(getTime() + "������ȷ�������ݿ���������");
      return false;
    } catch (SQLException sqle) {
      logger.error(getTime() + "�޷����ӵ���ϵ���ݿ⣡");
      return false;
    } catch (Exception e) {
      logger.error(e);
      logger.error(getTime() + "���ص����ݿ���������ȷ��"); }
    return false;
  }

  public boolean openRelationDb()
  {
    try
    {
    	String url = this.initParam.getStrRDBURL();
    	String userName = this.initParam.getStrRDBUserName();
    	String password = this.initParam.getStrRDBUserPwd();
    	showMSG(userName,"");
    	showMSG(password,"");
    	showMSG(this.initParam.getStrRDBDriver(),"");
      Driver driver = (Driver)Class.forName(this.initParam.getStrRDBDriver()).newInstance();
      //System.out.println("���������ɹ�");
      Properties prop = new Properties();
      prop.put("user", this.initParam.getStrRDBUserName());
      prop.put("password", this.initParam.getStrRDBUserPwd());
      //System.out.println("��ʼ�������ݿ�");
      this.con = driver.connect(this.initParam.getStrRDBURL(), prop);
      //this.con =DriverManager.getConnection(url,userName,password); 
      //this.con = DriverManager.getConnection("jdbc:sqlserver://10.0.43.66:1433;databasename=hanneng","admin","password");
      //System.out.println("�������ݿ�ɹ�");
      if (this.con != null) {
        this.stmt = this.con.createStatement();
        if (this.stmt != null) {
          this.initParam.setConnect(this.con);
          this.initParam.setStmt(this.stmt);
          showMSG(getTime() + "���ӵ���ϵ���ݿ⣡", "");
          return true;
        }
        return false;
      }

      return false;
    }
    catch (ClassNotFoundException cnfe) {
    	cnfe.printStackTrace();
      showMSG(getTime() + "������ȷ�������ݿ���������", "");
      return false;
    } catch (SQLException sqle) {
    	sqle.printStackTrace();
      showMSG(getTime() + "�޷����ӵ���ϵ���ݿ⣡", "");
      logger.error(sqle);
      return false;
    } catch (Exception e) {
    	e.printStackTrace();
      logger.error(e);
      showMSG(getTime() + "���ص����ݿ���������ȷ��", ""); 
      }
    return false;
  }

  public String DealInsert(String strInsert, String strValue)
  {
    try
    {
      String strnewValue = "";
      int intyj = -1;
      int intattch = -1;

      String strIn = "INSERT INTO " + this.strTable + "(";
      String[] insert = (String[])null;
      String strnewInsert = strInsert.toLowerCase().replace("fldyj,", "");

      if (this.strAttachInNewTable.equals("1")) {
        strnewInsert = strnewInsert.replace(
          this.strRDBattachFiled.toLowerCase() + 
          ",", "");
      }

      strnewValue = "";
      strInsert = strInsert.replace(strIn, "");
      insert = strInsert.toLowerCase().split(",");

      for (int i = 0; i < insert.length; ++i) {
        if (insert[i].equals("fldyj")) {
          intyj = i;
        }
        if (insert[i].equals(this.strRDBattachFiled.toLowerCase())) {
          intattch = i;
        }
      }
      String strVa = "VALUES (";
      String strvaluecopy = strValue;
      strvaluecopy = strvaluecopy.replace(strVa, "");
      String[] value = strvaluecopy.split(",");
      String valuefldyj = "";
      String valueattach = "";
      if (intyj > -1) {
        valuefldyj = value[intyj];
      }
      String valueyj = valuefldyj.replace("'", "");
      if (intattch > -1) {
        valueattach = value[intattch];
      }
      String valueatt = valueattach.replace("'", "");

      String strnewattach = valueatt;
      if (valueatt.equals("")) {
        if (!(valueyj.equals("")))
          strnewattach = this.strRDBAttach + valueyj;
      }
      else
      {
        valueatt = valueatt.replace(this.strRDBAttach, "");
        String[] arrAttachFile = valueatt.split(";");
        String strTmpAttch = "";
        for (int i = 0; i < arrAttachFile.length; ++i) {
          if (arrAttachFile[i].indexOf("_Attitude.jpg") == -1) {
            if (strTmpAttch.equals(""))
              strTmpAttch = this.strRDBAttach + arrAttachFile[i];
            else {
              strTmpAttch = strTmpAttch + ";" + arrAttachFile[i];
            }
          }
        }
        if (!(valueyj.equals("")))
          strnewattach = strTmpAttch + ";" + valueyj;
        else {
          strnewattach = strTmpAttch;
        }
      }

      if (!(strnewattach.equals("")))
      {
        value[intattch] = "'" + strnewattach + "'";
      }

      for (int i = 0; i < value.length; ++i)
      {
        if (this.strAttachInNewTable.equals("1"))
        {
          if ((i != intyj) && (i != intattch)) {
            if (strnewValue.equals(""))
              strnewValue = value[i];
            else {
              strnewValue = strnewValue + "," + value[i];
            }
          }
        }
        else if (i != intyj) {
          if (strnewValue.equals(""))
            strnewValue = value[i];
          else {
            strnewValue = strnewValue + "," + value[i];
          }
        }

      }

      if (this.strAttachInNewTable.equals("1")) {
        this.strAllAttach = strnewattach;

        String strselect = "select top 1 * from " + this.strTable + 
          " order by " + this.strMainkey + " desc";
        if (this.strRDBType.equalsIgnoreCase("oracle"))
        {
          strselect = "select * from (select * from " + this.strTable + 
            " order by " + this.strMainkey + 
            " desc) where rownum<2";
        }
        if (this.strRDBType.equalsIgnoreCase("mysql")) {
          strselect = "select * from " + this.initParam.getStrRDBName() + 
            "." + this.strTable + " order by " + this.strMainkey + 
            " desc limit 0,1";
        }

        try
        {
          logger.info("��ѯ��䣺" + strselect);
          query(strselect);
          if (this.rs.next())
            this.intNum = this.rs.getInt(this.strMainkey);
          this.intNum += 1;
        } catch (Exception e) {
          logger.error(e);
        }
        strnewInsert = strnewInsert + "," + this.strMainkey + "," + 
          this.strAttkey;
        strnewValue = strnewValue + ",'" + this.intNum + "'" + ",'" + this.intNum + 
          "'";
      }

      if (strnewValue.indexOf("1wangsxSig1") != -1) {
        strnewValue = strnewValue.replace("1wangsxSig1", ",");
      }
      String strsql = strnewInsert + ")VALUES (" + strnewValue + ")";
      logger.info("strsql : " + strsql);
      return strsql;
    } catch (Exception e) {
      logger.error(e); }
    return "";
  }

  public void update(String strSql)
    throws Exception
  {
    if (strSql != "")
      this.stmt.executeUpdate(strSql);
  }

  public void query(String strSql) throws Exception
  {
    showMSG(strSql, "");
    if (strSql != "")
      this.rs = this.stmt.executeQuery(strSql);
  }

  public void closeDb()
  {
    try {
      this.stmt.close();
      this.con.close();
    } catch (Exception e) {
      logger.error(e);
    }
  }

  public void run()
  {
    try
    {
      mainTheard();
      Thread.sleep(60000 * InitParameter.getRecycleTime());
    }
    catch (Exception e)
    {
      logger.error(e);
    }
  }

  public static String getTime()
  {
    SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
    java.util.Date now = new java.util.Date();
    String strTime = sdf.format(now);
    return new String("[" + strTime + "]");
  }

  private void showMSG(String strMSGContent, String strMsgType) {
    if ((strMSGContent != null) && (!(strMSGContent.equalsIgnoreCase("hidden"))))
      logger.info(strMSGContent);
  }

  private void analyseNDoc()
  {
    lotus.domino.Document docBaseSet = this.initParam.getDocBaseSet();
    String[] arrSepecialField = { "$file", "fldyj", "ID" };

    String seperator = ";$";
    try
    {
      if (docBaseSet == null)
        return;
      String strCurrentServer = docBaseSet.getItemValueString("fldDomServerName");
      if (strCurrentServer == null) {
        strCurrentServer = "";
      }
      this.initParam.setStrCurrentServerName(strCurrentServer);

      this.initParam.setStrDataDBPath(
        docBaseSet.getItemValueString("fldDomDBName"));
      this.initParam.setStrDataView(
        docBaseSet.getItemValueString("fldView"));
      this.initParam
        .setStrTable(docBaseSet.getItemValueString("fldTable"));
      this.initParam.setStrIds(
        docBaseSet.getItemValueString("fldFieldIds"));
      this.initParam.setStrDelorMor(
        docBaseSet.getItemValueString("fldDelorMov"));
      this.initParam.setStrAttachFilePath(
        docBaseSet.getItemValueString("fldAttachFile"));
      this.initParam.setStrAttachView(
        docBaseSet.getItemValueString("fldAttView"));
      this.initParam.setStrRDBAttach(
        docBaseSet.getItemValueString("fldRDBAttach"));
      int intExportAttitude = stringToInt(
        docBaseSet.getItemValueString("IsyjOut"));
      this.initParam.setIntExportAttitude(intExportAttitude);

      this.initParam.setStrAttachInNewTable(
        docBaseSet.getItemValueString("fldAttachInNewTable"));
      this.initParam.setStrAttTable(
        docBaseSet.getItemValueString("fldAttTable"));
      this.initParam.setStrMainkey(
        docBaseSet.getItemValueString("fldMainkey"));

      this.initParam.setStrAttachForeignKey(
        docBaseSet.getItemValueString("fldAttkey"));
      this.initParam.setStrAttachFieldIds(
        docBaseSet.getItemValueString("fldAttachFieldIds"));

      this.initParam.addVSpecialField(arrSepecialField[0]);
      this.initParam.addVSpecialField(arrSepecialField[2]);
      if (intExportAttitude == 1) {
        this.initParam.addVSpecialField(arrSepecialField[1]);
      }
      String tmpSeperator = docBaseSet.getItemValueString("fileSplit");
      if (tmpSeperator != null)
        seperator = tmpSeperator;
      this.initParam.setStrSepretor(seperator);
    }
    catch (Exception e)
    {
      logger.error(e);
    }
  }

  private void setKeyMap(Database NDBConfig)
  {
    String regex = ",";
    String strIds = this.initParam.getStrIds();
    String[] Ids = strIds.split(regex);
    String strAttachIds = this.initParam.getStrAttachFieldIds();
    try
    {
      Vector vFieldToField;
      View vwFieldtoF;
      int i = 0;
      lotus.domino.Document docFieldtoF;

      for (i = 0; i < Ids.length; ++i) {
        vwFieldtoF = NDBConfig.getView("vwFieldtoF");
        docFieldtoF = vwFieldtoF.getDocumentByKey(Ids[i]);
        vFieldToField = setKeyValue(docFieldtoF);
        this.initParam.addVKeyFieldMap(vFieldToField);
      }
      if ((!(this.initParam.getStrAttachInNewTable().equalsIgnoreCase("1"))) || 
        (strAttachIds.equalsIgnoreCase(""))) return;
      String[] AttachIds = strAttachIds.split(regex);
      for (i = 0; i < AttachIds.length; ++i) {
        vwFieldtoF = NDBConfig.getView("vwFieldtoF");
        docFieldtoF = vwFieldtoF
          .getDocumentByKey(AttachIds[i]);
        vFieldToField = setKeyValue(docFieldtoF);
        this.initParam.addVAttachFieldMap(vFieldToField);
      }
    }
    catch (Exception e)
    {
      logger.error(e);
    }
  }

  private Vector dealDocYJ(lotus.domino.Document NDataDoc, Vector vAttachKeyMap)
  {
    Vector tmpVKeyItem = new Vector();
    int i = 0;
    int vSize = vAttachKeyMap.size();
    String strKeyText = "fldyj";
    String strFilePath = this.initParam.getStrAttachFilePath();
    String tmpFilePath = strFilePath + File.separator + "tmpFile";
    for (i = 0; i < vSize; ++i) {
      tmpVKeyItem = (Vector)vAttachKeyMap.get(i);
      strKeyText = tmpVKeyItem.get(3).toString();

      if (strKeyText.equalsIgnoreCase("fldYj")) {
        vAttachKeyMap.remove(i);
        break;
      }
    }

    if (i <= vSize)
    {
      Vector vFldYJ = getKeyValue(NDataDoc, "fldYj");
      String strFldV = "";

      if (vFldYJ.size() > 0) {
        for (int j = 0; j < vFldYJ.size(); ++j) {
          strFldV = strFldV + vFldYJ.elementAt(j).toString();
        }
        delAllFile(tmpFilePath);

        strFldV = makeSPYJToPDF(strFldV, tmpFilePath);

        for (int intSleep = 0; intSleep < 2; ++intSleep) {
          if ((fileExist(tmpFilePath + File.separatorChar + strFldV)) && 
            (!(strFldV.equalsIgnoreCase(""))))
          {
            createAttachToMaindoc(NDataDoc, tmpFilePath + 
              File.separatorChar + strFldV, strFldV);
            return vAttachKeyMap;
          }
          try
          {
            Thread.sleep(500L);
          }
          catch (InterruptedException e) {
            logger.error(e);
          }
        }
      } else {
        showMSG("fldyj Ϊ�գ�", "");
      }
    }
    return vAttachKeyMap;
  }

  public int stringToInt(String intstr)
  {
    int i = 0;
    try
    {
      Integer integer = Integer.valueOf(intstr);
      i = integer.intValue();
    } catch (Exception e) {
      logger.error(e);
    }
    return i;
  }

  public String intToString(int value)
  {
    Integer integer = new Integer(value);
    return integer.toString();
  }

  public float stringToFloat(String floatstr)
  {
    Float floatee = Float.valueOf(floatstr);
    return floatee.floatValue();
  }

  public String floatToString(float value)
  {
    Float floatee = new Float(value);
    return floatee.toString();
  }

  public java.sql.Date stringToDate(String dateStr)
  {
    return java.sql.Date.valueOf(dateStr);
  }

  public String dateToString(java.sql.Date datee)
  {
    return datee.toString();
  }

  public String getGuid() {
    UUID uuid = UUID.randomUUID();
    return uuid.toString();
  }
}