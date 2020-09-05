package com.offcn.service.Impl;

import com.offcn.dao.PersonDao;
import com.offcn.pojo.Person;
import com.offcn.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    private PersonDao personDao;

    @Override
    public void add(Person person) {
        personDao.save(person);
    }

    @Override
    public void delete(Long id) {
        personDao.deleteById(id);
    }

    @Override
    public void update(Person person) {
        personDao.save(person);
    }

    @Override
    public Person findOne(Long id) {

        return personDao.findById(id).get();
    }

    @Override
    public List<Person> findAll() {
        return personDao.findAll();
    }
}
