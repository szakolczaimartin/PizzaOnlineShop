



function validateRegistry() {
    var password = document.getElementById("password").value;
    var confirmPass = document.getElementById("confPass").value;

    if (password != confirmPass) {
        alert("The password is not correct");
        return false;
    }
    // else if (email == "" || reEmail.test(email) == false) {
    //     alert("Tha email is empty or not valid");
    //     return false;
    // }
    // else if (message == "") {
    //     alert("Tha message is empty");
    //     return false;
    // }

    return true;
}