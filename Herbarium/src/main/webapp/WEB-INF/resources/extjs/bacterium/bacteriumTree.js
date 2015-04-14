/**
 * 
 */
var treeStore = Ext.create('Ext.data.TreeStore', {
		root: {
			expanded: true,
			children: [
				{ text: "detention", leaf: true },
				{ text: "homework", expanded: true, children: [
					{ text: "book report",expanded: true, children: [{text: "testdsadsadadsadasdsadasdasdasdasdsadsadsadsadasda", leaf: true}]
					},
					{ text: "algebra", leaf: true}
				] }
			]
		}
	});

Ext.define("Herbarium.bacterium.bacteriumTree", {
	extend : "Ext.panel.Panel",
	header : false,
	layout: 'border',
	autoScroll : true,
	xtype : 'bacteriumTree',
	tbar : [{
	    		xtype : 'textfield',
	    		id : 'categoryName',
	    		width : '80%',
	    		emptyText : '输入查询条件'
	    	}, '-', {
	    		xtype : 'button',
	    		text : '查询',
	    		handler: function(){}
	    	}, '-' ],
	initComponent : function() {
		var me = this;
		var treeBar = Ext.create('Ext.toolbar.Toolbar', {
			id: 'treeBar',
			border : false,
			items : [ 
			{
				xtype : 'button',
				text : '展开',
				handler : function(){}
			}, '-', {
				xtype : 'button',
				text : '收起',
				handler :  function(){}
			}]
		});
		
		var specimenTreePanel = Ext.create('Ext.tree.Panel', {
			id: 'specimenTreePanel',
			store : treeStore,
			autoScroll : true,
			region: 'center',
			rootVisible : false,
			border : false,
			useArrows : true,
			tbar : [ treeBar ]
		});
		
		me.items = [ specimenTreePanel ];
		me.superclass.initComponent.call(me); // 调用父类的构造函数
	},
	getDataFn:null,
	show : function(getDataFn) {
		alert("run");
		this.getDataFn = getDataFn;
		this.superclass.show.call(this);
	}
});


