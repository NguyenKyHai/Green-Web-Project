<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Thông tin khách hàng</title>
        <link rel="icon"
              href="https://scontent.fsgn2-4.fna.fbcdn.net/v/t1.15752-9/245649683_296032139031123_8726178875137916058_n.png?_nc_cat=101&ccb=1-5&_nc_sid=ae9488&_nc_ohc=D04G5gZfD8IAX-Bq2Sh&_nc_ht=scontent.fsgn2-4.fna&oh=d83b75d6e4024bceecadd826bdbe7f5d&oe=6196055C"
              type="image/x-icon" />
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css">
        <link href="templates2/changePassword.css" rel="stylesheet" type="text/css" />

    <body>
        <div class="container">
            <div class="info">
                <h2 class="title-main">Đổi mật khẩu người dùng</h2>
                <form action="change-password" method="post">
                    <div class="form-info">
                        <p style="color:red; text-align: center;">${message}</p>
                        <div class="form-group">
                            <label>Nhập mật khẩu cũ</label>
                            <input name="oldpass" type="password" class="form-control" required>
                        </div>
                        <div class="form-group">
                            <label>Nhập mật khẩu mới</label>
                            <input name="newpass" type="password" class="form-control" required>
                        </div>
                        <div class="form-group">
                            <label>Nhập lại mật khẩu mới</label>
                            <input name="renewpass" type="password" class="form-control" required>
                        </div>
                        <div class="form-footer">
                            <input type="submit" class="btn-save" value="Đổi mật khẩu">
                        </div>
                    </div>
                        <div class="title-main" style="text-align: center; padding:30px 0px;">
                        <a href="./" style="font-weight: bold;">Trang chủ</a>
                    </div>
                </form>
            </div>
        </div>
    </body>

</html>
