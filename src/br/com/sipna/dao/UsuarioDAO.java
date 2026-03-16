package br.com.sipna.dao;

import br.com.sipna.database.ConnectionFactory;
import br.com.sipna.model.Usuario;
import br.com.sipna.model.Perfil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

    public void salvar(Usuario usuario) {

        String sql = "INSERT INTO usuarios (username,password,perfil) VALUES (?,?,?)";

        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, usuario.getUsername());
            stmt.setString(2, usuario.getPassword());
            stmt.setString(3, usuario.getPerfil().toString());

            stmt.executeUpdate();

        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public Usuario autenticar(String username,String password){

        String sql = "SELECT * FROM usuarios WHERE username=? AND password=?";

        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1,username);
            stmt.setString(2,password);

            ResultSet rs = stmt.executeQuery();

            if(rs.next()){

                return new Usuario(
                        rs.getString("username"),
                        rs.getString("password"),
                        Perfil.valueOf(rs.getString("perfil"))
                );
            }

        }catch(Exception e){
            e.printStackTrace();
        }

        return null;
    }

    public List<Usuario> listar(){

        List<Usuario> lista = new ArrayList<>();

        String sql = "SELECT * FROM usuarios";

        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

            ResultSet rs = stmt.executeQuery();

            while(rs.next()){

                Usuario user = new Usuario(
                        rs.getString("username"),
                        rs.getString("password"),
                        Perfil.valueOf(rs.getString("perfil"))
                );

                lista.add(user);
            }

        }catch(Exception e){
            e.printStackTrace();
        }

        return lista;
    }
}