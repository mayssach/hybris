/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at 17 avr. 2023 à 13:54:11                     ---
 * ----------------------------------------------------------------
 *  
 * [y] hybris Platform
 * Copyright (c) 2023 SAP SE or an SAP affiliate company. All rights reserved.
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 */
package de.hybris.reviews.core.constants;

/**
 * @deprecated since ages - use constants in Model classes instead
 */
@Deprecated
@SuppressWarnings({"unused","cast"})
public class GeneratedReviewsCoreConstants
{
	public static final String EXTENSIONNAME = "reviewscore";
	public static class TC
	{
		public static final String APPARELPRODUCT = "ApparelProduct".intern();
		public static final String APPARELSIZEVARIANTPRODUCT = "ApparelSizeVariantProduct".intern();
		public static final String APPARELSTYLEVARIANTPRODUCT = "ApparelStyleVariantProduct".intern();
		public static final String ELECTRONICSCOLORVARIANTPRODUCT = "ElectronicsColorVariantProduct".intern();
		public static final String MODERATIONRULE = "ModerationRule".intern();
		public static final String MODERATIONRULETYPE = "moderationRuleType".intern();
		public static final String MODERATIONWORD = "ModerationWord".intern();
		public static final String MODERATRULECOMPARATOR = "moderatRulecomparator".intern();
		public static final String REVIEWCAROUSELCOMPONENT = "ReviewCarouselComponent".intern();
		public static final String SITEREVIEW = "SiteReview".intern();
		public static final String SITEREVIEWAPPROVALTYPE = "SiteReviewApprovalType".intern();
		public static final String STOREREVIEW = "StoreReview".intern();
		public static final String SWATCHCOLORENUM = "SwatchColorEnum".intern();
	}
	public static class Attributes
	{
		public static class BaseSite
		{
			public static final String AVERAGERATING = "averageRating".intern();
			public static final String NUMBEROFREVIEWS = "numberOfReviews".intern();
			public static final String SITEREVIEWS = "siteReviews".intern();
		}
		public static class PointOfService
		{
			public static final String AVERAGERATING = "averageRating".intern();
			public static final String NUMBEROFREVIEWS = "numberOfReviews".intern();
			public static final String STOREREVIEWS = "storeReviews".intern();
		}
		public static class User
		{
			public static final String SITEREVIEWS = "siteReviews".intern();
			public static final String STOREREVIEWS = "storeReviews".intern();
		}
	}
	public static class Enumerations
	{
		public static class CustomerReviewApprovalType
		{
			public static final String WAITING_FOR_VALIDATION = "waiting_for_validation".intern();
		}
		public static class ModerationRuleType
		{
			public static final String FLEXIBLE = "FLEXIBLE".intern();
			public static final String STRICT = "STRICT".intern();
		}
		public static class ModeratRulecomparator
		{
			public static final String AND = "AND".intern();
			public static final String OR = "OR".intern();
		}
		public static class SiteReviewApprovalType
		{
			public static final String APPROVED = "approved".intern();
			public static final String PENDING = "pending".intern();
			public static final String REJECTED = "rejected".intern();
		}
		public static class SwatchColorEnum
		{
			public static final String BLACK = "BLACK".intern();
			public static final String BLUE = "BLUE".intern();
			public static final String BROWN = "BROWN".intern();
			public static final String GREEN = "GREEN".intern();
			public static final String GREY = "GREY".intern();
			public static final String ORANGE = "ORANGE".intern();
			public static final String PINK = "PINK".intern();
			public static final String PURPLE = "PURPLE".intern();
			public static final String RED = "RED".intern();
			public static final String SILVER = "SILVER".intern();
			public static final String WHITE = "WHITE".intern();
			public static final String YELLOW = "YELLOW".intern();
		}
	}
	public static class Relations
	{
		public static final String MODERATRULE2WORD = "ModeratRule2Word".intern();
		public static final String REVIEWSFORCAROUSELCOMPONENT = "ReviewsForCarouselComponent".intern();
		public static final String REVIEWSITETOSITEREL = "ReviewSiteToSiteRel".intern();
		public static final String REVIEWSITETOUSERREL = "ReviewSiteToUserRel".intern();
		public static final String REVIEWSTORETOSTOREREL = "ReviewStoreToStoreRel".intern();
		public static final String REVIEWSTORETOUSERREL = "ReviewStoreToUserRel".intern();
	}
	
	protected GeneratedReviewsCoreConstants()
	{
		// private constructor
	}
	
	
}
