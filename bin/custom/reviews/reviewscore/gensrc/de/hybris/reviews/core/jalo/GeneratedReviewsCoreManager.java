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
package de.hybris.reviews.core.jalo;

import de.hybris.platform.basecommerce.jalo.site.BaseSite;
import de.hybris.platform.jalo.GenericItem;
import de.hybris.platform.jalo.Item;
import de.hybris.platform.jalo.Item.AttributeMode;
import de.hybris.platform.jalo.JaloBusinessException;
import de.hybris.platform.jalo.JaloInvalidParameterException;
import de.hybris.platform.jalo.JaloSystemException;
import de.hybris.platform.jalo.SessionContext;
import de.hybris.platform.jalo.extension.Extension;
import de.hybris.platform.jalo.link.Link;
import de.hybris.platform.jalo.security.Principal;
import de.hybris.platform.jalo.type.CollectionType;
import de.hybris.platform.jalo.type.ComposedType;
import de.hybris.platform.jalo.type.JaloGenericCreationException;
import de.hybris.platform.jalo.user.User;
import de.hybris.platform.storelocator.jalo.PointOfService;
import de.hybris.platform.util.OneToManyHandler;
import de.hybris.reviews.core.constants.ReviewsCoreConstants;
import de.hybris.reviews.core.jalo.ApparelProduct;
import de.hybris.reviews.core.jalo.ApparelSizeVariantProduct;
import de.hybris.reviews.core.jalo.ApparelStyleVariantProduct;
import de.hybris.reviews.core.jalo.ElectronicsColorVariantProduct;
import de.hybris.reviews.core.jalo.ReviewCarouselComponent;
import de.hybris.reviews.core.model.ModerationRule;
import de.hybris.reviews.core.model.ModerationWord;
import de.hybris.reviews.core.model.SiteReview;
import de.hybris.reviews.core.model.StoreReview;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Generated class for type <code>ReviewsCoreManager</code>.
 */
