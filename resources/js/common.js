/**
 * 
 */
var arrs = ['一', '二', '三', '四', '五', '六', '七', '八', '九', '十'];
var confimCompelete="确定完成?";
var confimWithdraw="是否撤回?";
function buildContentForReSearchComment(docBodyFiles){
	docBodyFiles = docBodyFiles || aschemaDoc.docBodyFile;
	if(!docBodyFiles){
		return;
	}
	var html = '';
	for(var i=0; i<docBodyFiles.length; i++){
		var objFile = docBodyFiles[i];
		if(objFile){
			var num =arrs[i];
			if(docBodyFiles.length<2){
				num="";
			}
			html += '<button style="margin-right:12px;" class="btn btn-primary" pdfUrl="' + objFile.accessPath + '" onclick="changeSrc(this);" >正文' + num + '</button>';
			pdfUrl = objFile.accessPath;
		}
	}
	if(aschemaDoc && aschemaDoc.docRelationFile){
		
	html += initRelationRecv();
	}
	
	$('#contentTitleId').empty();
	$('#contentTitleId').html(html);
	
	setPdfUrl(pdfUrl);
}
function changeSrc(that){
	var url = $(that).attr('pdfUrl');
	setPdfUrl(url);
	setTimeout(function(){
		window.pdfViewer.fSetScale_V();
	},1000);
}
function setPdfUrl(pdfUrl){
	if(pdfUrl){
		$("#pdfViewer").attr('src','/doc/doc/js/pdfjs/web/viewer.html?file=' + pdfUrl);
	}
}
function initDocNo(){
	$("#docNo").blur(function(){
		loadDocNo_init();
	});
	//下拉框改变事件
	$("#yearSelect").change(function(){
		loadDocNo_init();
	});
}

function loadDocNo_init() {
	var docNo = $('#docNo').val();
	if(stringIsEmpty(docNo)){
		return false;
	}
	var url = appName + "/docReceiveExtend/loadGovRelationReceive.do";
	var obj = {};
	obj.docSendId = docReceive.docSendId;
	obj.docReceiveId = docReceive.id;
	obj.docNo = docNo;

	var year = $("#yearSelect").val();
	if(!year){
		var myDate = new Date();
		year = myDate.getFullYear();
	}

	obj.year = year;
	window.top.layer.load(1, {
		shade: [0.1,'#000'],
		shadeClose: false
	});
	ajaxPost(url,obj,function(msg){
		debugger;
		if(msg){
			//aschemaDoc.docRelationFile = [];
			//docReceive.docRelationFile = [];
			var  docRelationFiles =  msg.contents;
			aschemaDoc.docRelationFile = docRelationFiles;
			docReceive.docRelationFile = docRelationFiles;
			buildContentForReSearchComment();
			/*var html = initRelationRecv();
            $("#contentTitleId").append(html);*/
		}else{
			aschemaDoc.docRelationFile = null;
			docReceive.docRelationFile = null;
			buildContentForReSearchComment();
		}
		layerCommonUtil.closeLoading();
	});
}

function bindDocNo_fileScan(){
	$("#docNo").blur(function(){
		loadDocNo_fileScan();
	});
	$("#yearSelect").change(function(){
		loadDocNo_fileScan();
	});
}

/**
 * 加载文号
 * @returns {boolean}
 */
function loadDocNo_fileScan() {
	var docNo = $('#docNo').val();
	if(stringIsEmpty(docNo)){
		return false;
	}
	var url = appName + "/docReceiveExtend/loadGovRelationReceive.do";
	var obj = {};
	obj.docNo = docNo;
	var year = $("#yearSelect").val();
	if(!year){
		var myDate = new Date();
		year = myDate.getFullYear();
	}
	obj.year = year;
	window.top.layer.load(1, {
		shade: [0.1,'#000'],
		shadeClose: false
	});
	ajaxPost(url,obj,function(msg){
		if(msg){
			var  docRelationFiles =  msg.contents;
			$(docRelationFiles).each(function(i){
				var fileObj = docRelationFiles[i];debugger
				if(fileObj.id){
					
					fileObj.refId = fileObj.id;
					fileObj.refType = "1";
					fileObj.id = "";
				}
				fileObj.accessPath=fileObj.accessPath.replace(/10.171.251.241/, "192.12.200.109");
				//fileObj.accessPath=fileObj.accessPath.replace(/192.12.200.109/, "10.171.251.241");//=http://192.12.200.109:8081/doc/files/cata/90/1289116552431525890.pdf
				console.log(fileObj.accessPath);
			
			})
			
			docRelationFile = docRelationFiles;
		}else{
			docRelationFile = null;
		}
		layerCommonUtil.closeLoading();
	});
}

