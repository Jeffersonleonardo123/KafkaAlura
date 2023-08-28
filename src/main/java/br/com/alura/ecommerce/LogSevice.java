package br.com.alura.ecommerce;

public class LogSevice {
    public static void main(String[] args) {
        var kafkaService = new KafkaService(LogSevice.class.getSimpleName(), "ECOMMERCE.*");
        kafkaService.runConsumer();
    }
}
