package com.apirest.chamados.controller;

import java.util.Date;

import com.apirest.chamados.model.dto.Status;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin(origins = "*")
@Api(value="API REST Status")
@RequestMapping("/api/status")
public class StatusController {

	@Value("${spring.datasource.url}")
	private String database;

	@ApiOperation(value = "Status da API")
	@GetMapping(produces = { "application/json" })
	public ResponseEntity<Status> getStatus() throws Exception {
		final String baseUrl = 
		ServletUriComponentsBuilder.fromCurrentContextPath().build().toUriString();
		String[] baseName = database.split(":");
		return ResponseEntity.ok(new Status(baseUrl, baseName[1].toUpperCase(), new Date()));
	}
    
}
