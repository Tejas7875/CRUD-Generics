package com.CrudGenerics.service;

import java.util.List;

public interface BaseService <T,ID>{
    T save(T entity);
    T findById(ID id);
    List<T> findAll();
    T deleteById(ID id);
    T update(ID id, T entity);
}
