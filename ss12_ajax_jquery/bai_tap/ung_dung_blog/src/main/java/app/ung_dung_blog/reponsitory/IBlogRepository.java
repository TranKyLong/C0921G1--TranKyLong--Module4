package app.ung_dung_blog.reponsitory;

import app.ung_dung_blog.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IBlogRepository extends JpaRepository<Blog, Integer> {

    Blog findAllById(Integer id);

    @Query(value = "  select * from blog b " +
            " LEFT join category c on b.cate_id_cate_id = c.cate_id ",

            nativeQuery = true)
    List<Blog> getBlogList();

    @Query(value = "  select * from blog b " +
            " LEFT join category c on b.cate_id_cate_id = c.cate_id where c.cate_id = :cateId ",
            countQuery = " select count(*) from blog b LEFT join category c on b.cate_id_cate_id = c.cate_id where c.cate_id = :cateId ",
            nativeQuery = true)
    List<Blog> getBlogListById(@Param("cateId") Integer cateId);

    @Query(value = "  select * from blog b " +
            " LEFT join category c on b.cate_id_cate_id = c.cate_id where b.id = :blogId ",
            countQuery = " select count(*) from blog b LEFT join category c on b.cate_id_cate_id = c.cate_id where b.id = :blogId ",
            nativeQuery = true)
    List<Blog> getBlogDetailById(@Param("blogId") Integer blogId);

    List<Blog> findAllByTitleContaining(String title);
}
