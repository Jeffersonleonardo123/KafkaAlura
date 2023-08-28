package br.com.alura.ecommerce;

public class FraudDetectorSevice {
    public static void main(String[] args) {
        var kafkaService = new KafkaService(FraudDetectorSevice.class.getSimpleName(), "ECOMMERCE_NEW_ORDER");
        kafkaService.runConsumer();
    }
}
