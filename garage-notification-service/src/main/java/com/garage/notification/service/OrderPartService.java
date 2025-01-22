package com.garage.notification.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import com.garage.notification.model.Part;

import reactor.core.publisher.Mono;

@Service
public class OrderPartService {
	private final WebClient webClient;

    @Autowired
    public OrderPartService(WebClient webClient) {
        this.webClient = webClient;
    }

    public Mono<Part> fetchData(Integer id) {
        return webClient.get()
                .uri("http://localhost:8080/api/parts/"+id)
                .retrieve()
                .bodyToMono(Part.class);
    }
    
    public Mono<ResponseEntity<Void>> updateData(Part part) {

        return webClient.put()
          .uri("http://localhost:8080/api/parts/")
          .contentType(MediaType.APPLICATION_JSON)
          .bodyValue(part)
          .retrieve()
          .toBodilessEntity();
      }
    
    public Mono<Part> updatePart(int partId, Part part) {
        return webClient.put()
                .uri("http://localhost:8080/api/parts/{id}", partId)
                .bodyValue(part)
                .retrieve()
                .bodyToMono(Part.class)
                .onErrorResume(WebClientResponseException.class, ex -> {
                    // Handle error
                    System.err.println("Error: " + ex.getMessage());
                    return Mono.empty();
                });
    }

}
