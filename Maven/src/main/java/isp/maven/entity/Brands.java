package isp.maven.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "brands")
public class Brands {

    @Id
    @Column(name = "idbrand", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idbrand;

    @Column(name = "name", nullable = false)
    private String name;

    public void setIdbrand(Integer idbrand) {
        this.idbrand = idbrand;
    }

    public Integer getIdbrand() {
        return idbrand;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Brands{" +
                "idbrand='" + idbrand + '\'' + ", " +
                "name='" + name + '\'' +
                '}';
    }
}
