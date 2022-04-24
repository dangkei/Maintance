package ftp;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class ArchivesMain
{
  static Logger logger = Logger.getLogger(ArchivesMain.class.getName());

  public static void main(String[] args)
  {
	try
    {
      PropertyConfigurator.configure("log.properties");
      SynchronizeArchives sa = new SynchronizeArchives();

      logger.info(getTime() + "����������������ͬ���̣߳�");
      sa.start();

      logger.info(getTime() + "�߳�������ϡ�");
    } catch (Exception e) {
      logger.error(e);
    }
  }

  public static String getTime()
  {
    SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
    Date now = new Date();
    String strTime = sdf.format(now);
    return new String("[" + strTime + "]");
  }
}