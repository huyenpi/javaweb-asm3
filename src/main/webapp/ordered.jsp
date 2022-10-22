<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="header.jsp"></c:import>
<c:choose>
<c:when test="${list.size() == 0}">
	<h3 style="padding: 10px 0 500px 0; text-align: center">No orders yet!</h3>
</c:when>
<c:otherwise>
<h3 style="padding: 10px; text-align: center">Shopping cart ordered</h3>
</c:otherwise>
</c:choose>
<c:forEach var="cart" items="${list}">
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
					<td>${c.number}</td>
					<td>($)${Math.round(c.price * c.number *100)/100}</td>
				</tr>
			</c:forEach>


		</tbody>
	</table>


	<div class="clearfix">
		<p class="total_amount">Total: ($)${cart.amount}</p>
	</div>
	<hr />
</c:forEach>

<c:import url="footer.jsp"></c:import>