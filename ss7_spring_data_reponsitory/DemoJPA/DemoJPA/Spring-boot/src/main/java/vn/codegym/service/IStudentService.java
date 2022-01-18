package vn.codegym.service;

import vn.codegym.model.Student;

import java.util.List;

public interface IStudentService {
    List<Student> findAll();

    void save(Student student);

    Student findById(int index);

    List<Student> searchByName(String keyword);
}
