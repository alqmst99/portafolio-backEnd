package com.Pierini.Portafolio.Segurity.Repository;

import com.Pierini.Portafolio.Segurity.Entity.Rol;
import com.Pierini.Portafolio.Segurity.enums.RolName;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Nahue
 */
@Repository
public interface IRolRepo extends JpaRepository<Rol, Integer>{
    Optional<Rol> findByRolName(RolName rolName);


}