package mvc.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.imageio.ImageIO;
import javax.xml.bind.DatatypeConverter;
import mvc.bean.Categoria;
import mvc.bean.Produto;
import mvc.dao.CategoriaDAO;
import mvc.dao.ProdutoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 *
 * @author Raymison
 */
@Controller
public class IndexController {
    private final ProdutoDAO pro;
    private final CategoriaDAO cat;
    @Autowired
    public IndexController(ProdutoDAO pro, CategoriaDAO cat){
        this.pro = pro;
        this.cat=cat;
    }
    @RequestMapping("/")
    public String index(Model model) throws IOException{
        List<Produto> listaProdutos = pro.listarProdutos();
        List<Categoria> listaCategoria = cat.listarCategoria();
        setImagePath(listaProdutos);
        
        for (Produto listaProduto : listaProdutos) {
            System.out.println(""+ listaProduto.getImagem());
        }
        model.addAttribute("listaCategoria",listaCategoria);
        model.addAttribute("listaProdutos", listaProdutos);
        return "index";
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
    
    @RequestMapping("/carregarCarrinho")
    private String carrinho(){
        return "carrinho";
    }

}
