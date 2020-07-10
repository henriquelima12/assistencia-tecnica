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
public class OS {
    private int os;
    private int data_os;
    private String tipo;
    private String situacao;
    private String equipamento;
    private String defeito;
    private String servico;
    private String tecnico;
    private int valor;
    private String nomecli;

    public OS() {
    }

    public OS(int os, int data_os, String tipo, String situacao, String equipamento, String defeito, String servico, String tecnico, int valor, String nomecli) {
        this.os = os;
        this.data_os = data_os;
        this.tipo = tipo;
        this.situacao = situacao;
        this.equipamento = equipamento;
        this.defeito = defeito;
        this.servico = servico;
        this.tecnico = tecnico;
        this.valor = valor;
        this.nomecli = nomecli;
    }

    public int getOs() {
        return os;
    }

    public void setOs(int os) {
        this.os = os;
    }

    public int getData_os() {
        return data_os;
    }

    public void setData_os(int data_os) {
        this.data_os = data_os;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public String getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(String equipamento) {
        this.equipamento = equipamento;
    }

    public String getDefeito() {
        return defeito;
    }

    public void setDefeito(String defeito) {
        this.defeito = defeito;
    }

    public String getServico() {
        return servico;
    }

    public void setServico(String servico) {
        this.servico = servico;
    }

    public String getTecnico() {
        return tecnico;
    }

    public void setTecnico(String tecnico) {
        this.tecnico = tecnico;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
    public String getNomecli() {
        return nomecli;
    }

    public void setNomecli(String nomecli) {
        this.nomecli = nomecli;
    }
    
    
    
    
    
    
    
}
