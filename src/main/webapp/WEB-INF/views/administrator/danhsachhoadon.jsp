<!-- sử dụng tiếng việt -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- import JSTL -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Admin SkyTour</title>
    <jsp:include page="/WEB-INF/views/common/variables.jsp"></jsp:include>
    <jsp:include page="/WEB-INF/views/administrator/layout/css.jsp"></jsp:include>
    <link rel="shortcut icon" href="${base}/img/images/iconLogoOffStardom.png"/>
  </head>
  <body>
    <div class="container-scroller">
      <jsp:include page="/WEB-INF/views/administrator/layout/header.jsp"></jsp:include>
      
      <div class="container-fluid page-body-wrapper">
      <!-- partial:../../partials/_sidebar.html -->
      <jsp:include page="/WEB-INF/views/administrator/layout/sidebar.jsp"></jsp:include>
       <!-- partial -->
      <div class="main-panel">
        <div class="content-wrapper">
          <div class="page-header">
            <h3 class="page-title"> Danh sách hóa đơn SkyTour </h3>
            <nav aria-label="breadcrumb">
              <ol class="breadcrumb">
                <!-- <li class="breadcrumb-item"><a href="./ThemSanPham.html" class="btn btn-behance">Thêm Tour</a></li> -->
              </ol>
            </nav>
          </div>
          <div class="row">
            <div class="col-12 grid-margin stretch-card">
                <div class="card">
                    <div class="card-body" style="overflow: auto;">
                        <table class="table table-hover">
                          <thead>
                            <tr>
                              <th>Mã Hóa Đơn</th>
                              <th>Mã Tour</th>
                              <th>Mã Khách Hàng</th>
                              <th>Tên Khách Hàng</th>
                              <th>SĐT Khách Hàng</th>
                              <th>Email Khách Hàng</th>
                              <th>Ghi Chú</th>
                              <th>Người Lớn</th>
                              <th>Trẻ Em</th>
                              <th>Trẻ Nhỏ</th>
                              <th>Trẻ Sơ Sinh</th>
                              <th>Tổng tiền</th>
                            </tr>
                          </thead>
                          <tbody>
                            <tr>
                              <td>HD01</td>
                              <td>MT01</td>
                              <td>1</td>
                              <td>Nguyễn Quang Anh</td>
                              <td>0323238832</td>
                              <td>hquanganh123@gmail.com</td>
                              <td><p>khôngzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz</p></td>
                              <td>3</td>
                              <td>3</td>
                              <td>3</td>
                              <td>3</td>
                              <td>4000000</td>
                            </tr>
                          </tbody>
                        </table>
                    </div>
                </div>
            </div>
          </div>
        </div>
        <!-- content-wrapper ends -->
        <!-- partial:../../partials/_footer.html -->
          <jsp:include page="/WEB-INF/views/administrator/layout/footer.jsp"></jsp:include>
        <!-- partial -->
      </div>
      <!-- main-panel ends -->
      </div>
      <!-- page-body-wrapper ends -->
    </div>
    <!-- container-scroller -->
    <jsp:include page="/WEB-INF/views/administrator/layout/js.jsp"></jsp:include>
  </body>
  <!-- background: linear-gradient(to right, #84d9d2, #07cdae); xanh lá nhạt-->
  <!-- background: linear-gradient(to right, #ffbf96, #fe7096); đỏ hồng-->
  <!-- background: linear-gradient(to right, #f6e384, #ffd500); vàng-->
  <!--  background: linear-gradient(to right, #90caf9, #047edf 99%); xanh dương-->
  <!-- background: linear-gradient(to right, #da8cff, #9a55ff); tím -->
  <!-- background: linear-gradient(to right, #e7ebf0, #868e96); xám -->
  <!-- background: linear-gradient(89deg, #5e7188, #3e4b5b);  dark -->
  <!-- background: linear-gradient(to bottom, #f4f4f4, #e4e4e9); trắng -->
</html>