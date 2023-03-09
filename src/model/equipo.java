package model;
public class equipo 
{
    private String IP;
    private String ENCARGADO;
    private String SUCURSAL;
    private String PROCESADOR;
    private int RAM;
    private String TDD;
    private int CAPACIDAD;
    private int STATUS;

    public equipo() 
    {
        
    }
    public equipo(String IP, String ENCARGADO, String SUCURSAL, String PROCESADOR, int RAM, String TDD, int CAPACIDAD, int STATUS) 
    {
        this.IP = IP;
        this.ENCARGADO = ENCARGADO;
        this.SUCURSAL = SUCURSAL;
        this.PROCESADOR = PROCESADOR;
        this.RAM = RAM;
        this.TDD = TDD;
        this.CAPACIDAD = CAPACIDAD;
        this.STATUS = STATUS;
    }

    public String getIP() {
        return IP;
    }

    public void setIP(String IP) {
        this.IP = IP;
    }

    public String getENCARGADO() {
        return ENCARGADO;
    }

    public void setENCARGADO(String ENCARGADO) {
        this.ENCARGADO = ENCARGADO;
    }

    public String getSUCURSAL() {
        return SUCURSAL;
    }

    public void setSUCURSAL(String SUCURSAL) {
        this.SUCURSAL = SUCURSAL;
    }

    public String getPROCESADOR() {
        return PROCESADOR;
    }

    public void setPROCESADOR(String PROCESADOR) {
        this.PROCESADOR = PROCESADOR;
    }

    public int getRAM() {
        return RAM;
    }

    public void setRAM(int RAM) {
        this.RAM = RAM;
    }

    public String getTDD() {
        return TDD;
    }

    public void setTDD(String TDD) {
        this.TDD = TDD;
    }

    public int getCAPACIDAD() {
        return CAPACIDAD;
    }

    public void setCAPACIDAD(int CAPACIDAD) {
        this.CAPACIDAD = CAPACIDAD;
    }

    public int getSTATUS() {
        return STATUS;
    }

    public void setSTATUS(int STATUS) {
        this.STATUS = STATUS;
    }

    @Override
    public String toString() {
        return "equipo{" + "IP=" + IP + ", ENCARGADO=" + ENCARGADO + ", SUCURSAL=" + SUCURSAL + ", PROCESADOR=" + PROCESADOR + ", RAM=" + RAM + ", TDD=" + TDD + ", CAPACIDAD=" + CAPACIDAD + ", STATUS=" + STATUS + '}';
    }
    
    
}
