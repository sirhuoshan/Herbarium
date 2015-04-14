/**
 * 增加物种
 */
Ext.define('Herbarium.bacterium.bacteriumSpeAdd',{
	extend:'Ext.tab.Panel',
	bodyPadding: 5,
    border:false,
    initComponent: function() {
    	var me = this;
    	
    	var bacteriumSpeInfo = Ext.create('Herbarium.bacterium.bacteriumSpeInfo');
    	var bacteriumSpeMedia = Ext.create('Herbarium.bacterium.bacteriumSpeMedia');
    	Ext.apply(me,{
    	    defaults: {                  
		        labelAlign : 'right'
    	    },
    	    items: [bacteriumSpeInfo,bacteriumSpeMedia]
    	});
    	me.callParent(arguments);
    }
});

Ext.define('Herbarium.bacterium.bacteriumSpeInfo',{
	extend:'Ext.form.Panel',
	layout:'column',
	title: '物种信息',
	bodyPadding: 5,
	items:[{
		labelAlign: 'right', 
        fieldLabel: 'First Name',
        xtype: 'textfield',
        name: 'first',
        width:200,
        allowBlank: false
    },{
		labelAlign: 'right', 
        fieldLabel: 'Last Name',
        xtype: 'textfield',
        name: 'last',
        width:200,
        allowBlank: false
    }]
});

Ext.define('Herbarium.bacterium.bacteriumSpeMedia',{
	extend:'Ext.form.Panel',
	title: '物种多媒体信息',
});