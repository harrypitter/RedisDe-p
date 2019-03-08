package com.test.redis.service;


import com.test.redis.domain.UserInfo;

public interface UserInfoService {

    public void saveData(UserInfo userInfo);

    public void saveData(String name,int age);

    public UserInfo findById(String id);

}
