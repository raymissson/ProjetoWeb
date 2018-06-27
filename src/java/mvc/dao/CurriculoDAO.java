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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;
import mvc.bean.Curriculo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
/**
 *
 * @author Aluno
 */
@Repository
public class CurriculoDAO {
    private final Connection connection;
    
    @Autowired
    public CurriculoDAO(DataSource dataSource){
        try{
            this.connection = dataSource.getConnection();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }        
    }
    
    public void adicionarCurriculo(Curriculo curriculo){
        String sql = "INSERT INTO CURRICULO (curriculo_arquivo, candidato_nome, candidato_email) " +
                        "VALUES (?, ?, ?)";
        
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, curriculo.getCurriculo_arquivo());            
            stmt.setString(2, curriculo.getCandidato_nome());
            stmt.setString(3, curriculo.getCandidato_email());
            stmt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(CurriculoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public List<Curriculo> listarCurriculos(){
        List<Curriculo> listaCurriculos = new ArrayList<>();
        String sql = "SELECT CANDIDATO_NOME, CANDIDATO_EMAIL, CURRICULO_ARQUIVO " +
                        "FROM CURRICULO";
        PreparedStatement stmt;
        try {
            stmt = connection.prepareStatement(sql);
            ResultSet resultados = stmt.executeQuery();
            while(resultados.next()){
                Curriculo curriculo = new Curriculo();
                curriculo.setCandidato_nome(resultados.getString("CANDIDATO_NOME"));
                curriculo.setCandidato_email(resultados.getString("CANDIDATO_EMAIL"));
                curriculo.setCurriculo_arquivo(resultados.getString("CURRICULO_ARQUIVO"));                
                listaCurriculos.add(curriculo);
            }
           
        } catch (SQLException ex) {
            Logger.getLogger(CurriculoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listaCurriculos;
        
    }
        
}
