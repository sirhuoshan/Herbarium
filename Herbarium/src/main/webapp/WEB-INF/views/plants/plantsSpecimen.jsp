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
<title>Insert title here</title>
<style type="text/css">
html,body{ margin:0px; height:100%;} 
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
       
        <div id="page-wrapper" style="height: 80%;">
            <table id="pspecimen" class="easyui-datagrid"  title="标本信息" fit="true"
		            data-options="
		                url: '<c:url value="/pcollect"/>',
		                method:'get',
		                rownumbers: true,
		                pagination: true,
		                pageSize: 10,
		                pageList: [10,20,30],
		                fitColumns :true,
		                idField: 'specimen_id',
		                treeField: 'latin_name',
						toolbar:'#tb'">
		        <thead>
		            <tr>
		                <th field="barcode_id" width="100" align="left">馆藏号</th>
		                <th field="collect_id" width="100" align="left">采集号</th>
		                <th field="chinese_name" width="100" align="left">中文名</th>
		                <th field="latin_name" width="100" align="left" styler="cellLatinStyler">拉丁名</th>
		                <th field="family" width="100" align="left">科</th>
		                <th field="genus" width="100" align="left">属</th>
		                <th field="collecter" width="100" align="left">采集人</th>
		            </tr>
		        </thead>
		    </table>
		    <!-- toolbar -->
    		<div id="tb" style="padding:2px 5px;">
			  <button type="button" class="btn btn-primary" style="height: 28px;padding: 0 6px;" id="pspecimenAdd">
			  	<span class="glyphicon glyphicon-plus"></span> 新增标本
			  </button>
			  <button type="button" class="btn btn-primary" style="height: 28px;padding: 0 6px;" id="pcollectCheck">
		  	  	<span class="glyphicon glyphicon-search"></span> 采集
			  </button>
			  <button type="button" class="btn btn-primary" style="height: 28px;padding: 0 6px;" id="pstorageCheck">
		  	  	<span class="glyphicon glyphicon-search"></span>馆藏
			  </button>
			  <button type="button" class="btn btn-primary" style="height: 28px;padding: 0 6px;" id="pidentifyCheck">
		  	  	<span class="glyphicon glyphicon-search"></span>鉴定
			  </button>
			  <button type="button" class="btn btn-primary" style="height: 28px;padding: 0 6px;" id="pmediaCheck">
		  	  	<span class="glyphicon glyphicon-search"></span>多媒体
			  </button>
			  <button type="button" class="btn btn-primary" style="height: 28px;padding: 0 6px;" id="pspecimenDel">
		  	  	<span class="glyphicon glyphicon-remove"></span> 删除
			  </button>
			  <select id="pspecimenSearchKey" class="form-control"  style="width: 15%;display: inline;vertical-align: middle;">
                <option value="barcode_id">馆藏号</option>
                <option value="chinese_name">中文名</option>
                <option value="latin_name">拉丁名</option>
                <option value="family">科</option>
                <option value="genus">属</option>
              </select>
			  <input type="text" id="pspecimenSearchValue" class="form-control" placeholder="查询..." style="width: 20%;display: inline;vertical-align: middle;">
              <button id="pspecimenSearch" class="btn btn-default" type="button">
                 <i class="fa fa-search"></i>
              </button>
			</div>
       	</div>
        <!-- /#page-wrapper -->
    </div>
    <!-- /#wrapper -->
		
	<!-- footer and common js -->
	<%@ include file="../common/footer.jsp"%>
    <!-- easyui JavaScript -->
    <script type="text/javascript" src="<c:url value="/resources/js/easy/jquery.easyui.min.js"/>"></script>
    
     <!-- commom.js -->
    <script type="text/javascript" src="<c:url value="/resources/js/common/common.js"/>"></script>
    
    <!-- plants category operate -->
    <script type="text/javascript" src="<c:url value="/resources/js/plants/pSpecimenOp.js"/>"></script>
    
    <script type="text/javascript">
    
    $(function(){
    	//点击搜索
    	$("#pspecimenSearch").click(function(){
    		var key = $('#pspecimenSearchKey').val();
    		var value = $('#pspecimenSearchValue').val();
    		var data = {};
    		if(value == ''){
    			key = 'parent_id';
    			value = 0;
    		}
    		data[key] = value;
    		$('#pspecimen').datagrid('load',data);
    	});
    });
    
    //拉丁文格式
    function cellLatinStyler(value,row,index){
        return 'font-style: italic;';
    }
    </script>
</body>
</html>