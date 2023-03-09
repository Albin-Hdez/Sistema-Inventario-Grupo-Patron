package view;
import controller.controller;
import java.awt.*;
import javax.swing.*;
public class principal extends JFrame
{
    JMenuBar Barra;
    JMenu Inventario, Red;
    JMenuItem Gestion, Gestion_R;
    
    public principal()
    {
        super("Sistema de Monitoreo Grupo Patron");
        this.getContentPane().setBackground(Color.BLACK);
        
        Barra = new JMenuBar();
        Barra.setBackground(Color.BLACK);
        this.setJMenuBar(Barra);
        
        //Fondo
        JLabel lb_p = new JLabel();
        ImageIcon icono=new ImageIcon("C:\\Users\\SISTEMAS\\Documents\\NetBeansProjects\\MGP\\src\\img\\patron_logo.png");
        Image logo = new ImageIcon(getClass().getResource("/img/patron_logo.png")).getImage();
        ImageIcon ic=new ImageIcon(logo.getScaledInstance(1700, 600, Image.SCALE_SMOOTH));
	lb_p.setIcon(ic);
        this.add(lb_p);
	
        //INVENTARIO
        Inventario=new JMenu("INVENTARIOS");
	Inventario.setForeground(Color.GREEN);
	Barra.add(Inventario);
        
        Gestion=new JMenuItem("GESTION DE INVENTARIO");
	Gestion.setBackground(Color.black);
	Gestion.setForeground(Color.white);
	Inventario.add(Gestion);
        
        //REDES
        Red=new JMenu("REDES");
	Red.setForeground(Color.GREEN);
	Barra.add(Red);
        
        Gestion_R=new JMenuItem("GESTION DE REDES");
	Gestion_R.setBackground(Color.black);
	Gestion_R.setForeground(Color.white);
	Red.add(Gestion_R);
        
        //EVENTOS
        controller ctrl = new controller(this);
        Gestion.addActionListener(ctrl);
        Gestion_R.addActionListener(ctrl);
    }
}
