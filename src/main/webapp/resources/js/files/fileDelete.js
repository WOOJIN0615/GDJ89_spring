export default function fileDelete(){
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
                url='./fileDelete';
                fetch(url, {
                    method:'POST',
                    headers : {
                        "Content-type": "application/x-www-form-urlencoded;charset=utf-8"
                    },
                    body : 'fileNum='+num
                })
                .then(a => a.text())
                .then(a => {
                    if(a.trim()*1>0){
                        //1. 파일갯수 count 수 수정
                        count--;
                        //2. Element 삭제
                        a.parentElement.remove();
                    }else {
                        alert('파일 삭제 실패');
                    }
                })  
                .catch(e => {
                    alert('파일 삭제 오류');
                })  
                .finally();
            }
        })
    }
}