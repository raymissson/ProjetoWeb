/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.controller;

import java.sql.SQLException;
import javax.validation.Valid;
import mvc.bean.Cliente;
import mvc.dao.ClienteDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Raymison
 */
@Controller
public class ClienteController {
    private ClienteDAO dao;
    
    @Autowired
    public ClienteController(ClienteDAO dao){
        this.dao=dao;
    }
    
    @RequestMapping("/formAdicionarCliente")
    public String form(){
        return "cliente/formularioAdicionar";
    }
    
    @RequestMapping("/adicionarCliente")
    public String adiciona(@Valid Cliente cliente){
        dao.adicionarCliente(cliente);        
        return "index";
    }
    
    @RequestMapping("/listarCliente")
    public String lista(Model model){
        model.addAttribute("listaClientes", dao.listarClientes());
        return "cliente/listarTodos";
    }
    
    @RequestMapping("/removeCliente")
    public String remove(int id){
        dao.removerCliente(id);
        return "redirect:/listarTodos";
    }
    
    @RequestMapping("/exibeCliente")
    public String exibe(int id, Model model) throws SQLException{
       
        model.addAttribute("cliente", dao.buscarClientePorId(id));
        
        return "usuario/formularioEditar";
    }
    
    @RequestMapping("/alteraCliente")
    public String altera(@Valid Cliente cliente, BindingResult result){
        dao.alterarCliente(cliente);
        return "redirect:/listarTodos";
    }
}
