package com.cem.test;

import com.cem.dao.UserDao;
import com.cem.daoImpl.UserDaoImpl;
import com.cem.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;

/**
 * Created by RayHauton on 2017/1/25.
 */
public class GetConnection {
    @Test
    public void testFindUserById() throws Exception {
        UserDao userDao = new UserDaoImpl();
        User user = userDao.findUserByStudNum("091401323");
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        System.out.println(user.getMail());
    }
    @Test
    public void testCoonection() {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:config/applicationContext.xml");
        DataSource dataSource = (DataSource) context.getBean("dataSource");
        try {
            System.out.println(dataSource.getConnection());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
