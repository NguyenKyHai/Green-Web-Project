<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css">
<div class="dashboard-header">
    <nav class="navbar navbar-expand-lg bg-white fixed-top">
        <a class="nav-link" href="./">
            <i class="fa fa-fw fa-home" style="font-size: 40px"></i>
        </a>
        <a class="navbar-brand" href="management">Trang Quản Lý Hệ Thống</a>
    </nav>
</div>

<div class="nav-left-sidebar sidebar-dark">
    <div class="menu-list">
        <nav class="navbar navbar-expand-lg navbar-light">
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav flex-column">
                    <li class="nav-divider">Danh mục</li>
                    <li class="nav-item">
                        <a
                            class="nav-link"
                            href="user-management"
                            data-toggle="collapse"
                            aria-expanded="false"
                            data-target="#submenu-1"
                            aria-controls="submenu-1"
                            ><i class="fa fa-fw fa-user-circle"></i>Người dùng
                            <span class="badge badge-success">6</span></a
                        >
                    </li>
                    <li class="nav-item">
                        <a
                            class="nav-link"
                            href="product-management"
                            data-toggle="collapse"
                            aria-expanded="false"
                            data-target="#submenu-2"
                            aria-controls="submenu-2"
                            ><i class="fa fa-fw fa-rocket"></i>Sản phẩm</a
                        >
                    </li>

                    <li class="nav-item">
                        <a
                            class="nav-link"
                            href="order-management"
                            data-toggle="collapse"
                            aria-expanded="false"
                            data-target="#submenu-4"
                            aria-controls="submenu-4"
                            ><i class="fas fa-calendar-check"></i>Đơn hàng</a
                        >
                    </li>

                    <li class="nav-item">
                        <a
                            class="nav-link"
                            href="statistical"
                            data-toggle="collapse"
                            aria-expanded="false"
                            data-target="#submenu-4"
                            aria-controls="submenu-4"
                            ><i class="fas fa-chart-bar"></i>Thống kê</a
                        >
                    </li>
                </ul>
            </div>
        </nav>
    </div>
</div>
