package flots_bleus.v2.security.controller;

import flots_bleus.v2.security.jwt.JWTTokenUtil;
import flots_bleus.v2.security.model.Admin;
import flots_bleus.v2.security.service.UserDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.security.auth.login.LoginException;
import java.util.HashMap;
import java.util.Map;

@RestController
public class ConnexionController {

    @Autowired
    JWTTokenUtil jwtTokenUtil;

    @Autowired
    UserDetailServiceImpl userDetailService;

    @PostMapping(value = "/connexion", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public Map<String,String> connexion(@RequestBody Admin admin) throws LoginException {
        String token = jwtTokenUtil.generateToken(userDetailService.loadAdmin(admin));

        Map<String,String> r = new HashMap<>();

        r.put("Token",token);
        r.put("Issued at", jwtTokenUtil.getIssuedAt(token));
        r.put("Expiration", jwtTokenUtil.getExpiration(token));

        return r;
    }


}