function initRelationRecv(){debugger
	var html = '';
	var docRelationFiles = aschemaDoc.docRelationFile;
	
	if(docRelationFiles && docRelationFiles.length > 0){
		for(var i=0;i<docRelationFiles.length;i++){
			var objFile = docRelationFiles[i];
			html += '<button style="margin-right:12px;" class="btn btn-primary" pdfUrl="' + objFile.accessPath + '" onclick="changeSrc(this);" >相关收文'+(i+1)+'</button>';
		
		}
	}
	return html;
}
function stringIsEmpty(str){
	if(!str){
		return true;
	}
	if(str == ''){
		return true;
	}
	if(str == null){
		return true;
	}
	if(str == undefined){
		return true;
	}
	if(!str.trim()){
		return true;
	}
	return false;
}
/**
 * 构建流程记录信息
 * @returns
 */
function buildFlowRecord_bak(){
	var flowRecord = {};
	flowRecord.todoId = docReceive ? docReceive.id : '';
	flowRecord.role = activityRole;
	flowRecord.sheetStatus = '1';
	var opinion = $('#' + activityRole).text();
	opinion = fToEscape_S(opinion);
	debugger
	var clearOpinion = clearBr(opinion);
	if(null ==clearOpinion ||""==clearOpinion){
		flowRecord.role = "proposedOpinions";
		opinion = $('#proposedOpinions').text();
		opinion = fToEscape_S(opinion);
	}
	flowRecord.opinion = opinion;
	return flowRecord;
}
function buildFlowRecord(){
	var flowRecord = {};
	flowRecord.todoId = docReceive ? docReceive.id : '';
	flowRecord.sheetStatus = '1';
	var opinion = buildFlowOpinion_P();
	flowRecord.role = activityRole;
	opinion = fToEscape_S(opinion);
	if(null ==opinion ||""==opinion){
		flowRecord.role = "proposedOpinions";
		opinion = $('#proposedOpinions').text();
		opinion = fToEscape_S(opinion);
	}
	flowRecord.opinion = opinion;
	return flowRecord;
}
//去除换行 
function clearBr(key) { 
	key = key.replace(/<\/?.+?>/g,""); 
	key = key.replace(/[\r\n]/g, ""); 
	key = key.replace(/\s+/g, ""); 
	return key; 
} 
function buildFlowOpinion_P(){
	var opinion ="";
	$(".opinion").each(function(i,obj){
		opinion = $(obj).text();
		opinion && (opinion = $.trim( fToEscape_S(opinion))) ;
		if( clearBr(opinion)){
			activityRole = $(obj).attr("id");
			return false;
		}
	});
	return opinion;
	
}

function openSucessTipAndRefreshList(){
	layerCommonUtil.success("操作成功",function(){
		layer.closeAll();
		window.close();
		if(window.opener){
			window.opener.fListContents_V();
		}
	});
}

