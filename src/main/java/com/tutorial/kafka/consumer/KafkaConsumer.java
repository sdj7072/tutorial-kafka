package com.tutorial.kafka.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class KafkaConsumer {
	
	Logger log = LoggerFactory.getLogger(KafkaConsumer.class);

    @KafkaListener(topics = "${spring.kafka.template.default-topic}", containerFactory = "kafkaListenerContainerFactory", groupId = "${spring.kafka.consumer.group-id}")
    public void listenMeJJTopic(@Payload String message, @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition) throws Exception {
        //log.info("Topic: [me-jj-topic] messageKey Message: [" + messageKey + "]");
        log.info("Topic: [me-jj-topic] Received Message: [" + message + "] from partition: [" + partition + "]");
    }
    /*
    public void listenMeJJTopic(@Payload String message, @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition, @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String messageKey) throws Exception {
        log.info("Topic: [me-jj-topic] messageKey Message: [" + messageKey + "]");
        log.info("Topic: [me-jj-topic] Received Message: [" + message + "] from partition: [" + partition + "]");
    }
    */
}