@SuppressWarnings({"deprecation","unused","cast"})
public abstract class GeneratedReviewsCoreManager extends Extension
{
	/**
	* {@link OneToManyHandler} for handling 1:n SITEREVIEWS's relation attributes from 'many' side.
	**/
	protected static final OneToManyHandler<SiteReview> REVIEWSITETOSITERELSITEREVIEWSHANDLER = new OneToManyHandler<SiteReview>(
	ReviewsCoreConstants.TC.SITEREVIEW,
	true,
	"site",
	null,
	false,
	true,
	CollectionType.COLLECTION
	).withRelationQualifier("siteReviews");
	/**
	* {@link OneToManyHandler} for handling 1:n STOREREVIEWS's relation attributes from 'many' side.
	**/
	protected static final OneToManyHandler<StoreReview> REVIEWSTORETOSTORERELSTOREREVIEWSHANDLER = new OneToManyHandler<StoreReview>(
	ReviewsCoreConstants.TC.STOREREVIEW,
	true,
	"store",
	null,
	false,
	true,
	CollectionType.COLLECTION
	).withRelationQualifier("storeReviews");
	/**
	* {@link OneToManyHandler} for handling 1:n SITEREVIEWS's relation attributes from 'many' side.
	**/
	protected static final OneToManyHandler<SiteReview> REVIEWSITETOUSERRELSITEREVIEWSHANDLER = new OneToManyHandler<SiteReview>(
	ReviewsCoreConstants.TC.SITEREVIEW,
	false,
	"user",
	null,
	false,
	true,
	CollectionType.COLLECTION
	).withRelationQualifier("siteReviews");
	/**
	* {@link OneToManyHandler} for handling 1:n STOREREVIEWS's relation attributes from 'many' side.
	**/
	protected static final OneToManyHandler<StoreReview> REVIEWSTORETOUSERRELSTOREREVIEWSHANDLER = new OneToManyHandler<StoreReview>(
	ReviewsCoreConstants.TC.STOREREVIEW,
	false,
	"user",
	null,
	false,
	true,
	CollectionType.COLLECTION
	).withRelationQualifier("storeReviews");
	protected static final Map<String, Map<String, AttributeMode>> DEFAULT_INITIAL_ATTRIBUTES;
	static
	{
		final Map<String, Map<String, AttributeMode>> ttmp = new HashMap();
		DEFAULT_INITIAL_ATTRIBUTES = ttmp;
	}
	@Override
	public Map<String, AttributeMode> getDefaultAttributeModes(final Class<? extends Item> itemClass)
	{
		Map<String, AttributeMode> ret = new HashMap<>();
		final Map<String, AttributeMode> attr = DEFAULT_INITIAL_ATTRIBUTES.get(itemClass.getName());
		if (attr != null)
		{
			ret.putAll(attr);
		}
		return ret;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>BaseSite.averageRating</code> attribute.
	 * @return the averageRating - The average rating of the site.
	 */
	public abstract Double getAverageRating(final SessionContext ctx, final BaseSite item);
	
	/**
	 * <i>Generated method</i> - Getter of the <code>BaseSite.averageRating</code> attribute.
	 * @return the averageRating - The average rating of the site.
	 */
	public Double getAverageRating(final BaseSite item)
	{
		return getAverageRating( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>BaseSite.averageRating</code> attribute. 
	 * @return the averageRating - The average rating of the site.
	 */
	public double getAverageRatingAsPrimitive(final SessionContext ctx, final BaseSite item)
	{
		Double value = getAverageRating( ctx,item );
		return value != null ? value.doubleValue() : 0.0d;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>BaseSite.averageRating</code> attribute. 
	 * @return the averageRating - The average rating of the site.
	 */
	public double getAverageRatingAsPrimitive(final BaseSite item)
	{
		return getAverageRatingAsPrimitive( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>PointOfService.averageRating</code> attribute.
	 * @return the averageRating - The average rating of the store.
	 */
	public abstract Double getAverageRating(final SessionContext ctx, final PointOfService item);
	
	/**
	 * <i>Generated method</i> - Getter of the <code>PointOfService.averageRating</code> attribute.
	 * @return the averageRating - The average rating of the store.
	 */
	public Double getAverageRating(final PointOfService item)
	{
		return getAverageRating( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>PointOfService.averageRating</code> attribute. 
	 * @return the averageRating - The average rating of the store.
	 */
	public double getAverageRatingAsPrimitive(final SessionContext ctx, final PointOfService item)
	{
		Double value = getAverageRating( ctx,item );
		return value != null ? value.doubleValue() : 0.0d;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>PointOfService.averageRating</code> attribute. 
	 * @return the averageRating - The average rating of the store.
	 */
	public double getAverageRatingAsPrimitive(final PointOfService item)
	{
		return getAverageRatingAsPrimitive( getSession().getSessionContext(), item );
	}
	
	public ApparelProduct createApparelProduct(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType( ReviewsCoreConstants.TC.APPARELPRODUCT );
			return (ApparelProduct)type.newInstance( ctx, attributeValues );
		}
		catch( JaloGenericCreationException e)
		{
			final Throwable cause = e.getCause();
			throw (cause instanceof RuntimeException ?
			(RuntimeException)cause
			:
			new JaloSystemException( cause, cause.getMessage(), e.getErrorCode() ) );
		}
		catch( JaloBusinessException e )
		{
			throw new JaloSystemException( e ,"error creating ApparelProduct : "+e.getMessage(), 0 );
		}
	}
	
	public ApparelProduct createApparelProduct(final Map attributeValues)
	{
		return createApparelProduct( getSession().getSessionContext(), attributeValues );
	}
	
	public ApparelSizeVariantProduct createApparelSizeVariantProduct(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType( ReviewsCoreConstants.TC.APPARELSIZEVARIANTPRODUCT );
			return (ApparelSizeVariantProduct)type.newInstance( ctx, attributeValues );
		}
		catch( JaloGenericCreationException e)
		{
			final Throwable cause = e.getCause();
			throw (cause instanceof RuntimeException ?
			(RuntimeException)cause
			:
			new JaloSystemException( cause, cause.getMessage(), e.getErrorCode() ) );
		}
		catch( JaloBusinessException e )
		{
			throw new JaloSystemException( e ,"error creating ApparelSizeVariantProduct : "+e.getMessage(), 0 );
		}
	}
	
	public ApparelSizeVariantProduct createApparelSizeVariantProduct(final Map attributeValues)
	{
		return createApparelSizeVariantProduct( getSession().getSessionContext(), attributeValues );
	}
	
	public ApparelStyleVariantProduct createApparelStyleVariantProduct(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType( ReviewsCoreConstants.TC.APPARELSTYLEVARIANTPRODUCT );
			return (ApparelStyleVariantProduct)type.newInstance( ctx, attributeValues );
		}
		catch( JaloGenericCreationException e)
		{
			final Throwable cause = e.getCause();
			throw (cause instanceof RuntimeException ?
			(RuntimeException)cause
			:
			new JaloSystemException( cause, cause.getMessage(), e.getErrorCode() ) );
		}
		catch( JaloBusinessException e )
		{
			throw new JaloSystemException( e ,"error creating ApparelStyleVariantProduct : "+e.getMessage(), 0 );
		}
	}
	
	public ApparelStyleVariantProduct createApparelStyleVariantProduct(final Map attributeValues)
	{
		return createApparelStyleVariantProduct( getSession().getSessionContext(), attributeValues );
	}
	
	public ElectronicsColorVariantProduct createElectronicsColorVariantProduct(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType( ReviewsCoreConstants.TC.ELECTRONICSCOLORVARIANTPRODUCT );
			return (ElectronicsColorVariantProduct)type.newInstance( ctx, attributeValues );
		}
		catch( JaloGenericCreationException e)
		{
			final Throwable cause = e.getCause();
			throw (cause instanceof RuntimeException ?
			(RuntimeException)cause
			:
			new JaloSystemException( cause, cause.getMessage(), e.getErrorCode() ) );
		}
		catch( JaloBusinessException e )
		{
			throw new JaloSystemException( e ,"error creating ElectronicsColorVariantProduct : "+e.getMessage(), 0 );
		}
	}
	
	public ElectronicsColorVariantProduct createElectronicsColorVariantProduct(final Map attributeValues)
	{
		return createElectronicsColorVariantProduct( getSession().getSessionContext(), attributeValues );
	}
	
	public ModerationRule createModerationRule(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType( ReviewsCoreConstants.TC.MODERATIONRULE );
			return (ModerationRule)type.newInstance( ctx, attributeValues );
		}
		catch( JaloGenericCreationException e)
		{
			final Throwable cause = e.getCause();
			throw (cause instanceof RuntimeException ?
			(RuntimeException)cause
			:
			new JaloSystemException( cause, cause.getMessage(), e.getErrorCode() ) );
		}
		catch( JaloBusinessException e )
		{
			throw new JaloSystemException( e ,"error creating ModerationRule : "+e.getMessage(), 0 );
		}
	}
	
	public ModerationRule createModerationRule(final Map attributeValues)
	{
		return createModerationRule( getSession().getSessionContext(), attributeValues );
	}
	
	public ModerationWord createModerationWord(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType( ReviewsCoreConstants.TC.MODERATIONWORD );
			return (ModerationWord)type.newInstance( ctx, attributeValues );
		}
		catch( JaloGenericCreationException e)
		{
			final Throwable cause = e.getCause();
			throw (cause instanceof RuntimeException ?
			(RuntimeException)cause
			:
			new JaloSystemException( cause, cause.getMessage(), e.getErrorCode() ) );
		}
		catch( JaloBusinessException e )
		{
			throw new JaloSystemException( e ,"error creating ModerationWord : "+e.getMessage(), 0 );
		}
	}
	
	public ModerationWord createModerationWord(final Map attributeValues)
	{
		return createModerationWord( getSession().getSessionContext(), attributeValues );
	}
	
	public ReviewCarouselComponent createReviewCarouselComponent(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType( ReviewsCoreConstants.TC.REVIEWCAROUSELCOMPONENT );
			return (ReviewCarouselComponent)type.newInstance( ctx, attributeValues );
		}
		catch( JaloGenericCreationException e)
		{
			final Throwable cause = e.getCause();
			throw (cause instanceof RuntimeException ?
			(RuntimeException)cause
			:
			new JaloSystemException( cause, cause.getMessage(), e.getErrorCode() ) );
		}
		catch( JaloBusinessException e )
		{
			throw new JaloSystemException( e ,"error creating ReviewCarouselComponent : "+e.getMessage(), 0 );
		}
	}
	
	public ReviewCarouselComponent createReviewCarouselComponent(final Map attributeValues)
	{
		return createReviewCarouselComponent( getSession().getSessionContext(), attributeValues );
	}
	
	public SiteReview createSiteReview(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType( ReviewsCoreConstants.TC.SITEREVIEW );
			return (SiteReview)type.newInstance( ctx, attributeValues );
		}
		catch( JaloGenericCreationException e)
		{
			final Throwable cause = e.getCause();
			throw (cause instanceof RuntimeException ?
			(RuntimeException)cause
			:
			new JaloSystemException( cause, cause.getMessage(), e.getErrorCode() ) );
		}
		catch( JaloBusinessException e )
		{
			throw new JaloSystemException( e ,"error creating SiteReview : "+e.getMessage(), 0 );
		}
	}
	
	public SiteReview createSiteReview(final Map attributeValues)
	{
		return createSiteReview( getSession().getSessionContext(), attributeValues );
	}
	
	public StoreReview createStoreReview(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType( ReviewsCoreConstants.TC.STOREREVIEW );
			return (StoreReview)type.newInstance( ctx, attributeValues );
		}
		catch( JaloGenericCreationException e)
		{
			final Throwable cause = e.getCause();
			throw (cause instanceof RuntimeException ?
			(RuntimeException)cause
			:
			new JaloSystemException( cause, cause.getMessage(), e.getErrorCode() ) );
		}
		catch( JaloBusinessException e )
		{
			throw new JaloSystemException( e ,"error creating StoreReview : "+e.getMessage(), 0 );
		}
	}
	
