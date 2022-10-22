<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/admin.css">
<script src="https://kit.fontawesome.com/cfc845dddc.js"
	crossorigin="anonymous"></script>
</head>
<body>
	<div class="container">
		<div class="left_box">
			<h3>1849 TEAM</h3>
			<div class="left_navbar">

				<p id="dashboard">
					<i class="fa-solid fa-gauge"></i><a href="#">Dashboard</a>
				</p>
				<p>
					<i class="fa-solid fa-user"></i><a href="#">Staff Manager</a>
				</p>
				<p>
					<i class="fa-solid fa-right-from-bracket"></i><a href="/PRJ321x_Asignment_2_huyenpttFX13136/logout">Log out</a>
				</p>


			</div>
		</div>
		<div class="right_box">
			<div class="banner">
				<h3 style="color: black; padding: 20px; text-align: center;">
					Welcome
					<%=session.getAttribute("username")%></h3>
			</div>
			<div class="members">
				<p>Members of the team</p>
				<table>
					<tr>
						<th>ID</th>
						<th>Name</th>
						<th>StudentID</th>
						<th>Class</th>
					</tr>
					<tr>
						<td>1</td>
						<td>Member 1</td>
						<td>Member Code 1</td>
						<td>Class 1</td>
					</tr>
					<tr>
						<td>2</td>
						<td>Member 2</td>
						<td>Member Code 2</td>
						<td>Class 2</td>
					</tr>
				</table>
			</div>
		</div>
	</div>

</body>
</html>