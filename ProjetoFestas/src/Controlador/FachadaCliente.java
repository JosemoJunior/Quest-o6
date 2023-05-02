/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;
import DAO.*;
import Bean.*;
import Conexao.*;
import java.util.*;
import java.sql.SQLException;

/**
 *
 * @author autologon
 */
public class FachadaCliente {
      private ConexaoDBMysql conn = null;

   public FachadaCliente(){
        this.conn = ConexaoDBMysql.getInstance();
    }

    /**
     * @return the conn
     */
    public ConexaoDBMysql getConn() {
        return conn;
    }

    /**
     * @param conn the conn to set
     */
    public void setConn(ConexaoDBMysql conn) {
        this.conn = conn;
    }

    // Início dos Métodos da Fachada.
    public ArrayList<Cliente> listagemGeralCliente() {
         ArrayList ob = new ArrayList();
       try {
           DAOCliente meuDAO = new DAOCliente(this.getConn());
           ob = meuDAO.list();
        } catch (Exception exception) {
           // System.out.println("Listagem dos Municípios não foi localizada.");
      }
       return ob;
    }

    public int inserirCliente(Cliente obj) {
       int retorno = 0;
       try {
        DAOCliente meuDAO = new DAOCliente(this.getConn());
        retorno = meuDAO.insert(obj);

      } catch (Exception exception){
         System.out.println("Inclusão não foi realizada Ocorrencia.");
      }
       return  retorno;
    }

    public int removerCliente(Cliente obj){
        int retorno = 0;
        try{
            DAOCliente meuDao = new DAOCliente(this.getConn());
            retorno = meuDao.remover(obj);

        } catch (Exception exception){
            System.out.println("não apagou");
        }
        return retorno;
    }
    
}
