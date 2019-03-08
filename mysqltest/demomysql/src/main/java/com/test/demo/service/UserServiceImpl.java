package com.test.demo.service;

import com.test.demo.domain.Department;
import com.test.demo.domain.DepartmentRepository;
import com.test.demo.domain.User;
import com.test.demo.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    DepartmentRepository departmentRepository;

    public User saveUser(User user){

        return userRepository.save(user);
    }

    public void saveDE(Department department){

        department = new Department(345L,"123",new Date());
        departmentRepository.save(department);
    }

    public void saveDE(String departmentStr){

        Department department = new Department(678L,departmentStr,new Date());
        departmentRepository.save(department);
    }

}
