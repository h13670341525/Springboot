package com.dhu.dao;

import com.dhu.domain.Tutor;

import java.util.List;

public interface TutorDao {
     Tutor findTutorById(int tutor_id);
     List<Tutor> findAllTutors();
}
