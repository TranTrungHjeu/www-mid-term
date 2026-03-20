<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Chi tiết căn hộ</title>
</head>
<body>
<h2>Chi tiết căn hộ</h2>

<p><strong>Mã căn hộ:</strong> ${canHo.maCanHo}</p>
<p><strong>Tên căn hộ:</strong> ${canHo.tenCanHo}</p>
<p><strong>Giá thuê:</strong> ${canHo.giaThue}</p>
<p><strong>Diện tích:</strong> ${canHo.dienTich}</p>
<p><strong>Hình ảnh:</strong> ${canHo.hinhAnh}</p>
<p><strong>Tòa nhà:</strong> ${canHo.toaNha.tenToa}</p>
<p><strong>Địa chỉ:</strong> ${canHo.toaNha.viTri}</p>
<p><strong>Chủ tòa:</strong> ${canHo.toaNha.chuToa}</p>

<a href="canho">Quay lại</a>
</body>
</html>