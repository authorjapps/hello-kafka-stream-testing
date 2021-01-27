package org.jsmart.zerocode.integration.tests.kafka.consume;

import org.jsmart.zerocode.core.domain.Scenario;
import org.jsmart.zerocode.core.domain.TargetEnv;
import org.jsmart.zerocode.core.runner.ZeroCodeUnitRunner;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * How to run? How to put the AVRO message directly to the topic ? How to consume ?
 * Ans:
 * - Run the ProducerPLAIN_TEXT.java, which produces directly to topic
 *   - AVRO messages are always coupled with the scema
 *     - See: http://cloudurable.com/blog/avro/index.html
 *     - When deserializing data, the schema is used. Data is serialized based on the schema,
 *       and schema is sent with data
 * - Run only the consume step here: org.jsmart...consume.KafkaConsumeAvroTest#testKafkaConsume_avroJson()
 *   - test_kafka_consume_avro_msg_json.json
 * -
 *
 */

//@Ignore("For running these Avro tests please uncomment the depdendency 'kafka-avro-serializer' in the 'pom.xml'." +
//        "And also uncomment the '<repository>' section")
@TargetEnv("kafka_servers/kafka_test_server_avro.properties")
@RunWith(ZeroCodeUnitRunner.class)
public class KafkaConsumeAvroTest {

    @Test
    @Scenario("kafka/consume/test_kafka_consume_avro_msg_json.json")
    public void testKafkaConsume_avroJson() throws Exception {
    }

    @Test
    @Scenario("kafka/consume/test_kafka_consume_avro_msg_raw_int.json")
    public void testKafkaConsume_avroRaw() throws Exception {
    }

    @Test
    @Scenario("kafka/consume/test_kafka_consume_avro_msg_raw_json.json")
    public void testKafkaConsume_avroRawJson() throws Exception {
    }

}
