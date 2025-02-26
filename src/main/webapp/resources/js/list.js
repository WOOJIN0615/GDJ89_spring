const pages = document.getElementsByClassName("pages");
const list_form = document.getElementById("list_form");
const pageNum = document.getElementById("pageNum");

for(let p of pages){
    p.addEventListener("click", function() {

        console.log(p.getAttribute("data-page-num"));
        pageNum.value=p.getAttribute("data-page-num");
        list_form.submit();
    })
}

