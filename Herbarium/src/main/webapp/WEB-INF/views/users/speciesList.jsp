<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- Bootstrap Core CSS -->
<link href="<c:url value="/resources/css/boot/css/bootstrap.min.css"/>" rel="stylesheet">
<link href="<c:url value="/resources/css/local/example.css"/>" rel="stylesheet">
<!-- user style css -->
<link href="<c:url value="/resources/css/local/u_style.css"/>" rel="stylesheet">
 
<title>物种列表</title>
</head>
<body>
	<div id="content" style=" margin: 0 auto -150px;">
	      <header class="content-header">
	    	<div class="container-main">
	    	</div>
		  </header>
	
		 <div class="container-main">
		    <div class="module">
		    </div>
		 </div>
	    <form id="s_form" method="get">
		    <div class="input-group" style="width: 500px;margin: 0 auto">
		      <input type="text" id="query" name="q" class="typeahead" value="${q }"  placeholder="搜索..." style="height: 34px;margin-top: 15px;">
		      <span class="input-group-btn">
		        <button class="btn btn-default" type="button" onclick="search(0)">搜索</button>
		      </span>
		    </div>
	     </form>
	
		<section class="section" style="width:1000px;min-height:300px;margin:0px auto" id="testimonials">
		    <div class="row">
	           <div class="col-lg-12" style="margin-bottom: 200px">
	               <div class="panel panel-default">
	                   <div class="panel-body" style="min-height: 350px;">
	                       <div class="table-responsive">
	                           <table class="table table-striped table-bordered table-hover" id="dataTables-example">
	                               <thead>
	                                   <tr>
	                                       <th style="text-align: center;">拉丁名</th>
	                                       <th style="text-align: center;">中文名</th>
	                                       <th style="text-align: center;">科</th>
	                                       <th style="text-align: center;">属</th>
	                                   </tr>
	                               </thead>
	                               <tbody>
	                               	 <c:forEach var="list" items="${pagination.rows}">
	                                   <tr>
	                                       <td style="font-style: italic;"><a href="<c:url value="/plants/${list.species_id}"/>"> ${list.latin_name}</a></td>
	                                       <td style="text-align: center;">${list.chinese_name}</td>
	                                       <td style="text-align: center;">${list.family}</td>
	                                       <td style="text-align: center;">${list.genus_val}</td>
	                                   </tr>
	                                 </c:forEach>
	                               </tbody>
	                           </table>
	                       </div>
	                   </div>
	               </div>
	               <nav>
					  <ul class="pager">
					  	<li> 每页显示：<select id="limit" onchange="search(0)">
					  					<option value="10">10</option>
					  					<option value="20">20</option>
					  					<option value="30">30</option>
					  				</select>
					  				<input type="hidden" value="${pagination.limit}" id="limit_val">
					  				<input type="hidden" value="${pagination.totalPage}" id="totalPage">
					  	</li>
					  	<c:if test="${pagination.page ==1}">
					  		<li class="disabled" ><a href="javascript:void(0)">上一页</a></li>
		  			 	</c:if>
		  			 	<c:if test="${pagination.page >1}">
		  			 		<li><a href="javascript:void(0)" onclick="search(${pagination.page-1})">上一页</a></li>
		  			 	</c:if>
		  			 		<li>当前第<input value="${pagination.page }" id="currentPage" style="width: 30px;"/>页/共${pagination.totalPage }页</li>
		  			 	<c:if test="${pagination.page == pagination.totalPage}">
		  			 		<li class="disabled"><a href="javascript:void(0)">下一页</a></li>
		  			 	</c:if>
		  			 	<c:if test="${pagination.page != pagination.totalPage}">
		  			 		<li><a href="javascript:void(0)" onclick="search(${pagination.page +1})">下一页</a></li>
		  			 	</c:if>
					  </ul>
					</nav>
	           </div>
	       </div>
		</section>
    </div>
	<footer id="footer" class="footer">
	<div class="container">
	    <div class="row">
	        <div class="span10 offset1">
	            <div class="row" style="text-align: center;">
	               		北京林业大学
	            </div>
	        </div>
	    </div>
	</div>
	</footer>
</body>
<!-- jQuery -->
<script src="<c:url value="/resources/js/boot/js/jquery.js"/>"></script>

 <!-- Bootstrap Core JavaScript -->
 <script src="<c:url value="/resources/js/boot/js/bootstrap.min.js"/>"></script>
 <script type="text/javascript" src="<c:url value="/resources/js/boot/js/typeahead.bundle.js"/>"></script>
	<script type="text/javascript">
	 var latins = new Bloodhound({
	        datumTokenizer: Bloodhound.tokenizers.obj.whitespace('name'),
	        queryTokenizer: Bloodhound.tokenizers.whitespace,
	        limit : 20,
	        // 在文本框输入字符时才发起请求
	        remote: '../../auto/%QUERY/20'
	    });
	    latins.initialize();
	   
	    $('.typeahead').typeahead(null, {
	        name: 'name',
	        displayKey: 'name',
	        source: latins.ttAdapter()
	    });
	    $('.typeahead').on('typeahead:selected', function (e, datum) {
	    	$("#genus").val(datum.genus_val);
	    	$("#family").val(datum.family);
	    	$("#chinese_name").val(datum.chinese_name);
	    	$("#species_id").val(datum.species_id);
	    });
	  $(
		  function init(){
			  var limit =  $('#limit_val').val();
			  $("#limit").val(limit);
		  }
	  )  
	  function search(page){
		  var limit = $("#limit").val();
		  $("#s_form").attr('action','../../'+page+'/'+limit+'/');
		  $("#s_form").submit();
	  }
	  $('#query').bind('keyup', function(event) {
		  if(event.keyCode == '13'){
			  search(1);
		  }
	  })
	  $('#currentPage').bind('keyup', function(event) {
	        if (event.keyCode == "13") {
	        	var page = $("#currentPage").val();
	        	var totalPage = $("#totalPage").val();
	        	if(!isNaN(page)){
	        		totalPage = parseInt(totalPage);
	        		if(page > totalPage){
	        			page = totalPage;
	        		}else if(page <0){
	        			page = 1;
	        		}
	        		search(page);
	        	}else{
	        		search(1);
	        	}
	        }
	    });
	  
 </script>
</html>