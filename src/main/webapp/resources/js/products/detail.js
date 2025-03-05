//수정 버튼을 클릭했을때 console에 출력
//form method의 값을 콘솔에 출력
//삭제 버튼을 클릭했을때 console에 출력
//form action의 주소값을 콘솔에 출력
const up = document.getElementById("up");
const del = document.getElementById("del");
const frm = document.getElementById("frm");
const rep = document.getElementById("rep");
const addCart = document.getElementById("addCart");
const productNum = document.getElementById("productNum");



up.addEventListener("click", function(){
    console.log("수정");
    console.log(frm.method);
    console.log(frm.getAttribute("method"));
    frm.action="./update";
    frm.submit();
})

del.addEventListener("click", function(){
    console.log("삭제");
    console.log(frm.action);
    let check = confirm("정말 삭제하시겠습니까?");  
    frm.action="./delete";
    frm.method="POST";
    frm.submit();
})

// rep.addEventListener("click", function(){
//     console.log(frm.getAttribute("method"));
//     frm.action="./reply";
//     frm.submit();
// })

addCart.addEventListener("click", ()=>{
    console.log(productNum.value);
    fetch('../users/addCart?productNum='+productNum.value)
    .then(res=>res.text())
    .then(res=>{
        
    })
})