/**
 * 
 */
//总共有多少个选择框
var selNums = 0;
/**
 * 
 * TODO 通过路径获取路径上的类别
 * @param class_path
 * @param type 是新增类别 还是修改类别
 * 2015年1月26日
 * @author wangcan
 */
function getCategoryPath(class_path,type){
	var categorySelect = $(".categorySelect");
	categorySelect.empty('');
	var class_id = $("#class_id").val();
	var url = "../path/"+class_path;
	$.ajax({
		url:url,
		type:'get',
		dataType:'json',
		success:function(result){
			//将选项被选中的id取出
			var class_selecteds = class_path.split('_');
			selNums = result.length;
			if(type == 'add'){
				for(var i=0;i<result.length;i++){
					var selector;
					if(i == 0)
						selector = $('<select id="bcSelector'+i+'" style="margin-bottom: 5px;" onchange=getChild("bcSelector",'+i+')></select>');
					else{
						var left = 105 + (i-1)*10;
						selector = $('<select id="bcSelector'+i+'" style="margin-bottom: 5px;margin-left:'+left+'px;"  onchange=getChild("bcSelector",'+i+')></select>');
					}
					for(var j=0;j<result[i].length;j++){
						var class_name = result[i][j].class_name!=null ?result[i][j].class_name : "";
						var class_latin= result[i][j].class_latin!=null ?result[i][j].class_latin : "";
						if(result[i][j].class_id == class_selecteds[result.length-2-i] || result[i][j].class_id == class_id){
							selector.append('<option value="'+result[i][j].class_id+'" selected="selected">'+class_name + class_latin+'</option>');
						}else{
							selector.append('<option value="'+result[i][j].class_id+'">'+class_name + class_latin+'</option>');
						}
					}
					categorySelect.append(selector);
				}
			}else if(type='edit'){
				for(var i=0;i<result.length;i++){
					var selector;
					if(i == 0)
						selector = $('<select id="bcSelector'+i+'" style="margin-bottom: 5px;" onchange=getChild("bcSelector",'+i+')></select>');
					else{
						var left = 105 + (i-1)*10;
						selector = $('<select id="bcSelector'+i+'" style="margin-bottom: 5px;margin-left:'+left+'px;"  onchange=getChild("bcSelector",'+i+')></select>');
					}
					
					if(i == result.length-1){
						selector.append('<option value="">请选择类别</option>');
					}
					
					for(var j=0;j<result[i].length;j++){
						var class_name = result[i][j].class_name!=null ?result[i][j].class_name : "";
						var class_latin= result[i][j].class_latin!=null ?result[i][j].class_latin : "";
						if(result[i][j].class_id == class_selecteds[result.length-2-i] || result[i][j].class_id == class_id && i != result.length-1){
							selector.append('<option value="'+result[i][j].class_id+'" selected="selected">'+class_name + class_latin+'</option>');
						}else{
							selector.append('<option value="'+result[i][j].class_id+'">'+class_name + class_latin+'</option>');
						}
					}
					categorySelect.append(selector);
				}
			}
			//获取最下一层的子类别
			getChild("bcSelector",result.length-1);
		}
	});
}

/**
 * TODO 当父类别选择框发生变化的时候 获取子类别并移除父类别选择框下的子选中框
 * @param selectorId 选中框的前缀
 * @param index 发生变化的选择框是第几个
 * @selNums 总共有多少个选择框
 * 2015年1月26日
 * @author wangcan
 */
function getChild(selectorId,index){
	var parent_id = index;
	var selNumsCopy = selNums;
	//移除父选择框下的子选择框
	for(var i=index+1; i<selNumsCopy; i++){
		var selector = $("#"+selectorId+i);
		selector.remove();
		--selNums;
	}
	var class_id = $("#"+selectorId+parent_id).val();
	if(class_id != ""){
		//重新加载子选择框
		$.ajax({
			url:"../category/"+class_id,
			type:'get',
			dataType:'json',
			success:function(result){
				if(result.length == 0)
					return;
				var categorySelect = $(".categorySelect");
				var left = 105 + index*10;
				var selector = $('<select id="bcSelector'+selNums+'" style="margin-bottom: 5px;margin-left:'+left+'px;"  onchange=getChild("bcSelector",'+selNums+')></select>');
				selector.append('<option value="">请选择类别</option>');
				for(var j=0;j<result.length;j++){
					var class_name = result[j].class_name!=null ?result[j].class_name : "";
					var class_latin= result[j].class_latin!=null ?result[j].class_latin : "";
					selector.append('<option value="'+result[j].class_id+'">'+class_name + class_latin+'</option>');
				}
				categorySelect.append(selector);
				//重新计算选择框的个数
				++selNums;
			}
		});
	}
}

/**
 * 获取类别路径
 */
function getClasspath(){
	var class_path="";
	for(var i=selNums-1;i>=0;i--){
		var class_id = $("#bcSelector"+i).val();
		if(class_id != ''){
			class_path += class_id + "_";
		}
	}
	//加上根类别
	class_path += 0;
	return class_path;
}