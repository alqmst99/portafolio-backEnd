package com.Pierini.Portafolio.Controller;

import com.Pierini.Portafolio.Entity.Person;
import com.Pierini.Portafolio.Interface.IPersonService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Pieirni Nahuel Nicolas 
 */
@RestController
@RequestMapping("/Person")
@CrossOrigin (origins = "http://localhost:4200")
public class PersonController {
@Autowired 
IPersonService ipersonService;
@GetMapping("/Person/get")
public List<Person> getPerson(){
    return ipersonService.getPersons();
}
@PostMapping("/Person/Create")
public String createPerson(@RequestBody Person person){
    ipersonService.savePerson(person);
    return "this person is create";
}
@DeleteMapping("/Person/delete/{id}")
public String deletePerson(@PathVariable Long id){
    ipersonService.deletePerson(id);
    return "this person has been delete";
}
@PutMapping("/Person/edit/{id}")
public Person editPerson(@PathVariable Long id, @RequestParam ("name")String newName,
        @RequestParam ("lastName")String newLastName,
        @RequestParam ("descP")String newDescP,
        @RequestParam ("imgP")String newImgP) {
    Person person=ipersonService.findPerson(id);
    person.setName(newName);
    person.setLastName(newLastName);
    person.setDescP(newDescP);
    person.setImgP(newImgP);
    return person;
}
}
