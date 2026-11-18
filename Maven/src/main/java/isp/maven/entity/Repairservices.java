package isp.maven.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "repairservices")
public class Repairservices {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idrepairservice", nullable = false)
    private Integer idrepairservice;

    @JsonIgnore
    @JoinColumn(name = "idrepair", referencedColumnName = "idrepair")
    @ManyToOne(optional = false)
    private Repairs idrepair;

    @JsonIgnore
    @JoinColumn(name = "idservice", referencedColumnName = "idservice")
    @ManyToOne(optional = false)
    private Services idservice;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    public void setIdrepairservice(Integer idrepairservice) {
        this.idrepairservice = idrepairservice;
    }

    public Integer getIdrepairservice() {
        return idrepairservice;
    }

    public void setIdrepair(Repairs idrepair) {
        this.idrepair = idrepair;
    }

    public Repairs getIdrepair() {
        return idrepair;
    }

    public void setIdservice(Services idservice) {
        this.idservice = idservice;
    }

    public Services getIdservice() {
        return idservice;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "Repairservices{" +
                "idrepairservice='" + idrepairservice + '\'' + ", " +
                "idrepair='" + idrepair + '\'' + ", " +
                "idservice='" + idservice + '\'' + ", " +
                "quantity='" + quantity + '\'' +
                '}';
    }
}
