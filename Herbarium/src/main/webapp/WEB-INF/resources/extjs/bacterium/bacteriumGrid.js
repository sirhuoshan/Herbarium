/**
 * 
 */
Ext.define('Herbarium.bacterium.bacteriumGrid',{
	extend: "Ext.panel.Panel",
	border: false,
    aliases: 'bacteriumGrid',
	baseCls : 'x-plain',
	selMod: null,
	layout: 'border',
	autoWidth: true,
	autoHeight: true,
	buttonAlign: 'center',
	initComponent: function () {//构造函数
		var me = this;
		
		var bacteriumInfoStore = Ext.create('Ext.data.Store',{
			id: 'bacteriumInfoStore',
			model: 'Herbarium.bacterium.model.bacteriumInfo',
			remoteStore: true,
			pageSize: 10,
			proxy:{
				type: 'ajax',
				actionMethods:{
	                create: "POST", read: "POST", update: "POST", destroy: "POST"
				},
				url: '../bacterium/queryBacterium.html',
				reader: {
					type: 'json',
					root: 'result.list',
					totalProperty: 'result.totalRecord'
				},
				simpleSortMode: true
			}
		});
		bacteriumInfoStore.load();
		
		var bacteriumGridBar = Ext.create('Ext.PagingToolbar',{
			dock: 'bottom',
			store: bacteriumInfoStore,
	        displayInfo: true,
	        displayMsg:'当前显示 {0} - {1}条, 共 {2}条',
	        emptyMsg: "没有要显示的内容"
		});
		
		var bacteriumGrid = Ext.create('Ext.grid.Panel',{
			id: 'bacteriumGrid',
			region: 'center',
			columnLines: true,
			store:bacteriumInfoStore,
		    selModel: me.selMod,
		    dockedItems: [bacteriumGridBar],
			border:false,
			columns: [
				Ext.create('Ext.grid.RowNumberer'),
				{
					text: "馆藏号",
					sortable:true,
					flex:1,
                    dataIndex: 'specimen_number'
                 },{
                    text: "采集号或其他号", 
                    dataIndex: 'collect_id',
                    flex:1
                 },{
                     text: "菌物名", 
                     flex: 1, 
                     dataIndex: 'bacterium_name'
                 },{
                     text: "菌物拉丁名", 
                     flex: 2, 
                     dataIndex: 'bacterium_latin'
                 },{
                     text: "目", 
                     flex: 2, 
                     dataIndex: 'order'
                 },{
                     text: "科", 
                     flex: 2, 
                     dataIndex: 'family'
                 },{
                     text: "属", 
                     flex: 2, 
                     dataIndex: 'genus'
                 },{
                     text: "采集人", 
                     flex: 1, 
                     dataIndex: 'collecter'
                 }],
			loadMask:true,
			tbar : [{
					columnWidth : 1,
					margin:4,
					xtype : 'button',
					text : '新增',
					handler : function(){
						var addForm = Ext.create('Herbarium.bacterium.bacteriumAdd');
					/*	Ext.create('Ext.tab.Tab',{
			        		title:'新增标本',
			        		alias:'widget.center',  
			                activeTab:0,  
			                width:500,  
			                height:400,  
			                region:'center', 
			        		items:[addForm],
			        		initComponent:function(){  
					            this.callParent(arguments);  
					        }  
			        	}).show();*/
						Ext.create('Ext.window.Window',{
			        		title:'新增角色',
			        		closable:true,
			        		closeAction:'destroy',
			        		modal:true,
			        		width:500,
			        		height:530,
			        		resizable:false,
							border:false,
							layout:'fit',
							items:[addForm]
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
