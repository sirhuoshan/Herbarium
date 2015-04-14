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
	<link href="<c:url value="/resources/css/local/speciesform.css"/>" rel="stylesheet">
	
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
            <table id="pspecies" class="easyui-datagrid" title="植物物种" fit="true"
		            data-options="
		                url: '<c:url value="/pspecies"/>',
		                method:'get',
		                rownumbers: true,
		                pagination: true,
		                pageSize: 10,
		                pageList: [10,20,30],
		                fitColumns :true,
		                idField: 'speciesID',
		                treeField: 'latinName',
		                singleSelect:true,
						toolbar:'#tb'">
		        <thead>
		            <tr>
		                <th field="chinese_name" width="100" align="left">中文名</th>
		                <th field="latin_name" width="100" align="left" styler="cellLatinStyler">拉丁名</th>
		                <th field="family" width="100" align="left">科</th>
		                <th field="genus_val" width="100" align="left">属</th>
		            </tr>
		        </thead>
		    </table>
		    <!-- toolbar -->
    		<div id="tb" style="padding:2px 5px;">
			  <button type="button" class="btn btn-primary" style="height: 28px;padding: 0 6px;" id="pspeciesAdd">
			  	<span class="glyphicon glyphicon-plus"></span> 增加
			  </button>
			  <button type="button" class="btn btn-primary" style="height: 28px;padding: 0 6px;" id="pspeciesEdit">
		  	  	<span class="glyphicon glyphicon-pencil"></span> 修改
			  </button>
			  <button type="button" class="btn btn-primary" style="height: 28px;padding: 0 6px;" id="pspeciesCheck">
		  	  	<span class="glyphicon glyphicon-search"></span> 查看
			  </button>
			  <button type="button" class="btn btn-primary" style="height: 28px;padding: 0 6px;" id="pspeciesDel">
		  	  	<span class="glyphicon glyphicon-remove"></span> 删除
			  </button>
			  <button type="button" class="btn btn-primary" style="height: 28px;padding: 0 6px;" id="pspeciesMedia">
		  	  	<span class="glyphicon glyphicon-search"></span> 多媒体信息
			  </button>
			  
			  <select id="pSpeciesSearchKey" class="form-control"  style="width: 15%;display: inline;vertical-align: middle;">
                <option value="chinese_name">物种中文名</option>
                <option value="latin_name">物种拉丁名</option>
                <option value="family">科</option>
                <option value="genus">属</option>
              </select>
			  <input type="text" id="pSpeciesSearchValue" class="form-control" placeholder="查询..." style="width: 20%;display: inline;vertical-align: middle;">
              <button id="pSpeciesSearch" class="btn btn-default" type="button">
                 <i class="fa fa-search"></i>
              </button>
			</div>
       	</div>
        <!-- /#page-wrapper -->
    </div>
    <!-- /#wrapper -->
    
     <!-- 显示标本类别信息 -->
	<div class="modal fade" id="pspeciesShow" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display: none;">
          <div class="modal-dialog">
              <div class="modal-content" style="width: 900px;">
                  <div class="modal-header">
                      <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                      <h4 class="modal-title" id="myModalLabel">标本类别信息</h4>
                  </div>
                  <div class="modal-body" style="padding: 0 0">
                  	  <form class="basic-grey" style="height: 500px;">
							<div>
							<label>
							<span class="spanstyle">物种拉丁名  :</span>
							<input id="latin_name" name="latin_name" type="text" class="inputstyle">
							</label>
							<label>
							<span class="spanstyle">物种中文名  :</span>
							<input id="chinese_name" name="chinese_name" type="text" class="inputstyle"/>
							</label>
							<label>
							<span class="spanstyle">科  :</span>
							<input id="family" name="family" type="text" class="inputstyle" readonly="readonly"/>
							</label>
							<label>
							<span class="spanstyle">属  :</span>
							<input id="genus" name="genus" type="hidden">
							<input id="genusval"  type="text" class="inputstyle"  readonly="readonly"/>
							</label>
							<label>
							<span class="spanstyle">物种异名 :</span>
							<input id="other_name" name="other_name"  type="text" class="inputstyle" />
							</label>
							<label>
							<span class="spanstyle">花果期  :</span>
							<input id="fruit_period" name="fruit_period"  type="text" class="inputstyle"/>
							</label>
							<label>
							<span class="spanstyle">栽培与繁殖 :</span>
							<textarea id="growth" name="growth"></textarea>
							</label>
							<label>
							<span class="spanstyle">用途  :</span>
							<textarea id="use"  name="use"></textarea>
							</label>
							<label>
							<span class="spanstyle">形态特征  :</span>
							<textarea id="character" name="character"></textarea>
							</label>
							<label>
							<span class="spanstyle">产地分布  :</span>
							<textarea id="location" name="location"></textarea>
							</label>
							<label>
							<span class="spanstyle">保护等级  :</span>
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
							</div>
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
    
    <!-- plants category operate -->
    <script type="text/javascript" src="<c:url value="/resources/js/plants/pSpeciesOp.js"/>"></script>
    
    <script type="text/javascript">
    
    $(function(){
    	//点击搜索
    	$("#pSpeciesSearch").click(function(){
    		var key = $('#pSpeciesSearchKey').val();
    		var value = $('#pSpeciesSearchValue').val();
    		var data = {};
    		data[key] = value;
    		$('#pspecies').datagrid('load',data);
    	});
    });
    
    //拉丁文格式
    function cellLatinStyler(value,row,index){
        return 'font-style: italic;';
    }
    
    
    </script>
</body>
</html>