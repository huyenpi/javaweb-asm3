<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="header.jsp"></c:import>
<div class="signup_form">
	<div class="left_column">
		<h1>Register</h1>


		<c:if test="${action == 'formsubmit'}">
			<p class="error">${error}</p>
		</c:if>


		<form action="<c:url value='/register'/>" method="post">
			<input type="hidden" name="action" value="formsubmit" required> <input
				type="text" id="name" name="name" placeholder="Your name" required><br />
			<input type="text" id="address" name="address"
				placeholder="Your address" required><br /> <input type="text"
				id="email" name="email" placeholder="Email address" required><br />
			<input type="text" id="phone" name="phone" placeholder="Your phone" required><br />
			<input type="password" id="password" name="password"
				placeholder="Password" required><br /> <input type="password"
				id="mappass" name="mappass" placeholder="Retype Password" required><br />



			<input type="submit" id="btn" name="btn" value="REGISTER">
		</form>
	</div>
	<div class="right_column">
		<h1>Welcome!</h1>
		<p>To keep connected with us please sign up with your personal
			info</p>
	</div>
</div>

<c:import url="footer.jsp"></c:import>