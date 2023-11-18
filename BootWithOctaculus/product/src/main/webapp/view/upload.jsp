<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <form action="/Upload" method="post" enctype="multipart/form-data">
        <table>
            <tr>
                <td>Product Title</td>
                <td>
                    <input type="text" name="productTitle">
                </td>
            </tr>
            <tr>
                <td>Short Description</td>
                <td>
                    <textarea name="shortDescription"></textarea>
                </td>
            </tr>
            <tr>
                <td>Price</td>
                <td>
                    <input type="text" name="price">
                </td>
            </tr>
            <tr>
                <td>Upload file</td>
                <td>
                    <input type="file" name="productImage">
                </td>
            </tr>
            <tr>
                <td>
                    <input type="submit" value="Upload">
                </td>
            </tr>
        </table>
    </form>
</body>
</html>