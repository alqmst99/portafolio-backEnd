/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package com.Pierini.Portafolio.Repository;

import com.Pierini.Portafolio.Entity.Skill;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Pierini Nahuel Nicolas
 * @email nahuel.pierini90@hotmail.com
 */
@Repository
public interface ISkillRepo extends JpaRepository<Skill, Integer>{
    Optional<Skill> findByName(String name);
public boolean existsByName(String name);
}
