$(document).ready(function() {
	
	// Sự kiện cho nút quay lại
	$("#backBtn").click(function(e) {
		window.history.back();
	});
	
	// Sự kiện khi rời khỏi mã hàng hóa
	$("#producerCode").blur(function(e) {
		var producerCode = $(this).val();
		// Kiểm tra mã hàng hóa này đã tồn tại trong kho này chưa
		$.get("/stock-management/producer/existsProducerCode?producerCode=" + producerCode , function(data) {
			producer = data.producerBean;
			if(producer == null){
				$("#producerId").val(null);
				$("#producerName").val(null);
				$("input:radio[name='producerBean.active']").val(true);
			}else{
				if(!producer.active){
					var result = confirm("Hàng hóa này đang ở trạng thái tạm dừng hoạt động, bạn có muốn kích hoạt lại nó không?");
					if(result){
						$("input:radio[name='producerBean.active']").val([true]);
					}
					$("#producerId").val(producer.id);
					$("#producerName").val(producer.name);
				}
				else{
					$("#producerId").val(producer.id);
					$("#producerName").val(producer.name);
					$("input:radio[name='producerBean.active']").val([true]);
				}
			}
				
		});
	});
	
	$(".delete").click(function(e) {
		var result = confirm("Bạn có muốn xóa không?");
		var producerId = $(this).attr("id");
		// Đồng ý xác nhận xóa
		if(result){
			var url = "/stock-management/producer/existsProducerId?producerId=" + producerId;
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