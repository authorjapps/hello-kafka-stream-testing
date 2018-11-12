package org.jsmart.zerocode.tests.kafkanocommit;

import org.jsmart.zerocode.core.domain.JsonTestCase;
import org.jsmart.zerocode.core.domain.TargetEnv;
import org.jsmart.zerocode.core.runner.ZeroCodeUnitRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

@TargetEnv("application_hosts.properties")
@RunWith(ZeroCodeUnitRunner.class)
public class KafkaHelloWorldNoCommitTest {

    @Test
    @JsonTestCase("tests/kafka_helloworld_no_commit/kafka_consume_no_commit_test.json")
    public void testKafka_noCommit() throws Exception {
    }

}
