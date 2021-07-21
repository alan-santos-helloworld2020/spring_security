/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onload.app.app_onload.service;

import com.onload.app.app_onload.model.Cliente;
import com.onload.app.app_onload.repository.ClienteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author alan
 */
@Service
public class ClienteServiceIMPT implements ClienteService{

    @Autowired
    private ClienteRepository repo;
    
    @Override
    public List<Cliente> listar() {
        return this.repo.findAll();
        
    }

    @Override
    public Cliente pesquisar(String id) {
        
        return this.repo.findById(id).orElseThrow(() -> new IllegalArgumentException("Este Cliente não Existe!"));
    }

    @Override
    public Cliente salvar(Cliente cl) {
        return this.repo.save(cl);
    }

    @Override
    public Cliente editar(Cliente cl) {
        return this.repo.save(cl);
    }

    @Override
    public void deletar(String id) {
        this.repo.deleteById(id);
    }

    @Override
    public Cliente pesquisarNome(String nome) {
        return this.repo.findByNome(nome);
    }
    
    
    
}
