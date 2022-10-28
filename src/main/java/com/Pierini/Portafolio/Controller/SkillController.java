package com.Pierini.Portafolio.Controller;


import com.Pierini.Portafolio.Dto.DtoSkill;
import com.Pierini.Portafolio.Entity.Skill;
import com.Pierini.Portafolio.Service.SkillService;
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
@CrossOrigin (origins = "https://frontend-portafolio-pierini.web.app/")
@RequestMapping("skill")
public class SkillController {
    @Autowired
    SkillService skillS;

   
    @GetMapping("/list")
    public ResponseEntity <List<Skill>>list(){
        List <Skill> list =skillS.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Skill> getById(@PathVariable("id") int id){
        if(!skillS.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Skill skill = skillS.getOne(id).get();
        return new ResponseEntity(skill, HttpStatus.OK);
    }
    
    //create Experience

  
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoSkill dtoS){
        //validations
        if (StringUtils.isBlank(dtoS.getName()))
            return new ResponseEntity(new Mensaje("this field in obligatory"),HttpStatus.BAD_REQUEST);
        if (skillS.existsByName(dtoS.getName()))
            return new ResponseEntity(new Mensaje("this skill i a ready exists"),HttpStatus.BAD_REQUEST);
        Skill skill= new Skill(dtoS.getName(), dtoS.getPorcent());
        skillS.save(skill);
        return new ResponseEntity(new Mensaje("skill hab bean created"),HttpStatus.OK);
    }
    //update

    
    @PreAuthorize ("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable ("id")int id, @RequestBody DtoSkill dtoS){
        //validations
        if(!skillS.existsById(id))
            return new ResponseEntity(new Mensaje("this id is a ready exists"),HttpStatus.BAD_REQUEST);
        
        if (skillS.existsByName(dtoS.getName())&& skillS.getByName(dtoS.getName()).get().getId() !=id)
            return new ResponseEntity(new Mensaje("this name is a ready exists"),HttpStatus.BAD_REQUEST);
        //don't have void
        if (StringUtils.isBlank(dtoS.getName()))
            return new ResponseEntity(new Mensaje("this field in obligatory"),HttpStatus.BAD_REQUEST);
        Skill skill = skillS.getOne(id).get();
        skill.setName(dtoS.getName());
        skill.setPorcent(dtoS.getPorcent());
        skillS.save(skill);
        return new ResponseEntity(new Mensaje("Skill hab bean update"),HttpStatus.OK);
    }
    //delete experience

    
    @PreAuthorize ("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}" )
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        //validations
        if(!skillS.existsById(id))
            return new ResponseEntity(new Mensaje("this id don't exists"),HttpStatus.BAD_REQUEST);
        skillS.delete(id);
         return new ResponseEntity(new Mensaje("this Skill has bean delete"),HttpStatus.OK);
    }
    

}
