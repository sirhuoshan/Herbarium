/**
 * 菌物分类树的各种操作
 */

$(function(){
	$("#pspeciesAdd").click(function(){
		window.location.href = "../pspecies/new";
	});
	$("#pspeciesEdit").click(function(){
		var selectNode = $('#pspecies').datagrid('getSelected');
		if(selectNode == null){
			alertInfo('提示','请选择要修改的物种!','info');
		}else{
			var species_id = selectNode.species_id;
			window.location.href = "../pspecies/edit/"+species_id;
		}
	});
	
	$("#pspeciesCheck").click(function(){
		var selectNode = $('#pspecies').datagrid('getSelected');
		if(selectNode == null){
			alertInfo('提示','请选择要查看的物种!','info');
		}else{
			var species_id = selectNode.species_id;
			$.ajax({
				url:"../pspecies/"+species_id,
				type:'get',
				dataType:'json',
				success:function(result){
					if(result.status){
						var obj = result.obj;
						$("#latin_name").val(obj.latin_name);
						$("#chinese_name").val(obj.chinese_name);
						$("#family").val(obj.family);
						$("#genusval").val(obj.genus_val);
						$("#other_name").val(obj.other_name);
						$("#fruit_period").val(obj.fruit_period);
						$("#growth").text(obj.growth);
						$("#use").text(obj.use);
						$("#character").text(obj.character);
						$("#location").text(obj.location);
						$("#protect_id").val(obj.protect_id);
						$("#iucn_id").val(obj.iucn_id);
						$("#cites_id").val(obj.cites_id);
						$("#redbook_id").val(obj.redbook_id);
						$('#pspeciesShow').modal('show');
					}else{
						alertInfo('错误',result.obj,'error');
					}
				}
			});
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
