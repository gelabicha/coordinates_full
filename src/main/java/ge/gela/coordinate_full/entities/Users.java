package ge.gela.coordinate_full.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(schema = "public", name = "users")
public class Users {
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
}
