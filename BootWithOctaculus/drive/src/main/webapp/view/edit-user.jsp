<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <form action="/register-user" method="post" modelAttribute="User">
        <table>
            <tr>
                <td>User ID</td>
                <td>
                    <input type="text" name="id" value="${user.getId()}" readonly>
                </td>
            </tr>
            <tr>
                <td>First Name</td>
                <td>
                    <input type="text" name="fname" value="${user.getFname()}">
                </td>
            </tr>
            <tr>
                <td>Last Name</td>
                <td>
                    <input type="text" name="lname" value="${user.getLname()}">
                </td>
            </tr>
            <tr>
                <td>Email</td>
                <td>
                    <input type="email" name="email" value="${user.getEmail()}">
                </td>
            </tr>
            <tr>
                <td>Password</td>
                <td>
                    <input type="password" name="password" value="${user.getPassword()}">
                </td>
            </tr>
            <tr>
                <td>Mobile</td>
                <td>
                    <input type="text" name="mobile" value="${user.getMobile()}">
                </td>
            </tr>
            <tr>
                <td>
                    <input type="text" name="recordCreated" value="${user.getRecordCreated()}" hidden>
                </td>
            </tr>
            <tr>
                <td>
                    <input type="submit" value="Update User">
                </td>
            </tr>
        </table>
    </form>
</body>
</html>