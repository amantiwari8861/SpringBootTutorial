package com.amazon.product.controller;

import java.io.IOException;
import java.util.Date;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.amazon.product.general.FileUploadUtil;
import com.amazon.product.model.Product;
import com.amazon.product.service.ProductService;

@Controller
public class URLController {

    @Autowired
    ProductService productService;
    
    @GetMapping("/")
    public String root(){
        return "index";
    }

    @GetMapping("/upload")
    public String upload(){
        return "upload";
    }

    @PostMapping("/Upload")
    public String uploadFile(@RequestParam("productTitle")String productTitle,@RequestParam("shortDescription")String shortDescription,@RequestParam("price")float price,@RequestParam("productImage")MultipartFile productImage) throws IOException{
        Product product=new Product();
        product.setPrice(price);
        product.setProductTitle(productTitle);
        product.setShortDescription(shortDescription);
        product.setRecordCreated(new Date().toString());
        String pImage=StringUtils.cleanPath(productImage.getOriginalFilename().trim());
        product.setProductImage(pImage);
        Product productAdded=productService.createProduct(product);

        String uploadProductImageDir="src/main/resources/static/productImages/"+productAdded.getId();
        
        FileUploadUtil.saveFile(uploadProductImageDir, pImage, productImage);

        return "success";
    }

    @GetMapping("/success")
    public String success(){
        return "success";
    }
}
