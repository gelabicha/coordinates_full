package ge.gela.coordinate_full.security;

import ge.gela.coordinate_full.entities.Users;
import ge.gela.coordinate_full.repositories.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

@RequiredArgsConstructor
public class ApplicationUserManager implements UserDetailsService {
    private final UsersRepository usersRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Users> users = usersRepository.findAllByEmail(email);
        if(users.isEmpty()){
            return null;
        }
        return users.get();
    }
}
