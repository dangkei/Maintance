package utils;

import com.aspose.cells.License;
import com.aspose.cells.SaveFormat;
import com.aspose.cells.Workbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

/**
 * @Author:YanchaoLiu
 * @Description:
 * @date:Created in 15:40 2019/11/5
 */
public class Excel2Pdf2 {

    public static void main(String[] args) {
        // 验证License
        if (!getLicense()) {
            return;
        }

        try {
            long old = System.currentTimeMillis();
            Workbook wb = new Workbook("d:/doc/通财债务文〔2020〕796号附件2：通州区地方政府新增债券项目储备库11.24(1)(1).xlsx");// 原始excel路径
            File pdfFile = new File("d:/doc/通财债务文〔2020〕796号附件2：通州区地方政府新增债券项目储备库11.24(1)(1).pdf");// 输出路径
            FileOutputStream fileOS = new FileOutputStream(pdfFile);

            wb.save(fileOS, SaveFormat.PDF);

            long now = System.currentTimeMillis();
            System.out.println("共耗时：" + ((now - old) / 1000.0) + "秒");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    public static boolean getLicense() {
        boolean result = false;
        try {
            InputStream is = Excel2Pdf2.class.getClassLoader().getResourceAsStream("\\license.xml");
            License aposeLic = new License();
            aposeLic.setLicense(is);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
