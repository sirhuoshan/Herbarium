/**
 * 
 */

Ext.define('Herbarium.bacterium.bacteriumSpeGrid',{
	extend: "Ext.panel.Panel",
	border: false,
    aliases: 'bacteriumSpeGrid',
	baseCls : 'x-plain',
	selMod: null,
	layout: 'border',
	autoWidth: true,
	autoHeight: true,
	buttonAlign: 'center',
	initComponent: function () {//构造函数
		var me = this;
		
		var userGridBbar = Ext.create('Ext.PagingToolbar',{
			dock: 'bottom',
			//store: userStore,
	        displayInfo: true,
	        displayMsg:'当前显示 {0} - {1}条, 共 {2}条',
	        emptyMsg: "没有要显示的内容"
		});
		
		var bacteriumGrid = Ext.create('Ext.grid.Panel',{
			id: 'bacteriumSpeGrid',
			region: 'center',
			columnLines: true,
			//store:userStore,
		    selModel: me.selMod,
		    dockedItems: [userGridBbar],
			border:false,
			columns: [{heard:"id",width:30}],
			tbar : [{
					columnWidth : 1,
					margin:4,
					xtype : 'button',
					text : '新增',
					handler : function(){
						var addSpeForm = Ext.create('Herbarium.bacterium.bacteriumSpeAdd');
						Ext.create('Ext.window.Window',{
			        		title:'新增物种',
			        		closable:true,
			        		closeAction:'destroy',
			        		modal:true,
			        		width:700,
			        		height:530,
			        		resizable:false,
							border:false,
							layout:'fit',
							items:[addSpeForm]
							/*initComponent: function() {
						    	var me = this;
						    	
							}*/
			        	}).show();
					}
				},{
					xtype : 'textfield',
					fieldLabel : '用户名',
					id: 'userGridName',
					name: 'userGridName',
					labelWidth : 50
				},{
					columnWidth : .1,
					margin:4,
					xtype : 'button',
					text : '查 询',
					handler : me.searchUserGrid
			}]
		});
		me.items = [bacteriumGrid];
	    me.superclass.initComponent.call(me); //调用父类的构造函数
	},
});