package org.uniquindio.edu.co.poo.model;
import javax.swing.*;
import java.util.Collection;
import java.util.List;
import java.util.ArrayList;

public class Consultorio {

    private String nombre;
    private String direccion;
    private List<Paciente>listaPacientes;
    private List<Odontologo>listaOdontologos;


    public Consultorio(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.listaOdontologos = new ArrayList<>();
        this.listaPacientes = new ArrayList<>();
    }

    public String getNombre() {

        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDireccion() {

        return direccion;
    }

    public ArrayList<Paciente>listaPacientes() {
        return (ArrayList<Paciente>) listaPacientes;
    }
    public ArrayList<Odontologo>listaOdontologos() {
        return (ArrayList<Odontologo>) listaOdontologos;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void registrarOdontologo(Odontologo odontologo) {
        listaOdontologos.add(odontologo);
    }

    public void registrarPaciente(Paciente paciente) {
        listaPacientes.add(paciente);
    }

    public List<Paciente> obtenerPacientesConMasDe5Tratamientos() {
        List<Paciente> resultado = new ArrayList<>();
        for (Paciente p : listaPacientes) {
            if (p.getTratamientosRealizados() > 5) {
                resultado.add(p);
            }
        }
        return resultado;
    }

}



