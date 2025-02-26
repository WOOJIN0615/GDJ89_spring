const productname = document.getElementById("productname");
const productrate = document.getElementById("productrate");
const productdate = document.getElementById("productdate");
const add_button = document.getElementById("add_button");

const value = document.querySelector("#volume-output");
const input = document.querySelector("#volume");
value.textContent = input.value;
input.addEventListener("input", (event) => {
value.textContent = event.target.value;
});

add_button.addEventListener("click", function(){
    if (productname.value==""){
        alert("상품명은 필수입니다.");
        proname.focus();
        return;
    }
    
    if (productdate.value==""){
        alert("기간은 필수입니다.");
        productdate.focus();
        return;
    }

    if (productrate.value.length==0){
        alert("이자율은 필수입니다.");
        productrate.focus();
        return;
    }

    document.getElementById("add_form").onsubmit();
})