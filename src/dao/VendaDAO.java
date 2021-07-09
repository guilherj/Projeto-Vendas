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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import jdbc.ConnectionFactory;
import model.Cliente;
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
    
    // Método para Filtrar Vendas Por Período
     public List<Venda> vendaPorPeriodo(LocalDate dataInicial, LocalDate dataFinal) {

        try {

            // 1º Passo: Criar a lista
            List<Venda> lista = new ArrayList<>();
            
            String dataHoraInicial;
            String dataHoraFinal;

            // 2º Passo: Criar, organizar e executar o comando SQL
            String sql = "SELECT v.id, date_format(v.data_venda,'%d/%m/%Y %H:%m:%s') as data_formatada, c.nome, v.total_venda FROM tb_vendas as v "
                    + "INNER JOIN tb_clientes as c ON(v.cliente_id = c.id) WHERE v.data_venda BETWEEN ? AND ?";

            PreparedStatement st = conn.prepareStatement(sql);
            
            dataHoraInicial = dataInicial.toString() + " 00:00:00";
            dataHoraFinal = dataFinal.toString() + " 23:59:59";
            
            st.setString(1, dataHoraInicial);
            st.setString(2, dataHoraFinal);
            
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Venda obj = new Venda();
                Cliente c = new Cliente();
                
                obj.setId(rs.getInt("v.id"));
                obj.setDataVenda(rs.getString("data_formatada"));
                c.setNome(rs.getString("c.nome"));
                obj.setTotalvenda(rs.getDouble("v.total_venda"));
                
                obj.setCliente(c);
               
                lista.add(obj);
            }

            return lista;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
            return null;

        }
    }
    
}
