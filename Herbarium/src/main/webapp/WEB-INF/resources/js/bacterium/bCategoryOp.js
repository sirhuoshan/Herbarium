/**
 * 菌物分类树的各种操作
 */

$(function(){
	$("#bcAdd").click(function(){
		var selectNode = $('#bcategory').datagrid('getSelected');
		if(selectNode == null){
			window.location.href = "../bcategory/new/0";
		}else{
			var class_id = selectNode.class_id;
			window.location.href = "../bcategory/new/"+class_id;
		}
	});
	$("#bcEdit").click(function(){
		var selectNode = $('#bcategory').datagrid('getSelected');
		if(selectNode == null){
			alertInfo('提示','请选择要修改的类别!','info');
		}else{
			var class_id = selectNode.class_id;
			window.location.href = "../bcategory/edit/"+class_id;
		}
	});
	
	$("#bcCheck").click(function(){
		var selectNode = $('#bcategory').datagrid('getSelected');
		if(selectNode == null){
			alertInfo('提示','请选择要查看的类别!','info');
		}else{
			var class_id = selectNode.class_id;
			$.ajax({
				url:"../bcategory/"+class_id,
				type:'get',
				dataType:'json',
				success:function(result){
					if(result.status){
						var obj = result.obj;
						$.ajax({
							url:"../bcategory/path/"+obj.class_path,
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
									
									$('#bacteriumCategryInfo').modal('show');
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
	
	$("#bcDel").click(function(){
		var selectNode = $('#bcategory').datagrid('getSelected');
		if(selectNode == null){
			alertInfo('提示','请选择要删除的类别!','info');
		}else{
			$.messager.confirm('确认','删除会将该类别及其子类别删除，确认删除？',function(r){
				if(r){
					var class_id = selectNode.class_id;
					$.ajax({
						url:'../bcategory/'+class_id,
						type:'delete',
						dataType:'json',
						success:function(result){
							if(result.status){
								window.location.href = "../bcategory/tree";
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
