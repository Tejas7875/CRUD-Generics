package com.CrudGenerics.controller;

import com.CrudGenerics.entity.User;
import com.CrudGenerics.service.impl.UserServiceImpl;

import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/users")
public class UserController extends BaseGenericController<User,Long>{
    public UserController(UserServiceImpl service) {
        super(service);
    }
}
