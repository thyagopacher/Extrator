package Comunicacao;

import java.io.*; // classes para input e output streams e
import java.net.*;// DatagramaSocket,InetAddress,DatagramaPacket
import javax.swing.JOptionPane;

/**
 *
 * @author thyago
 */
public class UDPServidor extends Thread{

    /**
     *
     */
    public String ip;

    /**
     *
     */
    public String mensagem;

    /**
     *
     */
    public int    portaRecebida;

    /**
     *
     */
    public static DatagramSocket servidorSocket;
           static DatagramSocket clienteSocket;
    
    /**
     *
     * @param porta
     */
    public void conectarServidor(int porta){
        try {
            servidorSocket = new DatagramSocket(porta);
        } catch (SocketException ex) {
            JOptionPane.showMessageDialog(null, "Porta de recebimento de mensagens sendo utilizada por outro processo:\n" + ex);
        }
    }
    
//carregamento dinamico da porta para o envio de mensagens

    /**
     *
     * @param porta_envio
     */
        public void conectarCliente(int porta_envio){
        try {
            clienteSocket = new DatagramSocket(porta_envio);
        } catch (SocketException ex) {
            JOptionPane.showMessageDialog(null, "Porta de envio sendo utilizada por outro processo:\n" + ex);
        }
    }
    
    /**
     *
     * @param mensagem
     * @param ip
     * @param porta
     * @param porta_envio
     */
    public void enviar(String mensagem, String ip, int porta, int porta_envio){
        conectarCliente(porta_envio);
        DatagramPacket enviarPacote;
        byte[] msgEnviar = mensagem.getBytes();
        InetAddress ipDestino1;
        //porta default para o programa no envio
        if(porta == 0){
            porta = 10001;
        }
        try {
            ipDestino1   = InetAddress.getByName(ip);
            enviarPacote = new DatagramPacket(msgEnviar, msgEnviar.length, ipDestino1, porta);
            clienteSocket.send(enviarPacote);
        } catch (UnknownHostException ex) {
            JOptionPane.showMessageDialog(null, "Host desconhecido:\n" + ex);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro de IO: \n" + ex);
        }
        clienteSocket.close();
    }
    
    /**
     *
     * @param porta
     */
    public void receberMensagem(int porta){
        conectarServidor(porta);
        DatagramPacket receberPacote;
        byte[] msgRecebida = new byte[1024];
        receberPacote = new DatagramPacket(msgRecebida, msgRecebida.length);
        try{  
                servidorSocket.receive(receberPacote);
                mensagem        = new String(receberPacote.getData());
                mensagem        = mensagem.trim();
                ip              = String.valueOf(receberPacote.getAddress());
                portaRecebida   = receberPacote.getPort();
                gravarMensagem();
                servidorSocket.close();
            } catch(IOException ex) {
                JOptionPane.showMessageDialog(null, "Erro na recepção: " + ex, "ERRO:", JOptionPane.ERROR_MESSAGE);
            }

    }
    
    /**
     *
     */
    public void gravarMensagem(){
        Cliente  cliente  = new Cliente();
        try{
            cliente.setIp(ip);
            cliente.setMensagem(mensagem);
            cliente.setPorta(portaRecebida);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Aconteceu o seguinte erro:\n" + e);
        }

    }

    //retorna o endereÃ§o de broadcast para determinado ip

    /**
     *
     * @param ip
     * @return
     */
        public String retornaBroadcast(String ip){
        String broadcast1 = "";
        ip = ip.replaceAll("ThyagoPacher-PC/", "");
        String[] endereco = ip.split("\\.");
        //classe A
        if((Integer.valueOf(endereco[0]) >= Integer.valueOf("0")) && (Integer.valueOf(endereco[0]) <= Integer.valueOf("127"))){
            broadcast1 = endereco[0] + ".255.255.255";
        }
        //classe B
        if((Integer.valueOf(endereco[0]) >= Integer.valueOf("128")) && (Integer.valueOf(endereco[0]) <= Integer.valueOf("191"))){
            broadcast1 = endereco[0] + "." + endereco[1] + "." + "255.255";
        }
        //classe C
        if((Integer.valueOf(endereco[0]) >= Integer.valueOf("192")) && (Integer.valueOf(endereco[0]) <= Integer.valueOf("223"))){
            broadcast1 = endereco[0] + "." + endereco[1] + "." + endereco[2] + "." +"255";
        }
        return broadcast1;
    }
}

