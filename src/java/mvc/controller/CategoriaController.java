/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.controller;


import javax.validation.Valid;
import mvc.bean.Categoria;
import mvc.dao.CategoriaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author david
 */
@Controller
public class CategoriaController {
    private final CategoriaDAO dao;
    
    @Autowired
    public CategoriaController(CategoriaDAO dao){
        this.dao = dao;
    }
      
    @RequestMapping("/formAdicionarCategoria")
    public String form(){
        return "categoria/formularioAdicionar";       
    }
               
    @RequestMapping(value="/adicionarCategoria")
    public String adiciona(@Valid Categoria categoria){
        dao.adicionarCategoria(categoria);
        return "usuario/index";
    }
    
    @RequestMapping("/formListarCategoria")
    public String lista(Model model){
        model.addAttribute("listaCategorias", dao.listarCategoria());
        return "categoria/listarTodos";
    }
    
    @RequestMapping("/formExibirCategoria")
    public String editar(int id, Model model){
        model.addAttribute("categoria", dao.buscarCategoriaPorId(id));
        return "categoria/formularioEditar";
    }
    
   @RequestMapping("/formAlterarCategoria")
    public String altera(@Valid Categoria categoria, BindingResult result){
       dao.alterarCategoria(categoria);
       return "redirect:/formListarCategoria";
    }
    
    @RequestMapping("/formExcluirCategoria")
    public String excluir(int id){
        dao.excluirCategoria(id);
        return "redirect:/formListarCategoria";
    }
    
}
