package com.xadmin.SpringBootCrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.xadmin.SpringBootCrud.bean.Cart;

@Service
public interface CartRepository extends JpaRepository<Cart, Long>{

}
