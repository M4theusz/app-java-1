package br.com.desafio.desafio_globo.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;

@RestController
public class TimeController {
	
	Logger logger = LoggerFactory.getLogger(TimeController.class);
	
	private final Counter counterHoraAtual;
	
	public TimeController (MeterRegistry registry) {
		counterHoraAtual = registry.counter("time.controller.counter");
	}
	
    @GetMapping("/hora")
    @Cacheable("horaAtual")
    public Map<String, String> horaAtual() {
    	logger.info("Esse endpint possui cache configurado de 10 segundos.");

    	DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    	Map<String, String>  horaMap = Map.of("horaServidor", LocalDateTime.now().format(format));
    	
    	counterHoraAtual.increment();
    	
        return horaMap;
    }
    
    @GetMapping("/mensagem")
    public String mensagem() {    	
    	return "============Desafio DevOps para Globo===============";
    }
}
