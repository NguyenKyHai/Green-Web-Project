<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>  
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Quản lý đơn hàng</title>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="icon"
              href="https://scontent.fsgn2-4.fna.fbcdn.net/v/t1.15752-9/245649683_296032139031123_8726178875137916058_n.png?_nc_cat=101&ccb=1-5&_nc_sid=ae9488&_nc_ohc=D04G5gZfD8IAX-Bq2Sh&_nc_ht=scontent.fsgn2-4.fna&oh=d83b75d6e4024bceecadd826bdbe7f5d&oe=6196055C"
              type="image/x-icon" />
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link href="templates2/productManager.css" rel="stylesheet" type="text/css" />
        <link href="templates2/orderManager.css" rel="stylesheet" type="text/css" />
        <link rel="stylesheet" href="templates2/bootstrap.min.css" />
        <link rel="stylesheet" href="templates2/style.css" />

    <body>
        <div class="dashboard-main-wrapper">
            <%@include file="common/category-admin.jsp" %>
            <fmt:setLocale value="vi-VN"/>
            <%@include file="common/navbar-statistical.jsp" %>
            <div class="head-item">Thống kê sản phẩm theo khoảng thời gian</div>
            <form action="statistical-by-time" method="get" style="text-align: center; padding-top: 20px;">
                <label>Từ ngày: </label>
                  <fmt:formatDate pattern = "yyyy-MM-dd" 
                                                    value = "${fromdate}" var="fromdate" />
                  <fmt:formatDate pattern = "yyyy-MM-dd" 
                                                    value = "${todate}" var="todate" />
                  <input type="date" name="fromdate" value="${fromdate}" placeholder="dd/mm/yyyy" />   
                 <label>Đến ngày: </label>
                 <input type="date" name="todate" value="${todate}" placeholder="dd/mm/yyyy" />    
                <input type="submit" value="Thống kê"/>
            </form>
            <div class="container float-right">
                <div class="container float-right">
                    <div class="table-wrapper">
                        <p style="font-size: 20px;">Tổng cộng: ${count} sản phẩm</p> 
                        <table class="table table-striped table-hover">
                            <thead>
                                <tr>
                                    <th>Mã sản phẩm</th>
                                    <th>Tên sản phẩm</th>
                                    <th>Hình ảnh</th>
                                    <th>Giá</th>
                                    <th>Số lượng</th>
                                    <th>Tổng tiền</th>
                                    <th>Loại sản phẩm</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${list}" var="o">
                                    <tr>
                                        <td>${o.productid.productid}</td>
                                        <td>${o.productid.name}</td>
                                        <td>
                                            <div>
                                                <img src="images/${o.productid.image}">
                                            </div>
                                        </td>
                                        <td><fmt:formatNumber value="${o.productid.price}" type="currency"/></td>
                                        <td>${o.quantity}</td>
                                        <td>${o.productid.price*o.quantity}</td>
                                        <td>${o.productid.categoryid.name}</td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
