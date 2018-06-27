/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;
import mvc.bean.Compra;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Aluno
 */
@Repository
public class compraDAO {
    Connection connection;
    
    @Autowired
    public compraDAO(DataSource datasource){
        try {        
            this.connection = datasource.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(compraDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void adicionarCompra(Compra compra){
        String sql = "INSERT INTO COMPRA(DATA_COMPRA, STATUS_COD_STATUS, TIPO_PAGTO_COD_TIPO_PAGTO, CLIENTE_COD_CLIENTE) VALUES (SYSDATE(), 1, 1, ?)";
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, compra.getCliente().getId());
        
    }catch(SQLException ex){
        Logger.getLogger(compraDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    }
    
}
