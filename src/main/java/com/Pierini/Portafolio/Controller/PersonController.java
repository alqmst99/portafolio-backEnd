package com.Pierini.Portafolio.Controller;

import com.Pierini.Portafolio.Dto.DtoPerson;
import com.Pierini.Portafolio.Entity.Person;
import com.Pierini.Portafolio.Service.ImpPersonService;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Pieirni Nahuel Nicolas 
 */

@RestController
@RequestMapping("person")
@CrossOrigin (origins = "https://frontend-portafolio-pierini.web.app/")
public class PersonController {
@Autowired 
ImpPersonService personService;
//list

   
@GetMapping("/list")
    public ResponseEntity<List<Person>> list() {
        List<Person> list = personService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
   
   
    @GetMapping("/detail/{id}")
    public ResponseEntity<Person> getById(@PathVariable("id") int id){
        if(!personService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
       Person person = personService.getOne(id).get();
        return new ResponseEntity(person, HttpStatus.OK);
    }
    /*create person
    
    public ResponseEntity<?> create(@RequestBody DtoPerson dtoPerson) {
        if (StringUtils.isBlank(dtoPerson.getName())) 
            return new ResponseEntity(new Mensaje("the name is obligatory"), HttpStatus.BAD_REQUEST);
        

        if (personService.existsByName(dtoPerson.getName())) 
            return new ResponseEntity(new Mensaje("the person is a ready exist"), HttpStatus.BAD_REQUEST);

            Person person = new Person(dtoPerson.getName(),dtoPerson.getLastName(),dtoPerson.getDescP(),dtoPerson.getImgP());
            personService.save(person);
            return new ResponseEntity(new Mensaje("Person hab bean add"), HttpStatus.OK);

        }*/
   
    //Update Person

 @PreAuthorize ("hasRole('ADMIN')")
 @PutMapping("/update/{id}")
    
  public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoPerson dtoPerson){
      //validations
      //exist id?
      if (!personService.existsById(id))
          return new ResponseEntity(new Mensaje("the id no exist"),HttpStatus.BAD_REQUEST); 
      if (!personService.existsByName(dtoPerson.getName())&& personService.getByName(dtoPerson.getName()).get().getId() != id)
           return new ResponseEntity (new Mensaje("the person i a ready exists"),HttpStatus.BAD_REQUEST);
      Person person= personService.getOne(id).get();
     person.setName(dtoPerson.getName());
     person.setLastName(dtoPerson.getLastName());
     person.setDescP(dtoPerson.getDescP());
     person.setImgP(dtoPerson.getImgP());
      personService.save(person);
      return new ResponseEntity(new Mensaje("Person had bean update"),HttpStatus.OK);
 }
    /*Delete Person 
  public ResponseEntity<?> delete(@PathVariable("id") int id){
      //validations
      if(!personService.existsById(id))
          return new ResponseEntity(new Mensaje("the id don't exist"),HttpStatus.BAD_REQUEST);
      personService.delete(id);
      return new ResponseEntity(new Mensaje("the Person hab bean delete"), HttpStatus.OK);
  }*/
}
