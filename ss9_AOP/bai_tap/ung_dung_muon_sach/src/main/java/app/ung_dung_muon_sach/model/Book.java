package app.ung_dung_muon_sach.model;

import javax.persistence.*;
import java.util.List;


@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookId;
    private String bookName;
    private String writer;

    @ManyToOne(targetEntity = Category.class)
    private Category category;

    private int quantily;
    private boolean isRented;
    private Integer rentCode;

    public Book() {
    }

    public Book(String bookName, String writer, Category category, int quantily, boolean isRented, Integer rentCode) {
        this.bookName = bookName;
        this.writer = writer;
        this.category = category;
        this.quantily = quantily;
        this.isRented = isRented;
        this.rentCode = rentCode;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getQuantily() {
        return quantily;
    }

    public void setQuantily(int quantily) {
        this.quantily = quantily;
    }

    public boolean isRented() {
        return isRented;
    }

    public void setRented(boolean rented) {
        isRented = rented;
    }

    public Integer getRentCode() {
        return rentCode;
    }

    public void setRentCode(Integer rentCode) {
        this.rentCode = rentCode;
    }
}
