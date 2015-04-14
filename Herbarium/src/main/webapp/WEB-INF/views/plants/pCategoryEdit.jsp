<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="franklin">
<title>修改类别</title>
<style type="text/css">

</style>
	<!-- Bootstrap Core CSS -->
    <link href="<c:url value="/resources/css/boot/css/bootstrap.min.css"/>" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="<c:url value="/resources/css/boot/css/plugins/metisMenu/metisMenu.min.css"/>" rel="stylesheet">
   
    <!-- Custom CSS -->
    <link href="<c:url value="/resources/css/boot/css/sb-admin-2.css"/>" rel="stylesheet">
    
    <!-- Custom Fonts -->
    <link href="<c:url value="/resources/font-awesome-4.1.0/css/font-awesome.min.css"/>" rel="stylesheet" type="text/css">
	
	<!-- easyui CSS -->
    <link href="<c:url value="/resources/css/easy/easyui.css"/>" rel="stylesheet" type="text/css">
    <link href="<c:url value="/resources/css/easy/icon.css"/>" rel="stylesheet" type="text/css">
    
    <!-- form css -->
	<link href="<c:url value="/resources/css/local/form.css"/>" rel="stylesheet">
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
	<div id="wrapper" style="height: 100%;">
        <!-- Navigation -->
        <%@ include file="../common/leftmenu.jsp"%>  
          
        <div id="page-wrapper" style="height: 80%;overflow: auto;">
        	<input type="hidden" value="${category.class_path}" id="class_path">
            <form id="pcUpdate" class="basic-grey">
            <input type="hidden" value="${category.class_id}" id="class_id" name="class_id">
			<h1>标本类别添加
			</h1>
				<label>
				<span>父类别 :</span>
				</label>
				<div class="categorySelect" style="padding-bottom: 10px;">
				</div>
			<label>
			<span>类别名 :</span>
			<input id="class_name" type="text" name="class_name" value="${category.class_name}"/>
			</label>
			<label>
			<span>类别拉丁名  :</span>
			<input id="class_latin" type="text" name="class_latin"  value="${category.class_latin}"/>
			</label>
			<label>
			<span>类别描述 :</span>
			<textarea id="class_describe" name="class_describe" >${category.class_describe}</textarea>
			</label>
			
			<div align="center" style="width: 100%">
				<input type="button" class="button" value="修改" id="editbtn"/>
			</div>
			</form>
       	</div>
        <!-- /#page-wrapper -->
    </div>
   
		
	<!-- footer and share js -->
	<%@ include file="../common/footer.jsp"%>
    
    <!-- easyui JavaScript -->
    <script type="text/javascript" src="<c:url value="/resources/js/easy/jquery.easyui.min.js"/>"></script>
    <!-- commom.js -->
    <script type="text/javascript" src="<c:url value="/resources/js/common/common.js"/>"></script>
    
    <script type="text/javascript">
    	$(function(){
    		var class_path = $("#class_path").val();
    		if(class_path != ""){
    			getCategoryPath(class_path);
    		}
    		
    		//修改类别
    		$("#editbtn").click(function(){
    			
    			//序列化表单数据
    			var data = $("#pcUpdate").serialize();
    			
    			//获取父类別id
    			var parent_id = $("#pcSelector"+(selNums-1)).val();
    			//如果最下面一个选框没有选择 则获取上一个选框的id作为父id
    			if(parent_id == ''){
    				parent_id = $("#pcSelector"+(selNums-2)).val();
    			}
    			
    			//重新组织表单数据
    			data = data+"&parent_id="+parent_id + "&class_path="+class_path;
    			
				$.ajax({
					url:"../category/",
					data:data,
					type:'put',
					dataType:'json',
					success:function(result){
						if(result.status){
							msg('修改成功',3000,result.obj,'fade');
							window.location.href = "../tree";
						}else{
							alertInfo('错误',result.obj,'error');
						}
					}
				});
			});
    		
    		$("#savedbtn").click(function(){
    			$("#savebtn").show();
    			$("#savedbtn").hide();
    		});
    	});
    	
    	/**
    	 * 
    	 */
    	//总共有多少个选择框
    	var selNums = 0;
    	/**
    	 * 
    	 * TODO 通过路径获取路径上的类别
    	 * @param class_path
    	 * 2015年1月26日
    	 * @author wangcan
    	 */
    	function getCategoryPath(class_path){
    		var categorySelect = $(".categorySelect");
    		categorySelect.empty('');
    		var class_id = $("#class_id").val();
    		var url = "../pathes/"+class_path;
    		
    		//根节点
			var selectorRoot = $('<select id="pcSelector" style="margin-bottom: 5px;"></select>');
			selectorRoot.append('<option value="0">植物  Plantae</option>');
			categorySelect.append(selectorRoot);
    		
    		$.ajax({
    			url:url,
    			type:'get',
    			dataType:'json',
    			success:function(result){
    				//将选项被选中的id取出
    				var class_selecteds = class_path.split('_');
    				selNums = result.length;
   					for(var i=0;i<result.length;i++){
   						var selector;
						var left = 105 + i*10;
   						selector = $('<select id="pcSelector'+i+'" style="margin-bottom: 5px;margin-left:'+left+'px;"  onchange=getChild("pcSelector",'+i+')></select>');
   						selector.append('<option value="">选择类别</option>');
   						
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
   				//获取最下一层的子类别
   				getChild("pcSelector",result.length-1);
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
    		var class_id = $("#"+selectorId+parent_id).val();
    		//父类别不能为自己
    		var class_id_val = $("#class_id").val();
    		if(class_id == class_id_val){
    			msg('错误',1800,'父类别不能为自身','fade');
    			$("#"+selectorId+parent_id).val('');
    			return;
    		}
    		var selNumsCopy = selNums;
    		//移除父选择框下的子选择框
    		for(var i=index+1; i<selNumsCopy; i++){
    			var selector = $("#"+selectorId+i);
    			selector.remove();
    			--selNums;
    		}
    		if(class_id != ""){
    			//重新加载子选择框
    			$.ajax({
    				url:"../category/"+class_id,
    				type:'get',
    				dataType:'json',
    				success:function(result){
    					if(result.status){
	    					if(result.length == 0)
	    						return;
	    					result = result.obj;
	    					var categorySelect = $(".categorySelect");
	    					var left = 105 + (index+1)*10;
	    					var selector = $('<select id="pcSelector'+selNums+'" style="margin-bottom: 5px;margin-left:'+left+'px;"  onchange=getChild("pcSelector",'+selNums+')></select>');
	    					selector.append('<option value="">请选择类别</option>');
	    					for(var j=0;j<result.length;j++){
	    						var class_name = result[j].class_name!=null ?result[j].class_name : "";
	    						var class_latin= result[j].class_latin!=null ?result[j].class_latin : "";
	    						selector.append('<option value="'+result[j].class_id+'">'+class_name + class_latin+'</option>');
	    					}
	    					categorySelect.append(selector);
	    					//重新计算选择框的个数
	    					++selNums;
    					}else{
							alertInfo('错误',result.obj,'error');
    					}
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
    			var class_id = $("#pcSelector"+i).val();
    			if(class_id != ''){
    				class_path += class_id + "_";
    			}
    		}
    		//加上根类别
    		class_path += 0;
    		return class_path;
    	}
    </script>	
</body>
</html>