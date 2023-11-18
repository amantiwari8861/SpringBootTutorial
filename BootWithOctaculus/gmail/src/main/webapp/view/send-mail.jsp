<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <form action="/sendMail" method="post">
        <table>
            <tr>
                <td>TO</td>
                <td>
                    <input type="email" name="to" required>
                </td>
            </tr>
            <tr>
                <td>Subject</td>
                <td>
                    <input type="text" name="subject" required>
                </td>
            </tr>
            <tr>
                <td>
                    <input type="submit" value="Send mail">
                </td>
            </tr>
        </table>
    </form>
</body>
</html>