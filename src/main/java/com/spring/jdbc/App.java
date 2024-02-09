package com.spring.jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.entities.Student;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Started..." );
        //Spring jdbcTemplate
        ApplicationContext applicationContext =
        		new AnnotationConfigApplicationContext(JdbcConfig.class);
        JdbcTemplate template = applicationContext.getBean("jdbcTemplate",JdbcTemplate.class);

        StudentDao studentDao = applicationContext.getBean("studentDao",StudentDao.class);
        
        //INSERT
        
//        Student student = new Student();
//        student.setId(676);
//        student.setName("Johnny");
//        student.setCity("Lucknow");
//        
//        int result =studentDao.insert(student);
//        System.out.println("student indian result");
        
        //UPDATE
        
//        Student student = new Student();
//        student.setId(676);
//        student.setName("Johnny Depp");
//        student.setCity("New York");
//        
//        int result =studentDao.change(student);
//        System.out.println("data changed " + result);
        
        //DELETE
       
//        int result =studentDao.delete(457);
//      System.out.println("data deleted " + result);
        
        //Get a single student object
        
//        Student student = studentDao.getStudent(222);
//        System.out.println(student);
        
        //Get multiple student object
        
        List<Student> allStudent = studentDao.getAllStudent();
        for (Student student : allStudent) {
			System.out.println(student);
		}
        
        
    }
}
