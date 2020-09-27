package springdatajpa.demo;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import springdatajpa.demo.Entities.Product;
import springdatajpa.demo.Repositories.ProductRepository;

import javax.swing.text.html.Option;
import java.util.Arrays;
import java.util.Optional;

@SpringBootTest
class SpringDataApplicationTests {
    @Autowired
  ProductRepository productRepository;
    @BeforeEach
    // create a new product and store it in the db
    public void setup(){
        Product newProduct =  new Product();
        newProduct.setId(2L);
        newProduct.setName("Hp Laptop");
        newProduct.setDescription("Good phone");
        newProduct.setPrice(5245d);
        productRepository.save(newProduct);
    }

    @AfterEach
    // DELETE THE RECORD FROM DB AFTER RUNNING EACH METHOD
    public  void  setUpForAfterEach(){
        productRepository.deleteById(2L);
    }

    @Test
    void contextLoads() {
    }

    @Test
    void createProduct(){

        Product newProduct =  new Product();
        newProduct.setId(3L);
        newProduct.setName("Hp Laptop");
        newProduct.setDescription("Good phone");
        newProduct.setPrice(5105d);
        productRepository.save(newProduct);
        Optional<Product> product = productRepository.findById(3L);
        Product product1 = null;

        if (product.isPresent()){
            product1 =  product.get();
        }


        Object[] actual =  new Object[4];
        actual[0] = product1.getId();
        actual[1] = product1.getName();
        actual[2] = product1.getDescription();
        actual[3] = product1.getPrice();

        Object[] expected =  new Object[4];
        expected[0] = newProduct.getId();
        expected[1] = newProduct.getName();
        expected[2] = newProduct.getDescription();
        expected[3] = newProduct.getPrice();
        Assertions.assertArrayEquals(expected , actual);
    }

    // create




 // method to test read operation
    @Test
    void testReadOperation(){
        Optional<Product> getProduct =  productRepository.findById(2L);
        Product product =  null;
                if (getProduct.isPresent()){
                    product = getProduct.get();
                }
        Assertions.assertNotNull(getProduct);
        Assertions.assertEquals(2, product.getId());
    }

    @Test
    void updateRecord(){
        Optional<Product> getProduct =  productRepository.findById((long) 2);
         Product  product =  null;
        if (getProduct.isPresent()){
             product =  getProduct.get();
        }
            // update the product
        product.setPrice(100D);
        product.setDescription("updated  Description");

        // save the updated copy
        productRepository.save(product);

        // get the updated record from the db
        Optional<Product>  getUpdatedProduct = productRepository.findById(2L);
        Product updatedProduct =  null;
        if (getUpdatedProduct.isPresent()){
            updatedProduct = getUpdatedProduct.get();
        }

        Assertions.assertNotNull(updatedProduct);
        Assertions.assertEquals(100, updatedProduct.getPrice());
        Assertions.assertEquals("updated  Description", updatedProduct.getDescription());
    }


    @Test
    // should not return deleted message
    void deleteRecord() {
       // create a new product which will be deleted latter
        Product newProduct =  new Product();
        newProduct.setId(5L);
        newProduct.setName("Hp Laptop");
        newProduct.setDescription("hahahahahahahahha");
        newProduct.setPrice(5245d);
        productRepository.save(newProduct);
        // delete the product from the db
        if (productRepository.existsById(5L)) {
            System.out.println("deleting product");
            productRepository.deleteById(5L);
        }

        //try to get the deleted record from the db
        Product getProduct = productRepository.findProductById(5L);
        // try to get the product from the db
        Assertions.assertNull(getProduct);
    }

}