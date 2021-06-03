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
}
