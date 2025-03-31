package org.uniquindio.edu.co.poo.app;

import org.uniquindio.edu.co.poo.model.Consultorio;
import org.uniquindio.edu.co.poo.model.Especialidad;
import org.uniquindio.edu.co.poo.model.Odontologo;
import org.uniquindio.edu.co.poo.model.Paciente;

import javax.swing.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Paciente> listaPacientes = new ArrayList<>();
        List<Odontologo> listaOdontologos = new ArrayList<>();

        Consultorio consultorio = new Consultorio("Consultorio universidad del Quindio", "Clle 12N");

        // Registrar odontólogos
        consultorio.registrarOdontologo(new Odontologo("Dr. Juan Pérez", "OD001", "LIC123", Especialidad.ORTODONCIA));
        consultorio.registrarOdontologo(new Odontologo("Dra. María Gómez", "OD002", "LIC456", Especialidad.ENDODONCIA));


        // Registrar pacientes
        consultorio.registrarPaciente(new Paciente("1", "Ana López", 30, "312334455", LocalDate.of(2024, 3, 15), 6));
        consultorio.registrarPaciente(new Paciente("2", "Carlos Martínez", 45, "362459898", LocalDate.of(2024, 2, 10), 4));
        consultorio.registrarPaciente(new Paciente("3", "Luis Fernández", 50, "32427890", LocalDate.of(2023, 12, 5), 7));



        boolean continuar = true;

        while (continuar) {
            String opcion = JOptionPane.showInputDialog(
                    "Seleccione una opción:\n" +
                            "1. Agregar Paciente\n" +
                            "2. Agregar Odontólogo\n" +
                            "3. Mostrar información de Pacientes\n" +
                            "4. Mostrar información de Odontólogos\n" +
                            "5. Mostrar Pacientes con más de 5 tratamientos\n" +
                            "6. Salir"
            );

            switch (opcion) {
                case "1":
                    boolean agregarPaciente;
                    do {
                        String numHistoriaClinica = JOptionPane.showInputDialog("Ingrese el número de historia clínica del paciente:");
                        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del paciente:");
                        double edad = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la edad del paciente:"));
                        String telefono = JOptionPane.showInputDialog("Ingrese el teléfono del paciente:");
                        LocalDate fechaUltimaConsulta = LocalDate.now();
                        int tratamientosRealizados = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de tratamientos realizados:"));

                        listaPacientes.add(new Paciente(numHistoriaClinica, nombre, (int) edad, telefono, fechaUltimaConsulta, tratamientosRealizados));

                        agregarPaciente = JOptionPane.showConfirmDialog(null, "¿Desea agregar otro paciente?", "Confirmación", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
                    } while (agregarPaciente);
                    break;

                case "2":
                    boolean agregarOdontologo;
                    do {
                        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del odontólogo:");
                        String id = JOptionPane.showInputDialog("Ingrese el ID del odontólogo:");
                        String telefono = JOptionPane.showInputDialog("Ingrese el teléfono del odontólogo:");
                        String[] especialidades = {"ORTODONCIA", "ENDODONCIA", "PERIODONCIA", "CIRUGÍA ORAL"};
                        Especialidad especialidad = Especialidad.valueOf((String) JOptionPane.showInputDialog(null, "Seleccione la especialidad:", "Especialidad", JOptionPane.QUESTION_MESSAGE, null, especialidades, especialidades[0]));

                        listaOdontologos.add(new Odontologo(nombre, id, telefono, especialidad));

                        agregarOdontologo = JOptionPane.showConfirmDialog(null, "¿Desea agregar otro odontólogo?", "Confirmación", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
                    } while (agregarOdontologo);
                    break;

                case "3":
                    StringBuilder pacientesInfo = new StringBuilder("Pacientes registrados:\n");
                    for (Paciente pacienteAux : listaPacientes) {
                        pacientesInfo.append(" ").append(pacienteAux.nombre()).append("  Numero de historia clínica: ").append(pacienteAux.numeroHistoriaClincica()).append(" Teléfono: ").append(pacienteAux.telefono()).append("  Edad: ").append(pacienteAux.edad()).append("  Última fecha: ").append(pacienteAux.fechaUltimaConsulta()).append("  # Tratamientos: ").append(pacienteAux.tratamientosRealizados()).append("\n");
                    }
                    JOptionPane.showMessageDialog(null, pacientesInfo.toString());
                    break;

                case "4":
                    StringBuilder odontologosInfo = new StringBuilder("Odontólogos disponibles:\n");
                    for (Odontologo odontologo : listaOdontologos) {
                        odontologosInfo.append(" ").append(odontologo.getNombre()).append(" ID: ").append(odontologo.getId()).append("  Nombre: ")
                                .append(odontologo.getNombre()).append(" Especialidad: ")
                                .append(odontologo.getEspecialidad()).append("\n");
                    }
                    JOptionPane.showMessageDialog(null, odontologosInfo.toString());
                    break;

                case "5":
                    StringBuilder pacientesGratis = new StringBuilder("Pacientes con más de 5 tratamientos:\n");
                    boolean hayPacientesGratis = false;

                    for (Paciente pacienteAux : listaPacientes) {
                        if (pacienteAux.tratamientosRealizados() > 5) {
                            pacientesGratis.append(" ").append(pacienteAux.nombre()).append("\n");
                            hayPacientesGratis = true;
                        }
                    }

                    if (hayPacientesGratis) {
                        JOptionPane.showMessageDialog(null, pacientesGratis.toString());
                    } else {
                        JOptionPane.showMessageDialog(null, "No hay pacientes para una revisión gratuita.");
                    }
                    break;

                case "6":
                    continuar = false;
                    JOptionPane.showMessageDialog(null, "Saliendo del programa...");
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida. Inténtelo de nuevo.");
            }
        }
    }
}