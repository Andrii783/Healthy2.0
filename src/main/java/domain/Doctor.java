package domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "doctor_id")
    private int id;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "first_name")
    private String firstName;

    private String patronymic;

    private String phone;

    @Enumerated(EnumType.ORDINAL)
    private Gender gender;

    @Column(name = "date_of_birth")
    private String dateOfBirth;

    @Enumerated(EnumType.STRING)
    private Category category;

    @Enumerated(EnumType.STRING)
    private Profile profile;

    @OneToOne(mappedBy = "doctor", cascade = CascadeType.PERSIST)
    private Ticket ticket;

    public Doctor(String lastName, String firstName, String patronymic,
                  String phone, Gender gender, String dateOfBirth,
                  Category category, Profile profile) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.phone = phone;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.category = category;
        this.profile = profile;
    }

    public Doctor() {
    }

    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

    public String getLastName() {return lastName;}

    public void setLastName(String lastName) {this.lastName = lastName;}

    public String getFirstName() {return firstName;}

    public void setFirstName(String firstName) {this.firstName = firstName;}

    public String getPatronymic() {return patronymic;}

    public void setPatronymic(String patronymic) {this.patronymic = patronymic;}

    public String getPhone() {return phone;}

    public void setPhone(String phone) {this.phone = phone;}

    public Gender getGender() {return gender;}

    public void setGender(Gender gender) {this.gender = gender;}

    public String getDateOfBirth() {return dateOfBirth;}

    public void setDateOfBirth(String dateOfBirth) {this.dateOfBirth = dateOfBirth;}

    public Category getCategory() {return category;}

    public void setCategory(Category category) {this.category = category;}

    public Profile getProfile() {return profile;}

    public void setProfile(Profile profile) {this.profile = profile;}

    public Ticket getTicket() {return ticket;}

    public void setTicket(Ticket ticket) {this.ticket = ticket;}
}
