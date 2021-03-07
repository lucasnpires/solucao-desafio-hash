package br.com.lucas.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.lucas.models.ProductsResponseDTO;
import br.com.lucas.models.ResultTeste;
import br.com.lucas.repository.ResultTesteRepository;
import br.com.lucas.utils.HeadersDefault;

@Component
public class ProductService {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private ResultTesteRepository resultTesteRepository;

	@Autowired
	private HeadersDefault headersDefault;

	@Value("${products_api.host:localhost}")
	private String hostProducts;

	@Value("${products_api.port:localhost}")
	private String portProducts;

	public ProductsResponseDTO getProducts(String idExecution) {
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl("http://"+hostProducts+":"+portProducts).path("/products");
		HttpHeaders headers = headersDefault.creatHeaders();
		HttpEntity<?> entity = new HttpEntity<>(headers);

		ResultTeste resultTeste = ResultTeste.builder().idExecution(idExecution).horaInicio(new Date()).build();

		final ResponseEntity<ProductsResponseDTO> response = this.restTemplate.exchange(builder.toUriString(),
				HttpMethod.GET, entity, ProductsResponseDTO.class);

		resultTeste.setHoraFim(new Date());
		resultTeste.setResultStatus(response.getStatusCodeValue());

		Date duracao = new Date(resultTeste.getHoraFim().getTime() - resultTeste.getHoraInicio().getTime());

		resultTeste.setDuracao(duracao.getTime());
		resultTesteRepository.save(resultTeste);

		return response.getBody();
	}
}
