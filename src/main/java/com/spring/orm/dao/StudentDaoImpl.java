package com.spring.orm.dao;

import com.spring.orm.entities.Student;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.hibernate.Query;
import java.util.List;

@Service
public class StudentDaoImpl implements StudentDao {
    private HibernateTemplate hibernateTemplate;

    public StudentDaoImpl(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    public StudentDaoImpl()
    {

    }
    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    @Override
    @Transactional
    public int insert(Student student) {
        return (int) this.hibernateTemplate.save(student);
    }

    @Override
    @Transactional
    public void update(Student student) {
        this.hibernateTemplate.update(student);
    }



    @Override
    @Transactional
    public void deleteById(int id) {
        this.hibernateTemplate.delete(getStudentById(id));
    }

    @Override
    @Transactional
    public void delete(Student student) {
        this.hibernateTemplate.delete(student);
    }
    @Override
    public Student getStudentById(int id) {
        Student s = this.hibernateTemplate.get(Student.class,id);
        //Student s = this.hibernateTemplate.load(Student.class,id);
        return s;
    }

    @Override
    public List<Student> getStudentList() {
        List<Student> students = this.hibernateTemplate.loadAll(Student.class);
        return students;
    }

    @Override
    @Transactional
    public void updateByIdWithHQLQuery(int id) {
        //This is a example of using Hibernate's method
        SessionFactory factory =this.hibernateTemplate.getSessionFactory();
        Session session = factory.openSession();
        Query query = session.createQuery("update Student s set s.name=:x where s.id =:y");
        query.setParameter("x","Ronaldo");
        query.setParameter("y",id);
        Transaction tx = session.getTransaction();
        tx.begin();
        query.executeUpdate();
        tx.commit();
        session.close();
    }

}
