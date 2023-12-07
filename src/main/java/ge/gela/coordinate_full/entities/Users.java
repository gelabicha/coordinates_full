package ge.gela.coordinate_full.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Getter
@Setter
@Table(schema = "public", name = "users")
public class Users implements UserDetails {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="users_seq_generation")
    @SequenceGenerator(name="users_seq_generation", sequenceName="users_id_seq", allocationSize = 1)
    private Integer id;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "active")
    private Boolean active;

    @Column(name = "last_login_date")
    private LocalDateTime lastLoginDate;

    @Column(name = "created_by")
    private Integer createdBy;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    public Collection<? extends GrantedAuthority> getAuthorities(){
        return new ArrayList<>();
    }
    public String getPassword(){
        return password;
    }
    public String getUsername(){
        return email;
    }
    public boolean isAccountNonExpired(){
        return true;
    }
    public boolean isAccountNonLocked(){
        return true;
    }
    public boolean isCredentialsNonExpired(){
        return true;
    }
    public boolean isEnabled(){
        return true;
    }
}
