<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="header.jsp"></c:import>
<h4 class="phone_name">${product.name}</h4>
<hr>
<div class="product_info">
	<div class="phone_image">
		<img src="${product.src}">
	</div>
	<div class="phone_info">
		<h2 class="price">$${product.price}</h2>
		<p>Product description: ${product.description}</p>
		<form action="<c:url value='/addtocart?id=${product.id}&action=add'/>"
			method="post">
			<button type="submit" id="button">Add to cart</button>
		</form>
	</div>
</div>
<c:import url="footer.jsp"></c:import>