package com.dhu.dao;

import com.dhu.domain.Student;

import java.util.List;

public interface StudentDao {
    Student findStudentById(int student_id);
    List<Student> findStudentsByCourseId(int course_id);
}
