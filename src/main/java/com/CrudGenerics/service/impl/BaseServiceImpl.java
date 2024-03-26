package com.CrudGenerics.service.impl;

import com.CrudGenerics.service.BaseService;
import org.springframework.beans.BeanUtils;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

public abstract class BaseServiceImpl <T, ID> implements BaseService<T, ID> {
    private final JpaRepository<T, ID> repository;

    public BaseServiceImpl(JpaRepository<T, ID> repository) {
        this.repository = repository;
    }

    @Override
    public T findById(ID id) {
        Optional<T> optional = repository.findById(id);
        return optional.orElse(null);
    }

    @Override
    public List<T> findAll() {
        return repository.findAll();
    }

    @Override
    public T deleteById(ID id) {
        Optional<T> optional = repository.findById(id);
        if (optional.isPresent()) {
            T entity = optional.get();
            repository.deleteById(id);
            return entity;
        }
        return null;
    }

    @Override
    public T save(T entity) {
        return repository.save(entity);
    }

    @Override
    public T update(ID id, T entity) {
        if (repository.existsById(id)) {
            return repository.save(entity);
        }
        return null;
    }
}
