package org.uniquindio.edu.co.poo.model;

import java.time.LocalDate;

public record Paciente(String numHistoriaClinica, String nombre, int edad, String telefono,
                       LocalDate fechaUltimaConsulta, int tratamientosRealizados) {

    public Paciente(String numHistoriaClinica, String nombre, int edad, String telefono, LocalDate fechaUltimaConsulta, int tratamientosRealizados) {
        this.numHistoriaClinica = numHistoriaClinica;
        this.nombre = nombre;
        this.edad = edad;
        this.telefono = telefono;
        this.fechaUltimaConsulta = fechaUltimaConsulta;
        this.tratamientosRealizados = tratamientosRealizados;
    }

    public String getHistoriaClinica() {
        return numHistoriaClinica;
    }

    public String getNombre() {
        return nombre;
    }

    public int getTratamientosRealizados() {
        return tratamientosRealizados;
    }

    public char[] numeroHistoriaClincica() {
        return numHistoriaClinica.toCharArray();
    }



   //Método para actualizar información sin modificar el objeto original

    public Paciente actualizar(String fechaUltimaConsulta, int nuevosTratamientos) {
        return new Paciente(this.numHistoriaClinica, this.nombre, this.edad, this.telefono, this.fechaUltimaConsulta, nuevosTratamientos);
    }

}
