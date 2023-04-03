package de.hybris.training.services.cronjob;

import de.hybris.platform.catalog.CatalogService;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.cronjob.enums.CronJobResult;
import de.hybris.platform.cronjob.enums.CronJobStatus;
import de.hybris.platform.cronjob.model.CronJobModel;
import de.hybris.platform.product.ProductService;
import de.hybris.platform.servicelayer.cronjob.AbstractJobPerformable;
import de.hybris.platform.servicelayer.cronjob.PerformResult;
import de.hybris.training.services.productSales.ProductSalesService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Required;

import java.io.FileWriter;
import java.util.*;

public class ProductSaledJob extends AbstractJobPerformable<CronJobModel> {
    private static final Logger LOG = Logger.getLogger(ProductSaledJob.class);
    private ProductSalesService productSalesService;
    private ProductService productService;
    private CatalogService catalogService;
    public CatalogService getCatalogService() {
        return catalogService;
    }
    @Required
     public void setCatalogService(CatalogService catalogService) {
        this.catalogService = catalogService;
    }


    public ProductService getProductService() {
        return productService;
    }
    @Required
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }


    public ProductSalesService getProductSalesService() {
        return productSalesService;
    }
    @Required
    public void setProductSalesService(ProductSalesService productSalesService) {
        this.productSalesService = productSalesService;
    }

    @Override
    public PerformResult perform(CronJobModel cronJobModel) {
       //Délimiteurs qui doivent être dans le fichier CSV
          final String DELIMITER = ",";
          final String SEPARATOR = "\n";

        //En-tête de fichier
        final String HEADER = "ProductCode, Qte saled";

        long bestSale=0;
        List<ProductModel> products=getProductService().getAllProductsForCatalogVersion(getCatalogService().getCatalogForId("electronicsProductCatalog").getActiveCatalogVersion());
        try (FileWriter file = new FileWriter("C:\\hybris_1905_2\\hybris\\bin\\custom\\training\\trainingservices\\src\\de\\hybris\\training\\services\\cronjob\\ProductSaled.csv");)
             {
                 //Ajouter l'en-tête
                file.append(HEADER);
                //Ajouter une nouvelle ligne après l'en-tête
                file.append(SEPARATOR);
                StringBuilder sb = new StringBuilder();
                for(ProductModel product : products)
                {
                    bestSale=getProductSalesService().getQuantityProductSale(product.getCode());
                    sb.append(product.getCode().toString());
                    sb.append(DELIMITER);
                    sb.append(bestSale);
                    sb.append(SEPARATOR);
                }
                file.write(sb.toString());
                file.close();
                return new PerformResult(CronJobResult.SUCCESS, CronJobStatus.FINISHED);

            }
            catch(Exception e)
            {
                LOG.error("Exception occurred during cart cleanup", e);
                return new PerformResult(CronJobResult.ERROR, CronJobStatus.ABORTED);

            }
    }



}
