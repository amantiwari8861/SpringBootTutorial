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
            <td>User ID</td>
            <td>Full Name</td>
            <td>Email ID</td>
            <td>Mobile Number</td>
            <td>Password</td>
            <td>Record Created</td>
        </tr>
        <tr>
            <td>${user.getId()}</td>
            <td>${user.getFname()} ${user.getLname()}</td>
            <td>${user.getEmail()}</td>
            <td>${user.getPassword()}</td>
            <td>${user.getMobile()}</td>
            <td>${user.getRecordCreated()}</td>
        </tr>
    </table>
</body>
</html>