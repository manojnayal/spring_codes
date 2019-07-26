package org.example.currencyconvertor.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.example.currencyconvertor.bean.CurrencyConversionBean;
import org.example.currencyconvertor.service.CurrencyExchangeServiceProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CurrencyConversionController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	 @Autowired
	  private CurrencyExchangeServiceProxy proxy;
	@GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean getConvertedCurrency(@PathVariable String from,
			@PathVariable String to, @PathVariable BigDecimal quantity) {
		 Map<String, String> uriVariables = new HashMap<String,String>();
		    uriVariables.put("from", from);
		    uriVariables.put("to", to);
		    
		    //ResponseEntity<CurrencyConversionBean> responseEntity =
		    		
		    CurrencyConversionBean response = proxy.retrieveExchangeValue(from, to);
		    logger.info("{}", response);
		    return new CurrencyConversionBean(response.getId(), from, to, response.getConversionMultiple(), quantity,
		            quantity.multiply(response.getConversionMultiple()), response.getPort());
	}
}
