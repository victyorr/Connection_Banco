package br.com.fiap.teste;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Database.Connection.ConnectionFactory;
import Database.Models.User;


import java.sql.SQLException;

import br.com.fiap.dao.UsuarioDAO;
import br.com.fiap.model.Usuario;

public class teste {

	public static void main(String[] args) throws SQLException {

		UsuarioDAO dao = new UsuarioDAO();
		Usuario jorge = new Usuario("Jorge","victor@gmail.com","123456");
		
		dao.insert(jorge);
		
		
		ListUsuarios<Usuario> listaUsuarios = dao.selectALL();
		
		//lambda expression, uso do for mais facil para listas
		listaUsuarios.forEach(user -> System.out.println("Id: "+user.getId))
		
		
		
		for(Usuario usuario = dao.selectById(2));
				System.out.println("Controle: "+usuario.getId());
				System.out.println("Nome: "+usuario.getNome());
				System.out.println("Email: "+usuario.getEmail());
				System.out.println("Senha: "+usuario.getSenha());
				System.out.println("Data de Registro: "+usuario.getData());
		
		
	}

}