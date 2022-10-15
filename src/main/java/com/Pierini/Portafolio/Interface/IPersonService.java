
package com.Pierini.Portafolio.Interface;

import com.Pierini.Portafolio.Entity.Person;
import java.util.List;

/**
 *
 * @author Pierini Nahuel Nicolas
 */
public interface IPersonService {
    //get List
    public List<Person>getPersons();
    //save Person
    public void savePerson(Person person);
    //delete Person
    public void deletePerson(Long id);
    //sarch person
    public Person findPerson(Long id);
    
}
