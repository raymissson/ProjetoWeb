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
import mvc.bean.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author david
 */
@Repository
public class CategoriaDAO {
    private final Connection connection;
    
    @Autowired
    public CategoriaDAO(DataSource dataSource){
        try{
            this.connection = dataSource.getConnection();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    
    public boolean adicionarCategoria(Categoria categoria){
        String sql = "INSERT INTO categoria (nome,descricao) VALUES (?, ?)";
        try(
        PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setString(1, categoria.getNome());            
            stmt.setString(2, categoria.getDescricao());
            stmt.execute();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
        return true;        
    }
    
    public List<Categoria> listarCategoria(){
        List<Categoria> categorias = new ArrayList<>();
        String sql = "SELECT cod_categoria, nome, descricao\n" +
                        "FROM categoria";        
        try{
            PreparedStatement smt = connection.prepareStatement(sql);
            ResultSet rs = smt.executeQuery();
            while(rs.next()){                
                Categoria categoria = new Categoria();
                categoria.setId(rs.getInt("cod_categoria"));
                categoria.setNome(rs.getString("nome"));
                categoria.setDescricao(rs.getString("descricao"));
                categorias.add(categoria);
            }
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
        return categorias;
    }
    
    public Categoria buscarCategoriaPorId(int id){
       String sql = "select * from categoria where cod_categoria = ? ";
       try ( 
        PreparedStatement stmt = connection.prepareStatement(sql)) {
        stmt.setInt(1,id);
        ResultSet rs = stmt.executeQuery();
        Categoria categoria = new Categoria();
        if(rs.next()) {
           categoria.setId(rs.getInt("cod_categoria"));
           categoria.setNome(rs.getString("nome"));
           categoria.setDescricao(rs.getString("descricao"));                         
        }
        return categoria;
       } catch (SQLException e) {
         throw new RuntimeException(e);
       }
    }
    
     public boolean alterarCategoria(Categoria categoria){
        String sql = "UPDATE categoria SET nome = ?,  descricao = ? " +
                        "WHERE cod_categoria = ?";
        try{
            PreparedStatement smt = connection.prepareStatement(sql);           
            smt.setString(1, categoria.getNome());            
            smt.setString(2, categoria.getDescricao());             
            smt.setLong(3, categoria.getId());
            smt.execute();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }        
        return true;
    }

    public void excluirCategoria(int id) {
       String sql = "delete from categoria where cod_categoria = ? ";
       try{
            PreparedStatement smt = connection.prepareStatement(sql);
            smt.setInt(1, id);                        
            smt.execute();            
        }catch(SQLException e){
            throw new RuntimeException(e);
        }       
    }
    
}
