package com.test.redis.domain;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserInfoRepository extends PagingAndSortingRepository<UserInfo, String> {
    public UserInfo findOneById(String id);

}
