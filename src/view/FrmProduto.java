/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.ClienteDAO;
import dao.FornecedorDAO;
import dao.ProdutoDAO;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Cliente;
import model.Fornecedor;
import model.Produto;
import util.uteis;

/**
 *
 * @author Guilherme
 */
public class FrmProduto extends javax.swing.JFrame {
    
    public void listar(){
        
        ClienteDAO dao = new ClienteDAO();
        List<Cliente> list = dao.listarClientes();
        
        DefaultTableModel dados = (DefaultTableModel) tableViewProdutos.getModel();
        dados.setNumRows(0); //Zera a tabela
        
        for(Cliente c : list){
            
            dados.addRow(new Object[]{
            
            c.getId(),
            c.getNome(),
            c.getRg(),
            c.getCpf(),
            c.getEmail(),
            c.getTelefone(),
            c.getCelular(),
            c.getCep(),
            c.getEndereco(),
            c.getNumero(),
            c.getComplemento(),
            c.getBairro(),
            c.getCidade(),
            c.getUf()
            });
            
        }
        
        
        
    }

    /**
     * Creates new form FrmCliente
     */
    public FrmProduto() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        panelDadosPessoais = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtDescricao = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtPreco = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtQtdEstoque = new javax.swing.JTextField();
        comboBoxFornecedor = new javax.swing.JComboBox();
        btPesquisar = new javax.swing.JButton();
        panelConsultaClientes = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        txtPesquisa = new javax.swing.JTextField();
        btPesquisarConsulta = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableViewProdutos = new javax.swing.JTable();
        btNovo = new javax.swing.JButton();
        btSalvar = new javax.swing.JButton();
        btEditar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 102, 204));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Cadastro de Produtos");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Código");

        txtCodigo.setEditable(false);
        txtCodigo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Descrição");

        txtDescricao.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtDescricao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescricaoActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Quantidade");

        txtPreco.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtPreco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecoActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Preço");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Fornecedor");

        txtQtdEstoque.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtQtdEstoque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQtdEstoqueActionPerformed(evt);
            }
        });

        comboBoxFornecedor.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        comboBoxFornecedor.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                comboBoxFornecedorAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        comboBoxFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxFornecedorActionPerformed(evt);
            }
        });

        btPesquisar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btPesquisar.setText("Pesquisar");
        btPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPesquisarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelDadosPessoaisLayout = new javax.swing.GroupLayout(panelDadosPessoais);
        panelDadosPessoais.setLayout(panelDadosPessoaisLayout);
        panelDadosPessoaisLayout.setHorizontalGroup(
            panelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDadosPessoaisLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel5)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(comboBoxFornecedor, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelDadosPessoaisLayout.createSequentialGroup()
                            .addGap(148, 148, 148)
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtQtdEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelDadosPessoaisLayout.createSequentialGroup()
                        .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btPesquisar))
                    .addComponent(txtPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(528, Short.MAX_VALUE))
        );
        panelDadosPessoaisLayout.setVerticalGroup(
            panelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDadosPessoaisLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(panelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(btPesquisar)
                    .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(panelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(txtQtdEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(comboBoxFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(151, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Dados do Produto", panelDadosPessoais);

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setText("Nome");

        txtPesquisa.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPesquisaActionPerformed(evt);
            }
        });
        txtPesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPesquisaKeyPressed(evt);
            }
        });

        btPesquisarConsulta.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btPesquisarConsulta.setText("Pesquisar");
        btPesquisarConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPesquisarConsultaActionPerformed(evt);
            }
        });

        tableViewProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Descrição", "Preço", "Qtd. Estoque", "Fornecedor"
            }
        ));
        tableViewProdutos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableViewProdutosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableViewProdutos);

        javax.swing.GroupLayout panelConsultaClientesLayout = new javax.swing.GroupLayout(panelConsultaClientes);
        panelConsultaClientes.setLayout(panelConsultaClientesLayout);
        panelConsultaClientesLayout.setHorizontalGroup(
            panelConsultaClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelConsultaClientesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelConsultaClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(panelConsultaClientesLayout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btPesquisarConsulta)
                        .addGap(0, 549, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelConsultaClientesLayout.setVerticalGroup(
            panelConsultaClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelConsultaClientesLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(panelConsultaClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txtPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btPesquisarConsulta))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Consulta de Produtos", panelConsultaClientes);

        btNovo.setText("NOVO");
        btNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNovoActionPerformed(evt);
            }
        });

        btSalvar.setText("SALVAR");
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });

        btEditar.setText("EDITAR");
        btEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditarActionPerformed(evt);
            }
        });

        btExcluir.setText("EXCLUIR");
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1054, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(326, 326, 326)
                .addComponent(btNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btSalvar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btEditar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btExcluir)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btEditar, btExcluir, btNovo, btSalvar});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btSalvar)
                    .addComponent(btEditar)
                    .addComponent(btExcluir))
                .addGap(45, 45, 45))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btEditar, btExcluir, btNovo, btSalvar});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoActionPerformed

    private void txtDescricaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescricaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescricaoActionPerformed

    private void txtPrecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecoActionPerformed

    private void txtQtdEstoqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQtdEstoqueActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtQtdEstoqueActionPerformed

    private void comboBoxFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxFornecedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxFornecedorActionPerformed

    private void txtPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPesquisaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPesquisaActionPerformed

    private void btPesquisarConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPesquisarConsultaActionPerformed
        // Botão Pesquisar na aba consulta
        
        String nome = "%" + txtPesquisa.getText() + "%";
        
        ClienteDAO dao = new ClienteDAO();
        List<Cliente> list = dao.buscarClientePorNome(nome);
        
        DefaultTableModel dados = (DefaultTableModel) tableViewProdutos.getModel();
        dados.setNumRows(0); //Zera a tabela
        
        for(Cliente c : list){
            
            dados.addRow(new Object[]{
            
            c.getId(),
            c.getNome(),
            c.getRg(),
            c.getCpf(),
            c.getEmail(),
            c.getTelefone(),
            c.getCelular(),
            c.getCep(),
            c.getEndereco(),
            c.getNumero(),
            c.getComplemento(),
            c.getBairro(),
            c.getCidade(),
            c.getUf()
            });
            
        }
        
    }//GEN-LAST:event_btPesquisarConsultaActionPerformed

    private void btNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoActionPerformed
        // TODO add your handling code here:
        
        uteis.limparTela(panelDadosPessoais);
    }//GEN-LAST:event_btNovoActionPerformed

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        // BOTÃO SALVAR

       Produto obj = new Produto();
       
       obj.setDescricao(txtDescricao.getText());
       obj.setPreco(Double.parseDouble(txtPreco.getText()));
       obj.setQtdEstoque(Integer.parseInt(txtQtdEstoque.getText()));
       
       Fornecedor fornecedor = new Fornecedor();
       
       fornecedor = (Fornecedor) comboBoxFornecedor.getSelectedItem();
       obj.setFornecedor(fornecedor);
       
        ProdutoDAO dao = new ProdutoDAO();
        dao.cadastrar(obj);
        uteis.limparTela(panelDadosPessoais);


    }//GEN-LAST:event_btSalvarActionPerformed

    private void btEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditarActionPerformed
         // BOTÃO EDITAR

        Cliente obj = new Cliente();
        
