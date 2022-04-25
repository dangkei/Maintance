package ftp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;
import lotus.domino.Database;
import lotus.domino.Document;
import lotus.domino.Session;

class InitParameter
{
  private String strRDBIP;
  private String strRDBPort;
  private String strRDBType;
  private String strRDBDriver;
  private String strRDBName;
  private String strRDBUserName;
  private String strRDBUserPwd;
  private String strRDBURL;
  private String strNotesServer;
  private String strNotesUserName;
  private String strNotesPSW;
  private String strNotesApp;
  private String strNotesConfigDBName;
  private String strCurrentServerName;
  private String strDataDBPath;
  private String strDataView;
  private Document docBaseSet;
  private String strTable;
  private String strIds;
  private String strDelorMor;
  private String strAttachFilePath;
  private String strRDBAttach;
  private String strAttachView;
  private Vector VKeyFieldMap = new Vector();

  private Vector vSpecialField = new Vector();
  private int intExportAttitude;
  private Vector vAttachFieldMap = new Vector();
  private String strAttachFieldIds;
  private String strAttachInNewTable;
  private String strAttTable;
  private String strMainkey;
  private String strPrimaryKeyValue;
  private String strAttachForeignKey;
  private String strAttachForeignKeyValue;
  private String strAttkey;
  private String strAttNo;
  private String strAttFileName;
  private String strAttFileNameAll;
  private String strAttEXT;
  private String strAttPZM;
  private String strAttPath;
  private String strFieldIdsAtt;
  private String strAllAttach;
  private String TDocType;
  private int intNum = 0;
  private String strSepretor;
  private Connection connect;
  private Statement stmt;
  private ResultSet rs;
  private String strRDBattachFiled;
  private String strFilePathLocal;
  private String strFilePathFtp;
  private String strFtpIP;
  private String strFtpUser;
  private String strFtpPwd;
  private int strFtpPort;
  private Database NdbConfig = null;

  private Database NdbArchives = null;

  private Session NSession = null;

  private static int recycleTime = 10;

  public Document getDocBaseSet()
  {
    return this.docBaseSet;
  }

  public void setDocBaseSet(Document docBaseSet) {
    this.docBaseSet = docBaseSet;
  }

  public int getIntNum() {
    return this.intNum;
  }

  public void setIntNum(int intNum) {
    this.intNum = intNum;
  }

  public String getStrAllAttach() {
    return this.strAllAttach;
  }

  public void setStrAllAttach(String strAllAttach) {
    this.strAllAttach = strAllAttach;
  }

  public String getStrAttachFilePath()
  {
    return this.strAttachFilePath;
  }

  public void setStrAttachFilePath(String strAttachFile) {
    this.strAttachFilePath = strAttachFile;
  }

  public String getStrAttachInNewTable() {
    return this.strAttachInNewTable;
  }

  public void setStrAttachInNewTable(String strAttachInNewTable) {
    this.strAttachInNewTable = strAttachInNewTable;
  }

  public String getStrAttachView() {
    return this.strAttachView;
  }

  public void setStrAttachView(String strAttachView) {
    this.strAttachView = strAttachView;
  }

  public String getStrAttEXT() {
    return this.strAttEXT;
  }

  public void setStrAttEXT(String strAttEXT) {
    this.strAttEXT = strAttEXT;
  }

  public String getStrAttFileName() {
    return this.strAttFileName;
  }

  public void setStrAttFileName(String strAttFileName) {
    this.strAttFileName = strAttFileName;
  }

  public String getStrAttFileNameAll() {
    return this.strAttFileNameAll;
  }

  public void setStrAttFileNameAll(String strAttFileNameAll) {
    this.strAttFileNameAll = strAttFileNameAll;
  }

  public String getStrAttkey() {
    return this.strAttkey;
  }

  public void setStrAttkey(String strAttkey) {
    this.strAttkey = strAttkey;
  }

  public String getStrAttNo() {
    return this.strAttNo;
  }

  public void setStrAttNo(String strAttNo) {
    this.strAttNo = strAttNo;
  }

  public String getStrAttPath() {
    return this.strAttPath;
  }

  public void setStrAttPath(String strAttPath) {
    this.strAttPath = strAttPath;
  }

  public String getStrAttPZM() {
    return this.strAttPZM;
  }

  public void setStrAttPZM(String strAttPZM) {
    this.strAttPZM = strAttPZM;
  }

  public String getStrAttTable() {
    return this.strAttTable;
  }

  public void setStrAttTable(String strAttTable) {
    this.strAttTable = strAttTable;
  }

