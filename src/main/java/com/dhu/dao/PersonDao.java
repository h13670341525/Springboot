package com.dhu.dao;

import com.dhu.domain.Person;

public interface PersonDao {
      void insertPerson(Person person);
      Person findPersonById(int person_id);
}
