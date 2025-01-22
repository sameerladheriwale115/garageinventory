package com.garage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.garage.domain.Part;
import com.garage.repositories.AutoReorderService;

@Service
public class AutoReorderServiceImpl implements AutoReorderService {
	
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final String TOPIC_NAME= "part-order-topic"; // Replace with your desired topic name

    public AutoReorderServiceImpl(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    private void sendMessage(String message) {
        kafkaTemplate.send(TOPIC_NAME, message);
        System.out.println("Message " + message +
             " has been sucessfully sent to the topic: " + TOPIC_NAME);
    }

	@Override
	public void reorder(Part part) {
		//Part part = partService.getPartById(partId);
		if(null != part) {
			try {
				this.sendMessage(new ObjectMapper().writeValueAsString(part));
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
	
	

}
