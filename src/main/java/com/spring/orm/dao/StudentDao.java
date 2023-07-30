package com.spring.orm.dao;

import com.spring.orm.entities.Student;

import java.util.List;

public interface StudentDao {
    public int insert(Student student);
    public void update(Student student);
    public void deleteById(int id);
    public void delete(Student student);
    public Student getStudentById(int id);
    public List<Student> getStudentList();
    public  void updateByIdWithHQLQuery(int id);

}
