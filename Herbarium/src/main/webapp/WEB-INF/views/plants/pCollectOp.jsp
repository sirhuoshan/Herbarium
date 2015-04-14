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
<title>标本管理</title>
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
           <form id="plantsCollect" class="basic-grey">
			<h1>植物采集信息管理
			</h1>
			<label>
			<span class="spanstyle">采集号  :</span>
			<input id="collect_id" name="collect_id" type="text" class="inputstyle" value="${pcollect.collect_id}">
			<input id="specimen_id" name="specimen_id" type="hidden" class="inputstyle" value="${pcollect.specimen_id}">
			</label>
			<label>
			<span class="spanstyle">采集人  :</span>
			<input id="collecter" name="collecter" type="text" class="inputstyle" value="${pcollect.collecter}"/>
			</label>
			<label>
			<span class="spanstyle">拉丁名  :</span>
			<input id="latin_name" name="latin_name" type="text" class="typeahead" value="${pcollect.latin_name}"/>
			</label>
			<label>
			<span class="spanstyle">中文名  :</span>
			<input id="chinese_name" name="chinese_name" readonly="readonly" type="text" class="inputstyle" value="${pcollect.chinese_name}"/>
			</label>
			<label>
			<span class="spanstyle">科  :</span>
			<input id="family" type="text" readonly="readonly" class="inputstyle" value="${pcollect.family}"/>
			<input id="species_id" name="species_id" type="hidden" value="${pcollect.species_id}"/>
			</label>
			<label>
			<span class="spanstyle">属  :</span>
			<input id="genus" type="text" readonly="readonly" class="inputstyle" value="${pcollect.genus}"/>
			</label>
			<label>
			<span class="spanstyle">标本俗名  :</span>
			<input id="trivial_name" name="trivial_name" type="text" class="inputstyle" value="${pcollect.trivial_name}"/>
			</label>
			<label>
			<span class="spanstyle">采集日期  :</span>
			<input id="collect_date" name="collect_date" type="text" class="inputstyle" value="${pcollect.collect_date}"/>
			</label>
			<label>
			<span class="spanstyle">国际代码  :</span>
			<input id="intenational_codes" name="intenational_codes" type="text" class="inputstyle" value="${pcollect.intenational_codes}"/>
			</label>
			<label>
			<span class="spanstyle">国家 :</span>
			<input id="country" name="country" type="text" class="inputstyle" value="${pcollect.country}"/>
			</label>
			<label>
			<span class="spanstyle">省  :</span>
			<input id="province" name="province" type="text" class="inputstyle" value="${pcollect.province}"/>
			</label>
			<label>
			<span class="spanstyle">市  :</span>
			<input id="city" name="city" type="text" class="inputstyle" value="${pcollect.city}"/>
			</label>
			<label>
			<span class="spanstyle">区  :</span>
			<input id="district" name="district" type="text" class="inputstyle" value="${pcollect.district}"/>
			</label>
			<label>
			<span class="spanstyle">县  :</span>
			<input id="county" name="county" type="text" class="inputstyle" value="${pcollect.county}"/>
			</label>
			<label>
			<span class="spanstyle">镇  :</span>
			<input id="town" name="town" type="text" class="inputstyle" value="${pcollect.town}"/>
			</label>
			<label>
			<span class="spanstyle">详细地址  :</span>
			<input id="detail_area" name="detail_area" type="text" class="inputstyle" value="${pcollect.detail_area}"/>
			</label>
			<label>
			<span class="spanstyle">地形及生境:</span>
				<textarea name="live_environment">${pcollect.live_environment}</textarea>
			</label>
			<label>
			<span class="spanstyle">经度  :</span>
			<input id="longitude" name="longitude" type="text" class="inputstyle" value="${pcollect.longitude}"/>
			</label>
			<label>
			<span class="spanstyle">纬度 :</span>
			<input id="latitude" name="latitude" type="text" class="inputstyle" value="${pcollect.latitude}"/>
			</label>
			<label>
			<span class="spanstyle">海拔  :</span>
			<input id="elevation" name="elevation" type="text" class="inputstyle" value="${pcollect.elevation}"/>
			</label>
			<label>
			<span class="spanstyle">生活型 :</span>
				<input id="live_type" type="hidden" class="inputstyle" value="${pcollect.live_type_id}"/>
				<select id="live_type_id" name="live_type_id">
					<option value="">请选择生活型</option>
					<option value="1">乔木</option>
					<option value="2">灌木</option>
					<option value="3">草本</option>
					<option value="4">藤本</option>
				</select>
			</label>
			<label>
			<span class="spanstyle">高度 :</span>
			<input id="height" name="height" type="text" class="inputstyle" value="${pcollect.height}"/>
			</label>
			<label>
			<span class="spanstyle">树皮:</span>
			<input id="bark" name="bark" type="text" class="inputstyle" value="${pcollect.bark}"/>
			</label>
			<label>
			<span class="spanstyle">枝:</span>
			<input id="branch" name="branch" type="text" class="inputstyle" value="${pcollect.branch}"/>
			</label>
			<label>
			<span class="spanstyle">叶:</span>
			<input id="leaf" name="leaf" type="text" class="inputstyle" value="${pcollect.leaf}"/>
			</label>
			<label>
			<span class="spanstyle">花:</span>
			<input id="flower" name="flower" type="text" class="inputstyle" value="${pcollect.flower}"/>
			</label>
			<label>
			<span class="spanstyle">果实:</span>
			<input id="fruit" name="fruit" type="text" class="inputstyle" value="${pcollect.fruit}"/>
			</label>
			<label>
			<span class="spanstyle">胸径（地径）:</span>
			<input id="dbh" name="dbh" type="text" class="inputstyle" value="${pcollect.dbh}"/>
			<input id="isidentified" name="isidentified" type="hidden" value="y" class="inputstyle"/>
			</label>
			<label>
			<span class="spanstyle">资源状况:</span>
				<textarea name="resource_state">${pcollect.resource_state}</textarea>
			</label>
			<label>
			<span class="spanstyle">备注:</span>
				<textarea name="collect_remark">${pcollect.collect_remark}</textarea>
			</label>
			<div align="center" style="width: 100%" id="toedit">
				<input type="button" class="button" value="修改" id="toeditbtn"/>
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
     <!-- typeahead.js -->
    <script type="text/javascript" src="<c:url value="/resources/js/boot/js/typeahead.bundle.js"/>"></script>
    <script type="text/javascript">
    var latins = new Bloodhound({
        datumTokenizer: Bloodhound.tokenizers.obj.whitespace('latin_name'),
        queryTokenizer: Bloodhound.tokenizers.whitespace,
        // 在文本框输入字符时才发起请求
        remote: '../../pspecies/auto?latin_name=%QUERY'
    });
    latins.initialize();
   
    $('.typeahead').typeahead(null, {
        name: 'latin_name',
        displayKey: 'latin_name',
        source: latins.ttAdapter()
    });
    $('.typeahead').on('typeahead:selected', function (e, datum) {
    	$("#genus").val(datum.genus_val);
    	$("#family").val(datum.family);
    	$("#chinese_name").val(datum.chinese_name);
    	$("#species_id").val(datum.species_id);
    });
    $(function(){  
    	var live_type = $("#live_type").val();
    	$("#live_type_id").val(live_type);
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
			
			var data = $("#plantsCollect").serialize();
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
	});
    </script>	
</body>
</html>