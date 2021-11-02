function userDelete(hnum){
	result = confirm("관리자 권한을 정말 해제하시겠습니까?");
	if(result==true){
		location.href="deleteHRAdmin.do?hnum="+hnum;
	}
	return;
}
function infoDelete(text, uri){
	result = confirm(text);
	if(result==true){
		location.href=uri;
	}
	return;
}
function edit(){
	var datas = document.querySelectorAll(".edit");

	for(var i = 0; i < datas.length; i++){
		datas[i].removeAttribute("readonly");
	}
	document.getElementById("infoText").innerHTML = "수정";
	document.getElementById("update").type ="submit";
	document.getElementById("delete").type ="button";
}

//insertPost.jsp
window.onload = function(){
	var postForm = document.postForm;

	postForm.onsubmit = function(){
		// 사번 인증 유효성검사
		console.log("name value : "+postForm.name.value);
		if(postForm.name.value==''){
			alert('확인 버튼을 통해 사번 인증을 해주세요.');
			return false;
		}
		if(postForm.category.value=="직접선택"){
			alert('카테고리를 선택해 주세요.');
			return false;
		}
		if(postForm.password.value.length<4){
			alert('비밀번호 4자리 입력해 주세요.');
			return false;
		}
		
	}
}

//insertPost.jsp
function mnumCheck(){
	var mnum = document.postForm.pmem;

	if(mnum.value.length==0){
		alert('사번을 입력해 주세요.');
		return;
	}

	$.ajax({
		type:"post",
		url:"getMem.do",
		data : "mnum="+mnum.value,
		dataType: "json",
		success:function(args){
			console.log("데이터전송완 : "+args[0].name);
			console.log("데이터전송완 : "+args[0]);
			document.postForm.name.setAttribute('value', args[0].name);
			
			//document.postForm.name.setAttribute('value', args);
		},
		error: function(xhr) {
			console.log(xhr);
			alert('존재하지 않는 사번입니다.');
		}
	})

}


// show_Post
function resultSelColor(){
	var resultSel = document.postUForm.result;
	console.log("확인");
	
	if(resultSel.value=="InActive"){
		resultSel.style.color = "red";
	}
	else if(resultSel.value=="Active"){
		resultSel.style.color = "#00cf00";
	}			
}


