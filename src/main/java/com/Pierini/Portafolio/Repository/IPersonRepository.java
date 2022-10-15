
package com.Pierini.Portafolio.Repository;

import com.Pierini.Portafolio.Entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Pierni Nahuel Nicolas
 */
@Repository
public interface IPersonRepository extends JpaRepository<Person, Long>{
    
    
}
