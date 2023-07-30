package com.spring.orm.main;

import com.spring.orm.dao.StudentDao;
import com.spring.orm.dao.StudentDaoImpl;
import com.spring.orm.entities.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("Config.xml");
        StudentDao studentDao = (StudentDao) context.getBean("StudentDaoImpl");
        Student s = new Student(1,"Lishakar",24);
        int n = studentDao.insert(s);
        System.out.println("Number of rows inserted = "+n);

    }
}
