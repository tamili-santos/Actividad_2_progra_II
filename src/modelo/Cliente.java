/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
*
 * @author santo
 */
public class Cliente extends Persona {
    private int id;
    private String nit;
    Conexion cn;
    public Cliente(){}

    public Cliente(int id, String nit, String nombres, String apellidos, String direccion, String telefono, String fecha_nacimiento) {
        super(nombres, apellidos, direccion, telefono, fecha_nacimiento);
        this.id = id;
        this.nit = nit;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }
    
    @Override
    public void crear(){
        try{
           PreparedStatement parametro;
           cn = new Conexion();
           cn.abrir_conexion();
           String query = "INSERT INTO clientes(nit,nombres,apellidos,direccion,telefono,fecha_nacimiento) VALUES(?,?,?,?,?,?);";
           parametro = (PreparedStatement) cn.conexionBD.prepareStatement(query);
           parametro.setString(1, getNit());
           parametro.setString(2, getNombres());
           parametro.setString(3, getApellidos());
           parametro.setString(4, getDireccion());
           parametro.setString(5, getTelefono());
           parametro.setString(6, getFecha_nacimiento());
           int ejecutar = parametro.executeUpdate();
           cn.cerrar_conexion();
           System.out.println("Ingreso exitoso: "+Integer.toString(ejecutar));
        }catch(SQLException ex){
                    System.out.println("Error en crear; "+ ex.getMessage());
                    }
        
    }
  
    public DefaultTableModel leer() {
        DefaultTableModel tabla = new DefaultTableModel();
        
        try{
            cn = new Conexion();
            cn.abrir_conexion();
            String query;
            query = "Select id_clientes as id,nit,nombres,apellidos,direccion,telefono,fecha_nacimiento from clientes;";
            ResultSet consulta = cn.conexionBD.createStatement().executeQuery(query);
            
            String encabezado[] = {"id","Nit","Nombres","Apellidos","Direccion","Telefono","Nacimiento"};
            tabla.setColumnIdentifiers(encabezado);
            
            
            String datos[]=new String[7];
            
            while(consulta.next())
            {
                datos[0]=consulta.getString("id");
                datos[1]=consulta.getString("nit");
                datos[2]=consulta.getString("nombres");
                datos[3]=consulta.getString("apellidos");
                datos[4]=consulta.getString("direccion");
                datos[5]=consulta.getString("telefono");
                datos[6]=consulta.getString("fecha_nacimiento");
                tabla.addRow(datos);
            }
            cn.cerrar_conexion();
            
        }catch(SQLException ex){
            cn.cerrar_conexion();
            System.out.println("Error: "+ ex.getMessage());
        }
        return tabla;
    }
        @Override
        public void actualizar(){
        try{
           PreparedStatement parametro;
           cn = new Conexion();
           cn.abrir_conexion();
           String query = "update clientes set nit = ?,nombres= ?,apellidos= ?,direccion= ?,telefono= ?,fecha_nacimiento= ? "+
                           "where id_clientes = ?";
           parametro = (PreparedStatement) cn.conexionBD.prepareStatement(query);
           parametro.setString(1, getNit());
           parametro.setString(2, getNombres());
           parametro.setString(3, getApellidos());
           parametro.setString(4, getDireccion());
           parametro.setString(5, getTelefono());
           parametro.setString(6, getFecha_nacimiento());
           parametro.setInt(7, getId());
           int ejecutar = parametro.executeUpdate();
           cn.cerrar_conexion();
           System.out.println("Registro actualizado: "+Integer.toString(ejecutar));
        }catch(SQLException ex){
                    System.out.println("Error en crear; "+ ex.getMessage());
                    }
        }
        
        @Override
        public void borrar(){
         try{
           PreparedStatement parametro;
           cn = new Conexion();
           cn.abrir_conexion();
           String query = "delete from clientes where id_clientes = ?";
                           
           parametro = (PreparedStatement) cn.conexionBD.prepareStatement(query);    
           parametro.setInt(1, getId());
           
           int ejecutar = parametro.executeUpdate();
           cn.cerrar_conexion();
           System.out.println("Registro eliminado: "+Integer.toString(ejecutar));
        }catch(SQLException ex){
                    System.out.println("Error en crear; "+ ex.getMessage());
                    }
        }
    
}
    
    

