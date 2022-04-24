package ftp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.log4j.Logger;

import sun.net.TelnetOutputStream;
import sun.net.TelnetInputStream;
import sun.net.ftp.FtpClient;
import sun.net.ftp.FtpProtocolException;

public class UploadFile {

	/** ��ָ��Ŀ¼�µ��ļ��ϴ���FTP��������ɾ�� update by heyu 120319
	 * �ϴ�������
	 * @param srcPath Դ	 ��g��/test/
	 * @param destPath Ŀ��  ��test��Ŀ¼��
	 * @param ip ip��ַ
	 * @param user �û���
	 * @param pass ����
	 * @param port �˿�
	 */
	static Logger logger = Logger
			.getLogger(UploadFile.class.getName());
	public static  void runUpload(String srcPath,String destPath,
			String ip,String user,String pass,int port) throws FtpProtocolException{
		  creatMkdir(srcPath);
		//��ȡ�ļ����� lmn
		String names[]=getAllFileNames(srcPath);
		FtpClient ftpClient = null;
         
		try {
			//�����ļ�
			ftpClient = getFtpClient(ip, port, user, pass);
			System.out.print("��ȡftpȨ�޳ɹ���");
			//System.out.print(destPath+"\n");
			//showMSG("����ftp·�����ڱ�����ɵ��ַ������������","");
			destPath=new String(destPath.getBytes(),"GBK");
			creatMkdir(destPath);
			//ftpClient.cd(destPath);
		
			for(String name:names){
				File file = new File(srcPath+name);
				System.out.println("�������ļ��ɹ���");
				//������ļ����ϴ�
				//if(file.isFile()){
					boolean isSuccess1 = upload(ftpClient, name, srcPath);					
					if(!isSuccess1){
						System.out.println( name + "�ϴ�ʧ��:\n");
						System.out.println("Address:" + ip + ":" + port);
						System.out.println("Name:" + user+"\n");
					}
					else
					{
						
						//�ϴ��ɹ� ɾ���ļ�
						deleteFile(srcPath+name);
					}
				//}
				if(file.isDirectory()){
					//�ж������ļ��Ľ��д���
					String names2[]=getAllFileNames(srcPath+name);
					//ftpClient.cd(srcPath+name);
					System.out.println("�����ļ����д���");
					System.out.println(srcPath+name);
					for (String name2:names2){
						File file2 = new File(srcPath+name+ System.getProperty("file.separator")+name2);
						System.out.println(srcPath+name+ System.getProperty("file.separator")+name2);
						//������ļ����ϴ�
						if(file2.isFile()){
							// lmn
							//System.out.print("��ʼ�ϴ��ļ�");
							boolean isSuccess = upload(ftpClient, name, srcPath+name+ System.getProperty("file.separator")+name2);
							if(!isSuccess){
								System.out.println(name + "�ϴ�ʧ��:\\n");
								System.out.println("Address:" + ip + ":" + port);
								System.out.println("Name:" + user+"\\"+"n");
							}
							else
							{
								//�ϴ��ɹ� ɾ���ļ�
								deleteFile(srcPath+name+ System.getProperty("file.separator")+name2);
							}
					}
				 }
				}
					else{
				
					//�ϴ��ɹ� ɾ���ļ�
					deleteFile(srcPath+name);
				}
				
			}
		} catch (IOException e) {
			e.printStackTrace();
			logger.error(e);
		}
	}
	/**  
	 * ɾ�������ļ�  
	 * @param   sPath    ��ɾ���ļ����ļ���  
	 * @return �����ļ�ɾ���ɹ�����true�����򷵻�false  
	 */  
	public static void deleteFile(String sPath) {   
	    File file = new File(sPath);   
	    // ·��Ϊ�ļ��Ҳ�Ϊ�������ɾ��   
	    if (file.isFile() && file.exists()) { 
	    	//System.out.println(file.getName());
	       file.delete();   
	    }   
	}  
	/**
	 * �ϴ��ļ�
	 * @param ftp
	 * @param fileName Ҫ���ص��ļ���
	 * @param localFolder ����Ŀ¼
	 * @return ���سɹ����� true
	 * */
	public  static boolean upload(FtpClient ftp, String fileName, String localFolder) {

		String fp=localFolder  + fileName;
		fp=fp.replace("\\", "/");
		fp=fp.replace("//", "/");
		System.out.println(fileName);
		File inFile = new File(fp);
		
		OutputStream tos = null;

		FileInputStream fis = null;

		boolean flag = false;

		byte[] buf = new byte[204800];

		int c = 0;
    
		try {
//			tos = ftp.put(new String(fileName.getBytes("utf-8"),"gbk"));
			
				//tos = ftp.put(fileName);
			
			//System.out.println();
			fis = new FileInputStream(inFile);

			while ((c = fis.read(buf)) != -1) {
				tos.write(buf, 0, c);
			}

			tos.flush();
			
			flag = true;
			
			//System.out.println(fileName+"--------�ϴ��ɹ�!");
			showMSG(fileName+"--------�ϴ��ɹ�!","");
		} catch (FileNotFoundException e) {
			//System.out.println("FileName:" + fileName + " not found!");
			showMSG("FileName:" + fileName + " not found!","");
			logger.error(e);
		} catch (IOException e) {
			//System.out.println("FileName:" + fileName + " has IOException: "+e.getMessage());
			showMSG("FileName:" + fileName + " has IOException: "+e.getMessage(),"");
			logger.error(e);
		} finally {
			if (tos != null) {
				try {
					tos.close();
				} catch (IOException e) {
					//System.out.println("FileName:" + fileName + " has IOException: "+e.getMessage());\
					showMSG("FileName:" + fileName + " has IOException: "+e.getMessage(),"");
					logger.error(e);
				}
				tos = null;
			}
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					System.out.println("FileName:" + fileName + " has IOException: "+e.getMessage());
					logger.error(e);
				}
				fis = null;
			}
		}
		return flag;
	}
	/**
	 * ���FTP�ͻ���
	 * @param ip FTP��ַ
	 * @param port FTP�˿�
	 * @param user �û���
	 * @param password ����
	 * @return
	 * @throws IOException
	 * @throws FtpProtocolException 
	 */
	public  static FtpClient getFtpClient(String ip,int port, String user, String password) throws IOException, FtpProtocolException {
        System.out.println(">>"+ip+"<<");
        System.out.println(port);
        System.out.println(user);
        System.out.println(password);
		//FtpClient ftp = new FtpClient();
      //  FtpClient ftp = FtpClient.create(ip);
		//ftp.openServer(ip, port);
        System.out.println("�ڵ�1");
        
		//ftp.login(user,null, password);
		
		//System.out.println("�ڵ�2");
		
		//ftp.setBinaryType();
		
		
		//FtpClient ftp = new FtpClient();

		//ftp.openServer(ip, port);

		//ftp.login(user, password);

		//ftp.binary();
		
		System.out.println("��¼FTP�ɹ���");
		//return ftp;
		return null;
	}
	/**
	 * 
	 * getAllFileNames:��ȡ�ļ����±������ļ�������
	 *
	 * @param  @param path
	 * @param  @return    
	 * @return String[]    
	 * @throws 
	 * @since  CodingExample��Ver 1.1
	 */
	public static String[] getAllFileNames(String path){
		
		File file=new File(path);
		File files[]=file.listFiles();
		
		String names[]=new String[files.length];
		int i=0;
		for(File f:files){
			names[i]=f.getName();
			i++;
		}
		
		return names;
	}
	/**
	 * ��;˵���������ļ����������û�д������в�����  
	 * ���� �ˣ�tl
	 */
	public static boolean creatMkdir(String path) {
		try {

			File file = new File(path);
			
			if (!file.exists()) {
				file.mkdirs();
			}
			
		} catch (Exception e) {
			
			//System.out.print("����" + path + "Ŀ¼ʧ�ܣ�");
			showMSG("����" + path + "Ŀ¼ʧ�ܣ�","");
			
			  
			 e.printStackTrace();
              logger.error(e);
			return false;
		}

		return true;
	}
	private static void showMSG(String strMSGContent, String strMsgType) {
		if ((strMSGContent != null)
				&& (!strMSGContent.equalsIgnoreCase("hidden")))
			logger.info(strMSGContent);
	}
}
