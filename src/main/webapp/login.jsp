
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="header.jsp"></c:import>
<div class="loginform">
	<div class="left_column">
		<h1>Sign in</h1>

		

<c:if test="${action == 'formsubmit'}"><p class="error">${error}</p></c:if>
		<form action="<c:url value='/login'/>"
			method="post">
			<input type="hidden" name="action" value="formsubmit"> <input
				type="text" id="email" name="email" placeholder="Email address" <c:if test="${cookie.cEmail.value != null}">
				value="${cookie.cEmail.value}"</c:if>><br /> <input type="password"
				id="password" name="password" placeholder="Password" /> <input
				type="checkbox" id="check" name="checkbox" /> <label
				style="font-size: 90%;" for="check">Remember me</label>
			<p>
				<a href="#">Forgot your password?</a>
			</p>
			<input type="submit" id="btn" name="btn" value="LOGIN">
		</form>
		<p>Not have account?<a style="color:blue;" href="<c:url value='/register.jsp'/>"> Register</a></p>
	</div>
	<div class="right_column">
		<h1>Welcome Back!</h1>
		<p>To keep connected with us please login with your personal info</p>
	</div>
</div>

<c:import url="footer.jsp"></c:import>