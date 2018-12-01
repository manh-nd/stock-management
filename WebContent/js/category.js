$(document).ready(function() {
	
	// Sự kiện cho nút quay lại
	$("#backBtn").click(function(e) {
		window.history.back();
	});
	
	// Sự kiện khi rời khỏi mã hàng hóa
	$("#categoryCode").blur(function(e) {
		var categoryCode = $(this).val();
		// Kiểm tra mã hàng hóa này đã tồn tại trong kho này chưa
		$.get("/stock-management/category/existsCategoryCode?categoryCode=" + categoryCode , function(data) {
			category = data.categoryBean;
			if(category == null){
				$("#categoryId").val(null);
				$("#categoryName").val(null);
				$("input:radio[name='categoryBean.active']").val(true);
			}else{
				if(!category.active){
					var result = confirm("Hàng hóa này đang ở trạng thái tạm dừng hoạt động, bạn có muốn kích hoạt lại nó không?");
					if(result){
						$("input:radio[name='categoryBean.active']").val([true]);
					}
					$("#categoryId").val(category.id);
					$("#categoryName").val(category.name);
				}
				else{
					$("#categoryId").val(category.id);
					$("#categoryName").val(category.name);
					$("input:radio[name='categoryBean.active']").val([true]);
				}
			}
				
		});
	});
	
	$(".delete").click(function(e) {
		var result = confirm("Bạn có muốn xóa không?");
		var categoryId = $(this).attr("id");
		// Đồng ý xác nhận xóa
		if(result){
			var url = "/stock-management/category/existsCategoryId?categoryId=" + categoryId;
			$.get(url, function(data) {
				var existsGoods = data.existsGoods;
				// Đang tồn tại dữ liệu trong bảng goods
				if(existsGoods){
					var cc = confirm("Nhà sản xuất này đang có hàng hóa. Bạn vẫn muốn xóa chứ?");
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