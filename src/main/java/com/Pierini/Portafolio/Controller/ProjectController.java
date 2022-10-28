/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.Pierini.Portafolio.Controller;

import com.Pierini.Portafolio.Dto.DtoProjects;
import com.Pierini.Portafolio.Entity.Projects;
import com.Pierini.Portafolio.Service.ProjectsService;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Pieirni Nahuel Nicolas 
 *@email nahuel.pierini90@hotmail.com
 */
@RestController
@RequestMapping("/project")
@CrossOrigin(origins = "http://localhost:4200/")
public class ProjectController {

    @Autowired
    ProjectsService  projService;
    
    @GetMapping("/list")
    public ResponseEntity<List<Projects>> list() {
        List<Projects> list = projService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Projects> getById(@PathVariable("id") int id){
        if(!projService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
       Projects edu = projService.getOne(id).get();
        return new ResponseEntity(edu, HttpStatus.OK);
    }
    //create education

   
    @PreAuthorize ("hasRole('ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoProjects dtoProj) {
        if (StringUtils.isBlank(dtoProj.getName())) 
            return new ResponseEntity(new Mensaje("the name is obligatory"), HttpStatus.BAD_REQUEST);
        

        if (projService.existsByName(dtoProj.getName())) 
            return new ResponseEntity(new Mensaje("the education is a ready exist"), HttpStatus.BAD_REQUEST);

            Projects projects = new Projects(dtoProj.getName(), dtoProj.getDescP(), dtoProj.getImgP());
            projService.save(projects);
            return new ResponseEntity(new Mensaje("Projects hab bean add"), HttpStatus.OK);

        }
    //Update Projects

   
    @PreAuthorize ("hasRole('ADMIN')")
 @PostMapping("/update/{id}")
  public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoProjects dtoProj){
      //validations
      //exist id?
      if (!projService.existsById(id))
          return new ResponseEntity(new Mensaje("the id no exist"),HttpStatus.BAD_REQUEST); 
      if (!projService.existsByName(dtoProj.getName())&& projService.getByName(dtoProj.getName()).get().getId() != id)
           return new ResponseEntity (new Mensaje("the education i a ready exists"),HttpStatus.BAD_REQUEST);
      Projects proj= projService.getOne(id).get();
      proj.setName(dtoProj.getName());
      proj.setDescP(dtoProj.getDescP());
      proj.setImgP(dtoProj.getImgP());
     
      projService.save(proj);
      return new ResponseEntity(new Mensaje("Projects had bean update"),HttpStatus.OK);
 }
    //Delete Projects 

   
  @PreAuthorize ("hasRole('ADMIN')")
  @DeleteMapping("/delete/{id}" )
  public ResponseEntity<?> delete(@PathVariable("id") int id){
      //validations
      if(!projService.existsById(id))
          return new ResponseEntity(new Mensaje("the id don't exist"),HttpStatus.BAD_REQUEST);
      projService.delete(id);
      return new ResponseEntity(new Mensaje("the Projects hab bean delete"), HttpStatus.OK);
  }
}
