/**
 * 菌物分类树的各种操作
 */

$(function(){
	$("#pspecimenAdd").click(function(){
		window.location.href = "../pcollect/new";
	});
	$("#pcollectCheck").click(function(){
		var selectNode = $('#pspecimen').datagrid('getSelected');
		if(selectNode == null){
			alertInfo('提示','请选择要查看的标本!','info');
		}else{
			var specimen_id = selectNode.specimen_id;
			window.location.href = "../pcollect/edit/"+specimen_id;
		}
	});
	
	$("#pstorageCheck").click(function(){
		var selectNode = $('#pspecimen').datagrid('getSelected');
		if(selectNode == null){
			alertInfo('提示','请选择要查看的标本!','info');
		}else{
			var specimen_id = selectNode.specimen_id;
			window.location.href = "../pstorage/edit/"+specimen_id;
		}
	});
	
	$("#pidentifyCheck").click(function(){
		var selectNode = $('#pspecimen').datagrid('getSelected');
		if(selectNode == null){
			alertInfo('提示','请选择要查看的标本!','info');
		}else{
			var specimen_id = selectNode.specimen_id;
			window.location.href = "../pidentify/edit/"+specimen_id;
		}
	});
	
	$("#pmediaCheck").click(function(){
		var selectNode = $('#pspecimen').datagrid('getSelected');
		if(selectNode == null){
			alertInfo('提示','请选择要查看的标本!','info');
		}else{
			var specimen_id = selectNode.specimen_id;
			window.location.href = "../pmedia/edit/"+specimen_id;
		}
	});
	$("#pspeciesDel").click(function(){
		var selectNode = $('#pspecies').datagrid('getSelected');
		if(selectNode == null){
			alertInfo('提示','请选择要删除的物种!','info');
		}else{
			$.messager.confirm('确认','删除会将该物种及物种下的标本删除，确认删除？',function(r){
				if(r){
					var species_id = selectNode.species_id;
					$.ajax({
						url:'../pspecies/'+species_id,
						type:'delete',
						dataType:'json',
						success:function(result){
							if(result.status){
								msg('删除成功',2000,result.obj,'fade');
								window.location.href = "../../pspecies/species";
							}else{
								alertInfo('错误',result.obj,'error');
							}
						}
					});
				}
			});
		}
	});
	
	$("#pspeciesMedia").click(function(){
		var selectNode = $('#pspecies').datagrid('getSelected');
		if(selectNode == null){
			alertInfo('提示','请选择要查看的物种!','info');
		}else{
			var species_id = selectNode.species_id;
			window.location.href = "../pspeciesMedia/medias/"+species_id;
		}
	});
});
