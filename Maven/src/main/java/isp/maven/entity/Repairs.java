package isp.maven.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "repairs")
public class Repairs {

    @Id
    @Column(name = "idrepair", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idrepair;

    @JsonIgnore
    @JoinColumn(name = "idautomobile", referencedColumnName = "idautomobile")
    @ManyToOne(optional = false)
    private Automobiles idautomobile;

    @JsonIgnore
    @JoinColumn(name = "idmechanic", referencedColumnName = "idmechanic")
    @ManyToOne(optional = false)
    private Mechanics idmechanic;

    @JsonIgnore
    @JoinColumn(name = "idadvisor", referencedColumnName = "idadvisor")
    @ManyToOne(optional = false)
    private Serviceadvisors idadvisor;

    @JsonIgnore
    @JoinColumn(name = "idbay", referencedColumnName = "idbay")
    @ManyToOne(optional = false)
    private Repairbays idbay;

    @Column(name = "acceptancedate", nullable = false)
    private Date acceptancedate;

    @Column(name = "completiondate", nullable = false)
    private Date completiondate;

    @Column(name = "status", nullable = false)
    private String status;

    public void setIdrepair(Integer idrepair) {
        this.idrepair = idrepair;
    }

    public Integer getIdrepair() {
        return idrepair;
    }

    public void setIdautomobile(Automobiles idautomobile) {
        this.idautomobile = idautomobile;
    }

    public Automobiles getIdautomobile() {
        return idautomobile;
    }

    public void setIdmechanic(Mechanics idmechanic) {
        this.idmechanic = idmechanic;
    }

    public Mechanics getIdmechanic() {
        return idmechanic;
    }

    public void setIdadvisor(Serviceadvisors idadvisor) {
        this.idadvisor = idadvisor;
    }

    public Serviceadvisors getIdadvisor() {
        return idadvisor;
    }

    public void setIdbay(Repairbays idbay) {
        this.idbay = idbay;
    }

    public Repairbays getIdbay() {
        return idbay;
    }

    public void setAcceptancedate(Date acceptancedate) {
        this.acceptancedate = acceptancedate;
    }

    public Date getAcceptancedate() {
        return acceptancedate;
    }

    public void setCompletiondate(Date completiondate) {
        this.completiondate = completiondate;
    }

    public Date getCompletiondate() {
        return completiondate;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Repairs{" +
                "idrepair='" + idrepair + '\'' + ", " +
                "idautomobile='" + idautomobile + '\'' + ", " +
                "idmechanic='" + idmechanic + '\'' + ", " +
                "idadvisor='" + idadvisor + '\'' + ", " +
                "idbay='" + idbay + '\'' + ", " +
                "acceptancedate='" + acceptancedate + '\'' + ", " +
                "completiondate='" + completiondate + '\'' + ", " +
                "status='" + status + '\'' +
                '}';
    }
}
