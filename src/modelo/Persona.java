/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author santo
 */
public class Persona {
    private String nombres, apellidos, direccion, telefono, fecha_nacimiento;

    public Persona(){}
    public Persona(String nombres, String apellidos, String direccion, String telefono, String fecha_nacimiento) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.telefono = telefono;
        this.fecha_nacimiento = fecha_nacimiento;
        
        
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }
    
    protected void crear(){}
    protected void actualizar(){}
    protected void borrar(){}
}
