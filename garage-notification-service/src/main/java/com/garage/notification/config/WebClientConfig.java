package com.garage.notification.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
@EnableWebFlux
public class WebClientConfig {

    @Bean
    public WebClient webClient() {
        return WebClient.builder()
                 // Apply ExchangeFilterFunction
                .build();
    }

	/*
	 * private ExchangeFilterFunction logRequest() { return
	 * ExchangeFilterFunction.ofRequestProcessor(clientRequest -> {
	 * System.out.println("Request: " + clientRequest.method() + " " +
	 * clientRequest.url()); clientRequest.headers().forEach((name, values) ->
	 * values.forEach(value -> System.out.println(name + ": " + value))); return
	 * clientRequest.exchange(); }); }
	 */
}
