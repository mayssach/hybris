<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ attribute name="product" required="true" type="de.hybris.platform.commercefacades.product.data.ProductData"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="formElement" tagdir="/WEB-INF/tags/responsive/formElement"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="productt" tagdir="/WEB-INF/tags/responsive/product"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<spring:htmlEscape defaultHtmlEscape="true" />

<c:url value="${product.url}/reviewhtml/3" var="getPageOfReviewsUrl"/>
<c:url value="${product.url}/reviewhtml/all" var="getAllReviewsUrl"/>
<c:url value="${product.url}/review" var="productReviewActionUrl"/>

<div class="tab-review">
	<spring:theme var="titlehtml"  code="review.write.product.title" arguments="${fn:escapeXml(product.name)}"/>
		<sec:authorize access="!hasAnyRole('ROLE_ANONYMOUS')">
			<c:if test="${verif}">
			<button class="btn btn-default btn-block js-add-review" data-title="${fn:escapeXml(titlehtml)}"><spring:theme code="review.write.review"/></button>
			</c:if>
		</sec:authorize>
	<div id="popup_add_review" >
		<div class="row">
				<div class="write-review">
					<div class="col-sm-6">
						<div><productt:productPrimaryImage product="${product}" format="product"/></div>
					</div>
					<div class="col-sm-6">
						<div class="name">${fn:escapeXml(product.name)}<br>
							<span class="sku">ID</span>
							<span class="code">${fn:escapeXml(product.code)}</span>
						</div>
					</div>
					<div class="col-sm-12">
					<form:form method="post" action="${productReviewActionUrl}" id="reviewForm" modelAttribute="reviewForm">
						<div class="form-group">
							<formElement:formInputBox idKey="review.headline" labelKey="review.headline" path="headline" inputCSS="form-control js-required" mandatory="true" />
						</div>
						<div class="form-group">
							<formElement:formTextArea idKey="review.comment" labelKey="review.comment" path="comment" areaCSS="form-control js-required" mandatory="true"/>
						</div>

						<div class="form-group">
							<label><spring:theme code="review.rating"/></label>
							<div class="rating rating-set js-ratingCalcSet">
								<div class="rating-stars js-writeReviewStars">
									<c:forEach  begin="1" end="10" varStatus="loop">
										<span class="js-ratingIcon glyphicon glyphicon-star ${loop.index % 2 == 0 ? 'lh' : 'fh'}"></span>
									</c:forEach>
								</div>
							</div>

							<formElement:formInputBox idKey="review.rating" labelKey="review.rating" path="rating" inputCSS="sr-only js-ratingSetInput js-required" labelCSS="sr-only" mandatory="true" />
							<formElement:formInputBox idKey="alias" labelKey="review.alias" path="alias" inputCSS="form-control" mandatory="false" />
						</div>

						<button type="submit" class="btn btn-primary js-close-popup-review" value="<spring:theme code="review.submit"/>"><spring:theme code="review.submit"/></button>
					</form:form>

				</div>
			</div>
		</div>
	</div>

</div>

