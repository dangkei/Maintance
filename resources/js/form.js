/**
 *  IE8 Array不支持forEach()扩展
 */
if (typeof Array.prototype.forEach != 'function') {
    Array.prototype.forEach = function(callback){
      for (var i = 0; i < this.length; i++){
        callback.apply(this, [this[i], i, this]);
      }
    };
}
/*
*	json填充form表单
*/ 
var renderInput = function(jsonData){
	for(key in jsonData){
		$("input[name="+key+"]").val(jsonData[key]);
	}
}

Object.prototype.Type=function(){
	var type = typeof(this);
	1.String

2.Number

3.Boolean

4.Object

5.Function

6.undefined
}

