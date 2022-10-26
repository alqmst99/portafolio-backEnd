package com.Pierini.Portafolio.Segurity.Service;

import com.Pierini.Portafolio.Segurity.Entity.Usuario;
import com.Pierini.Portafolio.Segurity.Entity.UsuarioPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author Pieirni Nahuel Nicolas
 */
@Service
public class UserDetailImpl implements UserDetailsService {

    @Autowired
    UsuarioService usuarioService;

    
    @Override
    public UserDetails loadUserByUsername(String nameUser) throws UsernameNotFoundException {
 
              Usuario usuario = usuarioService.getByUser(nameUser).get();
                return UsuarioPrincipal.build(usuario);
   
    }
}


