package view;

import controller.controller;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.*;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import model.equipo;
public class inventario extends JDialog
{   
    public static JTable MuestraT;
    private JScrollPane spane;
    private DefaultTableModel tmd;
    public static String ip;
    public static String suc;
    String [] Bodegas = {"Mercado","Oso", "Yebavito", "Navolato", "Culiacancito", "Espyga", "La Cruz", "Angostura", "El Gato", "Guasave", "Mezquitillo" };
    private JTextField txt_Buscar;
    JComboBox <Object> cb_bodegas, cb_componente, cb_carac;
    JButton btn_Filtrar, btn_refresh ,btn_ping ,btn_Conectar, btn_Añadir, btn_Editar, btn_Eliminar, btn_Salir;
    JLabel lb_bodega, lb_comp, lb_carac;
    
    public inventario()
    {
        
    }
    public inventario(JFrame frame, String titulo, ArrayList<equipo> select)
    {   
        super(frame, titulo);
        this.setLayout(null);
        
        lb_bodega = new JLabel("BODEGA: ");
        lb_bodega.setBounds(20, 20, 70, 20);
        this.add(lb_bodega);
        
        cb_bodegas = new JComboBox<>(Bodegas);
        cb_bodegas.setBounds(80, 20, 120, 20);
        this.add(cb_bodegas);
        
        lb_comp = new JLabel("COMPONENTE: ");
        lb_comp.setBounds(210, 20, 100, 20);
        this.add(lb_comp);
        
        cb_componente = new JComboBox<>();
        cb_componente.setBounds(300, 20, 200, 20);
        this.add(cb_componente);
        
        lb_carac = new JLabel("CARACTERISTICAS: ");
        lb_carac.setBounds(510, 20, 120, 20);
        this.add(lb_carac);
        
        cb_carac = new JComboBox<>();
        cb_carac.setBounds(630, 15, 200, 20);
        this.add(cb_carac);
        
        Image search = new ImageIcon(getClass().getResource("/img/search.png")).getImage();
        ImageIcon is=new ImageIcon(search.getScaledInstance(20, 20, Image.SCALE_SMOOTH));
        btn_Filtrar = new JButton();
        btn_Filtrar.setBounds(860, 10, 40, 40);
        btn_Filtrar.setBackground(Color.WHITE);
        btn_Filtrar.setIcon(is);
        this.add(btn_Filtrar);
        
        Image refresh = new ImageIcon(getClass().getResource("/img/refresh.png")).getImage();
        ImageIcon ir=new ImageIcon(refresh.getScaledInstance(20, 20, Image.SCALE_SMOOTH));
        btn_refresh = new JButton();
        btn_refresh.setBounds(920, 10, 40, 40);
        btn_refresh.setBackground(Color.WHITE);
        btn_refresh.setIcon(ir);
        this.add(btn_refresh);
        
        txt_Buscar = new JTextField("");
        txt_Buscar.setBounds(840, 60, 130, 20);
        add(txt_Buscar);
        
        Image ping = new ImageIcon(getClass().getResource("/img/routing.png")).getImage();
        ImageIcon iping=new ImageIcon(ping.getScaledInstance(30, 30, Image.SCALE_SMOOTH));
        btn_ping = new JButton("PING");
        btn_ping.setBounds(840, 100, 130, 60);
        btn_ping.setIcon(iping);
        btn_ping.setHorizontalTextPosition( SwingConstants.CENTER );
        btn_ping.setVerticalTextPosition( SwingConstants.BOTTOM );
        this.add(btn_ping);
        
        Image connect = new ImageIcon(getClass().getResource("/img/conection.png")).getImage();
        ImageIcon ic=new ImageIcon(connect.getScaledInstance(40, 40, Image.SCALE_SMOOTH));
        btn_Conectar = new JButton("CONECTAR");
        btn_Conectar.setBounds(840, 180, 130, 60);
        btn_Conectar.setIcon(ic);
        btn_Conectar.setHorizontalTextPosition( SwingConstants.CENTER );
        btn_Conectar.setVerticalTextPosition( SwingConstants.BOTTOM );
        this.add(btn_Conectar);
        
        Image add = new ImageIcon(getClass().getResource("/img/add.png")).getImage();
        ImageIcon iadd=new ImageIcon(add.getScaledInstance(30, 30, Image.SCALE_SMOOTH));
        btn_Añadir = new JButton("AÑADIR");
        btn_Añadir.setBounds(840, 260, 130, 60);
        btn_Añadir.setIcon(iadd);
        btn_Añadir.setHorizontalTextPosition( SwingConstants.CENTER );
        btn_Añadir.setVerticalTextPosition( SwingConstants.BOTTOM );
        this.add(btn_Añadir);
        
        Image edit = new ImageIcon(getClass().getResource("/img/edit.png")).getImage();
        ImageIcon iedit=new ImageIcon(edit.getScaledInstance(30, 30, Image.SCALE_SMOOTH));
        btn_Editar = new JButton("EDITAR");
        btn_Editar.setBounds(840, 340, 130, 60);
        btn_Editar.setIcon(iedit);
        btn_Editar.setHorizontalTextPosition( SwingConstants.CENTER );
        btn_Editar.setVerticalTextPosition( SwingConstants.BOTTOM );
        this.add(btn_Editar);
        
        Image del = new ImageIcon(getClass().getResource("/img/trash.png")).getImage();
        ImageIcon idel=new ImageIcon(del.getScaledInstance(30, 30, Image.SCALE_SMOOTH));
        btn_Eliminar = new JButton("ELIMINAR");
        btn_Eliminar.setBounds(840, 420, 130, 60);
        btn_Eliminar.setIcon(idel);
        btn_Eliminar.setHorizontalTextPosition( SwingConstants.CENTER );
        btn_Eliminar.setVerticalTextPosition( SwingConstants.BOTTOM );
        this.add(btn_Eliminar);
        
        Image exit = new ImageIcon(getClass().getResource("/img/logout.png")).getImage();
        ImageIcon iex=new ImageIcon(exit.getScaledInstance(20, 20, Image.SCALE_SMOOTH));
        btn_Salir = new JButton("SALIR", iex);
        btn_Salir.setBounds(840, 510, 130, 30);
        //btn_Salir.setIcon(iex);
        this.add(btn_Salir);
        
        MuestraT = new JTable(){public boolean isCellEditable(int rowIndex, int vColIndex){return false;}};
        tmd = new DefaultTableModel();
        tmd =  llenartabla(select);
        
        MuestraT.setModel(tmd);
        MuestraT.setRowSelectionAllowed(true);
        MuestraT.setCellSelectionEnabled(true);
        MuestraT.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e)
            {
;               if(e.getClickCount() == 1)
                {
                    JTable target = (JTable)e.getSource();
                    int row = target.getSelectedRow();
                    int col = target.getSelectedColumn();
                    
                    String ip2 = (String) target.getValueAt(row, col);
                    suc = (String) target.getValueAt(row, 2);
                    
                    set_Buscar(ip2);
                }
            }
        });
        spane = new JScrollPane(MuestraT);
        spane.setVisible(true);
        spane.setBounds(20,60,810,480);
        this.add(spane);
                
        //Eventos
        controller ctrl = new controller(frame);
        btn_refresh.addActionListener(ctrl);
        btn_refresh.setActionCommand("refresh");
        btn_ping.addActionListener(ctrl);
        btn_ping.setActionCommand("ping");
        btn_Conectar.addActionListener(ctrl);
        btn_Conectar.setActionCommand("conectar");
        
        
        btn_Salir.addActionListener(ctrl);
        btn_Salir.setActionCommand("salir");
        
       
    }
    public DefaultTableModel llenartabla(ArrayList<equipo> select)
    {   
        tmd.setRowCount(0);
        tmd.addColumn("IP");
        tmd.addColumn("ENCARGADO");
        tmd.addColumn("BODEGA");
        tmd.addColumn("PROCESADOR");
        tmd.addColumn("RAM");
        tmd.addColumn("DISCO DURO");
        tmd.addColumn("CAPACIDAD");
        tmd.addColumn("STATUS");
        
        String [] fila = new String[8];
        
        //System.out.println(select.size());
        for (int i = 0; i < select.size(); i++) 
        {
            
            fila[0] = select.get(i).getIP();
            fila[1] = select.get(i).getENCARGADO();
            fila[2] = select.get(i).getSUCURSAL();
            fila[3] = select.get(i).getPROCESADOR();
            fila[4] = Integer.toString(select.get(i).getRAM());
            fila[5] = select.get(i).getTDD();
            fila[6] = Integer.toString(select.get(i).getCAPACIDAD());
            fila[7] = Integer.toString(select.get(i).getSTATUS());
            
            tmd.addRow(fila);
        }
        
        return tmd;
    }
    public void valores_seleccionados(ArrayList A)
    {   
        controller c = new controller();
        System.err.println(A);
    }
    public JTable tabla(){return this.MuestraT;}
    
    public String get_Buscar(){
        String var = this.txt_Buscar.getText();
        System.err.println(this.ip+"-1");
        return ip;
    }
    public void set_Buscar(String text)
    {
        this.ip = text;
        System.err.println(ip);
        this.txt_Buscar.setText(text);
    }
}
