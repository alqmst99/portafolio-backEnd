

package com.Pierini.Portafolio.Service;

import com.Pierini.Portafolio.Entity.Education;
import com.Pierini.Portafolio.Repository.IEducationRepo;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Pieirni Nahuel Nicolas 
 */

@Service
@Transactional
public class EducationService {
@Autowired
IEducationRepo ieducationRepo;

    public List<Education> list(){
    return ieducationRepo.findAll();
}
    public Optional<Education> getOne(int id){
    return ieducationRepo.findById(id);
}
    public Optional<Education> getByNameE(String nameE){
    return ieducationRepo.findByNameE(nameE);
}
    public void save(Education edu){
    ieducationRepo.save(edu);
    
}
    public void delete(int id){
    ieducationRepo.deleteById(id);
}
    public boolean existsById(int id){
    return ieducationRepo.existsById(id);
}

   
    public boolean existsByNameE(String nameE){
    return ieducationRepo.existsByNameE(nameE);
}
}
