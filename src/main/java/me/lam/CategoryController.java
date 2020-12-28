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
public class CategoryController {

    @Autowired
    CategoryRespository categoryRespository;

    @GetMapping("/category")
    public List<Category> index(){
        return categoryRespository.findAll();
    }

    @GetMapping("/category/{id}")
    public Category show(@PathVariable String id){
        int blogId = Integer.parseInt(id);
        return categoryRespository.findOne(blogId);
    }

//    @PostMapping("/product/search")
//    public List<Category> search(@RequestBody Map<String, String> body){
//        String searchTerm = body.get("name");
//        Float price = Float.parseFloat(body.get("price"));
//        return productRespository.findByNameContainingOrPriceContaining(searchTerm, price);
//    }

}