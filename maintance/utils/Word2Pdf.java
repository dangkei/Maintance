package utils;

import com.aspose.words.Document;
import com.aspose.words.ImageSaveOptions;
import com.aspose.words.License;
import com.aspose.words.SaveFormat;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @Author:YanchaoLiu
 * @Description:
 * @date:Created in 14:16 2019/11/7
 */
public class Word2Pdf {
    static boolean isCheckLicense = false;
    /**
     * 获取license
     *
     * @return
     */
    public synchronized static boolean getLicense() {
        if(isCheckLicense) {
            return true;
        }
        boolean result = false;
        try {
            InputStream is = com.assoft.doc.common.util.Word2Pdf.class.getResourceAsStream("license.xml");
            License aposeLic = new License();
            aposeLic.setLicense(is);

            result = true;
            isCheckLicense = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * doc to pdf
     *
     * @param docPath
     *            doc源文件
     * @param pdfPath
     *            pdf目标文件
     */
    public synchronized static boolean doc2PDF(String docPath, String pdfPath) {
        return doc2PDF(docPath, pdfPath, null, null);
    }
    public synchronized static boolean doc2PDF(String docPath, String pdfPath, String imageDir) {
        return doc2PDF(docPath, pdfPath, imageDir, null);
    }

    /**
     * doc to pdf
     *
     * @param docPath
     *            doc源文件
     * @param pdfPath
     *            pdf目标文件
     */
    public synchronized static boolean doc2PDF(String docPath, String pdfPath, String imageDir, String swfPath) {
        FileOutputStream os = null;
        Document doc = null;
        try {
            System.out.println("++++++++++++++++++++++++++++++++++=转换word文档路径=" + docPath + "++++++++++++++++++++++++++++++++++");
            long startTime = System.currentTimeMillis();
            // 验证License
            if (!getLicense()) {
                return false;
            }

            if (StringUtils.isNotBlank(docPath) && StringUtils.isNotBlank(pdfPath)) {
                File file = new File(pdfPath);
                os = new FileOutputStream(file);
                doc = new Document(docPath);
                doc.save(os, SaveFormat.PDF);//全面支持DOC, DOCX, OOXML, RTF HTML, OpenDocument, PDF, EPUB, XPS, SWF 相互转换
                long endTime1 = System.currentTimeMillis();
                System.out.println("++++++++++++++++++++++word转换pdf用时=" + (endTime1 - startTime) + " ms+++++++++++++++++++++++++");

                if(StringUtils.isNotBlank(swfPath)) {
                    //word转swf
                    word2Swf(doc, swfPath);
                }
                if(StringUtils.isNotBlank(imageDir)) {
                    //word转图片
                    word2Image(doc, imageDir);
                    long endTime2 = System.currentTimeMillis();
                    System.out.println("++++++++++++++++++++++word转换image用时=" + (endTime2 - endTime1) + " ms+++++++++++++++++++++++++");
                }
            }
            long endTime = System.currentTimeMillis();
            System.out.println("++++++++++++++++++++++转换总用时=" + (endTime - startTime) + " ms+++++++++++++++++++++++++");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            if(os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * word转swf
     * @param doc
     * @param swfPath
     * @throws FileNotFoundException
     */
    private static void word2Swf(Document doc, String swfPath) throws FileNotFoundException {
        // FileOutputStream os = new FileOutputStream(swfPath);

    }

    /**
     * word转pdf
     * @param doc
     * @param imageDir
     * @throws Exception
     */
    private static void word2Image(Document doc, String imageDir) throws Exception {
        if(StringUtils.isBlank(imageDir)) {
            return;
        }
        new File(imageDir).mkdirs();
        ImageSaveOptions iso = new ImageSaveOptions(SaveFormat.JPEG);
        iso.setPrettyFormat(true);
        iso.setUseAntiAliasing(true);
        for (int i = 0; i < doc.getPageCount(); i++)
        {
            iso.setPageIndex(i);
            doc.save(imageDir + i + ".jpg", iso);
        }
    }

    public static void main(String[] args) throws Exception {

        String docPath = "E:\\doc\\京通市监文〔2021〕27号.docx";
        String pdfPath = "E:\\doc\\1.pdf";
        com.assoft.doc.common.util.Word2Pdf.doc2PDF(docPath, pdfPath);

    }

    private static void mutliTest() {

    }


    private static void sigleTest() {
         }

}
