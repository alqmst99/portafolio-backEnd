package com.Pierini.Portafolio.Service;

import com.Pierini.Portafolio.Entity.Experience;
import com.Pierini.Portafolio.Repository.IExperienceRepo;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Pieirni Nahuel Nicolas 
*@email nahuel.pierini90@hotmail.com
 */

@Service
@Transactional
public class ExperienceService  {
   @Autowired
    IExperienceRepo expRepo;
   public List<Experience>list(){
       return expRepo.findAll();
   }
public Optional <Experience> getByNameE(String nameE){
    return expRepo.findByNameE(nameE);
    
}
 public Optional <Experience> getOne(int id){
    return expRepo.findById(id);
}
    
public void save(Experience exp){
    expRepo.save(exp);
}
public void delete (int id){
    expRepo.deleteById(id);
}
public boolean existsById(int id){
    return expRepo.existsById(id);
}
public boolean existsByNameE(String nameE){
    return expRepo.existsByNameE(nameE);
}

}
