package app.model;

public class Product {
    private Integer id;
    private String name;
    private Double cost;
    private String note;
    private String nsx;

    public Product() {
    }

    public Product(Integer id,String name, Double cost, String note, String nsx) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.note = note;
        this.nsx = nsx;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getNsx() {
        return nsx;
    }

    public void setNsx(String nsx) {
        this.nsx = nsx;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + cost + " " + note + " " + nsx ;
    }
}

