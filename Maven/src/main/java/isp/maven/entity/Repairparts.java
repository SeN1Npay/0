package isp.maven.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "repairparts")
public class Repairparts {

    @Id
    @Column(name = "idrepairpart", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idrepairpart;

    @JsonIgnore
    @JoinColumn(name = "idrepair", referencedColumnName = "idrepair")
    @ManyToOne(optional = false)
    private Repairs idrepair;

    @JsonIgnore
    @JoinColumn(name = "idsparepart", referencedColumnName = "idsparepart")
    @ManyToOne(optional = false)
    private Spareparts idsparepart;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    public void setIdrepairpart(Integer idrepairpart) {
        this.idrepairpart = idrepairpart;
    }

    public Integer getIdrepairpart() {
        return idrepairpart;
    }

    public void setIdrepair(Repairs idrepair) {
        this.idrepair = idrepair;
    }

    public Repairs getIdrepair() {
        return idrepair;
    }

    public void setIdsparepart(Spareparts idsparepart) {
        this.idsparepart = idsparepart;
    }

    public Spareparts getIdsparepart() {
        return idsparepart;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "Repairparts{" +
                "idrepairpart='" + idrepairpart + '\'' + ", " +
                "idrepair='" + idrepair + '\'' + ", " +
                "idsparepart='" + idsparepart + '\'' + ", " +
                "quantity='" + quantity + '\'' +
                '}';
    }
}
