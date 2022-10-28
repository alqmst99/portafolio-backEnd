package com.Pierini.Portafolio.Controller;

import com.Pierini.Portafolio.Dto.DtoEducation;
import com.Pierini.Portafolio.Entity.Education;
import com.Pierini.Portafolio.Service.EducationService;
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
 */
@RestController
@RequestMapping("/education")
@CrossOrigin(origins = "http://localhost:4200/")
public class EduactionController {

    @Autowired
    EducationService eduServ;

    @GetMapping("/list")
    public ResponseEntity<List<Education>> list() {
        List<Education> list = eduServ.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Education> getById(@PathVariable("id") int id){
        if(!eduServ.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
       Education edu = eduServ.getOne(id).get();
        return new ResponseEntity(edu, HttpStatus.OK);
    }
    
//create education  
    @PreAuthorize ("hasRole('ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoEducation dtoEdu) {
        if (StringUtils.isBlank(dtoEdu.getNameE())) 
            return new ResponseEntity(new Mensaje("the name is obligatory"), HttpStatus.BAD_REQUEST);
        

        if (eduServ.existsByNameE(dtoEdu.getNameE())) 
            return new ResponseEntity(new Mensaje("the education is a ready exist"), HttpStatus.BAD_REQUEST);

            Education education = new Education(dtoEdu.getNameE(), dtoEdu.getDateI(), dtoEdu.getDateF(), dtoEdu.getDescEd());
            eduServ.save(education);
            return new ResponseEntity(new Mensaje("Education hab bean add"), HttpStatus.OK);

        }
    //Update Education

   
 @PreAuthorize ("hasRole('ADMIN')")
 @PutMapping("/update/{id}")
  public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoEducation dtoEdu){
      //validations
      //exist id?
      if (!eduServ.existsById(id))
          return new ResponseEntity(new Mensaje("the id no exist"),HttpStatus.BAD_REQUEST); 
      if (!eduServ.existsByNameE(dtoEdu.getNameE())&& eduServ.getByNameE(dtoEdu.getNameE()).get().getId() != id)
           return new ResponseEntity (new Mensaje("the education i a ready exists"),HttpStatus.BAD_REQUEST);
      Education edu= eduServ.getOne(id).get();
      edu.setNameE(dtoEdu.getNameE());
      edu.setDateI(dtoEdu.getDateI());
      edu.setDateF(dtoEdu.getDateF());
      edu.setDescEd(dtoEdu.getDescEd());
      eduServ.save(edu);
      return new ResponseEntity(new Mensaje("Education had bean update"),HttpStatus.OK);
 }
    //Delete Education 

   
  @PreAuthorize ("hasRole('ADMIN')")
  @DeleteMapping("/delete/{id}" )
  public ResponseEntity<?> delete(@PathVariable("id") int id){
      //validations
      if(!eduServ.existsById(id))
          return new ResponseEntity(new Mensaje("the id don't exist"),HttpStatus.BAD_REQUEST);
      eduServ.delete(id);
      return new ResponseEntity(new Mensaje("the Education hab bean delete"), HttpStatus.OK);
  }
    }
