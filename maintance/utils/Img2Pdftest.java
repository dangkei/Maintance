package utils;



import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.assoft.common.util.PDFUtils;

public class Img2Pdftest {
	
	public static void main(String []args){
		
		List<String> list = new ArrayList<String>();
		String imgPath="D:\\doc\\img\\1\\";//要转换成的pdf的图片放置的文件夹，如果是多张图片，则会合成到一个pdf中
		
		File[] files = new File(imgPath).listFiles();
		for(File temp:files){
			list.add(temp.getAbsolutePath());
		}
		String savePath="D:\\doc\\6.pdf";//合成后的pdf文件
		PDFUtils.insertImagesTopdf(list, savePath);
		System.out.print("/****---图片转换完毕---****/");
		
	}
	
}