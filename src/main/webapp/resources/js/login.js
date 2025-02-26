/**
 * 
 */

const username = document.getElementById("username");
const password = document.getElementById("password");
const login_button = document.getElementById("login_button");

login_button.addEventListener("click", function(){
    if(username.value.length == 0){
        alert("ID는 필수 입니다.");
        username.focus();

        return;
    }
    if (password.value==""){
        alert("PW는 필수 입니다.");
        password.focus();

        return;
    }

    document.getElementById("login_form").onsubmit();


})