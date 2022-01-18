package app.reponsitory.impl;

import app.model.Blog;
import app.reponsitory.IBlogReponsitory;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class BlogReponsitoryImpl implements IBlogReponsitory {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Blog> showAll() {
        TypedQuery<Blog> query = entityManager.createQuery("SELECT b FROM Blog AS b", Blog.class);
        return query.getResultList();
    }

    @Override
    public Blog findById(Long id) {
        TypedQuery<Blog> query = entityManager.createQuery("SELECT b FROM Blog AS b WHERE b.id = :id", Blog.class);
        query.setParameter("id", id);
        try {
            return query.getSingleResult();

        } catch (NoResultException e) {
            return null;
        }

    }
    @Override
    public void delete(Long id) {
        Blog deleteBlog = findById(id);
        if (deleteBlog != null) {
            entityManager.remove(deleteBlog);
        }
    }

    @Override
    public void save(Blog blog) {
        if (blog.getId() != null) {
            entityManager.merge(blog);
        } else {
            entityManager.persist(blog);
        }
    }

    @Override
    public void update(int id) {

    }

}
