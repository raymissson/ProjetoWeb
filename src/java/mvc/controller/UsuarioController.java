/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.controller;

import javax.servlet.http.HttpSession;
import mvc.dao.UsuarioDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.validation.Valid;
import mvc.bean.Usuario;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

/**
 *
 * @author david
 */
@Controller
public class UsuarioController {
    private final UsuarioDAO dao;
    
    @Autowired
    public UsuarioController(UsuarioDAO dao){
        this.dao = dao;
    }
    // acessa tela principal de gerencimaneto de usuário
    @RequestMapping("/formTelaUsuario")
    public String abrir(){
        return "usuario/index";
    }

    @RequestMapping("/formAdicionarUsuario")
    public String form(){
        return "usuario/formularioAdicionar";
    }       
    @RequestMapping(value="/adicionaUsuario")
    public String adiciona(@Valid Usuario usuario){
        dao.adicionaUsuario(usuario);
        return "usuario/index";
    }
    
    @RequestMapping("/formListarUsuario")
    public String lista(Model model){
        model.addAttribute("listaUsuarios", dao.listarUsuarios());
        return "usuario/listarTodos";
    }

    @RequestMapping("/formExcluirUsuario")
    public String excluir(int id){
        dao.removerUsuario(id);
        return "redirect:/formListarUsuario";
    }
    
    @RequestMapping("/formExibirUsuario")
    public String exibe(int id, Model model){
        model.addAttribute("usuario", dao.buscarUsuarioPorId(id));
        return "usuario/formularioEditar";
    }
    
    @RequestMapping("/formAlterarUsuario")
    public String altera(@Valid Usuario usuario, BindingResult result){
       dao.alterarUsuario(usuario);
       return "redirect:/formListarUsuario";
    }
    
    @RequestMapping("/efetuaLogin")
    public String efetuaLogin(@Valid Usuario usuario, HttpSession session){        
        if(dao.validarLogin(usuario)){            
            session.setAttribute("usuarioLogado", usuario);
            session.removeAttribute("msgLoginInvalido");            
            if(dao.validarAdmin(usuario.getId())){
                System.out.println("Tô logado como administrador");
                return "usuario/index";
            }else{                
                return "index";
            }
        }else{
            System.out.println("Não Tô logado");
            session.setAttribute("msgLoginInvalido", "O login não foi validado!");
            return "index";
        }
        
    }
    
    @RequestMapping("/efetuarLogout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}
