package com.Pierini.Portafolio.Service;


import com.Pierini.Portafolio.Entity.Person;
import com.Pierini.Portafolio.Interface.IPersonService;
import com.Pierini.Portafolio.Repository.IPersonRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Pieirni Nahuel Nicolas 
 */
@Service
public class ImpPersonService implements IPersonService {
    @Autowired 
    IPersonRepository ipersonRepository;
    
    @Override
    public List<Person> getPersons() {
    List <Person> Person= ipersonRepository.findAll();
    return Person;
    }

    @Override
    public void savePerson(Person person) {
        ipersonRepository.save(person);
    }

    @Override
    public void deletePerson(Long id) {
   ipersonRepository.deleteById(id);
    }

    @Override
    public Person findPerson(Long id) {
    Person person =ipersonRepository.findById(id).orElse(null);
    return person;
    }
    

}
