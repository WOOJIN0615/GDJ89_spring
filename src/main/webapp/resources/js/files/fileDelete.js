const file_delete = document.getElementsByClassName("file_delete");

for (let a of file_delete){
    a.addEventListener('click', ()=>{
        let check=confirm("정말 삭제하시겠습니까? 복구가 불가능합니다");
        if (check){
            let num = a.getAttribute("data-file-num")
            let kind = a.getAttribute("data-kind");

            //동기식, 비동기식
            //'post'
            let url=`/${kind}/fileDelete`;
            fetch(url, {
                method:'POST',
                headers : {
                    "Content-type": "application/x-www-form-urlencoded;charset=utf-8"
                },
                body : 'fileNum='+num
            })    
        }
    })
}