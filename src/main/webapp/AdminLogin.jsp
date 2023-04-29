<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <link rel="stylesheet" type="text/css" href="adminlogin.css">
</head>
<body>
    <!-- Header Section -->
    <h1 style="color:red">Learner's Academy</h1>
    <h4>Developer Name: Surya prakash </h4> 
    <h4>Developer Email: Suryaprakashyadav424@gmail.com</h4>
    <h4>SimpliLearn Full Stack Development Course Phase 2<h4>

    <!-- Login Section -->
    <h2 style="text-align:center; color:green">Welcome To Your ADMIN Login Page!</h2>
    <br>
    <br>
    <div style="text-align:center;">
        <form action="login" method="post">
            <table border="1" style="text-align:center; margin-left:auto; margin-right:auto;"> 
                <tr>
                    <td>
                        <br>
                        &nbsp;&nbsp;Enter Your Username: <input type="text" name="username" placeholder="username" required>
                        &nbsp;&nbsp;<br>
                        <br>
                        &nbsp;&nbsp;Enter Your Password: <input type="password" name="password" placeholder="password" required>
                        &nbsp;&nbsp;<br>
                        <br>
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="submit" value="Login">
                    </td>
                </tr>
            </table>
        </form>
    </div>
    <br>
    <br>
    <br>
    <br>
</body>
</html>
