package br.com.alura.ecommerce;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

public class KafkaService {
    private static String className = "";
    private static String nameQueue =  "";

    public KafkaService(String className, String nameQueue){
        this.nameQueue = nameQueue;
        this.className = className;
    }

    public void runConsumer(){
        var consumer = new KafkaConsumer<String, String>(properties());
        consumer.subscribe(Collections.singletonList(nameQueue));

        while (true) {
            var records = consumer.poll(Duration.ofMillis(100));
            if (!records.isEmpty()) {
                System.out.println("encontrei registro " + records.count());
            }

            for (var record : records) {
                System.out.println("-------------------------------------");
                System.out.println("Processing " + nameQueue);
                System.out.println(record.key() + " -- " + record.value());

                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("processado com sucesso!");
            }
        }


    }

    private static Properties properties() {
        var properties = new Properties();
        properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
        properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG, className);
        return properties;
    }
}
