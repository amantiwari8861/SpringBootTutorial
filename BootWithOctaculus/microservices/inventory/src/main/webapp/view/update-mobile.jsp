
<!DOCTYPE html>
<html lang="en">
<head>
  <title>AdminLTE 3 | Validation Form</title>
  <jsp:include page="header.jsp" />
</head>
<body class="hold-transition sidebar-mini">
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
            <h1>Add product</h1>
          </div>
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="#">Mobile</a></li>
              <li class="breadcrumb-item active">Add Mobile</li>
            </ol>
          </div>
        </div>
      </div><!-- /.container-fluid -->
    </section>

    <!-- Main content -->
    <section class="content">
      <div class="container-fluid">
        <div class="row">
          <!-- left column -->
          <div class="col-md-12">
            <!-- jquery validation -->
            <div class="card card-primary">
              <!-- form start -->
              <form action="/updateMobile" method="post" modelAttribut="Mobile">
                <div class="card-body">
                  <div class="form-group">
                    <label for="exampleInputEmail1">Product ID</label>
                    <input type="text" readonly name="id" value="${mobile.getId()}" class="form-control" id="exampleInputEmail1" placeholder="">
                  </div>
                  <div class="form-group">
                    <label for="exampleInputEmail1">Product Title</label>
                    <input type="text" name="productTitle" value="${mobile.getProductTitle()}" class="form-control" id="exampleInputEmail1" placeholder="">
                  </div>
                  <div class="form-group">
                    <label for="exampleInputPassword1">MRP</label>
                    <input type="number" name="mrp" value="${mobile.getMrp()}" class="form-control" id="exampleInputPassword1" placeholder="">
                  </div>
                  <div class="form-group">
                    <label for="exampleInputPassword1">Price</label>
                    <input type="number" name="price" value="${mobile.getPrice()}" class="form-control" id="exampleInputPassword1" placeholder="">
                  </div>
                  <div class="form-group">
                    <label for="exampleInputPassword1">Colors</label>
                    <div class="form-group">
                        <select multiple class="form-control" name="colors">
                          <option  selected value="${mobile.getColors()}">${mobile.getColors()}</option>
                          <option value="Blue">Blue</option>
                          <option value="Black">Black</option>
                          <option value="Gray">Gray</option>
                          <option value="Red">Red</option>
                          <option value="Pink">Pink</option>
                        </select>
                      </div>    
                </div>
                  <div class="form-group">
                    <label for="exampleInputPassword1">Brand</label>
                    <input type="text" name="brand" value="${mobile.getBrand()}" class="form-control" id="exampleInputPassword1" placeholder="">
                  </div>
                  <div class="form-group">
                    <label for="exampleInputPassword1">Model Name</label>
                    <input type="text" name="modelName" value="${mobile.getModelName()}" class="form-control" id="exampleInputPassword1" placeholder="">
                  </div>
                  <div class="form-group">
                    <label for="exampleInputPassword1">Wireless Carrier</label>
                    <input type="text" name="wirelessCarrier" value="${mobile.getWirelessCarrier()}" class="form-control" id="exampleInputPassword1" placeholder="">
                  </div>
                  <div class="form-group">
                    <label for="exampleInputPassword1">Operating System</label>
                    <select class="form-control" name="operatingSystem">
                      <option selected value="${mobile.getOperatingSystem()}">${mobile.getOperatingSystem()}</option>
                      <option value="Android 14">Android 14</option>
                      <option value="Android 13">Android 13</option>
                      <option value="Android 12">Android 12</option>
                      <option value="Android 11">Android 11</option>
                      <option value="iOS 17">iOS 17</option>
                      <option value="iOS 16">iOS 16</option>
                      <option value="iOS 15">iOS 15</option>
                      <option value="iOS 14">iOS 14</option>
                    </select>    
                </div>
                  <div class="form-group">
                    <label for="exampleInputPassword1">Cellular Technology</label>
                    <select class="form-control" name="cellularTechnology">
                      <option selected value="${mobile.getCellularTechnology()}">${mobile.getCellularTechnology()}</option>
                      <option value="4G">4G</option>
                      <option value="5G">5G</option>
                    </select> </div>
                  <div class="form-group">
                    <label for="exampleInputPassword1">Memory Storage Capacity (RAM)</label>
                    <input type="text" name="memoryStorageCapacity" value="${mobile.getMemoryStorageCapacity()}" class="form-control" id="exampleInputPassword1" placeholder="">
                  </div>
                  <div class="form-group">
                    <label for="exampleInputPassword1">Internal Memory</label>
                    <input type="text" name="internalMemory" value="${mobile.getInternalMemory()}" class="form-control" id="exampleInputPassword1" placeholder="">
                  </div>
                  <div class="form-group">
                    <label for="exampleInputPassword1">Front Camera (in Mega Pixel)</label>
                    <input type="text" name="frontCamera" value="${mobile.getFrontCamera()}" class="form-control" id="exampleInputPassword1" placeholder="">
                  </div>
                  <div class="form-group">
                    <label for="exampleInputPassword1">Rear Camera (in Mega Pixel)</label>
                    <input type="text" name="rearCamera" value="${mobile.getRearCamera()}" class="form-control" id="exampleInputPassword1" placeholder="">
                  </div>
                  <div class="form-group">
                    <label for="exampleInputPassword1">Battery Capacity</label>
                    <input type="text" name="batteryCapacity" value="${mobile.getBatteryCapacity()}" class="form-control" placeholder="">
                  </div>
                  <div class="form-group">
                    <label for="exampleInputPassword1">Connectivity Technology</label>
                    <div class="form-group">
                      <select multiple class="form-control" name="connectivityTechnology">
                        <option selected value="${mobile.getConnectivityTechnology()}">${mobile.getConnectivityTechnology()}</option>
                        <option value="Bluetooth">Bluetooth</option>
                        <option value="Wi-Fi">Wi-Fi</option>
                        <option value="USB">USB</option>
                      </select>
                    </div>
                  </div>
                  <div class="form-group">
                    <label for="exampleInputPassword1">Screen Size</label>
                    <input type="text" name="screenSize" value="${mobile.getScreenSize()}" class="form-control" id="exampleInputPassword1" placeholder="">
                  </div>
                  <div class="form-group">
                    <label for="exampleInputPassword1">Wireless Network Technology</label>
                    <div class="form-group">
                      <select multiple class="form-control" name="wirelessNetworkTechnology">
                        <option selected value="${mobile.getWirelessNetworkTechnology()}">${mobile.getWirelessNetworkTechnology()}</option>
                        <option value="GSM">GSM</option>
                        <option value="Wi-Fi">Wi-Fi</option>
                        <option value="CDMA">CDMA</option>
                        <option value="LTE">LTE</option>
                      </select>
                    </div>
                  </div>
                  <div class="form-group">
                    <label for="exampleInputPassword1">Stock Quantity</label>
                    <input type="number" name="stockQuantity" value="${mobile.getStockQuantity()}" class="form-control" id="exampleInputPassword1" placeholder="">
                  </div>
                  <div class="form-group">
                    <label for="exampleInputPassword1">Short Description</label><br>
                    <textarea name="shortDescription">${mobile.getShortDescription()}</textarea>
                </div>
                  <div class="form-group">
                    <label for="exampleInputPassword1">Product Description</label>
                    <div class="card-body">
                        <textarea id="summernote" name="productDescription"> 
                          ${mobile.getProductDescription()}
                        </textarea>
                      </div>    
                </div>
                </div>
                <div class="form-group">
                  <label for="exampleInputPassword1">Record created on</label>
                  <input type="text" readonly name="recordCreated" value="${mobile.getRecordCreated()}" class="form-control" id="exampleInputPassword1" placeholder="">
                </div>
                <div class="form-group">
                  <label for="exampleInputPassword1">Record created by [Seller ID]</label>
                  <input type="text" readonly name="sellerId" value="${mobile.getSellerId()}" class="form-control" id="exampleInputPassword1" placeholder="">
                </div>
                <!-- /.card-body -->
                <div class="card-footer">
                  <button type="submit" class="btn btn-primary">Update Product</button>
                </div>
              </form>
            </div>
            <!-- /.card -->
            </div>
          <!--/.col (left) -->
        </div>
        <!-- /.row -->
      </div><!-- /.container-fluid -->
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


