package asopdc;

import com.assoft.dc.common.util.ImageUtils;

public class ImgComposeTest {

	
	public static void main(String[]args){
		//两个图片合成
		String imgSrcPath1="E:\\doc\\img\\0.jpg";
		String secondImgPath="E:\\doc\\img\\2.jpg";
		String destPath="E:\\doc\\img\\5.jpg";
				
		try {
			ImageUtils.generalImgByAlpha(imgSrcPath1, secondImgPath, destPath);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
