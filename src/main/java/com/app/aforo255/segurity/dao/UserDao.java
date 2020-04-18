package com.app.aforo255.segurity.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.app.aforo255.segurity.models.entity.User;

public interface UserDao extends PagingAndSortingRepository<User, Long> {
	public User findByUsername(@Param("nombre") String username);
}
