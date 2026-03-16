package br.com.sipna.service;

import br.com.sipna.dao.UsuarioDAO;
import br.com.sipna.model.Usuario;
import br.com.sipna.model.Perfil;

import java.util.List;

public class UsuarioService {

    private UsuarioDAO usuarioDAO = new UsuarioDAO();

    public void cadastrarUsuario(String nome,String senha, Perfil perfil){

        if(nome == null || nome.isBlank()){
            throw new IllegalArgumentException("Nome inválido");
        }

        if(senha == null || senha.isBlank()){
            throw new IllegalArgumentException("Senha inválida");
        }

        Usuario usuario = new Usuario(nome,senha,perfil);

        usuarioDAO.salvar(usuario);
    }

    public Usuario login(String username,String password){

        return usuarioDAO.autenticar(username,password);
    }

    public List<Usuario> listarUsuarios(){

        return usuarioDAO.listar();
    }

}