package org.jsmart.zerocode.tests.kafkafiledump;

import org.jsmart.zerocode.core.domain.JsonTestCase;
import org.jsmart.zerocode.core.domain.TargetEnv;
import org.jsmart.zerocode.core.runner.ZeroCodeUnitRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

@TargetEnv("host_kafka_single.properties")
@RunWith(ZeroCodeUnitRunner.class)
public class KafkaRecordsToFileDumpTest {

    @Test
    @JsonTestCase("tests/file_dump/kafka_consume_record_dump_test.json")
    public void testKafkaRawRecordDump() throws Exception {
    }


}
