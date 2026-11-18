package isp.maven.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "spareparts")
public class Spareparts {

    @Id
    @Column(name = "idsparepart", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idsparepart;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "article", nullable = false)
    private String article;

    @Column(name = "price", nullable = false)
    private Integer price;

    @Column(name = "stock", nullable = false)
    private Integer stock;

    public void setIdsparepart(Integer idsparepart) {
        this.idsparepart = idsparepart;
    }

    public Integer getIdsparepart() {
        return idsparepart;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public String getArticle() {
        return article;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getPrice() {
        return price;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getStock() {
        return stock;
    }

    @Override
    public String toString() {
        return "Spareparts{" +
                "idsparepart='" + idsparepart + '\'' + ", " +
                "name='" + name + '\'' + ", " +
                "article='" + article + '\'' + ", " +
                "price='" + price + '\'' + ", " +
                "stock='" + stock + '\'' +
                '}';
    }
}
