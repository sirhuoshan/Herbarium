<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/plugins/Extjs/ext-theme-neptune/ext-theme-neptune-all.css"/>" />  
<script type="text/javascript" src="<c:url value="/resources/js/plugins/Extjs/ext-all.js"/>"></script> 
<script type="text/javascript" src="<c:url value="/resources/js/plugins/Extjs/ext-lang-zh_CN.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/plugins/JQuery/jquery.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/extjs/common/common.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/extjs/bacterium/model/bacteriumModel.js"/>"></script>
<script type="text/javascript">
//Ext.Loader.setPath('common','/Herbarium/resources/extjs/common');
Ext.Loader.setPath('Herbarium.bacterium','/Herbarium/resources/extjs/bacterium');
Ext.Loader.setPath('Herbarium.bacterium.model','/Herbarium/resources/extjs/bacterium/model');

Ext.require([
    'Herbarium.bacterium.bacteriumGrid',
    'Herbarium.bacterium.bacteriumTree',
    'Herbarium.bacterium.bacteriumSpeAdd',
    'Herbarium.bacterium.bacteriumSpeGrid',
    'Herbarium.bacterium.model.bacteriumInfo'
]);

Ext.onReady(function(){
	Ext.create('Ext.container.Viewport', {
		layout: 'border',
		defaults: {
            split: true
        },
		items: [{
			region: 'north',
			bodyStyle: {  
				background: 'url(../resources1/images/background.jpg) no-repeat #157fcc',  
				padding: '10px'  
			}, 
			height:50,
			split: false,
			border: false,
			margins: '0 0 5 0',
			html: '<div align="right"><a class="exit" href="LoginAction_logout">[退出]</a></div>'
		}, {
			region: 'west',
			collapsible: true,
			title: '管理菜单',
			width: '15%',
			layout : 'accordion',
			items: [{
				/* title: '标本管理', */
				xtype: 'panel',
				layout: {
					type: 'vbox',
					align: 'center'
				},
				items: [{
					 xtype: 'button',
					/*  text : '菌物管理', */
					 icon : '../resources1/images/application.png',
					 width : '100%',
					 handler: function() {
						var bacteriumCenter = Ext.getCmp('bacteriumCenter');
						bacteriumCenter.remove("bacteriumListView",true); 
						bacteriumCenter.remove("bacteriumSpeListView",true); 
						var bacteriumListView = Ext.create('Herbarium.bacterium.bacteriumGrid',{
							id:'bacteriumListView',
							//renderTo:'bacteriumListPanel',
							listeners : {
								'render' : function(){
							 		this.updateBox(Ext.getCmp('bacteriumCenter').getSize());
							 	}
							}
						});
						bacteriumCenter.add(bacteriumListView).doLayout();
					}
				},{
					 xtype: 'button',
					 text : '物种管理', 
					 icon : '../resources1/images/action_add.png',
					 width : '100%',
					 handler: function() {
						 var bacteriumCenter = Ext.getCmp('bacteriumCenter');
						 bacteriumCenter.remove("bacteriumSpeListView",true); 
						 bacteriumCenter.remove("bacteriumListView",true); 
						 var bacteriumSpeListView = Ext.create('Herbarium.bacterium.bacteriumSpeGrid',{
								id:'bacteriumSpeListView',
								listeners : {
									'render' : function(){
								 		this.updateBox(Ext.getCmp('bacteriumCenter').getSize());
								 	}
								}
							});
						 bacteriumCenter.add(bacteriumSpeListView).doLayout();
					}
				}]
			},{
// 				/* title: '类别管理', */
				layout:'fit',
				items : [{
					xtype: 'bacteriumTree'
				}]
			}]
		}, {
			region: 'south',
			split: false,
			height: 45,
			layout: {
				type: 'vbox',
				align: 'center'
			},
			items: [{
				xtype: 'text',
				text: 'Copyright @ 北京林业大学信息学院',
			}]
		},{
			id : 'bacteriumCenter',
			region: 'center',
		}]
	});
});
</script> 
<title></title>
</head>
<body>
	
</body>
</html>