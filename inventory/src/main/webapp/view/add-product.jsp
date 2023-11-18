<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

</body>
</html>


<!DOCTYPE html>
<html lang="en">
<head>
  <title>AdminLTE 3 | Validation Form</title>
  <jsp:include page="header.jsp" />
</head>
<body class="hold-transition sidebar-mini">
<div class="wrapper">
  <!-- Navbar -->
  <jsp:include page="navbar.jsp" />
  <!-- /.navbar -->

  <!-- Main Sidebar Container -->
  <jsp:include page="sidebar-menu.jsp" />

  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->

    <c:if test = "${product_type != null}">
    <section class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6">
            <h4>Add product [${product_type}]</h4>
          </div>
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="#">Product</a></li>
              <li class="breadcrumb-item active">Add Product</li>
            </ol>
          </div>
        </div>
      </div><!-- /.container-fluid -->
    </section>
  </c:if>

  <c:if test = "${product_type == null}">
    <section class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="">
            <p>Please use sidebnar menu to add a specific product with category or use the following format of URL to add a product<br>
            localhost:8080/add-product/{category-name}<br><br>
            Below are the list of categories names<br>
            <ol>
              <c:forEach var = "category" items="${categories}">
                <li>${category.getCategoryName()}</li>
              </c:forEach>
            </ol>
            </p>
          </div>
        </div>
      </div><!-- /.container-fluid -->
    </section>
  </c:if>
    <!-- Main content -->

  <c:if test = "${error != null}">
    <p>${error}</p>
  </c:if>

    <!-- <c:if test = "${product_type != null}">
    <section class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="form-group">
            <label for="exampleInputPassword1">Product Category</label>
            <div class="form-group">
                <select class="form-control" name="category" required>
                  <c:forEach var = "category" items="${categories}">
                  <option value="${category.getCategoryName()}">${category.getCategoryName()}</option>
                </c:forEach>
                </select>
              </div> 
              
        </div>
        </div>
      </div>
    </section>
  </c:if> -->

    <c:if test = "${product_type == 'Mobile'}">
    <section class="content">
      <div class="container-fluid">
        <div class="row">
          <!-- left column -->
          <div class="col-md-12">
            <!-- jquery validation -->
            <div class="card card-primary">
              <!-- form start -->
              <form action="/addProduct" method="post" modelAttribut="Product">
                <div class="card-body">
                  <div class="form-group">
                    <label for="exampleInputEmail1">Sub Category</label>
                    <input type="text" readonly value="${product_type}" name="subCategory" class="form-control" id="exampleInputEmail1" placeholder="">
                  </div>
                  <div class="form-group">
                    <label for="exampleInputEmail1">Product Title</label>
                    <input type="text" name="productTitle" class="form-control" id="exampleInputEmail1" placeholder="">
                  </div>
                  <div class="form-group">
                    <label for="exampleInputPassword1">MRP</label>
                    <input type="number" name="mrp" class="form-control" id="exampleInputPassword1" placeholder="">
                  </div>
                  <div class="form-group">
                    <label for="exampleInputPassword1">Price</label>
                    <input type="number" name="price" class="form-control" id="exampleInputPassword1" placeholder="">
                  </div>
                  <div class="form-group">
                    <label for="exampleInputPassword1">Colors</label>
                    <div class="form-group">
                        <select multiple class="form-control" name="colors">
                          <option>Blue</option>
                          <option>Black</option>
                          <option>Gray</option>
                          <option>Red</option>
                          <option>Pink</option>
                        </select>
                      </div>    
                </div>
                  <div class="form-group">
                    <label for="exampleInputPassword1">Brand</label>
                    <input type="text" name="brand" class="form-control" id="exampleInputPassword1" placeholder="">
                  </div>
                  <div class="form-group">
                    <label for="exampleInputPassword1">Model Name</label>
                    <input type="text" name="modelName" class="form-control" id="exampleInputPassword1" placeholder="">
                  </div>
                  <div class="form-group">
                    <label for="exampleInputPassword1">Wireless Carrier</label>
                    <input type="text" name="wirelessCarrier" class="form-control" id="exampleInputPassword1" placeholder="">
                  </div>
                  <div class="form-group">
                    <label for="exampleInputPassword1">Operating System</label>
                    <select class="form-control" name="operatingSystem">
                      <option>Android 14</option>
                      <option>Android 13</option>
                      <option>Android 12</option>
                      <option>Android 11</option>
                      <option>iOS 17</option>
                      <option>iOS 16</option>
                      <option>iOS 15</option>
                      <option>iOS 14</option>
                    </select>    
                </div>
                  <div class="form-group">
                    <label for="exampleInputPassword1">Cellular Technology</label>
                    <select class="form-control" name="cellularTechnology">
                      <option>4G</option>
                      <option>5G</option>
                    </select> </div>
                  <div class="form-group">
                    <label for="exampleInputPassword1">Memory Storage Capacity (RAM)</label>
                    <input type="text" name="memoryStorageCapacity" class="form-control" id="exampleInputPassword1" placeholder="">
                  </div>
                  <div class="form-group">
                    <label for="exampleInputPassword1">Internal Memory</label>
                    <input type="text" name="internalMemory" class="form-control" id="exampleInputPassword1" placeholder="">
                  </div>
                  <div class="form-group">
                    <label for="exampleInputPassword1">Front Camera (in Mega Pixel)</label>
                    <input type="text" name="frontCamera" class="form-control" id="exampleInputPassword1" placeholder="">
                  </div>
                  <div class="form-group">
                    <label for="exampleInputPassword1">Rear Camera (in Mega Pixel)</label>
                    <input type="text" name="rearCamera" class="form-control" id="exampleInputPassword1" placeholder="">
                  </div>
                  <div class="form-group">
                    <label for="exampleInputPassword1">Battery Capacity</label>
                    <input type="text" name="batteryCapacity" class="form-control" id="exampleInputPassword1" placeholder="">
                  </div>
                  <div class="form-group">
                    <label for="exampleInputPassword1">Connectivity Technology</label>
                    <div class="form-group">
                      <select multiple class="form-control" name="connectivityTechnology">
                        <option>Bluetooth</option>
                        <option>Wi-Fi</option>
                        <option>USB</option>
                      </select>
                    </div>
                  </div>
                  <div class="form-group">
                    <label for="exampleInputPassword1">Screen Size</label>
                    <input type="text" name="screenSize" class="form-control" id="exampleInputPassword1" placeholder="">
                  </div>
                  <div class="form-group">
                    <label for="exampleInputPassword1">Wireless Network Technology</label>
                    <div class="form-group">
                      <select multiple class="form-control" name="wirelessNetworkTechnology">
                        <option>GSM</option>
                        <option>Wi-Fi</option>
                        <option>CDMA</option>
                        <option>LTE</option>
                      </select>
                    </div>
                  </div>
                  <div class="form-group">
                    <label for="exampleInputPassword1">Stock Quantity</label>
                    <input type="number" name="stockQuantity" class="form-control" id="exampleInputPassword1" placeholder="">
                  </div>
                  <div class="form-group">
                    <label for="exampleInputPassword1">Short Description</label>
                    
                        <textarea name="shortDescription"></textarea>
                       
                </div>
                  <div class="form-group">
                    <label for="exampleInputPassword1">Product Description</label>
                    <div class="card-body">
                        <textarea id="summernote" name="productDescription"> 
                          Place <em>some</em> <u>text</u> <strong>here</strong>
                        </textarea>
                      </div>    
                </div>
                </div>
                <!-- /.card-body -->
                <div class="card-footer">
                  <button type="submit" class="btn btn-primary">Add Product</button>
                </div>
              </form>
            </div>
            <!-- /.card -->
            </div>
          <!--/.col (left) -->
          <!-- right column -->
          <div class="col-md-6">

          </div>
          <!--/.col (right) -->
        </div>
        <!-- /.row -->
      </div><!-- /.container-fluid -->
    </section>
    <!-- /.content -->
    </c:if>

    <c:if test = "${product_type == 'Television'}">
    <section class="content">
      <div class="container-fluid">
        <div class="row">
          <!-- left column -->
          <div class="col-md-12">
            <!-- jquery validation -->
            <div class="card card-primary">
              <!-- form start -->
              <form action="/addProduct" method="post" modelAttribut="Product">
                <div class="card-body">
                  <div class="form-group">
                    <label for="exampleInputEmail1">Sub Category</label>
                    <input type="text" readonly value="${product_type}" name="subCategory" class="form-control" id="exampleInputEmail1" placeholder="">
                  </div>
                  <div class="form-group">
                    <label for="exampleInputEmail1">Product Title</label>
                    <input type="text" name="productTitle" class="form-control" id="exampleInputEmail1" placeholder="">
                  </div>
                  <div class="form-group">
                    <label for="exampleInputPassword1">MRP</label>
                    <input type="number" name="mrp" class="form-control" id="exampleInputPassword1" placeholder="">
                  </div>
                  <div class="form-group">
                    <label for="exampleInputPassword1">Price</label>
                    <input type="number" name="price" class="form-control" id="exampleInputPassword1" placeholder="">
                  </div>
                  <div class="form-group">
                    <label for="exampleInputPassword1">Sizes</label>
                    <div class="form-group">
                        <select multiple class="form-control" name="screenSize">
                          <option value="24">24</option>
                          <option value="32">32</option>
                          <option value="40">40</option>
                          <option value="42">42</option>
                          <option value="50">50</option>
                        </select>
                      </div>    
                </div>
                  <div class="form-group">
                    <label for="exampleInputPassword1">Brand</label>
                    <input type="text" name="brand" class="form-control" id="exampleInputPassword1" placeholder="">
                  </div>
                  <div class="form-group">
                    <label for="exampleInputPassword1">Model Name</label>
                    <input type="text" name="modelName" class="form-control" id="exampleInputPassword1" placeholder="">
                  </div>
                  <div class="form-group">
                    <label for="exampleInputPassword1">Supported Internet Services</label>
                    <input type="text" name="supportedInternetServices" class="form-control" id="exampleInputPassword1" placeholder="">
                  </div>
                  <div class="form-group">
                    <label for="exampleInputPassword1">Display Technology</label>
                    <input type="text" name="displayTechnology" class="form-control" id="exampleInputPassword1" placeholder="">
                  </div>
                  <div class="form-group">
                    <label for="exampleInputPassword1">Product Dimensions</label>
                    <input type="text" name="productDimensions" class="form-control" id="exampleInputPassword1" placeholder="">
                  </div>
                  <div class="form-group">
                    <label for="exampleInputPassword1">Resolution</label>
                    <input type="text" name="resolution" class="form-control" id="exampleInputPassword1" placeholder="">
                  </div>
                  <div class="form-group">
                    <label for="exampleInputPassword1">Refresh Rate</label>
                    <input type="text" name="refreshRate" class="form-control" id="exampleInputPassword1" placeholder="">
                  </div>
                  <div class="form-group">
                    <label for="exampleInputPassword1">Special Feature</label>
                    <input type="text" name="specialFeature" class="form-control" id="exampleInputPassword1" placeholder="">
                  </div>
                  <div class="form-group">
                    <label for="exampleInputPassword1">Included Components</label>
                    <input type="text" name="includedComponents" class="form-control" id="exampleInputPassword1" placeholder="">
                  </div>
                  <div class="form-group">
                    <label for="exampleInputPassword1">Stock Quantity</label>
                    <input type="number" name="stockQuantity" class="form-control" id="exampleInputPassword1" placeholder="">
                  </div>
                  <div class="form-group">
                    <label for="exampleInputPassword1">Short Description</label>
                    
                        <textarea name="shortDescription"></textarea>
                       
                </div>
                  <div class="form-group">
                    <label for="exampleInputPassword1">Product Description</label>
                    <div class="card-body">
                        <textarea id="summernote" name="productDescription"> 
                          Place <em>some</em> <u>text</u> <strong>here</strong>
                        </textarea>
                      </div>    
                </div>
                </div>
                <!-- /.card-body -->
                <div class="card-footer">
                  <button type="submit" class="btn btn-primary">Add Product</button>
                </div>
              </form>
            </div>
            <!-- /.card -->
            </div>
          <!--/.col (left) -->
          <!-- right column -->
          <div class="col-md-6">

          </div>
          <!--/.col (right) -->
        </div>
        <!-- /.row -->
      </div><!-- /.container-fluid -->
    </section>
    <!-- /.content -->
  </c:if>

  <c:if test = "${product_type == 'Shoes'}">
    <section class="content">
      <div class="container-fluid">
        <div class="row">
          <!-- left column -->
          <div class="col-md-12">
            <!-- jquery validation -->
            <div class="card card-primary">
              <!-- form start -->
              <form action="/addProduct" method="post" modelAttribut="Product">
                <div class="card-body">
                  <div class="form-group">
                    <label for="exampleInputEmail1">Sub Category</label>
                    <input type="text" readonly value="${product_type}" name="subCategory" class="form-control" id="exampleInputEmail1" placeholder="">
                  </div>
                  <div class="form-group">
                    <label for="exampleInputEmail1">Product Title</label>
                    <input type="text" name="productTitle" class="form-control" id="exampleInputEmail1" placeholder="">
                  </div>
                  <div class="form-group">
                    <label for="exampleInputPassword1">MRP</label>
                    <input type="number" name="mrp" class="form-control" id="exampleInputPassword1" placeholder="">
                  </div>
                  <div class="form-group">
                    <label for="exampleInputPassword1">Price</label>
                    <input type="number" name="price" class="form-control" id="exampleInputPassword1" placeholder="">
                  </div>
                  <div class="form-group">
                    <label for="exampleInputPassword1">Colors</label>
                    <div class="form-group">
                        <select multiple class="form-control" name="colors">
                          <option>Blue</option>
                          <option>Black</option>
                          <option>Gray</option>
                          <option>Red</option>
                          <option>Pink</option>
                        </select>
                      </div>    
                </div>
                <div class="form-group">
                  <label for="exampleInputPassword1">Sizes</label>
                  <div class="form-group">
                      <select multiple class="form-control" name="sizes">
                        <option>6</option>
                        <option>7</option>
                        <option>8</option>
                        <option>9</option>
                        <option>10</option>
                      </select>
                    </div>    
              </div>
                  <div class="form-group">
                    <label for="exampleInputPassword1">Brand</label>
                    <input type="text" name="brand" class="form-control" id="exampleInputPassword1" placeholder="">
                  </div>
                  <div class="form-group">
                    <label for="exampleInputPassword1">Model Name</label>
                    <input type="text" name="modelName" class="form-control" id="exampleInputPassword1" placeholder="">
                  </div>
                  <div class="form-group">
                    <label for="exampleInputPassword1">Stock Quantity</label>
                    <input type="number" name="stockQuantity" class="form-control" id="exampleInputPassword1" placeholder="">
                  </div>
                  <div class="form-group">
                    <label for="exampleInputPassword1">Short Description</label>
                    
                        <textarea name="shortDescription"></textarea>
                       
                </div>
                  <div class="form-group">
                    <label for="exampleInputPassword1">Product Description</label>
                    <div class="card-body">
                        <textarea id="summernote" name="productDescription"> 
                          Place <em>some</em> <u>text</u> <strong>here</strong>
                        </textarea>
                      </div>    
                </div>
                </div>
                <!-- /.card-body -->
                <div class="card-footer">
                  <button type="submit" class="btn btn-primary">Add Product</button>
                </div>
              </form>
            </div>
            <!-- /.card -->
            </div>
          <!--/.col (left) -->
          <!-- right column -->
          <div class="col-md-6">

          </div>
          <!--/.col (right) -->
        </div>
        <!-- /.row -->
      </div><!-- /.container-fluid -->
    </section>
    <!-- /.content -->
  </c:if>
  
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


