package org.jsmart.zerocode.integration.tests.kafka.consume;

import org.apache.avro.Schema;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericRecord;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import java.util.Properties;

public class AvroDirectTest {

    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
//        props.put("key.serializer", "io.confluent.kafka.serializers.KafkaAvroSerializer");
//        props.put("value.serializer", "io.confluent.kafka.serializers.KafkaAvroSerializer");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "io.confluent.kafka.serializers.KafkaAvroSerializer");
        props.put("schema.registry.url", "http://localhost:8081");
        KafkaProducer producer = new KafkaProducer(props);

        String key = "key1";
        String userSchema = "{\"type\":\"record\"," +
                "\"name\":\"myrecord\"," +
                "\"fields\":[{\"name\":\"f1\",\"type\":\"string\"}]}";
        Schema.Parser parser = new Schema.Parser();
        Schema schema = parser.parse(userSchema);
        GenericRecord avroRecord = new GenericData.Record(schema);
        avroRecord.put("f1", "valueX");

        ProducerRecord<String, Object> record = new ProducerRecord<String, Object>("demo-avro-2", key, avroRecord);

//        ProducerRecord<Object, Object> record = new ProducerRecord<Object, Object>("demo-avro-1", key, avroRecord);
        try {
            producer.send(record);
            //producer.commitTransaction();
            System.out.println("done");
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
