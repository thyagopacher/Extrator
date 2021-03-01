package visao;

import java.awt.AWTException;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import static java.awt.SystemTray.getSystemTray;
import java.awt.TrayIcon;
import static java.awt.TrayIcon.MessageType.valueOf;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import static java.lang.System.exit;
import static java.lang.Thread.sleep;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 *
 * @author Charleston Anjos
 * @version 1.0 - 2013
 */
public class TaskBar {

    //Instance new SystemTray
    private static final SystemTray Tray = getSystemTray();
    private static TrayIcon TrayIconBar;

    //variables
    private static String IconMain;
    private static JFrame frame;
    private static MouseListener mlOpcoes;
    private static String NameTask;

    //variables the alteration image
    private static boolean AlterCountTray = false;    

    /**
     *
     * @param icon
     * @param frame
     * @param nameTask 
     */
    TaskBar(String icon, JFrame frame,String nameTask){
        TaskBar.IconMain = icon;
        TaskBar.frame = frame;
        TaskBar.NameTask = nameTask;
    }

    /**
     *
     */
    public void instanceTask(){                

        //alter image and instance task
        alterImageTray(IconMain);

        //add events mouse
        //initEventsMouse();

        //add icon in SystemTray
        try {           
            Tray.add(TrayIconBar);
        } catch (AWTException ex) {
            showMessageDialog(null, "Problemas ao instanciar taskbar causado por:" + ex, "ERRO:",JOptionPane.ERROR_MESSAGE);
        }

        AlterCountTray = true;

    }

    /**
     *
     * @param image
     */
    public void alterImageTray(String image){
        //if not exist instance create new
        if (TaskBar.AlterCountTray==false){
            TrayIconBar = new TrayIcon(new ImageIcon(getClass().getResource(image)).getImage(),NameTask,initPopUpMenu());
        }else{
            TrayIconBar.setImage(new ImageIcon(getClass().getResource(image)).getImage());
        }

        //image auto resize
        TrayIconBar.setImageAutoSize(true);
    }

    /**
     *
     * @param imageOne
     * @param imageTwo
     * @param time
     */
    //used with timerbean
    public void useSequenceImage(String imageOne, String imageTwo, int time){
        try {

            alterImageTray(imageOne); //image footprint parameter changes

            sleep(time); //time for change

            alterImageTray(imageTwo); //image footprint parameter changes
            
        } catch (InterruptedException ex) {
            showMessageDialog(null, "Problemas ao instanciar taskbar causado por:" + ex, "ERRO:",JOptionPane.ERROR_MESSAGE);
        }
    }

    private void initEventsMouse(){
        //instantiates a mouse listener for use user be in TrayIcon
            mlOpcoes = new MouseListener(){

                @Override
                public void mouseClicked(MouseEvent e) {
//                     frame.setVisible(true);
//                     frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
                }
@Override
                public void mousePressed(MouseEvent e) {}
@Override
                public void mouseReleased(MouseEvent e) {
                    /*  if the mouse is clicked with the wheel mouse or with
                     *  button right close the application 
                    if(e.getButton() == 2 || e.getButton() == 3){
                        //System.exit(0);
                    }*/
                }
@Override
                public void mouseEntered(MouseEvent e) {}
@Override
                public void mouseExited(MouseEvent e) {}

            };

         //add mouseListener in TrayIcon
        TrayIconBar.addMouseListener(mlOpcoes);
    }

    /**
     * @return PopUp
     */
    private PopupMenu initPopUpMenu() {

        PopupMenu popup = new PopupMenu();
        
        MenuItem miAbout = new MenuItem("Sobre");
        miAbout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showMessageDialog(null, "Extrator de E-mails\nVersão 1.0\n\n"
                        + "Desenvolvido por Thyago Henrique Pacher\n");
            }
        });

        MenuItem miReturn = new MenuItem("Voltar");
        miReturn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(true);
                frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
            }
        });

        MenuItem miExit = new MenuItem("Sair");
        miExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {                
                exit(0);
            }
        });
        
        popup.add(miAbout);
        popup.addSeparator();
        popup.add(miReturn);
        popup.addSeparator();
        popup.add(miExit);

        return popup;
    }

    /**
     *
     * @param title
     * @param message
     * @param type
     */
    public void displayMessageTask(String title, String message, int type){
        String style = "";
        switch(type){
            case 0: style = "NONE";break;
            case 1: style = "INFO";break;
            case 2: style = "ERROR";break;
            case 3: style = "WARNING";break;
        }
        TrayIconBar.displayMessage(title, message,valueOf(style));
    }    
}