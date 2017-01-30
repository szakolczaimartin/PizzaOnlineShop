<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head><title>Sign Up</title>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>


</head>
<body>
<jsp:include page="_menu.jsp" />


<form action="/signUpIn" method='POST'>
    <table>
        <tr>
            <td>User:</td>
            <td><input type='text' name='name' value=''></td>
        </tr>
        <tr>
            <td>User name:</td>
            <td><input type='text' name='username' value=''></td>
        </tr>
        <tr>
            <td>Email:</td>
            <td><input type='email' name='email' value=''></td>
        </tr>
        <tr>
            <td>Phone number:</td>
            <td><input type='text' name='phoneNumber' value=''></td>
        </tr>
        <tr>
            <td>Address:</td>
            <td><input type='text' name='address' value=''></td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><input type='password' name='password' /></td>
        </tr>
        <tr>
            <td><input name="submit" type="submit" value="submit" />

        </tr>
    </table>
</form>



</body>
</html>
