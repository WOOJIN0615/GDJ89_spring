<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header class="row">
			<nav class="navbar bg-dark border-bottom border-body" data-bs-theme="dark">
			  <div class="container-fluid">
			    <a class="navbar-brand" href="/">WOOJIN</a>
			    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
			      <span class="navbar-toggler-icon"></span>
			    </button>
			    <div class="collapse navbar-collapse" id="navbarSupportedContent">
			      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
			        <li class="nav-item">
			          <a class="nav-link active" aria-current="page" href="/">
			          	Home
			          </a>
			          	<c:if test="${not empty user}">
			          		<li style="color: white;">${user.username}님, 환영합니다!</li>
			          	</c:if>
			        </li>
			        <c:if test="${empty user}">
					<li class="nav-item">
						<a class="nav-link active" aria-current="page" href="users/login">Login</a>
					</li>
					</c:if>
					<c:if test="${not empty user}">
					<li><a class="nav-link active" aria-current="page" href="users/logout">Logout</a></li>
					<li><a class="nav-link active" aria-current="page" href="users/detail?username=${user.username}">Mypage</a></li>				
					</c:if>
			        <li class="nav-item">
			          <a class="nav-link" href="/products/list">Products</a>
			        </li>
			        <li class="nav-item">
			          <a class="nav-link" href="/qna/list">QNA</a>
			        </li>
			        <li class="nav-item">
			          <a class="nav-link" href="/notices/list">Notices</a>
			        </li>
			        <li class="nav-item dropdown">
			          <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="true">
			            Dropdown
			          </a>
			          <ul class="dropdown-menu">
			            <li><a class="nav-link" href="/products/list">Products</a></li>
			            <li><a class="nav-link" href="/qna/list">QNA</a></li>
			            <li><hr class="dropdown-divider"></li>
			            <li><a class="nav-link" href="/notices/list">Notices</a></li>
			          </ul>
			        </li>
			      </ul>
			      <form class="d-flex" role="search">
			        <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
			        <button class="btn btn-outline-success" type="submit">Search</button>
			      </form>
			    </div>
			  </div>
			</nav>
			
		</header>