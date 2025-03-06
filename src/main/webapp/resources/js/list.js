const pages = document.getElementsByClassName("pages");
const list_form = document.getElementById("list_form");
const pageNum = document.getElementById("pageNum");
const cbox = document.getElementById("cbox");
const checks = document.getElementsByClassName("checks");
const cart_del = document.getElementById("cart_del");

for(let p of pages){
    p.addEventListener("click", function() {

        console.log(p.getAttribute("data-page-num"));
        pageNum.value=p.getAttribute("data-page-num");
        list_form.submit();
    })
}

cbox.addEventListener('click', ()=>{
    
        for (let check of checks){
            check.checked=cbox.checked;
        }
})

for(let check of checks){
    check.addEventListener('click', ()=>{
        let r = true;
        for(let c of checks){
            if (!c.checked){
                r=false;
            }
        }
        cbox.checked=r;
    })
}

cart_del.addEventListener('click', ()=>{
    for (let a of checks){
        if (a.checked){
            console.log(a.getAttribute("data-product-num"));
        }
    }
})