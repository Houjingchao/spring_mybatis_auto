package com.jaf.test;

import com.jaf.entity.User;
import com.jaf.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.util.List;

/**
 * Created by jaf on 16/8/19.
 */
public class SpringBatis {
    ApplicationContext context = null;
    UserService userService = null;

    /**
     * @before 需要引入junit 包
     */
    @Before
    public void initContext() {

        /*
        * 注意与另一种方式的区别
        * */
        this.context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //this.context = new FileSystemXmlApplicationContext("WebRoot/WEB-INF/applicationContext.xml");
        this.userService = (UserService) context.getBean("userService");
    }

    @Test
    public void countAll() {
        System.out.println("数据库中的记录条数:" + userService.countAll());
    }

    @Test
    public void insert() {
        User user = new User();
        user.setUsername("苏若年");
        user.setPassword("passtest");
        user.setEmail("dennisit@163.com");
        user.setSex("男");
        user.setAge(23);
        userService.insert(user);
    }

    @Test
    public void selectAll() {
        List<User> list = userService.selectAll();
        for (int i = 0; i < list.size(); i++) {
            User user = list.get(i);
            System.out.println("用户名:" + user.getUsername() + "\t密码:" + user.getPassword() + "\t邮箱：" + user.getEmail());
        }
    }

    @Test
    public void update() {
        User user = new User();
        user.setUsername("jaf");
        user.setPassword("1234567");
        user.setEmail("1234567@qq.com");
        user.setSex("男");
        user.setAge(33);
        userService.update(user);
    }

    @Test
    public void delete() {
        userService.delete("jaf");
    }

    @Test
    public void findByName() {
        User user = userService.findByUserName("jaf");
        System.out.println("用户名:" + user.getUsername() + "\t密码:" + user.getPassword() + "\t邮箱：" + user.getEmail());

    }
}