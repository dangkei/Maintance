package ftp;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class testFileName
{
  static Logger logger = Logger.getLogger(testFileName.class.getName());

  public static void main(String[] args) { PropertyConfigurator.configure("log.properties");
    int intFileName = 1;
    String strName = "test.docx";
    String strSaveName = intFileName + strName.substring(strName.lastIndexOf("."), strName.length());
    logger.info(strSaveName);
  }
}