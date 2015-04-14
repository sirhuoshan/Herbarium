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
<title>植物物种多媒体</title>
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
          
          <div style="margin-top: 35px">
           		<input type="hidden" id="specimen_id" name="specimen_id" value="${specimen_id }" />
           		<div style="width:400px;margin-top:-30px;position:absolute;z-index:100;">
           			<input id="file_upload" name="file" type="file" multiple="true">
           		</div>
           		<div style="width:100px;margin-left:200px;margin-top:-35px;position:absolute;z-index:200;">
           		    <a  href="javascript:$('#file_upload').uploadify('cancel')" class="btn btn-success" style="width:50px;margin-left:100px;margin-top:3px;position:absolute;">取消</a>
           			<a  href="javascript:uplodaMedia()" class="btn btn-success" style="width:50px;margin-left:0px;margin-top:3px;position:absolute;">上传</a>
		   		</div>
	          <div class="section" style="z-index:10;margin-left: 380px;margin-top:-35px;float: left;">
		 	     <ul class="clearfix" id="photo_list" style="z-index:10;">    
			 		<c:forEach var="media" items="${medias}">
			 			<li id="media${media.media_id}" style="width:150px;height: 140px;">
			 					<div class="rsp" style="width:150px;height: 16px;">
				                	<a href="javascript:void(0)" style="float:right;cursor: pointer;">
				                		<img src="<c:url value="/resources/css/uploadify/uploadify-cancel.png" />" class="img_icon" onclick="delMedia(${media.media_id})">
				                	</a>
				                </div>
					 			<div class="photo" style="width:150px;height: 100px;" onclick="showmedia('${media.media_path}','${media.media_id}')">
					 				<img src="/static_img/${media.media_compress_path}"/>
								</div>
				                <div style="width: 150px;height: 30px;">
				               		<span id="describe" style="display: block;text-align: center;">${media.media_discribe}</span>
				                </div>
				           </li>
			 		</c:forEach>
		    	</ul>
	    	 </div>  								
	      </div> 
          </div>
        <!-- /#page-wrapper -->
    </div>
   
     <!-- 显示照片信息 -->
	<div class="modal fade" id="plantsMediaInfo" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display: none;">
          <div class="modal-dialog">
              <div class="modal-content"  style="max-width: 1000px;">
                  <div class="modal-header">
                      <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                      <h4 class="modal-title" id="myModalLabel">照片信息</h4>
                  </div>
                  <div class="modal-body" style="max-width: 1000px;overflow: auto;text-align: center;">
                  	  <img id = "imageSrc">
                  </div>
                  <div class="modal-footer">
                      <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                  </div>
              </div>
          </div>
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
		        	var photoList = $("#photo_list");
		        	data = eval('('+data+')');
		        	if(data.status){
		        		var obj = data.obj;
		        		var li =  generateLi(obj);
		        		photoList.prepend(li);
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
	    function generateLi(obj){
	    	var li =  '<li id="media${media.media_id}" style="width:150px;height: 140px;">'+
							'<div class="rsp" style="width:150px;height: 16px;">'+
			            	'<a href="javascript:void(0)" style="float:right;cursor: pointer;">'+
			            		'<img src="<c:url value="/resources/css/uploadify/uploadify-cancel.png" />" class="img_icon" onclick="delMedia('+obj.media_id+')">'+
			            	'</a>'+
			            '</div>'+
			 			'<div class="photo" style="width:150px;height: 100px;" onclick="showmedia(\''+obj.media_path+'\',\''+obj.media_id+'\')">'+
			 				'<img src="/static_img/'+obj.media_compress_path+'"/>'+
						'</div>'+
			            '<div style="width: 150px;height: 30px;">'+
			           		'<span id="describe" style="display: block;text-align: center;">'+obj.media_discribe+'</span>'+
			            '</div>'+
			       	  '</li>';
       		return li;
	    }
	    
	    function showmedia(media_path,media_id){
	    	var pic = new Image();
	    	pic.onload=function(){
	    		$(".modal-content").width(this.width+50);
	    		$("#imageSrc").attr("src","/static_img/"+media_path);
	    	};
	    	pic.src = "/static_img/"+media_path;
	    	$("#plantsMediaInfo").modal('show');
	    }
	    
	    function delMedia(media_id){
	    	$.ajax({
	    		url:'../'+media_id,
	    		type:'delete',
	    		dataType:'json',
	    		async:false,
	    		success:function(result){
	    			if(result.status){
						msg('删除成功',2000,result.obj,'fade');
						var mediali = $('#media'+media_id);
						mediali.remove();
	    			}else{
						alertInfo('错误',result.obj,'error');
		    		}
	    		}
	    	});
	    }
    </script>	
</body>
</html>