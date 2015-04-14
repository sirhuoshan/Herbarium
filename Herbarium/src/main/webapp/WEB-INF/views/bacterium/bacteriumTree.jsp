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
            <table id="bcategory" title="标本分类树" fit="true"
		            data-options="
		                url: '<c:url value="/bcategory/category"/>',
		                method:'get',
		                rownumbers: true,
		                pagination: true,
		                pageSize: 10,
		                pageList: [10,20,30],
		                fitColumns :true,
		                idField: 'class_id',
		                treeField: 'class_name',
		                queryParams: {
							'parent_id': '0'
						},
						toolbar:'#tb'">
		        <thead>
		            <tr>
		                <th field="class_name" width="100" align="left">中文名</th>
		                <th field="class_latin" width="100" align="left" styler="cellLatinStyler">拉丁名</th>
		            </tr>
		        </thead>
		    </table>
		    <!-- toolbar -->
    		<div id="tb" style="padding:2px 5px;">
			  <button type="button" class="btn btn-primary" style="height: 28px;padding: 0 6px;" id="bcAdd">
			  	<span class="glyphicon glyphicon-plus"></span> 增加
			  </button>
			  <button type="button" class="btn btn-primary" style="height: 28px;padding: 0 6px;" id="bcEdit">
		  	  	<span class="glyphicon glyphicon-pencil"></span> 修改
			  </button>
			  <button type="button" class="btn btn-primary" style="height: 28px;padding: 0 6px;" id="bcCheck">
		  	  	<span class="glyphicon glyphicon-search"></span> 查看
			  </button>
			  <button type="button" class="btn btn-primary" style="height: 28px;padding: 0 6px;" id="bcDel">
		  	  	<span class="glyphicon glyphicon-remove"></span> 删除
			  </button>
			  <select id="bcSearchKey" class="form-control"  style="width: 15%;display: inline;vertical-align: middle;">
                <option value="class_name">类别中文名</option>
                <option value="class_latin">类别拉丁名</option>
              </select>
			  <input type="text" id="bcSearchValue" class="form-control" placeholder="查询..." style="width: 20%;display: inline;vertical-align: middle;">
              <button id="bcSearch" class="btn btn-default" type="button">
                 <i class="fa fa-search"></i>
              </button>
			</div>
       	</div>
        <!-- /#page-wrapper -->
    </div>
    <!-- /#wrapper -->
    
    <!-- 显示标本类别信息 -->
	<div class="modal fade" id="bacteriumCategryInfo" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display: none;">
          <div class="modal-dialog">
              <div class="modal-content">
                  <div class="modal-header">
                      <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                      <h4 class="modal-title" id="myModalLabel">标本类别信息</h4>
                  </div>
                  <div class="modal-body">
                  	  <form id="bcAdd" class="basic-grey">
						<label>
						<span>父类别 :</span>
						</label>
						<div id="categoryArea" style="padding-bottom: 10px;">
							
						</div>
						<label>
						<span>类别名 :</span>
						<input id="class_name" type="text" name="class_name" value="${category.class_name}"/>
						</label>
						<label>
						<span>类别拉丁名  :</span>
						<input id="class_latin" type="text" name="class_latin" style="font-style: italic;"  value="${category.class_latin}"/>
						</label>
						<label>
						<span>类别描述 :</span>
						<textarea id="class_describe" name="class_describe" >${category.class_describe}</textarea>
						</label>
					</form>
                  </div>
                  <div class="modal-footer">
                      <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                  </div>
              </div>
          </div>
      </div>
	
		
	<!-- footer and common js -->
	<%@ include file="../common/footer.jsp"%>
    <!-- easyui JavaScript -->
    <script type="text/javascript" src="<c:url value="/resources/js/easy/jquery.easyui.min.js"/>"></script>
    
     <!-- commom.js -->
    <script type="text/javascript" src="<c:url value="/resources/js/common/common.js"/>"></script>
    
    <!-- bacterium category operate -->
    <script type="text/javascript" src="<c:url value="/resources/js/bacterium/bCategoryOp.js"/>"></script>
    
    <script type="text/javascript">
    
    $(function(){
    	//点击搜索
    	$("#bcSearch").click(function(){
    		var key = $('#bcSearchKey').val();
    		var value = $('#bcSearchValue').val();
    		var data = {};
    		if(value == ''){
    			key = 'parent_id';
    			value = 0;
    		}
    		data[key] = value;
    		$('#bcategory').treegrid('load',data);
    	});
    });
    
    //过滤节点数据
    $('#bcategory').treegrid({
    	loadFilter:function(data){return TreeGridShow(data);}
    });
    
    //拉丁文格式
    function cellLatinStyler(value,row,index){
        return 'font-style: italic;';
    }
    
    //默认关闭所有的节点
    function TreeGridShow(data) {
        $(data.rows).each(function (index, item) {
	        if (item.children.length == 0) {
	            item.state = "open";
	        }
	        else{
	            item.state = "closed";
	            TreeGridShow(item.children);
	        }
        });
        return data;
    }
    
    </script>
</body>
</html>