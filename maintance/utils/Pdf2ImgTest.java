package utils;



import java.io.File;

import com.assoft.dc.common.util.ImageUtils;

public class Pdf2ImgTest {
	
	public static void main(String []args){
		String saveImgPath="e:\\doc\\img";
		new File(saveImgPath).mkdir();
		int size = 1;
		int index=5;//图片命名从1开始
		for(int i=0;i<size;i++){
			String pdfPath="e:\\doc\\通财预文〔2021〕29号附件（以此为准）.pdf";
			StringBuilder msgBuilder = new StringBuilder();
			ImageUtils.savaPdf2JpgByAcrobat(pdfPath,saveImgPath);//只有一个pdf时使用
			//index = ImageUtils.savaPdf2JpgByAcrobat(pdfPath,saveImgPath,index,msgBuilder);
			System.out.println("");
		}
		
		
	}
	
}