  public String getStrDataDBPath() {
    return this.strDataDBPath;
  }

  public void setStrDataDBPath(String strDataDBPath) {
    this.strDataDBPath = strDataDBPath;
  }

  public String getStrDelorMor() {
    return this.strDelorMor;
  }

  public void setStrDelorMor(String strDelorMor) {
    this.strDelorMor = strDelorMor;
  }

  public String getStrFieldIdsAtt() {
    return this.strFieldIdsAtt;
  }

  public void setStrFieldIdsAtt(String strFieldIdsAtt) {
    this.strFieldIdsAtt = strFieldIdsAtt;
  }

  public String getStrIds() {
    return this.strIds;
  }

  public void setStrIds(String strIds) {
    this.strIds = strIds;
  }

  public String getStrMainkey() {
    return this.strMainkey;
  }

  public void setStrMainkey(String strMainkey) {
    this.strMainkey = strMainkey;
  }

  public String getStrNotesServer() {
    return this.strNotesServer;
  }

  public void setStrNotesServer(String strNotesServer) {
    this.strNotesServer = strNotesServer;
  }

  public String getStrRDBAttach()
  {
    return this.strRDBAttach;
  }

  public void setStrRDBAttach(String strRDBAttach)
  {
    this.strRDBAttach = strRDBAttach;
  }

  public String getStrRDBattachFiled() {
    return this.strRDBattachFiled;
  }

  public void setStrRDBattachFiled(String strRDBattachFiled) {
    this.strRDBattachFiled = strRDBattachFiled;
  }

  public String getStrRDBDriver() {
    return this.strRDBDriver;
  }

  public void setStrRDBDriver(String strRDBDriver) {
    this.strRDBDriver = strRDBDriver;
  }

  public String getStrRDBIP() {
    return this.strRDBIP;
  }

  public void setStrRDBIP(String strRDBIP) {
    this.strRDBIP = strRDBIP;
  }

  public String getStrRDBName() {
    return this.strRDBName;
  }

  public void setStrRDBName(String strRDBName) {
    this.strRDBName = strRDBName;
  }

  public String getStrRDBPort() {
    return this.strRDBPort;
  }

  public void setStrRDBPort(String strRDBPort) {
    this.strRDBPort = strRDBPort;
  }

  public String getStrRDBType() {
    return this.strRDBType;
  }

  public void setStrRDBType(String strRDBType) {
    this.strRDBType = strRDBType;
  }

  public String getStrRDBUserName() {
    return this.strRDBUserName;
  }

  public void setStrRDBUserName(String strRDBUserName) {
    this.strRDBUserName = strRDBUserName;
  }

  public String getStrRDBUserPwd() {
    return this.strRDBUserPwd;
  }

  public void setStrRDBUserPwd(String strRDBUserPwd) {
    this.strRDBUserPwd = strRDBUserPwd;
  }

  public String getStrTable() {
    return this.strTable;
  }

  public void setStrTable(String strTable) {
    this.strTable = strTable;
  }

  public String getStrDataView() {
    return this.strDataView;
  }

  public void setStrDataView(String strView) {
    this.strDataView = strView;
  }

  public String getTDocType() {
    return this.TDocType;
  }

  public void setTDocType(String docType) {
    this.TDocType = docType;
  }

  public String getStrNotesApp() {
    return this.strNotesApp;
  }

  public void setStrNotesApp(String strNotesApp) {
    this.strNotesApp = strNotesApp;
  }

  public String getStrNotesConfigDBName() {
    return this.strNotesConfigDBName;
  }

  public void setStrNotesConfigDBName(String strNotesConfigDBName) {
    this.strNotesConfigDBName = strNotesConfigDBName;
  }

  public String getStrNotesPSW() {
    return this.strNotesPSW;
  }

  public void setStrNotesPSW(String strNotesPSW) {
    this.strNotesPSW = strNotesPSW;
  }

  public String getStrNotesUserName() {
    return this.strNotesUserName;
  }

  public void setStrNotesUserName(String strNotesUserName) {
    this.strNotesUserName = strNotesUserName;
  }

  public Session getNSession() {
    return this.NSession;
  }

  public void setNSession(Session session) {
    this.NSession = session;
  }

  public Database getNdbArchives() {
    return this.NdbArchives;
  }

  public void setNdbArchives(Database ndbArchives) {
    this.NdbArchives = ndbArchives;
  }

  public Database getNdbConfig() {
    return this.NdbConfig;
  }

  public void setNdbConfig(Database ndbConfig) {
    this.NdbConfig = ndbConfig;
  }

