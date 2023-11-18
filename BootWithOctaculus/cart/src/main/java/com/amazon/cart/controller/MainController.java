package com.amazon.cart.controller;

import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.amazon.cart.model.Product;
import com.amazon.cart.service.ProductService;

@Controller
public class MainController {

    @Autowired
    ProductService productService;


    @GetMapping("/add-product")
    public String add_product(){
        return "add-product";
    }

    @PostMapping("/addProduct")
    public String addProduct(@ModelAttribute("Product")Product product,Model model,HttpSession session){
        product.setRecordCreated(new Date().toString());
        productService.createProduct(product);
        model.addAttribute("products", productService.getAllProducts());
        model.addAttribute("count", session.getAttribute("count")==null?0:(int)session.getAttribute("count"));
        return "products";
    }

    @GetMapping("/products")
    public String products(Model model,HttpSession session){
        model.addAttribute("products", productService.getAllProducts());
        model.addAttribute("count", session.getAttribute("count")==null?0:(int)session.getAttribute("count"));
        return "products";
    }

    @PostMapping("/addToCart")
    public String addToCart(Model model,HttpSession session,@RequestParam("id")long id,@RequestParam("title")String title,@RequestParam("price")float price,@RequestParam("description")String description,@RequestParam("quantity")int quantity){
        Product product=new Product();
        product.setId(id);
        product.setTitle(title);
        product.setPrice(price);
        product.setDescription(description);
        product.setQuantity(quantity);
        ArrayList<Product> cart=new ArrayList<Product>();
        if(session.getAttribute("cart")!=null){
            cart.addAll((ArrayList<Product>)session.getAttribute("cart"));
            // for(Product prod:(ArrayList<Product>)session.getAttribute("cart")){
            // cart.add(prod);
            // }
        }
        // for (Product p : cart) {
        //     if (p.getId()==product.getId()) {
        //         product.setQuantity(p.getQuantity()+1);
        //         cart.remove(p);
        //     }
        // }
        cart.add(product);
        model.addAttribute("products", productService.getAllProducts());
        session.setAttribute("cart", cart);
        session.setAttribute("count", session.getAttribute("count")==null?1:(int)session.getAttribute("count")+1);
        return "products";
    }

    @GetMapping("/cart")
    public String cart(){
        return "cart";
    }
}
