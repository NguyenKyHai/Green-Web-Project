<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>  
<!DOCTYPE html>
<html>
    <%@include file="common/head.jsp" %>
    <body>
        <fmt:setLocale value="vi-VN"/>
        <!--begin of menu-->
        <%@include file="common/header.jsp" %>

        <section class="hero">
            <div class="container">
                <div class="row">
                    <div class="col-lg-3">
                        <div class="hero__categories">
                            <div class="hero__categories__all">
                                <i class="fa fa-bars"></i>
                                <span>Danh mục</span>
                            </div>
                            <ul >
                                <c:forEach items="${listC}" var="c"> 
                                    <li class="${tag==c.categoryid ?"active bg-light":""}">
                                        <a href="category-detail?categoryid=${c.categoryid}">${c.name}</a>
                                    </li>
                                </c:forEach>
                            </ul>
                        </div>
                    </div>
                    <div class="col-lg-9">
                        <div class="hero__search">
                            <div class="hero__search__form">
                                <form action="search">
                                    <input name="search" type="text" placeholder="Nhập tên sản phẩm..." value="${txtsearch}" />
                                    <button type="submit" class="site-btn">TÌM</button>
                                </form>
                            </div>
                            <div class="hero__search__phone">
                                <div class="hero__search__phone__icon">
                                    <i class="fa fa-phone"></i>
                                </div>
                                <div class="hero__search__phone__text">
                                    <h5>0396 427 446</h5>
                                    <span>Phục vụ 24/7</span>
                                </div>
                            </div>
                        </div>
                        <div class="hero__item set-bg" data-setbg="images/banner.jpg">
                            <div class="hero__text">
                                <span>THỰC PHẨM SẠCH</span>
                                <h2>Rau củ <br />100% tươi sạch</h2>
                                <p>Miễn phí vận chuyển toàn quốc</p>
                                <a href="#buyProduct" class="primary-btn" style="color: #fff;">MUA NGAY</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- Hero Section End -->

        <!-- Categories Section Begin -->
        <section class="categories">
            <div class="container">
                <div class="row">
                    <div class="categories__slider owl-carousel">
                        <c:forEach items="${list}" var="p">
                            <div class="col-lg-3">
                                <div
                                    class="categories__item set-bg"
                                    data-setbg="images/${p.image}"
                                    >
                                    
                                </div>
                                <h5 class="slide-title"><a href="addcart?id=${p.productid}">${p.name}</a></h5>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </section>
        <!-- Categories Section End -->

        <!-- Featured Section Begin -->
        <section class="featured spad" id="buyProduct">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="section-title">
                            <h2>Sản phẩm nổi bật</h2>
                        </div>
                        <div class="featured__controls">
                            <ul>
                                <li class="breadcrumb-item" ><a href="./" class="featured-product">Nổi bật</li>
                                    <c:forEach items="${listC}" var="c"> 
                                    <li class="breadcrumb-item"><a href="category-detail?categoryid=${c.categoryid}" class="featured-product">${c.name}</a></li>
                                    </c:forEach>
                            </ul>
                        </div>
                    </div>
                </div>
                <div class="row featured__filter">
                    <c:forEach items="${listP}" var="p">
                        <div class="col-lg-3 col-md-4 col-sm-6 mix oranges fresh-meat">
                            <div class="featured__item">
                                <div
                                    class="featured__item__pic set-bg"
                                    data-setbg="images/${p.image}"
                                    >
                                    <ul class="featured__item__pic__hover">
                                        <li>
                                            <a href="detail?productid=${p.productid}"><i class="fa fa-info-circle"></i></a>
                                        </li>
                                        <li>
                                            <a href="addcart?id=${p.productid}"><i class="fa fa-shopping-cart"></i></a>
                                        </li>
                                    </ul>
                                </div>
                                <div class="featured__item__text">
                                    <h6><a href="addcart?id=${p.productid}">${p.name}</a></h6>
                                    <h5><fmt:formatNumber value="${p.price}" type="currency"/></h5>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </section>
        <!-- Latest Product Section End -->
        <div class="d-flex justify-content-center">
            <c:forEach begin="1" end="${endpage}" var="o">
                <a href="home?index=${o}" class="pl-3 pr-3 font-weight-bold btn btn-light" style="text-align:center;">${o}</a>
            </c:forEach>
        </div>

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