function openSucessTip(noParent){
	debugger;
	
	if(noParent){
		layerCommonUtil.success("操作成功",function(){
			layer.closeAll();
			window.close();
			if(window.opener){
				//window.opener.fListContents_V();
				window.opener.location.reload();
				//window.opener.parent.changeToDone();
			}
		});
	} else {
		layerCommonUtil.success("操作成功",function(){
			parent.layer.closeAll();
			if($("#scanFile").val()=="1"){
				window.close();
			}
			//window.parent.changeToDone();
			//window.parent.fListContents_V();//
			window.parent.reloadPage();
		});
		
	}
}
function openSucessTip_PBD(noParent){
	debugger;
	
	if(noParent){
		layer.confirm("操作成功，是否打印批办单?", {
			btn : [ '是', '否' ], // 按钮
			shade : false
			// 不显示遮罩
		}, function(index) {
			withdrawMeetingRecv(receiveId)
		},function(index){
			layer.closeAll();
			window.close();
			if(window.opener){
				window.opener.location.reload();
				//window.opener.parent.changeToDone();
			}
		});
		
		layerCommonUtil.success("操作成功",function(){
			layer.closeAll();
			window.close();
			if(window.opener){
				window.opener.location.reload();
				//window.opener.parent.changeToDone();
			}
		});
	} else {
		layerCommonUtil.success("操作成功",function(){
			parent.layer.closeAll();
			if($("#scanFile").val()=="1"){
				window.close();
			}
			//window.parent.changeToDone();
			window.parent.reloadPage();
		});
		
	}
}
function openSucessTip_bak(noParent){
	debugger;
	
	if(noParent){
		layer.alert('&nbsp;&nbsp;&nbsp;&nbsp;操作成功', {
		  skin: 'layui-layer-lan' //样式类名
		  ,closeBtn: 0
		}, function(){
			layer.closeAll();
			window.close();
			if(window.opener){
				window.opener.location.reload();
			}
		});
	} else {
		parent.layer.alert('&nbsp;&nbsp;&nbsp;&nbsp;操作成功', {
		  skin: 'layui-layer-lan' //样式类名
		  ,closeBtn: 0
		}, function(){
			parent.layer.closeAll();
			if($("#scanFile").val()=="1"){
				window.close();
			}
			window.parent.reloadPage();
		});
	}
	/*parent.layer.msg('操作成功', {
	    time: 3000, //3s后自动关闭
	    shadeClose: false,
		shade: 0.8,
		title:'提示',
	    btn: ['关闭', '确定']
	});*/
	
	//parent.layer.alert('操作成功');
}
function initReceipt(){
	if(isDept){
		$('#isReceipt').show();
		
	} else {
		$('#isReceipt').hide();
		
	}
	initQZPSAndDQPS();
	initNeedLeaderSelfSignRead();
}
function initNeedLeaderSelfSignRead(){debugger
	if(!isDept && typeof isZhfb != "undefined" && (isZhfb ==true || isZhfb =="true")){
		$('#isNeedLeaderSelfSignRead').show();
	}else{
		$('#isNeedLeaderSelfSignRead').hide();
	}
}
function initQZPSAndDQPS(){
	if(isDept && curDeptId && "1152477503830659074"==curDeptId){
		$('#isQZPS').show();
//		$('#isDQPS').show();
	}else{
		$('#isQZPS').hide();
		$('#isDQPS').hide();
	}
}
function bindQZPSAndDQPS(){
	$("#isQZPS").click(function(){              
		
		isCheckedQZPS = !isCheckedQZPS;
		//shortcutSetCheckDept("1164448999676792833",isCheckedQZPS); 
		//2021-3-22 葛琦的帐号，领导签批完，对外转发时，选择单位列表，会出现一个【区长批示】的选项，
		//选中会给督查室科长也发送一篇该公文。以前督查室科长是洪跃，现在变成李玉雷了
		//shortcutSetCheckDept("1306859477186265089",isCheckedQZPS);
		
		//2021-3-31 有个bug，搜索树之后，树列表中如果没有区政府办督查室-李玉雷，点击【区长批示】没反应
		//测试环境
		//shortcutSetCheckDept_new("1377166069495881729",isCheckedQZPS,"区政府办督查室-李玉雷");
		//正式环境
		shortcutSetCheckDept_new("1306859477186265089",isCheckedQZPS,"区政府办督查室-李玉雷");
	}) ;
	$("#isDQPS").click(function(){              
		
		isCheckedDQPS = !isCheckedDQPS;
	//	shortcutSetCheckDept("1164439510303068162",isCheckedDQPS);  
		shortcutSetCheckDept_new("1164439510303068162",isCheckedQZPS,"区政府办文秘科-王瑞");
	}) ;
}
function initShortCutBtn(){
	if(isDept){
		$('.shortCutBtn').hide();
	}else{
		if(curLoginName=='dongxiaoqi'){
			$('.shortCutBtn').show();
			$('#researchCommentId').show();
			$('.shortCutBtn_DXQ').hide();
		} else if(curLoginName=='maguokai'){
			$('.shortCutBtn').show();
			$('.shortCutBtn_KZ').hide();
			$('.shortCutBtn_DXQ').show();
			$('#researchCommentId').show();
		} else if(curLoginName=='geqi'){
			$('.shortCutBtn').show();
			$('#researchCommentId').hide();
			$('.shortCutBtn_DXQ').hide();
		}else{
			$('.shortCutBtn').hide();
			$('.shortCutBtn_DXQ').hide();
			$('#researchCommentId').hide();
		}
	}
}
function formatDateTime(formatTime, dateTime){
	if(!dateTime){
		return '';
	}
	formatTime = formatTime.replace(formatTime.substring(0, 4), dateTime.substring(0, 4));
	formatTime = formatTime.replace(formatTime.substring(5, 7), dateTime.substring(4, 6));
	formatTime = formatTime.replace(formatTime.substring(8, 10), dateTime.substring(6, 8));
	if(dateTime.length == 14){
		formatTime = formatTime.replace(formatTime.substring(11, 13), dateTime.substring(8, 10));
		formatTime = formatTime.replace(formatTime.substring(14, 16), dateTime.substring(10, 12));
		formatTime = formatTime.replace(formatTime.substring(17, 19), dateTime.substring(12, 14));
	}
	
	return formatTime;
}
//获取当前时间，格式YYYY-MM-DD
function getNowFormatDate() {
    var date = new Date();
    var seperator = "-";
    var year = date.getFullYear();
    var month = date.getMonth() + 1;
    var strDate = date.getDate();
    if (month >= 1 && month <= 9) {
        month = "0" + month;
    }
    if (strDate >= 0 && strDate <= 9) {
        strDate = "0" + strDate;
    }
    var currentdate = year + seperator + month + seperator + strDate;
    return currentdate;
}
function downLoadDocByUrl(url, fileName){
	parent.layerCommonUtil.loading();
	if(isIE()){
		window.open(url);
		parent.layerCommonUtil.closeLoading();
	}
	fileName = fileName ? fileName : url.split("/").pop();
	var xhr = new XMLHttpRequest();
	xhr.open('GET', url, true);//get请求，请求地址，是否异步
	xhr.responseType = "blob";    // 返回类型blob
	xhr.onload = function () {// 请求完成处理函数
		if (this.status === 200) {
			var blob = this.response;// 获取返回值
			var a = document.createElement('a');
			a.download = fileName;
			a.href=window.URL.createObjectURL(blob);
			if(navigator.userAgent.indexOf("Firefox")>0){
				//火狐浏览器
				document.body.appendChild(a)
				a.click();
				document.body.removeChild(a)
			}else{
				a.click();
			}
			parent.layerCommonUtil.closeLoading();
	    }
	};
	// 发送ajax请求
	xhr.send();
}
function downLoadDoc(that, fileName){
	parent.layerCommonUtil.loading();
	var url = $(that).attr('pdfUrl');
	if(!url){
		return false;
	}
	if(isIE()){
		window.open(url);
		parent.layerCommonUtil.closeLoading();
	}
	fileName = fileName ? fileName : url.split("/").pop();
	var xhr = new XMLHttpRequest();
	xhr.open('GET', url, true);//get请求，请求地址，是否异步
	xhr.responseType = "blob";    // 返回类型blob
	xhr.onload = function () {// 请求完成处理函数
		if (this.status === 200) {
			var blob = this.response;// 获取返回值
			var a = document.createElement('a');
			a.download = fileName;
			a.href=window.URL.createObjectURL(blob);
			if(navigator.userAgent.indexOf("Firefox")>0){
				//火狐浏览器
				document.body.appendChild(a)
				a.click();
				document.body.removeChild(a)
			}else{
				a.click();
			}
			parent.layerCommonUtil.closeLoading();
	    }
	};
	// 发送ajax请求
	xhr.send();
}

