package ie.atu.week6;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService myService;

    public ProductController(ProductService myService) {
        this.myService = myService;
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return myService.getAllProducts();
    }

    @PostMapping
    public ResponseEntity<Product> newProduct(@Valid @RequestBody Product product) {
        return ResponseEntity.ok(myService.addProduct(product));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Integer id, @Valid @RequestBody Product updatedProduct) {
        Product updated = myService.updateProduct(id, updatedProduct);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Integer id) {
        boolean removed = myService.deleteProduct(id);
        return removed ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}

