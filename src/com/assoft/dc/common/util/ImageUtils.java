package com.assoft.dc.common.util;


import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.swing.ImageIcon;

import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;
import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.ComThread;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

public class ImageUtils {
	
	public static final String PDF_TO_IMG_ERROR="pdf2ImgError";
	
	
   
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		
	
			
			//ImageUtils.generalImgByAlpha("F:/测试环境/移动服务端/1.jpg","F:/测试环境/移动服务端/0.jpg","F:/测试环境/移动服务端/1.jpg");
		
					ImageUtils.savePdf2JpgByAcrobatToSmallImg("e://2.pdf", "e://1//",1,new StringBuilder());
				
		
		//savaPdf2JpgByAcrobatNew("F:/ceshi1/ReceiveDoc,2744516.pdf", "f:/ceshi1/img/", 0);
		//savaPdf2JpgByAcrobat("F:/ceshi1/ReceiveDoc,2744516.pdf",  "f:/ceshi1/img1/", 0);	
		//compressPic(true, "H:/3842/bigImg/1_temp.jpg", Constant.SMALL_IMAGE_WIDTH, Constant.SMALL_IMAGE_HEIGHT, new File("H:/3842/bigImg/1.jpg"));
		//compressPic("H:/3842/bigImg/1.jpg", "H:/3842/bigImg/1_temp_temp.jpg");
		
//		for(int i=0;i<=2;i++){
//			StringBuilder msg = new StringBuilder();
//			String docPath="f://ceshi/sss.doc";
//			
//				String pathString ="f://ceshi/img/"+i;
//				File file = new File(pathString);
//				file.mkdirs();
//			
//				Word2SwfUtils.word2PDF(docPath, pathString+"/a.pdf",
//						Constant.WORD_SAVE_AS_PDF, msg);
//		}
		
		
//			for( int i=0;i<10;i++){
//				final int num=i;
//			
//				new Thread(
//			 new Runnable() {
//				public void run() {
//					StringBuilder msg = new StringBuilder();
//					String docPath="f://ceshi/sss.doc";
//					for(int j=0;j<=10;j++){
//						String pathString ="f://ceshi/img/"+num+"/"+j+"/";
//						File file = new File(pathString);
//						file.mkdirs();
//					//savaPdf2JpgByAcrobat(pdfPath,file.getAbsolutePath() ,0);
//						Word2SwfUtils.word2PDF(docPath, pathString+"/a.pdf",
//							Constant.WORD_SAVE_AS_PDF, msg);
//						
//				}
//			}
//			
//			 }).start();
//			}
//			
//			
//			String srcImgPath = "d:/ceshi/1.jpg";
//			String secondImgPath = "d:/ceshi/0.jpg";
//			String destPath = "d:/ceshi/1.jpg";
//			File file = new File(destPath);
//			System.out.println(file.getName());
			
			
			//changeJpgToPng(secondImgPath);
			//generalImgByAlpha(srcImgPath, secondImgPath, destPath);
			//generalImgByGraphics2(srcImgPath, secondImgPath, destPath);
			/*String savePath = "d:/test";
			
			String filepath = "F:/workspace/tzoanew-3.7/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/asopdc/docApproval/tzoa/200/approval/ReceiveDoc,248148088817.pdf";
			
			File file = new File(savePath);
			if(!file.exists())
				file.mkdir();
			savaPdf2JpgByAcrobat(filepath, savePath);*/
			
