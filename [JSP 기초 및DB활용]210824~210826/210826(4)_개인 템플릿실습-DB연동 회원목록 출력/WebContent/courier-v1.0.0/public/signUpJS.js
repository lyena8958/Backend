
//회원가입 유효성검사
window.onload = function() {
      var join = document.join; //form데이터를 모두 join변수에 저장
      //var errorIndex;
      
      var input = document.querySelectorAll('.check');

         
      //submit 실행시 수행할 동작
      join.onsubmit = function() { //join에서 submit이 실행된다면 수행할 함수
         var flag = false;//input값 여부를 확인할 버튼식 boolean            
  
         
         var idLimit = /^[a-zA-Z0-9-_]{5,20}$/; //정규식(a~z, A~Z, 0~9, -, _만 입력가능)
         var pwLimit = /^[a-zA-Z0-9~!@#$%^&*()_-]{10,20}$/;///[a-zA-Z0-9]{10, 20}/; //정규식(a~z, A~Z, 0~9,~!@#$%^&*()_-특수문자 만 입력가능)
         
         if (!idLimit.test(input[1].value)) {
            alert(" 5~20자의 영문 소대문자, 숫자와 특수기호(_),(-)만 사용 가능합니다.");
            history.go(-1);
            return false;
         }
         if (!pwLimit.test(input[2].value)) {
        	alert(" 10~20자의 영문 소대문자, 숫자와 특수기호 '~!@#$%^&*()_-'만 사용 가능합니다.");
        	history.go(-1);
            //console.log(input[1].value);
            //console.log(pwLimit.test(input[1].value));
            return false;
         }         

         // 개인정보 동의박스 체크
         var consentCheck = document.getElementById("agree");

         if(!consentCheck.checked){
        	 alert("개인정보 수집이용 동의를 해주세요.");
        	 history.go(-1);
            return false;
         }
        
      }//join.onsublit

   }//window