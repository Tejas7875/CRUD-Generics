package com.CrudGenerics.controller;

import com.CrudGenerics.service.BaseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public abstract class BaseGenericController<T,ID> {
    protected final BaseService<T, ID> service;

    public BaseGenericController(BaseService<T, ID> service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<T> create(@RequestBody T entity) {
        T savedEntity = service.save(entity);
        return new ResponseEntity<>(savedEntity, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<T> getById(@PathVariable ID id) {
        T entity = service.findById(id);
        if (entity == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(entity, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<T>> getAll() {
        List<T> entities = service.findAll();
        return new ResponseEntity<>(entities, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<T> update(@PathVariable ID id, @RequestBody T entity) {
        T updatedEntity = service.update(id, entity);
        if (updatedEntity == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updatedEntity, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<T> delete(@PathVariable ID id) {
        T deletedEntity = service.deleteById(id);
        if (deletedEntity != null) {
            return new ResponseEntity<>(deletedEntity,HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
