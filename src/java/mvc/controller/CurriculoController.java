/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.controller;


import java.io.IOException; 
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.servlet.http.HttpServletRequest;
import mvc.bean.Curriculo;
import mvc.dao.CurriculoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;

/**
 *
 * @author Aluno
 */
@Controller
public class CurriculoController {
    private CurriculoDAO dao;
    private static final String UPLOADED_FOLDER =
            "C:\\Users\\Aluno\\Documents\\ProjetoFinalWeb2\\ProjetoFinalWeb\\web\\resources\\curriculos\\";
    
    @Autowired
    public CurriculoController(CurriculoDAO dao){
        this.dao = dao;        
    }
    
    @RequestMapping("listarCurriculos")
    public String listar(Model model) throws IOException{
        List<Curriculo> listaCurriculos = dao.listarCurriculos();
        model.addAttribute("listaCurriculos", listaCurriculos);        
        return "curriculo/listarTodos";
    }
    
    @RequestMapping("formEnviarCurriculo")
    public String adicionar(){
        return "curriculo/enviarCurriculo";
    }  
           
    @RequestMapping(value="adicionarCurriculo", method=RequestMethod.POST)
    public String adicionarCurriculo(HttpServletRequest request, Model model, 
            @RequestParam("arquivoCurriculo") MultipartFile arquivoCurriculo){
        try{
            byte[] bytes = arquivoCurriculo.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER+arquivoCurriculo.getOriginalFilename());
            System.err.println("path: " + path);
            Files.write(path, bytes);
            Curriculo curriculoAdicionado = new Curriculo();
            curriculoAdicionado.setCurriculo_arquivo(arquivoCurriculo.getOriginalFilename());            
            curriculoAdicionado.setCandidato_nome(request.getParameter("nomeCandidato"));
            curriculoAdicionado.setCandidato_email(request.getParameter("emailCandidato"));
            dao.adicionarCurriculo(curriculoAdicionado);
            return "curriculo/adicao";            
        }catch(IOException e){
            e.printStackTrace();
            return "curriculo/erro-adicao";
        }
        
    }
  
   
    
    
}
