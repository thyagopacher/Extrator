/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Comunicacao;

import java.sql.Time;

/**
 *
 * @author e601535
 */
public class Cliente {

    private int    codcliente;
    private String ip;//se relaciona aos ips recebidos
    private int    porta;//porta utilizada na comunicação
    private String mensagem;
    private String hora_chegada;

    /**
     *
     * @return
     */
    public int getPorta() {
        return porta;
    }

    /**
     *
     * @param porta
     */
    public void setPorta(int porta) {
        this.porta = porta;
    }

    /**
     *
     * @return
     */
    public String getMensagem() {
        return mensagem;
    }

    /**
     *
     * @param mensagem
     */
    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    /**
     *
     * @return
     */
    public String getHora_chegada() {
        return hora_chegada;
    }

    /**
     *
     * @param hora_chegada
     */
    public void setHora_chegada(String hora_chegada) {
        this.hora_chegada = hora_chegada;
    }

    /**
     *
     * @return
     */
    public String getIp() {
        return ip;
    }

    /**
     *
     * @param ip
     */
    public void setIp(String ip) {
        this.ip = ip;
    }

    /**
     *
     * @return
     */
    public int getCodcliente() {
        return codcliente;
    }

    /**
     *
     * @param codcliente
     */
    public void setCodcliente(int codcliente) {
        this.codcliente = codcliente;
    }


}
