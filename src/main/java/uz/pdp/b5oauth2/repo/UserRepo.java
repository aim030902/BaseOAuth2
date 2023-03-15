package uz.pdp.b5oauth2.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.b5oauth2.entity.User;

public interface UserRepo extends JpaRepository<User,Integer> {
}