	public StoreReview createStoreReview(final Map attributeValues)
	{
		return createStoreReview( getSession().getSessionContext(), attributeValues );
	}
	
	@Override
	public String getName()
	{
		return ReviewsCoreConstants.EXTENSIONNAME;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>BaseSite.numberOfReviews</code> attribute.
	 * @return the numberOfReviews - The number of reviews for the site.
	 */
	public abstract Integer getNumberOfReviews(final SessionContext ctx, final BaseSite item);
	
	/**
	 * <i>Generated method</i> - Getter of the <code>BaseSite.numberOfReviews</code> attribute.
	 * @return the numberOfReviews - The number of reviews for the site.
	 */
	public Integer getNumberOfReviews(final BaseSite item)
	{
		return getNumberOfReviews( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>BaseSite.numberOfReviews</code> attribute. 
	 * @return the numberOfReviews - The number of reviews for the site.
	 */
	public int getNumberOfReviewsAsPrimitive(final SessionContext ctx, final BaseSite item)
	{
		Integer value = getNumberOfReviews( ctx,item );
		return value != null ? value.intValue() : 0;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>BaseSite.numberOfReviews</code> attribute. 
	 * @return the numberOfReviews - The number of reviews for the site.
	 */
	public int getNumberOfReviewsAsPrimitive(final BaseSite item)
	{
		return getNumberOfReviewsAsPrimitive( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>PointOfService.numberOfReviews</code> attribute.
	 * @return the numberOfReviews - The number of reviews for the store.
	 */
	public abstract Integer getNumberOfReviews(final SessionContext ctx, final PointOfService item);
	
	/**
	 * <i>Generated method</i> - Getter of the <code>PointOfService.numberOfReviews</code> attribute.
	 * @return the numberOfReviews - The number of reviews for the store.
	 */
	public Integer getNumberOfReviews(final PointOfService item)
	{
		return getNumberOfReviews( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>PointOfService.numberOfReviews</code> attribute. 
	 * @return the numberOfReviews - The number of reviews for the store.
	 */
	public int getNumberOfReviewsAsPrimitive(final SessionContext ctx, final PointOfService item)
	{
		Integer value = getNumberOfReviews( ctx,item );
		return value != null ? value.intValue() : 0;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>PointOfService.numberOfReviews</code> attribute. 
	 * @return the numberOfReviews - The number of reviews for the store.
	 */
	public int getNumberOfReviewsAsPrimitive(final PointOfService item)
	{
		return getNumberOfReviewsAsPrimitive( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>BaseSite.siteReviews</code> attribute.
	 * @return the siteReviews
	 */
	public Collection<SiteReview> getSiteReviews(final SessionContext ctx, final BaseSite item)
	{
		return REVIEWSITETOSITERELSITEREVIEWSHANDLER.getValues( ctx, item );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>BaseSite.siteReviews</code> attribute.
	 * @return the siteReviews
	 */
	public Collection<SiteReview> getSiteReviews(final BaseSite item)
	{
		return getSiteReviews( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>BaseSite.siteReviews</code> attribute. 
	 * @param value the siteReviews
	 */
	public void setSiteReviews(final SessionContext ctx, final BaseSite item, final Collection<SiteReview> value)
	{
		REVIEWSITETOSITERELSITEREVIEWSHANDLER.setValues( ctx, item, value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>BaseSite.siteReviews</code> attribute. 
	 * @param value the siteReviews
	 */
	public void setSiteReviews(final BaseSite item, final Collection<SiteReview> value)
	{
		setSiteReviews( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Adds <code>value</code> to siteReviews. 
	 * @param value the item to add to siteReviews
	 */
	public void addToSiteReviews(final SessionContext ctx, final BaseSite item, final SiteReview value)
	{
		REVIEWSITETOSITERELSITEREVIEWSHANDLER.addValue( ctx, item, value );
	}
	
	/**
	 * <i>Generated method</i> - Adds <code>value</code> to siteReviews. 
	 * @param value the item to add to siteReviews
	 */
	public void addToSiteReviews(final BaseSite item, final SiteReview value)
	{
		addToSiteReviews( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Removes <code>value</code> from siteReviews. 
	 * @param value the item to remove from siteReviews
	 */
	public void removeFromSiteReviews(final SessionContext ctx, final BaseSite item, final SiteReview value)
	{
		REVIEWSITETOSITERELSITEREVIEWSHANDLER.removeValue( ctx, item, value );
	}
	
	/**
	 * <i>Generated method</i> - Removes <code>value</code> from siteReviews. 
	 * @param value the item to remove from siteReviews
	 */
	public void removeFromSiteReviews(final BaseSite item, final SiteReview value)
	{
		removeFromSiteReviews( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>User.siteReviews</code> attribute.
	 * @return the siteReviews
	 */
	public Collection<SiteReview> getSiteReviews(final SessionContext ctx, final User item)
	{
		return REVIEWSITETOUSERRELSITEREVIEWSHANDLER.getValues( ctx, item );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>User.siteReviews</code> attribute.
	 * @return the siteReviews
	 */
	public Collection<SiteReview> getSiteReviews(final User item)
	{
		return getSiteReviews( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>User.siteReviews</code> attribute. 
	 * @param value the siteReviews
	 */
	protected void setSiteReviews(final SessionContext ctx, final User item, final Collection<SiteReview> value)
	{
		if ( ctx == null) 
		{
			throw new JaloInvalidParameterException( "ctx is null", 0 );
		}
		// initial-only attribute: make sure this attribute can be set during item creation only
		if ( ctx.getAttribute( "core.types.creation.initial") != Boolean.TRUE )
		{
			throw new JaloInvalidParameterException( "attribute '"+ReviewsCoreConstants.Attributes.User.SITEREVIEWS+"' is not changeable", 0 );
		}
		REVIEWSITETOUSERRELSITEREVIEWSHANDLER.setValues( ctx, item, value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>User.siteReviews</code> attribute. 
	 * @param value the siteReviews
	 */
	protected void setSiteReviews(final User item, final Collection<SiteReview> value)
	{
		setSiteReviews( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Adds <code>value</code> to siteReviews. 
	 * @param value the item to add to siteReviews
	 */
	protected void addToSiteReviews(final SessionContext ctx, final User item, final SiteReview value)
	{
		// initial-only attribute: make sure this attribute can be set during item creation only
		if ( ctx.getAttribute( "core.types.creation.initial") != Boolean.TRUE )
		{
			throw new JaloInvalidParameterException( "attribute '"+ReviewsCoreConstants.Attributes.User.SITEREVIEWS+"' is not changeable", 0 );
		}
		REVIEWSITETOUSERRELSITEREVIEWSHANDLER.addValue( ctx, item, value );
	}
	
	/**
	 * <i>Generated method</i> - Adds <code>value</code> to siteReviews. 
	 * @param value the item to add to siteReviews
	 */
	protected void addToSiteReviews(final User item, final SiteReview value)
	{
		addToSiteReviews( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Removes <code>value</code> from siteReviews. 
	 * @param value the item to remove from siteReviews
	 */
	protected void removeFromSiteReviews(final SessionContext ctx, final User item, final SiteReview value)
	{
		// initial-only attribute: make sure this attribute can be set during item creation only
		if ( ctx.getAttribute( "core.types.creation.initial") != Boolean.TRUE )
		{
			throw new JaloInvalidParameterException( "attribute '"+ReviewsCoreConstants.Attributes.User.SITEREVIEWS+"' is not changeable", 0 );
		}
		REVIEWSITETOUSERRELSITEREVIEWSHANDLER.removeValue( ctx, item, value );
	}
	
	/**
	 * <i>Generated method</i> - Removes <code>value</code> from siteReviews. 
	 * @param value the item to remove from siteReviews
	 */
	protected void removeFromSiteReviews(final User item, final SiteReview value)
	{
		removeFromSiteReviews( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>PointOfService.storeReviews</code> attribute.
	 * @return the storeReviews
	 */
	public Collection<StoreReview> getStoreReviews(final SessionContext ctx, final PointOfService item)
	{
		return REVIEWSTORETOSTORERELSTOREREVIEWSHANDLER.getValues( ctx, item );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>PointOfService.storeReviews</code> attribute.
	 * @return the storeReviews
	 */
	public Collection<StoreReview> getStoreReviews(final PointOfService item)
	{
		return getStoreReviews( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>PointOfService.storeReviews</code> attribute. 
	 * @param value the storeReviews
	 */
	public void setStoreReviews(final SessionContext ctx, final PointOfService item, final Collection<StoreReview> value)
	{
		REVIEWSTORETOSTORERELSTOREREVIEWSHANDLER.setValues( ctx, item, value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>PointOfService.storeReviews</code> attribute. 
	 * @param value the storeReviews
	 */
	public void setStoreReviews(final PointOfService item, final Collection<StoreReview> value)
	{
		setStoreReviews( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Adds <code>value</code> to storeReviews. 
	 * @param value the item to add to storeReviews
	 */
	public void addToStoreReviews(final SessionContext ctx, final PointOfService item, final StoreReview value)
	{
		REVIEWSTORETOSTORERELSTOREREVIEWSHANDLER.addValue( ctx, item, value );
	}
	
	/**
	 * <i>Generated method</i> - Adds <code>value</code> to storeReviews. 
	 * @param value the item to add to storeReviews
	 */
	public void addToStoreReviews(final PointOfService item, final StoreReview value)
	{
		addToStoreReviews( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Removes <code>value</code> from storeReviews. 
	 * @param value the item to remove from storeReviews
	 */
	public void removeFromStoreReviews(final SessionContext ctx, final PointOfService item, final StoreReview value)
	{
		REVIEWSTORETOSTORERELSTOREREVIEWSHANDLER.removeValue( ctx, item, value );
	}
	
	/**
	 * <i>Generated method</i> - Removes <code>value</code> from storeReviews. 
	 * @param value the item to remove from storeReviews
	 */
	public void removeFromStoreReviews(final PointOfService item, final StoreReview value)
	{
		removeFromStoreReviews( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>User.storeReviews</code> attribute.
	 * @return the storeReviews
	 */
	public Collection<StoreReview> getStoreReviews(final SessionContext ctx, final User item)
	{
		return REVIEWSTORETOUSERRELSTOREREVIEWSHANDLER.getValues( ctx, item );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>User.storeReviews</code> attribute.
	 * @return the storeReviews
	 */
	public Collection<StoreReview> getStoreReviews(final User item)
	{
		return getStoreReviews( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>User.storeReviews</code> attribute. 
	 * @param value the storeReviews
	 */
	protected void setStoreReviews(final SessionContext ctx, final User item, final Collection<StoreReview> value)
	{
		if ( ctx == null) 
		{
			throw new JaloInvalidParameterException( "ctx is null", 0 );
		}
		// initial-only attribute: make sure this attribute can be set during item creation only
		if ( ctx.getAttribute( "core.types.creation.initial") != Boolean.TRUE )
		{
			throw new JaloInvalidParameterException( "attribute '"+ReviewsCoreConstants.Attributes.User.STOREREVIEWS+"' is not changeable", 0 );
		}
		REVIEWSTORETOUSERRELSTOREREVIEWSHANDLER.setValues( ctx, item, value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>User.storeReviews</code> attribute. 
	 * @param value the storeReviews
	 */
	protected void setStoreReviews(final User item, final Collection<StoreReview> value)
	{
		setStoreReviews( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Adds <code>value</code> to storeReviews. 
	 * @param value the item to add to storeReviews
	 */
	protected void addToStoreReviews(final SessionContext ctx, final User item, final StoreReview value)
	{
		// initial-only attribute: make sure this attribute can be set during item creation only
		if ( ctx.getAttribute( "core.types.creation.initial") != Boolean.TRUE )
		{
			throw new JaloInvalidParameterException( "attribute '"+ReviewsCoreConstants.Attributes.User.STOREREVIEWS+"' is not changeable", 0 );
		}
		REVIEWSTORETOUSERRELSTOREREVIEWSHANDLER.addValue( ctx, item, value );
	}
	
	/**
	 * <i>Generated method</i> - Adds <code>value</code> to storeReviews. 
	 * @param value the item to add to storeReviews
	 */
	protected void addToStoreReviews(final User item, final StoreReview value)
	{
		addToStoreReviews( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Removes <code>value</code> from storeReviews. 
	 * @param value the item to remove from storeReviews
	 */
	protected void removeFromStoreReviews(final SessionContext ctx, final User item, final StoreReview value)
	{
		// initial-only attribute: make sure this attribute can be set during item creation only
		if ( ctx.getAttribute( "core.types.creation.initial") != Boolean.TRUE )
		{
			throw new JaloInvalidParameterException( "attribute '"+ReviewsCoreConstants.Attributes.User.STOREREVIEWS+"' is not changeable", 0 );
		}
		REVIEWSTORETOUSERRELSTOREREVIEWSHANDLER.removeValue( ctx, item, value );
	}
	
	/**
	 * <i>Generated method</i> - Removes <code>value</code> from storeReviews. 
	 * @param value the item to remove from storeReviews
	 */
	protected void removeFromStoreReviews(final User item, final StoreReview value)
	{
		removeFromStoreReviews( getSession().getSessionContext(), item, value );
	}
	
}
