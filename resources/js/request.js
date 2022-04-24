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
function AjaxPage(sId, url) {
    var oXmlHttp = request();
    oXmlHttp.OnReadyStateChange = function() {
        if (oXmlHttp.readyState == 4) { //第四次握手开始传输数据
            if (oXmlHttp.status == 200 || oXmlHttp.status == 304) {  //200传输完毕， //304缓存资源无变化
                IncludeJS(sId, url, oXmlHttp.responseText);
            } else {
                alert('XML request error: ' + oXmlHttp.statusText + ' (' + oXmlHttp.status + ')');
            }
        }
    }
    oXmlHttp.open('GET', url, true);
    oXmlHttp.send(null);
}
/**
	动态引入js文件
 */ 
function IncludeJS(sId, fileUrl, source) {
    if ((source != null) && (!document.getElementById(sId))) {
        var oHead = document.getElementsByTagName('HEAD').item(0);
        var oScript = document.createElement("script");
        oScript.language = "javascript";
        oScript.type = "text/javascript";
        oScript.id = sId;
        oScript.defer = true;
        oScript.text = source;
        oHead.appendChild(oScript);
    }
}