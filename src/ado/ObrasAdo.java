package ado;

import model.Obras;
import model.Usuarios;
import java.sql.*;
import java.util.*;

public class ObrasAdo {

    public void add(model.Obras o) {
        String sql = "INSERT INTO obras (titulo, resumo, tags, id_autor) VALUES (?, ?, ?, ?)";
        try (Connection con = Conexao.conectar()) {
            assert con != null;
            try (PreparedStatement ps = con.prepareStatement(sql)) {

                ps.setString(1, o.getTitulo());
                ps.setString(2, o.getResumo());
                ps.setString(3, o.getTags());
                ps.setInt(4, o.getUsuarios().getId());
                ps.executeUpdate();
                System.out.println("Obra adicionada com sucesso!");

            }
        } catch (Exception e) {
            System.out.println("Erro ao adicionar obra: " + e.getMessage());
        }
    }

    public List<ado.ObrasAdo> Listar() {
        List<ObrasAdo> lista = new ArrayList<>();
        String sql = "SELECT * FROM obras";
        try (Connection con = Conexao.conectar()) {
            assert con != null;
            try (Statement st = con.createStatement();
                 ResultSet rs = st.executeQuery(sql)) {

                while (rs.next()) {
                    Obras o = new Obras();
                    o.setId(rs.getInt("id_obra"));
                    o.setTitulo(rs.getString("titulo"));
                    o.setResumo(rs.getString("resumo"));
                    o.setTags(rs.getString("tags"));
                    lista.add(o);
                }


            }
        } catch (Exception e) {
            System.out.println("Erro ao listar obras: " + e.getMessage());
        }
        return lista;
    }
}
