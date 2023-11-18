<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <!DOCTYPE html>
    <html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>OAuth2 Register</title>
        <link rel="stylesheet" href="css/SignInForm.css">
    </head>

    <body>
        <!-- <fieldset>
        <legend>OAuth2 Login</legend>
        <form action="/login" method="post">
            UserName : <input type="text" name="username"><br>
            Password : <input type="text" name="password" id=""><br>
            <input type="submit" value="Login!!">
            <a href="/oauth2/authorization/google">Login with Google</a><br>
            <a href="/oauth2/authorization/github">Login with GitHub</a><br>
            <a href="/oauth2/authorization/facebook">Login with Facebook</a>
        </form>
    </fieldset> -->
        <!-- <img src="../images/AmazonLogoDark.png" alt="AmazonLogo"/><small>in</small>
    <img src="../../images/AmazonLogoDark.png" alt="AmazonLogo"/><small>in</small>
    <img src="<c:url value='/images/AmazonLogoDark.png'/>" alt="AmazonLogo"/><small>in</small> -->
        <div class="logo-container">
            <img src="/images/AmazonLogoDark.png" alt="AmazonLogo" id="logo" /><span id="domain">in</span>
        </div>
        <div id="form-container">
            <form action="/registerUser" method="post" id="signin-form">
                <h2>Register</h2>
                <span id="msg">${msg}</span>
                <label for="username">Enter mobile phone number or email</label>
                <input type="text" name="username" id="username" placeholder="enter phone or email">
                <label for="password">Enter password</label>
                <input type="password" name="password" id="password" placeholder="enter password">
                <label for="role">Choose Role</label>
                <select name="role" id="role" multiple>
                <option value="ROLE_USER">User</option>
                <option value="ROLE_ADMIN">Admin</option>
                <option value="ROLE_MANAGER">Manager</option>
                </select> <br>
                <input type="submit" value="Register" id="sign-in">
                <br>
                <hr>
                <br>
                <a href="/oauth2/authorization/google">
                    <div class="google">Sign Up with Google</div>
                </a>
                <a href="/oauth2/authorization/facebook">
                    <div class="facebook">Sign Up with Facebook</div>
                </a>
                <a href="/oauth2/authorization/github">
                    <div class="github">Sign Up with Github</div>
                </a>
            </form>
        </div>





    </body>
    <!-- <script src="js/script.js" type="text/javascript"></script> -->

    </html>