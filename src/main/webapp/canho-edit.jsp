<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Cập nhật căn hộ</title>
</head>
<body>
<h2>Cập nhật căn hộ</h2>

<form action="canho" method="post">
  <input type="hidden" name="action" value="update"/>

  <p>
    Mã căn hộ:
    <input type="text" name="maCanHo" value="${canHo.maCanHo}" readonly/>
  </p>

  <p>
    Tên căn hộ:
    <input type="text" name="tenCanHo" value="${canHo.tenCanHo}" required/>
  </p>

  <p>
    Giá thuê:
    <input type="number" step="0.01" name="giaThue" value="${canHo.giaThue}" required/>
  </p>

  <p>
    Diện tích:
    <input type="number" step="0.1" name="dienTich" value="${canHo.dienTich}" required/>
  </p>

  <p>
    Hình ảnh:
    <input type="text" name="hinhAnh" value="${canHo.hinhAnh}" required/>
  </p>

  <p>
    Tòa nhà:
    <select name="maToa">
      <c:forEach var="t" items="${dsToaNha}">
        <option value="${t.maToa}" ${canHo.toaNha.maToa == t.maToa ? 'selected' : ''}>
            ${t.tenToa}
        </option>
      </c:forEach>
    </select>
  </p>

  <button type="submit">Lưu</button>
</form>

<a href="canho">Quay lại</a>
</body>
</html>