function isIE() {
	 if (!!window.ActiveXObject || "ActiveXObject" in window)
	  return true;
	  else
	  return false;
	 }
Array.prototype.remove = function(val) {
	var index = this.indexOf(val); 
	if (index > -1) {
		this.splice(index, 1); 
	}  
}; 

function getQueryVariable(variable){
       var query = window.location.search.substring(1);
       var vars = query.split("&");
       for (var i=0;i<vars.length;i++) {
               var pair = vars[i].split("=");
               if(pair[0] == variable){return pair[1];}
       }
       return(false);
}
if (!Array.prototype.indexOf){
	  Array.prototype.indexOf = function(elt /*, from*/){
	    var len = this.length >>> 0;

	    var from = Number(arguments[1]) || 0;
	    from = (from < 0)
	         ? Math.ceil(from)
	         : Math.floor(from);
	    if (from < 0)
	      from += len;

	    for (; from < len; from++){
	      if (from in this && this[from] === elt)
	        return from;
	    }
	    return -1;
	  };
	}

/*
 * jquery 初始化form插件，传入一个json对象，为form赋值 
 * version: 1.0.0-2013.06.24
 * @requires jQuery v1.5 or later
 * Copyright (c) 2013
 * note:  1、此方法能赋值一般所有表单，但考虑到checkbox的赋值难度，以及表单中很少用checkbox，这里不对checkbox赋值
 *		  2、此插件现在只接收json赋值，不考虑到其他的来源数据
 *		  3、对于特殊的textarea，比如CKEditor,kindeditor...，他们的赋值有提供不同的自带方法，这里不做统一，如果项目中有用到，不能正确赋值，请单独赋值
 */	
