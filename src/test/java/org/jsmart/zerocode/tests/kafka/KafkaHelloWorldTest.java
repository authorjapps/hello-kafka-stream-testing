package org.jsmart.zerocode.tests.kafka;

import org.jsmart.zerocode.core.domain.JsonTestCase;
import org.jsmart.zerocode.core.domain.TargetEnv;
import org.jsmart.zerocode.core.runner.ZeroCodeUnitRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

@TargetEnv(value="app_host.properties")
@RunWith(ZeroCodeUnitRunner.class)
public class KafkaHelloWorldTest {

    @Test
    @JsonTestCase("tests/kafka_helloworld/kafka_produce_consume_test.json")
    public void testKafka_helloWorld() throws Exception {
    }

}
