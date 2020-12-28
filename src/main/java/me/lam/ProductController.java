package me.lam;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @Autowired
    ProductRespository productRespository;

    @GetMapping("/product")
    public List<Product> index(){
        return productRespository.findAll();
    }

    @GetMapping("/product/{id}")
    public Product show(@PathVariable String id){
        int blogId = Integer.parseInt(id);
        Product product = null;
        try {
        	product = productRespository.findOne(blogId);
        } catch(Exception ex) {
        	System.out.println(ex.getMessage());
        }
//        Category category = product.getCategory();
        return product;
    }

    @PostMapping("/product/search")
    public List<Product> search(@RequestBody Map<String, String> body){
        String searchTerm = body.get("name");
        Float price = Float.parseFloat(body.get("price"));
        return productRespository.findByNameContainingOrPriceContaining(searchTerm, price);
    }

//    @PostMapping("/blog")
//    public Product create(@RequestBody Map<String, String> body){
//        Category
//    	String title = body.get("title");
//        String content = body.get("content");
//        return productRespository.save(new Product(category, name, price));
//    }

//    @PutMapping("/blog/{id}")
//    public Product update(@PathVariable String id, @RequestBody Map<String, String> body){
//        int blogId = Integer.parseInt(id);
//        // getting blog
//        Product blog = productRespository.findOne(blogId);
//        blog.setTitle(body.get("title"));
//        blog.setContent(body.get("content"));
//        return productRespository.save(blog);
//    }

//    @DeleteMapping("blog/{id}")
//    public boolean delete(@PathVariable String id){
//        int blogId = Integer.parseInt(id);
//        productRespository.delete(blogId);
//        return true;
//    }


}