<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <!DOCTYPE html>
    <html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>OAuth2 Login</title>
        <link rel="stylesheet" href="css/SignInForm.css">
    </head>

    <body>

<!-- <img src="../images/AmazonLogoDark.png" alt="AmazonLogo"/><small>in</small>
    <img src="../../images/AmazonLogoDark.png" alt="AmazonLogo"/><small>in</small>
    <img src="<c:url value='/images/AmazonLogoDark.png'/>" alt="AmazonLogo"/><small>in</small> -->
        <div class="logo-container">
            <img src="/images/AmazonLogoDark.png" alt="AmazonLogo" id="logo" /><span id="domain">in</span>
        </div>
        <div id="form-container">
            <form action="/login" method="post" id="signin-form">
                <h2>Sign in</h2>
                <label for="username">Enter mobile phone number or email</label>
                <input type="text" name="username" id="username" placeholder="enter phone or email">
                <label for="password">Enter password</label>
                <input type="password" name="password" id="password" placeholder="enter password">
                <input type="submit" value="Sign in" id="sign-in">
                <br>
                <hr>
                <br>
                <a href="/oauth2/authorization/google">
                    <div class="google">Sign in with Google</div>
                </a>
                <a href="/oauth2/authorization/facebook">
                    <div class="facebook">Sign in with Facebook</div>
                </a>
                <a href="/oauth2/authorization/github">
                    <div class="github">Sign in with Github</div>
                </a>
            </form>
        </div>

    </body>
    <!-- <script src="js/script.js" type="text/javascript"></script> -->

    </html>