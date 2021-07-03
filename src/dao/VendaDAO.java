/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import jdbc.ConnectionFactory;
import model.Venda;

/**
 *
 * @author Guilherme
 */
public class VendaDAO {
    
    private Connection conn;
    
    public VendaDAO(){
        this.conn = new ConnectionFactory().getConnection();
    }
    
    // Método para Efetuar Venda
    public void efetuarVenda(Venda obj){
        
        try {
            String sql = "INSERT INTO tb_vendas(cliente_id,data_venda,total_venda) VALUES(?,?,?)";

            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1, obj.getCliente().getId());
            st.setString(2, obj.getDataVenda());
            st.setDouble(3, obj.getTotalvenda());
            
            st.execute();
            st.close();

            

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());

        }

    }
    
    // Método para Retornar última venda
    public int retornaUltimavenda(){
        
        try {
            int idVenda = 0;
            
            String sql = "select max(id) id from tb_vendas";
            
            PreparedStatement st = conn.prepareStatement(sql);
            
            ResultSet rs = st.executeQuery();
            
            if(rs.next()){
                Venda v = new Venda();
                v.setId(rs.getInt("id"));
                idVenda = v.getId();
            }
            
           return idVenda;
            
        } catch (SQLException e) {
          throw new RuntimeException(e);
         
        }
          
    }
    
}
