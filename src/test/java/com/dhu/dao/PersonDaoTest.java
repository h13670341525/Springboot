package com.dhu.dao;

import com.dhu.domain.Address;
import com.dhu.domain.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class PersonDaoTest {
    @Autowired
    private PersonDao personDao;
    @Test
    public void insertPerson(){
        Person person=new Person();
        Address address=new Address();
        address.setAddress_id(1);
        person.setPerson_name("cherish");
        person.setAddress(address);
        personDao.insertPerson(person);
    }
    @Test
    public void findPersonById(){
        Person person=personDao.findPersonById(1);
        System.out.println(person.getPerson_name());
        System.out.println(person.getAddress().getAddress_name());
    }
}
