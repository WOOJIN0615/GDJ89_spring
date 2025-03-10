<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="/WEB-INF/views/template/boot_css.jsp"></c:import>
</head>
<body>
<c:import url="/WEB-INF/views/template/layout_header.jsp"></c:import>

<div class="container-fluid my-5">
	<div class="row col-md-8 offset-md-2">
		<!-- contents 내용 작성 -->
		<h1>Notice Add</h1>
		<form action="" method="post" enctype="multipart/form-data">
		<div class="mb-3">
		  <input type="hidden" name="boardNum" value="${dto.boardNum}">
		  <label for="exampleFormControlInput1" class="form-label">제목</label>
		  <input type="text" name="boardTitle" class="form-control" id="exampleFormControlInput1" value="${dto.boardTitle}">
		</div>
		<div class="mb-3">
		  <label for="exampleFormControlTextarea1" class="form-label">내용</label>
		  <textarea class="form-control" name="boardContents" id="exampleFormControlTextarea1" rows="15" value="${dto.boardContents}"></textarea>
		</div>
		
		<div class="mb-3">
			<c:forEach items="${dto.boardFileDTOs}" var="a">
				<div class="alert alert-success" role="alert">
				   ${a.oldName} <button type="button" data-file-num="${a.fileNum}" data-kind="${kind}" class="btn btn-outline-light badge text-bg-secondary file_delete">X</button>
			 </div>
			</c:forEach>
		</div>

		<div id="files" class="mb-3" data-files-size="${dto.boardFileDTOs.size()}">
			<div class="mb-3">
				<button class="btn btn-success" type="button" id="add_file">파일추가</button>
			</div>
		   </div>
		<div class="mb-3" style="justify-content: between">
		<button type="submit" class="btn btn-primary">
		  수정
		</button>
		<a class="btn btn-danger" href="./list">수정 취소</a>		
		</div>
		</form>
	</div>
	
</div>

<c:import url="/WEB-INF/views/template/layout_footer.jsp"></c:import>
<c:import url="/WEB-INF/views/template/boot_jsp.jsp"></c:import>
<script type="module" src="/resources/js/files/filemanager.js"></script>
</body>
</html>