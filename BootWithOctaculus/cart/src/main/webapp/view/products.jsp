<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <h3>Cart (${count}) <a href="/cart">Go to Cart</a></h3>
    <c:forEach items = "${products}" var = "product">
        <form action="/addToCart" method="post" class="cartid">
         <img src="../../images/product.png" height="50" width="50"><br>
         Product ID <input type="text" name="id" value="${product.getId()}" readonly><br>
         Product Title <input type="text" name="title" value="${product.getTitle()}" readonly><br>
         Product Price<input type="text" name="price" value="${product.getPrice()}" readonly><br>
         Product Description <input type="text" name="description" value="${product.getDescription()}" readonly><br>
         Product Quantity <input type="number" name="quantity" value="1"><br>
         <input type="submit" value="Add to Cart">
         <br><br>
        </form>
      </c:forEach>
      <script>
        let cartarr=document.querySelectorAll(".cartid");
        cartarr.forEach((p)=>{
            p.addEventListener("submit",(e)=>{
                e.preventDefault();
                alert("added product!!");
            })
        })
      </script>
</body>
</html>