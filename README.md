# sum-of-products-of-preceding

This application calculates the sum of a function across a range of consecutive numbers, from 1 to n (inclusive), 
    where the function returns the product of the *preceding* C elements.   

## To run application
The application can be run in 2 ways after placing input file in specified path:
  1) java -jar preceding-1.0-SNAPSHOT.jar arg1, arg2, arg3, where arg1 is the first element in range, arg2 is the first element in range,
     arg3 is the number of preceding elements for the products
     Eg: for sum of products of preceding 2 elements of [1,2,3,..,5] is : 
     
        java -jar preceding-1.0-SNAPSHOT.jar 1 5 2
        
  2) Import the code to IDE (Intellij, Eclipse) as maven project & run Application.java with program arguments
  
## How to build software
jar file is attached which can be run in java environment.
To build, run :    mvn clean install

