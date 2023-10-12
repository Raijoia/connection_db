/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.rai.crud_pessoas;

import javax.swing.JOptionPane;

/**
 *
 * @author 82318841
 */
public class TestConexao {
    public static void main(String[] args){
        try {
            var factory = new ConnectionFactory();
            var connection = factory.conectar();
            System.out.println("Conectou!");
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Conexão Falhou " + e.getMessage());
            e.printStackTrace();
        }
    }
}
