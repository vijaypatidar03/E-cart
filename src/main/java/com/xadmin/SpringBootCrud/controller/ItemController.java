package com.xadmin.SpringBootCrud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.xadmin.SpringBootCrud.bean.Item;
import com.xadmin.SpringBootCrud.service.ItemService;

import java.util.List;

@RestController
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
	//getting all items
	@RequestMapping("/item")
	public List<Item> getAllItems()
	{
		return itemService.getAllItems();
	}
	 //insert data
	@RequestMapping(method = RequestMethod.POST, value="/item")
	public String addItem(@RequestBody Item item)
	{
		itemService.addItem(item);
		return "Record Inserted ";
	}
	//update items
	@RequestMapping(method = RequestMethod.PUT, value="/item/{id}")
	public String updateItem(@PathVariable Long id ,@RequestBody Item item)
	{
		itemService.updateItem(id , item);
		return "Record Updated ";
	}
	//delete
	@RequestMapping(method = RequestMethod.DELETE, value="/item/{id}")
	public String DeleteItem(@PathVariable Long id)
	{
		itemService.deleteItem(id);
		return "Data Deleted ";
	}
}
