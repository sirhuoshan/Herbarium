/**
 * 增加标本
 */
Ext.define('Herbarium.bacterium.bacteriumAdd',{
	extend:'Ext.tab.Panel',
	bodyPadding: 5,
    border:false,
    initComponent: function() {
    	var me = this;
    	
    	var bacteriumCollect = Ext.create('Herbarium.bacterium.bacteriumCollect');
    	Ext.apply(me,{
    	    defaults: {                  
    	        margin : '20 0 5 5',
		        labelAlign : 'right',
		        width:300
    	    },
    	    items: [bacteriumCollect]
    	});
    	me.callParent(arguments);
    }
});

Ext.define('Herbarium.bacterium.bacteriumCollect',{
	extend:'Ext.form.Panel',
	title: '采集信息',
});
