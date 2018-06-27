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
import mvc.bean.Mensagem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author david
 */
@Repository
public class MensagemDAO {
    private final Connection connection;
    
    @Autowired
    public MensagemDAO(DataSource dataSource){
        try{
            this.connection = dataSource.getConnection();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    
     public boolean adicionarMensagem(Mensagem mensagem){
        String sql = "INSERT INTO mensagem (conteudo, tipo, nome_usuario, email_usuario, status_resposta) VALUES(?, ?, ?, ?, ?)";
        try(
        PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setString(1, mensagem.getConteudo());
            stmt.setString(2, mensagem.getTipo());
            stmt.setString(3, mensagem.getNome_usuario());
            stmt.setString(4, mensagem.getEmail_usuario());
            stmt.setInt(5, mensagem.getStatus());                      
            stmt.execute();
            System.out.println("Teste!");
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
        return true;        
    }
    
     public List<Mensagem> listarMensagens(){
        List<Mensagem> mensagens = new ArrayList<>();
        String sql = "SELECT conteudo, tipo, nome_usuario, email_usuario, status_resposta\n" +
                        "FROM mensagem";        
        try{
            PreparedStatement smt = connection.prepareStatement(sql);
            ResultSet resultados = smt.executeQuery();
            while(resultados.next()){                
                Mensagem mensagem = new Mensagem();  
                mensagem.setConteudo(resultados.getString("conteudo"));
                mensagem.setTipo(resultados.getString("tipo"));
                mensagem.setNome_usuario(resultados.getString("nome_usuario"));
                mensagem.setEmail_usuario(resultados.getString("email_usuario"));
                mensagem.setStatus(resultados.getInt("status_resposta"));
                mensagens.add(mensagem);
            }
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
        return mensagens;
    }
        
    
}
