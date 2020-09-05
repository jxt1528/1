package com.offcn.service;

import com.offcn.pojo.Person;

import java.util.List;

public interface PersonService {
    public void add(Person person);
    public void delete(Long id);
    public void update(Person person);
    public Person findOne(Long id);
    public List<Person> findAll();
}
