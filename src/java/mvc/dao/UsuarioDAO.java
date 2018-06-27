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
import mvc.bean.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author david
 */
@Repository
public class UsuarioDAO {
    private final Connection connection;
    
    @Autowired
    public UsuarioDAO(DataSource dataSource){
        try{
            this.connection = dataSource.getConnection();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    
    public boolean adicionaUsuario(Usuario usuario){
        String sql = "INSERT INTO usuario (nome, login, senha) VALUES (?, ?, ?)";
        try(
        PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getLogin());
            stmt.setString(3, usuario.getSenha());
            stmt.execute();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
        return true;        
    }
    
     public List<Usuario> listarUsuarios(){
        List<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT codigo, nome, login, senha\n" +
                        "FROM usuario";        
        try{
            PreparedStatement smt = connection.prepareStatement(sql);
            ResultSet resultados = smt.executeQuery();
            while(resultados.next()){                
                Usuario usuario = new Usuario();
                usuario.setId(resultados.getInt("codigo"));
                usuario.setNome(resultados.getString("nome"));
                usuario.setLogin(resultados.getString("login"));
                usuario.setSenha(resultados.getString("senha"));
                usuarios.add(usuario);                
            }
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
        return usuarios;
    }
    
    public Usuario buscarUsuarioPorId(int id){
       String sql = "select * from usuario where codigo = ? ";
       try ( 
        PreparedStatement stmt = connection.prepareStatement(sql)) {
        stmt.setLong(1,id);
        ResultSet rs = stmt.executeQuery();
        Usuario usuario = new Usuario();
        if(rs.next()) {
           usuario.setId(rs.getInt("codigo"));
           usuario.setNome(rs.getString("nome"));
           usuario.setLogin(rs.getString("login"));
           usuario.setSenha(rs.getString("senha"));                         
        }
        return usuario;
       } catch (SQLException e) {
         throw new RuntimeException(e);
       }
    }
    
    public boolean alterarUsuario(Usuario usuario){
        String sql = "UPDATE usuario SET nome = ?,  login = ?, senha = ? " +
                        "WHERE codigo = ?";
        try{
            PreparedStatement smt = connection.prepareStatement(sql);           
            smt.setString(1, usuario.getNome());            
            smt.setString(2, usuario.getLogin());
            smt.setString(3, usuario.getSenha());               
            smt.setLong(4, usuario.getId());
            smt.execute();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }        
        return true;
    }

    public boolean removerUsuario(int id){
       String sql = "delete from usuario where codigo = ? ";
       try ( 
        PreparedStatement stmt = connection.prepareStatement(sql)) {
        stmt.setLong(1,id);
        stmt.execute();
       } catch (SQLException e) {
         throw new RuntimeException(e);
       }
       return true;
    }
    
    public boolean validarLogin(Usuario usuario){
        String sql = "select * from usuario where login = ? and senha = ? ";        
        try ( 
                PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setString(1, usuario.getLogin());
                stmt.setString(2, usuario.getSenha());
                System.out.println("Consulta "+stmt);
                ResultSet rs = stmt.executeQuery();
                if(rs.next()) {
                  return true;        
                }else{
                    return false;
                }
       } catch (SQLException e) {
           throw new RuntimeException(e);
       }
    }
    
    public boolean validarAdmin(int id){
        String sql = "select * from usuario where login = ? and tipo_usuario = 1 ";
        try ( 
                PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setInt(1, id);
                ResultSet rs = stmt.executeQuery();
                if(rs.next()) {
                  return true;        
                }else{
                    return false;
                }
       } catch (SQLException e) {
           throw new RuntimeException(e);
       }
    }
}
