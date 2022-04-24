package ncloud;

import com.assoft.asopUtil.common.tool.util.MD5Util;

/**
 * 更改应用的 admin对应的密码，加密规则如下
 * @author an
 *
 */
public class PasswordTest {

	public static void main(String[] args) {
		String adminP = "cloudDisk@2020";
		adminP = "asop";
//		adminP = "docInterface@2020";
//		adminP = "agenda@2020";
//		adminP = "dutyManagement@2020";
//		adminP = "addressBook@2020";
//		adminP = "car@2020";
		adminP = "chapter@2021";
//		adminP = "contract@2020";
//		adminP = "feedback@2020";
//		adminP = "zeroReport@2020";
//		adminP = "fileTransfer@2020";
//		adminP = "leave@2020";
//		adminP = "publishInfo@2020";
//		adminP = "hotline@2020";
//		adminP = "fundApply@2020";
//		adminP = "fundUse@2020";
//		adminP = "done@2020";
//		adminP = "record@2020";
//		adminP = "todo@2020";
//		adminP = "freeflow@2020";
//		adminP = "ncloud@2020";
//		adminP = "doc@2020";
//		adminP = "ams@2020";
//		
		String md5 = MD5Util.getMD5(MD5Util.getMD5(adminP)+"-asop");
		System.out.println(md5);
	}
}