  public String getStrRDBURL() {
    return this.strRDBURL;
  }

  public ResultSet getRs() {
    return this.rs;
  }

  public void setRs(ResultSet rs) {
    this.rs = rs;
  }

  public Statement getStmt() {
    return this.stmt;
  }

  public void setStmt(Statement stmt) {
    this.stmt = stmt;
  }

  public void setStrRDBURL(String strRDBURL) {
    this.strRDBURL = strRDBURL;
  }

  public Connection getConnect() {
    return this.connect;
  }

  public void setConnect(Connection connect) {
    this.connect = connect;
  }

  public Vector getVKeyFieldMap() {
    return this.VKeyFieldMap;
  }

  public void addVKeyFieldMap(Vector keyFieldMap) {
    this.VKeyFieldMap.add(keyFieldMap);
  }

  public void removeVKeyFieldMap()
  {
    this.VKeyFieldMap.clear();
  }

  public Vector getVSpecialField() {
    return this.vSpecialField;
  }

  public void addVSpecialField(String specialField) {
    this.vSpecialField.add(specialField); }

  public void removeVSpecialField() {
    this.vSpecialField.clear(); }

  public String getStrSepretor() {
    return this.strSepretor;
  }

  public void setStrSepretor(String strSepretor) {
    this.strSepretor = strSepretor;
  }

  public void setVKeyFieldMap(Vector keyFieldMap) {
    this.VKeyFieldMap = keyFieldMap;
  }

  public Vector getVAttachFieldMap() {
    return this.vAttachFieldMap;
  }

  public void addVAttachFieldMap(Vector attachFieldMap) {
    this.vAttachFieldMap.add(attachFieldMap); }

  public void removeAttachFieldMap() {
    this.vAttachFieldMap.clear(); }

  public String getStrAttachFieldIds() {
    return this.strAttachFieldIds;
  }

  public void setStrAttachFieldIds(String strAttachFieldIds) {
    this.strAttachFieldIds = strAttachFieldIds;
  }

  public static int getRecycleTime() {
    return recycleTime; }

  public static void setRecycleTime(int recycleTime) {
    recycleTime = recycleTime;
  }

  public int getIntExportAttitude() {
    return this.intExportAttitude;
  }

  public void setIntExportAttitude(int intExportAttitude) {
    this.intExportAttitude = intExportAttitude;
  }

  public String getStrPrimaryKeyValue() {
    return this.strPrimaryKeyValue;
  }

  public void setStrPrimaryKeyValue(String strPrimaryKeyValue) {
    this.strPrimaryKeyValue = strPrimaryKeyValue;
  }

  public String getStrAttachForeignKey() {
    return this.strAttachForeignKey;
  }

  public void setStrAttachForeignKey(String strAttachForeignKey) {
    this.strAttachForeignKey = strAttachForeignKey;
  }

  public String getStrAttachForeignKeyValue() {
    return this.strAttachForeignKeyValue;
  }

  public void setStrAttachForeignKeyValue(String strAttachForeignKeyValue) {
    this.strAttachForeignKeyValue = strAttachForeignKeyValue;
  }

  public String getStrCurrentServerName() {
    return this.strCurrentServerName;
  }

  public void setStrCurrentServerName(String strCurrentServerName) {
    this.strCurrentServerName = strCurrentServerName;
  }
  
  public String getStrFilePathLocal(){
	  return this.strFilePathLocal;
  }
  
  public void setStrFilePathLocal(String strFilePathLocal){
	  this.strFilePathLocal = strFilePathLocal;
  }
  
  public String getStrFilePathFtp(){
	  return this.strFilePathFtp;
  }
  
  public void setStrFilePathFtp(String strFilePathFtp){
	  this.strFilePathFtp = strFilePathFtp;
  }
  
  public String getStrFtpIP(){
	  return this.strFtpIP;
  }
  
  public void setStrFtpIP(String strFtpIP){
	  this.strFtpIP = strFtpIP;
  }
  
  public String getStrFtpUser(){
	  return this.strFtpUser;
  }
  
  public void setStrFtpUser(String strFtpUser){
	  this.strFtpUser = strFtpUser;
  }
  
  public String getStrFtpPwd(){
	  return this.strFtpPwd;
  }
  
  public void setStrFtpPwd(String strFtpPwd){
	  this.strFtpPwd = strFtpPwd;
  }
  
  public int getStrFtpPort(){
	  return this.strFtpPort;
  }
  
  public void setStrFtpPort(int strFtpPort){
	  this.strFtpPort = strFtpPort;
  }
  
}