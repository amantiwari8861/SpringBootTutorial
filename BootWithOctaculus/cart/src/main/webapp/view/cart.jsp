<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <table border="1">
        <tr>
            <td>Title</td>
            <td>Price</td>
            <td>Quantity</td>
            <td>Total Amount</td>
        </tr>
        <c:forEach items="${cart}" var="product">
            <tr>
                <td>${product.getTitle()}</td>
                <td>${product.getPrice()}</td>
                <td>${product.getQuantity()}</td>
                <td>${product.getPrice()*product.getQuantity()}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>