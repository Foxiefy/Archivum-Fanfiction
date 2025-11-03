package ado;

import model.Usuarios;
import java.sql.*;
import java.util.*;

public class UsuariosAdo {
    private Connection con;

    public UsuariosAdo() {
        con = Conexao.conectar();
    }


    public void adicionar(Usuarios u) {
        String sql = "INSERT INTO usuarios (nome_usuario, email) VALUES (?, ?)";
        try (PreparedStatement st = con.prepareStatement(sql)) {
            st.setString(1, u.getNome());
            st.setString(2, u.getEmail());
            st.executeUpdate();
            System.out.println("Usuário adicionado com sucesso!");
        } catch (Exception e) {
            System.out.println(" Erro ao adicionar usuário: " + e.getMessage());
        }
    }

    // Listar todos os usuários
    public List<Usuarios> listar() {
        List<Usuarios> lista = new ArrayList<>();
        String sql = "SELECT * FROM usuarios";
        try (Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Usuarios u = new Usuarios();
                u.getId() = rs.getInt("id_usuario");
                u.getNome() = rs.getString("nome_usuario");
                u.getEmail() = rs.getString("email");
                lista.add(u);
            }
        } catch (Exception e) {
            System.out.println("Erro ao listar usuários: " + e.getMessage());
        }
        return lista;
    }
}
