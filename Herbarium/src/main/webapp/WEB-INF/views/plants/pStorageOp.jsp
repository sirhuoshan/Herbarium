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
<title>馆藏信息管理</title>
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
	<link href="<c:url value="/resources/css/local/speciesform.css"/>" rel="stylesheet">
	<link href="<c:url value="/resources/css/local/example.css"/>" rel="stylesheet">
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
           <form id="plantsStorage" class="basic-grey">
			<h1>馆藏信息
			</h1>
			<label>
			<span class="spanstyle">馆藏号  :</span>
			<input id="barcode_id" name="barcode_id" type="text" class="inputstyle" value="${pstorage.barcode_id}">
			<input id="specimen_id" name="specimen_id" value="${pstorage.specimen_id}" type="hidden" class="inputstyle">
			</label>
			<label>
			<span class="spanstyle">标本位置  :</span>
			<input id="keep_location" name="keep_location"  value="${pstorage.keep_location}" type="text" class="inputstyle"/>
			</label>
			<label>
			<span class="spanstyle">标本来源  :</span>
				<input id="specimen_source_val" value="${pstorage.specimen_source}" type="hidden" class="inputstyle"/>
				<select name="specimen_source" id="specimen_source">
					<option value="">请选择标本来源</option>
					<option value="exchange">交换</option>
					<option value="give">赠送</option>
					<option value="collect">自采集</option>
				</select>
			</label>
			<label>
			<span class="spanstyle">标本状态  :</span>
			<input id="specimen_state" name="specimen_state" value="${pstorage.specimen_state}" type="text" class="inputstyle"/>
			</label>
			<label>
			<span class="spanstyle">是否模式标本  :</span>
				<input id="specimen_attribute_val" value="${pstorage.specimen_attribute}" type="hidden" class="inputstyle"/>
				<select name="specimen_attribute" id="specimen_attribute">
					<option value="n">否</option>
					<option value="y">是</option>
				</select>
			</label>
			<label>
			<span class="spanstyle">保存份数  :</span>
			<input id="storage_num"  name="storage_num" value="${pstorage.storage_num}" type="text" class="inputstyle"/>
			</label>
			<label>
			<span class="spanstyle">前台展示 :</span>
				<input id="display_val" value="${pstorage.display}" type="hidden" class="inputstyle"/>
				<select name="display" id="display">
					<option value="y">展示</option>
					<option value="n">不展示</option>
				</select>
			</label>
			<label>
			<span class="spanstyle">备注  :</span>
				<textarea name="storage_remark">${pstorage.storage_num}</textarea>
			</label>
			<div align="center" style="width: 100%" id="toedit">
				<input type="button" class="button" value="修改" id="toeditbtn"/>
				<input type="button" class="button" value="删除" id="delbtn"/>
			</div>
			<div align="center" style="width: 100%;display: none;" id="edit">
				<input type="button" class="button" value="取消" id="cancel" />
				<input type="button" class="button" value="更新" id="updatebtn"/>
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
    	var specimen_source_val = $("#specimen_source_val").val();
    	$("#specimen_source").val(specimen_source_val);
    	var specimen_attribute_val = $("#specimen_attribute_val").val();
    	$("#specimen_attribute").val(specimen_attribute_val);
    	var display_val = $("#display_val").val();
    	$("#display").val(display_val);
    	//禁用所有表单项
    	$("input:text").attr("disabled","disabled");
    	$("textarea").attr("disabled","disabled");
    	$("select").attr("disabled","disabled");
    	
	  //添加类别
		$("#updatebtn").click(function(){
			//改变button样式
			var updatebtn = $("#updatebtn");
			updatebtn.attr("class","saving_button");
			updatebtn.val("更新中...");
			
			var data = $("#plantsStorage").serialize();
			$.ajax({
				url:"../",
				data:data,
				type:'put',
				dataType:'json',
				success:function(result){
					if(result.status){
						msg('保存成功',3000,result.obj,'fade');
						updatebtn.attr("class","button");
						updatebtn.val("更新");
					}else{
						alertInfo('错误',result.obj,'error');
					}
				}
			});
		});
		
		$("#toeditbtn").click(function(){
			//启用所有表单项
	    	$("input").removeAttr("disabled");
	    	$("textarea").removeAttr("disabled");
	    	$("select").removeAttr("disabled");
	    	
	    	$("#toedit").hide();
	    	$("#edit").show();
		});
		
		$("#cancel").click(function(){
			//禁用所有表单项
	    	$("input:text").attr("disabled","disabled");
	    	$("textarea").attr("disabled","disabled");
	    	$("select").attr("disabled","disabled");
	    	$("#toedit").show();
	    	$("#edit").hide();
		});
		
		$("#delbtn").click(function(){
			var specimen_id = $("#specimen_id").val();
			$.ajax({
				url:"../"+specimen_id,
				type:'delete',
				dataType:'json',
				success:function(result){
					if(result.status){
						msg('删除成功',3000,result.obj,'fade');
					}else{
						alertInfo('错误',result.obj,'error');
					}
				}
			});
		});
	});
    </script>	
</body>
</html>