package app.ung_dung_muon_sach.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cateId;
    private String cateName;

    @OneToMany(mappedBy = "category")
    private List<Book> bookCate;

    public Category() {
    }

    public Category(Integer cateId, String cateName, List<Book> bookCate) {
        this.cateId = cateId;
        this.cateName = cateName;
        this.bookCate = bookCate;
    }

    public Integer getCateId() {
        return cateId;
    }

    public void setCateId(Integer cateId) {
        this.cateId = cateId;
    }

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

    public List<Book> getBookCate() {
        return bookCate;
    }

    public void setBookCate(List<Book> bookCate) {
        this.bookCate = bookCate;
    }
}
