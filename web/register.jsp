
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
        <link rel="stylesheet" type="text/css" href="templates2/register.css">
        <title>Đăng ký - Green Market</title>
    </head>

    <body>
        <div id="background">
            <div class="register">
                <div class="logo-register">
                    <img src="images/logo.png">
                </div>
                <div class="title-register">
                    <h2>Đăng ký</h2>
                    <p style="color:red">${message}</p>
                </div>
                <form action="signup" method="post">
                    <div class="input-user">
                        <input name="user" value="${username}"type="text" placeholder="Tên đăng nhập" required="">
                    </div>
                    <div class="input-password"">
                        <input name="email" value="${email}"type="email" placeholder="Nhập email" required="">
                    </div>
                    <div class="input-password">
                        <input name="pass" value="${pass}" type="password" placeholder="Mật khẩu" required="">
                    </div>
                    <div class="input-repeat-password">
                        <input name="repass" type="password" placeholder="Nhập lại mật khẩu" required="">
                    </div>

                    <div class="btn-register">
                        <button type="submit">
                            Đăng ký
                        </button>
                    </div>
                </form>
                <div class="title-register">
                    <a href="./" style="font-weight: bold;">Trang chủ</a>
                </div>
            </div>
        </div>
    </body>

</html>