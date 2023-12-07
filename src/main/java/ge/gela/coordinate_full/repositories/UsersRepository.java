package ge.gela.coordinate_full.repositories;

import ge.gela.coordinate_full.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<Users,Integer> {

    Optional<Users> findAllByEmail(String email);
}
