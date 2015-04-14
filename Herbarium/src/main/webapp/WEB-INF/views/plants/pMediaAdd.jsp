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
<title>植物多媒体</title>
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
    
    <!-- uploadify css -->
	<link href="<c:url value="/resources/css/uploadify/uploadify.css"/>" rel="stylesheet" type="text/css">
	
	<!-- picture css -->
	<link href="<c:url value="/resources/css/local/ul-pic.css"/>" rel="stylesheet" type="text/css">
	
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
        <div id="page-wrapper" style="height: 80%;overflow: auto; padding: 10px 10px">
           <ul class="nav nav-tabs">
			  <li role="presentation"><a href="<c:url value="/pstorage/new/${specimen_id}"/>">馆藏</a></li>
			  <li role="presentation"><a href="<c:url value="/pidentify/new/${specimen_id}"/>">鉴定</a></li>
			  <li role="presentation" class="active"><a href="<c:url value="/pmedia/new/${specimen_id}"/>">多媒体</a></li>
			</ul>
          <div style="margin-top: 35px">
           		<input type="hidden" id="specimen_id" name="specimen_id" value="${specimen_id }" />
           		<div style="width:400px;margin-top:-30px;position:absolute;z-index:100;">
           			<input id="file_upload" name="file" type="file" multiple="true">
           		</div>
           		<div style="width:100px;margin-left:200px;margin-top:-35px;position:absolute;z-index:200;">
           		    <a  href="javascript:$('#file_upload').uploadify('cancel')" class="btn btn-success" style="width:50px;margin-left:100px;margin-top:3px;position:absolute;">取消</a>
           			<a  href="javascript:uplodaMedia()" class="btn btn-success" style="width:50px;margin-left:0px;margin-top:3px;position:absolute;">上传</a>
		   		</div>
	      </div> 
          </div>
        <!-- /#page-wrapper -->
    </div>
   
	<!-- footer and share js -->
	<%@ include file="../common/footer.jsp"%>
    
    <!-- easyui JavaScript -->
    <script type="text/javascript" src="<c:url value="/resources/js/easy/jquery.easyui.min.js"/>"></script>
    <!-- commom.js -->
    <script type="text/javascript" src="<c:url value="/resources/js/common/common.js"/>"></script>
    <!-- uploadify.js -->
    <script type="text/javascript" src="<c:url value="/resources/js/uploadify/jquery.uploadify.min.js"/>"></script>
    
    <script type="text/javascript">
		var loaded = 0;
	    $(function() {
			$('#file_upload').uploadify({
				'buttonText' : '选择图片',
				'swf'      : '<c:url value="/resources/css/uploadify/uploadify.swf"/>',
				'auto' : false,
				'multi': true,
		        'onUploadSuccess': function (file, data, response) {
		        	data = eval('('+data+')');
		        	if(data.status){
		        		
		        	}else{
		        		alert("上传"+file.name+"文件出错！"+"\n"+data.errorMsg);
		        		$('#file_upload').uploadify('cancel', '*'); 
		        	}
				}
			});
		});
	    function uplodaMedia(){
			var specimen_id = $("#specimen_id").val();
			var data = "?specimen_id="+specimen_id;
			var url = '../../../pmedia' + data;
			$('#file_upload').uploadify('settings','uploader', url);
			$('#file_upload').uploadify('upload', '*');
	    }
    </script>	
</body>
</html>