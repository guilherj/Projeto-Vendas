/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import jdbc.ConnectionFactory;
import model.Produto;

/**
 *
 * @author Guilherme
 */
public class ProdutoDAO {
    
    private Connection conn;

    public ProdutoDAO() {
        this.conn = new ConnectionFactory().getConnection();
    }
    
    // Método Cadastrar Produto
    public void cadastrar(Produto obj){
        
        try{
            String sql = "INSERT INTO tb_produtos(descricao,preco,qtd_estoque,for_id) VALUES (?,?,?,?)";
            
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, obj.getDescricao());
            st.setDouble(2, obj.getPreco());
            st.setInt(3, obj.getQtdEstoque());
            
            st.setInt(4, obj.getFornecedor().getId());
            st.execute();
            st.close();
            
            JOptionPane.showMessageDialog(null, "Produto Cadastrado com Sucesso!");
            
        }catch(SQLException e){
            
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
            
        }
    }
    
}
