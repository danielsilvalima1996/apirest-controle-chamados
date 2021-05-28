package com.apirest.chamados.controller;

import java.util.Date;

import com.apirest.chamados.model.dto.Status;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin(origins = "*")
@Api(value="API REST Status")
@RequestMapping("/api/status")
public class StatusController {

    // @Autowired
	// private RegraService service;

	@ApiOperation(value = "Status da API")
	@GetMapping(produces = { "application/json" })
	public ResponseEntity<Status> findAll() throws Exception {
		Status status = new Status("url", "PostgreSQL", new Date());
        return ResponseEntity.ok(status);
	}
    
}
