$(document).ready(function() {
	
	// Sự kiện cho nút quay lại
	$("#backBtn").click(function(e) {
		window.history.back();
	});
	
	// Sự kiện khi rời khỏi mã hàng hóa
	$("#stockCode").blur(function(e) {
		var stockCode = $(this).val();
		// Kiểm tra mã hàng hóa này đã tồn tại trong kho này chưa
		$.get("/stock-management/stock/existsStockCode?stockCode=" + stockCode , function(data) {
			stock = data.stockBean;
			if(stock == null){
				$("#stockId").val(null);
				$("#stockName").val(null);
				$("input:radio[name='stockBean.active']").val(true);
			}else{
				if(!stock.active){
					var result = confirm("Kho này đang ở trạng thái tạm dừng hoạt động, bạn có muốn kích hoạt lại nó không?");
					if(result){
						$("input:radio[name='stockBean.active']").val([true]);
					}
					$("#stockId").val(stock.id);
					$("#stockName").val(stock.name);
				}
				else{
					$("#stockId").val(stock.id);
					$("#stockName").val(stock.name);
					$("input:radio[name='stockBean.active']").val([true]);
				}
			}
				
		});
	});
});