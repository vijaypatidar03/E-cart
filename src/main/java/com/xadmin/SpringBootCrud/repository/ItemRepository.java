package com.xadmin.SpringBootCrud.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xadmin.SpringBootCrud.bean.Cart;
import com.xadmin.SpringBootCrud.bean.Item;

public interface ItemRepository extends JpaRepository<Item,Long> {

	public Set<Item> findByCart(Cart cart);
}
