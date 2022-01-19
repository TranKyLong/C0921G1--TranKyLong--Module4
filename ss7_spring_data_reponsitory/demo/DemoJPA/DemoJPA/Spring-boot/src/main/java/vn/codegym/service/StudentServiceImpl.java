package vn.codegym.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.model.Student;
import vn.codegym.repository.IStudentRepository;

import java.util.List;

@Service
public class StudentServiceImpl implements IStudentService {

    @Autowired
    private IStudentRepository repository;

    @Override
    public List<Student> findAll() {
        return repository.findAllByOrderByIdDesc();
    }

    @Override
    public void save(Student student) {
        repository.save(student);
    }

    @Override
    public Student findById(int id) {
        return  null;
    }

    @Override
    public List<Student> searchByName(String keyword) {
//        return repository.findByName(keyword); // tim kiem tuyet doi
        return repository.findByNameContaining(keyword); //tim kiem tuong doi
//        return repository.findByNameContainingAndIdGreaterThan(keyword, 3); //tim kiem tuong doi nhieu dieu kien
//        return repository.searchByName(keyword); //Tự viết query
    }
}