//        obj.setNome(txtDescricao.getText());
//        obj.setRg(txtRg.getText());
//        obj.setCpf(txtCpf.getText());
//        obj.setEmail(txtPreco.getText());
//        obj.setTelefone(txtTelefone.getText());
//        obj.setCelular(txtCelular.getText());
//        obj.setCep(txtCep.getText());
//        obj.setEndereco(txtQtdEstoque.getText());
//        obj.setNumero(Integer.parseInt(txtNumero.getText()));
//        obj.setComplemento(txtComplemento.getText());
//        obj.setBairro(txtBairro.getText());
//        obj.setCidade(txtCidade.getText());
//        obj.setUf(comboBoxFornecedor.getSelectedItem().toString());
        
        obj.setId(Integer.parseInt(txtCodigo.getText()));

        ClienteDAO dao = new ClienteDAO();
        dao.alterarCliente(obj);
        uteis.limparTela(panelDadosPessoais);

    }//GEN-LAST:event_btEditarActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
         // BOTÃO EXCLUIR

        Cliente obj = new Cliente();
                
        obj.setId(Integer.parseInt(txtCodigo.getText()));

        ClienteDAO dao = new ClienteDAO();
        dao.excluirCliente(obj);
        uteis.limparTela(panelDadosPessoais);
    }//GEN-LAST:event_btExcluirActionPerformed

    private void btPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPesquisarActionPerformed
        // Botão Buscar Cliente por nome
        String nome = txtDescricao.getText();
        Cliente obj = new Cliente();
        ClienteDAO dao = new ClienteDAO();
        
        obj = dao.consultaCliente(nome);
        
        // Exibir os dados do obj nos text fields
        if(obj.getNome() != null){
        txtCodigo.setText(String.valueOf(obj.getId()));
        txtDescricao.setText(obj.getNome());
//        txtRg.setText(obj.getRg());
//        txtCpf.setText(obj.getCpf());
//        txtPreco.setText(obj.getEmail());
//        txtTelefone.setText(obj.getTelefone());
//        txtCelular.setText(obj.getCelular());
//        txtCep.setText(obj.getCep());
//        txtQtdEstoque.setText(obj.getEndereco());
//        txtNumero.setText(String.valueOf(obj.getNumero()));
//        txtComplemento.setText(obj.getComplemento());
//        txtBairro.setText(obj.getBairro());
//        txtCidade.setText(obj.getCidade());
//        comboBoxFornecedor.setSelectedItem(obj.getUf());
//        } else {
            JOptionPane.showMessageDialog(null, "Cliente não Encontrado");
        }
        
    }//GEN-LAST:event_btPesquisarActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // Chamada do Método Listar Lista para ao abrir a tela já carregar a lista de clientes
        
        listar();
    }//GEN-LAST:event_formWindowActivated

    private void tableViewProdutosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableViewProdutosMouseClicked
        // Ao clicar numa linha da tabela passar para a outra aba
        // Cada aba tem seu indice começando pelo 0 igual em vetores, o comando pega o nome da tabela e seta 
        // a linha selecionada para a aba do indice escolhido, que nesse caso é a aba indice 0
        jTabbedPane1.setSelectedIndex(0);
        
        /*
        Agora seta os valoes que serão passados para seus respectivos campos
        indicando primeiro o nome do text field que receberá, depois indicando qual
        linha e coluna na table view do valor que será passado. Nesse caso passamos que receberá
        o valor da linha selecionada, e o indice da coluna correspondente, as colunas também são indicadas por indices
        iguais a um vetor, começando pelo 0.
        */
        txtCodigo.setText(tableViewProdutos.getValueAt(tableViewProdutos.getSelectedRow(), 0).toString());
        txtDescricao.setText(tableViewProdutos.getValueAt(tableViewProdutos.getSelectedRow(), 1).toString());
