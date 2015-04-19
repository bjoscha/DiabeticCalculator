package com.example.awesome.be_calculator.business;

import com.example.awesome.be_calculator.model.Product;
import com.example.awesome.be_calculator.model.ProductCategory;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by j on 11.04.2015.
 */
public class BusinessState {

    private static BusinessState INSTANCE;
    private ProductCategory currentCategory;
    private List<Product> products;

    public BusinessState()
    {
        currentCategory = ProductCategory.MeatAndColdmeat;
        products = Arrays.asList(TestProducts.TestProducts);
    }

    public static BusinessState getInstance()
    {
        if (INSTANCE==null)
        {
            INSTANCE = new BusinessState();
        }
        return INSTANCE;
    }

    public List<Product> getProductsOfCurrentCategory()
    {
        List<Product> productsOfCategory = new LinkedList<>();
        for(Product product : products) {
            if (product.Category == currentCategory)
            {
                productsOfCategory.add(product);
            }
        }

        return productsOfCategory;
    }


    public ProductCategory getCurrentCategory() {
        return currentCategory;
    }

    public void setCurrentCategory(ProductCategory newCurrentCategory) {
        currentCategory = newCurrentCategory;
    }

    public List<Product> getAllProducts()
    {
        return products;
    }
}
