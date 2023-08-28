package br.com.alura.ecommerce;

public class EmailSevice {
    public static void main(String[] args) {
        var kafkaService = new KafkaService(EmailSevice.class.getSimpleName(), "ECOMMERCE_SEND_EMAIL");
        kafkaService.runConsumer();
    }
}