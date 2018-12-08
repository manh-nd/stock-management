<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<s:url action="" namespace="/" var="homePageURL" />
<s:url action="list" namespace="/stock" var="stockListURL" />
<s:url action="list" namespace="/supplier" var="supplierListURL" />
<s:url action="list" namespace="/producer" var="producerListURL" />
<s:url action="list" namespace="/goods" var="goodsListURL" />
<s:url action="list" namespace="/category" var="categoryListURL" />
<s:url action="list" namespace="/account" var="accountListURL" />


<s:url action="category-report" namespace="/report"
	var="categoryReportURL" />
<s:url action="supplier-report" namespace="/report"
	var="supplierReportURL" />
<s:url action="expiration-goods-report" namespace="/report"
	var="expirationGoodsReportURL" />

<s:url action="logout" namespace="/account" var="logoutURL" />
<s:url action="change-password" namespace="/account"
	var="changePasswordURL" />

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
	<s:a cssClass="navbar-brand" href="%{homePageURL}">QUẢN LÝ KHO HÀNG</s:a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarSupportedContent"
		aria-controls="navbarSupportedContent" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item">
				<s:a href="%{homePageURL}" cssClass="nav-link">Trang chủ</s:a>
			</li>
			<li class="nav-item">
				<s:a cssClass="nav-link" href="%{goodsListURL}">Hàng hóa</s:a>
			</li>
			<li class="nav-item dropdown">
				<a class="nav-link dropdown-toggle" href="#"
					id="navbarDropdownMenuLink" role="button" data-toggle="dropdown"
					aria-haspopup="true" aria-expanded="false"> Danh mục tham chiếu
				</a>
				<div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
					<s:a cssClass="dropdown-item" href="%{stockListURL}"> Kho hàng </s:a>
					<s:a cssClass="dropdown-item" href="%{categoryListURL}"> Phân loại </s:a>
					<s:a cssClass="dropdown-item" href="%{producerListURL}"> Hãng sản xuất </s:a>
					<s:a cssClass="dropdown-item" href="%{supplierListURL}"> Nhà cung cấp </s:a>
				</div>
			</li>
			<li class="nav-item dropdown">
				<a class="nav-link dropdown-toggle" href="#"
					id="navbarDropdownMenuLink" role="button" data-toggle="dropdown"
					aria-haspopup="true" aria-expanded="false"> Báo cáo </a>
				<div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
					<s:a cssClass="dropdown-item" href="%{categoryReportURL}"> Chủng loại </s:a>
					<s:a cssClass="dropdown-item" href="%{supplierReportURL}"> Nhà cung cấp </s:a>
					<s:a cssClass="dropdown-item" href="%{expirationGoodsReportURL}"> Hàng sắp hết hạn </s:a>
				</div>
			</li>
			<li class="nav-item">
				<s:a href="%{accountListURL}" cssClass="nav-link">Tài Khoản</s:a>
			</li>

			<s:if test="%{#session.user != null}">
				<div class="dropdown dropdown-menu-right" style="position: relative; left: 0">
					<button class="btn btn-secondary dropdown-toggle" type="button"
						id="dropdownMenuButton" data-toggle="dropdown"
						aria-haspopup="true" aria-expanded="false">
						<font color="blue">Xin Chào:</font>
						<font color="red">
							<s:property value="#session.user.fullname" />
						</font>
					</button>
					<div class="dropdown-menu dropdown-menu-right" aria-labelledby="dropdownMenuButton">
						<s:a cssClass="dropdown-item disabled"> Vai trò:  <s:property
								value="#session.user.role" />
						</s:a>
						<s:a cssClass="dropdown-item" href="%{changePasswordURL}">Đổi mật khẩu</s:a>
						<s:a cssClass="dropdown-item" href="%{logoutURL}"> Đăng xuất </s:a>
					</div>
				</div>
			</s:if>
		</ul>
	</div>
</nav>