			//imgToWord(savePath + File.separator + "1.docx", savePath + File.separator + "1.jpg");
			//img2Word(savePath + File.separator + "1.doc", savePath + File.separator + "1.jpg");
			//insertImage(savePath + File.separator + "1.doc", savePath + File.separator + "1.jpg");
			/*List<String> fileList = new ArrayList<String>();
			fileList.add(savePath + File.separator + "22.doc");
			fileList.add(savePath + File.separator + "1.doc");
			Word2SwfUtils.uniteDoc(fileList, savePath + File.separator + "3.doc");*/
//			String destPath = "d:/11111.jpg";
//			int height = 1068;
//			int width = 768;
//			File imgFile = new File("d:/20528/11.jpg");
//			compressPic(false, destPath, width, height, imgFile);
		
	}

	public static void generalImg(String imgSrcPath, String secondImgPath, String destPath)
			throws Exception {
		File _file1 = new File(imgSrcPath);
		File _file2 = new File(secondImgPath);
		FileOutputStream out = null;
		try {
			Image src = javax.imageio.ImageIO.read(_file1); // 构造Image对象
			Image src2 = javax.imageio.ImageIO.read(_file2);
			int width = src.getWidth(null); // 得到源图宽
			int height = src.getHeight(null); // 得到源图长
			BufferedImage tag = new BufferedImage(width, height,
					BufferedImage.TYPE_INT_RGB);
			
			out = new FileOutputStream(destPath); // 输出到文件流
			Graphics g = tag.createGraphics();
			g.fillRect(0, 0, width, height);
			g.setClip(0, 0, width, height);

			g.drawImage(src, 0, 0, width, height, null);
			g.drawImage(src2, 0, 0, width, height, null);
			g.dispose();
           
			JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
			
			encoder.encode(tag); // 近JPEG编码
			encoder=null;
			out.flush();
		} finally {
			if (out != null) {
				out.close();
			}
		}
	}

	
	

	/**
	 * 这里实现了透明的图片合成
	 * @param imgSrcPath
	 * @param secondImgPath
	 * @param destPath
	 * @throws Exception
	 */
	public static void generalImgByAlpha(String imgSrcPath, String secondImgPath, String destPath)throws Exception {
		
			transferAlpha(imgSrcPath);
			transferAlpha(secondImgPath);
			
			generalImg(imgSrcPath,secondImgPath,destPath);
		
		
		
	}
	
	
	/**
	 * 	
	 * @param imgPage
	 * @return
	 */
	 public static void transferAlpha(String imgPage)throws Exception { 
		 Graphics2D g2D = null;
	       try{
	    	   
	      
	        Image src = javax.imageio.ImageIO.read(new File(imgPage)); // 构造Image对象
	         ImageIcon imageIcon = new ImageIcon(src); 
	         BufferedImage bufferedImage = new BufferedImage(imageIcon 
	           .getIconWidth(), imageIcon.getIconHeight(), 
	           BufferedImage.TYPE_4BYTE_ABGR); 
	          g2D = (Graphics2D) bufferedImage.getGraphics(); 
	         g2D.drawImage(imageIcon.getImage(), 0, 0, imageIcon 
	           .getImageObserver()); 
	         int alpha = 0; 
	         for (int j1 = bufferedImage.getMinY(); j1 < bufferedImage 
	           .getHeight(); j1++) { 
	          for (int j2 = bufferedImage.getMinX(); j2 < bufferedImage 
	            .getWidth(); j2++) { 
	           int rgb = bufferedImage.getRGB(j2, j1); 
	         
	           int R =(rgb & 0xff0000 ) >> 16 ; 
	           int G= (rgb & 0xff00 ) >> 8 ; 
	           int B= (rgb & 0xff ); 
	           if(((255-R)<30) && ((255-G)<30) && ((255-B)<30)){ 
	            rgb = ((alpha + 1) << 24) | (rgb & 0x00ffffff); 
	           } 

	           bufferedImage.setRGB(j2, j1, rgb); 

	          } 
	         } 

	         g2D.drawImage(bufferedImage, 0, 0, imageIcon.getImageObserver()); 
	        
	         ImageIO.write(bufferedImage, "png", new File(imgPage)); 
	         bufferedImage=null;
	         imageIcon=null;
	       }finally{
	    	   if(g2D!=null) g2D.dispose();
	       }
	        } 
	    
	
	/**
	 * 通过Acrobat把pdf转换成图片
	 * @param filePath pdf文件地址
	 * @param savePath 图片保存的目录
	 * @return 图片个数
	 */
	@SuppressWarnings("deprecation")
	public static int savaPdf2JpgByAcrobat(String filePath, String savePath) {
		ComThread.InitSTA(true);
		//输出
		FileOutputStream out = null; 
		//PDF页数 
		int pageNum = 0;
		//PDF宽、高 
		int x,y = 0; 
		//PDF控制对象 
		Dispatch pdfObject = null; 
		//PDF坐标对象 
		Dispatch pointxy = null; 
		//pdfActiveX PDDoc对象 主要建立PDF对象 
		ActiveXComponent app = new ActiveXComponent("AcroExch.PDDoc"); 
		//pdfActiveX PDF的坐标对象
		ActiveXComponent point = new ActiveXComponent("AcroExch.Point"); 
		try { 
			//得到控制对象 
			pdfObject = app.getObject(); 
			//得到坐标对象 
			pointxy = point.getObject(); 
			//打开PDF文件，建立PDF操作的开始
			Dispatch.call(pdfObject, "Open", new Variant(filePath));
			//得到当前打开PDF文件的页数 
			pageNum = Dispatch.call(pdfObject, "GetNumPages").toInt();
			for(int i=0;i < pageNum;i++){ 
				//根据页码得到单页PDF 
				Dispatch page = Dispatch.call(pdfObject, "AcquirePage", new Variant(i)).toDispatch(); 
				//得到PDF单页大小的Point对象 
				Dispatch pagePoint = Dispatch.call(page, "GetSize").toDispatch(); 
				//创建PDF位置对象，为拷贝图片到剪贴板做准备 
				ActiveXComponent pdfRect = new ActiveXComponent("AcroExch.Rect"); 
				//得到单页PDF的宽 
				int imgWidth = (int) (Dispatch.get(pagePoint, "x").toInt() * 2); 
				//得到单页PDF的高 
				int imgHeight = (int) (Dispatch.get(pagePoint, "y").toInt() * 2); 
				
				//控制PDF位置对象 
				Dispatch pdfRectDoc = pdfRect.getObject(); 
				//设置PDF位置对象的值 
				Dispatch.put(pdfRectDoc, "Left", new Integer(0)); 
				Dispatch.put(pdfRectDoc, "Right", new Integer(imgWidth));
				Dispatch.put(pdfRectDoc, "Top", new Integer(0)); 
				Dispatch.put(pdfRectDoc, "Bottom", new Integer(imgHeight)); 
				//将设置好位置的PDF拷贝到Windows剪切板，参数：位置对象,宽起点，高起点，分辨率 
				Dispatch.call(page, "CopyToClipboard",new Object[]{pdfRectDoc,0,0,200}); 
				Image image = getImageFromClipboard(); 
				BufferedImage tag = new BufferedImage(imgWidth, imgHeight, 1);
				Graphics graphics = tag.getGraphics(); 
				graphics.drawImage(image, 0, 0, null); 
				graphics.dispose(); 
				String fileName = (i + 1) + ".jpg";
				//输出图片 
				ImageIO.write(tag, "JPEG", new File(savePath + File.separator + fileName));
				
				//image.flush();
			}
		} catch (Exception e) {
			e.printStackTrace(); 
		} finally { //关闭PDF 
		
		
			//point.invoke("Close", new Variant[] {}); 
//			Clipboard sysc = Toolkit.getDefaultToolkit().getSystemClipboard();
//			sysc.setContents(null, null);
			
			try {
				app.invoke("Close", new Variant[] {}); 
//				point.invoke("Close",new Variant[]{});
				if(app!=null){
					//app.invoke("Quit",new Variant[]{});
					app.safeRelease();
					app=null;
				}
//				if(point!=null){
//					point.invoke("Quit",new Variant[]{});
//					point.safeRelease();
//					point=null;
//				}
				//app.invoke("Quit", new Variant[]{}); 
				ComThread.Release();//释放com线程。根据jacob的帮助文档，com的线程回收不由java的垃圾回收器处理
				if(out != null)
					out.close();
				Thread.sleep(200);
			} catch (IOException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return pageNum;
	}
	
	
	
	/**
	 * 检查pdf是否能正常打开
	 * @param filePath
	 * @param savePath
	 * @return boolean true 表示正常打开   fasle表示失败
	 */
	public static boolean checkPdfIsOpen(String filePath) {
		
		boolean isOpen=false;
		ComThread.InitSTA(true);
		
		//PDF页数 
		int pageNum = 0;
		
		//PDF控制对象 
		Dispatch pdfObject = null; 
		//PDF坐标对象 
		Dispatch pointxy = null; 
		//pdfActiveX PDDoc对象 主要建立PDF对象 
		ActiveXComponent app = new ActiveXComponent("AcroExch.PDDoc"); 
		//pdfActiveX PDF的坐标对象
		ActiveXComponent point = new ActiveXComponent("AcroExch.Point"); 
		try { 
			//得到控制对象 
			pdfObject = app.getObject(); 
			//得到坐标对象 
			pointxy = point.getObject(); 
			//打开PDF文件，建立PDF操作的开始
			Dispatch.call(pdfObject, "Open", new Variant(filePath));
			//得到当前打开PDF文件的页数 
			pageNum = Dispatch.call(pdfObject, "GetNumPages").toInt();
			
			
			isOpen=(pageNum !=-1);
		
			
			
		} catch (Exception e) {
			e.printStackTrace(); 
		} finally { //关闭PDF 
		
		
			
			try {
				app.invoke("Close", new Variant[] {}); 

				if(app!=null){
					app.safeRelease();
					app=null;
				}

				ComThread.Release();//释放com线程。根据jacob的帮助文档，com的线程回收不由java的垃圾回收器处理
				
			} catch (Exception e) {
				e.printStackTrace();
			} 
			
		}
		return isOpen;
	}
	
	
	/**
	 * 通过Acrobat把pdf转换成图片
	 * @param filePath pdf文件地址
	 * @param savePath 图片保存的目录
	 * @param msgBuilder 收集错误信息   转化图片异常
	 * @return 图片个数
	 */
	@SuppressWarnings("deprecation")
	public static int savaPdf2JpgByAcrobat(String filePath, String savePath,int index,StringBuilder msgBuilder) {
		ComThread.InitSTA(true);		
		//输出
		FileOutputStream out = null; 
		//PDF页数 
		int pageNum = 0;
		//PDF宽、高 
		int x,y = 0; 
		//PDF控制对象 
		Dispatch pdfObject = null; 
		//PDF坐标对象 
		Dispatch pointxy = null; 
		//pdfActiveX PDDoc对象 主要建立PDF对象 
		ActiveXComponent app = new ActiveXComponent("AcroExch.PDDoc"); 
		//pdfActiveX PDF的坐标对象
		ActiveXComponent point = new ActiveXComponent("AcroExch.Point"); 
		try { 
			//得到控制对象 
			pdfObject = app.getObject(); 
			//得到坐标对象 
			pointxy = point.getObject(); 
			//打开PDF文件，建立PDF操作的开始
			Dispatch.call(pdfObject, "Open", new Variant(filePath));
			//得到当前打开PDF文件的页数 
			pageNum = Dispatch.call(pdfObject, "GetNumPages").toInt();
			for(int i=0;i < pageNum;i++){ 
				//根据页码得到单页PDF 
				Dispatch page = Dispatch.call(pdfObject, "AcquirePage", new Variant(i)).toDispatch(); 
				//得到PDF单页大小的Point对象 
				Dispatch pagePoint = Dispatch.call(page, "GetSize").toDispatch(); 
				//创建PDF位置对象，为拷贝图片到剪贴板做准备 
				ActiveXComponent pdfRect = new ActiveXComponent("AcroExch.Rect"); 
				//得到单页PDF的宽 
				int imgWidth = (int) (Dispatch.get(pagePoint, "x").toInt() * 2); 
				//得到单页PDF的高 
				int imgHeight = (int) (Dispatch.get(pagePoint, "y").toInt() * 2); 
				
				//控制PDF位置对象 
				Dispatch pdfRectDoc = pdfRect.getObject(); 
				//设置PDF位置对象的值 
				Dispatch.put(pdfRectDoc, "Left", new Integer(0)); 
				Dispatch.put(pdfRectDoc, "Right", new Integer(imgWidth));
				Dispatch.put(pdfRectDoc, "Top", new Integer(0)); 
				Dispatch.put(pdfRectDoc, "Bottom", new Integer(imgHeight)); 
				//将设置好位置的PDF拷贝到Windows剪切板，参数：位置对象,宽起点，高起点，分辨率 
				Dispatch.call(page, "CopyToClipboard",new Object[]{pdfRectDoc,0,0,200}); 
				Image image = getImageFromClipboard(); 
				BufferedImage tag = new BufferedImage(imgWidth, imgHeight, 1);
				Graphics graphics = tag.getGraphics(); 
				graphics.drawImage(image, 0, 0, null); 
				graphics.dispose(); 
				String fileName = (index+i + 1) + ".jpg";
				//输出图片 
				ImageIO.write(tag, "JPEG", new File(savePath + File.separator + fileName));
				//image.flush();
			}
		} catch (Exception e) {
			msgBuilder.append(","+PDF_TO_IMG_ERROR+",");
			e.printStackTrace(); 
		} finally { //关闭PDF 
			
			
			//point.invoke("Close", new Variant[] {}); 
			/*Clipboard sysc = Toolkit.getDefaultToolkit().getSystemClipboard();
			sysc.setContents(null, null);*/ 
			try {
				app.invoke("Close", new Variant[] {}); 
				//point.invoke("Close",new Variant[]{});
				if(app!=null){
					//app.invoke("Quit",new Variant[]{});
					app.safeRelease();
					app=null;
				}
//				if(point!=null){
//					point.invoke("Quit",new Variant[]{});
//					point.safeRelease();
//					point=null;
//				}
				//app.invoke("Quit", new Variant[]{}); 
				ComThread.Release();//释放com线程。根据jacob的帮助文档，com的线程回收不由java的垃圾回收器处理
				if(out != null)
					out.close();
				Thread.sleep(200);
			} catch (IOException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
			// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return pageNum+index;
	}
	
	
	
	
	/**
	 * 通过Acrobat把pdf转换成图片
	 * @param filePath pdf文件地址
	 * @param savePath 图片保存的目录
	 * @return 图片个数
	 */
	@SuppressWarnings("deprecation")
	public static int savaPdf2JpgByAcrobatNew(String filePath, String savePath,int index) {
		ComThread.InitSTA(true);
		//输出
		FileOutputStream out = null; 
		//PDF页数 
		int pageNum = 0;
		//PDF宽、高 
		int x,y = 0; 
		//PDF控制对象 
		Dispatch pdfObject = null; 
		//PDF坐标对象 
		Dispatch pointxy = null; 
		//pdfActiveX PDDoc对象 主要建立PDF对象 
		ActiveXComponent app = new ActiveXComponent("AcroExch.PDDoc"); 
		//pdfActiveX PDF的坐标对象
		ActiveXComponent point = new ActiveXComponent("AcroExch.Point"); 
		try { 
			//得到控制对象 
			pdfObject = app.getObject(); 
			//得到坐标对象 
			pointxy = point.getObject(); 
			//打开PDF文件，建立PDF操作的开始
			Dispatch.call(pdfObject, "Open", new Variant(filePath));
			//得到当前打开PDF文件的页数 
			pageNum = Dispatch.call(pdfObject, "GetNumPages").toInt();
			for(int i=0;i < pageNum;i++){ 
				//根据页码得到单页PDF 
				Dispatch page = Dispatch.call(pdfObject, "AcquirePage", new Variant(i)).toDispatch(); 
				//得到PDF单页大小的Point对象 
				Dispatch pagePoint = Dispatch.call(page, "GetSize").toDispatch(); 
				//创建PDF位置对象，为拷贝图片到剪贴板做准备 
				ActiveXComponent pdfRect = new ActiveXComponent("AcroExch.Rect"); 
				//得到单页PDF的宽 
				int imgWidth = (int) (Dispatch.get(pagePoint, "x").toInt()*2 ); 
				//得到单页PDF的高 
				int imgHeight = (int) (Dispatch.get(pagePoint, "y").toInt()*2); 
				
				//控制PDF位置对象 
				Dispatch pdfRectDoc = pdfRect.getObject(); 
				//设置PDF位置对象的值 
				Dispatch.put(pdfRectDoc, "Left", new Integer(0)); 
				Dispatch.put(pdfRectDoc, "Right", new Integer(imgWidth));
				Dispatch.put(pdfRectDoc, "Top", new Integer(0)); 
				Dispatch.put(pdfRectDoc, "Bottom", new Integer(imgHeight)); 
				//将设置好位置的PDF拷贝到Windows剪切板，参数：位置对象,宽起点，高起点，分辨率 
				Dispatch.call(page, "CopyToClipboard",new Object[]{pdfRectDoc,0,0,200}); 
				Image image = getImageFromClipboard(); 
				BufferedImage tag = new BufferedImage(imgWidth, imgHeight, 1);
				//BufferedImage tag = new BufferedImage(width, height, imageType)
				Graphics graphics = tag.getGraphics(); 
				graphics.drawImage(image, 0, 0, null); 
				graphics.dispose(); 
				String fileName = (index+i + 1) + ".jpg";
				//输出图片 
				ImageIO.write(tag, "JPEG", new File(savePath + File.separator + fileName));
				//image.flush();
			}
		} catch (Exception e) {
			e.printStackTrace(); 
		} finally { //关闭PDF 
			
			
			//point.invoke("Close", new Variant[] {}); 
			/*Clipboard sysc = Toolkit.getDefaultToolkit().getSystemClipboard();
			sysc.setContents(null, null);*/ 
			try {
				app.invoke("Close", new Variant[] {}); 
				//point.invoke("Close",new Variant[]{});
				if(app!=null){
					//app.invoke("Quit",new Variant[]{});
					app.safeRelease();
					app=null;
				}
//				if(point!=null){
//					point.invoke("Quit",new Variant[]{});
//					point.safeRelease();
//					point=null;
//				}
				//app.invoke("Quit", new Variant[]{}); 
				ComThread.Release();//释放com线程。根据jacob的帮助文档，com的线程回收不由java的垃圾回收器处理
				if(out != null)
					out.close();
				Thread.sleep(200);
			} catch (IOException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
			// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return pageNum+index;
	}
	
	
	
	/**
	 * 从剪切板获取图片信息
	 * 
	 * @return
	 * @throws Exception
	 */
	public static Image getImageFromClipboard() throws Exception {
		Clipboard sysc = Toolkit.getDefaultToolkit().getSystemClipboard();
		Transferable cc = sysc.getContents(null);
		if (cc == null)
			return null;
		else if (cc.isDataFlavorSupported(DataFlavor.imageFlavor)){
			Image img= (Image) cc.getTransferData(DataFlavor.imageFlavor);
			//sysc.setContents(null, null);
			return img;
		}
		return null;
	}
	
	/**
	 * 清空剪切板
	 * 
	 * @return
	 * @throws Exception
	 */
	public static void cleanImageFromClipboard() throws Exception {
		Clipboard sysc = Toolkit.getDefaultToolkit().getSystemClipboard();
		Transferable cc = sysc.getContents(null);
		if (cc == null)
			return ;
		else if (cc.isDataFlavorSupported(DataFlavor.imageFlavor)){
			if(sysc!=null&&sysc.getContents(null)!=null)
		        //sysc.setContents(null, null);
			return;
		}
		return;
	}

	/**
	 * 图片按照一定的比例进行缩放
	 * @param proportion 是否为等比例
	 * @param destPath 图片缩放后存放的路径
	 * @param imgWidth 图片宽度
	 * @param imgHeight 图片高度
	 * @param imgFile  源图片文件
	 * @return
	 */
	public static boolean compressPic(boolean proportion, String destPath, int imgWidth, int imgHeight,
			File imgFile) {
		// 获得源文件
		FileOutputStream out = null;
		BufferedImage tag = null;
		try {

			Image img = ImageIO.read(imgFile);
			// 判断图片格式是否正确
			if (img.getWidth(null) == -1) {
				return false;
			} else {
				int newWidth;
				int newHeight;
				// 判断是否是等比缩放
				if (proportion) {
					// 为等比缩放计算输出的图片宽度及高度
					double rate1 = ((double) img.getWidth(null)) / (double) imgWidth + 0.1;
					double rate2 = ((double) img.getHeight(null)) / (double) imgHeight + 0.1;
					// 根据缩放比率大的进行缩放控制
					double rate = rate1 > rate2 ? rate1 : rate2;
					newWidth = (int) (((double) img.getWidth(null)) / rate);
					newHeight = (int) (((double) img.getHeight(null)) / rate);
				} else {
					newWidth = imgWidth;   //输出的图片宽度
					newHeight = imgHeight; //输出的图片高度
				}
				tag = new BufferedImage((int) newWidth, (int) newHeight, BufferedImage.TYPE_INT_RGB);
				/*
				 * Image.SCALE_SMOOTH 的缩略算法 生成缩略图片的平滑度的 优先级比速度高 生成的图片质量比较好 但速度慢
				 */
				tag.getGraphics().drawImage(img.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH), 0, 0, null);
				out = new FileOutputStream(destPath);
				// JPEGImageEncoder可适用于其他图片类型的转换
				JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
				encoder.encode(tag);
                tag.getGraphics().dispose();
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (out != null)
				try {
					//tag.flush();
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		return true;
	}
	
	/**
	 * 对图片进行压缩
	 * @param srcFilePath 原图片文件路径
	 * @param descFilePath 存放图片文件路径
	 * @return
	 */
	public static boolean compressPic(String srcFilePath, String descFilePath){   
		BufferedImage src = null;
        File file = null;  
        FileOutputStream out = null;  
        ImageWriter imgWrier;  
        ImageWriteParam imgWriteParams;  
       
        // 指定写图片的方式为 jpg  
        imgWrier = ImageIO.getImageWritersByFormatName("jpg").next();  
        imgWriteParams = new javax.imageio.plugins.jpeg.JPEGImageWriteParam(null);  
        // 要使用压缩，必须指定压缩方式为MODE_EXPLICIT  
        imgWriteParams.setCompressionMode(imgWriteParams.MODE_EXPLICIT);  
        // 这里指定压缩的程度，参数qality是取值0~1范围内，  
        imgWriteParams.setCompressionQuality((float)0.5);  
        imgWriteParams.setProgressiveMode(imgWriteParams.MODE_DISABLED);  
        ColorModel colorModel = ColorModel.getRGBdefault();  
        // 指定压缩时使用的色彩模式  
        imgWriteParams.setDestinationType(new javax.imageio.ImageTypeSpecifier(colorModel, colorModel  
                .createCompatibleSampleModel(16, 16)));  
  
        try  
        {   
        	file = new File(srcFilePath);  
        	src = ImageIO.read(file);  
            out = new FileOutputStream(descFilePath);  
  
            imgWrier.reset();  
            // 必须先指定 out值，才能调用write方法, ImageOutputStream可以通过任何 OutputStream构造  
            imgWrier.setOutput(ImageIO.createImageOutputStream(out));  
            // 调用write方法，就可以向输入流写图片  
            imgWrier.write(null, new IIOImage(src, null, null), imgWriteParams);  
            out.flush();  
            out.close(); 
            imgWrier.dispose();
        }  
        catch(Exception e)  
        {  
            e.printStackTrace();  
            return false;  
        }  finally{
        	src=null;
        	if(out != null)
				try {
					//src.flush();
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
        	
        	if(imgWrier!=null){
        		try{
        		imgWrier.dispose();
        		}catch(Exception e){
        			e.printStackTrace();
        		}
        	}
        	
        	
        }
        return true;  
    }

	/**
	 * 将图片插入到word中
	 * 
	 * @param targetUrl
	 *            目标
	 * @param imgUrls
	 *            图片路径
	 */
	@SuppressWarnings("deprecation")
	public static void imgToWord(String targetUrl, String imgUrls) {
		Document document = new Document();
		try {
			File file = new File(targetUrl);
			  //判断文件是否存在,如果不存在则创建文件
			  if (file.exists()) {
				  Utils.deleteDirFile(file);
			  }
			PdfWriter.getInstance(document, new FileOutputStream(targetUrl));
			document.open();
			document.setPageSize(PageSize.A4);
			com.itextpdf.text.Image png = com.itextpdf.text.Image.getInstance(imgUrls);
			png.scaleToFit((PageSize.A4.getWidth()-130), (PageSize.A4.getHeight() - 60)); 
			document.add(png);
			//document.close();
		} catch (Exception e) {
			e.printStackTrace();
			
		}finally{
			document.close();
		}
	}
	
	/*public static void img2Word(){
		objWord = new Application();
	    //objWord.setScreenUpdating(false);
		objWord.setVisible(true);
	    documents = objWord.getDocuments();
	    document = documents.add();
	    try{
	    	Range range = document.getParagraphs().add().getRange();
	    	range.getInlineShapes().addPicture("d:/\My Documents\\我的图片\\褐红.jpg",new Variant(true),new Variant(false));
	        Thread.sleep(5000);
	            document.saveAs(new Variant("D:\\aa\\wordTest.doc"));
	            objWord.quit();
	    }catch(Exception e){
	     e.printStackTrace();
	    
	    }
	}*/
	/*public static void img2Word(String wordFilePath, String imgPath) {  
        WordBean wordBean = new WordBean();  
        wordBean.setVisible(false); // 是否前台打开word 程序，或者后台运行  
        wordBean.openFile(wordFilePath);  
        wordBean.insertJpeg(imgPath); // 插入图片(注意刚打开的word  
        // ，光标处于开头，故，图片在最前方插入)  
        wordBean.save();  
        wordBean.closeDocument();  
        wordBean.closeWord();  
    }*/
	/** 
     * 给指定的word文档在字符串指定位置插入图片 
     * @param wordFile word文档 
     * @param imagePath  待添加图片的路径 
     * @param str 指定的字符串位置 
     */    
    public static void insertImage(String wordFile, String imagePath) {     
        ActiveXComponent app = new ActiveXComponent("Word.Application");// 启动word  
        try {     
            app.setProperty("Visible", new Variant(false));// 设置word不可见  
    
            Dispatch docs = app.getProperty("Documents").toDispatch();     
    
            Dispatch doc = Dispatch.invoke(     
                    docs,     
                    "Open",     
                    Dispatch.Method,     
                    new Object[] { wordFile, new Variant(false),     
                            new Variant(false) }, new int[1]).toDispatch();     
            // 打开word文件，注意这里第三个参数要设为false，这个参数表示是否以只读方式打开，  
            // 因为我们要保存原文件，所以以可写方式打开。  
    
            Dispatch selection = app.getProperty("Selection").toDispatch();     
            
            Dispatch.call(selection, "HomeKey", new Variant(6));// 移到开头  
    
            Dispatch find = Dispatch.call(selection, "Find").toDispatch();// 获得Find组件  
    
            Dispatch.put(find, "Text", "a");// 查找字符串tarStr  
    
            Dispatch.call(find, "Execute");// 执行查询  
    
            Dispatch.call(Dispatch.get(selection, "InLineShapes").toDispatch(),     
                    "AddPicture", imagePath);// 在指定位置插入图片  

    
            Dispatch.call(doc, "Save");// 保存  
    
            Dispatch.call(doc, "Close", new Variant(false));     
        } catch (Exception e) {     
            e.printStackTrace();     
        } finally {     
            app.invoke("Quit", new Variant[] {});     
            app.safeRelease();     
        }     
    }
    
    
    /**
     * 
     * @param pdfFilePath
     * @param savePath
     * @param index
     * @param msgBuffer 收集错误信息
     * @return
     */
    public  static int savePdf2JpgByAcrobatToSmallImg(String pdfFilePath, String savePath,int index,StringBuilder msgBuffer) {

		ComThread.InitSTA(true);
		//输出
		FileOutputStream out = null; 
		//PDF页数 
		int pageNum = 0;
		//PDF宽、高 
		int x,y = 0; 
		//PDF控制对象 
		Dispatch pdfObject = null; 
		//PDF坐标对象 
		Dispatch pointxy = null; 
		//pdfActiveX PDDoc对象 主要建立PDF对象 
		ActiveXComponent app = new ActiveXComponent("AcroExch.PDDoc"); 
		//pdfActiveX PDF的坐标对象
		ActiveXComponent point = new ActiveXComponent("AcroExch.Point"); 
		try { 
			//得到控制对象 
			pdfObject = app.getObject(); 
			//得到坐标对象 
			pointxy = point.getObject(); 
			//打开PDF文件，建立PDF操作的开始
			Dispatch.call(pdfObject, "Open", new Variant(pdfFilePath));
			//得到当前打开PDF文件的页数 
			pageNum = Dispatch.call(pdfObject, "GetNumPages").toInt();
			for(int i=0;i < pageNum;i++){ 
				//根据页码得到单页PDF 
				Dispatch page = Dispatch.call(pdfObject, "AcquirePage", new Variant(i)).toDispatch(); 
				//得到PDF单页大小的Point对象 
				Dispatch pagePoint = Dispatch.call(page, "GetSize").toDispatch(); 
				//创建PDF位置对象，为拷贝图片到剪贴板做准备 
				ActiveXComponent pdfRect = new ActiveXComponent("AcroExch.Rect"); 
				//得到单页PDF的宽 
				int imgWidth = (int) (Dispatch.get(pagePoint, "x").toInt() * 2); 
				//得到单页PDF的高 
				int imgHeight = (int) (Dispatch.get(pagePoint, "y").toInt() * 2); 
				
				//控制PDF位置对象 
				Dispatch pdfRectDoc = pdfRect.getObject(); 
				//设置PDF位置对象的值 
				Dispatch.put(pdfRectDoc, "Left", new Integer(0)); 
				Dispatch.put(pdfRectDoc, "Right", new Integer(imgWidth));
				Dispatch.put(pdfRectDoc, "Top", new Integer(0)); 
				Dispatch.put(pdfRectDoc, "Bottom", new Integer(imgHeight)); 
				//将设置好位置的PDF拷贝到Windows剪切板，参数：位置对象,宽起点，高起点，分辨率 
				Dispatch.call(page, "CopyToClipboard",new Object[]{pdfRectDoc,0,0,200});
				Image image = getImageFromClipboard(); 
				
				int newWidth=Constant.SMALL_IMAGE_WIDTH;
				int newHeight=Constant.SMALL_IMAGE_HEIGHT;
				
				
				BufferedImage tag = new BufferedImage((int) newWidth, (int) newHeight, BufferedImage.TYPE_INT_RGB);
				
				Graphics graphics = tag.getGraphics(); 
				graphics.drawImage(image.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH), 0, 0, null);
				
				graphics.dispose(); 
				String fileName = (index+i + 1) + ".jpg";
				//输出图片 
				ImageIO.write(tag, "JPEG", new File(savePath + File.separator + fileName));
				
				image.flush();
			}
		} catch (Exception e) {
			msgBuffer.append(","+PDF_TO_IMG_ERROR+",");
			e.printStackTrace(); 
		} finally { //关闭PDF 
			try {
				app.invoke("Close", new Variant[] {}); 
				if(app!=null){
					app.safeRelease();
					app=null;
				}
				ComThread.Release();//释放com线程。根据jacob的帮助文档，com的线程回收不由java的垃圾回收器处理
				if(out != null)
					out.close();
				Thread.sleep(200);
			} catch (Exception e) {
				msgBuffer.append(","+PDF_TO_IMG_ERROR);
				e.printStackTrace();
				
			} 
			
		}
		return pageNum+index;	
    }
  
   
}
