$(document).ready(function() {
	
	// Sự kiện cho nút quay lại
	$("#backBtn").click(function(e) {
		window.history.back();
	});
	
	// Sự kiện khi rời khỏi mã hàng hóa
	$("#supplierCode").blur(function(e) {
		var supplierCode = $(this).val();
		// Kiểm tra mã hàng hóa này đã tồn tại trong kho này chưa
		$.get("/stock-management/supplier/existsSupplierCode?supplierCode=" + supplierCode , function(data) {
			supplier = data.supplierBean;
			if(supplier == null){
				$("#supplierId").val(null);
				$("#supplierName").val(null);
				$("input:radio[name='supplierBean.active']").val(true);
			}else{
				if(!supplier.active){
					var result = confirm("Hàng hóa này đang ở trạng thái tạm dừng hoạt động, bạn có muốn kích hoạt lại nó không?");
					if(result){
						$("input:radio[name='supplierBean.active']").val([true]);
					}
					$("#supplierId").val(supplier.id);
					$("#supplierName").val(supplier.name);
				}
				else{
					$("#supplierId").val(supplier.id);
					$("#supplierName").val(supplier.name);
					$("input:radio[name='supplierBean.active']").val([true]);
				}
			}
				
		});
	});
	
	$(".delete").click(function(e) {
		var result = confirm("Bạn có muốn xóa không?");
		var supplierId = $(this).attr("id");
		// Đồng ý xác nhận xóa
		if(result){
			var url = "/stock-management/supplier/existsSupplierId?supplierId=" + supplierId;
			$.get(url, function(data) {
				var existsGoods = data.existsGoods;
				// Đang tồn tại dữ liệu trong bảng goods
				if(existsGoods){
					var cc = confirm("Nhà cung cấp này đang có hàng hóa. Bạn vẫn muốn xóa chứ?");
					if(cc){
						return true;
					}
				}else{ // Không tồn tại, xóa
					return true;
				}
			});
		}else{
			return false;
		}
	});
});