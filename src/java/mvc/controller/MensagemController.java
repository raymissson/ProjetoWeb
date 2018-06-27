/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import mvc.bean.Mensagem;
import mvc.dao.MensagemDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author david
 */
@Controller
public class MensagemController {
    private final MensagemDAO dao;
    
    @Autowired
    public MensagemController(MensagemDAO dao){
        this.dao = dao;        
    }
    
    @RequestMapping("/listarMensagens")
    public String listar(Model model) throws IOException{
        List<Mensagem> listaMensagens = dao.listarMensagens();
        model.addAttribute("listaMensagens", listaMensagens);
        return "mensagem/listarTodos";
    }
    
    @RequestMapping("/formAdicionarMensagem")
    public String adicionar(){
        return "mensagem/enviarMensagem";
    }
             
    @RequestMapping(value="/adicionarMensagem", method=RequestMethod.POST)    
    public String adiciona(HttpServletRequest request, Model model){
        Mensagem mensagemAdd = new Mensagem();        
        mensagemAdd.setNome_usuario(request.getParameter("nome"));
        mensagemAdd.setConteudo(request.getParameter("conteudo"));
        mensagemAdd.setEmail_usuario(request.getParameter("email"));
        mensagemAdd.setStatus(2);             
        mensagemAdd.setTipo(request.getParameter("motivo"));
        dao.adicionarMensagem(mensagemAdd);
        return "index";    
    }
    
}
