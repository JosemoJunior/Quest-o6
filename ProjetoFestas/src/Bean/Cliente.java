/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bean;

/**
 *
 * @author autologon
 */
public class Cliente {
    //Atributos de instância da classe (Cliente);
    private Integer idCliente;
    private String nmCliente;
    private String email;
    
    //Métodos Get e Set.

    /**
     * @return the idCliente
     */
    public Integer getIdCliente() {
        return idCliente;
    }

    /**
     * @param idCliente the idCliente to set
     */
    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    /**
     * @return the nmCliente
     */
    public String getNmCliente() {
        return nmCliente;
    }

    /**
     * @param nmCliente the nmCliente to set
     */
    public void setNmCliente(String nmCliente) {
        this.nmCliente = nmCliente;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }  
    
}
