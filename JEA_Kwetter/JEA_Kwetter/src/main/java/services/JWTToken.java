package services;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.impl.crypto.MacProvider;
import java.security.Key;

import domain.User;

import javax.ejb.Stateless;

@Stateless
public class JWTToken {

    public JWTToken(){

    }

    // We need a signing key, so we'll create one just for this example. Usually
    // the key would be read from your application configuration instead.
    Key key = MacProvider.generateKey();

    public String EncodeToken(User user) {
        String compactJws = Jwts.builder()
                .setSubject(user.getUsername())
                .signWith(SignatureAlgorithm.HS512, key)
                .compact();
        return compactJws;
    }

    public void DecodeToken(String compactJws) {
        try {
            Jwts.parser().setSigningKey(key).parseClaimsJws(compactJws);
            //OK, we can trust this JWT

        } catch (SignatureException e) {
            //don't trust the JWT!
        }
    }
}
