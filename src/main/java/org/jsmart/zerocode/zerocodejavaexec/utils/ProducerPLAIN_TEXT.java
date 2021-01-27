package org.jsmart.zerocode.zerocodejavaexec.utils;

import org.apache.avro.Schema;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericRecord;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.jsmart.zerocode.core.di.provider.GsonSerDeProvider;
import org.jsmart.zerocode.core.di.provider.ObjectMapperProvider;

import java.util.Properties;
import java.util.concurrent.Future;

public class ProducerPLAIN_TEXT {
    public static void main(String[] args) throws Exception{
        Properties properties = new Properties();
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
//        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
//        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer", "io.confluent.kafka.serializers.KafkaAvroSerializer");
        properties.put("schema.registry.url", "http://localhost:8081");

//        KafkaProducer<String,String> producer = new KafkaProducer<String, String>(properties);
//        ProducerRecord<String,String> record = new ProducerRecord<String, String>("demo-new-1","hello world...xxx..");

        KafkaProducer producer = new KafkaProducer(properties);
        String key = "key1";
        String userSchema = "{\"type\":\"record\"," +
                "\"name\":\"myrecord\"," +
                "\"fields\":[{\"name\":\"f1\",\"type\":\"string\"}]}";
        Schema.Parser parser = new Schema.Parser();
        Schema schema = parser.parse(userSchema);
        GenericRecord avroRecord = new GenericData.Record(schema);
        avroRecord.put("f1", "valueNEW1");

//        String avroJson = new ObjectMapperProvider().get().writeValueAsString(avroRecord);
        String avroJson = new GsonSerDeProvider().get().toJson(avroRecord);
        System.out.println("Gson JSON =>\n" + avroJson);

        ProducerRecord<String, Object> record = new ProducerRecord<String, Object>("topic1", key, avroRecord);

        Future<RecordMetadata> producedDetails = producer.send(record);
        System.out.println("topic: " + producedDetails.get().topic());
        System.out.println("partition: " + producedDetails.get().partition());
        producer.flush();
        producer.close();

    }
}
