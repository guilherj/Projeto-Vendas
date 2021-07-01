/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Guilherme
 */
public class Venda {
    
    private int id;
    private Cliente cliente;
    private String dataVenda;
    private double totalvenda;
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(String dataVenda) {
        this.dataVenda = dataVenda;
    }

    public double getTotalvenda() {
        return totalvenda;
    }

    public void setTotalvenda(double totalvenda) {
        this.totalvenda = totalvenda;
    }

   

   
    
    
    
  
    
}
