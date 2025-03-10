const file_delete = document.getElementsByClassName("file_delete");

for (let a of file_delete){
    a.addEventListener('click', ()=>{
        console.log("delete");
    })
}