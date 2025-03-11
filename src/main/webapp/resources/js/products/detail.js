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
const addComments = document.getElementById("addComments");
const commentContents = document.getElementById("commentContents");
const commentsListResult = document.getElementById("commentsListResult");
const pages = document.getElementById("pages");



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

addComments.addEventListener("click", async ()=>{
    console.log(commentContents.value);
    console.log(addCart.getAttribute("data-product-num"));
    
    await add();
    await getList(1);

   

})

function makeForm(pn, contents){
    let f = new FormData();
    f.append("productNum", pn);
    f.append("boardContents", contents)

    return f;
}

function makeParam(pn, contents){

    let p = new URLSearchParams();
    p.append("productNum", pn);
    p.append("boardContents", contents)

    return p;
}

getList(1)

async function getList(page){
    let pn = addCart.getAttribute("data-product-num");
    fetch(`listComments?productNum=${pn}&page=${page}`)
    .then(r => r.text())
    .then(r => {
        commentsListResult.innerHTML=r;
    })
    .catch(e=> console.log(e))
    
}

async function add(){
    let pn = addCart.getAttribute("data-product-num");

    //let p = makeParam(pn, commentsContents.value);
    let p = makeForm(pn, commentContents.value)

   

    fetch('./addComments', {
        method:'POST',
        // headers: {
        //     "Content-type":"application/x-www-form-urlencoded; charset=UTF-8"
        // },
        //body: `productNum=${pn}&boardContents=${commentsContents.value}`
        body:p
    })
    .then(r=>r.text())
    .then(r=>{
        //getList()
        if(r.trim()*1>0){

        }else {

        }

        commentContents.value="";

    })
    .catch(e =>{
        alert('에러 발생')
    })
}

commentsListResult.addEventListener('click', (e)=>{
    if(e.target.classList.contains('pages')){
        let p = e.target.getAttribute("data-page-num");
        getList(p)
    }
})