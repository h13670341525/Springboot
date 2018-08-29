package com.dhu.dao;

import com.dhu.domain.Course;

import java.util.List;

public interface CourseDao {
    Course findCourseById(int course_id);
    List<Course> findCoursesByTutorId(int tutor_id);
    List<Course> findCoursesByStudentId(int student_id);
}
