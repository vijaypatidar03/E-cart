package com.xadmin.SpringBootCrud.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xadmin.SpringBootCrud.bean.Cart;
import com.xadmin.SpringBootCrud.bean.Item;
import com.xadmin.SpringBootCrud.repository.ItemRepository;

@Service
public class ItemService {

	@Autowired
	public ItemRepository itemRepo;

	public List<Item> getAllItems() {
		List<Item> items = new ArrayList<>();
		itemRepo.findAll().forEach(items::add);
		return items;
	}

	public void addItem(Item item) {
		itemRepo.save(item);
	}

	public void updateItem(Long id, Item item) {
		itemRepo.save(item);
	}

	public void deleteItem(Long id) {
		itemRepo.deleteById(id);
	}
	
	public Set<Item> getItemOfCart(Cart cart)
	{
		System.out.print(cart.getCid()); 
		
		return this.itemRepo.findByCart(cart);
	}
}
