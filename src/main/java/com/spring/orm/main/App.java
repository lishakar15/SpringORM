package com.spring.orm.main;

import com.spring.orm.dao.StudentDao;
import com.spring.orm.dao.StudentDaoImpl;
import com.spring.orm.entities.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("Config.xml");
        StudentDao studentDao = (StudentDao) context.getBean("StudentDaoImpl");
        Student s = new Student("Sam",24);
        studentDao.insert(s);
        s.setAge(26);
        studentDao.update(s);
        studentDao.deleteById(1);
        //Update using HQL query
        studentDao.updateByIdWithHQLQuery(3);
    }
}
