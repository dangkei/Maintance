/**
 * 处理流程中审批意见
 */
function buildApproval(action){
	var role = action.roleShortname;
	var opinion = action.opinion;
	opinion = opinion || '';
	if(null ==opinion ||"" ==opinion){
		return;
	}
	var time=action.createTime;
	var st=formateTime(time);
	st =st.substring(0,10);
	var html='';
	html+='<div style="text-align:left;">';
	html+='<img width="18" height="18" src="'+appName+'/contract/customizeJxj/images/closed.png">';
	html+='&nbsp;'+opinion+'&nbsp;&nbsp;&nbsp;'+action.operatorName+"/"+st;
	html+='</div>';
	
	
	if(role){
		if(role.indexOf('personInCharge')>-1){
			$('#personInCharge').before(html);
		} else if(role.indexOf('branchLeader')>-1){
			$('#branchLeader').before(html);
		} else if(role.indexOf('leader')>-1){
			$('#leader').before(html);
		}	else if(role.indexOf('legalAffairs')>-1){
			$('#legalAffairs').before(html);
		} else if(role.indexOf('financialRoom')>-1){
			$('#financialRoom').before(html);
		} else if(role.indexOf('contractManager')>-1){
			$('#contractManager').before(html);
		}
	}
}