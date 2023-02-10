package flots_bleus.v2.security.service;

import flots_bleus.v2.security.model.Admin;
import flots_bleus.v2.security.repo.AdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import javax.security.auth.login.LoginException;
import java.util.HashSet;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    AdminRepo repo;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {

        Admin admin = repo.findByLogin(login);

        return new User(admin.getLogin(),admin.getMotDePasse(), new HashSet<>());
    }

    public UserDetails loadAdmin(Admin user) throws LoginException {
        UserDetails admin = loadUserByUsername(user.getLogin());

        if (BCrypt.checkpw(user.getMotDePasse(),admin.getPassword())){
            return admin;
        }else {
            throw new LoginException("Mot de pas incorrect");
        }
    }
}
