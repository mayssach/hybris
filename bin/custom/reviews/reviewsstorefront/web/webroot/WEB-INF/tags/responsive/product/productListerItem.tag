<%@ tag body-content="empty" trimDirectiveWhitespaces="true" %>
<%@ attribute name="product" required="true" type="de.hybris.platform.commercefacades.product.data.ProductData" %>
<%@ taglib prefix="product" tagdir="/WEB-INF/tags/responsive/product" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="action" tagdir="/WEB-INF/tags/responsive/action" %>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<spring:htmlEscape defaultHtmlEscape="true" />

<spring:theme code="text.addToCart" var="addToCartText"/>
<c:url value="${product.url}" var="productUrl"/>

<c:set value="${not empty product.potentialPromotions}" var="hasPromotion"/>

<c:set value="product__list--item" var="productTagClasses"/>
<c:forEach var="tag" items="${product.tags}">
	<c:set value="${productTagClasses} tag-${tag}" var="productTagClasses"/>
</c:forEach>
<li class="${fn:escapeXml(productTagClasses)}">
	<ycommerce:testId code="test_searchPage_wholeProduct">
		<a class="product__list--thumb" href="${fn:escapeXml(productUrl)}" title="${fn:escapeXml(product.name)}" >
			<product:productPrimaryImage product="${product}" format="thumbnail"/>
		</a>
		<ycommerce:testId code="searchPage_productName_link_${product.code}">
			<a class="product__list--name" href="${fn:escapeXml(productUrl)}">${ycommerce:sanitizeHTML(product.name)}</a>
		</ycommerce:testId>
		<div class="product__list--price-panel">
			<c:if test="${not empty product.potentialPromotions}">
				<div class="product__listing--promo">
					<c:forEach items="${product.potentialPromotions}" var="promotion">
						${ycommerce:sanitizeHTML(promotion.description)}
					</c:forEach>
				</div>
			</c:if>

			<ycommerce:testId code="searchPage_price_label_${product.code}">
				<div class="product__listing--price"><product:productListerItemPrice product="${product}"/></div>
			</ycommerce:testId>
		</div>

		<c:if test="${not empty product.summary}">
			<div class="product__listing--description">${ycommerce:sanitizeHTML(product.summary)}</div>
		</c:if>
		<div class="rating" >
			<div class="rating-stars pull-left js-ratingCalc ${fn:escapeXml(starsClass)}" data-rating='{"rating":"${fn:escapeXml(product.averageRating)}","total":5}' >
				<div class="greyStars">
					<c:forEach  begin="1" end="5">
						<span class="glyphicon glyphicon-star"></span>
					</c:forEach>
				</div>
				<div class="greenStars js-greenStars">
					<c:forEach  begin="1" end="5">
						<span class="glyphicon glyphicon-star active"></span>
					</c:forEach>
				</div>
			</div>
			<div class="rating-number" style="margin-top:25px;">${product.numberOfReviews}&nbsp;reviews</div>
		</div>


		<c:set var="product" value="${product}" scope="request"/>
		<c:set var="addToCartText" value="${addToCartText}" scope="request"/>
		<c:set var="addToCartUrl" value="${addToCartUrl}" scope="request"/>
		<div class="addtocart">
			<div id="actions-container-for-${fn:escapeXml(component.uid)}" class="row">
				<action:actions element="div" parentComponent="${component}"  />
			</div>
		</div>

	</ycommerce:testId>
</li>







