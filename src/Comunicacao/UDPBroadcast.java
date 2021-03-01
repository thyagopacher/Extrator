package Comunicacao;

import java.io.IOException;
import java.net.DatagramPacket;// DatagramaSocket,InetAddress,DatagramaPacket
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import javax.swing.JOptionPane;

/**
 *
 * @author thyago
 */
public class UDPBroadcast extends Thread{

    /**
     *
     */
    public static DatagramSocket clienteSocket;

    /**
     *
     */
    public String meu_ip;
           int                   porta_envio;

    /**
     *
     * @param porta_envio
     */
    public void conectarCliente(int porta_envio){
        try {
            clienteSocket = new DatagramSocket(porta_envio);
        } catch (SocketException ex) {
            JOptionPane.showMessageDialog(null, "Porta de envio broadcast sendo utilizada por outro processo:\n" + ex);
        }
    }
    
    //envio de mensagens para ip broadcast

    /**
     *
     * @param mensagem
     * @param ip
     * @param porta
     * @param porta_envio
     */
        public void enviar(String mensagem, String ip, int porta, int porta_envio){
        conectarCliente(porta_envio);
        byte[] msgEnviar = mensagem.getBytes();
        if(porta == 0){
            porta = 10001;
        }
        try {
            InetAddress    ipDestino1   = InetAddress.getByName(ip);
            meu_ip                      = String.valueOf(InetAddress.getLocalHost());
            clienteSocket.send(new DatagramPacket(msgEnviar, msgEnviar.length, ipDestino1, porta));
            clienteSocket.close();
        } catch (UnknownHostException ex) {
            JOptionPane.showMessageDialog(null, "Host desconhecido:\n" + ex);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro de IO:\n" + ex);
        }
  
    }
    
  
}

