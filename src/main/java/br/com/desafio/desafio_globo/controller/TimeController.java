package br.com.desafio.desafio_globo.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TimeController {
	
	Logger logger = LoggerFactory.getLogger(TimeController.class);
	
    @GetMapping("/hora")
    @Cacheable("horaAtual")
    public String horaAtual() {
    	DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    	logger.info("Esse endpint possui cache configurado de 10 segundos.");
        return LocalDateTime.now().format(format);
    }
    
    @GetMapping("/mensagem")
    public String mensagem() {    	
    	return "============Desafio DevOps para Globo===============";
    }
}
