package com.cdac.daooperation;

import org.springframework.data.repository.CrudRepository;

import com.cdac.dao.entity.Book;

public interface BookRepository extends CrudRepository<Book, Integer>{

}
