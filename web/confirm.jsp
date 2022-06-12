<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Quên mật khẩu</title>
        <link rel="icon"
              href="https://scontent.fsgn2-4.fna.fbcdn.net/v/t1.15752-9/245649683_296032139031123_8726178875137916058_n.png?_nc_cat=101&ccb=1-5&_nc_sid=ae9488&_nc_ohc=D04G5gZfD8IAX-Bq2Sh&_nc_ht=scontent.fsgn2-4.fna&oh=d83b75d6e4024bceecadd826bdbe7f5d&oe=6196055C"
              type="image/x-icon" />
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css">
        <link href="templates2/changePassword.css" rel="stylesheet" type="text/css" />

    <body>
        <a class="backhome" href="home">
            <i class="fas fa-home"></i>Trang chủ 
        </a>
        <div class="container">
            <div class="info">
                <h2 class="title-main">Xác nhận email</h2>
                <form action="confirm" method="post">
                    <div class="form-info">
                        <p style="color:red">${message}</p>
                        <div class="form-group">
                            <label>Nhập mã code</label>
                            <input name="code" type="text" class="form-control" required>
                        </div> 
                        <div class="form-footer">
                            <button class="btn-save" type="submit">Gửi</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
        <script src="templates/functionWeb.js"></script>
    </body>
</html>
