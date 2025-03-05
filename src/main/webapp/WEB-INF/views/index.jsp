<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="./template/boot_css.jsp"></c:import>
</head>
<body>
<c:import url="./template/layout_header.jsp"></c:import>
	<div class="container-fluid">
		<div class="container-fluid my-5">
			<div class="row col-md-8 offset-md-2">
				<div id="carouselExampleAutoplaying" class="carousel slide" data-bs-ride="carousel">
				  <div class="carousel-inner">
				    <div class="carousel-item active">
				      <img src="/resources/images/allright2.png" class="d-block w-100" alt="...">
				    </div>
				    <div class="carousel-item">
				      <img src="/resources/images/ct1_v2.png" class="d-block w-100" alt="...">
				    </div>
				    <div class="carousel-item">
				      <img src="/resources/images/ct1_v3.png" class="d-block w-100" alt="...">
				    </div>
				  </div>
				  <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleAutoplaying" data-bs-slide="prev">
				    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
				    <span class="visually-hidden">Previous</span>
				  </button>
				  <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleAutoplaying" data-bs-slide="next">
				    <span class="carousel-control-next-icon" aria-hidden="true"></span>
				    <span class="visually-hidden">Next</span>
				  </button>
				</div>
				
			</div>
		
		</div>
		<button id="btn">CLICK</button>

	
	</div>
<c:import url="./template/layout_footer.jsp"></c:import>
<c:import url="./template/boot_jsp.jsp"></c:import>
<script>
	const btn = document.getElementById("btn");
	
	btn.addEventListener('click', function(){
		console.log("start");
		let num=1;
		fetch("notices/list").then(result=>{
			return result.text(); //응답 데이터가 text 형태일때 꺼내는 메서드
			//result.json(); //응답 데이터가 json 형태일때 꺼내는 메서드
		})
		.then(result => {
			console.log(result);
			num++;
		})
		.catch((e)=>{

		})
		.finally(()=>{

		});
		console.log(num);
	})
</script>
</body>
</html>