(function($){
	$.fn.extend({
		initForm:function(options){
			//默认参数
			var defaults = {
				jsonValue:"",
				exclude:[],     //不需要进行初始化的name,将name字符串数组传入
				isDebug:false	//是否需要调试，这个用于开发阶段，发布阶段请将设置为false，默认为false,true将会把name value打印出来
			}
			//设置参数
			var setting = $.extend({}, defaults, options);
			var form = this;
			jsonValue = setting.jsonValue;
			//如果传入的json字符串，将转为json对象
			if($.type(setting.jsonValue) === "string"){
				jsonValue = $.parseJSON(jsonValue);
			}
			//如果传入的json对象为空，则不做任何操作
			if(!$.isEmptyObject(jsonValue)){
				var debugInfo = "";
				$.each(jsonValue,function(key,value){
					//是否开启调试，开启将会把name value打印出来
					if(setting.isDebug){
						//alert("name:"+key+"; value:"+value);
						debugInfo += "name:"+key+"; value:"+value+" || ";
					}
					if(setting.exclude.indexOf(key)==-1){
						
					var formField = form.find("[name='"+key+"']");
					if($.type(formField[0]) === "undefined"){
						if(setting.isDebug){
							alert("can not find name:["+key+"] in form!!!");	//没找到指定name的表单
						}
					} else {
							var fieldTagName = formField[0].tagName.toLowerCase();
							if(fieldTagName == "input"){
								if(formField.attr("type") == "radio"){
									$("input:radio[name='"+key+"'][value='"+value+"']").attr("checked","checked");
								} else if(formField.attr("type") == "checkbox"){
									
								} else {
									formField.val(value);
								}
							} else if(fieldTagName == "select"){
								//do something special
								formField.val(value);
							} else if(fieldTagName == "textarea"){
								//do something special
								formField.val(value);
							} else if(fieldTagName == "div"){
								formField.html(value);
							} else {
								formField.val(value);
							}
					   }
					}
				})
				if(setting.isDebug){
					alert(debugInfo);
				}
			}
			return form;	//返回对象，提供链式操作
		}
	});
})(jQuery)


function renderPage(num) {
	pageRendering = true;
	pdfDoc.getPage(num).then(function(page) {
		var viewport = page.getViewport(scale);
		canvas.height = viewport.height
		canvas.width = viewport.width;
		var renderContext = {
			canvasContext : ctx,
			viewport : viewport
		};
		var renderTask = page.render(renderContext);
		renderTask.promise.then(function() {
			pageRendering = false;
			if (pageNumPending !== null) {
				// New page rendering is pending
				renderPage(pageNumPending);
				pageNumPending = null;
			}
		});
	});
	document.getElementById('page_num').textContent = pageNum;
}
function queueRenderPage(num) {
	if (pageRendering) {
		pageNumPending = num;
	} else {
		renderPage(num);
	}
}
function onPrevPage() {
	if (pageNum <= 1) {
		return;
	}
	pageNum--;
	queueRenderPage(pageNum);
}

function onNextPage() {
	if (pageNum >= pdfDoc.numPages) {
		return;
	}
	pageNum++;
	queueRenderPage(pageNum);
}

function initPdf() {
	var pdfUrl = '';
	var paths = pdfUploadPath.split(splitStr);
	var newPaths = new Array();
	var html='';
	for(var i=0; i<paths.length; i++){
		var path = paths[i];
		var objPath = fileObj.get(path);
		if(objPath){
			if(i==0){
				pdfUrl = objPath.accessPath;
			}
			var pdfAccessPath = buildPdfViewPath(objPath.accessPath);
			html += '<button style="margin-right:12px;" class="btn btn-primary" pdfUrl="' +pdfAccessPath + '" onclick="changeSrc(this);" >正文' + arrs[i] + '</button>';
		}
	}
	if(paths.length>1){
		$('#contentTitleId').empty();
		$('#contentTitleId').html(html);
		$("#pdfViewer").css("height", $(window).height() - 100);
	}
	var viewUrl = appName + '/doc/js/pdfjs/web/viewer.html?file=';
	if(!pdfUrl) {
		$("#pdfViewer").attr('src', viewUrl);
		return;
	}
	pdfUrl = viewUrl + buildPdfViewPath(pdfUrl);
	$("#pdfViewer").attr('src',pdfUrl);
}
function buildPdfViewPath(pdfUrl){
	var fileName = ''
	var index = pdfUrl.indexOf('=');
	if(index != -1){
		fileName = pdfUrl.substring(index + 1, pdfUrl.length);
		var preFix = filePrefix;
		preFix += '/temp/' + fileName;
		return preFix;
	}else{
		return pdfUrl;
	}
}
function fValidateSigleInput_O(id, tip){
	var str = $('#' + id).val();
	if(!str){
		layerCommonUtil.error(tip);
		$('#' + id).focus();
		return false;
	}
	return true;
}

