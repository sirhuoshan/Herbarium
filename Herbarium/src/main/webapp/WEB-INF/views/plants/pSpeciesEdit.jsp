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
            <form id="pspeciesEdit" class="basic-grey">
			<h1>植物物种修改
			</h1>
			<label>
			<span class="spanstyle">物种拉丁名  :</span>
			<input class="typeahead" id="species_id" name="species_id" value="${pspecies.species_id}" type="hidden">
			<input class="typeahead" id="latin_name" name="latin_name" value="${pspecies.latin_name}" type="text" class="inputstyle"  placeholder="请输入拉丁名">
			</label>
			<label>
			<span class="spanstyle">物种中文名  :</span>
			<input id="chinese_name" name="chinese_name" type="text" value="${pspecies.chinese_name}" class="inputstyle"/>
			</label>
			<label>
			<span class="spanstyle">科  :</span>
			<input id="family" name="family" type="text" value="${pspecies.family}" class="inputstyle" readonly="readonly"/>
			</label>
			<label>
			<span class="spanstyle">属  :</span>
			<input id="genus" name="genus" type="hidden" value="">
			<input id="genusval"  type="text" class="inputstyle" value="${pspecies.genus_val}" readonly="readonly"/>
			</label>
			<label>
			<span class="spanstyle">物种异名 :</span>
			<input id="other_name" name="other_name"  type="text" value="${pspecies.other_name}" class="inputstyle" />
			</label>
			<label>
			<span class="spanstyle">花果期  :</span>
			<input id="fruit_period" name="fruit_period"  type="text" value="${pspecies.fruit_period}" class="inputstyle"/>
			</label>
			<label>
			<span class="spanstyle">栽培与繁殖 :</span>
			<textarea name="growth">${pspecies.growth}</textarea>
			</label>
			<label>
			<span class="spanstyle">用途  :</span>
			<textarea name="use">${pspecies.use}</textarea>
			</label>
			<label>
			<span class="spanstyle">形态特征  :</span>
			<textarea name="character">${pspecies.character}</textarea>
			</label>
			<label>
			<span class="spanstyle">产地分布  :</span>
			<textarea name="location">${pspecies.location}</textarea>
			</label>
			<label>
			<span class="spanstyle">保护等级  :</span>
			<input id="protect_id_val" value="${pspecies.protect_id}" type="hidden">
			<input id="iucn_id_val" value="${pspecies.iucn_id}" type="hidden">
			<input id="cites_id_val" value="${pspecies.cites_id}" type="hidden">
			<input id="redbook_id_val" value="${pspecies.redbook_id}" type="hidden">
			
			<select id="protect_id" name="protect_id">
				<option value="">请选择保护等级</option>
				<option value="1">Ⅰ</option>
				<option value="2">Ⅱ</option>
				<option value="3">濒危植物</option>
			</select>
			</label>
			<label>
			<span class="spanstyle">IUCEN等级：</span>
				<select id="iucn_id" name="iucn_id">
					<option value="">请选择IUCN等级</option>
					<option value="1">NE</option>
					<option value="2">DD</option>
					<option value="3">LC</option>
					<option value="4">NT</option>
					<option value="5">VU</option>
					<option value="6">EN</option>
					<option value="7">CR</option>
					<option value="8">EW</option>
					<option value="9">EX</option>
				</select>
			</label>
			<label>
			<span class="spanstyle">CITES等级：</span>
				<select id="cites_id" name="cites_id">
					<option value="">请选择CITES等级</option>
					<option value="1">附录一</option>
					<option value="2">附录二</option>
					<option value="3">附录三</option>
				</select>
			</label>
			<label>
			<span class="spanstyle">红皮书等级：</span>
				<select id="redbook_id" name="redbook_id">
					<option value="">请选择RedBook等级</option>
					<option value="1">绝灭EX </option>
					<option value="2">野外绝灭EW</option>
					<option value="3">极危CR</option>
					<option value="4"> 濒危EN</option>
					<option value="5">易危VU </option>
					<option value="6">近危NT</option>
					<option value="7"> 无危LC</option>
				</select>
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
    <!-- typeahead.js -->
    <script type="text/javascript" src="<c:url value="/resources/js/boot/js/typeahead.bundle.js"/>"></script>
    <script type="text/javascript">
    var latins = new Bloodhound({
        datumTokenizer: Bloodhound.tokenizers.obj.whitespace('class_latin'),
        queryTokenizer: Bloodhound.tokenizers.whitespace,
        // 在文本框输入字符时才发起请求
        remote: '../../pcategory/auto?class_latin=%QUERY'
    });
    latins.initialize();
   
    
    $('.typeahead').typeahead(null, {
        name: 'class_latin',
        displayKey: 'class_latin',
        source: latins.ttAdapter()
    });
    $('.typeahead').on('typeahead:selected', function (e, datum) {
    	$("#genusval").val(datum.class_name + '  ' + datum.class_latin);
    	$("#genus").val(datum.class_id);
    	var class_id = datum.parent_id;
        $.ajax({
        	url:'../../pcategory/'+class_id,
        	type:'get',
        	success:function(result){
        		if(result.status){
        			$("#family").val(result.obj.class_name + '  ' + result.obj.class_latin);
        		}
        	}
        });
    });
    $(function(){    
    	//修改类别
		$("#editbtn").click(function(){
			
			//序列化表单数据
			var data = $("#pspeciesEdit").serialize();
			
			$.ajax({
				url:"../../pspecies/",
				data:data,
				type:'put',
				dataType:'json',
				success:function(result){
					if(result.status){
						msg('修改成功',3000,result.obj,'fade');
						window.location.href = "../../pspecies/species";
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
		
		var protect_id_val = $("#protect_id_val").val();
		var iucn_id_val = $("#iucn_id_val").val();
		var cites_id_val = $("#cites_id_val").val();
		var redbook_id_val = $("#redbook_id_val").val();

		$("#protect_id").val(protect_id_val);
		$("#iucn_id").val(iucn_id_val);
		$("#cites_id").val(cites_id_val);
		$("#redbook_id").val(redbook_id_val);
	});
	    
    </script>	
</body>
</html>