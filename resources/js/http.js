/**
 * 获取HttpRequest对象兼容IE&FX
 */
var request = function() {
    if (window.XMLHttpRequest) // Gecko
        return new XMLHttpRequest();
    else if (window.ActiveXObject) // IE
        return new ActiveXObject("MsXml2.XmlHttp");
}
/**
   	sId jsdom id  
	url js文件scr
 */
function AjaxPage(sId, url,callback) {
    var oXmlHttp = request();
    oXmlHttp.OnReadyStateChange = function() {
        if (oXmlHttp.readyState == 4) { //第四次握手开始传输数据
            if (oXmlHttp.status == 200 || oXmlHttp.status == 304) {  //200传输完毕， //304缓存资源无变化
				if(typeof callback==function){
					callback(oXmlHttp.responseText);
				}
                //IncludeJS(sId, url, oXmlHttp.responseText);
            } else {
                alert('XML request error: ' + oXmlHttp.statusText + ' (' + oXmlHttp.status + ')');
            }
        }
    }
    oXmlHttp.open('GET', url, true);
    oXmlHttp.send(null);
}