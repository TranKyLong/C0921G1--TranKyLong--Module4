package vn.codegym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository; //hỗ trợ thêm phân trang sắp xếp
import org.springframework.data.repository.CrudRepository; //định nghĩa những phương thức CRUD
import org.springframework.data.repository.Repository; //quản lý entity, kiểu dữ liệu của entity
import org.springframework.data.repository.query.Param;
import vn.codegym.model.Student;

import java.util.List;

public interface IStudentRepository extends JpaRepository<Student, Integer> {
    List<Student> findAllByOrderByIdDesc();

    List<Student> findByName(String name);

    List<Student> findByNameContaining(String keyword);

    List<Student> findByNameContainingAndIdGreaterThan(String keyword, int id);

    @Query(value = "select * from Student  where name=:keyword", nativeQuery = true)
    List<Student> searchByName(@Param("keyword") String keyword);
}
