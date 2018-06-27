/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.dao;

import java.sql.Connection;
//import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import mvc.bean.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Raymison
 */
@Repository
public class ClienteDAO {
    private final Connection connection;
    
    @Autowired
    public ClienteDAO(DataSource dataSource){
        try{
            this.connection = dataSource.getConnection();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    
    public boolean adicionarCliente(Cliente cliente){
        String sql = "insert into cliente (cpf,nome,email,telefone,login,senha) values (?,?,?,?,?,?)";
        try(
        PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setString(1, cliente.getCpf());
            stmt.setString(2, cliente.getNome());
            stmt.setString(3, cliente.getEmail());
            stmt.setString(4, cliente.getTelefone());            
            //stmt.setDate(5, new Date(cliente.getDataNascimento()));
            stmt.setString(5, cliente.getLogin());
            stmt.setString(6, cliente.getSenha());
          //  stmt.setDate(7, new Date(cliente.getDataCadastro().getTimeInMillis()));
            stmt.execute();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
        return true;
    }
    
    public List<Cliente> listarClientes(){
        List<Cliente> listaClientes = new ArrayList<Cliente>();
        String sql = "select * from cliente order by cod_cliente";
        try(
        PreparedStatement stmt = connection.prepareStatement(sql)){
        ResultSet rs = stmt.executeQuery();
        while(rs.next()){
            Cliente cliente = new Cliente();
            cliente.setId(rs.getInt("cod_cliente"));
            cliente.setCpf(rs.getString("cpf"));
            cliente.setNome(rs.getString("nome"));
            cliente.setEmail(rs.getString("email"));
            cliente.setTelefone(rs.getString("telefone"));
            cliente.setLogin(rs.getString("login"));
            cliente.setSenha(rs.getString("senha"));
            listaClientes.add(cliente);
        }
      }catch(SQLException e){
          throw new RuntimeException(e);
      }
      return listaClientes;
    }
    
    public boolean removerCliente(int id){
        String sql = "delete from cliente where cod_cliente=?";
        try(
                PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setInt(1, id);
            stmt.execute();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
        return true;
    }
    
    public Cliente buscarClientePorId(int id) throws SQLException{
        String sql="select * from cliente where cod_cliente=?";
        Cliente cliente = new Cliente(); 
        
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            
            if(rs.next()){
                cliente.setId(rs.getInt("cod_cliente"));
                cliente.setCpf("cpf");
                cliente.setNome("nome");
                cliente.setEmail("email");
                cliente.setTelefone("telefone");
                cliente.setLogin("login");
                cliente.setSenha("senha");
            }
        
        return cliente;
    }
    
    public boolean alterarCliente(Cliente cliente){
        String sql = "update cliente set cpf=?,nome=?,email=?,telefone=?,login=?,senha=?,"
                + "where cod_cliente=?";
        try(
              PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setString(1, cliente.getCpf());
            stmt.setString(2, cliente.getNome());
            stmt.setString(3, cliente.getEmail());
            stmt.setString(4, cliente.getTelefone());
            stmt.setString(5, cliente.getLogin());
            stmt.setString(6, cliente.getSenha());
            stmt.setInt(7, cliente.getId());
            stmt.execute();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
        return true;
    }
}
