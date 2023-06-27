package main.java.com.application.learning.Models.Payment;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="payment")
public class PaymentModel {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "user_Id")
    private int userId;

    @Column(name = "course_Id")
    private int courseId;

    @Column(name = "first_Name")
    private String firstName;

    @Column(name = "last_Name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "amount")
    private long amount;

    public PaymentModel() {
    }

    public PaymentModel(long id, int userId, int courseId, String firstName, String lastName, String email,
            long amount) {
        this.id = id;
        this.userId = userId;
        this.courseId = courseId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.amount = amount;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    
}
