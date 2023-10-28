package org.sid.inventoryservice;

import org.sid.inventoryservice.entities.Product;
import org.sid.inventoryservice.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(ProductRepository productRepository){
        return args -> {
          productRepository.save(new Product(null, "Laptop", 2000, 100));
          productRepository.save(new Product(null, "Telephone", 1500, 150));
          productRepository.save(new Product(null, "Clavier", 1000, 200));
          productRepository.findAll().forEach(product -> {
              System.out.println(product.getName());
          });
        };
    }
}
