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
<title>新增</title>
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
           <ul class="nav nav-tabs">
			  <li role="presentation"><a href="<c:url value="/pstorage/new/${specimen_id}"/>">馆藏</a></li>
			  <li role="presentation" class="active"><a href="<c:url value="/pidentify/new/${specimen_id}"/>">鉴定</a></li>
			  <li role="presentation"><a href="<c:url value="/pmedia/new/${specimen_id}"/>">多媒体</a></li>
			</ul>
           <form id="plantsIdentify" class="basic-grey">
			<h1>${chinese_name}-${latin_name}鉴定信息
			</h1>
			<label>
			<span class="spanstyle">学名  :</span>
			<input id="scientific_name" name="scientific_name" type="text" class="inputstyle">
			<input id="specimen_id" name="specimen_id" value="${specimen_id}" type="hidden" class="inputstyle">
			</label>
			<label>
			<span class="spanstyle">中文名  :</span>
			<input id="chinese_name" name="chinese_name" type="text" class="inputstyle"/>
			</label>
			<label>
			<span class="spanstyle">科名  :</span>
				<input name="famaly_name" id="famaly_name" type="text" class="inputstyle">
			</label>
			<label>
			<span class="spanstyle">鉴定日期  :</span>
				<input name="identify_date" id="identify_date" type="text" class="inputstyle">
			</label>
			<label>
			<span class="spanstyle">鉴定信息  :</span>
			<textarea id="identify_info" name="identify_info"></textarea>
			</label>
			<label>
			<span class="spanstyle">鉴定备注  :</span>
			<textarea id="identify_remark" name="identify_remark"></textarea>
			</label>
			<label>
			<span class="spanstyle">鉴定人  :</span>
			<input id="identifier_id" name="identifier_id" type="text" class="inputstyle"/>
			</label>
			<div align="center" style="width: 100%">
				<input type="reset" class="button" value="重置" />
				<input type="button" class="button" value="保存" id="savebtn"/>
				<input type="button" class="saved_button" value="继续添加" id="savedbtn" style="display:none;"/>
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
	  //添加类别
		$("#savebtn").click(function(){
			//改变button样式
			var savebtn = $("#savebtn");
			savebtn.attr("class","saving_button");
			savebtn.val("保存中...");
			
			//序列化表单数据
			var data = $("#plantsIdentify").serialize();
			$.ajax({
				url:"../",
				data:data,
				type:'post',
				dataType:'json',
				success:function(result){
					if(result.status){
						msg('保存成功',3000,'保存成功','fade');
						savebtn.hide();
						savebtn.attr("class","button");
						savebtn.val("保存");
						$("#savedbtn").show();
					}else{
						alertInfo('错误',result.obj,'error');
						savebtn.attr("class","button");
						savebtn.val("保存");
					}
				}
			});
		});
		
		$("#savedbtn").click(function(){
			$("#savebtn").show();
			$("#savedbtn").hide();
		});
	});
    </script>	
</body>
</html>