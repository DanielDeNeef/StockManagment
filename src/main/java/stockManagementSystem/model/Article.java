package stockManagementSystem.model;

import java.math.BigDecimal;

public class Article {

    private int id;
    private String name;
    private BigDecimal price;

    public Article() {
    }

    public Article(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public Article setId(int id) {
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
