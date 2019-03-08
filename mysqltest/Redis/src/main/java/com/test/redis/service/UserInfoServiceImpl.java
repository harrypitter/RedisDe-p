package com.test.redis.service;

import com.test.redis.domain.UserInfo;
import com.test.redis.domain.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    UserInfoRepository userRepository;



    public void saveData(UserInfo userInfo){
        String id = UUID.randomUUID().toString().replace("-", "").substring(0, 8);

        userInfo = new UserInfo(id,"123",20);
        userRepository.save(userInfo);
    }



    public void saveData(String name,int age){

        UserInfo userInfo = new UserInfo(getRandomId(),name,age);
        userRepository.save(userInfo);
    }

    @Override
    public UserInfo findById(String id) {
       return userRepository.findOneById(id);
    }


    private String getRandomId()
    {
        String currentDate = (new SimpleDateFormat("yyyyMMddHHmm")).format(new Date());
        String uuid = UUID.randomUUID().toString().replace("-", "").substring(0, 4);
        return "ID" + currentDate + uuid;
    }
}
