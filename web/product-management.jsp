<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Quản lý sản phẩm</title>
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
        <link rel="stylesheet" href="templates2/bootstrap.min.css" />
        <link rel="stylesheet" href="templates2/style.css" />
    </head>

    <body>
        <div class="dashboard-main-wrapper">
            <%@include file="common/category-admin.jsp" %>
            <fmt:setLocale value="vi-VN"/>
            <div class="head-item">Quản lý sản phẩm</div>
            <div class="container float-right">
                <div class="table-wrapper">
                    <a href="#addEmployeeModal" class="btn btn-add" data-toggle="modal"><i class="material-icons">&#xE147;</i>
                        <span>Thêm sản phẩm</span>
                    </a>
                    <div class="edit-content">
                        <form action="edit-product" method="post">
                            <div class="modal-header">
                                <h4>Chỉnh sửa thông tin sản phẩm</h4>
                            </div>
                            <div class="modal-body">
                                <div class="form-group">
                                    <label>Mã sản phẩm</label>
                                    <input type="text" name="productid" value="${product.productid}" class="form-control"readonly>
                                </div>
                                <div class="form-group">
                                    <label>Tên sản phẩm</label>
                                    <input type="text" name="name" value="${product.name}" class="form-control" required="">
                                </div>
                                <div class="form-group">
                                    <label>Hình ảnh sản phẩm</label>
                                    <img src="images/${product.image}">
                                    <input type="text" name="image" value="${product.image}"class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <label>Giá sản phẩm</label>
                                    <input type="text" name="price" value="${product.price}" class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <label>Loại sản phẩm: </label>
                                    <select name="category" class="form-select" aria-label="Default select example">
                                        <c:forEach items="${listC}" var="o">
                                            <option ${product.categoryid.categoryid==o.categoryid?"selected":""} value="${o.categoryid}">${o.name}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                            <div class="modal-footer">
                                <input type="submit" class="btn-save" value="Lưu">
                            </div>
                        </form>
                    </div>
                    <table class="table table-striped table-hover">
                        <thead>
                            <tr>
                                <th>Mã sản phẩm</th>
                                <th>Tên sản phẩm</th>
                                <th>Hình ảnh</th>
                                <th>Giá</th>
                                <th>Loại sản phẩm</th>
                                <th>Chỉnh sửa</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${listP}" var="o">
                                <tr>
                                    <td>${o.productid}</td>
                                    <td>${o.name}</td>
                                    <td>
                                        <div>
                                            <img src="images/${o.image}">
                                        </div>
                                    </td>
                                    <td><fmt:formatNumber value="${o.price}" type="currency"/></td>
                                    <td>${o.categoryid.name}</td>
                                    <td>
                                        <a href="edit-product?id=${o.productid}" class="edit" data-toggle="modal">
                                            <i class="material-icons" data-toggle="tooltip" title="Chỉnh sửa sản phẩm">&#xE254;</i></a>
                                        <a href="delete-product?id=${o.productid}" class="delete" data-toggle="modal"><i
                                                class="material-icons" data-toggle="tooltip"
                                                title="Xóa sản phẩm">&#xE872;</i></a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                    <div class="total">
                        <form action="">
                            <p>Tổng cộng: ${numproduct} sản phẩm</p> 
                        </form>
                    </div>
                </div>
            </div>
            <!-- Edit Modal HTML -->
            <div id="addEmployeeModal" class="modal">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <form action="add-product" method="post">
                            <div class="modal-header">
                                <h4 class="modal-title">Thêm sản phẩm</h4>
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            </div>
                            <div class="modal-body">
                                <div class="form-group">
                                    <label>Tên sản phẩm</label>
                                    <input name="name" type="text" class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <label>Giá</label>
                                    <input name="price" class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <label>Hình ảnh</label>
                                    <input name="image" type="text" class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <label>Danh mục</label>
                                    <select name="category" class="form-select" aria-label="Default select example">
                                        <c:forEach items="${listC}" var="o">
                                            <option value="${o.categoryid}">${o.name}</option>
                                        </c:forEach>
                                    </select>
                                </div>

                            </div>
                            <div class="modal-footer">
                                <input type="button" class="btn-cancel" data-dismiss="modal" value="Hủy">
                                <input type="submit" class="btn-add" value="Thêm">
                            </div>
                        </form>
                    </div>
                </div>
            </div>
            <!-- Edit Modal HTML -->

            <!--Delete Modal HTML--> 
            <div id="deleteEmployeeModal" class="modal fade">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <form>
                            <div class="modal-header">
                                <h4 class="modal-title">Xóa sản phẩm</h4>
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            </div>
                            <div class="modal-body">
                                <p>Bạn có chắc chắn muốn xóa sản phẩm này không ?</p>
                                <p class="text-warning"><small>Đây là hành động không thể khôi phục</small></p>
                            </div>
                            <div class="modal-footer">
                                <input type="button" class="btn-cancel" data-dismiss="modal" value="Hủy">
                                <input type="submit" class="btn-delete" value="Xóa">
                            </div>
                        </form>
                    </div>
                </div>
            </div>
    </body>

</html>
