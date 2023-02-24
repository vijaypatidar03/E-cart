package com.xadmin.SpringBootCrud.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xadmin.SpringBootCrud.bean.Cart;
import com.xadmin.SpringBootCrud.bean.Item;
import com.xadmin.SpringBootCrud.service.CartService;
import com.xadmin.SpringBootCrud.service.ItemService;

@RestController
@CrossOrigin("*")
@RequestMapping("/cart")
public class CartController {

	@Autowired
	private CartService cartService;
	
	@Autowired
	private ItemService itemService;

	// insert data
	@RequestMapping(method = RequestMethod.POST, value = "/cart")
	public String addCart(@RequestBody Cart cart) {
		cartService.addCart(cart);
		return "Record Inserted ";
	}
	
	//getting all items
	@RequestMapping("/list/{cid}")
	public Set<Item> getItems(@PathVariable Long cid)
	{
		System.out.print("cid"+cid); 	
		Cart cart = new Cart(Long.valueOf(cid));
		cart.setCid(Long.valueOf(cid) );
		Set<Item> list = this.itemService.getItemOfCart(cart);
		System.out.println("length of list "+list.size());
		return list;
	}

	// delete
	@RequestMapping(method = RequestMethod.DELETE, value = "/cart/{id}")
	public String DeleteItem(@PathVariable Long cid) {
		cartService.deleteCart(cid);
		return "Data Deleted ";
	}
}
