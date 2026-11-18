package isp.maven.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "models")
public class Models {

    @Id
    @Column(name = "idmodel", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idmodel;

    @JsonIgnore
    @JoinColumn(name = "idbrand", referencedColumnName = "idbrand")
    @ManyToOne(optional = false)
    private Brands idbrand;

    @Column(name = "name", nullable = false)
    private String name;

    public void setIdmodel(Integer idmodel) {
        this.idmodel = idmodel;
    }

    public Integer getIdmodel() {
        return idmodel;
    }

    public void setIdbrand(Brands idbrand) {
        this.idbrand = idbrand;
    }

    public Brands getIdbrand() {
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
        return "Models{" +
                "idmodel='" + idmodel + '\'' + ", " +
                "idbrand='" + idbrand + '\'' + ", " +
                "name='" + name + '\'' +
                '}';
    }
}
