/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import jdbc.ConnectionFactory;
import model.ItemVenda;


/**
 *
 * @author Guilherme
 */
public class ItemVendaDAO {
    
    private Connection conn;
    
    public ItemVendaDAO(){
        this.conn = new ConnectionFactory().getConnection();
    }
    
    // Método para Adicionar o Itens da Venda
    public void ItensVenda(ItemVenda obj){
        
        try {
            String sql = "INSERT INTO tb_itensvendas(venda_id,produto_id,qtd,subtotal) VALUES(?,?,?,?)";

            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1, obj.getVenda().getId());
            st.setInt(2, obj.getProduto().getId());
            st.setInt(3, obj.getQtd());
            st.setDouble(4, obj.getSubTotal());
            
            st.execute();
            st.close();

            

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());

        }

    }
}
