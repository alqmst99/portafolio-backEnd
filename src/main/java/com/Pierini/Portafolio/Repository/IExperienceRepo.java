package com.Pierini.Portafolio.Repository;

import com.Pierini.Portafolio.Entity.Experience;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Pierini Nahuel Nicolas
 */
@Repository
public interface IExperienceRepo extends JpaRepository<Experience, Integer>{
    public Optional<Experience>findByNameE(String nameE);
    public boolean existsByNameE(String nameE);
    
}
