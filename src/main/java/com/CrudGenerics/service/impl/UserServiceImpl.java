package com.CrudGenerics.service.impl;

import com.CrudGenerics.entity.User;
import com.CrudGenerics.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends BaseServiceImpl<User, Long> {
    public UserServiceImpl(UserRepository repository) {
        super(repository);
    }
}