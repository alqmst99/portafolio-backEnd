package com.Pierini.Portafolio.Segurity.JWT;


import com.Pierini.Portafolio.Segurity.Entity.UsuarioPrincipal;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;


import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication; 
import org.springframework.stereotype.Component;

/**
 *
 * @author Pieirni Nahuel Nicolas 
 */

@Component
public class JwtProvider {
    private final static Logger logger =LoggerFactory.getLogger(JwtProvider.class);
    @Value("${jwt.secret}")
    private String secret;
    @Value ("${jwt.expiration}")
    private int expiration;

 
    public String generateToken(Authentication auth){
        UsuarioPrincipal usuarioPrincipal=(UsuarioPrincipal) auth.getPrincipal();
        return Jwts.builder().setSubject(usuarioPrincipal.getUsername()).setIssuedAt(new Date()).setExpiration(new Date(new Date().getTime() + expiration*1000)).signWith(SignatureAlgorithm.HS512, secret).compact();
           }

    public String getNameUserFromToken(String token){
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
    }

    public boolean valiateToken(String token){
        try {
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            return true;
            
        } catch (MalformedJwtException e) {
            logger.error("Token MalFormed");
         
             } catch (UnsupportedJwtException e) {
            logger.error("Token Unsupported");
         
             } catch (ExpiredJwtException e) {
            logger.error("Token Expired");
         
             } catch (IllegalArgumentException e) {
            logger.error("Token void");
          } catch (SignatureException e) {
            logger.error("No Valid");
                   } 

        
        return false;
    }


}