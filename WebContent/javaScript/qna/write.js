/**
 * 
 */

function deleteCheck(root, pageNumber, boardNumber){
	var url=root+"/qna/qnalist.self";
	alert(url);

	var value = confirm("삭제하시겠습니까?");
	if(value==true){
		location.href=url;
	}
}