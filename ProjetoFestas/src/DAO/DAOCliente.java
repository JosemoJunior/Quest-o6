/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexao.ConexaoDBMysql;
//import Controlador.*;
import Bean.Cliente;

import java.sql.*;
import javax.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author ricardoricrob
 */

public class DAOCliente {

    private ConexaoDBMysql co = ConexaoDBMysql.getInstance();
    private String sql = "",  sql1 = "";
    private PreparedStatement stmt = null;

    public DAOCliente(ConexaoDBMysql conn) {
        this.co = conn;
    }

    public ArrayList list() throws SQLException {
    ArrayList list = new ArrayList();
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    try {
      conn = co.getConnection();
      String sql = "SELECT idCliente, nmCliente, email from cliente order by nmCliente";
      pstmt = conn.prepareStatement(sql);
      rs = pstmt.executeQuery();
      while(rs.next()) {
        Cliente c = new Cliente();
     //populate(material, rs);
//        c.setIdcliente(rs.getInt("Idcliente"));
//        c.setIdcliente(Integer.parseInt(rs.getString(1)));

//        c.setNome(rs.getString(1));
//        c.setFone(rs.getString(2));
//        c.setEmail(rs.getString(3));
//        c.setAssinante(rs.getString(4));
//        list.add(c);

          c.setIdCliente(rs.getInt(1));
          c.setNmCliente(rs.getString(2));
          c.setEmail(rs.getString(3));
          list.add(c);
      }
      rs.close();
      pstmt.close();
    } catch (SQLException e) {
      rs.close();
      pstmt.close();
      conn.rollback();
      e.printStackTrace();
    } finally {
    	co.devolveconexao(conn);
    }
    return list;
  }

    public int insert(Cliente cliente) throws SQLException {
    String sql;
    int a = 0;
    sql = "INSERT INTO Cliente (idCliente, nmCliente, email) VALUES (?, ?, ?, ?)";
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    try {
      conn = co.getConnection();
      pstmt = conn.prepareStatement(sql);
//      pstmt.setString(1, cliente.getNome());
//      pstmt.setString(2, cliente.getFone());
//      pstmt.setString(3, cliente.getEmail());
//      pstmt.setString(4, cliente.getAssinante());
        pstmt.setInt(1, cliente.getIdCliente());
        pstmt.setString(2, cliente.getNmCliente());
        pstmt.setString(3, cliente.getEmail());
      a = pstmt.executeUpdate();
      pstmt.close();
//      conn.commit();
//      JOptionPane.showMessageDialog(null,"Registro Gravado com Sucesso");
      return a;
    } catch (SQLException sqle) {

      sqle.printStackTrace();
      throw sqle;
    } finally {
    	co.devolveconexao(conn);
    }
  }

    public int remover(Cliente cliente) throws SQLException{
        int a = 0;
        String sql;
         sql = "DELETE from Cliente where idcliente = ?";
         Connection conn = null;
         PreparedStatement pstmt = null;
         ResultSet rs = null;
         try {
        conn = co.getConnection();
      pstmt = conn.prepareStatement(sql);
      pstmt.setInt(1, cliente.getIdCliente());
      a = pstmt.executeUpdate();
      pstmt.close();
//      conn.commit();
//      JOptionPane.showMessageDialog(null,"Registro Gravado com Sucesso");
      return a;
    } catch (SQLException sqle) {
      sqle.printStackTrace();
      throw sqle;
    } finally {
    	co.devolveconexao(conn);
    }


    }

}
