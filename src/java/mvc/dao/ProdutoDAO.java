/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import mvc.bean.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Aluno
 */
@Repository
public class ProdutoDAO {
    private final Connection connection;
    
    @Autowired
    public ProdutoDAO(DataSource dataSourcer){
        try {
            this.connection =dataSourcer.getConnection();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    
    public boolean adicionarProduto(Produto produto){
        String sql = "insert into produto (nome,descricao,imagem,preco_venda,categoria_cod_categoria) values (?,?,?,?,?)"; 
        
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, produto.getNome());
            stmt.setString(2, produto.getDescricao());
            stmt.setString(3, produto.getImagem());
            stmt.setDouble(4, produto.getPreco());
            stmt.setInt(5, produto.getCategoria());
            stmt.execute();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return true;
    }
    
    public List<Produto> listarProdutos(){
        List<Produto> produtos = new ArrayList<>();
        String sql = "SELECT cod_produto,nome,descricao,imagem,preco_venda,categoria_cod_categoria " +
                     "FROM produto";        
        try{
            PreparedStatement smt = connection.prepareStatement(sql);
            ResultSet rs = smt.executeQuery();
            while(rs.next()){                
                Produto produto = new Produto();
                produto.setId(rs.getInt("cod_produto"));
                produto.setNome(rs.getString("nome"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setImagem(rs.getString("imagem"));
                produto.setPreco(rs.getDouble("preco_venda"));
                produto.setCategoria(rs.getInt("categoria_cod_categoria"));                                
                produtos.add(produto);
            }
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
        return produtos;
    }
    
    public Produto pesquisarProdutoPorId(int id){
        Produto produto = new Produto();
        String sql = "SELECT cod_produto,nome,descricao,imagem,preco_venda,categoria_cod_categoria " +
                     "FROM produto "+
                     "WHERE cod_produto = ?";              
        
        try{
            PreparedStatement smt = connection.prepareStatement(sql);
            smt.setInt(1, id);
            ResultSet rs = smt.executeQuery();
            while(rs.next()){                                
                produto.setId(rs.getInt("cod_produto"));
                produto.setNome(rs.getString("nome"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setImagem(rs.getString("imagem"));
                produto.setPreco(rs.getDouble("preco_venda"));
                produto.setCategoria(rs.getInt("categoria_cod_categoria"));                                                
            }
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
        return produto;
    }
    public List<Produto> listarProdutoCategoria(int cod){
        List<Produto> produtos = new ArrayList<>();
        String sql = "SELECT cod_produto,nome,descricao,imagem,preco_venda,categoria_cod_categoria " +
                     "FROM produto WHERE categoria_cod_categoria=?";        
        try{
            PreparedStatement smt = connection.prepareStatement(sql);
            smt.setInt(1, cod);
            ResultSet rs = smt.executeQuery();
            while(rs.next()){                
                Produto produto = new Produto();
                produto.setId(rs.getInt("cod_produto"));
                produto.setNome(rs.getString("nome"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setImagem(rs.getString("imagem"));
                produto.setPreco(rs.getDouble("preco_venda"));
                produto.setCategoria(rs.getInt("categoria_cod_categoria"));                                
                produtos.add(produto);
            }
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
        return produtos;
    }
    
    public boolean alterarProduto(Produto produto){
        String sql = "UPDATE produto SET nome = ?,  descricao =?, imagem =?, preco=?. categoria_cod_categoria" +
                        "WHERE cod_produto = ?";
        try{
            PreparedStatement smt = connection.prepareStatement(sql);           
            smt.setString(1, produto.getNome());            
            smt.setString(2, produto.getDescricao());
            smt.setString(3, produto.getImagem());
            smt.setDouble(4, produto.getPreco());
            smt.setInt(5, produto.getCategoria());
            smt.setLong(6, produto.getId());
            smt.execute();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }        
        return true;
    }
    
    public void excluirProduto(int id) {
       String sql = "DELETE FROM produto WHERE cod_produto = ? ";
       try{
            PreparedStatement smt = connection.prepareStatement(sql);
            smt.setInt(1, id);                        
            smt.execute();            
        }catch(SQLException e){
            throw new RuntimeException(e);
        }       
    }
       
}
