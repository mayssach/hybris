/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.reviews.core.constants;

import de.hybris.platform.core.Registry;
import de.hybris.platform.core.Tenant;
import de.hybris.platform.util.Config;
import de.hybris.platform.util.SingletonCreator;
import de.hybris.platform.util.config.ConfigIntf;
import org.apache.log4j.Logger;

/**
 * Global class for all ReviewsCore constants. You can add global constants for your extension into this class.
 */
public final class ReviewsCoreConstants extends GeneratedReviewsCoreConstants
{
	public static final String EXTENSIONNAME = "reviewscore";
	private static final Logger LOG = Logger.getLogger(ReviewsCoreConstants.class.getName());

	private ReviewsCoreConstants()
	{
		Tenant tenant = Registry.getCurrentTenantNoFallback();
		this.config = tenant.getConfig();
		this.MINRATING = this.getMinRating();
		this.MAXRATING = this.getMaxRating();
		this.config.registerConfigChangeListener((key, value) -> {
			if (key.equals("customerreview.minimalrating")) {
				this.MINRATING = this.getMinRating();
			} else if (key.equals("customerreview.maximalrating")) {
				this.MAXRATING = this.getMaxRating();
			}

		});

	}

	// implement here constants used by this extension
	public static final String QUOTE_BUYER_PROCESS = "quote-buyer-process";
	public static final String QUOTE_SALES_REP_PROCESS = "quote-salesrep-process";
	public static final String QUOTE_USER_TYPE = "QUOTE_USER_TYPE";
	public static final String QUOTE_SELLER_APPROVER_PROCESS = "quote-seller-approval-process";
	public static final String QUOTE_TO_EXPIRE_SOON_EMAIL_PROCESS = "quote-to-expire-soon-email-process";
	public static final String QUOTE_EXPIRED_EMAIL_PROCESS = "quote-expired-email-process";
	public static final String QUOTE_POST_CANCELLATION_PROCESS = "quote-post-cancellation-process";

	private final ConfigIntf config;
	public volatile double MINRATING = 0.0;
	public volatile double MAXRATING = 5.0;

	public static ReviewsCoreConstants getInstance() {
		return (ReviewsCoreConstants)Registry.getSingleton(new SingletonCreator.Creator<ReviewsCoreConstants>() {
			private final String SINGLETON_CREATOR_ID = ReviewsCoreConstants.class.getName().intern();

			protected String getID() {
				return this.SINGLETON_CREATOR_ID;
			}

			protected ReviewsCoreConstants create() {
				return new ReviewsCoreConstants();
			}
		});
	}

	private double getMaxRating() {
		double maxRating = 0.0;

		try {
			maxRating = this.config.getDouble("sitereview.maximalrating", 5.0);
		} catch (NumberFormatException var3) {
			LOG.error("The parameter \"sitereview.maximalrating\" has illegal format (" + Config.getParameter("sitereview.maximalrating") + "), using default value: " + 5.0);
		}

		return maxRating;
	}

	private double getMinRating() {
		double minRating = 0.0;

		try {
			minRating = this.config.getDouble("sitereview.minimalrating", 0.0);
		} catch (NumberFormatException var3) {
			LOG.error("The parameter \"sitereview.minimalrating\" has illegal format (" + Config.getParameter("sitereview.minimalrating") + "), using default value: " + 0.0);
		}

		return minRating;
	}

	public static class DEFAULTS {
		public static final double MINIMAL_RATING = 0.0;
		public static final double MAXIMAL_RATING = 5.0;

		private DEFAULTS() {
		}
	}

	public static class KEYS {
		public static final String MINIMAL_RATING = "sitereview.minimalrating";
		public static final String MAXIMAL_RATING = "sitereview.maximalrating";

		private KEYS() {
		}
	}
}
