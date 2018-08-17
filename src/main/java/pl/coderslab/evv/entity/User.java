package pl.coderslab.evv.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable	=	false,	unique	=	true)
    @NotNull
    private	String	username;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;

    @Column(nullable	=	false)
    @NotNull
    private String password;
    private	boolean	enabled;

    @ManyToMany(cascade	=	CascadeType.ALL,	fetch	=	FetchType.EAGER)
    @JoinTable(name	=	"user_role",	joinColumns	=	@JoinColumn(name	=	"user_id"),
            inverseJoinColumns	=	@JoinColumn(name	=	"role_id"))
    private Set<Role> roles;

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
