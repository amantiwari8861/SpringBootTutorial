package com.amazon.seller.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazon.seller.model.Seller;
import com.amazon.seller.service.SellerService;

@Service
public class SellerServiceImpl implements SellerService{
    @Autowired
    com.amazon.seller.repository.SellerRepository SellerRepository;
  
    @Override
    public List<Seller> getAllSellers(){
        return SellerRepository.findAll();
    }

    @Override
    public Seller getSellerByEmail(String email){
        Optional<Seller> Seller=SellerRepository.getSellerByEmail(email);
        if(Seller.isPresent())
            return Seller.get();
        else
            return null;
    }

    @Override
    public Seller getSellerByMobile(String mobile){
        Optional<Seller> Seller=SellerRepository.getSellerByMobile(mobile);
        if(Seller.isPresent())
            return Seller.get();
        else
            return null;
    }

    @Override
    public Seller getSellerByEmailOrMobile(String email,String mobile){
        Optional<Seller> Seller=SellerRepository.getSellerByEmailOrMobile(email, mobile);
        if(Seller.isPresent())
            return Seller.get();
        else
            return null;
    }

    @Override
    public Seller getSellerByEmailAndMobile(String email,String mobile){
        Optional<Seller> Seller=SellerRepository.getSellerByEmailAndMobile(email, mobile);
        if(Seller.isPresent())
            return Seller.get();
        else
            return null;
    }

    @Override
    public Seller getSellerByEmailOrMobileAndPassword(String username,String password){
        Optional<Seller> Seller=SellerRepository.getSellerByEmailOrMobileAndPassword(username, password);
        if(Seller.isPresent())
            return Seller.get();
        else   
            return null;
    }

    @Override
    public void deleteSeller(long id){
        SellerRepository.deleteById(id);
    }

    @Override
    public Seller createSeller(Seller Seller){
        return SellerRepository.save(Seller);
    }

    @Override
    public void changePassword(String password,long id){
        SellerRepository.changePassword(password,id);
    }
}
