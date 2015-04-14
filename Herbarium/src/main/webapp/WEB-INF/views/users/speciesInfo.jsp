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
<style type="text/css">
#page_heading {
  padding: 10px 0 0 0;
  border-bottom: 1px solid #93a4b0;
  background: #e2e9ef;
}
.site_column{
  width: 940px;
  margin: 50px auto 0px;
  
}
#page_heading .hgroup {
  float: left;
  width: 670px;
  padding: 10px 0 20px 10px;
}
#page_heading h1 {
  font-size: 2em;
  font-weight: normal;
  color: #394651;
}
#page_heading ul.nav{
  clear: both;
  position: relative;
  bottom: -1px;
}
.gallery{
	overflow: hidden;
	padding: 10px 20px 10px 20px;
	border: 1px solid #cad3db;
}

.gallery ul{
	float: right;list-style: none;width: 100px;padding: 0;background: transparent;
	min-height: 300px;min-width: 100px;
}

.gallery ul li{
	text-align: center;
	line-height: 64px;
	margin-bottom: 10px;
	background: #e2e9ef;
	overflow: hidden;
	width: 98px;
  	height: 68px;
  	border: 1px solid #cad3db;
}

.gallery ul li.active {
  border: 3px solid #c1d62e;
  line-height: 64px;
  text-align: center;
}

.image{
	opacity: 1;
	width: 430px; 
	height: 300px;
	text-align: center;
	position: relative;
	float: left;
}
/* ul.nav li {
  float: left;
  margin: 0 1px 1px 0;
  border: 1px solid #d4dce2;
  background: #f1f4f7;
} */

.data_div{
	border: 1px solid #cad3db;background-color: #fefeff;background-image: linear-gradient(to bottom, #f3f7fa 0%, #fefeff 100%);padding: 10px 5px 10px;
}

.data_div ul{
	list-style: none;padding: 0px 0px;
	font-family: '微软雅黑';
}

.data_div ul li{
	padding: 2px 0px;
}

.data_div .character{
	height: 110px;
	overflow: hidden;
	overflow-y:auto;
}

.data_div .location{
	height: 70px;
	overflow: hidden;
	overflow-y:auto;
}

