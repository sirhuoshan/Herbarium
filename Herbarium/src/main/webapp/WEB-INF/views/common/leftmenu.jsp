<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
  	html,body{ margin:0px; height:100%;} 
</style>
</head>
<body>
<nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
     <div class="navbar-header" style="height: 10%">
         <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
             <span class="sr-only">Toggle navigation</span>
             <span class="icon-bar"></span>
             <span class="icon-bar"></span>
             <span class="icon-bar"></span>
         </button>
         <a class="navbar-brand" href="index.html">北京林业大学博物馆</a>
     </div>
     <!-- /.navbar-header -->
     <ul class="nav navbar-top-links navbar-right">
         <!-- /.dropdown -->
         <li class="dropdown">
             <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                 <i class="fa fa-user fa-fw"></i>  <i class="fa fa-caret-down"></i>
             </a>
             <ul class="dropdown-menu dropdown-user">
                 <li><a href="#"><i class="fa fa-user fa-fw"></i> User Profile</a>
                 </li>
                 <li><a href="#"><i class="fa fa-gear fa-fw"></i> Settings</a>
                 </li>
                 <li class="divider"></li>
                 <li><a href="login.html"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
                 </li>
             </ul>
             <!-- /.dropdown-user -->
         </li>
         <!-- /.dropdown -->
     </ul>
     <!-- /.navbar-top-links -->

     <div class="navbar-default sidebar" role="navigation">
         <div class="sidebar-nav navbar-collapse">
             <ul class="nav" id="side-menu">
                 <li>
                     <a class="active" href="index.html"><i class="fa fa-dashboard fa-fw"></i> 主页</a>
                 </li>
                 <li>
                     <a href="<c:url value="/pspecies/species" />"><i class="fa fa-wrench fa-fw"></i>物种管理</a>
                 </li>
                <li>
                     <a href="<c:url value="/pcollect/collects" />"><i class="fa fa-wrench fa-fw"></i>标本管理</a>
                 </li>
                 <li>
                     <a href="<c:url value="/pcategory/tree" />"><i class="fa fa-sitemap fa-fw"></i> 标本分类树</a>
                 </li>
             </ul>
         </div>
         <!-- /.sidebar-collapse -->
     </div>
     <!-- /.navbar-static-side -->
 </nav>
</body>
</html>