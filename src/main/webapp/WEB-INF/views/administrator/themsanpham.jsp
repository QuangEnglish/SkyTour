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
        <div class="content-wrapper content-wrapper__product">
          <div class="content-wrapper__product__body">
            <div class="product__body__nav">
              <a href="../../index.html">Trang chủ</a>
              <span><i class="mdi mdi-chevron-right"></i></span>
              <a href="../../pages/ui-features/SanPham.html">Danh sách tour</a>
              <span><i class="mdi mdi-chevron-right"></i></span>
              <a href="../../pages/ui-features/ThemSanPham.html">Thêm</a>

            </div>
            <div class="product__body__title">
              <p>Thông Tin Tour</p>
            </div>
            <div class="product__body__table">
              <form action="" method="post">
                <table class="tableAdd table table-borderless">
                  <tr>
                    <td>Avatar: </td>
                    <td style="height: 200px;"><img src="../../assets/images/logo-off.jpg" alt=""
                        style="width: 70px; height: 70px; "><br><input type='file' name='productAvatar' id="productAvatar"
                        style="margin-top: 40px; height: 56px;"><br></td>
                  </tr>
                  <tr>
                  <tr>
                    <td>Hình ảnh: </td>
                    <td style="height: 200px;"><img src="../../assets/images/logo-off.jpg" alt=""
                        style="width: 70px; height: 70px; "><br>
                      <input type="file" id="productPictures" name="productPictures" multiple="multiple"
                        style="margin-top: 40px; height: 56px;"><br>
                    </td>
                  </tr>
                  <tr>
                    <td>Danh Mục:</td>
                    <td><input type="text" name="categoryId" id="categoryId"></td>
                  <tr>
                    <td>Mã tour:</td>
                    <td><input type="text" name="code" id="code"></td>
                  </tr>
                  <tr>
                    <td>Tên tour:</td>
                    <td><input type="text" name="name" id="name"></td>
                  </tr>
                  <tr>
                    <td>Tên tour chi tiết:</td>
                    <td><input type="text" name="nameDetail" id="nameDetail"></td>
                  </tr>
                  <tr>
                    <td>Thời gian:</td>
                    <td><input type="text" name="time" id="time" placeholder="(3 ngày 2 đêm, 5 ngày 4 đêm, ...)"></td>
                  </tr>
                  <tr>
                    <td>Thời gian khởi hành:</td>
                    <td><select name="timeStart" id="timeStart">
                        <option value="2">Thứ hai</option>
                        <option value="3">Thứ ba</option>
                        <option value="4">Thứ tư</option>
                        <option value="5">Thứ năm</option>
                        <option value="6">Thứ sáu</option>
                        <option value="7">Thứ bảy</option>
                        <option value="8">Chủ Nhật</option>
                        <option value="9">Mọi ngày</option>
                      </select></td>
                  </tr>
                  <tr>
                    <td>Phương tiện:</td>
                    <td><select name="vehicle" id="vehicle">
                        <option value="1">Ô tô con</option>
                        <option value="2">Ô tô điện</option>
                        <option value="3">Xe khách</option>
                        <option value="4">Xe bus</option>
                        <option value="5">Xe máy</option>
                        <option value="6">Máy bay</option>
                        <option value="7">Du thuyền</option>
                        <option value="8">Thứ bảy</option>
                      </select></td>
                  </tr>
                  <tr>
                    <td>Địa điểm khởi hành:</td>
                    <td><input type="text" name="addressStart" id="addressStart"></td>
                  </tr>
                  <tr>
                    <td>Giá:</td>
                    <td><input type="text" name="price" id="price"></td>
                  </tr>
                  <tr>
                    <td>Giá khuyến mãi:</td>
                    <td><input type="text" name="priceSale" id="priceSale"></td>
                  </tr>
                  <tr>
                    <td>Đánh giá:</td>
                    <td><input type="text" name="assess" id="assess" disabled></td>
                  </tr>
                  <tr>
                    <td>Điểm nhấn tour:</td>
                    <td><textarea name="highlightTour" id="highlightTour" cols="100" rows="2"></textarea></td>
                  </tr>
                  <tr>
                    <td>Lịch trình tour:</td>
                    <td><a href="ThemLichTrinhTour.html" class="btn btn-behance">Thêm lịch trình tour</a></td>
                  </tr>
                  <tr>
                    <td>Dịch vụ tour:</td>
                    <td><textarea name="serviceTour" id="serviceTour" cols="100" rows="2"></textarea>
                    </td>
                  </tr>
                  <tr>
                    <td>Tác vụ:</td>
                    <td>
                      <input type="checkbox" name="isHot" id="isHot" style="height: 20px; width: 20px; margin: 0px 10px;">
                      <label for="isHot"> Nổi bật</label><br>
                    </td>
                  </tr>
                  <tr>
                    <td></td>
                    <td> <input type="checkbox" name="isSale" id="isSale"
                        style="height: 20px; width: 20px; margin: 0px 10px;">
                      <label for="isSale">Giảm giá</label><br>
                    </td>
                  </tr>
                  <tr>
                    <td></td>
                    <td><button type="submit" class="btn btn-behance" style="margin-top: 0px;">Thêm</button>
                      <a href="../../pages/ui-features/SanPham.html" style="text-decoration: none; color: black;"
                        class="btn btn-danger">Thoát</a>
                    </td>
                  </tr>
                </table>
              </form>
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