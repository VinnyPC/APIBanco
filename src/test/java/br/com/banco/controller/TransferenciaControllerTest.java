package br.com.banco.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import br.com.banco.model.TransferenciaModel;
import br.com.banco.repository.TransferenciaRepository;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TransferenciaControllerTest {
	
	private TransferenciaController transferenciaController;

    @Mock
    private TransferenciaRepository transferenciaRepository;

    @Before(value = "")
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        transferenciaController = new TransferenciaController(transferenciaRepository);
    }

    @Test
    public void testGetAll() {
        List<TransferenciaModel> transferencias = new ArrayList<>();
        transferencias.add(new TransferenciaModel());
        transferencias.add(new TransferenciaModel());

        when(transferenciaRepository.findAll()).thenReturn(transferencias);

        ResponseEntity<List<TransferenciaModel>> response = transferenciaController.getAll();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(2, response.getBody().size());
    }

    @Test
    public void testGetTransferenciasPorOperador() {
        List<TransferenciaModel> transferencias = new ArrayList<>();
        transferencias.add(new TransferenciaModel());
        transferencias.add(new TransferenciaModel());

        when(transferenciaRepository.findByOperador(anyString())).thenReturn(transferencias);

        List<TransferenciaModel> response = transferenciaController.getTransferenciasPorOperador("operador");

        assertEquals(2, response.size());
    }

    @Test
    public void testGetTransferenciasEspecificas() {
        List<TransferenciaModel> transferencias = new ArrayList<>();
        transferencias.add(new TransferenciaModel());
        transferencias.add(new TransferenciaModel());

        LocalDateTime startDateTime = LocalDate.of(2022, 1, 1).atStartOfDay();
        LocalDateTime endDateTime = LocalDate.of(2022, 1, 31).plusDays(1).atStartOfDay();

        when(transferenciaRepository.findByDataBetweenAndOperadorIgnoreCase(any(LocalDateTime.class), any(LocalDateTime.class), anyString())).thenReturn(transferencias);

        List<TransferenciaModel> response = transferenciaController.getTransferenciasEspecificas(LocalDate.of(2022, 1, 1), LocalDate.of(2022, 1, 31), "operador");

        assertEquals(2, response.size());
    }
}
