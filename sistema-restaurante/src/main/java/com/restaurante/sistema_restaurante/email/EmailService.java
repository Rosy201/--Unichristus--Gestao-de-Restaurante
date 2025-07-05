//package com.restaurante.sistema_restaurante.email;
//
//import com.restaurante.sistema_restaurante.data.dto.CupomDTO;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.stereotype.Service;
//
//@Service
//public class EmailService {
//
//    @Autowired
//    private JavaMailSender mailSender;
//
//    public void sendCupomEmail(String emailDestinatario, String codigo, double desconto) {
//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setTo(emailDestinatario);
//        message.setSubject("Seu cupom de Desconto1");
//        message.setText("Use o codigo" + codigo + "para obter um desconto de " + desconto + "!");
//        mailSender.send(message);
//    }
//}
