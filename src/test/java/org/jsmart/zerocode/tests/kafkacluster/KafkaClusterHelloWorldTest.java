package org.jsmart.zerocode.tests.kafkacluster;

import org.jsmart.zerocode.core.domain.JsonTestCase;
import org.jsmart.zerocode.core.domain.TargetEnv;
import org.jsmart.zerocode.core.runner.ZeroCodeUnitRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

@TargetEnv("host_kafka_cluster.properties")
@RunWith(ZeroCodeUnitRunner.class)
public class KafkaClusterHelloWorldTest {

    @Test
    @JsonTestCase("tests/kafka_helloworld/kafka_produce_consume_test.json")
    public void testKafka_helloWorld() throws Exception {
    }

}
