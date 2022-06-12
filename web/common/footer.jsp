<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<footer class="footer spad">
    <div class="container">
        <div class="row">
            <div class="col-lg-3 col-md-6 col-sm-6">
                <div class="footer__about">
                    <div class="footer__about__logo">
                        <a href="./"><img src="img/logo.png" alt="" /></a>
                    </div>
                    <ul>
                        <li>Address: Số 1, Võ Văn Ngân, TP.Thủ Đức, TP.HCM</li>
                        <li>Phone: 0396 427 446</li>
                        <li>Email: greenmarket827@gmail.com</li>
                    </ul>
                </div>
            </div>
            <div class="col-lg-4 col-md-6 col-sm-6 offset-lg-1">
                <div class="footer__widget">
                    <h6>Danh mục sản phẩm</h6>
                    <ul>
                        <c:forEach items="${listC}" var="c"> 
                            <li><a href="category-detail?categoryid=${c.categoryid}" >${c.name}</a></li>
                        </c:forEach>
                    </ul>
                </div>
            </div>
            <div class="col-lg-4 col-md-12">
                <div class="footer__widget">
                    <h6>Đăng ký ngay</h6>
                    <p>
                        Nhận cập nhật qua E-mail về cửa hàng mới nhất của chúng tôi và các ưu đãi đặc biệt.
                    </p>
                    <form action="#" style="width: auto;">
                        <input type="text" placeholder="Nhập email của bạn..." />
                        <button type="submit" class="site-btn">Đăng ký</button>
                    </form>
                    <div class="footer__widget__social">
                        <a href="https://www.facebook.com/"><i class="fa fa-facebook"></i></a>
                        <a href="https://www.instagram.com/"><i class="fa fa-instagram"></i></a>
                        <a href="https://www.twitter.com/"><i class="fa fa-twitter"></i></a>
                        <a href="https://www.pinterest.com/"><i class="fa fa-pinterest"></i></a>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-12">
                <div class="footer__copyright">
                    <div class="footer__copyright__text">
                        <p>
                            <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                            Copyright &copy;
                            <script>
                                document.write(new Date().getFullYear());
                            </script>
                            <i class="fa fa-heart" aria-hidden="true"></i> by GreenMarket
                        </p>
                    </div>
                    <div class="footer__copyright__payment">
                        <img src="img/payment-item.png" alt="" />
                    </div>
                </div>
            </div>
        </div>
    </div>
</footer>