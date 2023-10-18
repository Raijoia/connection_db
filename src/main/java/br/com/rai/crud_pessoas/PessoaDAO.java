/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.rai.crud_pessoas;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
        String sql = "INSERT INTO tb_pessoas (nome, fone, email, ativo) value (?, ?, ?, 1)";
        
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
    
    public void atualizar(Pessoa pessoa) throws Exception {
        String nome = pessoa.getNome();
        String fone = pessoa.getFone();
        String email = pessoa.getEmail();
        int codigo = pessoa.getCodigo();
        
        //1 - Especificar o comando SQL
        String sql = "UPDATE tb_pessoas SET nome = ?, fone = ?, email = ? WHERE cod_pessoa = ?;";
        
        //2 - Abrir uma conexão com o MySQL
        try(
//              Não precisa do fehcmaneto deles, se fecham sozinho
                var factory = ConnectionFactory.conectar();
//              3 - preparar o comando
                var ps = factory.prepareStatement(sql)
            ){
        
            //4 - Substituir os eventuais placeholders
            ps.setString(1, nome);
            ps.setString(2, fone);
            ps.setString(3, email);
            ps.setInt(4, codigo);
            
            //5 - Executar o comando preparado
            ps.execute();
            
//           6 - fechar a conexão
//           try-with-resources já fez
        }
    }
     
    public void deletar(Pessoa pessoa) throws Exception {
        int codigo = pessoa.getCodigo();
         
        //1 - Especificar o comando SQL
        String sql = "DELETE FROM tb_pessoas WHERE cod_pessoa = ?;";
         
        //2 - Abrir uma conexão com o MySQL
        try(
//              Não precisa do fehcmaneto deles, se fecham sozinho
                var factory = ConnectionFactory.conectar();
//              3 - preparar o comando
                var ps = factory.prepareStatement(sql)
            ){
        
            //4 - Substituir os eventuais placeholders
            ps.setInt(1, codigo);
            
            //5 - Executar o comando preparado
            ps.execute();
            
//           6 - fechar a conexão
//           try-with-resources já fez
        }
    }
    
    public void desativar(Pessoa pessoa) throws Exception {
        int codigo = pessoa.getCodigo();
         
        //1 - Especificar o comando SQL
        String sql = "UPDATE tb_pessoas SET ativo = 0 WHERE cod_pessoa = ?;";
         
        //2 - Abrir uma conexão com o MySQL
        try(
//              Não precisa do fehcmaneto deles, se fecham sozinho
                var factory = ConnectionFactory.conectar();
//              3 - preparar o comando
                var ps = factory.prepareStatement(sql)
            ){
        
            //4 - Substituir os eventuais placeholders
            ps.setInt(1, codigo);
            
            //5 - Executar o comando preparado
            ps.execute();
            
//           6 - fechar a conexão
//           try-with-resources já fez
        }
    }
    
    public void listar() throws Exception {
        //1 - Especificar o comando SQL
        String sql = "SELECT * FROM tb_pessoas";
        
        //2 - Abrir uma conexão com o MySQL
        try (
            var factory = ConnectionFactory.conectar();
            //3 - preparar o comando
            var ps = factory.prepareStatement(sql);
            
            //4 - Substituir os eventuais placeholders
            //5 - Executar o comando preparado
//          para armazenar o que será devolvido pelo db
            ResultSet rs = ps.executeQuery();
        ){
           //6 - tratar os dados e fechar a conexão, o try já fecha
           // colocar o cursor do resultSet para a linha debaixo
            while (rs.next()) {
                String nome = rs.getString("nome");
                String fone = rs.getString("fone");
                String email = rs.getString("email");
                System.out.printf("nome: %s, fone: %s, email: %s\n",
                    nome, fone, email
                );
            }          
        }
        // fechar as conexões (São fechadas automaticamente no try)
    }
}
