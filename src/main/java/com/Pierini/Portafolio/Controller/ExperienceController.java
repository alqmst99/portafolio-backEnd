
package com.Pierini.Portafolio.Controller;

import com.Pierini.Portafolio.Dto.DtoExperience;
import com.Pierini.Portafolio.Entity.Experience;
import com.Pierini.Portafolio.Service.ExperienceService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Pieirni Nahuel Nicolas 
*@email nahuel.pierini90@hotmail.com
 */
@RestController
@RequestMapping("/experience")
@CrossOrigin (origins = "http://localhost:4200/")
public class ExperienceController  {
    @Autowired
    ExperienceService expServ;
    
    //lista

   
    @GetMapping("/list")
    public ResponseEntity<List<Experience>>list(){
        List <Experience> list =expServ.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
   
   
    @GetMapping("/detail/{id}")
     public ResponseEntity<Experience> getById(@PathVariable("id") int id){
        if(!expServ.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Experience experiencia = expServ.getOne(id).get();
        return new ResponseEntity(experiencia, HttpStatus.OK);
    }
    
    //create Experience

    
    @PreAuthorize ("hasRole('ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoExperience dtoExp){
        //validations
        if (StringUtils.isBlank(dtoExp.getNameE()))
            return new ResponseEntity(new Mensaje("this field in obligatory"),HttpStatus.BAD_REQUEST);
        if (expServ.existsByNameE(dtoExp.getNameE()))
            return new ResponseEntity(new Mensaje("this experience i a ready exists"),HttpStatus.BAD_REQUEST);
        Experience exp= new Experience(dtoExp.getNameE(),dtoExp.getDateI(),dtoExp.getDateF(), dtoExp.getDescE());
        expServ.save(exp);
        return new ResponseEntity(new Mensaje("Experience hab bean created"),HttpStatus.OK);
    }
    //update

    
    @PreAuthorize ("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable ("id")int id, @RequestBody DtoExperience dtoExp){
        //validations
        if(!expServ.existsById(id))
            return new ResponseEntity(new Mensaje("this id is a ready exists"),HttpStatus.BAD_REQUEST);
        
        if (expServ.existsByNameE(dtoExp.getNameE())&& expServ.getByNameE(dtoExp.getNameE()).get().getId() !=id)
            return new ResponseEntity(new Mensaje("this name is a ready exists"),HttpStatus.BAD_REQUEST);
        //don't have void
        if (StringUtils.isBlank(dtoExp.getNameE()))
            return new ResponseEntity(new Mensaje("this field in obligatory"),HttpStatus.BAD_REQUEST);
        Experience exp = expServ.getOne(id).get();
        exp.setNameE(dtoExp.getNameE());
        exp.setDateI(dtoExp.getDateI());
        exp.setDateF(dtoExp.getDateF());
        exp.setDescE(dtoExp.getDescE());
        expServ.save(exp);
        return new ResponseEntity(new Mensaje("Experience hab bean update"),HttpStatus.OK);
    }
    //delete experience

   
    @PreAuthorize ("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}" )
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        //validations
        if(!expServ.existsById(id))
            return new ResponseEntity(new Mensaje("this id don't exists"),HttpStatus.BAD_REQUEST);
        expServ.delete(id);
         return new ResponseEntity(new Mensaje("this experience has bean delete"),HttpStatus.OK);
    }
    

}
