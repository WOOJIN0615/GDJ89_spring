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
		<h1>${kind}</h1>
		<form action="./list" id="list_form" class="row row-cols-lg-auto g-3 align-items-center">
	<input type="hidden" name="page" id="pageNum">
  <div class="col-12">
    <label class="visually-hidden" for="inlineFormSelectPref">Preference</label>
    <select name="kind" class="form-select" id="inlineFormSelectPref">
      <option value="k1" ${pager.kind eq 'k1'?'selected': ''}>제목</option>
      <option value="k2" ${pager.kind eq 'k2'?'selected': ''}>내용</option>
      <option value="k3" ${pager.kind eq 'k3'?'selected': ''}>제목+내용</option>
    </select>
  </div>
<div class="col-12">
      <input type="text" value="${pager.search}" name="search" class="form-control" id="inlineFormInputGroupUsername">
  </div>

  <div class="col-12">
    <button type="submit" class="btn btn-primary">검색</button>
  </div>
</form>
		<table class="table">
			  <thead>
			    <tr>
			      <th>#</th>
			      <th>작성자</th>
			      <th>제목</th>
			      <th>작성일</th>
			      <th>조회수</th>
			    </tr>
			  </thead>
			  <tbody>
			  <c:forEach items="${list}" var="v">
			    <tr>
			      <td>${v.boardNum}</td>
			      <td>
			      <a style="color:black; text-decoration: none" href="./detail.do?boardNum=${v.boardNum}">${v.userName}</a></td>
			      <td>
			      		<c:catch>
			      		<c:forEach begin="1" end="${v.boardDepth}">--</c:forEach>
			      		</c:catch>
			      		${v.boardTitle}
			      </td>
			      <td>${v.boardDate}</td>
			      <td>${v.boardHit}</td>
			    </tr>
			  </c:forEach>
			  </tbody>
			</table>
			<div >
			<nav aria-label="Page navigation example" style="width: 300px; margin: 0px auto;">
  			<ul class="pagination">
  			  <li class="page-item">
   			   <button class="page-link pages" data-page-num="${pager.start-1}" aria-label="Previous">
   		     <span aria-hidden="true">&laquo;</span>
			   </button>
		    </li>
		    <c:forEach begin="${pager.start}" end="${pager.end}" var="i">
		    	<li class="page-item">
					<button class="page-link pages" data-page-num="${i}">${i}</button>
				</li>
		    </c:forEach>
		    <li class="page-item ${pager.endCheck?'disabled':''}">
		      <button class="page-link pages" data-page-num="${pager.end+1}" aria-label="Next">
		        <span aria-hidden="true">&raquo;</span>
			  </button>
		    </li>
		  </ul>
			</nav>
			</div>
			<a class="btn btn-success" href="./add">글쓰기</a>
	</div>
</div>

<c:import url="/WEB-INF/views/template/layout_footer.jsp"></c:import>
<c:import url="/WEB-INF/views/template/boot_jsp.jsp"></c:import>
<script src="/resources/js/list.js"></script>
</body>
</html>