<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Quản lý người dùng</title>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="icon"
              href="https://scontent.fsgn2-4.fna.fbcdn.net/v/t1.15752-9/245649683_296032139031123_8726178875137916058_n.png?_nc_cat=101&ccb=1-5&_nc_sid=ae9488&_nc_ohc=D04G5gZfD8IAX-Bq2Sh&_nc_ht=scontent.fsgn2-4.fna&oh=d83b75d6e4024bceecadd826bdbe7f5d&oe=6196055C"
              type="image/x-icon" />
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

        <link href="templates2/customerManager.css" rel="stylesheet" type="text/css" />

        <link rel="stylesheet" href="templates2/bootstrap.min.css" />
        <link rel="stylesheet" href="templates2/style.css" />

    </head>

    <body>
        <div class="dashboard-main-wrapper">
            <%@include file="common/category-admin.jsp" %>
            <div class="head-item">Quản lý người dùng</div>
            <div class="container float-right">
                <div class="table-wrapper">
                    <a href="#addEmployeeModal" class="btn" data-toggle="modal"><i class="material-icons">&#xE147;</i>
                        <span>Thêm người dùng</span></a>
                    <div class="edit-content">
                        <form action="edit-user" method="post">
                            <div class="modal-header">
                                <h4>Chỉnh sửa thông tin khách hàng</h4>
                            </div>
                            <div class="modal-body">
                                <div class="form-group">
                                    <label>UserID</label>
                                    <input name="userid" type="text" value="${user.id}" class="form-control" readonly>
                                </div>
                                <div class="form-group">
                                    <label>UserName</label>
                                    <input name="username" type="text" value="${user.username}" class="form-control">
                                </div>
                                <div class="form-group">
                                    <label>Password</label>
                                    <input name="password" type="text" value="${user.password}" class="form-control" required >
                                </div>
                                <div class="form-group">
                                    <label>Email</label>
                                    <input name="email" type="text" value="${user.email}" class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <label>Role</label>
                                    <input name="role" type="text" value="${user.role}" class="form-control" required>
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
                                <th>UserID</th>
                                <th>UserName</th>
                                <th>Password</th>
                                <th>Email</th>
                                <th>Role</th>
                                <th>Chỉnh sửa</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${listU}" var="o">
                                <tr>
                                    <td>${o.id}</td>
                                    <td>${o.username}</td>
                                    <td>${o.password}</td>
                                    <td>${o.email}</td>
                                    <td>${o.role}</td>

                                    <td>
                                        <a href="edit-user?id=${o.id}" class="edit" data-toggle="modal">
                                            <i class="material-icons" data-toggle="tooltip" title="Chỉnh sửa người dùng">&#xE254;</i>
                                        </a>
                                        <a href="delete-user?id=${o.id}" class="delete" data-toggle="modal">
                                            <i class="material-icons" data-toggle="tooltip" title="Xóa người dùng">&#xE872;</i>
                                        </a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
            <!-- Edit Modal HTML -->
            <div id="addEmployeeModal" class="modal">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <form action="add-user" method="post">
                            <div class="modal-header">
                                <h4 class="modal-title">Thêm người dùng</h4>
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            </div>
                            <div class="modal-body">
                                <div class="form-group">
                                    <label>UserName</label>
                                    <input name="username" type="text" class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <label>PassWord</label>
                                    <input name="password" type="text" class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <label>Email</label>
                                    <input name="email" type="email" class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <label>Role</label>
                                    <input name="role" type="text" class="form-control" required>
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
            <!-- Delete Modal HTML -->
            <div id="deleteEmployeeModal" class="modal fade">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <form action="DeleteUser" method="post">
                            <div class="modal-header">
                                <h4 class="modal-title">Xóa người dùng</h4>
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            </div>
                            <div class="modal-body">
                                <p>Bạn có chắc chắn muốn xóa người dùng này không ?</p>
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
        </div>

    </body>

</html>