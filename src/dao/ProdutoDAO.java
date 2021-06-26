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
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import jdbc.ConnectionFactory;
import model.Fornecedor;
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
    public void cadastrar(Produto obj) {

        try {
            String sql = "INSERT INTO tb_produtos(descricao,preco,qtd_estoque,for_id) VALUES (?,?,?,?)";

            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, obj.getDescricao());
            st.setDouble(2, obj.getPreco());
            st.setInt(3, obj.getQtdEstoque());

            st.setInt(4, obj.getFornecedor().getId());
            st.execute();
            st.close();

            JOptionPane.showMessageDialog(null, "Produto Cadastrado com Sucesso!");

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());

        }
    }
    
    // Método Alterar Produto
    public void alterar(Produto obj) {

        try {
            String sql = "UPDATE tb_produtos SET descricao=?,preco=?,qtd_estoque=?,for_id=? WHERE id=?";

            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, obj.getDescricao());
            st.setDouble(2, obj.getPreco());
            st.setInt(3, obj.getQtdEstoque());

            st.setInt(4, obj.getFornecedor().getId());
            
            st.setInt(5, obj.getId());
            
            st.execute();
            st.close();

            JOptionPane.showMessageDialog(null, "Produto Alterado com Sucesso!");

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());

        }
    }
    
    //Método Excluir Produto
    public void excluir(Produto obj){
        
        try{
            
            String sql = "DELETE FROM tb_produtos WHERE id=?";
            
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1, obj.getId());
            
            st.execute();
            st.close();
            
            JOptionPane.showMessageDialog(null, "Produto Excluido com Sucesso!");
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
            
        }
    }

    //Método Listar produtos
    public List<Produto> listarProdutos() {

        try {

            // 1º Passo: Criar a lista
            List<Produto> lista = new ArrayList<>();

            // 2º Passo: Criar, organizar e executar o comando SQL
            String sql = "SELECT p.id, p.descricao, p.preco, p.qtd_estoque, f.nome FROM tb_produtos as p "
                    + "INNER JOIN tb_fornecedores f ON(p.for_id = f.id)";

            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Produto obj = new Produto();
                Fornecedor f = new Fornecedor();

                obj.setId(rs.getInt("p.id"));
                obj.setDescricao(rs.getString("p.descricao"));
                obj.setPreco(rs.getDouble("p.preco"));
                obj.setQtdEstoque(rs.getInt("p.qtd_estoque"));

                f.setNome(rs.getString("f.nome"));
                obj.setFornecedor(f);

                lista.add(obj);
            }

            return lista;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
            return null;

        }
    }
    
    //Método Listar produtos por nome
    public List<Produto> listarProdutosPorNome(String nome) {

        try {

            // 1º Passo: Criar a lista
            List<Produto> lista = new ArrayList<>();

            // 2º Passo: Criar, organizar e executar o comando SQL
            String sql = "SELECT p.id, p.descricao, p.preco, p.qtd_estoque, f.nome FROM tb_produtos as p "
                    + "INNER JOIN tb_fornecedores f ON(p.for_id = f.id) WHERE p.descricao LIKE ?";

            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, nome);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Produto obj = new Produto();
                Fornecedor f = new Fornecedor();

                obj.setId(rs.getInt("p.id"));
                obj.setDescricao(rs.getString("p.descricao"));
                obj.setPreco(rs.getDouble("p.preco"));
                obj.setQtdEstoque(rs.getInt("p.qtd_estoque"));

                f.setNome(rs.getString("f.nome"));
                obj.setFornecedor(f);

                lista.add(obj);
            }

            return lista;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
            return null;

        }
    }
    
    //Método Consutar produto por nome
    public Produto consultaProduto(String nome) {

        try {

            
            // 1º Passo: Criar, organizar e executar o comando SQL
            String sql = "SELECT p.id, p.descricao, p.preco, p.qtd_estoque, f.nome FROM tb_produtos as p "
                    + "INNER JOIN tb_fornecedores f ON(p.for_id = f.id) WHERE p.descricao=?";

            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, nome);
            ResultSet rs = st.executeQuery();
            
            Produto obj = new Produto();
            Fornecedor f = new Fornecedor();

            if(rs.next()) {
                
                obj.setId(rs.getInt("p.id"));
                obj.setDescricao(rs.getString("p.descricao"));
                obj.setPreco(rs.getDouble("p.preco"));
                obj.setQtdEstoque(rs.getInt("p.qtd_estoque"));

                f.setNome(rs.getString("f.nome"));
                obj.setFornecedor(f);
                
            }

            return obj;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
            return null;

        }
    }

}
