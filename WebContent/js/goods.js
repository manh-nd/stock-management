$(document).ready(function() {
	
	// Sự kiện cho nút quay lại
	$("#backBtn").click(function(e) {
		window.history.back();
	});
	
	// Sự kiện khi rời khỏi mã hàng hóa
	$("#goodsCodeField").blur(function(e) {
		var goodsCode = $(this).val();
		var stockId = $("#stockId").val();
		
		// Tạo biến tồn kho
		var inventory = null;
		
		// Tạo biến hàng hóa
		var goods = null;
		
		// Kiểm tra mã hàng hóa này đã tồn tại trong kho này chưa
		$.get("/stock-management/goods/existsGoodsInStock?goodsCode=" + goodsCode + "&stockId=" + stockId, function(data) {
			
			// Gán giá trị cho biến tồn kho khi hàng hóa này tồn tại
			inventory = data.inventoryBean;
			if(inventory != null){
				// Tồn kho
				$("#inventoryId").val(inventory.id);
				$("#inventoryQuantity").val(inventory.quantity);
				
				// Gán giá trị cho biến hàng hóa
				goods = inventory.goods;
				
				setGoodsFormValue(goods);
				setReadOnlyGoodsField(false);
			}else{
				// Kiểm tra mã hàng hóa này đã tồn tại hay chưa
				$.get("/stock-management/goods/existsGoodsCode?goodsCode=" + goodsCode, function(data) {
					goods = data.goodsBean;		
					if(goods!=null){
						setGoodsFormValue(goods);
						setReadOnlyGoodsField(true);
					}else{
						// Khi goods không tồn tại, bỏ goodsId, gán mặc định active = true và hàng mới
						setReadOnlyGoodsField(false);
						$("#goodsId").val(null);
						$("input:radio[name='goodsBean.active']").val([true]);
						$("#goodsNewBrand").attr("checked", true);
					}
				});
				// Bỏ qua giá trị các trường của inventory
				$("#inventoryId").val(null);
				$("#inventoryQuantity").val(0);
			}
		});
	});
	
	function setGoodsFormValue(goods){
		$("#goodsId").val(goods.id);
		$("#categoryId").val(goods.category.id);
		$("#producerId").val(goods.producer.id);
		$("#supplierId").val(goods.supplier.id);
		$("#goodsName").val(goods.name);
		$("#goodsFeature").val(goods.feature);
		$("#goodsUnit").val(goods.unit);
		$("#goodsExpiration").val(goods.expiration);
		$("#goodsImportPrice").val(goods.importPrice);
		$("#goodsExportPrice").val(goods.exportPrice);
		$("#goodsLotNumber").val(goods.lotNumber);
		$("input:radio[name='goodsBean.active']").val([goods.active]);
		$("#goodsNewBrand").attr("checked", goods.newBrand);
		$("#goodsExpiration input[name='goodsBean.expiration']").val(goods.expiration);
		var expiration = new Date(goods.expiration);
		var day = expiration.getDate();
		var month = expiration.getMonth() + 1;
		var year = expiration.getFullYear();
		if(day<10){
			day = "0" + day;
		}
		if(month < 10){
			month = "0" + month;
		}
		$("#goodsExpiration input[name='dojo.goodsBean.expiration']").val(day + "/" + month + "/" + year);
		if(!goods.active){
			var result = confirm("Hàng hóa này đang ở trạng thái tạm dừng hoạt động, bạn có muốn kích hoạt lại nó không?");
			if(result){
				$("input:radio[name='goodsBean.active']").val([true]);
			}
		}
	}
	
	function setReadOnlyGoodsField(readonly){
		$("#categoryId").attr("readonly", readonly);
		$("#producerId").attr("readonly", readonly);
		$("#supplierId").attr("readonly", readonly);
		$("#goodsName").attr("readonly", readonly);
		$("#goodsFeature").attr("readonly", readonly);
		$("#goodsUnit").attr("readonly", readonly);
		$("#goodsExpiration").attr("readonly", readonly);
		$("#goodsImportPrice").attr("readonly", readonly);
		$("#goodsExportPrice").attr("readonly", readonly);
		$("#goodsLotNumber").attr("readonly", readonly);
		$("input:radio[name='goodsBean.active']").attr("readonly", readonly);
		$("#goodsNewBrand").attr("readonly", readonly);
		$("#goodsExpiration").attr("readonly", readonly);
		$("#goodsExpiration input[name='dojo.goodsBean.expiration']").attr("readonly", readonly);
		if(readonly){
			$("#goodsMessage").text("Hàng hóa này đã tồn tại ở một kho khác, " +
			"để đảm bảo tính toàn vẹn dữ liệu, các trường của hàng hóa sẽ bị vô hiệu hóa. Nếu bạn muốn sửa hàng hóa này, vui lòng chọn sửa thông tin hàng hóa!");
			
		}else{
			$("#goodsMessage").text(null);
		}
	}
	
});