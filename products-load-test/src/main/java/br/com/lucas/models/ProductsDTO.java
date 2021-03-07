package br.com.lucas.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductsDTO {
	
	private String id;
	private Double price_in_cents;
	private String title;
	private String description;
	private DiscountDTO discount;

}
