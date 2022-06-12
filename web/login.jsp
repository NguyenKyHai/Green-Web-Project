<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="icon"
              href="https://scontent.fsgn2-4.fna.fbcdn.net/v/t1.15752-9/245649683_296032139031123_8726178875137916058_n.png?_nc_cat=101&ccb=1-5&_nc_sid=ae9488&_nc_ohc=D04G5gZfD8IAX-Bq2Sh&_nc_ht=scontent.fsgn2-4.fna&oh=d83b75d6e4024bceecadd826bdbe7f5d&oe=6196055C"
              type="image/x-icon" />
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css">

        <title>Đăng nhập - Green Market</title>

        <link rel="stylesheet" type="text/css" href="templates2/login.css">
    </head>

    <body>
        <div id="background">
            <div class="login">
                <div class="logo-login">
                    <img src="images/logo.png" alt="logo">
                </div>
                <div class="title-login">
                    <h2>Đăng nhập</h2>
                    <p style="color:red">${message}</p>
                </div>
                <form action="login" method="post">
                    <div class="input-user">
                        <i class="fas fa-user"></i>
                        <input name ="user" type="text" placeholder="Tên đăng nhập" required="">
                    </div>
                    <div class="input-password">
                        <i class="fas fa-key"></i>
                        <input name="password" type="password" placeholder="Mật khẩu" required="">
                    </div>
                    <div class="btn-login">
                        <button type="submit">
                            Đăng nhập
                        </button>
                    </div>
                    <div class="link-register">
                        Bạn chưa có tài khoản?
                        <a href="signup">Đăng ký</a>
                    </div>
                    <div class="or">
                        <a href="forgot-password">Quên mật khẩu?</a>
                    </div>
                    <div class="title-login">
                        <a href="./" style="font-weight: bold;">Trang chủ</a>
                    </div>
                </form>

            </div>
        </div>
    </body>

</html>