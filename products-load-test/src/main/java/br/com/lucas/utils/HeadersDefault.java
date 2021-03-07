package br.com.lucas.utils;

import static br.com.lucas.utils.Constants.ACCEPT;
import static br.com.lucas.utils.Constants.CONTENT_TYPE;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;


@Service
public class HeadersDefault {
	public HttpHeaders creatHeaders() {
		HttpHeaders header = new HttpHeaders();
		header.set(CONTENT_TYPE, APPLICATION_JSON_VALUE);
		header.set(ACCEPT, APPLICATION_JSON_VALUE);
		return header;
	}

}