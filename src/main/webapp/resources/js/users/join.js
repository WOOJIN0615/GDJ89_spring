const username = document.getElementById("username");
const usernameResult = document.getElementById("usernameResult");

username.addEventListener('change', ()=>{
    console.log(username.value)
    fetch("check?username="+username.value)
    .then(res => {
        res.text()
        .then(res => {
            if(res.trim()=='0'){
                //가입 불가
                usernameResult.innerHTML='중복된 ID 입니다'
            }else {
                //가입 가능
                usernameResult.innerHTML='사용 가능한 ID입니다.'
            }
        })
    })
});