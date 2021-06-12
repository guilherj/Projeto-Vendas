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
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import jdbc.ConnectionFactory;
import model.Fornecedor;
import model.WebServiceCep;

/**
 *
 * @author Guilherme
 */
public class FornecedorDAO {
    
    private Connection conn;

    public FornecedorDAO() {
        this.conn = new ConnectionFactory().getConnection();
    }

    //Método Cadastrar Fornecedor
    public void cadastrarFornecedor(Fornecedor obj) {
        try {

            // 1º Passo - Criar o comando SQL   
            String sql = "insert into tb_fornecedores(nome,cnpj,email,telefone,celular,cep,endereco,numero,complemento,bairro,cidade,estado)"
                    + " VALUE(?,?,?,?,?,?,?,?,?,?,?,?)";

            // 2º Passo - Conectar o bando de dados e organizar o código
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, obj.getNome());
            st.setString(2, obj.getCnpj());
            st.setString(3, obj.getEmail());
            st.setString(4, obj.getTelefone());
            st.setString(5, obj.getCelular());
            st.setString(6, obj.getCep());
            st.setString(7, obj.getEndereco());
            st.setInt(8, obj.getNumero());
            st.setString(9, obj.getComplemento());
            st.setString(10, obj.getBairro());
            st.setString(11, obj.getCidade());
            st.setString(12, obj.getUf());

            // 3º Passo - Executar o comando SQL    
            st.execute();
            st.close();

            JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso!");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
        }
    }
    
    //Método Alterar Fornecedor
    public void alterarFornecedor(Fornecedor obj) {
        try {

            // 1º Passo - Criar o comando SQL   
            String sql = "update tb_fornecedores set nome=?,cnpj=?,email=?,telefone=?,celular=?,cep=?,"
                    + "endereco=?,numero=?,complemento=?,bairro=?,cidade=?,estado=? where id =?";

            // 2º Passo - Conectar o bando de dados e organizar o código
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, obj.getNome());
            st.setString(2, obj.getCnpj());
            st.setString(3, obj.getEmail());
            st.setString(4, obj.getTelefone());
            st.setString(5, obj.getCelular());
            st.setString(6, obj.getCep());
            st.setString(7, obj.getEndereco());
            st.setInt(8, obj.getNumero());
            st.setString(9, obj.getComplemento());
            st.setString(10, obj.getBairro());
            st.setString(11, obj.getCidade());
            st.setString(12, obj.getUf());

            st.setInt(13, obj.getId());

            // 3º Passo - Executar o comando SQL    
            st.execute();
            st.close();

            JOptionPane.showMessageDialog(null, "Alterado com Sucesso!");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
        }
    }

    //Método Excluir Fornecedor
    public void excluirFornecedor(Fornecedor obj) {
        try {

            // 1º Passo - Criar o comando SQL   
            String sql = "delete from tb_fornecedores where id = ?";

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
    public List<Fornecedor> listarFornecedores() {

        try {
            List<Fornecedor> list = new ArrayList<>();
            String sql = "select * from tb_fornecedores";
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Fornecedor obj = new Fornecedor();

                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setCnpj(rs.getString("cnpj"));
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

    // Método para consulta do Fornecedor por nome
    public Fornecedor consultaFornecedor(String nome) {

        try {
            String sql = "select * from tb_fornecedores where nome=?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, nome);

            ResultSet rs = st.executeQuery();
            Fornecedor obj = new Fornecedor();

            if (rs.next()) {

                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setCnpj(rs.getString("cnpj"));
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

            }

            return obj;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Fornecedor não Encontrado");
            return null;
        }
    }

    // Método para buscar Fornecedores por nome
    public List<Fornecedor> buscarFornecedorPorNome(String nome) {

        try {
            List<Fornecedor> list = new ArrayList<>();
            String sql = "select * from tb_fornecedores where nome like ?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, nome);

            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Fornecedor obj = new Fornecedor();

                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setCnpj(rs.getString("cnpj"));
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
    
    // Prenchimento automatico do endereço pelo cep (precisa de internet)
    public Fornecedor buscaCep(String cep) {

        WebServiceCep webServiceCep = WebServiceCep.searchCep(cep);

        Fornecedor obj = new Fornecedor();

        if (webServiceCep.wasSuccessful()) {
            obj.setEndereco(webServiceCep.getLogradouroFull());
            obj.setCidade(webServiceCep.getCidade());
            obj.setBairro(webServiceCep.getBairro());
            obj.setUf(webServiceCep.getUf());
            return obj;
        } else {
            JOptionPane.showMessageDialog(null, "Erro numero: " + webServiceCep.getResulCode());
            JOptionPane.showMessageDialog(null, "Descrição do erro: " + webServiceCep.getResultText());
            return null;
        }

    }
    
}
