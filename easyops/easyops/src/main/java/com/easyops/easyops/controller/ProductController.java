package com.easyops.easyops.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.easyops.easyops.entity.Product;
import com.easyops.easyops.exception.ResponseMessage;
import com.easyops.easyops.exception.UserException;
import com.easyops.easyops.service.ProductService;

import jakarta.servlet.http.HttpServletRequest;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService service;

    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product) {
        return service.saveProduct(product);
    }

    @PostMapping("/addProducts")
    public List<Product> addProducts(@RequestBody List<Product> products) {
        return service.saveProducts(products);
    }

    @GetMapping("/products")
    public List<Product> findAllProducts() {
        return service.getProducts();
    }

    @GetMapping("/productById/{id}")
    public Product findProductById(@PathVariable int id) {
        return service.getProductById(id);
    }

    @GetMapping("/product/{name}")
    public Product findProductByName(@PathVariable String name) {
        return service.getProductByName(name);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseMessage> updateProduct(@PathVariable int  id , @RequestBody Product product,HttpServletRequest req) throws UserException{
    	try {
         service.updateProduct(id,product);
         return new ResponseEntity<ResponseMessage>(new ResponseMessage("Updated User successfully","Updated",req.getRequestURI()),HttpStatus.OK);
    	}
    	catch (Exception ex) {
    		return new ResponseEntity<ResponseMessage>(new ResponseMessage("Cannot find user with an id:"+id+"",ex.getMessage(), req.getRequestURI()),HttpStatus.NOT_FOUND);
		}
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id) {
        return service.deleteProduct(id);
    }
}
