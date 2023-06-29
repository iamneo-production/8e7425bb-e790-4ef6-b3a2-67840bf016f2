package main.java.com.application.learning.Models.Payment;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="payment")
public class PaymentModel {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;

    @Column(name = "user_Id")
    private Long userId;

    @Column(name = "course_Id")
    private Long courseId;


    @Column(name = "amount")
    private Long amount;

    @Column(name = "date")
    private Date date;

    public PaymentModel() {
    }

    public PaymentModel(Long id, Long userId, Long courseId, Long amount, Date date) {
        this.id = id;
        this.userId = userId;
        this.courseId = courseId;
        this.amount = amount;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
