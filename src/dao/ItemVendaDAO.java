/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import jdbc.ConnectionFactory;
import model.Cliente;
import model.ItemVenda;
import model.Produto;
import model.Venda;


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
    
    public List<ItemVenda> ItensPorVenda(int vendaId) {

        try {

            // 1º Passo: Criar a lista
            List<ItemVenda> lista = new ArrayList<>();
          
            // 2º Passo: Criar, organizar e executar o comando SQL
            String sql = "select p.id, p.descricao, i.qtd, p.preco, i.subtotal from tb_itensvendas as i "
                    + " inner join tb_produtos as p on(i.produto_id = p.id) where i.venda_id =?";

            PreparedStatement st = conn.prepareStatement(sql);
                                 
            st.setInt(1, vendaId);
            
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                ItemVenda item = new ItemVenda();
                Produto produto = new Produto();
                
                item.setId(rs.getInt("p.id"));
                produto.setDescricao(rs.getString("p.descricao"));
                item.setQtd(rs.getInt("i.qtd"));
                produto.setPreco(rs.getDouble("p.preco"));
                item.setSubTotal(rs.getDouble("i.subtotal"));
                
                item.setProduto(produto);
                
               
                lista.add(item);
            }

            return lista;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
            return null;

        }
    }
}
