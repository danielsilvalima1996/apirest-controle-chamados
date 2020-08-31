package com.apirest.chamados.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(consumes=MediaType.APPLICATION_JSON_UTF8_VALUE, 
produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
public interface RestService {

}