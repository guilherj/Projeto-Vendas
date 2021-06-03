/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import jdbc.ConnectionFactory;
import model.Funcionario;

/**
 *
 * @author Guilherme
 */
public class FuncionarioDAO {

    private Connection conn;

    public FuncionarioDAO() {
        this.conn = new ConnectionFactory().getConnection();
    }

    //Método Cadastrar Funcionario
    public void cadastrarFuncionario(Funcionario obj) {
        try {

            // 1º Passo - Criar o comando SQL   
            String sql = "insert into tb_funcionarios(nome,rg,cpf,email,senha,cargo,nivel_acesso,telefone,celular,cep,endereco,"
                    + "numero,complemento,bairro,cidade,estado)VALUE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

            // 2º Passo - Conectar o bando de dados e organizar o código
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, obj.getNome());
            st.setString(2, obj.getRg());
            st.setString(3, obj.getCpf());
            st.setString(4, obj.getEmail());
            st.setString(5, obj.getSenha());
            st.setString(6, obj.getCargo());
            st.setString(7, obj.getNivelAcesso());
            st.setString(8, obj.getTelefone());
            st.setString(9, obj.getCelular());
            st.setString(10, obj.getCep());
            st.setString(11, obj.getEndereco());
            st.setInt(12, obj.getNumero());
            st.setString(13, obj.getComplemento());
            st.setString(14, obj.getBairro());
            st.setString(15, obj.getCidade());
            st.setString(16, obj.getUf());

            // 3º Passo - Executar o comando SQL    
            st.execute();
            st.close();

            JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso!");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
        }
    }
    
    // Método Listar Funcionarios
    public List<Funcionario> listarFuncionarios() {

        try {
            List<Funcionario> list = new ArrayList<>();
            String sql = "select * from tb_funcionarios";
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Funcionario obj = new Funcionario();

                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                
                obj.setSenha(rs.getString("senha"));
                obj.setCargo(rs.getString("cargo"));
                obj.setNivelAcesso(rs.getString("nivel_acesso"));
                
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
