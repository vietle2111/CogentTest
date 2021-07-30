package cogent.ecommerce.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;

import cogent.ecommerce.entity.Product;

@CrossOrigin()
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	Page<Product> findByCategoryId(@RequestParam("id") Long id, Pageable pageable);

	Page<Product> findByNameContaining(@RequestParam("name") String name, Pageable pageable);
}
