// .confirm-link라는 클래스를 가진 a 태그를 누르면 확인창 출력 후 이동
window.addEventListener("load", function(){

    // 모듈을 만들 때는 갯수를 알 수 없다고 생각하고 구현한다
    var linkList = document.querySelectorAll(".confirm-link");

    if(linkList.length == 0) {return;}

    for(var i = 0 ; i < linkList.length ; i ++) {
        linkList[i].addEventListener("click", function(e){
            var choice = window.confirm("정말 이동하시겠습니까?");
            if(choice == false) {
                // return false; 로 기본 이벤트 차단 불가능
                e.preventDefault(); // 기본 이벤트 차단 명령
            }
        })
    }
});