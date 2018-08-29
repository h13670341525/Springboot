package com.dhu.dao;

import com.dhu.domain.Course;
import com.dhu.domain.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class StudentDaoTest {
    @Autowired
    private StudentDao studentDao;
    @Test
    public void findStudentById(){
        Student student=studentDao.findStudentById(1);
        System.out.println(student.getStudent_name());
        for(Course course:student.getCourses()){
            System.out.println(course.getCourse_name());
            for(Student student1:course.getStudents()){
                System.out.println(" "+student1.getStudent_name());
                for(Course course1:student1.getCourses()){
                    System.out.println("  "+course1.getCourse_name());
                }
            }
        }
    }
}
