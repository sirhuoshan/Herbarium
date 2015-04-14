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
			  <li role="presentation" class="active"><a href="<c:url value="/pstorage/new/${specimen_id}"/>">馆藏</a></li>
			  <li role="presentation"><a href="<c:url value="/pidentify/new/${specimen_id}"/>">鉴定</a></li>
			  <li role="presentation"><a href="<c:url value="/pmedia/new/${specimen_id}"/>">多媒体</a></li>
			</ul>
           <form id="plantsStorage" class="basic-grey">
			<h1>${chinese_name}-${latin_name}馆藏信息
			</h1>
			<label>
			<span class="spanstyle">馆藏号  :</span>
			<input id="barcode_id" name="barcode_id" type="text" class="inputstyle">
			<input id="specimen_id" name="specimen_id" value="${specimen_id}" type="hidden" class="inputstyle">
			</label>
			<label>
			<span class="spanstyle">标本位置  :</span>
			<input id="keep_location" name="keep_location" type="text" class="inputstyle"/>
			</label>
			<label>
			<span class="spanstyle">标本来源  :</span>
				<select name="specimen_source" id="specimen_source">
					<option value="">请选择标本来源</option>
					<option value="exchange">交换</option>
					<option value="give">赠送</option>
					<option value="collect">自采集</option>
				</select>
			</label>
			<label>
			<span class="spanstyle">标本状态  :</span>
			<input id="specimen_state" name="specimen_state" type="text" class="inputstyle"/>
			</label>
			<label>
			<span class="spanstyle">是否模式标本  :</span>
				<select name="specimen_attribute" id="specimen_attribute">
					<option value="n">否</option>
					<option value="y">是</option>
				</select>
			</label>
			<label>
			<span class="spanstyle">保存份数  :</span>
			<input id="storage_num"  name="storage_num" type="text" class="inputstyle"/>
			</label>
			<label>
			<span class="spanstyle">前台展示 :</span>
				<select name="display" id="display">
					<option value="y">展示</option>
					<option value="n">不展示</option>
				</select>
			</label>
			<label>
			<span class="spanstyle">备注  :</span>
				<textarea name="storage_remark"></textarea>
			</label>
			
			<div align="center" style="width: 100%">
				<input type="reset" class="button" value="重置" />
				<input type="button" class="button" value="保存" id="savebtn"/>
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
			var data = $("#plantsStorage").serialize();
			$.ajax({
				url:"../",
				data:data,
				type:'post',
				dataType:'json',
				success:function(result){
					if(result.status){
						msg('保存成功',3000,result.obj,'fade');
						savebtn.attr("class","button");
						savebtn.val("已添加");
						savebtn.attr("disabled","disabled");
					}else{
						alertInfo('错误',result.obj,'error');
						savebtn.attr("class","button");
						savebtn.val("保存");
					}
				}
			});
		});
	});
    </script>	
</body>
</html>