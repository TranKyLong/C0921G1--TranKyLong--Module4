package app.ung_dung_blog.reponsitory;

import app.ung_dung_blog.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICategoryRepository extends JpaRepository<Category, Integer> {

//    @Query(value = " select cate_id, cate_name from category  ",
//            countQuery = " select  count(cate_id) from category ",
//            nativeQuery = true)
//    List<Category> getCategoryList();
}
