package com.sum.product.preceding;

import com.sum.product.preceding.process.SumOfPrecedingProducts;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class Application implements CommandLineRunner {

    private final Logger log = LoggerFactory.getLogger(getClass());

    SumOfPrecedingProducts sumOfPrecedingProducts;

    public static void main(String[] args) {
        new SpringApplicationBuilder(Application.class).run(args).close();
    }

    @Override
    public void run(String... args) throws Exception {

        try {

            sumOfPrecedingProducts = new SumOfPrecedingProducts(Integer.parseInt(args[0]), Integer.parseInt(args[1]),
                    Integer.parseInt(args[2]));
            sumOfPrecedingProducts.calculateSumOfProducts();

        } catch (NumberFormatException e) {
            log.error("***--------- Illegal arguments. Please pass 3 integers as input ---------***");
        }


    }
}
