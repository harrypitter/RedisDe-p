package com.test.demo.web;

import com.test.demo.domain.Department;
import com.test.demo.service.UserService;
import com.test.demo.service.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class TestController {

    @Autowired
    UserService userService;

    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    @RequestMapping("depart")
    public void save(){
        logger.info("存储信息");
        System.out.println("save info");
        userService.saveDE(new Department());
    }

    @RequestMapping("departl/{der}")
    @ResponseBody
    public String save(@PathVariable String der){
        logger.info("存储信息");
        System.out.println("save info");
        userService.saveDE(der);
        return "saved";
    }

}
