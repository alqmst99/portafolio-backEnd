package com.Pierini.Portafolio.Service;



import com.Pierini.Portafolio.Entity.Person;
import com.Pierini.Portafolio.Repository.IPersonRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Pieirni Nahuel Nicolas 
 */
@Service
public class ImpPersonService  {
    @Autowired 
    IPersonRepository ipersonRepo;
   
    public List<Person> list(){
       return ipersonRepo.findAll();
   }

    public Optional <Person> getByName(String name){
    return ipersonRepo.findByName(name);
    
}

    public Optional <Person> getOne(int id){
    return ipersonRepo.findById(id);
}
    public void save(Person person){
    ipersonRepo.save(person);
}

    public void delete(int id){
    ipersonRepo.deleteById(id);
}

   
    public boolean existsById(int id){
    return ipersonRepo.existsById(id);
}

    public boolean existsByName(String name){
    return ipersonRepo.existsByName(name);
}

}
