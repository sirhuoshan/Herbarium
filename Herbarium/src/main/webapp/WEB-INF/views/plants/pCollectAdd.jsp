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
<title>新增类别</title>
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
           <form id="plantsCollect" class="basic-grey" action="<c:url value="/pcollect"/>" method="post" >
			<h1>植物采集信息添加
			</h1>
			<label>
			<span class="spanstyle">采集号  :</span>
			<input id="collect_id" name="collect_id" type="text" class="inputstyle">
			</label>
			<label>
			<span class="spanstyle">采集人  :</span>
			<input id="collecter" name="collecter" type="text" class="inputstyle"/>
			</label>
			<label>
			<span class="spanstyle">拉丁名  :</span>
			<input id="latin_name" name="latin_name" type="text" class="typeahead"/>
			</label>
			<label>
			<span class="spanstyle">中文名  :</span>
			<input id="chinese_name" name="chinese_name" readonly="readonly" type="text" class="inputstyle"/>
			</label>
			<label>
			<span class="spanstyle">科  :</span>
			<input id="family" type="text" readonly="readonly" class="inputstyle"/>
			<input id="species_id" name="species_id" type="hidden" />
			</label>
			<label>
			<span class="spanstyle">属  :</span>
			<input id="genus" type="text" readonly="readonly" class="inputstyle"/>
			</label>
			<label>
			<span class="spanstyle">标本俗名  :</span>
			<input id="trivial_name" name="trivial_name" type="text" class="inputstyle"/>
			</label>
			<label>
			<span class="spanstyle">采集日期  :</span>
			<input id="collect_date" name="collect_date" type="text" class="inputstyle"/>
			</label>
			<label>
			<span class="spanstyle">国际代码  :</span>
			<input id="intenational_codes" name="intenational_codes" type="text" class="inputstyle"/>
			</label>
			<label>
			<span class="spanstyle">国家 :</span>
			<input id="country" name="country" type="text" class="inputstyle"/>
			</label>
			<label>
			<span class="spanstyle">省  :</span>
			<input id="province" name="province" type="text" class="inputstyle"/>
			</label>
			<label>
			<span class="spanstyle">市  :</span>
			<input id="city" name="city" type="text" class="inputstyle"/>
			</label>
			<label>
			<span class="spanstyle">区  :</span>
			<input id="district" name="district" type="text" class="inputstyle"/>
			</label>
			<label>
			<span class="spanstyle">县  :</span>
			<input id="county" name="county" type="text" class="inputstyle"/>
			</label>
			<label>
			<span class="spanstyle">镇  :</span>
			<input id="town" name="town" type="text" class="inputstyle"/>
			</label>
			<label>
			<span class="spanstyle">详细地址  :</span>
			<input id="detail_area" name="detail_area" type="text" class="inputstyle"/>
			</label>
			<label>
			<span class="spanstyle">地形及生境:</span>
				<textarea name="live_environment"></textarea>
			</label>
			<label>
			<span class="spanstyle">经度  :</span>
			<input id="longitude" name="longitude" type="text" class="inputstyle"/>
			</label>
			<label>
			<span class="spanstyle">纬度 :</span>
			<input id="latitude" name="latitude" type="text" class="inputstyle"/>
			</label>
			<label>
			<span class="spanstyle">海拔  :</span>
			<input id="elevation" name="elevation" type="text" class="inputstyle"/>
			</label>
			<label>
			<span class="spanstyle">生活型 :</span>
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
			<input id="height" name="height" type="text" class="inputstyle"/>
			</label>
			<label>
			<span class="spanstyle">树皮:</span>
			<input id="bark" name="bark" type="text" class="inputstyle"/>
			</label>
			<label>
			<span class="spanstyle">枝:</span>
			<input id="branch" name="branch" type="text" class="inputstyle"/>
			</label>
			<label>
			<span class="spanstyle">叶:</span>
			<input id="leaf" name="leaf" type="text" class="inputstyle"/>
			</label>
			<label>
			<span class="spanstyle">花:</span>
			<input id="flower" name="flower" type="text" class="inputstyle"/>
			</label>
			<label>
			<span class="spanstyle">果实:</span>
			<input id="fruit" name="fruit" type="text" class="inputstyle"/>
			</label>
			<label>
			<span class="spanstyle">胸径（地径）:</span>
			<input id="dbh" name="dbh" type="text" class="inputstyle"/>
			<input id="isidentified" name="isidentified" type="hidden" value="y" class="inputstyle"/>
			</label>
			<label>
			<span class="spanstyle">资源状况:</span>
				<textarea name="resource_state"></textarea>
			</label>
			<label>
			<span class="spanstyle">备注:</span>
				<textarea name="collect_remark"></textarea>
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
     <!-- typeahead.js -->
    <script type="text/javascript" src="<c:url value="/resources/js/boot/js/typeahead.bundle.js"/>"></script>
    <script type="text/javascript">
    var latins = new Bloodhound({
        datumTokenizer: Bloodhound.tokenizers.obj.whitespace('latin_name'),
        queryTokenizer: Bloodhound.tokenizers.whitespace,
        // 在文本框输入字符时才发起请求
        remote: '../pspecies/auto?latin_name=%QUERY'
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
	  //添加类别
		$("#savebtn").click(function(){
			//改变button样式
			var savebtn = $("#savebtn");
			savebtn.attr("class","saving_button");
			savebtn.val("保存中...");
			$("#plantsCollect").submit();
		});
		
		$("#savedbtn").click(function(){
			$("#savebtn").show();
			$("#savedbtn").hide();
		});
	});
    </script>	
</body>
</html>