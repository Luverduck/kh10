/*
    ** class 이름에 대한 제약 조건
    전체 체크박스는 class = "check-all"
    개별 체크박스는 class = "check-item"
    으로 만들어야 작동된다
*/

// checkbox에 대한 모듈
window.addEventListener("load", function(){
    // [1] 전체선택을 체크하면 개별항목을 변경
    var checkAllItems = document.querySelectorAll(".check-all");
    if(checkAllItems.length > 0) {
        for(var i = 0 ; i < checkAllItems.length ; i ++) {

            // // 이벤트 발생시 동작할 함수(checkAllProcess)
            // checkAllItems[i].addEventListener("input", checkAllProcess);
            // checkAllProcess();

            checkAllItems[i].addEventListener("input", function(){
                // 여기서의 this는 체크된(이벤트가 발생한) 전체선택 체크박스 (= e.target)
                
                var checkItems = document.querySelectorAll(".check-item");
                for(var j = 0 ; j < checkItems.length ; j ++) {
                    checkItems[j].checked = this.checked;
                }

                var checkAllItems = document.querySelectorAll(".check-all");
                for(var j = 0 ; j < checkAllItems.length ; j ++) {
                    checkAllItems[j].checked = this.checked;
                }

            })
        }
    }

    // [2] 개별항목을 체크하면 전체선택을 변경
    var checkItems = document.querySelectorAll(".check-item");
    for(var i = 0 ; i < checkItems.length ; i ++) {
        checkItems[i].addEventListener("input", function(e) {
            // 여기서의 this는 체크된(이벤트가 발생한) 전체선택 체크박스 (= e.target)
            var countAll = document.querySelectorAll(".check-item").length;
            var countCheck = document.querySelectorAll(".check-item:checked").length;

            var allCheck = countAll == countCheck;
            
            var checkAllItems = document.querySelectorAll(".check-all");
            for(var k = 0 ; k < checkAllItems.length ; k ++) {
                checkAllItems[k].checked = allCheck;
            }
        })
    }
});