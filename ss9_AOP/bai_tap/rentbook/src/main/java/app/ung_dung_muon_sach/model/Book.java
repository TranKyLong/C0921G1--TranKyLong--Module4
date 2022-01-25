package app.ung_dung_muon_sach.model;

import javax.persistence.*;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String author;
    private Integer quanlity;

    private Integer rentCode;

    @Column(length = 10000)
    private String review;

    public Book() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getQuanlity() {
        return quanlity;
    }

    public void setQuanlity(Integer qunality) {
        this.quanlity = qunality;
    }

    public Integer getRentCode() {
        return rentCode;
    }

    public void setRentCode(Integer rentCode) {
        this.rentCode = rentCode;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }
}
