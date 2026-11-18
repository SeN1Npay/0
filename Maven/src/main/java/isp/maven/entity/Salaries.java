package isp.maven.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "salaries")
public class Salaries {

    @Id
    @Column(name = "idsalary", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idsalary;

    @JsonIgnore
    @JoinColumn(name = "iduser", referencedColumnName = "iduser")
    @ManyToOne(optional = false)
    private Users iduser;

    @Column(name = "periodstart", nullable = false)
    private Date periodstart;

    @Column(name = "periodend", nullable = false)
    private Date periodend;

    @Column(name = "amount", nullable = false)
    private Integer amount;

    @Column(name = "paymentdate", nullable = false)
    private Date paymentdate;

    public void setIdsalary(Integer idsalary) {
        this.idsalary = idsalary;
    }

    public Integer getIdsalary() {
        return idsalary;
    }

    public void setIduser(Users iduser) {
        this.iduser = iduser;
    }

    public Users getIduser() {
        return iduser;
    }

    public void setPeriodstart(Date periodstart) {
        this.periodstart = periodstart;
    }

    public Date getPeriodstart() {
        return periodstart;
    }

    public void setPeriodend(Date periodend) {
        this.periodend = periodend;
    }

    public Date getPeriodend() {
        return periodend;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setPaymentdate(Date paymentdate) {
        this.paymentdate = paymentdate;
    }

    public Date getPaymentdate() {
        return paymentdate;
    }

    @Override
    public String toString() {
        return "Salaries{" +
                "idsalary='" + idsalary + '\'' + ", " +
                "iduser='" + iduser + '\'' + ", " +
                "periodstart='" + periodstart + '\'' + ", " +
                "periodend='" + periodend + '\'' + ", " +
                "amount='" + amount + '\'' + ", " +
                "paymentdate='" + paymentdate + '\'' +
                '}';
    }
}
