<%@ taglib prefix="product" tagdir="/WEB-INF/tags/responsive/product"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<spring:htmlEscape defaultHtmlEscape="true" />


<div id="popup_add_review">
	<ycommerce:testId code="product-review-popup">
	  <div class="product-review-body">
			<div class="details">
				<div class="product-details-toggle-wrap">
					<div class="row">
						<div class="col-sm-6">
							<product:productPrimaryImage product="${product}" format="product"/>
						</div>
						<div class="col-sm-6">
							<ycommerce:testId code="productDetails_productNamePrice_label_${product.code}">
								<div class="name">${fn:escapeXml(product.name)}<span class="sku">ID</span>
									<span class="code">${fn:escapeXml(product.code)}</span>
									<span class="glyphicon glyphicon-chevron-right"></span>
								</div>
							</ycommerce:testId>
						</div>
					</div>
				</div>
			</div>

		  <div class="write-review">
			  <form:form method="post" action="${productReviewActionUrl}" modelAttribute="reviewForm">
				  <div class="form-group">
					  <formElement:formInputBox idKey="review.headline" labelKey="review.headline" path="headline" inputCSS="form-control" mandatory="true"/>
				  </div>
				  <div class="form-group">
					  <formElement:formTextArea idKey="review.comment" labelKey="review.comment" path="comment" areaCSS="form-control" mandatory="true"/>
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

					  <formElement:formInputBox idKey="review.rating" labelKey="review.rating" path="rating" inputCSS="sr-only js-ratingSetInput" labelCSS="sr-only" mandatory="true"/>
					  <formElement:formInputBox idKey="alias" labelKey="review.alias" path="alias" inputCSS="form-control" mandatory="false"/>
				  </div>

				  <button type="submit" class="btn btn-primary" value="<spring:theme code="review.submit"/>"><spring:theme code="review.submit"/></button>
			  </form:form>
			  <a href="" class="btn btn-default btn-block js-product-review-close-button">
				  <spring:theme text="Annuler" code="cart.page.continue"/>
			  </a>
		  </div>
	  </div>
	</ycommerce:testId>
</div>