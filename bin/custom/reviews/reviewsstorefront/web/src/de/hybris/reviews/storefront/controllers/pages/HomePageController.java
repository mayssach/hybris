/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.reviews.storefront.controllers.pages;

import de.hybris.platform.acceleratorstorefrontcommons.constants.WebConstants;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.AbstractPageController;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.util.GlobalMessages;
import de.hybris.platform.acceleratorstorefrontcommons.forms.ReviewForm;
import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;
import de.hybris.platform.cms2.model.pages.AbstractPageModel;
import de.hybris.platform.cms2.model.pages.ContentPageModel;

import de.hybris.platform.commercefacades.product.data.ReviewData;
import de.hybris.reviews.facades.review.ReviewFacade;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import java.util.List;


/**
 * Controller for home page
 */
@Controller
@RequestMapping("/")
public class HomePageController extends AbstractPageController
{
	private static final String LOGOUT = "logout";
	private static final String ACCOUNT_CONFIRMATION_SIGNOUT_TITLE = "account.confirmation.signout.title";
	private static final String ACCOUNT_CONFIRMATION_CLOSE_TITLE = "account.confirmation.close.title";
	@Resource(name = "reviewFacade")
	private ReviewFacade reviewFacade;

	@RequestMapping(method = RequestMethod.GET)
	public String home(@RequestParam(value = WebConstants.CLOSE_ACCOUNT, defaultValue = "false") final boolean closeAcc,
			@RequestParam(value = LOGOUT, defaultValue = "false") final boolean logout, final Model model,
			final RedirectAttributes redirectModel) throws CMSItemNotFoundException
	{
		final List<ReviewData> reviews=reviewFacade.getSiteReviews(getBaseSiteService().getCurrentBaseSite().getUid(),null);
		model.addAttribute("siteReviewsData", reviews);
		model.addAttribute("reviewsTotal", getBaseSiteService().getCurrentBaseSite().getNumberOfReviews());
		model.addAttribute("site", getBaseSiteService().getCurrentBaseSite());
		model.addAttribute("sitereviewForm",new ReviewForm());
		if (logout)
		{
			String message = ACCOUNT_CONFIRMATION_SIGNOUT_TITLE;
			if (closeAcc)
			{
				message = ACCOUNT_CONFIRMATION_CLOSE_TITLE;
			}
			GlobalMessages.addFlashMessage(redirectModel, GlobalMessages.INFO_MESSAGES_HOLDER, message);
			return REDIRECT_PREFIX + ROOT;
		}
		final ContentPageModel contentPage = getContentPageForLabelOrId(null);
		storeCmsPageInModel(model, contentPage);
		setUpMetaDataForContentPage(model, contentPage);
		updatePageTitle(model, contentPage);

		return getViewForPage(model);
	}

	protected void updatePageTitle(final Model model, final AbstractPageModel cmsPage)
	{
		storeContentPageTitleInModel(model, getPageTitleResolver().resolveHomePageTitle(cmsPage.getTitle()));
	}
}
