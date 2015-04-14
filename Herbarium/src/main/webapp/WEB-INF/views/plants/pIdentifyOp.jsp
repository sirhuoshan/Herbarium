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
	<link href="<c:url value="/resources/css/local/form.css"/>" rel="stylesheet">
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
        	<div style="margin-left: 10px;margin-top: 10px;">
				<input type="button"  class="btn btn-default" value="新增" id="newbtn" onclick="newidentify()"/>
			</div>
			<div>
				<ul style="display:inline-table;" id="identifyList">
					<c:forEach var="identify" items="${piList}">
						<li id="identify${identify.identify_id}" style="float:left;display:inline;width:250px;height:260px;overflow:hidden;position:relative;padding: 5px 5px">
							<ul style="list-style: none;border: 1px solid #E4E4E4;font-size: 13px;padding: 0 0">
							   <li style="float: right;"><img src="<c:url value="/resources/css/uploadify/uploadify-cancel.png" />" style="cursor: pointer;" onclick="delIdentify(${identify.identify_id})"></li>
				               <li><span style="font-weight: bold;">学名  :</span><span id="scientific_name${identify.identify_id}">${identify.scientific_name}</span></li>
				               <li><span style="font-weight: bold;">中文名  :</span><span id="chinese_name${identify.identify_id}">${identify.chinese_name}</span></li>
				               <li><span style="font-weight: bold;">科名  :</span><span id="famaly_name${identify.identify_id}">${identify.famaly_name}</span></li>
				               <li><span style="font-weight: bold;">鉴定日期  :</span><span id="identify_date${identify.identify_id}">${identify.identify_date}</span></li>
				               <li><span style="font-weight: bold;">鉴定人  :</span><span id="identifier_id${identify.identify_id}">${identify.identifier_id}</span></li>
				               <li style="height:57px;overflow-x:hidden;overflow-y:auto;">
				               		<span style="font-weight: bold;">鉴定信息  :</span><span id="identify_info${identify.identify_id}">${identify.identify_info}</span>
				               </li>
				               <li style="height:57px;width:250px;overflow-x:hidden;overflow-y:auto;">
				               		<span style="font-weight: bold;">鉴定备注  :</span><span id="identify_remark${identify.identify_id}">${identify.identify_remark}</span>
				               </li>
				               <li>
			               		 <div align="center" style="width: 100%;margin-top: 10px;">
								  	<input type="button" class="btn btn-default" value="修改" id="editbtn" onclick="editIdentify(${identify.identify_id})"/>
								 </div>	
				               </li>
			              </ul>
			            </li>
					</c:forEach>
				</ul>
			</div>
       	</div>
        <!-- /#page-wrapper -->
    </div>
   
    
     <!-- 更新 -->
	<div class="modal fade" id="pidentifyInfo" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display: none;">
          <div class="modal-dialog">
              <div class="modal-content" style="width: 500px;">
                  <div class="modal-header">
                      <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                      <h4 class="modal-title" id="myModalLabel">鉴定信息</h4>
                  </div>
                  <div class="modal-body" style="padding: 0 0">
                  	 <form id="plantsIdentify" class="basic-grey">
					<label>
					<span class="spanstyle">学名  :</span>
					<input id="scientific_name" name="scientific_name" type="text" class="inputstyle">
					<input id="identify_id" name="identify_id" type="hidden" class="inputstyle">
					<input id="specimen_id" name="specimen_id" type="hidden" class="inputstyle">
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
						<input type="button" class="button" value="更新" id="updatebtn" onclick="updateidentify()"/>
					</div>
					</form>
                  </div>
                  <div class="modal-footer">
                      <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                  </div>
              </div>
          </div>
      </div>
      
      
      <div class="modal fade" id="pidentifyInfoNew" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display: none;">
          <div class="modal-dialog">
              <div class="modal-content" style="width: 500px;">
                  <div class="modal-header">
                      <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                      <h4 class="modal-title" id="myModalLabel">鉴定信息</h4>
                  </div>
                  <div class="modal-body" style="padding: 0 0">
                  	 <form id="plantsIdentifyNew" class="basic-grey">
					<label>
					<span class="spanstyle">学名  :</span>
					<input id="scientific_name" name="scientific_name" type="text" class="inputstyle">
					<input id="identify_id" name="identify_id" type="hidden" class="inputstyle">
					<input id="specimen_id" name="specimen_id" value="${specimen_id}"  type="hidden" class="inputstyle">
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
						<input type="button" class="button" value="保存" id="savebtn" onclick="save()"/>
					</div>
					</form>
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
    <script type="text/javascript">
    
    function editIdentify(identify_id){
    	$.ajax({
			url:"../"+identify_id,
			type:'get',
			dataType:'json',
			success:function(result){
				if(result.status){
					$("#identify_id").val(result.obj.identify_id);
					$("#specimen_id").val(result.obj.specimen_id);
					$("#identifier_id").val(result.obj.identifier_id);
					$("#scientific_name").val(result.obj.scientific_name);
					$("#chinese_name").val(result.obj.chinese_name);
					$("#famaly_name").val(result.obj.famaly_name);
					$("#identify_info").val(result.obj.identify_info);
					$("#identify_date").val(result.obj.identify_date);
					$("#identify_remark").val(result.obj.identify_remark);
					$('#pidentifyInfo').modal('show');
				}else{
					alertInfo('错误',result.obj,'error');
				}
			}
		});
    }
    
    function updateidentify(){
    	var identify_id = $("#identify_id").val();
    	var data = $("#plantsIdentify").serialize();
    	$.ajax({
			url:"../",
			data:data,
			type:'put',
			dataType:'json',
			success:function(result){
				if(result.status){
					msg('更新成功',3000,'更新成功','fade');
					$('#pidentifyInfo').modal('hide');
					$("#identifier_id"+identify_id).text(result.obj.identifier_id);
					$("#scientific_name"+identify_id).text(result.obj.scientific_name);
					$("#chinese_name"+identify_id).text(result.obj.chinese_name);
					$("#famaly_name"+identify_id).text(result.obj.famaly_name);
					$("#identify_info"+identify_id).text(result.obj.identify_info);
					$("#identify_date"+identify_id).text(result.obj.identify_date);
					$("#identify_remark"+identify_id).text(result.obj.identify_remark);
				}else{
					alertInfo('错误',result.obj,'error');
				}
			}
		});
    }
    
    function newidentify(){
    	$('#pidentifyInfoNew').modal('show');
    	$("#plantsIdentifyNew #scientific_name").val("");
		$("#plantsIdentifyNew #chinese_name").val("");
		$("#plantsIdentifyNew #famaly_name").val("");
		$("#plantsIdentifyNew #identify_info").val("");
		$("#plantsIdentifyNew #identify_date").val("");
		$("#plantsIdentifyNew #identify_remark").val("");
		$("#plantsIdentifyNew #identifier_id").val("");

    }
    function save(){
    	var savebtn = $("#savebtn");
		savebtn.attr("class","saving_button");
		savebtn.val("保存中...");
		savebtn.attr("disabled","disabled");
    	
    	//序列化表单数据
		var data = $("#plantsIdentifyNew").serialize();
		$.ajax({
			url:"../",
			data:data,
			type:'post',
			dataType:'json',
			success:function(result){
				if(result.status){
					msg('保存成功',3000,'保存成功','fade');
					savebtn.attr("class","button");
					savebtn.val("保存");
					savebtn.removeAttr("disabled");
					$('#pidentifyInfoNew').modal('hide');
					
					var identify = result.obj;
					var li = '<li id="identify'+identify.identify_id+'" style="float:left;display:inline;width:250px;height:260px;overflow:hidden;position:relative;padding: 5px 5px">'+
								'<ul style="list-style: none;border: 1px solid #E4E4E4;font-size: 13px;padding: 0 0">'+
								   '<li style="float: right;"><img src="<c:url value="/resources/css/uploadify/uploadify-cancel.png" />" style="cursor: pointer;" onclick="delIdentify('+identify.identify_id+')"></li>'+
					               '<li><span style="font-weight: bold;">学名  :</span><span id="scientific_name'+identify.identify_id+'">'+identify.scientific_name+'</span></li>'+
					               '<li><span style="font-weight: bold;">中文名  :</span><span id="chinese_name'+identify.identify_id+'">'+identify.chinese_name+'</span></li>'+
					               '<li><span style="font-weight: bold;">科名  :</span><span id="famaly_name'+identify.identify_id+'">'+identify.famaly_name+'</span></li>'+
					               '<li><span style="font-weight: bold;">鉴定日期  :</span><span id="identify_date'+identify.identify_id+'">'+identify.identify_date+'</span></li>'+
					               '<li><span style="font-weight: bold;">鉴定人  :</span><span id="identifier_id'+identify.identify_id+'">'+identify.identifier_id+'</span></li>'+
					               '<li style="height:57px;overflow-x:hidden;overflow-y:auto;">'+
					               		'<span style="font-weight: bold;">鉴定信息  :</span><span id="identify_info'+identify.identify_id+'">'+identify.identify_info+'</span>'+
					               '</li>'+
					               '<li style="height:57px;width:250px;overflow-x:hidden;overflow-y:auto;">'+
					               		'<span style="font-weight: bold;">鉴定备注  :</span><span id="identify_remark'+identify.identify_id+'">'+identify.identify_remark+'</span>'+
					               '</li>'+
					               '<li>'+
				               		 '<div align="center" style="width: 100%;margin-top: 10px;">'+
									  	'<input type="button" class="btn btn-default" value="修改" id="editbtn" onclick="editIdentify('+identify.identify_id+')"/>'+
									 '</div>'+
					               '</li>'+
				             '</ul>'+
				            '</li>';
					$("#identifyList").prepend(li);
				}else{
					alertInfo('错误',result.obj,'error');
					savebtn.attr("class","button");
					savebtn.val("保存");
					savebtn.removeAttr("disabled");
				}
			}
		});
    }
    
    function delIdentify(identify_id){
    	$.ajax({
			url:"../"+identify_id,
			type:'delete',
			dataType:'json',
			success:function(result){
				if(result.status){
					msg('删除成功',3000,result.obj,'fade');
					$("#identify"+identify_id).remove();
				}else{
					alertInfo('错误',result.obj,'error');
				}
			}
    	});
    }
    </script>	
</body>
</html>