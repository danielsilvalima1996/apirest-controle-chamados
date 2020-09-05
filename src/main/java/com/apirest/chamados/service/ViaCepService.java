package com.apirest.chamados.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.stereotype.Service;

import com.apirest.chamados.model.ViaCep;
import com.google.gson.Gson;

@Service
public class ViaCepService {

	static String webService = "http://viacep.com.br/ws/";
	static int codigoSucesso = 200;

	public static ViaCep buscaEnderecoPelo(String cep) throws Exception {
		String urlParaChamada = webService + cep + "/json";

		try {
			URL url = new URL(urlParaChamada);
			HttpURLConnection conexao = (HttpURLConnection) url.openConnection();

			if (conexao.getResponseCode() != codigoSucesso) {
				throw new RuntimeException("HTTP error code : " + conexao.getResponseCode());
			}

			BufferedReader resposta = new BufferedReader(new InputStreamReader((conexao.getInputStream())));
			String jsonEmString = converteJsonEmString(resposta);

			Gson gson = new Gson();
			ViaCep endereco = gson.fromJson(jsonEmString, ViaCep.class);

			if (endereco.getCep() == null) {
				throw new Exception("CEP Não encontrado");
			}
			
			return endereco;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public static String converteJsonEmString(BufferedReader buffereReader) throws IOException {
		String resposta, jsonEmString = "";
		while ((resposta = buffereReader.readLine()) != null) {
			jsonEmString += resposta;
		}
		return jsonEmString;
	}

}
