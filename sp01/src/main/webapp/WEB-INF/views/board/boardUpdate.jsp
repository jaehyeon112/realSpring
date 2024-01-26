<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="container">
  <h1>게시글 수정</h1>
  <form name="updateForm">
    <table class="table">
      <tr>
        <th>번호</th>
        <td><input name="bno" type="text" value="${boardInfo.bno }"></td>
      </tr>
      <tr>
        <th>제목</th>
        <td><input name="title" type="text" value="${boardInfo.title }"></td>
      </tr>
      <tr>
        <th>작성자</th>
        <td><input name="writer" type="text" value="${boardInfo.writer }"></td>
      </tr>
      <tr>
        <th>내용</th>
        <td><textarea name="contents" cols="50">${boardInfo.contents }"</textarea></td>
      </tr>
      <tr>
        <th>이미지</th> <!-- app.jpg -->
        <td><input name="image" type="text" value="${boardInfo.image }"></td>
      </tr>
    </table>
    <button type="button">저장</button>
  </form>
</div>
<script>
  $('form button:contains(저장)').on('click', boardUpdateAjax);

  function boardUpdateAjax(event) {
    // 통신 진행 여부 결정
    if (!validation()){return}

    console.log('진행해~')
    // 통신하기 위한 데이터 가져오기
    let boardDta = getBoardInfo();
    console.log('boardDta', boardDta);
	
    $.ajax('boardUpdate', {
        type: 'post',
        // data : boardDta
        
        // @RequestBody
        data: JSON.stringify(boardDta),
        contentType : 'application/json'
      })
      .then(result => {
        console.log(result)
      })
      .fail(err => console.log(err))
  }

  function validation() {
    let title = $('input[name="title"]');
    let writer = $('input[name="writer"]');
	
    if (title.val() == '') {
      alert('제목이 입력되지 않았습니다.')
      title.focus();
      return false;
    }

    if (writer.val() == '') {
      alert('작성자가 입력되지 않았습니다.');
      writer.focus();
      return false;
    }
    return true;
  }

  function getBoardInfo() {
	console.log("이거됨?")
    let formAry = $('form[name="updateForm"]').serializeArray();
    console.log(formAry);

    let formObj = {};
    $(formAry).each((idx, tag) => {
      console.log(tag);
      formObj[tag.name] = tag.value;
    })
    return formObj;
  }
</script>