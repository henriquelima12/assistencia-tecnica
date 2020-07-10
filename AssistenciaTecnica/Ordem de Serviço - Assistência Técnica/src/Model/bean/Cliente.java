/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.bean;

/**
 *
 * @author teonilia
 */
public class Cliente {
    private int idcli;
    private String nomecli;
    private String endcli;
    private String cpf;
    private String emailcli;

    public Cliente() {
    }

    public Cliente(String nomecli, String endcli, String cpf, String emailcli) {
        this.nomecli = nomecli;
        this.endcli = endcli;
        this.cpf = cpf;
        this.emailcli = emailcli;
    }

    public int getIdcli() {
        return idcli;
    }

    public void setIdcli(int idcli) {
        this.idcli = idcli;
    }

    public String getNomecli() {
        return nomecli;
    }

    public void setNomecli(String nomecli) {
        this.nomecli = nomecli;
    }

    public String getEndcli() {
        return endcli;
    }

    public void setEndcli(String endcli) {
        this.endcli = endcli;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmailcli() {
        return emailcli;
    }

    public void setEmailcli(String emailcli) {
        this.emailcli = emailcli;
    }
    
}

