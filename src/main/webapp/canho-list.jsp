<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Danh sách căn hộ</title>
  <style>
    table { border-collapse: collapse; width: 100%; }
    th, td { border: 1px solid #333; padding: 8px; }
    form { margin: 10px 0; }
  </style>
</head>
<body>
<h2>Danh sách căn hộ</h2>

<form action="canho" method="get">
  <input type="hidden" name="action" value="search"/>
  <input type="text" name="keyword" placeholder="Nhập tên căn hộ" value="${keyword}"/>
  <button type="submit">Tìm kiếm</button>
</form>

<form action="canho" method="get">
  <input type="hidden" name="action" value="byToanha"/>
  <select name="maToa">
    <option value="">-- Chọn tòa nhà --</option>
    <c:forEach var="t" items="${dsToaNha}">
      <option value="${t.maToa}">
          ${t.tenToa}
      </option>
    </c:forEach>
  </select>
  <button type="submit">Lọc</button>
</form>

<a href="canho">Xem tất cả</a>

<table>
  <tr>
    <th>Mã căn hộ</th>
    <th>Tên căn hộ</th>
    <th>Giá thuê</th>
    <th>Diện tích</th>
    <th>Hình ảnh</th>
    <th>Tòa nhà</th>
    <th>Chức năng</th>
  </tr>
  <c:forEach var="c" items="${dsCanHo}">
    <tr>
      <td>${c.maCanHo}</td>
      <td>${c.tenCanHo}</td>
      <td>${c.giaThue}</td>
      <td>${c.dienTich}</td>
      <td>${c.hinhAnh}</td>
      <td>${c.toaNha.tenToa}</td>
      <td>
        <a href="canho?action=detail&id=${c.maCanHo}">Chi tiết</a> |
        <a href="canho?action=edit&id=${c.maCanHo}">Sửa</a>
      </td>
    </tr>
  </c:forEach>
</table>
</body>
</html>