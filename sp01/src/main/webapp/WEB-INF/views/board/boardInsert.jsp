<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="container">
	<h1>게시글 등록</h1>
	<form name="insertForm" action="boardInsert" method="post">
		<table class="table">
			<tr>
				<th>제목</th>
				<td><input name="title"  type="text"></td>
			</tr>
			<tr>
				<th>작성자</th>
				<td><input name="writer" type="text"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea name="contents" cols="50" ></textarea></td>
			</tr>
			<tr>
				<th>이미지</th> <!-- app.jpg -->
				<td><input name="image" type="text"></td>
			</tr>
		</table>
		<button type="submit">등록</button>
	</form>
</div>
<script>
/* document.querySelector('form[name="insertForm"]')
.addEventListener('submit', boardInsertJs)

function boardInsertJs(e) {
e.preventDefault();

let title = document.getElementsByName('title')[0];
let writer = document.getElementsByName('writer')[0];

if (title.value == '' ) {
  alert('제목이 입력되지 않았습니다.')
  title.focus();
  return;
}

if (writer.value == '' ) {
  alert('작성자가 입력되지 않았습니다.');
  writer.focus();
  return;
}

insertForm.submit();
} */
$('form[name="insertForm"]').on('submit', boardInsertJq);

function boardInsertJq(e) {
	e.preventDefault();
	
  let title = $('[name="title"]');
  let writer = $('[name="writer"]');


  if (title.val() == '') {
    alert('제목이 입력되지 않았습니다.')
    title.focus();
    return;
  }

  if (writer.val() == '') {
    alert('작성자가 입력되지 않았습니다.');
    writer.focus();
    return;
  }

  insertForm.submit();

}
</script>