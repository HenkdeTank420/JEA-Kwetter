package services;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.impl.crypto.MacProvider;
import java.security.Key;

import domain.User;

public class JWTToken {

    public JWTToken(){

    }

    // We need a signing key, so we'll create one just for this example. Usually
    // the key would be read from your application configuration instead.
    static String key = "is9hrKi9YO5GaUCep2xZ6Zpy7kUVvgKc";

    public String EncodeToken(String username) {
        String compactJws = Jwts.builder()
                .setSubject("login")
                .claim("username", username)
                .signWith(SignatureAlgorithm.HS512, key)
                .compact();
        return compactJws;
    }

    public Boolean CheckIfTokenIsTrusted(String token) {
        try{
            Claims claims = Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody();
            System.out.print(claims.getSubject());
            if (claims.getSubject().equals("login")) {
                return true;
            }
            return false;

        }
        catch(SignatureException e){
            return false;
        }
    }

    public String GetUsernameFromToken(String token) {

        if(CheckIfTokenIsTrusted(token)){
            Claims claims = Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody();
            return (String) claims.get("username");
        }
        return null;
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
