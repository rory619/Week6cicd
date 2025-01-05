package ie.atu.week6;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class ProductService {
    private final List<Product> myList = new ArrayList<>();

    public List<Product> getAllProducts() {
        return myList;
    }

    public Product addProduct(Product product) {
        myList.add(product);
        return product;
    }

    public Product updateProduct(Integer id, Product updatedProduct) {
        for (int i = 0; i < myList.size(); i++) {
            Product existingProduct = myList.get(i);
            if (Objects.equals(existingProduct.getId(), id)) {
                myList.set(i, updatedProduct);
                return updatedProduct;
            }
        }
        return null;
    }

    public boolean deleteProduct(Integer id) {
        return myList.removeIf(p -> Objects.equals(p.getId(), id));
    }
}

