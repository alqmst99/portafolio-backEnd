package com.Pierini.Portafolio.Service;

import com.Pierini.Portafolio.Entity.Projects;
import com.Pierini.Portafolio.Repository.IProjectsRepo;
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
public class ProjectsService {
    @Autowired
     IProjectsRepo projectRepo;
      public List<Projects> list(){
        return projectRepo.findAll();
    }

    public Optional<Projects> getOne(int id){
        return projectRepo.findById(id);
    }

   
    public Optional<Projects> getByName(String name){
        return projectRepo.findByName(name);
    }

    public void save(Projects skill){
        projectRepo.save(skill);
    }

    public void delete(int id){
        projectRepo.deleteById(id);
    }

    public boolean existsById(int id){
        return projectRepo.existsById(id);
    }

    public boolean existsByName(String name){
        return projectRepo.existsByName(name);
    }


}