.summary .header{
	overflow: hidden;padding: 0 10px 0 0;margin: 0 -10px 12px -10px;border-bottom: 1px solid #394651;width:410px;
}
.summary .header h3{
	margin-top:5px;float: left;padding: 0 10px 3px 10px;margin-bottom:0px;font-size: 20px;border-bottom: 3px solid #394651;
}
#content{
	width:1000px;
	margin:140px auto 0px;
}
</style>
<title>物种列表</title>
</head>
<body>
	<div id="pagewrap" style=" margin: 0 auto">
	      <header class="content-header">
	    	<div class="container-main">
	    	</div>
		  </header>
		 <section class="section" style="min-height:1100px;margin:0px auto">
			<div class="with_nav" id="page_heading">
				<div class="site_column">
					<div class="hgroup">
						<h1 class="scientific_name">
							<i>${psinfo.latin_name}</i>
						</h1>
					</div>
					 <ul class="nav nav-tabs">
					  <li role="presentation" class="active" style="border: 1px solid #d4dce2;"><a href="<c:url value="/plants/${psinfo.species_id}"/>">概述</a></li>
					  <li role="presentation" style="border: 1px solid #d4dce2;"><a href="<c:url value="/plants/detail/${psinfo.species_id}"/>">详细信息</a></li>
					  <li role="presentation" style="border: 1px solid #d4dce2;"><a href="<c:url value="/plants/media/${psinfo.species_id}"/>">图片资源</a></li>
					</ul>
				</div>
			</div>
			
			 <div class="container-main">
			    <div class="module">
			    </div>
			 </div>
			
			<div id="content">
				<div id="images" style="float: left;width: 580px;">
					<div class="gallery" id="media_summary">
						<div class="image">
							<span style="height: 100%;display: inline-block;vertical-align: middle;"></span>
							<img  id="bigphoto" style="vertical-align:middle;">
						</div>
						<ul>
							<c:forEach varStatus="num" var="media" items="${medias.rows }">
								<c:choose>
									<c:when test="${num.index == 0}">
										<li class="active" id="initphoto" photobig ="${media.media_compress_big_path}"><a href="javascript:void(0)"><img src="/static_img/${media.media_compress_path }"></a></li>
									</c:when>
									<c:otherwise>
										<li photobig ="${media.media_compress_big_path}"><a href="javascript:void(0)"><img src="/static_img/${media.media_compress_path }"></a></li>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</ul>
						<p style="padding: 5px 0 0 0;font-weight: bold;float: left;">
						<a href="/pages/1153801/media">查看所有媒体</a>
						</p>
					</div>
				</div>
				
				<div id="rightarea" style="width: 400px;float: right;">
					<div class="summary">
						<div class="header">
							<h3>物种概述</h3>
						</div>
						<div class="data_div">
							<ul>
				             <li>&nbsp;&nbsp;<span style="font-weight: bold;">拉丁名称：</span><span style="font-style:italic" id="latinName">${psinfo.latin_name}</span></li>
				             <li>&nbsp;&nbsp;<span style="font-weight: bold;">中文名称：</span><span id="chineseName">${psinfo.chinese_name}</span></li>
				             <li>&nbsp;&nbsp;<span style="font-weight: bold;">科：</span><span id="family">${psinfo.family}</span></li>
				             <li>&nbsp;&nbsp;<span style="font-weight: bold;">属：</span><span id="genus">${psinfo.genus_val}</span></li>
				             <li class="character">&nbsp;&nbsp;<span style="font-weight: bold;">形态特征 ：</span><span id="genus">${psinfo.character}</span></li>
				             <li class="location">&nbsp;&nbsp;<span style="font-weight: bold;">产地分布 ：</span><span id="genus">${psinfo.location}</span></li>
				             <li style="float: right;">&nbsp;&nbsp;<a href="<c:url value="/plants/detail/${psinfo.species_id}"/>">查看所有信息</a></li>
	                        </ul>
						</div>
					</div>
					
					<div class="summary" style="margin-top: 20px;">
						<div class="header">
							<h3>系统分类位置</h3>
						</div>
						<div class="data_div">
							<ul>
								<c:forEach varStatus="num" var="pcs" items="${plantsCategories}">
									<li style="padding-left: ${10*num.index}px"><a href="<c:url value="/plants/species/${pcs.class_id }" />">${pcs.class_name} ${pcs.class_latin}</a></li>
								</c:forEach>
							</ul>
						</div>
					</div>
					
					<div class="summary" style="margin-top: 20px;">
						<div class="header">
							<h3>相关类群</h3>
						</div>
						<div class="data_div">
							<ul>
								<c:forEach varStatus="num" var="relates" items="${relateSpecies}">
									<li><a href="<c:url value="/plants/${relates.species_id }" />">${relates.chinese_name} ${relates.latin_name}</a></li>
								</c:forEach>
									<li>...</li>
							</ul>
						</div>
					</div>
				</div>
				<div id="leftarea" style="width: 580px;float: left;">
					<div class="summary" style="margin-top: 20px;">
						<div class="header" style="width: 580px;">
							<h3>评论列表</h3>
						</div>
						<div class="comment_div">
							<ul>
								<c:forEach varStatus="num" var="relates" items="${relateSpecies}">
									<li><a href="<c:url value="/plants/${relates.species_id }" />">${relates.chinese_name} ${relates.latin_name}</a></li>
								</c:forEach>
									<li>...</li>
							</ul>
						</div>
					</div>
				</div>
			</div>	
		</section>
		
		<div class="recommend_div" style="height: 200px;width:1000px;margin: -300px auto 0px;">
		  	<div class="summary" >
				<div class="header" style="width: 1000px;">
					<h3>和您浏览的物种相关的物种</h3>
				</div>
				<div class="comment_div">
					<ul>
						<c:forEach varStatus="num" var="relates" items="${relateSpecies}">
							<li><a href="<c:url value="/plants/${relates.species_id }" />">${relates.chinese_name} ${relates.latin_name}</a></li>
						</c:forEach>
							<li>...</li>
					</ul>
				</div>
			</div>
	 	</div>	
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
	  $(function(){  
		  //初始化第一张图片
		   var initphoto = $("#initphoto").attr("photobig");
	       $("#bigphoto").attr("src","/static_img/"+initphoto);
		  
	        $(".gallery li").click(function(){  
	            $(this).addClass("active");  
	            $(this).siblings().removeClass("active");     
	            var path = $(this).attr("photobig");
	            $("#bigphoto").attr("src","/static_img/"+path);
	        });  
	   });  
 </script>
</html>