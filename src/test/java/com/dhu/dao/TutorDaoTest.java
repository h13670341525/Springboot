package com.dhu.dao;

import com.dhu.domain.Course;
import com.dhu.domain.Tutor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TutorDaoTest {
    @Autowired
    private TutorDao tutorDao;
    @Test
    public void findTutorById(){
        Tutor tutor=tutorDao.findTutorById(1);
        System.out.println(tutor.getTutor_name());
        System.out.println(tutor.getCourses().size());
        for(Course course:tutor.getCourses()){
            System.out.println(course.getCourse_name());
        }
    }
    @Test
    public  void findAllTutors(){
        List<Tutor> tutors=tutorDao.findAllTutors();
        for(Tutor tutor:tutors){
            System.out.println(tutor.getTutor_name());
            for(Course course:tutor.getCourses()){
                System.out.println(course.getCourse_name());
            }
        }
    }
}
