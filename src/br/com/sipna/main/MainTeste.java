package br.com.sipna.main;

import br.com.sipna.model.Perfil;
import br.com.sipna.model.Usuario;
import br.com.sipna.service.UsuarioService;

public class MainTeste {

    public static void main(String[] args) {

        UsuarioService service = new UsuarioService();

        service.cadastrarUsuario("teste","123", Perfil.ALUNO);

        Usuario user = service.login("teste","123");

        if(user != null){
            System.out.println("Login realizado com sucesso!");
            System.out.println("Perfil: " + user.getPerfil());
        }

        System.out.println("\nLista de usuários:");

        service.listarUsuarios()
                .forEach(u -> System.out.println(u.getUsername()));

    }
}