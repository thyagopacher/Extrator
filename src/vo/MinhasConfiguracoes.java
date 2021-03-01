/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Date;


/**
 *
 * @author ThyagoPacher
 */
public class MinhasConfiguracoes implements java.io.Serializable{
    
    private static long serialVersionUID = 1L;
    
    /**
     *
     * @return
     */
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    /**
     *
     * @param aSerialVersionUID
     */
    public static void setSerialVersionUID(long aSerialVersionUID) {
        serialVersionUID = aSerialVersionUID;
    }
    
    private String idioma;
    private int    ativado = 0;
    private String  email;
    private String  nome;
    private Date data_ativacao;
    
    /**
     *
     */
    public MinhasConfiguracoes() {
    }

    /** * @param arquivo define qual o caminho do arquivo .txt
     * Seta o objeto MinhasConfiguracoes para novo idioma
     * @return retorna o objeto traducao com o respectivo idioma
     */
    public MinhasConfiguracoes getObjeto(String arquivo) {
        try {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File(arquivo)))) {
                MinhasConfiguracoes resultado = (MinhasConfiguracoes) ois.readObject();
                return resultado;
            }
        } catch (IOException ex) {
            System.out.println("Erro causado por:" + ex);
            return null;
        } catch (ClassNotFoundException ex) {
            System.out.println("Erro causado por:" + ex);
            return null;
        }
    }

    /**
     * @param configuracoes objeto para setar tradução nova
     * @return mensagem de erro ou nada em caso de sucesso
     */
    public String setObjeto(MinhasConfiguracoes configuracoes) {
        java.io.ObjectOutputStream oos;
        try {
            oos = new java.io.ObjectOutputStream(new FileOutputStream(new File("C:/best_extrator/minhas_configuracoes")));
            oos.writeObject(configuracoes);
            oos.close();            
        } catch (IOException ex) {
            return ""+ ex;
        }
        return "";
    }    
    
    /**
     *
     * @return
     */
    public String getIdioma() {
        return idioma;
    }

    /**
     *
     * @param idioma
     */
    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    /**
     *
     * @return
     */
    public int getAtivado() {
        return ativado;
    }

    /**
     *
     * @param ativado
     */
    public void setAtivado(int ativado) {
        this.ativado = ativado;
    }

    /**
     *
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *
     * @return
     */
    public String getNome() {
        return nome;
    }

    /**
     *
     * @param nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     *
     * @return
     */
    public Date getData_ativacao() {
        return data_ativacao;
    }

    /**
     *
     * @param data_ativacao
     */
    public void setData_ativacao(Date data_ativacao) {
        this.data_ativacao = data_ativacao;
    }
    
}
