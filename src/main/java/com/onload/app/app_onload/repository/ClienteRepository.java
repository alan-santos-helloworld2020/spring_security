/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onload.app.app_onload.repository;

import com.onload.app.app_onload.model.Cliente;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author alan
 */
@Repository
public interface ClienteRepository extends MongoRepository<Cliente,String> {
    
   public  Cliente findByNome(String nome);
    
}
