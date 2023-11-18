<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <title>AdminLTE 3 | E-commerce</title>
    <jsp:include page="header.jsp" />
</head>

<body class="hold-transition sidebar-mini">
    <!-- Site wrapper -->
    <div class="wrapper">
        <jsp:include page="navbar.jsp" />

        <jsp:include page="sidebar-menu.jsp" />

        <!-- Content Wrapper. Contains page content -->
        <div class="content-wrapper">
            <!-- Content Header (Page header) -->
            <section class="content-header">
                <div class="container-fluid">
                    <div class="row mb-2">
                        <div class="col-sm-6">
                            <h1>E-commerce</h1>
                        </div>
                        <div class="col-sm-6">
                            <ol class="breadcrumb float-sm-right">
                                <li class="breadcrumb-item"><a href="#">Home</a></li>
                                <li class="breadcrumb-item active">E-commerce</li>
                            </ol>
                        </div>
                    </div>
                </div><!-- /.container-fluid -->
            </section>

            <!-- Main content -->
            <section class="content">

                <!-- Default box -->
                <div class="card card-solid">
                    <div class="card-body">
                        <div class="row">
                            <div class="col-12 col-sm-6">
                                <h3 class="d-inline-block d-sm-none">${product.getProductTitle()}</h3>
                                <div class="col-12">
                                    <img src="../../dist/img/prod-1.jpg" class="product-image" alt="Product Image">
                                </div>
                                <div class="col-12 product-image-thumbs">
                                    <div class="product-image-thumb active"><img src="../../dist/img/prod-1.jpg"
                                            alt="Product Image"></div>
                                    <div class="product-image-thumb"><img src="../../dist/img/prod-2.jpg"
                                            alt="Product Image"></div>
                                    <div class="product-image-thumb"><img src="../../dist/img/prod-3.jpg"
                                            alt="Product Image"></div>
                                    <div class="product-image-thumb"><img src="../../dist/img/prod-4.jpg"
                                            alt="Product Image"></div>
                                    <div class="product-image-thumb"><img src="../../dist/img/prod-5.jpg"
                                            alt="Product Image"></div>
                                </div>
                            </div>
                            <div class="col-12 col-sm-6">
                                <h3 class="my-3">${product.getProductTitle()}</h3>
                                <p>${product.getShortDescription()}</p>

                                <div class="mt-4">
                                    <h2 class="mb-0">
                                        &#x20B9; ${product.getPrice()}
                                    </h2>
                                    <h4 class="mt-0">
                                        <small>MRP: <s>&#x20B9; ${product.getMrp()}</s> </small>
                                    </h4>
                                </div>

                                <hr>
                                <h4>Available Colors</h4>
                                <div class="btn-group btn-group-toggle" data-toggle="buttons">
                                    <label class="btn btn-default text-center active">
                                        <input type="radio" name="color_option" id="color_option_a1" autocomplete="off"
                                            checked>
                                        Green
                                        <br>
                                        <i class="fas fa-circle fa-2x text-green"></i>
                                    </label>
                                    <label class="btn btn-default text-center">
                                        <input type="radio" name="color_option" id="color_option_a2" autocomplete="off">
                                        Blue
                                        <br>
                                        <i class="fas fa-circle fa-2x text-blue"></i>
                                    </label>
                                    <label class="btn btn-default text-center">
                                        <input type="radio" name="color_option" id="color_option_a3" autocomplete="off">
                                        Purple
                                        <br>
                                        <i class="fas fa-circle fa-2x text-purple"></i>
                                    </label>
                                    <label class="btn btn-default text-center">
                                        <input type="radio" name="color_option" id="color_option_a4" autocomplete="off">
                                        Red
                                        <br>
                                        <i class="fas fa-circle fa-2x text-red"></i>
                                    </label>
                                    <label class="btn btn-default text-center">
                                        <input type="radio" name="color_option" id="color_option_a5" autocomplete="off">
                                        Orange
                                        <br>
                                        <i class="fas fa-circle fa-2x text-orange"></i>
                                    </label>
                                </div>



                                <div class="mt-4">
                                    <h2 class="mb-0">
                                        Product Details
                                    </h2>
                                    <table>
                                        <!-- for everything -->
                                        <tr>
                                            <td><b>Brand</b></td>
                                            <td>${product.getBrand()}</td>
                                        </tr>
                                        <tr>
                                            <td>Model</td>
                                            <td>${product.getModelName()}</td>
                                        </tr>
                                        <!-- for Mobile -->
                                        <c:if test="${product.getSubCategory() == 'Mobile'}">
                                        <tr>
                                            <td>Wireless Carrier</td>
                                            <td>${product.getWirelessCarrier()}</td>
                                        </tr>
                                        <tr>
                                            <td>Operating System</td>
                                            <td>${product.getOperatingSystem()}</td>
                                        </tr>
                                        <tr>
                                            <td>Cellular Technology</td>
                                            <td>${product.getCellularTechnology()}</td>
                                        </tr>
                                        <tr>
                                            <td>Memory Storage Capacity</td>
                                            <td>${product.getMemoryStorageCapacity()} GB</td>
                                        </tr>
                                        <tr>
                                            <td>Internal Storage Capacity</td>
                                            <td>${product.getInternalMemory()} GB</td>
                                        </tr>
                                        <tr>
                                            <td>Connectivity Technology</td>
                                            <td>${product.getConnectivityTechnology()}</td>
                                        </tr>
                                        <tr>
                                            <td>Screen Size</td>
                                            <td>${product.getScreenSize()} inch</td>
                                        </tr>
                                        <tr>
                                            <td>Battery Capacity</td>
                                            <td>${product.getBatteryCapacity()} MAH</td>
                                        </tr>
                                        <tr>
                                            <td>Front Camera</td>
                                            <td>${product.getBatteryCapacity()}</td>
                                        </tr>
                                        <tr>
                                            <td>Rear Camera</td>
                                            <td>${product.getBatteryCapacity()}</td>
                                        </tr>
                                        <tr>
                                            <td>Wireless Network Technology</td>
                                            <td>${product.getWirelessNetworkTechnology()}</td>
                                        </tr>
                                    </c:if>
                                        <!-- for Mobile and Television -->
                                        <c:if test="${product.getSubCategory() =='Mobile' or product.getSubCategory() =='Television'}">
                                        <tr>
                                            <td>Screen Size</td>
                                            <td>${product.getScreenSize()}</td>
                                        </tr>
                                    </c:if>
                                        <!-- for Television -->
                                        <c:if test="${product.getSubCategory() =='Television'}">
                                        <tr>
                                            <td>Supported Internet Services</td>
                                            <td>${product.getSupportedInternetServices()}</td>
                                        </tr>
                                        <tr>
                                            <td><b>Display Technology</b></td>
                                            <td>${product.getDisplayTechnology()}</td>
                                        </tr>
                                        <tr>
                                            <td><b>Product Dimensions</b></td>
                                            <td>${product.getProductDimensions()}</td>
                                        </tr>
                                        <tr>
                                            <td><b>Resolution</b></td>
                                            <td>${product.getResolution()}</td>
                                        </tr>
                                        <tr>
                                            <td><b>Refresh Rate</b></td>
                                            <td>${product.getRefreshRate()}</td>
                                        </tr>
                                        <tr>
                                            <td><b>Special Feature</b></td>
                                            <td>${product.getSpecialFeature()}</td>
                                        </tr>
                                        <tr>
                                            <td><b>Included Components</b></td>
                                            <td>${product.getIncludedComponents()}</td>
                                        </tr>
                                    </c:if>
                                        <!-- for Shoes -->
                                        <c:if test="${product.getSubCategory()=='Shoes'}">
                                        <tr>
                                            <td><b>Sizes</b></td>
                                            <td>${product.getSizes()}</td>
                                        </tr>
                                    </c:if>
                                    </table>
                                </div>

                            </div>
                        </div>
                        <div class="row mt-4">
                            <nav class="w-100">
                                <div class="nav nav-tabs" id="product-tab" role="tablist">
                                    <a class="nav-item nav-link active" id="product-desc-tab" data-toggle="tab"
                                        href="#product-desc" role="tab" aria-controls="product-desc"
                                        aria-selected="true">Description</a>
                                    <a class="nav-item nav-link" id="product-comments-tab" data-toggle="tab"
                                        href="#product-comments" role="tab" aria-controls="product-comments"
                                        aria-selected="false">Comments</a>
                                </div>
                            </nav>
                            <div class="tab-content p-3" id="nav-tabContent">
                                <div class="tab-pane fade show active" id="product-desc" role="tabpanel"
                                    aria-labelledby="product-desc-tab">${product.getProductDescription()}</div>
                                <div class="tab-pane fade" id="product-comments" role="tabpanel"
                                    aria-labelledby="product-comments-tab">
                                <form action="/writeComment" method="post" mnodelAttribute="Comments">
                                    <table>
                                        <tr>
                                            <td>Write comment</td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <textarea name="comment" cols="50" rows="3"></textarea>
                                            </td>
                                        </tr>
                                        <input type="text" name="productId" value="${product.getId()}" hidden>
                                        <input type="text" name="customerId" value="11" hidden>
                                        <input type="text" name="customerName" value="Vishal Singh" hidden>
                                    <tr>
                                        <td>
                                            <input type="submit" value="Write comment">
                                        </td>
                                    </tr>
                                    </table>
                                </form>
                                <table>
                                    <c:forEach var = "comment" items="${comments}">
                                    <tr>
                                        <td><br>
                                            ${comment.getCustomerName()}<br>
                                            ${comment.getRecordCreated()}<br>
                                            ${comment.getComment()}<br>
                                        </td>
                                    </tr>
                                    </c:forEach>
                                </table>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- /.card-body -->
                </div>
                <!-- /.card -->

            </section>
            <!-- /.content -->
        </div>
        <!-- /.content-wrapper -->

        <jsp:include page="footer.jsp" />

        <!-- Control Sidebar -->
        <aside class="control-sidebar control-sidebar-dark">
            <!-- Control sidebar content goes here -->
        </aside>
        <!-- /.control-sidebar -->
    </div>
    <!-- ./wrapper -->

    <jsp:include page="footer-scripts.jsp" />
</body>

</html>