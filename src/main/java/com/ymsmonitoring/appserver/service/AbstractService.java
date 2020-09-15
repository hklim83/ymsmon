package com.ymsmonitoring.appserver.service;


import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import com.ymsmonitoring.appserver.model.AbstractModel;

import java.io.Serializable;
import java.util.Optional;

public abstract class AbstractService<T extends AbstractModel<Long>, Long extends Serializable> {

    private static final int PAGE_SIZE = 5;


    public Page<T> getList(Integer pageNumber) {
    	return null;
    }

    public T save(T entity) {
    	return null;
    }

    public T get(Long id) {
    	return null;
    }

    public void delete(Long id) {

    }

    public void update(T entity) {
       
    }

}