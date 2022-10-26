package com.Pierini.Portafolio.Segurity.Repository;


import com.Pierini.Portafolio.Segurity.Entity.Usuario;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 *
 * @author Nahue
 */
@Repository

public interface IUsuarioRepo extends JpaRepository <Usuario, Integer>{

    Optional <Usuario> findByNameUser(String nameUser);

    boolean existsByNameUser(String nameUser);

    boolean existsByEmail(String email);
}
