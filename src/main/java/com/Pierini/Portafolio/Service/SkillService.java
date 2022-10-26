package com.Pierini.Portafolio.Service;

import com.Pierini.Portafolio.Entity.Skill;
import com.Pierini.Portafolio.Repository.ISkillRepo;
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
public class SkillService {
    @Autowired
    ISkillRepo skillRepo;

  
    public List<Skill> list(){
        return skillRepo.findAll();
    }

    public Optional<Skill> getOne(int id){
        return skillRepo.findById(id);
    }

   
    public Optional<Skill> getByName(String name){
        return skillRepo.findByName(name);
    }

    public void save(Skill skill){
        skillRepo.save(skill);
    }

    public void delete(int id){
        skillRepo.deleteById(id);
    }

    public boolean existsById(int id){
        return skillRepo.existsById(id);
    }

    public boolean existsByName(String name){
        return skillRepo.existsByName(name);
    }

}
