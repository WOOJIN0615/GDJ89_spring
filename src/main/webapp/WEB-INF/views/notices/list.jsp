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
		<h1>공지사항</h1>
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
			      <td><a style="color:black; text-decoration: none" href="./detail.do?boardNum=${v.boardNum}">${v.userName}</a></td>
			      <td>${v.boardTitle}%</td>
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
   			   <a class="page-link" href="./list?page=${pager.start-1}" aria-label="Previous">
   		     <span aria-hidden="true">&laquo;</span>
   			   </a>
		    </li>
		    <c:forEach begin="${pager.start}" end="${pager.end}" var="i">
		    	<li class="page-item"><a class="page-link" href="./list?page=${i}">${i}</a></li>
		    </c:forEach>
		    <li class="page-item ${pager.endCheck?'disabled':''}">
		      <a class="page-link" href="./list?page=${pager.end+1}" aria-label="Next">
		        <span aria-hidden="true">&raquo;</span>
		      </a>
		    </li>
		  </ul>
			</nav>
			</div>
			<a class="btn btn-success" href="./add">글쓰기</a>
	</div>
</div>

<c:import url="/WEB-INF/views/template/layout_footer.jsp"></c:import>
<c:import url="/WEB-INF/views/template/boot_jsp.jsp"></c:import>
</body>
</html>