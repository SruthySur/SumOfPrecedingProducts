package com.sum.product.preceding.process;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


/**
 * Calculates the sum of a function across a range of consecutive numbers, from 1 to n (inclusive),
 * where the function returns the product of the *preceding* C elements
 */
public class SumOfPrecedingProducts {

    private final Logger log = LoggerFactory.getLogger(getClass());
    private final int startElement;
    private final int endElement;
    private final int precedingCount;

    public SumOfPrecedingProducts(int startElement, int endElement, int precedingCount) {
        this.startElement = startElement;
        this.endElement = endElement;
        this.precedingCount = precedingCount;
    }

    /**
     * @return calculates the sum of the products of the preceding C[precedingCount] elements of each element in the range -[startElement.....endElement]
     */
    public BigInteger calculateSumOfProducts() {

        BigInteger sum = BigInteger.ZERO;
        int currentElement = startElement;
        List<Integer> precedingElements;
        BigInteger product;

        while (currentElement <= endElement) {
            if (currentElement == startElement) sum.add(BigInteger.ZERO);
            else {
                precedingElements = getPrecedingElements(currentElement);
                product = multiplyElements(precedingElements);
                sum = sum.add(product);
            }
            currentElement++;
        }

        log.info("***------- Sum of products of preceding {} elements in the range ( {} - {} ) is :  {}  -------***",
                precedingCount, startElement, endElement, sum);

        return sum;
    }

    /**
     * @param list of Integers
     * @return the product of the elements in the input list
     */
    private BigInteger multiplyElements(List<Integer> list) {
        return list.stream().map(BigInteger::valueOf).reduce(BigInteger.ONE, BigInteger::multiply);
    }

    /**
     * @param currentElement
     * @return list of Integers which are the preceding C elements to find the product
     */
    private List<Integer> getPrecedingElements(int currentElement) {
        int precedingStart = currentElement <= precedingCount ? startElement : currentElement - precedingCount;
        return IntStream.rangeClosed(precedingStart, currentElement - 1).boxed().collect(Collectors.toList());
    }


}