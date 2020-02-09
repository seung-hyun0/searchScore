/**
 * 
 */


function idCheck(obj, root){
	/*alert(obj.id.value); 사용자가 입력한 id값*/
	
	if(obj.id.value==""){	//id값에 입력을 안한 경우
		alert("아이디를 입력하세요.");
		obj.id.focus();	//커서를 아이디에 놓아줌
		return false;
	}
	
	var url = root +"/member/idCheck.self?id=" + obj.id.value;	// /homePage/member/idCheck.do?id=0000 id에 0000입력한 경우
	/*alert(url);*/													// idCheckAction으로 간 다음에 idCheck.jsp로 간다.
	
	open(url,"","width=400, height=400, scrollbars=yes");	// url페이지(idCheck.jsp)를 새창으로 오픈 
}

function zipcodeRead(root){
	var url=root + "/member/zipcode.self";	
	/*alert(url);*/
	
	open(url,"","width=400, height=400, scrollbars=yes");
}

function sendAddress(zipcode, sido, gugun, dong, ri, bunji){
	var address=sido + gugun + dong + ri + bunji;	//address에 시,군,동,리,번지값을 대입
	alert(zipcode + "," + address);
	
	opener.createForm.zipcode.value=zipcode;	//createForm의 zipcode값에 선택된 zipcode값을 입력 (회원가입 페이지에 자동으로 입력되는 것)
	opener.createForm.address.value=address;	//createForm의 address값에 선택된 address값을 입력
	self.close();
}