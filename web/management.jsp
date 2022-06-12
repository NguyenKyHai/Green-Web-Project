<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta
            name="viewport"
            content="width=device-width, initial-scale=1, shrink-to-fit=no"
            />

        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet"
              integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
        <link rel="icon"
              href="https://scontent.fsgn2-4.fna.fbcdn.net/v/t1.15752-9/245649683_296032139031123_8726178875137916058_n.png?_nc_cat=101&ccb=1-5&_nc_sid=ae9488&_nc_ohc=D04G5gZfD8IAX-Bq2Sh&_nc_ht=scontent.fsgn2-4.fna&oh=d83b75d6e4024bceecadd826bdbe7f5d&oe=6196055C"
              type="image/x-icon" />

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="templates2/bootstrap.min.css" />
        <link rel="stylesheet" href="templates2/style.css" />
        <title>Quản lý</title>
    </head>

    <body>
        <div class="dashboard-main-wrapper">
            <%@include file="common/category-admin.jsp" %>
            <div class="dashboard-wrapper">
                <div class="dashboard-ecommerce">
                    <div class="container-fluid dashboard-content">
                        <div class="row">
                            <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
                                <div class="page-header">
                                    <h2 class="pageheader-title">Quản lý hệ thống</h2>
                                </div>
                            </div>
                        </div>
                        <div class="ecommerce-widget">
                            <div class="row">
                                <div class="col-xl-3 col-lg-6 col-md-6 col-sm-12 col-12">
                                    <div class="card">
                                        <div class="card-body">
                                            <h5 class="text-muted">Tổng người dùng</h5>
                                            <div class="metric-value d-inline-block">
                                                <h1 class="mb-1">${numuser}</h1>
                                            </div>
                                            <div
                                                class="
                                                metric-label
                                                d-inline-block
                                                float-right
                                                text-success
                                                font-weight-bold
                                                "
                                                >
                                                <!-- <span><i class="fa fa-fw fa-arrow-up"></i></span
                                                ><span>5.86%</span> -->
                                            </div>
                                        </div>
                                        <div id="sparkline-revenue"></div>
                                    </div>
                                </div>
                                <div class="col-xl-3 col-lg-6 col-md-6 col-sm-12 col-12">
                                    <div class="card">
                                        <div class="card-body">
                                            <h5 class="text-muted">Tổng sản phẩm</h5>
                                            <div class="metric-value d-inline-block">
                                                <h1 class="mb-1">${numproduct}</h1>
                                            </div>
                                            <div
                                                class="
                                                metric-label
                                                d-inline-block
                                                float-right
                                                text-success
                                                font-weight-bold
                                                "
                                                >

                                            </div>
                                        </div>
                                        <div id="sparkline-revenue2"></div>
                                    </div>
                                </div>
                                <div class="col-xl-3 col-lg-6 col-md-6 col-sm-12 col-12">
                                    <div class="card">
                                        <div class="card-body">
                                            <h5 class="text-muted">Tổng đơn hàng</h5>
                                            <div class="metric-value d-inline-block">
                                                <h1 class="mb-1">${numorder}</h1>
                                            </div>
                                            <div
                                                class="
                                                metric-label
                                                d-inline-block
                                                float-right
                                                text-primary
                                                font-weight-bold
                                                "
                                                >
                                            </div>
                                        </div>
                                        <div id="sparkline-revenue3"></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div>
                    <div id="chart" style="padding-left: 30px;"></div>
                </div>  
            </div>
        </div>

        <!-- jquery 3.3.1 -->
        <script
            type="text/javascript"
            src="https://www.gstatic.com/charts/loader.js"
        ></script>

        <script type="text/javascript">
            //load the Google Visualization API and the chart
            google.load('visualization', '1', {'packages': ['columnchart']});

            //set callback
            google.setOnLoadCallback(createChart);

            //callback function
            function createChart() {

                //create data table object
                var dataTable = new google.visualization.DataTable();

                //define columns
                dataTable.addColumn('string', 'Quarters 2009');
                dataTable.addColumn('number', 'SLSP');

                //define rows of data
                dataTable.addRows([
                    ['Sp/ngày', ${numdate}],
                    ['Sp/tuần', ${numweek}],
                    ['Tổng đơn hàng', ${numorder}],
                ]);

                //instantiate our chart object
                var chart = new google.visualization.ColumnChart(document.getElementById('chart'));

                //define options for visualization
                var options = {width: 750, height: 300, is3D: true, title: 'Thống kê số lượng'};

                //draw our chart
                chart.draw(dataTable, options);

            }
        </script>

        <script
            type="text/javascript"
            src="https://canvasjs.com/assets/script/canvasjs.min.js"
        ></script>

        <script src="templates2/bootstrap.bundle.js"></script>
        <script src="templates2/dashboard-ecommerce.js"></script>
        <script src="templates2/jquery-3.3.1.min.js"></script>
        <script src="templates2/jquery.slimscroll.js"></script>
        <script src="templates2/main-js.js"></script>
    </body>
</html>
