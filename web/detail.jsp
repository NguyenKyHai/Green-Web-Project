<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>  
<!DOCTYPE html>
<html>
    <link rel="stylesheet" href="templates2/detail.css">
    <%@include file="common/head.jsp" %>

    <body>
        <fmt:setLocale value="vi-VN"/>
        <!--begin of menu-->
        <%@include file="common/header.jsp" %>

        <section class="hero">
            <div class="container2">
                <div class="card">
                    <div class="container-fliud">
                        <div class="wrapper row">
                            <div class="preview col-md-6">
                                <div class="preview-pic tab-content">
                                    <div class="tab-pane active" id="pic-1"><img
                                            src="images/${detail.image}"
                                            alt="">
                                    </div>
                                </div>

                            </div>
                            <div class="details col-md-6">
                                <h3 class="product-title">${detail.name}</h3>
                                <h5>Danh mục: ${detail.categoryid.name}</h5>
                                <div class="rating">
                                    <h4 class="price"><fmt:formatNumber value="${detail.price}" type="currency"/></h4>
                                    <h5>Tình trạng: <span>Còn hàng</span></h5>
                                    <form action="addcart" method="get">
                                        <lable class="quantity">Số lượng: </lable>
                                        <input class=""quantity name="id" value="${detail.productid}" type="hidden">
                                        <input class="quantity" name="quantity" type="number" value="1" min="1" max="10">
                                        <p><i class="fas fa-truck"></i>Vận chuyển: Miễn phí trên toàn quốc </p>
                                        <div class="action"> 
                                            <button class="add-to-cart" type="submit">MUA NGAY
                                            </button>
                                            </a>
                                    </form>
                                    <a href="./">
                                        <button class="add-to-cart" type="button">TRỞ VỀ
                                        </button>
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Hero Section End -->

    <script src="templates/owl.carousel.min.js"></script>
    <script src="templates/jquery.slicknav.js"></script>
    <script src="templates/main.js"></script>
    <script src="templates/jquery-ui.min.js"></script>
    <script src="templates/mixitup.min.js"></script>
    <script src="templates/jquery.nice-select.min.js"></script>
    <script src="templates/bootstrap.min.js"></script>

</body>
<%@include file="common/footer.jsp" %>
</html>
