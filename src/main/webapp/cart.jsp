<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="header.jsp"></c:import>

<c:choose>
	<c:when test="${cart == null}">
		<h3 style="padding: 10px 0 500px 0; text-align: center">No cart
			yet!</h3>
	</c:when>
	<c:otherwise>
		<h3 style="padding: 10px; text-align: center">Shopping Cart</h3>

		<table class="cart">
			<thead>
				<tr>
					<th>Products in cart: ${cart.items.size()}</th>
					<th>Price</th>
					<th>Quantity</th>
					<th>Amount</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="c" items="${cart.items}">

					<tr>
						<td>${c.name}</td>
						<td>($)${c.price}</td>
						<td><a class="quantity"
							href="<c:url value='/addtocart?action=remove&id=${c.id}'/>"><</a>${c.number}<a
							class="quantity"
							href="<c:url value='/addtocart?action=add&id=${c.id}'/>">></a></td>
						<td>($)${Math.round(c.price * c.number *100)/100}</td>
					</tr>
				</c:forEach>


			</tbody>
		</table>

		<div class="clearfix">
			<p class="total_amount">Total: ($)${cart.amount}</p>
		</div>
		<hr />

		<div class="customInfo">
			<c:set var="cart" scope="session" value="${cart}" />

			<form action="<c:url value='/pay'/>" method="post">

				<lable for="name">Custom Name: </lable>
				<br /> <input type="text" id="name" name="name" required /><br />
				<lable for="address">Custom Address: </lable>
				</br> <input type="text" id="address" name="address" required /><br />
				<lable for="discount">Discount Code(if any): </lable>
				</br> <input type="text" id="discount" name="discount" /><br /> <input
					type="submit" id="button" name="btn" value="Submit" />
			</form>
		</div>
	</c:otherwise>
</c:choose>
<c:import url="footer.jsp"></c:import>