<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Insert title here</title>
<!-- Bootstrap Core CSS -->
<link href="<c:url value="/resources/css/boot/css/bootstrap.min.css"/>" rel="stylesheet">
<link href="<c:url value="/resources/css/local/example.css"/>" rel="stylesheet">
<!-- user style css -->
<link href="<c:url value="/resources/css/local/u_style.css"/>" rel="stylesheet">
</head>
<body>
	<div id="lg" style="text-align: center;margin-top: 50px;">
		<img src="<c:url value="/resources/css/images/banner.png"/>" width="500px;" height="89px;">
	</div>
	<div class="row" style="text-align: center;margin-top: 20px;">
	    <form id="s_form"  method="get">
	    <div class="input-group" style="width: 500px;margin: 0 auto">
	      <input type="text" id="query" name="q" class="typeahead"  placeholder="搜索..." style="height: 34px;margin-top: 15px;">
	      <span class="input-group-btn">
	        <button class="btn btn-default" type="button" onclick="search()">搜索</button>
	      </span>
	    </div>
	     </form>
	</div>
	
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
	        remote: 'plants/auto/%QUERY/20'
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
	   
	    $('#query').bind('keyup', function(event) {
		  if(event.keyCode == '13'){
			  search();
		  }
	   });  
	    
	  function search(){
		  $("#s_form").attr('action','plants/0/10/');
		  $("#s_form").submit();
	  }  
	</script>
</body>
</html>