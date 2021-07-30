package cogent.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cogent.ecommerce.entity.Product;
import cogent.ecommerce.service.ProductService;

@CrossOrigin
@RestController
@RequestMapping("/product")
public class ProductController {
	@Autowired
	private ProductService ps;
	
	@GetMapping("/all")
	public List<Product> getProducts(){
		return ps.getProducts();
	}
	
	@GetMapping("/{id}")
	public Product getProductById(@PathVariable("id") long id ) {
		return ps.getProductById(id);
	}
	
	@GetMapping("/category/{id}")
	public Page<Product> getProByCateId(@PathVariable("id") long id){
		return ps.getProByCateId(id);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Product> addProduct(@RequestBody Product p){
		return new ResponseEntity<>(ps.addProduct(p), HttpStatus.CREATED);
	}
}
