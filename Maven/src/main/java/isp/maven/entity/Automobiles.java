package isp.maven.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "automobiles")
public class Automobiles {

    @Id
    @Column(name = "idautomobile", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idautomobile;

    @JsonIgnore
    @JoinColumn(name = "idcustomer", referencedColumnName = "idcustomer")
    @ManyToOne(optional = false)
    private Customers idcustomer;

    @JsonIgnore
    @JoinColumn(name = "idmodel", referencedColumnName = "idmodel")
    @ManyToOne(optional = false)
    private Models idmodel;

    @Column(name = "vin", nullable = false)
    private String vin;

    @Column(name = "registrationnumber", nullable = false)
    private String registrationnumber;

    @Column(name = "productionyear", nullable = false)
    private Integer productionyear;

    @Column(name = "photolink", nullable = false)
    private String photolink;

    public void setIdautomobile(Integer idautomobile) {
        this.idautomobile = idautomobile;
    }

    public Integer getIdautomobile() {
        return idautomobile;
    }

    public void setIdcustomer(Customers idcustomer) {
        this.idcustomer = idcustomer;
    }

    public Customers getIdcustomer() {
        return idcustomer;
    }

    public void setIdmodel(Models idmodel) {
        this.idmodel = idmodel;
    }

    public Models getIdmodel() {
        return idmodel;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getVin() {
        return vin;
    }

    public void setRegistrationnumber(String registrationnumber) {
        this.registrationnumber = registrationnumber;
    }

    public String getRegistrationnumber() {
        return registrationnumber;
    }

    public void setProductionyear(Integer productionyear) {
        this.productionyear = productionyear;
    }

    public Integer getProductionyear() {
        return productionyear;
    }

    public void setPhotolink(String photolink) {
        this.photolink = photolink;
    }

    public String getPhotolink() {
        return photolink;
    }

    @Override
    public String toString() {
        return "Automobiles{" +
                "idautomobile='" + idautomobile + '\'' + ", " +
                "idcustomer='" + idcustomer + '\'' + ", " +
                "idmodel='" + idmodel + '\'' + ", " +
                "vin='" + vin + '\'' + ", " +
                "registrationnumber='" + registrationnumber + '\'' + ", " +
                "productionyear='" + productionyear + '\'' + ", " +
                "photolink='" + photolink + '\'' +
                '}';
    }
}
