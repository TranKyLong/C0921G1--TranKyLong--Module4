package vn.codegym.repository;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import vn.codegym.model.Student;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Repository
public class StudentRepositoryImpl implements IStudentRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Student> findAll() {
        TypedQuery<Student> query = entityManager
                .createQuery("SELECT s FROM Student as s", Student.class);
        return query.getResultList();

    }

    @Override
    public void save(Student student) {
       entityManager.persist(student);
    }

    @Override
    public Student findByIndex(int id) {
//        return studentList.get(index);
        return entityManager.find(Student.class, id);
    }
}
