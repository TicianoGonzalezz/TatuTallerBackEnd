package com.example.tatu.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.tatu.entidades.ReservaClase;

@Service
public class EmailServicio {

    @Autowired
    private JavaMailSender mailSender;

    // Método para enviar un correo de confirmación al profesor
    /**
     * Envía un correo de confirmación al profesor cuando se realiza una reserva de
     * clase.
     *
     * @param reserva Objeto ReservaClase que contiene los detalles de la reserva.
     */
    public void enviarMailConfirmacionProfesor(ReservaClase reserva) {
        String emailProfesor = reserva.getClase().getProfesor().getEmail();
        String linkConfirmar = "http://localhost:8080/reservas/confirmar/" + reserva.getId();
        String linkRechazar = "http://localhost:8080/reservas/rechazar/" + reserva.getId();
        String asunto = "Nueva Reserva de Clase";
        String mensaje = "Hola " + reserva.getClase().getProfesor().getNombre() + ",\n\n" +
                "Tienes una nueva reserva de clase:\n" +
                "Usuario: " + reserva.getUsuario().getNombre() + "\n" +
                "Fecha: " + reserva.getFechaReserva() + "\n" +
                "Hora : " + reserva.getClase().getHorarioDesde() + " - " + reserva.getClase().getHorarioHasta()
                + "\n\n"
                +
                "Por favor, confirma o rechaza la reserva usando los siguientes enlaces:\n" +
                "Confirmar: " + linkConfirmar + "\n" +
                "Rechazar: " + linkRechazar + "\n\n" +
                "Saludos,\nEl equipo de Tatu";
        enviarMail(emailProfesor, asunto, mensaje);
    }

    // Método para enviar un correo de respuesta al usuario
    /**
     * Envía un correo de respuesta al usuario informando si su reserva fue aceptada
     * o rechazada.
     *
     * @param reserva  Objeto ReservaClase que contiene los detalles de la reserva.
     * @param aceptada Indica si la reserva fue aceptada o rechazada.
     */
    public void enviarMailRespuestaUsuario(ReservaClase reserva, boolean aceptada) {
        String emailUsuario = reserva.getUsuario().getEmail();
        String asunto = aceptada ? "Reserva de Clase Aceptada" : "Reserva de Clase Rechazada";
        String mensajeTexto = aceptada
                ? "Hola " + reserva.getUsuario().getNombre() + ",\n\n" +
                        "Tu reserva de clase ha sido aceptada.\n" +
                        "Fecha: " + reserva.getFechaReserva() + "\n" +
                        "Hora: " + reserva.getClase().getHorarioDesde() + " - " + reserva.getClase().getHorarioHasta()
                        + "\n\n"
                        +
                        "Saludos,\nEl equipo de Tatu"
                : "Hola " + reserva.getUsuario().getNombre() + ",\n\n" +
                        "Lamentablemente, tu reserva de clase ha sido rechazada.\n\n" +
                        "Saludos,\nEl equipo de Tatu";

        enviarMail(emailUsuario, asunto, mensajeTexto);

    }

    public void enviarMailConfirmacionPorLote(List<ReservaClase> reservas) {
        for (ReservaClase reserva : reservas) {
            String emailProfesor = reserva.getClase().getProfesor().getEmail();
            String linkConfirmar = "http://localhost:8080/reservas/confirmar/" + reserva.getId();
            String linkRechazar = "http://localhost:8080/reservas/rechazar/" + reserva.getId();
            String asunto = "Nueva Reserva de Clase (Reserva Mensual)";
            String mensaje = "Hola " + reserva.getClase().getProfesor().getNombre() + ",\n\n" +
                    "Tienes una nueva reserva de clase:\n" +
                    "Usuario: " + reserva.getUsuario().getNombre() + "\n" +
                    "Fecha: " + reserva.getFechaReserva() + "\n" +
                    "Hora: " + reserva.getClase().getHorarioDesde() + " - " + reserva.getClase().getHorarioHasta()
                    + "\n\n" +
                    "Por favor, confirma o rechaza la reserva usando los siguientes enlaces:\n" +
                    "Confirmar: " + linkConfirmar + "\n" +
                    "Rechazar: " + linkRechazar + "\n\n" +
                    "Saludos,\nEl equipo de Tatu";
            enviarMail(emailProfesor, asunto, mensaje);
        }
    }

    public void enviarMail(String destinatario, String asunto, String mensaje) {
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(destinatario);
        mail.setSubject(asunto);
        mail.setText(mensaje);
        mailSender.send(mail);
    }

}
