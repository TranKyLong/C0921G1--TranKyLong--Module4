package app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String writer;
    private String Content;
    private String postingDay;

    public Blog() {
    }

    public Blog(String title, String writer, String Content, String postingDay) {
        this.title = title;
        this.writer = writer;
        this.Content = Content;
        this.postingDay = postingDay;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String songName) {
        this.title = songName;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String artistName) {
        this.writer = artistName;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String category) {
        this.Content = category;
    }

    public String getPostingDay() {
        return postingDay;
    }

    public void setPostingDay(String songLlink) {
        this.postingDay = songLlink;
    }
}
