package br.com.ecommerce.service;

import br.com.ecommerce.repository.ProductRepository;
import br.com.ecommerce.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product getProductsById(Integer productId){
        Optional<Product> optionalProduct = productRepository.findById(productId);
        if(optionalProduct.isPresent()){
            Product product = optionalProduct.get();
            return product;
        }else{
            return null;
        }
    }

    public void addNewProduct(String name, Double price, Integer category){
        Product newProduct = new Product();
        newProduct.setProduct_name(name);
        newProduct.setProduct_price(price);
        newProduct.setCategories_id(category);
        productRepository.save(newProduct);
    }

    public List<Product> getProductsByName(String name){
        return productRepository.findProductsByName(name);
    }

    public List<Product> getProductsByCategoryId(Integer categoryId) {
        return productRepository.getProductsByCategoryId(categoryId);
    }

    public List<Product> getProductsByCartId(Integer cartId) {
        return productRepository.getProductsByCartId(cartId);
    }
}
