<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <form action="/addProduct" method="post" modelAttribute="Product">
        <table>
            <tr>
                <td>Product Title</td>
                <td>
                    <input type="text" name="title">
                </td>
            </tr>
            <tr>
                <td>Price</td>
                <td>
                    <input type="text" name="price">
                </td>
            </tr>
            <tr>
                <td>Product Description</td>
                <td>
                    <input type="text" name="description">
                </td>
            </tr>
            <tr>
                <td>
                    <input type="submit" value="Add Product">
                </td>
            </tr>
        </table>
    </form>
</body>
</html>