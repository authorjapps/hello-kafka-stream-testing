package org.jsmart.zerocode.integration.tests.kafka.consume;

import org.jsmart.zerocode.core.domain.JsonTestCase;
import org.jsmart.zerocode.core.domain.TargetEnv;
import org.jsmart.zerocode.core.runner.ZeroCodeUnitRunner;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

@TargetEnv("kafka_servers/kafka_test_server.properties")
@RunWith(ZeroCodeUnitRunner.class)
public class KafkaConsumeTest {

    @Test
    @JsonTestCase("kafka/consume/test_kafka_consume.json")
    public void testKafkaConsume() throws Exception {
    }

}
