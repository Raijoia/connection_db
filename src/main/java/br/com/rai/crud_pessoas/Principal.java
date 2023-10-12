/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.rai.crud_pessoas;

import javax.swing.JOptionPane;

/**
 *
 * @author rai
 */
public class Principal {
    public static void main(String[] args) throws Exception{
        String menu = "1-Cadastrar\n2-Atualizar\n8-Sair";
        int op;
        
        do {            
            op = Integer.parseInt(JOptionPane.showInputDialog(menu));
            
            switch(op) {
                case 1:
                    String nome = JOptionPane.showInputDialog("Digite o nome");
                    String fone = JOptionPane.showInputDialog("Digite o fone");
                    String email = JOptionPane.showInputDialog("Digite o email");
                    var pessoa = new Pessoa(nome, fone, email);
                    var pessoaDAO = new PessoaDAO();
                    pessoaDAO.cadastrar(pessoa);
                    JOptionPane.showMessageDialog(null, "Pessoa cadastrada com sucesso!");
                    break;
                case 2:
                    break;
            }
        } while (op != 8);
    }
}
