package ru.indivio.homecrm.dto;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "clients")
public class ClientDto implements Cloneable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "login_name")
    private String loginName;

    @Column(name = "password")
    private String password;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    public ClientDto() {
    }

    public ClientDto(String loginName, String password, String firstName, String lastName, String email) {
        this.loginName = loginName;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
    @Override
    public ClientDto clone(){
        return new ClientDto("clone".concat(this.loginName),"clonePass".concat(this.password),this.firstName,this.lastName,this.email);
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", loginName='" + loginName + '\'' + ", password='" + "*********" + '\''
                + ", firstName='" + firstName + '\'' + ", lastName='" + lastName + '\'' + ", email='" + email + '\''
                + '}';
    }
}
