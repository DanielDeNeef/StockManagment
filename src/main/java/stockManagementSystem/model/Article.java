package stockManagementSystem.model;

import java.math.BigDecimal;

public class Article {

    private Integer id;
    private String name;
    private BigDecimal price;

    public Article() {
    }

    public Article(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    public Article(int id, String name, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public Article setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Article setName(String name) {
        this.name = name;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Article setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    @Override
    public String toString() {
        return String.format("Article{id: %d, name: %s, price: %s}", id, name, price);
    }
}