//        txtRg.setText(tableViewProdutos.getValueAt(tableViewProdutos.getSelectedRow(), 2).toString());
//        txtCpf.setText(tableViewProdutos.getValueAt(tableViewProdutos.getSelectedRow(), 3).toString());
//        txtPreco.setText(tableViewProdutos.getValueAt(tableViewProdutos.getSelectedRow(), 4).toString());
//        txtTelefone.setText(tableViewProdutos.getValueAt(tableViewProdutos.getSelectedRow(), 5).toString());
//        txtCelular.setText(tableViewProdutos.getValueAt(tableViewProdutos.getSelectedRow(), 6).toString());
//        txtCep.setText(tableViewProdutos.getValueAt(tableViewProdutos.getSelectedRow(), 7).toString());
//        txtQtdEstoque.setText(tableViewProdutos.getValueAt(tableViewProdutos.getSelectedRow(), 8).toString());
//        txtNumero.setText(tableViewProdutos.getValueAt(tableViewProdutos.getSelectedRow(), 9).toString());
//        txtComplemento.setText(tableViewProdutos.getValueAt(tableViewProdutos.getSelectedRow(), 10).toString());
//        txtBairro.setText(tableViewProdutos.getValueAt(tableViewProdutos.getSelectedRow(), 11).toString());
//        txtCidade.setText(tableViewProdutos.getValueAt(tableViewProdutos.getSelectedRow(), 12).toString());
//        comboBoxFornecedor.setSelectedItem(tableViewProdutos.getValueAt(tableViewProdutos.getSelectedRow(), 13).toString());
        
    }//GEN-LAST:event_tableViewProdutosMouseClicked

    private void txtPesquisaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisaKeyPressed
        // Método para enquanto vai digitando no txtpesquisar já vai fazendo a pesquisa nos clientes
        
        /*
        É o mesmo método usado para buscar por nome quando aperta o botão pesquisar, só estamos usando
        esse código no evento key pressed
        */
        String nome = "%" + txtPesquisa.getText() + "%";
        
        ClienteDAO dao = new ClienteDAO();
        List<Cliente> list = dao.buscarClientePorNome(nome);
        
        DefaultTableModel dados = (DefaultTableModel) tableViewProdutos.getModel();
        dados.setNumRows(0); //Zera a tabela
        
        for(Cliente c : list){
            
            dados.addRow(new Object[]{
            
            c.getId(),
            c.getNome(),
            c.getRg(),
            c.getCpf(),
            c.getEmail(),
            c.getTelefone(),
            c.getCelular(),
            c.getCep(),
            c.getEndereco(),
            c.getNumero(),
            c.getComplemento(),
            c.getBairro(),
            c.getCidade(),
            c.getUf()
            });
            
        }
    }//GEN-LAST:event_txtPesquisaKeyPressed

    private void comboBoxFornecedorAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_comboBoxFornecedorAncestorAdded
        // Carregando o Objeto na ComboBox
        
        FornecedorDAO dao = new FornecedorDAO();
        List<Fornecedor>list = dao.listarFornecedores();
        comboBoxFornecedor.removeAll();
        
        for(Fornecedor f : list){
            comboBoxFornecedor.addItem(f);
        }
        
    }//GEN-LAST:event_comboBoxFornecedorAncestorAdded

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmProduto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btEditar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btNovo;
    private javax.swing.JButton btPesquisar;
    private javax.swing.JButton btPesquisarConsulta;
    private javax.swing.JButton btSalvar;
    private javax.swing.JComboBox comboBoxFornecedor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel panelConsultaClientes;
    private javax.swing.JPanel panelDadosPessoais;
    private javax.swing.JTable tableViewProdutos;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtDescricao;
    private javax.swing.JTextField txtPesquisa;
    private javax.swing.JTextField txtPreco;
    private javax.swing.JTextField txtQtdEstoque;
    // End of variables declaration//GEN-END:variables
}
