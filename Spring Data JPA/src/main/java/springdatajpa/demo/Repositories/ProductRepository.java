package springdatajpa.demo.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;
import springdatajpa.demo.Entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findProductById(Long id);
}
