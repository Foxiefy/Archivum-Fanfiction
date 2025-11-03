package ado;

import model.Capitulos;
import model.Obras;

import java.sql.*;
import java.util.*;

public class CapitulosAdo {

    public void adicionar(Capitulos c) {
        String sql = "INSERT INTO capitulos (titulo_capitulo, conteudo, numero, id_obra) VALUES (?, ?, ?, ?)";
        try (Connection con = Conexao.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, c.getTitulo());
            ps.setString(2, c.getConteudo());
            ps.setInt(3, c.getNumero());
            ps.setInt(4, c.getObras().getId());
            ps.executeUpdate();
            System.out.println("Capítulo adicionado com sucesso!");

        } catch (Exception e) {
            System.out.println("Erro ao adicionar capítulo: " + e.getMessage());
        }
    }

    public List<Capitulos> listar() {
        List<Capitulos> lista = new ArrayList<>();
        String sql = "SELECT * FROM capitulos";
        try (Connection con = Conexao.conectar();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Capitulos c = new Capitulos();
                c.getId() = rs.getInt("id_capitulo");
                c.getTitulo() = rs.getString("titulo_capitulo");
                c.getConteudo() = rs.getString("conteudo");
                c.getNumero() = rs.getInt("numero");
                lista.add(c);
            }

        } catch (Exception e) {
            System.out.println("Erro ao listar capítulos: " + e.getMessage());
        }
        return lista;
    }
}
