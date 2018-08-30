package com.sum.product.preceding.process;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigInteger;

public class SumOfPrecedingProductsTest {

    private SumOfPrecedingProducts sumOfPrecedingProducts;

    /**
     * test for numbers in lower range
     */
    @Test
    public void sumOfPrecedingProducts_LowRange_Test() {

        sumOfPrecedingProducts = new SumOfPrecedingProducts(1, 5, 2);
        Assert.assertEquals(BigInteger.valueOf(21), sumOfPrecedingProducts.calculateSumOfProducts());
    }

    /**
     * test for numbers in mid range
     */
    @Test
    public void sumOfPrecedingProducts_MidRange_Test() {

        sumOfPrecedingProducts = new SumOfPrecedingProducts(1, 100, 10);
        Assert.assertEquals(new BigInteger("513946235090696089113"), sumOfPrecedingProducts.calculateSumOfProducts());
    }

    /**
     * test for numbers in higher range
     */
    @Test
    public void sumOfPrecedingProducts_HighRange_Test() {

        sumOfPrecedingProducts = new SumOfPrecedingProducts(1, 100000, 50);
        Assert.assertEquals("1935938857", sumOfPrecedingProducts.calculateSumOfProducts().toString().substring(0, 10));
    }


}