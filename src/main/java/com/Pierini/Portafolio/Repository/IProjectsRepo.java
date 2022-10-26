package com.Pierini.Portafolio.Repository;

import com.Pierini.Portafolio.Entity.Projects;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Pierini Nahuel Nicolas
 * @email nahuel.pierini90@hotmail.com
 */
public interface IProjectsRepo extends JpaRepository<Projects, Integer>{
    Optional<Projects> findByName(String name);

   
    public boolean existsByName(String name);
}
