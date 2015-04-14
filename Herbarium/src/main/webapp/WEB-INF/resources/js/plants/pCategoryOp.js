/**
 * 菌物分类树的各种操作
 */

$(function(){
	$("#pcAdd").click(function(){
		var selectNode = $('#pcategory').datagrid('getSelected');
		if(selectNode == null){
			window.location.href = "../pcategory/new/0";
		}else{
			var class_id = selectNode.class_id;
			window.location.href = "../pcategory/new/"+class_id;
		}
	});
	$("#pcEdit").click(function(){
		var selectNode = $('#pcategory').datagrid('getSelected');
		if(selectNode == null){
			alertInfo('提示','请选择要修改的类别!','info');
		}else{
			var class_id = selectNode.class_id;
			window.location.href = "../pcategory/edit/"+class_id;
		}
	});
	
	$("#pcCheck").click(function(){
		var selectNode = $('#pcategory').datagrid('getSelected');
		if(selectNode == null){
			alertInfo('提示','请选择要查看的类别!','info');
		}else{
			var class_id = selectNode.class_id;
			$.ajax({
				url:"../pcategory/"+class_id,
				type:'get',
				dataType:'json',
				success:function(result){
					if(result.status){
						var obj = result.obj;
						$.ajax({
							url:"../pcategory/path/"+obj.class_path,
							type:'get',
							dataType:'json',
							success:function(result){
								$("#categoryArea").html('');
								if(result.status){
									$("#class_name").val(obj.class_name);
									$("#class_latin").val(obj.class_latin);
									$("#class_describe").val(obj.class_describe);
									for(var i=0;i<result.obj.length;i++){
										var input;
										if(i == 0)
											input = $('<input type="text" style="width:250px;" value="'+result.obj[i].class_name + '  ' +result.obj[i].class_latin +'"/>');
										else{
											var left = 105 + i*10;
											input = $('<input type="text" style="width:250px;margin-left:'+left+'px;" value="'+result.obj[i].class_name + '  ' +result.obj[i].class_latin +'"/>');
										}
											
										$("#categoryArea").append(input);
									}
									
									$('#plantsCategryInfo').modal('show');
								}else{
									
								}
							}
						});
					}else{
						alertInfo('错误',result.obj,'error');
					}
				}
			});
		}
	});
	
	$("#pcDel").click(function(){
		var selectNode = $('#pcategory').datagrid('getSelected');
		if(selectNode == null){
			alertInfo('提示','请选择要删除的类别!','info');
		}else{
			$.messager.confirm('确认','删除会将该类别及其子类别删除，确认删除？',function(r){
				if(r){
					var class_id = selectNode.class_id;
					$.ajax({
						url:'../pcategory/'+class_id,
						type:'delete',
						dataType:'json',
						success:function(result){
							if(result.status){
								window.location.href = "../pcategory/tree";
								msg('删除成功',2000,result.obj,'fade');
							}else{
								alertInfo('错误',result.obj,'error');
							}
						}
					});
				}
			});
		}
	});
});
