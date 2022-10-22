<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<c:import url="header.jsp"></c:import>



<table class="list_products">

	<c:set var="table_width" value="3" />
	<c:if test="${products.size() == 0}">
		<h1 style="padding: 200px; text-align: center">No items match</h1>
	</c:if>
	<c:forEach var="product" items="${products}" varStatus="status">

		<c:if test="${status.index % table_width == 0 }">
			<tr>
		</c:if>
		<td><a class="link"
			href="<c:url value="/info?id=${product.id}"/>"> <img width="80%"
				src="${product.src}" class="product_img" />
				<p class="shopname">${fn:toUpperCase(product.type)}</p>

				<h4 class="phonename">${product.name}</h4>
				<p class="price">$${product.price}</p></a></td>

		<c:if test="${status.index + 1 % table_width == 0 }">
			</tr>
		</c:if>
	</c:forEach>
</table>

<div class="pagination">
	<c:if test="${param.index > 1}">
		<a href="<c:url value='/products?index=${param.index-1}'/>"><<</a>
	</c:if>

	<c:forEach begin="1" end="${endPage}" var="i">
		<a href="<c:url value='/products?index=${i}'/>"
			<c:if test="${param.index == i}">class="active"</c:if>>${i}</a>
	</c:forEach>
	
	<c:if test="${param.index < endPage}">
		<a href="<c:url value='/products?index=${param.index+1}'/>">>></a>
	</c:if>
</div>





<c:import url="footer.jsp"></c:import>