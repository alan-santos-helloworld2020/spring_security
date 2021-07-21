/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onload.app.app_onload.controller;

import com.onload.app.app_onload.model.Cliente;
import com.onload.app.app_onload.service.ClienteServiceIMPT;
import com.onload.app.app_onload.storage.FotoStorage;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
    private ClienteServiceIMPT repo;
    @Autowired
    private FotoStorage bancoFotos;

    @GetMapping("/login")
    public String login(Model md) {
        return "login";

    }
    
    @GetMapping("/logout")
    public String logout(HttpSession session) {
    	session.invalidate();
	return "redirect:login";


    }

    @GetMapping("/")
    public String index(Model md) {
        md.addAttribute("nome", "Home");
        return "index";

    }

    @GetMapping("/cadastro")
    public String cadastro(Model md) {

        md.addAttribute("cliente", new Cliente())
                .addAttribute("nome", "Formulário de Cadastro");
        return "cadastro";
    }

    @PostMapping("/salvar")
    public String salvar(@RequestParam("arquivo") MultipartFile arquivo, @Validated Cliente cliente) {

        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter dataHoje = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String frmtData = myDateObj.format(dataHoje);

//        cliente.setFoto(.getName().toString());
        cliente.setData(frmtData);
        bancoFotos.salvarFoto(arquivo);
        repo.salvar(cliente);
        return "redirect:/clientes";

    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable String id, Model md) {

        md.addAttribute("nome", "Editar Cliente").addAttribute("cliente", repo.pesquisar(id));
        return "editar";
    }

    @GetMapping("/clientes")
    public String clientes(Model md) {

        md.addAttribute("clientes", repo.listar()).addAttribute("nome", "Tabela de Clientes");
        return "clientes";
    }

    @GetMapping("/deletar/{id}")
    public String deletar(@PathVariable String id) {
        repo.deletar(id);
        return "redirect:/clientes";
    }

    @GetMapping("/sobre")
    public String sobre(Model md) {

        return "sobre";

    }

}
