package com.assoft.common.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfCopy;
import com.itextpdf.text.pdf.PdfImportedPage;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * 这里处理pdf文档
 * 
 * @author liuliping
 * 
 */
public class PDFUtils {

	public static void main(String[] arrs) {

		
//		List<String>imgesList = new ArrayList<String>();
//		imgesList.add("E:\\tzoa\\对外转发失败word\\ceshi\\1.jpg");
//		String saveImagePath ="E:\\tzoa\\对外转发失败word\\ceshi\\1.pdf";
//		insertImagesTopdf(imgesList, saveImagePath);
		List<String> list = new ArrayList<String>();
		//list.add("E:\\tzoa\\对外转发失败word\\qa\\12.pdf");
		//list.add("E:\\tzoa\\对外转发失败word\\qa\\1.pdf");
		
	
		
		//String newFile ="E:\\tzoa\\对外转发失败word\\qa\\3.pdf";
		//mergePdfFiles(list, newFile);
		
		//mergePdfFilesBy((String[])list.toArray(), newFile);

	}

	/**
	 * 把图片插入到pdf中
	 * 
	 * @param list
	 * @param savePath
	 */
	public static void insertImagesTopdf(List<String> list, String savePath) {
		File saveFile=new File(savePath);
		if(saveFile.exists()) saveFile.delete();
		
       
		Document document = null;
		FileOutputStream outputStream = null;
		try {
			document = new Document(PageSize.A4,150, 150, 0,0);
			outputStream = new FileOutputStream(savePath);
			PdfWriter writer = PdfWriter.getInstance(document, outputStream);

			writer.setPdfVersion(PdfWriter.PDF_VERSION_1_2);

			

			document.open();
			
			
			
			for (String imagePath : list) {

				document.newPage();
				Image image = Image.getInstance(imagePath);

				image.setAlignment(Image.ORIGINAL_JPEG|Image.ALIGN_CENTER|Image.TOP);

				image.setBorder(Image.BOX);
				image.setBorderWidth(0);
				//image.setBorderColor(BaseColor.WHITE);
				// 设置大小
				image.scaleToFit(PageSize.A4);
				

				document.add(image);
			}
			outputStream.flush();

			document.close();
			outputStream.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (document != null) {
				document.close();
			}

			if (outputStream != null) {
				try {
					outputStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

	/**
	 * 多个pdf合成
	 * 
	 * @param list
	 * @param newfile
	 * @return
	 */
	public static boolean mergePdfFiles(List<String> list, String newfile) {
		
		File file=new File(newfile);
		if(file.exists()) file.delete();
		
		
		boolean sucess=false;
		
		FileOutputStream outputStream=null;
		
		Document document=null;
		PdfWriter writer=null;
		try {
			outputStream=new FileOutputStream(newfile);

		    //创建文档,设置页面大小,      左、右、上和下页边距

			document=new Document();
			writer=PdfWriter.getInstance(document, outputStream);
			
			PdfContentByte cByte=null;
			int totalPages=0;
			
			
			int pageOfCurrentReaderPDF=0;
			System.out.println("ddd");
			Iterator<String> iterator=list.iterator();
			int first=0;
			while(iterator.hasNext()){
				PdfReader reader=new PdfReader(iterator.next());
				totalPages+=reader.getNumberOfPages();
				int index=1;
				while(pageOfCurrentReaderPDF<reader.getNumberOfPages()){
					
					if(first==0){//如果是一次添加属性则需要调用后才能打开
						document.open();
						//得到该pdf的内容
						cByte =writer.getDirectContent();
					}
				
					document.setPageSize(reader.getPageSize(index));
					first++;
					document.newPage();
					
				//	writer.setPageSize(reader.getPageSize(index));
					index++;
					pageOfCurrentReaderPDF++;
					
					PdfImportedPage page = writer.getImportedPage(reader, pageOfCurrentReaderPDF);
				   cByte.addTemplate(page, 0,0);
				}
				pageOfCurrentReaderPDF=0;
			}
			
			outputStream.flush();
	
			document.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			sucess=false;
			e.printStackTrace();
		}finally{
			if(outputStream!=null){
				try {
					outputStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
		
		return sucess;
	}
	
	
	
	/*
	 * * 合並pdf文件 * * @param files 要合並文件數組(絕對路徑如{ "e:\\1.pdf", "e:\\2.pdf" ,
	 * "e:\\3.pdf"}) * @param newfile 合並後新產生的文件絕對路徑如e:\\temp.pdf,請自己刪除用過後不再用的文件請
	 * * @return boolean 產生成功返回true, 否則返回false
	 */
	public static boolean mergePdfFilesBy(String[] files, String newfile) {
		boolean retValue = false;
		Document document = null;
		try {
			document = new Document(new PdfReader(files[0]).getPageSize(1));
			PdfCopy copy = new PdfCopy(document, new FileOutputStream(newfile));
			document.open();
			for (int i = 0; i < files.length; i++) {
				PdfReader reader = new PdfReader(files[i]);
				int n = reader.getNumberOfPages();
				for (int j = 1; j <= n; j++) {
					document.newPage();
					PdfImportedPage page = copy.getImportedPage(reader, j);
					copy.addPage(page);
				}
			}
			retValue = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			document.close();
		}
		return retValue;
	}
	
}
