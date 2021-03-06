package com.mrjzhang.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mrjzhang.bean.User;
import com.mrjzhang.service.UserService;

@RestController
@RequestMapping(value="/user/api")
public class UserRestController {
    @Autowired
    private UserService userService;

    @RequestMapping(value="/addUser", method = RequestMethod.POST)
    public boolean addUser(User user) {
      System.out.println("开始新增。。。");
      System.out.println(user);
      return userService.addUser(user);
    }

    @RequestMapping(value="/updateUser", method = RequestMethod.PUT)
    public boolean updateUser(User user) {
      System.out.println("开始更新。。。");
      return userService.updateUser(user);
    }

    @RequestMapping(value="/deleteUser", method = RequestMethod.DELETE)
    public boolean deleteUser(@RequestParam(value = "userId", required = true) int userId) {
      System.out.println("开始删除。。。");
      return userService.deleteUser(userId);
    }

    @RequestMapping(value="/userId", method = RequestMethod.GET)
    public User findUserById(@RequestParam(value = "userId", required = true) int userId) {
      System.out.println("开始查询。。。");
      return userService.findUserById(userId);
    }

    // 需要处理没有找到数据的情况的处理
    @RequestMapping(value="/userName", method = RequestMethod.GET)
    public User findUserByName(@RequestParam(value = "userName", required = true) String userName) {
      System.out.println("开始查询。。。");
      return userService.findUserByName(userName);
    }

    @RequestMapping(value="/userAge", method = RequestMethod.GET)
    public User findUserByAge(@RequestParam(value = "userAge", required = true) int userAge) {
      System.out.println("开始查询。。。");
      return userService.findUserByAge(userAge);
    }

}
