package com.whm.usercenter.service;
import java.util.Date;

import com.whm.usercenter.model.domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;
/*
* 用户服务测试
*
* @author whm
* */

@SpringBootTest
public class UserServiceTest {

    @Resource
    private UserService userService;

    @Test
    public void testAddUser() {
        User user = new User();
        user.setUsername("testWhm");
        user.setUserAccount("123");
        user.setAvatarUrl("https://gips3.baidu.com/it/u=2776647388,3101487920&fm=3074&app=3074&f=PNG?w=2048&h=2048");
        user.setGender(0);
        user.setUserPassword("xxx");
        user.setPhone("123");
        user.setEmail("456");
        user.setPlanetCode("1");
        boolean result = userService.save(user);
        System.out.println(user.getId());
        assertTrue(result);
    }
    @Test
    public void testDeleteUser() {
    }

    @Test
    void userRegister() {
        String userAccount="wwhm";
        String userPassword="";
        String checkPassword="123456";
        String planetCode="1";
        long result = userService.userRegister(userAccount, userPassword, checkPassword, planetCode);
        Assertions.assertEquals(-1, result);
        userAccount="whm";
        result = userService.userRegister(userAccount, userPassword, checkPassword, planetCode);
        Assertions.assertEquals(-1, result);
        userAccount="wwhm";
        userPassword="123456";
        result = userService.userRegister(userAccount, userPassword, checkPassword, planetCode);
        Assertions.assertEquals(-1, result);
        userAccount="w h m";
        userPassword="12345678";
        result = userService.userRegister(userAccount, userPassword, checkPassword, planetCode);
        Assertions.assertEquals(-1, result);
        checkPassword="123456789";
        result = userService.userRegister(userAccount, userPassword, checkPassword, planetCode);
        Assertions.assertEquals(-1, result);
        userAccount="testWhm";
        checkPassword="12345678";
        result = userService.userRegister(userAccount, userPassword, checkPassword, planetCode);
        Assertions.assertEquals(-1, result);
        userAccount="wwhm";
        result = userService.userRegister(userAccount, userPassword, checkPassword, planetCode);
        Assertions.assertEquals(-1, result);

    }
}