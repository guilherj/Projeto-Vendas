/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import model.Cliente;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import jdbc.ConnectionFactory;

/**
 *
 * @author Guilherme
 */
public class ClienteDAO {
    
    private Connection conn;
    
    public ClienteDAO(){
        this.conn = new ConnectionFactory().getConnection();
    }
    
    //Método Cadastrar Cliente
    public void cadastrarCliente(Cliente obj){
        try {
         
         // 1º Passo - Criar o comando SQL   
         String sql = "insert into tb_clientes(nome,rg,cpf,email,telefone,celular,cep,endereco,numero,complemento,bairro,cidade,estado)"
                                        + " VALUE(?,?,?,?,?,?,?,?,?,?,?,?,?)";
            
        // 2º Passo - Conectar o bando de dados e organizar o código
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, obj.getNome());
            st.setString(2, obj.getRg());
            st.setString(3, obj.getCpf());
            st.setString(4, obj.getEmail());
            st.setString(5, obj.getTelefone());
            st.setString(6, obj.getCelular());
            st.setString(7, obj.getCep());
            st.setString(8, obj.getEndereco());
            st.setInt(9, obj.getNumero());
            st.setString(10, obj.getComplemento());
            st.setString(11, obj.getBairro());
            st.setString(12, obj.getCidade());
            st.setString(13, obj.getUf());
            
        // 3º Passo - Executar o comando SQL    
            st.execute();
            st.close();
            
            JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso!");
                      
         
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
        }
    }
    
    //Método Alterar Cliente
    public void alterarCliente(){
        
    }
    
    //Método Excluir Cliente
    public void excluirCliente(){
        
    }
    
}
