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
const addComment = document.getElementById("addComment");
const comment = document.getElementById("comment");



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
        if (res.trim()=="1"){
            let r=confirm("장바구니로 이동하시겠습니까?");
            if (r){
                alert('장바구니로 이동')
            }
        }else {
            alert('상품이 장바구니에 담기지 않았습니다');
        }
    }).catch(r=>{
        alert('상품이 장바구니에 담기지 않았습니다');
    })
})

addComment.addEventListener("click", ()=>{
    console.log(productNum.value);
    console.log(comment.value);
    let p = makeForm(pn, commentContents.value)

    fetch('./detail', {
        method:"POST",
        // headers:{
        //     'Content-type': 'application/x-www-form-urlencoded; charset=UTF-8'
        // },
        body:p
    })


})

function makeForm(pn, contents){
    let f = new FormData();
    f.append("productNum", pn);
    f.append("boardContents", contents);

    return f;
}

function makeParam(){
    let p = new URLSearchParams(pn, a);
    p.append("productNum", pn);
    p.append("boardContents", a);
}

getList();

function getList() {
    fetch('getCommentList?productNum='+productNum.value);
}