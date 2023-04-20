<%@ tag body-content="empty" trimDirectiveWhitespaces="true" %>
<%@ attribute name="searchPageData" required="true" type="de.hybris.platform.commerceservices.search.pagedata.SearchPageData" %>
<%@ attribute name="locationQuery" required="false" type="java.lang.String" %>
<%@ attribute name="geoPoint" required="false" type="de.hybris.platform.commerceservices.store.data.GeoPoint" %>
<%@ attribute name="numberPagesShown" required="true" type="java.lang.Integer" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="theme" tagdir="/WEB-INF/tags/shared/theme" %>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags" %>
<%@ taglib prefix="store" tagdir="/WEB-INF/tags/responsive/store" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="nav" tagdir="/WEB-INF/tags/responsive/nav" %>
<%@ taglib prefix="action" tagdir="/WEB-INF/tags/responsive/action" %>
<%@ taglib prefix="format" tagdir="/WEB-INF/tags/shared/format" %>
<%@ taglib prefix="component" tagdir="/WEB-INF/tags/shared/component" %>
<%@ taglib prefix="formElement" tagdir="/WEB-INF/tags/responsive/formElement"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<spring:htmlEscape defaultHtmlEscape="true" />
<c:url value="${store.url}" var="storeReviewActionUrl"/>
<c:url value="/store-finder" var="storeFinderFormAction" />

<div class="store__finder js-store-finder" data-url="${storeFinderFormAction}">
    <div class="row">
        <ycommerce:testId code="storeFinder">
            <div class="col-lg-8">
                <div class="store__finder--pagination">
                    <div class="pull-right">
                        <button class="btn btn-default js-store-finder-pager-prev" type="button">
                            <spring:theme code="storeFinder.pagination.previous" text="Previous"></spring:theme>
                        </button>
                        <button class="btn btn-default js-store-finder-pager-next" type="button">
                            <spring:theme code="storeFinder.pagination.next" text="Next"></spring:theme>
                        </button>
                    </div>
                    <span class="js-store-finder-pager-item-from"></span>-
                    <span class="js-store-finder-pager-item-to"></span>
                    <spring:theme code="storeFinder.pagination.from" text="from"></spring:theme>
                    &nbsp;<span class="js-store-finder-pager-item-all"></span>
                    <spring:theme code="storeFinder.pagination.stores" text="stores found"></spring:theme>
                </div>

                <div class="store__finder--panel">
                    <div class="store__finder--navigation">
                        <ul class="store__finder--navigation-list js-store-finder-navigation-list">
                            <li class="loading"><span class="glyphicon glyphicon-repeat"></span></li>
                        </ul>
                    </div>

                    <div class="store__finder--details js-store-finder-details">
                        <div>
                            <button class="btn btn-default store__finder--details-back js-store-finder-details-back">
                                <span class="glyphicon glyphicon-chevron-left"></span>
                                <spring:theme code="pickup.in.store.back.to.results" text="Back"></spring:theme>
                            </button>
                        </div>



                        <div class="store__finder--details-image js-store-image"></div>
                        <div class="store__finder--details-info">
                            <div class="info__name js-store-name"  name="storeName">
                            </div>
                            <div class="info__address">
                                <div class="js-store-line1"></div>
                                <div class="js-store-line2"></div>
                                <div class="js-store-town"></div>
                            </div>
                        </div>
                        <c:set var="storeName" value="${pageContext.request.getAttribute('storeName')}" />
                        <c:url value="/store/Nakano" var="store"/>
                        <a href="${fn:escapeXml(store)}">${storeName}</a>
                        <hr>
                        <div class="store__finder--map js-store-finder-map"></div>
                        <hr>

                        <div class="store__finder--details-openings">
                            <dl class="dl-horizontal js-store-openings"></dl>
                            <div class="openings__title"><spring:theme code="storeDetails.table.features" /></div>
                            <ul class="js-store-features"></ul>
                        </div>
                    </div>
                </div>



                <div class="store__finder--pagination">
                    <div class="pull-right">
                        <button class="btn btn-default js-store-finder-pager-prev" type="button" >
                            <spring:theme code="storeFinder.pagination.previous" text="Previous"></spring:theme>
                        </button>
                        <button class="btn btn-default js-store-finder-pager-next" type="button" >
                            <spring:theme code="storeFinder.pagination.next" text="Next"></spring:theme>
                        </button>
                    </div>
                    <span class="js-store-finder-pager-item-from"></span>
                    <span class="js-store-finder-pager-item-to"></span>
                    <spring:theme code="storeFinder.pagination.from" text="from"></spring:theme>
                    &nbsp;<span class="js-store-finder-pager-item-all"></span>
                    <spring:theme code="storeFinder.pagination.stores" text="stores found"></spring:theme>
                </div>
            </div>
        </ycommerce:testId>
    </div>

</div>