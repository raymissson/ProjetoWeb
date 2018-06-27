/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.controller;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.xml.bind.DatatypeConverter;
import mvc.bean.Categoria;
import mvc.bean.Produto;
import mvc.bean.Usuario;
import mvc.dao.CategoriaDAO;
import mvc.dao.ProdutoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

/**
 *
 * @author Aluno
 */
@Controller
public class ProdutoController {
    private final CategoriaDAO cat;
    private final ProdutoDAO dao;
    private static final String UPLOADED_FOLDER = 
            "C:\\Users\\Aluno\\Documents\\ProjetoFinalWeb2\\ProjetoFinalWeb\\web\\resources\\img\\";            
    @Autowired
    public ProdutoController(ProdutoDAO dao, CategoriaDAO cat){
        this.dao = dao;
        this.cat=cat;
    }
    
    @RequestMapping("/formAdicionarProduto")
    public String form(Model model){
        List<Categoria> listaCategoria = cat.listarCategoria();
        model.addAttribute("listaCategoria",listaCategoria);
        return "produto/formularioAdicionar";       
    }
    
    @RequestMapping(value="/adicionarProduto", method=RequestMethod.POST)
    public String adiciona(HttpServletRequest request, Model model){
        /*
        Configuracoes necessárias
        Fonte: http://www.pablocantero.com/blog/2010/09/29/upload-com-spring-mvc/
        */
        try {
            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
            MultipartFile multipartFile = multipartRequest.getFile("photo");
            
            String destinyPath = "C:\\Users\\Aluno\\Documents\\NetBeansProjects\\ProjetoFinalWeb\\web\\resources\\img\\";
            if(!(new File(destinyPath)).exists()){
                (new File(destinyPath)).mkdir();
            }
            
            String photoName = multipartFile.getOriginalFilename();
            String photoPath = destinyPath + photoName;
                       
            File photoFile = new File(photoPath);
            multipartFile.transferTo(photoFile);
            
            //backup
            //File destinationDir = new File(applicationPath);
            //FileUtils.copyFileToDirectory(photoFile, destinationDir);
            
            Produto produto = new Produto();
            produto.setNome(request.getParameter("nome"));
            produto.setDescricao(request.getParameter("descricao"));
            produto.setImagem(photoPath);
            produto.setPreco(Double.parseDouble(request.getParameter(("preco_venda"))));
            produto.setCategoria(Integer.parseInt(request.getParameter("categoria_cod_categoria")));
            dao.adicionarProduto(produto);
            return "index";
            
        } catch (IOException ex) {
            //model.addAttribute("erro", ex.toString());
            return "index";
        } 
    }
    
    private void setImagePath(List<Produto> listaProdutos) throws IOException{
        
        for (Produto produto : listaProdutos) {
            
            try{
                BufferedImage bImage = ImageIO.read(new File(produto.getImagem()));            
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                ImageIO.write( bImage, "jpg", baos );
                baos.flush();
                byte[] imageInByteArray = baos.toByteArray();
                baos.close();                                   
                String b64 = DatatypeConverter.printBase64Binary(imageInByteArray);
                produto.setImagem(b64);            
                
            }catch(Exception e){
                 e.printStackTrace();
            }
            
            
        }
            
    }
    private void setImagePath(Produto produto){
        try{
            BufferedImage bImage = ImageIO.read(new File(produto.getImagem()));            
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                ImageIO.write( bImage, "jpg", baos );
                baos.flush();
                byte[] imageInByteArray = baos.toByteArray();
                baos.close();                                   
                String b64 = DatatypeConverter.printBase64Binary(imageInByteArray);
                produto.setImagem(b64);   
        }catch(Exception e){
                 e.printStackTrace();
            }
    }
    
    @RequestMapping("/listaProduto")
    public String lista(Model model) throws IOException{
        List<Produto> listaProdutos = dao.listarProdutos();
        setImagePath(listaProdutos);     
        model.addAttribute("listaProdutos", listaProdutos);
        return "produto/listarTodos";
    }
    
    @RequestMapping("/formVisualizarProduto")
    public String exibeDetalhe(int id, Model model){
        Produto produto = new Produto();
        produto = dao.pesquisarProdutoPorId(id);
        setImagePath(produto);
        model.addAttribute("produto", produto);
        return "produto/detalhesProduto";
    }
    
    @RequestMapping("/listaProdutoCategoria")
    public String listaProdutoCategoria(int id, Model model) throws IOException{
        List<Produto> listaProdutos = dao.listarProdutoCategoria(id);
        List<Categoria> listaCategoria = cat.listarCategoria();
        model.addAttribute("listaCategoria",listaCategoria);
        setImagePath(listaProdutos);
        
        for (Produto listaProduto : listaProdutos) {
            System.out.println(""+ listaProduto.getImagem());
        }
        
        model.addAttribute("listaProdutos", listaProdutos);
        return "produto/produtoPorCategoria";
    }
    
    @RequestMapping("/formEditarProduto")
    public String editar(int id, Model model){
        List<Categoria> listaCategoria = cat.listarCategoria();
        model.addAttribute("listaCategoria",listaCategoria);
        Produto produto = new Produto();
        produto = dao.pesquisarProdutoPorId(id);
        setImagePath(produto);
        model.addAttribute("produto", produto);
        return "produto/formularioEditar";
    }
    
    @RequestMapping("/alterarProduto")
    public String alterar(@Valid Produto produto,BindingResult result,HttpServletRequest request, Model model){
        dao.alterarProduto(produto);
        return "redirect:/listarTodos";
    }
    
    @RequestMapping("/formExcluirProduto")
    public String excluir(int id){
        dao.excluirProduto(id);
        return "redirect:/listaProduto";
    }
    
    @RequestMapping("/efetuarCompra")
    public String finalizarCompra(@Valid Produto produto,BindingResult result,HttpServletRequest request, Model model, HttpSession session){        
        if(dao.adicionarProduto(produto)){
            return "comprarProduto";            
        }else{
            return "comprarProduto-falha";
        }
        
    }
}