function fValidateSigleDiv_O(id, tip){
	var str = $('#' + id).text();
	if(!str){
		layerCommonUtil.error(tip);
		$('#' + id).focus();
		return false;
	}
	return true;
}
function commonInit(){
	bindEnter();
}
function bindEnter(){
	$('#docTitle').bind('keyup', function(event) {
		if (event.keyCode == "13") {
		　　　　//回车执行查询
			fListContents_V();
		}
	});
	$('#docNo').bind('keyup', function(event) {
		if (event.keyCode == "13") {
		　　　　//回车执行查询
			fListContents_V();
		}
	});
	$('#title').bind('keyup', function(event) {
		if (event.keyCode == "13") {
		　　　　//回车执行查询
			fListContents_V();
		}
	});
	$('#fromUnitNameName').bind('keyup', function(event) {
		if (event.keyCode == "13") {
		　　　　//回车执行查询
			fListContents_V();
		}
	});
		
}
function deleteDoc(receiveId,removeType,type){debugger
	
	layer.confirm('您确认要删除吗?', {
		btn : [ '确认', '取消' ], // 按钮
		shade : false
	// 不显示遮罩
	}, function(index) {
		var url ='';
		if(type =="doc"){
			url = appName+"/docReceiveExtend/removeTodoOrDone.do";
		}else if(type =="meeting"){
			url = appName+"/meetingReceiveExtend/removeTodoOrDone.do";
		}else if(type =="briefing"){
			url = appName+"/briefingReceiveExtend/removeTodoOrDone.do";
		}
		if(url){
			var obj={};
			obj.receiveId=receiveId;
			obj.removeType =removeType;
			fListAfterPostAjax_V(url,obj);
			
			layer.close(index);
		}
	});
	
	
}
//status;//状态  0:草稿 1:办理中 2:办理完成 3:归档 4:撤回 5:退回 9:删除 -1:待发 10:彻底删除 
function deleteSendDoc(sendId,type){
	updateSend(sendId,type,"9","删除");
}
function deleteThroughSendDoc(sendId,type){
	updateSend(sendId,type,"10","彻底删除");
}
function restoreSendDoc(sendId,type){
	updateSend(sendId,type,"4","还原");
}
function updateSend(sendId,type,status,msg){
	layer.confirm('您确认要'+msg+'吗?', {
		btn : [ '确认', '取消' ], // 按钮
		shade : false
	// 不显示遮罩
	}, function(index) {
		var url ='';
		if(type =="doc"){
			url = appName+"/docSendExtend/updateSend.do";
		}else if(type =="meeting"){
			url = appName+"/meetingSendExtend/updateSend.do";
		}else if(type =="briefing"){
			url = appName+"/briefingExtend/updateSend.do";
		}
		if(url){
			var obj={};
			obj.sendId=sendId;
			obj.status =status;
			fListAfterPostAjax_V(url,obj);
			
			layer.close(index);
		}
	});
}
function deleteDocs(removeType,type){
	var ids = new Array();  
	$('input[name="receiveIds"]:checked').each(function(){  
		ids.push($(this).val());//向数组中添加元素  
	}); 
	var len = ids.length;
	if (!len) {
		layerCommonUtil.error("请选择待删除内容!");
		return;
	}
	
	layer.confirm('您确认要删除吗?', {
		btn : [ '确认', '取消' ], // 按钮
		shade : false
	// 不显示遮罩
	}, function(index) {
		
		var url ='';
		if(type =="doc"){
			url = appName+"/docReceiveExtend/removeTodoOrDones.do";
		}else if(type =="meeting"){
			url = appName+"/meetingReceiveExtend/removeTodoOrDones.do";
		}else if(type =="briefing"){
			url = appName+"/briefingReceiveExtend/removeTodoOrDones.do";
		}
		if(url){
			var obj={};
			obj.receiveIds=JSON2.stringify(ids);
			obj.removeType =removeType;
			fListAfterPostAjax_V(url,obj);
			
			layer.close(index);
		}
	});
	
	
}
function restoreDoc(receiveId,type){debugger
	
	layer.confirm('您确认要还原吗?', {
		btn : [ '确认', '取消' ], // 按钮
		shade : false
	// 不显示遮罩
	}, function(index) {
		var url ='';
		if(type =="doc"){
			url = appName+"/docReceiveExtend/restoreTodoOrDone.do";
		}else if(type =="meeting"){
			url = appName+"/meetingReceiveExtend/restoreTodoOrDone.do";
		}else if(type =="briefing"){
			url = appName+"/briefingReceiveExtend/restoreTodoOrDone.do";
		}
		if(url){
			var obj={};
			obj.receiveId=receiveId;
			layerCommonUtil.loading();
			ajaxPost(url,obj,function(msg){
				debugger;
				layerCommonUtil.closeLoading();
				if(msg.errorMsg){
					layerCommonUtil.error(msg.errorMsg);
				}else{
					layerCommonUtil.success(msg,function(){
						fListContents_V(msg);//重新加载
					});		
					
				}
			});
			
			
		}
	});
}	
function removeThorough(receiveId,type){
	
	layer.confirm('您确认要彻底删除吗?', {
		btn : [ '确认', '取消' ], // 按钮
		shade : false
	// 不显示遮罩
	}, function(index) {
		var url ='';
		if(type =="doc"){
			url = appName+"/docReceiveExtend/removeThorough.do";
		}else if(type =="meeting"){
			url = appName+"/meetingReceiveExtend/removeThorough.do";
		}else if(type =="briefing"){
			url = appName+"/briefingReceiveExtend/removeThorough.do";
		}
		if(url){
			var obj={};
			obj.receiveId=receiveId;
			fListAfterPostAjax_V(url,obj);
			
			layer.close(index);
		}
	});
	
		
}
function removeThoroughs(type){
	var ids = new Array();  
	$('input[name="receiveIds"]:checked').each(function(){  
		ids.push($(this).val());//向数组中添加元素  
	}); 
	var len = ids.length;
	if (!len) {
		layerCommonUtil.error("请选择待删除内容!");
		return;
	}
	
	layer.confirm('您确认要彻底删除吗?', {
		btn : [ '确认', '取消' ], // 按钮
		shade : false
	// 不显示遮罩
	}, function(index) {
		var url ='';
		if(type =="doc"){
			url = appName+"/docReceiveExtend/removeThoroughs.do";
		}else if(type =="meeting"){
			url = appName+"/meetingReceiveExtend/removeThoroughs.do";
		}else if(type =="briefing"){
			url = appName+"/briefingReceiveExtend/removeThoroughs.do";
		}
		if(url){
			var obj={};
			obj.receiveIds=JSON2.stringify(ids);
			fListAfterPostAjax_V(url,obj);
			
			layer.close(index);
		}
	});
	
	
}
function closePage(){
	layer.closeAll();
	window.close();
	if(window.opener){
		window.opener.location.reload();
	}
}
function fToggleAll_V_Doc(obj){
  	if($(obj).attr("checked")){
  		$("input[type=checkbox][name=receiveIds]").attr("checked",true);
  	}else{
  		$("input[type=checkbox][name=receiveIds]").attr("checked",false);
  	}
  }

