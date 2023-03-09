package controller;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.swing.JFrame;
import model.model;
import view.inventario;
import view.principal;
import view.inventario;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
public class controller implements ActionListener
{   
    JFrame frame;
    private ArrayList datos2 = new ArrayList<>();
    public controller()
    {
        
    }
    public controller(JFrame frame_c)
    {
        frame=frame_c;
    }
    public void Principal()
    {
        principal p = new principal();
        p.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	p.setExtendedState(JFrame.MAXIMIZED_BOTH);
	p.setResizable(true);
	p.setVisible(true);
    }
    public void actionPerformed(ActionEvent e) 
    {
        model m = new model();
        inventario i = new inventario(frame, "GESTION DE INVENTARIO",m.select(m.conexion()));
        String evento = e.getActionCommand();
        datos2 = m.select(m.conexion());
        //VISTAS
        if(evento.equals("GESTION DE INVENTARIO"))
        {   
            setDatos2(datos2);
            i.setSize(1000, 600);
            i.setBackground(Color.red);
            i.setResizable(false);
            i.setVisible(true);
        }
        //MODELO
        if(evento.equals("refresh"))
        {
           i.valores_seleccionados(datos2);
        }
        if(evento.equals("ping"))
        {
            String fila = i.ip;
            m.ping(fila);
        }
        if(evento.equals("conectar"))
        {
            String fila = i.ip;
            String sucursal = i.suc;
            m.conectar(fila, sucursal);
            
            
        }
        if(evento.equals("salir"))
        {
            System.err.println("salir alb");
            i.dispose();
        }
    }

    public ArrayList getDatos2() {
        return datos2;
    }

    public void setDatos2(ArrayList datos2) {
        this.datos2 = datos2;
    }
    
}
