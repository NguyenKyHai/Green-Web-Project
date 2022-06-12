<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>  
<header class="header">
    <div class="header__top">
        <div class="container">
            <div class="row">
                <div class="col-lg-6 col-md-6">
                    <div class="header__top__left">
                        <ul>
                            <li>
                                <i class="fa fa-envelope"></i>greenmarket827@gmail.com
                            </li>
                            <li>Số 01 Võ Văn Ngân</li>
                        </ul>
                    </div>
                </div>
                <div class="col-lg-6 col-md-6">
                    <div class="header__top__right">
                        <div class="header__top__right__social">
                            <a href="https://www.facebook.com/"><i class="fa fa-facebook"></i></a>
                            <a href="https://www.twitter.com/"><i class="fa fa-twitter"></i></a>
                            <a href="https://www.linkedin.com/"><i class="fa fa-linkedin"></i></a>
                            <a href="https://www.pinterest.com/"><i class="fa fa-pinterest-p"></i></a>
                        </div>
                        <div class="header__top__right__auth">
                            <c:if test="${sessionScope.usersession==null}">
                                <a href="login"><i class="fa fa-user"></i> Đăng nhập</a>
                            </c:if>
                            <c:if test="${sessionScope.usersession!=null}">                              
                                <ul id="menu">                                   
                                    <li>                                    
                                        <a class="info-user"><i class="fa fa-user"></i>${sessionScope.usersession.username}
                                            <span class="arrow arrow-down"></span>
                                        </a>
                                        <ul class="dropdown_menu">
                                            <c:if test="${sessionScope.usersession.role==1}">      
                                                <li><a href="management">Đến trang quản lý</a></li>
                                                </c:if>
                                            <li><a href="change-password">Đổi mật khẩu</a></li>
                                            <li><a href="logout">Đăng xuất<i class="fas fa-sign-out-alt" style="padding: 0 5px;"></i></a></li>
                                        </ul>
                                    </li>                                   
                                </ul>
                            </c:if>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="container">
        <div class="row">
            <div class="col-lg-3">
                <div class="header__logo">
                    <a href="./"><img src="images/logo.png" alt="logo" /></a>
                </div>
            </div>
            <div class="col-lg-6">
                <nav class="header__menu">
                    <ul>
                        <li><a href="./">Trang chủ</a></li>
                        <li><a href="#buyProduct">Mua hàng</a></li>
                        <li>
                            <a href="#">Khác</a>
                            <ul class="header__menu__dropdown">
                                <li><a href="cart">Thanh toán</a></li>
                                <li><a href="login">Đăng nhập</a></li>
                                <li><a href="signup">Đăng ký</a></li>
                            </ul>
                        </li>
                    </ul>
                </nav>
            </div>
            <div class="col-lg-3">
                <div class="header__cart">
                    <ul>
                        <li>
                            <a href="cart">
                                <i class="fa fa-shopping-bag">Giỏ hàng</i> <span>${sessionScope.qcart}</span>
                            </a>
                        </li>
                    </ul>
                    <c:if test="${sessionScope.sum!=null}">   
                        <div class="header__cart__price">
                            Tổng: <span><fmt:formatNumber value="${sessionScope.sum}" type="currency"/></span>
                        </div>
                    </c:if>
                </div>
            </div>
        </div>
        <div class="humberger__open">
            <i class="fa fa-bars"></i>
        </div>
    </div>
</header>