function initBatchDeleteBtn(){
	if(isZhfb){
		$('#batchDeleteBtn').show();
	} else {
		$('#batchDeleteBtn').hide();
	}
	
}
function delTodoSend(type,sendId){
	var url = appName+"/docExtend/updateSend.do";
	var obj={};
	obj.sendId = sendId;
	obj.docType=type;
	obj.status="9";
	ajaxPost(url,obj,function(msg){
		
	})
}
function delDraft(id,type){
	
	layer.confirm('草稿删除后，无法还原，您确认要删除吗?', {
		btn : [ '确认', '取消' ], // 按钮
		shade : false
// 不显示遮罩
	}, function(index) {
		var url ='';
		if(type =="doc"){
			url = appName+"/docSend/removeById.do";
		}else if(type =="meeting"){
			url = appName+"/meetingSend/removeById.do";
		}else if(type =="briefing"){
			url = appName+"/briefingSend/removeById.do";
		}
		if(url){
			var obj={};
			obj.id=id;
			fListAfterPostAjax_V(url,obj);
			
			layer.close(index);
		}
	});
}




function docAttachView(that,isDownload) {//公文附件预览

	var fileObj = {};
	fileObj.fileName =  $(that).attr("fileName");
	fileObj.accessPath = $(that).attr("accessPath");
	fileObj.filePath = $(that).attr("filePath");

	var filePath = fileObj.filePath;
	fileObj.suffix = filePath.substring(filePath.lastIndexOf("."));
	debugger;
	if("1" == isDownload){
		//流程附件预览
		$.ajax({
			url:appName+"/docExtend/flowFileDownload.do",
			async:false,
			dataType:"JSON",
			type:"GET",
			data:{"info":JSON.stringify(fileObj),"ajax":"1"},
			success:function (msg) {
				docAttachViewExtend(msg);
			}
		})
	}else{
		docAttachViewExtend(fileObj);
	}


}


/**
 * 公文附件预览
 */
function docAttachViewExtend(fileObj) {
	var pdfSuffix = ".pdf.PDF";
	var otherSuffix = ".xls.xlsx.doc.docx";
	var imgSuffix = ".bmp.jpg.png.gif.webp";

	var suffix = fileObj.suffix;
	var accessPath = fileObj.accessPath;
	if(pdfSuffix.indexOf(suffix) > -1){
		//pdf处理
		buildDocAttachView(accessPath)
	}else if(otherSuffix.indexOf(suffix) >-1){
		docAttach2File(fileObj);
	}else if(imgSuffix.indexOf(suffix) >-1){
		buildDocImgView(accessPath);
	}else{
		layerCommonUtil.error("仅支持Word、Excel、PDF")
	}




}

