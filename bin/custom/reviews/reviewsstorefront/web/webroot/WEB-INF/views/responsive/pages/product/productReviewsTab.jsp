<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="product" tagdir="/WEB-INF/tags/responsive/product"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:url value="${product.url}/reviewhtml/3" var="getPageOfReviewsUrl"/>
<c:url value="${product.url}/reviewhtml/all" var="getAllReviewsUrl"/>
<c:url value="${product.url}/review" var="productReviewActionUrl"/>
<c:url value="${product.url}/reviewjson" var="productReviewUrl"/>

<spring:theme var="myProductCode" code="${product.code}"/>

<div id="tabreview" class="tabhead" data-productCode="${myProductCode}">
	<a href="">${fn:escapeXml(title)}</a> <span <%--class="glyphicon"--%>></span>
</div>

<div class="tabbody">
		<div class="row">
			<div class="col-md-12 col-lg-12">
				<div class="tab-container">
					<product:productPageReviewsTab product="${product}" />
				</div>
			</div>
		</div>
	<div id="reviews-container"></div>
</div>

