<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>  
<!DOCTYPE html>
<html>
    <link rel="stylesheet" href="templates2/cart.css">
    <%@include file="common/head.jsp" %>

    <body>
        <fmt:setLocale value="vi-VN"/>
        <!--begin of menu-->
        <%@include file="common/header.jsp" %>
        <div class="container">
            <table id="cart" class="table table-hover table-condensed">
                <thead>
                    <tr>
                        <th style="width:50%">Tên sản phẩm</th>
                        <th style="width:10%">Giá</th>
                        <th style="width:10%">Số lượng</th>
                        <th style="width:22%" class="text-center">Thành tiền</th>
                        <th style="width:10%"> </th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${list}" var="o">
                        <tr>
                            <td data-th="Product">
                                <div class="row">
                                    <div class="col-sm-2 hidden-xs"><img
                                            src="images/${o.productid.image}"
                                            alt="Sản phẩm" class="img-responsive" width="100">
                                    </div>
                                    <div class="col-sm-10">
                                        <h4 class="nomargin">${o.productid.name}</h4>
                                        <p>${o.productid.categoryid.name}</p>
                                    </div>
                                </div>
                            </td>
                            <td data-th="Price"><fmt:formatNumber value="${o.productid.price}" type="currency"/></td>
                            <td data-th="Quantity"> 
                                <a href="sub?id=${o.productid.productid}"><button class="btnSub">-</button></a> 
                                <strong>${o.quantity}</strong>
                                <a href="addcart?id=${o.productid.productid}&quantity=1" ><button class="btnAdd">+</button></a>
                            </td>
                            <td data-th="Subtotal" class="text-center"><fmt:formatNumber value="${o.productid.price*o.quantity}" type="currency"/></td>
                            <td class="actions" data-th=""><a href="remove?id=${o.productid.productid}" class="text-dark">
                                    <button class="btn btn-danger btn-sm">Xóa</button>
                                </a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
                <tfoot>
                    <tr>
                        <td><a href="./" class="btn btn-warning">Tiếp tục mua hàng</a>
                        </td>
                        <td colspan="2" class="hidden-xs"> </td>
                        <td class="hidden-xs text-center">
                            <strong>Tổng tiền: <span><fmt:formatNumber value="${sessionScope.sum}" type="currency"/></span></strong></br>
                            <strong>(Đã bao gồm thuế: 2%)</strong>
                        </td>
                        <td><a href="remove-all" class="btn btn-danger btn-block">Xóa hết
                        </td>
                    </tr>
                </tfoot>
            </table>
        </div>
        <div class="form_info">
            <c:if test="${sessionScope.usersession!=null && sessionScope.qcart!=0}"> 
                <div>
                    <h2>Thông tin giao hàng</h2>
                    <h4 class="note">Quý khách vui lòng cung cấp đầy đủ các thông tin</h4>
                    <h5>Cám ơn quý khách đã tin tưởng và mua hàng tại Website của chúng tôi</h5>
                </div>
                <form action="order" method="post" class="delivery-product">
                    <table>
                        <tr>
                            <td>Tên của bạn</td>
                            <td>
                                <input type="text" placeholder="Họ và tên" name="username" required=""/>
                            </td>
                        </tr>
                        <tr>
                            <td>Số điện thoại liên hệ</td>
                            <td>
                                <input type="text" placeholder="Số điện thoại" name="sodienthoai" required=""/>
                            </td>
                        </tr>
                        <tr>
                            <td>Địa chỉ giao hàng</td>
                            <td>
                                <input type="text" placeholder="Địa chỉ giao hàng" name="address" required=""/>
                            </td>
                        </tr>
                        <tr>
                            <td>Phương thức thanh toán</td>
                            <td>
                                <select name="department">
                                    <option class="pay_for">Tiền mặt</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td></td>
                            <td>
                                <input type="submit" class="btn btn-success btn-block" value="Thanh toán"/>
                            </td>
                        </tr>
                    </table>
                </form>
            </c:if>
            <c:if test="${sessionScope.usersession==null}">
              <div style="margin-top: 30px;">
                <a href="login" class="btn btn-success">MUA HÀNG</a>
            </div>
            </c:if>
        </div>

        <script src="templates/functionWeb.js"></script>
    </body>

    <%@include file="common/footer.jsp" %>
</html>