/**
 * 附件临时文件转换
 * @param fielObj 文件对象
 */
function docAttach2File(fielObj) {
	var url = appName + "/docExtend/docAttachView.do";
	var obj = {};
	obj.fileInfo = JSON.stringify(fielObj);
	parent.layerCommonUtil.loading();
	ajaxPost(url,obj,function (msg) {
		if(msg.errorMsg){
			parent.layerCommonUtil.closeLoading();
			layerCommonUtil.error(msg.errorMsg);
			return ;
		}else{
			buildDocAttachView(msg.accessPath);
		}

	})
}

/**
 * 构建附件视图
 */
function buildDocAttachView(url) {
	if($("#pdfShowView").length <= 0) {
		var html = "";
		html+='<div id="pdfShowView" style="display: none;height: 100%">';
		html+='<iframe id="docAttachViewer" style="width: 99%;height: 97%"></iframe>';
		html+='</div>';
		$("body").append(html);
	}
	var pdfViewUrl = "/doc/doc/js/pdfjs/web/viewer.html?file="+url;
	$("#docAttachViewer").attr("src",pdfViewUrl);

	window.setTimeout(function () {
		parent.layer.open({
			type: 1,
			content: $('#pdfShowView'),
			area: ['60%', '97%'],
			title:"附件预览"
		});
		parent.layerCommonUtil.closeLoading();
	},300)
}

/**
 * 图片展示
 * @param url
 */
function buildDocImgView(url) {
	if($("#imgShowView").length <= 0) {
		var html = "";
		html+='<div id="imgShowView" style="display: none;height: 100%">';
		html+='<img id="docAttachViewerImg" style="width: 99%;height: 97%" "/>';
		html+='</div>';
		$("body").append(html);
	}
	$("#docAttachViewerImg").attr("src",url);
	$("#docAttachViewerImg").attr("data-original",url);

	new Viewer(document.getElementById('imgShowView'), {
		url: "data-original",
	});

	$("#docAttachViewerImg").click();

}

/**
 * 流程附件下载
 */
function downloadFlowFile(that) {
	var fileObj = {};
	fileObj.fileName =  $(that).attr("fileName");
	fileObj.accessPath = $(that).attr("accessPath");
	fileObj.filePath = $(that).attr("filePath");

	var filePath = fileObj.filePath;
	fileObj.suffix = filePath.substring(filePath.lastIndexOf("."));
	layerCommonUtil.loading();
	var url = appName+"/docExtend/flowFileDownload.do";
	ajaxPost(url,{"info":JSON.stringify(fileObj)},function (msg) {
		layerCommonUtil.closeLoading();
		var url = msg.accessPath;
		var fileName = msg.fileName;
		if(isIE()){
			window.open(url);
		}
		fileName = fileName ? fileName : url.split("/").pop();
		var xhr = new XMLHttpRequest();
		xhr.open('GET', url, true);//get请求，请求地址，是否异步
		xhr.responseType = "blob";    // 返回类型blob
		xhr.onload = function () {// 请求完成处理函数
			if (this.status === 200) {
				var blob = this.response;// 获取返回值
				var a = document.createElement('a');
				a.download = fileName;
				a.href=window.URL.createObjectURL(blob);
				a.click();
			}
		};
		// 发送ajax请求
		xhr.send();
	})
}
function judgeCurUser(loginName){
		var url = appName+"/login/judgeCurUser.do";
		var obj ={};
		obj.loginName =loginName;
		ajaxPost(url,obj,function(msg){debugger
			if(!msg.errorMsg){
				if("-1" == msg){
					parent.layerCommonUtil.success("检测到当前用户已变更，刷新页面",function(){
						
						window.parent.location.reload();
					});
					
				}
			}else{
				parent.layerCommonUtil.error(msg.errorMsg);
			}
		});

}
function judgeCurUser_Close(loginName){
	var url = appName+"/login/judgeCurUser.do";
	var obj ={};
	obj.loginName =loginName;
	ajaxPost(url,obj,function(msg){debugger
		if(!msg.errorMsg){
			if("-1" == msg){
				parent.layerCommonUtil.error("检测到当前用户已变更，将不能继续办文",function(){
					
				window.close();
				});
				
			}
		}else{
			parent.layerCommonUtil.error(msg.errorMsg);
		}
	});

}