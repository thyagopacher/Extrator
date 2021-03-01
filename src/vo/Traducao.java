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
import javax.swing.JOptionPane;

/**
 *
 * @author ThyagoPacher
 */
public class Traducao implements java.io.Serializable{
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
    private String argconexao    = "Aguardando conexão";
    private String exportar      = "Exportar";
    private String parar         = "Parar";
    private String continuar     = "Continuar";
    private String estatisticas  = "Estatísticas";
    private String status        = "Status";
    private String processando   = "Processando...";
    private String errosvarquivo = "Arquivo não pode ser salvo! Aconteceu o erro:";
    private String svarquivo     = "Arquivo salvo com sucesso!";
    private String msgerro       = "Erro causado por:";
    private String titerro       = "Erro";
    private String titatencao    = "Atenção";
    private String contatosenc   = "Contatos encontrados:";
    private String urlenc        = "Url encontradas:";
    private String tempodecor    = "Tempo decorrido:";
    private String arquivosnome  = "Arquivo não tem nome";
    private String consulta      = "Consulta";
    private String email         = "E-mail";
    private String site          = "Site";
    private String procparado    = "Processamento parado";
    private String buscaterm     = "Busca terminada...";
    private String removdupl     = "Removendo duplicados";
    private String removedupl    = "Remove duplicados";
    private String duplremov     = "Duplicados removidos";
    private String exportvazio   = "Ainda não tem nada para exportar";
    private String contproc      = "Continuando processamento anterior";
    private String buscavazia    = "Coloque algum termo para busca";
    private String parebusca     = "Primeiro pare a busca";
    private String listavazia    = "Ainda não achou nada";
    private String salvar        = "Salvar";
    private String confirmar     = "Confirmar";
    private String ajuda         = "Ajuda";
    private String configuracao  = "Configuração";
    private String limpar        = "Limpar";
    private String iniciar       = "Iniciar";
    private String sinternetbq   = "Sem Internet para extrair e-mails";
    private String verinternet   = "Verificando Internet";
    private String seminternet   = "Sem Internet";
    private String cominternet   = "Com Internet";
    private String sucessooper   = "Sucesso com a operação!";
    private String prodativado   = "Produto já ativado!";
    private String prodnativado  = "Produto não ativado!";
    private String ativar        = "Ativar";
    private String comprar       = "Comprar";
    private String ativeantes    = "PRODUTO NÃO ATIVADO!";
    /** * @param arquivo define qual o caminho do arquivo .txt
     * Seta o objeto Traducao para novo idioma
     * @return retorna o objeto traducao com o respectivo idioma
     */
    public Traducao getObjeto(String arquivo) {
        try {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File(arquivo)))) {
                Traducao resultado = (Traducao) ois.readObject();
                return resultado;
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex, "ERRO:", JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex, "ERRO:", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }

    /**
     * @param traduz objeto para setar tradução nova
     * @param idioma nome do arquivo
     * @return mensagem de erro ou nada em caso de sucesso
     */
    public String setObjeto(Traducao traduz, String idioma) {
        java.io.ObjectOutputStream oos;
        try {
            oos = new java.io.ObjectOutputStream(new FileOutputStream(new File("C:/best_extrator/idioma/"+idioma)));
            oos.writeObject(traduz);
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
    public String getExportar(){
        return exportar;
    }

    /**
     *
     * @param exportar
     */
    public void setExportar(String exportar) {
        this.exportar = exportar;
    }    
    
    /**
     *
     * @return
     */
    public String getParar() {
        return parar;
    }

    /**
     *
     * @param parar
     */
    public void setParar(String parar) {
        this.parar = parar;
    }

    /**
     *
     * @return
     */
    public String getContinuar() {
        return continuar;
    }

    /**
     *
     * @param continuar
     */
    public void setContinuar(String continuar) {
        this.continuar = continuar;
    }

    /**
     *
     * @return
     */
    public String getEstatisticas() {
        return estatisticas;
    }

    /**
     *
     * @param estatisticas
     */
    public void setEstatisticas(String estatisticas) {
        this.estatisticas = estatisticas;
    }

    /**
     *
     * @return
     */
    public String getStatus() {
        return status;
    }

    /**
     *
     * @param status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     *
     * @return
     */
    public String getProcessando() {
        return processando;
    }

    /**
     *
     * @param processando
     */
    public void setProcessando(String processando) {
        this.processando = processando;
    }

    /**
     *
     * @return
     */
    public String getErrosvarquivo() {
        return errosvarquivo;
    }

    /**
     *
     * @param errosvarquivo
     */
    public void setErrosvarquivo(String errosvarquivo) {
        this.errosvarquivo = errosvarquivo;
    }

    /**
     *
     * @return
     */
    public String getSvarquivo() {
        return svarquivo;
    }

    /**
     *
     * @param svarquivo
     */
    public void setSvarquivo(String svarquivo) {
        this.svarquivo = svarquivo;
    }

    /**
     *
     * @return
     */
    public String getMsgerro() {
        return msgerro;
    }

    /**
     *
     * @param msgerro
     */
    public void setMsgerro(String msgerro) {
        this.msgerro = msgerro;
    }

    /**
     *
     * @return
     */
    public String getTiterro() {
        return titerro;
    }

    /**
     *
     * @param titerro
     */
    public void setTiterro(String titerro) {
        this.titerro = titerro;
    }

    /**
     *
     * @return
     */
    public String getTitatencao() {
        return titatencao;
    }

    /**
     *
     * @param titatencao
     */
    public void setTitatencao(String titatencao) {
        this.titatencao = titatencao;
    }

    /**
     *
     * @return
     */
    public String getContatosenc() {
        return contatosenc;
    }

    /**
     *
     * @param contatosenc
     */
    public void setContatosenc(String contatosenc) {
        this.contatosenc = contatosenc;
    }

    /**
     *
     * @return
     */
    public String getUrlenc() {
        return urlenc;
    }

    /**
     *
     * @param urlenc
     */
    public void setUrlenc(String urlenc) {
        this.urlenc = urlenc;
    }
   
    /**
     *
     * @return
     */
    public String getTempodecor() {
        return tempodecor;
    }

    /**
     *
     * @param tempodecor
     */
    public void setTempodecor(String tempodecor) {
        this.tempodecor = tempodecor;
    }

    /**
     *
     * @return
     */
    public String getArquivosnome() {
        return arquivosnome;
    }

    /**
     *
     * @param arquivosnome
     */
    public void setArquivosnome(String arquivosnome) {
        this.arquivosnome = arquivosnome;
    }

    /**
     *
     * @return
     */
    public String getConsulta() {
        return consulta;
    }

    /**
     *
     * @param consulta
     */
    public void setConsulta(String consulta) {
        this.consulta = consulta;
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
    public String getSite() {
        return site;
    }

    /**
     *
     * @param site
     */
    public void setSite(String site) {
        this.site = site;
    }

    /**
     *
     * @return
     */
    public String getProcparado() {
        return procparado;
    }

    /**
     *
     * @param procparado
     */
    public void setProcparado(String procparado) {
        this.procparado = procparado;
    }

    /**
     *
     * @return
     */
    public String getBuscaterm() {
        return buscaterm;
    }

    /**
     *
     * @param buscaterm
     */
    public void setBuscaterm(String buscaterm) {
        this.buscaterm = buscaterm;
    }

    /**
     *
     * @return
     */
    public String getRemovdupl() {
        return removdupl;
    }

    /**
     *
     * @param removdupl
     */
    public void setRemovdupl(String removdupl) {
        this.removdupl = removdupl;
    }

    /**
     *
     * @return
     */
    public String getDuplremov() {
        return duplremov;
    }

    /**
     *
     * @param duplremov
     */
    public void setDuplremov(String duplremov) {
        this.duplremov = duplremov;
    }

    /**
     *
     * @return
     */
    public String getExportvazio() {
        return exportvazio;
    }

    /**
     *
     * @param exportvazio
     */
    public void setExportvazio(String exportvazio) {
        this.exportvazio = exportvazio;
    }

    /**
     *
     * @return
     */
    public String getContproc() {
        return contproc;
    }

    /**
     *
     * @param contproc
     */
    public void setContproc(String contproc) {
        this.contproc = contproc;
    }

    /**
     *
     * @return
     */
    public String getBuscavazia() {
        return buscavazia;
    }

    /**
     *
     * @param buscavazia
     */
    public void setBuscavazia(String buscavazia) {
        this.buscavazia = buscavazia;
    }

    /**
     *
     * @return
     */
    public String getParebusca() {
        return parebusca;
    }

    /**
     *
     * @param parebusca
     */
    public void setParebusca(String parebusca) {
        this.parebusca = parebusca;
    }

    /**
     *
     * @return
     */
    public String getSalvar() {
        return salvar;
    }

    /**
     *
     * @param salvar
     */
    public void setSalvar(String salvar) {
        this.salvar = salvar;
    }

    /**
     *
     * @return
     */
    public String getListavazia() {
        return listavazia;
    }

    /**
     *
     * @param listavazia
     */
    public void setListavazia(String listavazia) {
        this.listavazia = listavazia;
    }

    /**
     *
     * @return
     */
    public String getConfirmar() {
        return confirmar;
    }

    /**
     *
     * @param confirmar
     */
    public void setConfirmar(String confirmar) {
        this.confirmar = confirmar;
    }

    /**
     *
     * @return
     */
    public String getAjuda() {
        return ajuda;
    }

    /**
     *
     * @param ajuda
     */
    public void setAjuda(String ajuda) {
        this.ajuda = ajuda;
    }

    /**
     *
     * @return
     */
    public String getConfiguracao() {
        return configuracao;
    }

    /**
     *
     * @param configuracao
     */
    public void setConfiguracao(String configuracao) {
        this.configuracao = configuracao;
    }

    /**
     *
     * @return
     */
    public String getLimpar() {
        return limpar;
    }

    /**
     *
     * @param limpar
     */
    public void setLimpar(String limpar) {
        this.limpar = limpar;
    }

    /**
     *
     * @return
     */
    public String getIniciar() {
        return iniciar;
    }

    /**
     *
     * @param iniciar
     */
    public void setIniciar(String iniciar) {
        this.iniciar = iniciar;
    }

    /**
     *
     * @return
     */
    public String getRemovedupl() {
        return removedupl;
    }

    /**
     *
     * @param removedupl
     */
    public void setRemovedupl(String removedupl) {
        this.removedupl = removedupl;
    }

    /**
     *
     * @return
     */
    public String getArgconexao() {
        return argconexao;
    }

    /**
     *
     * @param argconexao
     */
    public void setArgconexao(String argconexao) {
        this.argconexao = argconexao;
    }

    /**
     *
     * @return
     */
    public String getVerinternet() {
        return verinternet;
    }

    /**
     *
     * @param verinternet
     */
    public void setVerinternet(String verinternet) {
        this.verinternet = verinternet;
    }

    /**
     *
     * @return
     */
    public String getSeminternet() {
        return seminternet;
    }

    /**
     *
     * @param seminternet
     */
    public void setSeminternet(String seminternet) {
        this.seminternet = seminternet;
    }

    /**
     *
     * @return
     */
    public String getCominternet() {
        return cominternet;
    }

    /**
     *
     * @param cominternet
     */
    public void setCominternet(String cominternet) {
        this.cominternet = cominternet;
    }

    /**
     *
     * @return
     */
    public String getSinternetbq() {
        return sinternetbq;
    }

    /**
     *
     * @param sinternetbq
     */
    public void setSinternetbq(String sinternetbq) {
        this.sinternetbq = sinternetbq;
    }

    /**
     *
     * @return
     */
    public String getSucessooper() {
        return sucessooper;
    }

    /**
     *
     * @param sucessooper
     */
    public void setSucessooper(String sucessooper) {
        this.sucessooper = sucessooper;
    }

    /**
     *
     * @return
     */
    public String getProdativado() {
        return prodativado;
    }

    /**
     *
     * @param prodativado
     */
    public void setProdativado(String prodativado) {
        this.prodativado = prodativado;
    }

    /**
     *
     * @return
     */
    public String getProdnativado() {
        return prodnativado;
    }

    /**
     *
     * @param prodnativado
     */
    public void setProdnativado(String prodnativado) {
        this.prodnativado = prodnativado;
    }

    /**
     *
     * @return
     */
    public String getAtivar() {
        return ativar;
    }

    /**
     *
     * @param ativar
     */
    public void setAtivar(String ativar) {
        this.ativar = ativar;
    }

    /**
     *
     * @return
     */
    public String getComprar() {
        return comprar;
    }

    /**
     *
     * @param comprar
     */
    public void setComprar(String comprar) {
        this.comprar = comprar;
    }

    /**
     *
     * @return
     */
    public String getAtiveantes() {
        return ativeantes;
    }

    /**
     *
     * @param ativeantes
     */
    public void setAtiveantes(String ativeantes) {
        this.ativeantes = ativeantes;
    }
    
}
