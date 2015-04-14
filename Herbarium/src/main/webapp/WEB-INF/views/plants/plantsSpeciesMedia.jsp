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
           		<input type="hidden" id="species_id" name="species_id" value="${species_id }" />
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
			 			<li id="media${media.media_id}" style="width:150px;height: 200px;">
			 					<div class="rsp" style="width:150px;height: 16px;">
				                	<a href="##" style="float:right;cursor: pointer;">
				                		<img src="<c:url value="/resources/css/uploadify/uploadify-cancel.png" />" class="img_icon" onclick="delMedia(${media.media_id})">
				                	</a>
				                </div>
					 			<div class="photo" onclick="showmedia('${media.media_path}','${media.media_id}')">
					 				<img src="/static_img/${media.media_compress_path}"/>
								</div>
				                <div style="width: 150px;height: 100px;">
				               		<span id="describe" style="display: block;text-align: center;">${media.media_discribe}</span>
				               		<span id="location" style="display: block;text-align: center;">${media.shooting_part}</span>
				               		<span id="photoinfo" style="display: block;text-align: center;">拍摄：${media.photographer}  ${obj.shooting_time}</span>
				               		<span id="area" style="display: block;text-align: center;">${media.shooting_area}</span>
				               		<span id="identify" style="display: block;text-align: center;">鉴定人：${media.identifiers}</span>
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
	<div class="modal fade" id="plantsSpeciesMediaInfo" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display: none;">
          <div class="modal-dialog">
              <div class="modal-content"  style="max-width: 1000px;">
                  <div class="modal-header">
                      <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                      <h4 class="modal-title" id="myModalLabel">照片信息</h4>
                       <div style="margin-top:5px;">
                       		<form id="speciesMediaEdit">
						   		<div style="margin-top:2px;">
						   			<input type="hidden" id="media_id" name="media_id">
							   		<label for="photographer" style="width: 70px;height: 20px">拍摄者</label>
							   		<input type="text" id="photographer" name="photographer" style="width: 150px;height: 20px"/>
									<label for="shooting_time"  style="width: 70px;height: 20px">拍摄时间</label>
									<input id="shooting_time"  name="shooting_time" type="text" style="width:150px;height: 20px;">
						   			
							   		<label for="identifiers" style="width: 70px;height: 20px">鉴定人</label>
							   		<input type="text" id="identifiers" name="identifiers" style="width: 150px;height: 20px"/>
							   		<label for="shooting_part" style="width: 70px;height: 20px">拍摄部位</label>
							   		<input type="text" id="shooting_part" name="shooting_part" style="width: 150px;height: 20px"/>
					   			</div>
						   		<div>
							   		<label for="shooting_area" style="width: 70px;height: 20px">拍摄地点</label>
							   		<input type="text" id="shooting_area" name="shooting_area" style="width: 400px;height: 20px"/>
							   		<input type="button" onclick="speciesMediaEdit()" style="float: right;margin-right: 60px;" class="btn btn-default"  value="更新"/>
						   		</div>
						   	</form>
   					</div>
                      
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
				'onSelect' : function(file) {
					loaded++;
					var index = file.index;
					var html =  '<div style="margin-top:5px;">'+
								  	 '<fieldset style="border:#06c solid 1px;height:85px;">'+
									   		'<div style="margin-top:2px;">'+
										   		'<label for="photographer'+index+'" style="width: 70px;height: 20px">拍摄者</label>'+
										   		'<input type="text" id="photographer'+index+'" name="photographer'+index+'" style="width: 90px;height: 20px"/>'+
 												'<label for="shooting_time'+index+'"  style="width: 70px;height: 20px">拍摄时间</label>'+
 												'<input id="shooting_time'+index+'"  name="shootingTime'+index+'" type="text" style="width:90px;height: 20px;">'+
									   		'</div>'+
									   		'<div>'+
										   		'<label for="identifiers'+index+'" style="width: 70px;height: 20px">鉴定人</label>'+
										   		'<input type="text" id="identifiers'+index+'" name="identifiers'+index+'" style="width: 90px;height: 20px"/>'+
										   		'<label for="shooting_part'+index+'" style="width: 70px;height: 20px">拍摄部位</label>'+
										   		'<input type="text" id="shooting_part'+index+'" name="shootingPart'+index+'" style="width: 90px;height: 20px"/>'+
								   			'</div>'+
									   		'<div>'+
										   		'<label for="shooting_area'+index+'" style="width: 70px;height: 20px">拍摄地点</label>'+
										   		'<input type="text" id="shooting_area'+index+'" name="shootingArea'+index+'" style="width: 250px;height: 20px"/>'+
									   		'</div>'+
								   	'</fieldset>'+
			   					'</div>';
			   		$("#SWFUpload_0_"+index).append(html);			
				},
				'onUploadStart' : function(file) {
					var index = file.index;
			     	var photographer = $("#photographer"+index).val();
		    		var shootingTime = $("#shooting_time"+index).val();
		    		var identifiers = $("#identifiers"+index).val();
		    		var shootingPart = $("#shooting_part"+index).val();
		    		var shootingArea = $("#shooting_area"+index).val();
		    		var formData = 	{'photographer' : photographer, 'shooting_time' : shootingTime,'identifiers' :  identifiers ,
							 'shooting_part' :  shootingPart ,'shooting_area ' : shootingArea};
		    		$("#file_upload").uploadify('settings','formData',formData);
		        },
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
			var species_id = $("#species_id").val();
			var data = "?species_id="+species_id;
			var url = '../../../pspeciesMedia' + data;
			$('#file_upload').uploadify('settings','uploader', url);
			$('#file_upload').uploadify('upload', '*');
	    }
	    function generateLi(obj){
	    	var li =  '<li id="media'+obj.media_id+'" style="width:150px;height: 200px;">'+
				    	'<div class="rsp" style="width:150px;height: 16px;">'+
			        	'<a href="##" style="float:right;cursor: pointer;">'+
			        		'<img src="<c:url value="/resources/css/uploadify/uploadify-cancel.png" />" class="img_icon" onclick="delMedia('+obj.media_id+')">'+
			        	'</a>'+
				        '</div>'+
			 			'<div class="photo" onclick="showmedia(\''+obj.media_path+'\,\''+obj.media_id+'\')">'+
			 				'<img src="/static_img/'+obj.media_compress_path+'"/>'+
						'</div>'+
			            '<div style="width: 150px;height: 100px;">'+
			           		'<span id="describe" style="display: block;text-align: center;">'+obj.media_discribe+'</span>'+
			           		'<span id="location" style="display: block;text-align: center;">'+obj.shooting_part+'</span>'+
			           		'<span id="photoinfo" style="display: block;text-align: center;">拍摄：'+obj.photographer+'  '+obj.shooting_time+'</span>'+
			           		'<span id="area" style="display: block;text-align: center;">'+obj.shooting_area+'</span>'+
		               		'<span id="identify" style="display: block;text-align: center;">鉴定人'+obj.identifiers+'</span>'+
			            '</div>'+
			       '</li>';
       		return li;
	    }
	    
	    function showmedia(media_path,media_id){
	    	var pic = new Image();
	    	pic.onload=function(){
	    		$(".modal-content").width(this.width+50);
	    		$("#imageSrc").attr("src","/static_img/"+media_path)
	    	};
	    	pic.src = "/static_img/"+media_path;
	    	
	    	$.ajax({
	    		url:'../'+media_id,
	    		type:'get',
	    		dataType:'json',
	    		async:false,
	    		success:function(result){
	    			if(result.status){
	    				$("#media_id").val(result.obj.media_id);
	    				$("#photographer").val(result.obj.photographer);
	    				$("#shooting_time").val(result.obj.shooting_time);
	    				$("#identifiers").val(result.obj.identifiers);
	    				$("#shooting_area").val(result.obj.shooting_area);
	    				$("#shooting_part").val(result.obj.shooting_part);
	    				$("#plantsSpeciesMediaInfo").modal('show');
	    			}else{
						alertInfo('错误',result.obj,'error');
		    		}
	    		}
	    	});
	    }
	    function speciesMediaEdit(){
	    	var data = $("#speciesMediaEdit").serialize();
	    	$.ajax({
	    		url:'../',
	    		type:'put',
	    		data:data,
	    		dataType:'json',
	    		async:false,
	    		success:function(result){
	    			if(result.status){
						msg('更新成功',2000,result.obj,'fade');
	    			}else{
						alertInfo('错误',result.obj,'error');
		    		}
	    		}
	    	});
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