package flots_bleus.v2.security.repo;

import flots_bleus.v2.security.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepo extends JpaRepository<Admin,String> {

    Admin findByLogin(String login);
}
