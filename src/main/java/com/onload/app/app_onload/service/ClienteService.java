/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onload.app.app_onload.service;

import com.onload.app.app_onload.model.Cliente;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author alan
 */

public interface ClienteService {
    
    	public List<Cliente> listar();
	
	public Cliente pesquisar(String id);
        
	public Cliente pesquisarNome(String id);
	
	public Cliente salvar(Cliente cl);
	
	public Cliente editar(Cliente cl);
	
	public void deletar(String id);
	
    
}
