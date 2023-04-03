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

<c:set var="ratingJson">${ycommerce:encodeJSON(Math.round(product.averageRating * 100) / 100.0)}</c:set>

<div id="tabreview" class="tabhead">
	<a href="">${fn:escapeXml(title)}</a> <span class="glyphicon"></span>
</div>

<div class="tabbody">
		<div class="row">
			<div class="col-md-2 col-lg-2">
				<div class="tab-container">
					<product:productPageReviewsTab product="${product}" />
				</div>
			</div>
		</div>
	    <div class="carousel__component">
		  <div class="carousel__component--headline" >
			  <spring:theme code="reviews.headline"/>
			<br>
			Rating avarage:&nbsp;${ratingJson}/5.0
			<br>
			<div class="rating" style="margin-left: 44%;">
				<div class="rating-stars pull-left js-ratingCalc ${fn:escapeXml(starsClass)}" data-rating='{"rating":"${fn:escapeXml(ratingJson)}","total":5}' >
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
			</div>
		</div>
		<div class="carousel__component--carousel js-owl-carousel js-owl-lazy-reference js-owl-carousel-reference">

			<c:forEach items="${reviewsData}" var="review">
				<div class="carousel__item reviewsCarousel" >
					<div class="carousel__item--name">
						<div class="review-entry">
							<div class="name"><spring:theme code="reviews.customer"/>&nbsp;${fn:escapeXml(review.principal.name)}</div>
						</div>
					</div>
					<div class="carousel__item--name">
							<div class="title"><spring:theme code="reviews.title"/>&nbsp;${fn:escapeXml(review.headline)}</div>
					</div>

					<div class="carousel__item--name" >
						<spring:theme code="reviews.rating"/>&nbsp;${review.rating}
						<div class="rating" style="margin-left: 30%;">

							<div class="rating-stars pull-left js-ratingCalc " data-rating='{"rating":"${ycommerce:encodeJSON(review.rating)}","total":5}' >
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
						</div>
					</div>
					<div class="carousel__item--name"><div class="content commentContent"><spring:theme code="reviews.comment"/>&nbsp;${fn:escapeXml(review.comment)}</div></div>
				</div>
			</c:forEach>
		</div>
	</div>

</div>

