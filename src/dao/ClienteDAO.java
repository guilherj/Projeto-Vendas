/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.Cliente;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import jdbc.ConnectionFactory;

/**
 *
 * @author Guilherme
 */
public class ClienteDAO {

    private Connection conn;

    public ClienteDAO() {
        this.conn = new ConnectionFactory().getConnection();
    }

    //Método Cadastrar Cliente
    public void cadastrarCliente(Cliente obj) {
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
    public void alterarCliente(Cliente obj) {
        try {

            // 1º Passo - Criar o comando SQL   
            String sql = "update tb_clientes set nome=?,rg=?,cpf=?,email=?,telefone=?,celular=?,cep=?,"
                         + "endereco=?,numero=?,complemento=?,bairro=?,cidade=?,estado=? where id =?";
                    

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
            
            st.setInt(14, obj.getId());

            // 3º Passo - Executar o comando SQL    
            st.execute();
            st.close();

            JOptionPane.showMessageDialog(null, "Alterado com Sucesso!");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
        }
    }

    //Método Excluir Cliente
    public void excluirCliente(Cliente obj) {
        try {

            // 1º Passo - Criar o comando SQL   
            String sql = "delete from where id = ?";

            // 2º Passo - Conectar o bando de dados e organizar o código
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1, obj.getId());

            // 3º Passo - Executar o comando SQL    
            st.execute();
            st.close();

            JOptionPane.showMessageDialog(null, "Excluido com Sucesso!");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
        }
    }

    // Método Listar Clientes
    public List<Cliente> listarClientes() {

        try {
            List<Cliente> list = new ArrayList<>();
            String sql = "select * from tb_clientes";
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Cliente obj = new Cliente();

                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                obj.setTelefone(rs.getString("telefone"));
                obj.setCelular(rs.getString("celular"));
                obj.setCep(rs.getString("cep"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setNumero(rs.getInt("numero"));
                obj.setComplemento(rs.getString("complemento"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setUf(rs.getString("estado"));

                list.add(obj);

            }

            return list;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
            return null;
        }

    }

}
