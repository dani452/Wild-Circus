package com.wildCircus.demo.controller;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.wildCircus.demo.entity.Contact;


	@Controller
	public class SimpleEmail {

		@Autowired
		public JavaMailSender emailSender;

		@PostMapping("/sendSimpleEmail")

		public String sendSimpleEmail(@Valid @ModelAttribute("contact") Contact contact,
				BindingResult bindingResult) throws MessagingException {

			if (bindingResult.hasErrors()) {
				return "contactUs";
			} else {
				MimeMessage mailling = emailSender.createMimeMessage();

				boolean multipart = true;
				MimeMessageHelper helper = new MimeMessageHelper(mailling, multipart, "utf-8");

				String htmlMsg = "<h3>A client send you a message.</h3><br>" + contact.getFirstname()
						+ " " + contact.getLastname() + "<br>" + contact.getMail() + "<br>" + contact.getPhone()
						+ "<br><p>He try to contact you for a " + contact.getEvenement() + "." + "</p><br>"
						+ contact.getMessage();

				mailling.setContent(htmlMsg, "text/html");

				helper.setTo(Contact.FRIEND_EMAIL);

				helper.setSubject("Demande de contact d'un client.");

				// Send Message!
				this.emailSender.send(mailling);

				return "redirect:/contact";
			}
		}

	}

