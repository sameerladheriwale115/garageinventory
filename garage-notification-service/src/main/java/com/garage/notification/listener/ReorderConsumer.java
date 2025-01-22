package com.garage.notification.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.garage.notification.model.Part;
import com.garage.notification.service.OrderPartService;

import reactor.core.publisher.Mono;

@Service
public class ReorderConsumer {
	
	@Autowired
	private OrderPartService orderPartService;

    @KafkaListener(topics = "part-order-topic")
    public void consume(String message) {
    	ObjectMapper mapper = new ObjectMapper();
        System.out.println("Consumed message: " + message);
        try {
            Part part = mapper.readValue(message, Part.class);
            // Process the part object
            System.out.println("Received Part: " + part.getPartID());
            Mono<Part> partMono = orderPartService.fetchData(part.getPartID());
            sendRequest(part, partMono);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

	private void sendRequest(Part part, Mono<Part> partMono) {
		Part request = partMono.block();
		request.setAvailableQty(part.getMinOrderQty());
		Mono<Part> partupd = orderPartService.updatePart(part.getPartID(),request);
		System.out.println(partupd.block());
	}


	/*
	 * @KafkaListener(topics = "Kafka_Example_json",containerFactory =
	 * "userKafkaListenerFactory") public void consumeJson(User user) {
	 * System.out.println("Consumed JSON Message: " + user); }
	 */
}
