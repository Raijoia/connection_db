/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.rai.crud_pessoas;

import java.sql.PreparedStatement;

/**
 *
 * @author rai
 */
public class PessoaDAO {
    //  DAO = Data Access object
    //  Oferece funcionalidade de acesso aos dados no banco de dados do tipo Pessoa  
    
    public void cadastrar(Pessoa pessoa) throws Exception {
        String nome = pessoa.getNome();
        String fone = pessoa.getFone();
        String email = pessoa.getEmail();
        
        //1 - Especificar o comando SQL
        String sql = "INSERT INTO tb_pessoas (nome, fone, email) value (?, ?, ?)";
        
        //2 - Abrir uma conexão com o MySQL
        var factory = new ConnectionFactory();
        var connection = factory.conectar();
        
        //3 - Preparar o comando
        PreparedStatement ps = connection.prepareStatement(sql);
        
        //4 - Substituir os eventuais placeholders
        ps.setString(1, nome);
        ps.setString(2, fone);
        ps.setString(3, email);
        
        //5 - Executar o comando preparado
        ps.execute();
        
        //6 - Fechar a conexão
        connection.close(); // connection.close() já fecha tbm o ps
    }
}
