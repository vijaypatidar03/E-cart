package com.xadmin.SpringBootCrud.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xadmin.SpringBootCrud.bean.Cart;
import com.xadmin.SpringBootCrud.bean.Item;
import com.xadmin.SpringBootCrud.repository.CartRepository;

@Service
public class CartService {
	
	@Autowired
	public CartRepository cartRepo;
	
	public List<Cart> getAllItems() {
		List<Cart> items = new ArrayList<>();
		cartRepo.findAll().forEach(items::add);
		return items;
	}
	
	//add items 
	public void addCart(Cart cart){
		cartRepo.save(cart);
	}
	//remove items
	public void deleteCart(Long cid) {
		cartRepo.deleteById(cid);
	}
}
