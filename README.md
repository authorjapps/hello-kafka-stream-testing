# Kafka Testing Hello World examples

This repo used open-source lib [zerocode-tdd](https://github.com/authorjapps/zerocode) for declarative style testing. 

👉 Many flavours of [RealWorld Testing Samples](https://github.com/authorjapps/zerocode/tree/master/kafka-testing-examples) of Kafka, Daatabases & API etc are available here.


> _Please make sure you bring up [Kafka in a Docker](https://github.com/authorjapps/zerocode-docker-factory/wiki/Docker-container-for-Kafka-and-Schema-Registry) prior to running the tests._

Let's learn the most simple and efficient way of automated testing of Kafka applications. 
This is particulaly useful during:

+ Micro-Services involving REST and Kafka
+ Read/Write during BigData store e.g. HBase/Hadoop
+ any other Data Pipe Lines

<details>
  <summary>Try-at-home examples and much more(click to exapnd)</summary>

+ [Kafka testing - Examples to run at home](https://github.com/authorjapps/hello-kafka-stream-testing/tree/master/src/test/resources/kafka)

+ [Kafka testing - An Intro](https://github.com/authorjapps/zerocode/wiki/Kafka-Testing-Introduction)

+ [Other HelloWorld examples](https://github.com/authorjapps/zerocode/blob/master/README.md#hello-world-), such as Spring boot app testing, Performance testing, Kotlin app testing etc.

</details>

<br/>

For running the below test, please jump to the corresponding JUnit @Test.

```java
@TargetEnv("kafka_servers/kafka_test_server.properties")
@RunWith(ZeroCodeUnitRunner.class)
public class KafkaProduceTest {

    @Test
    @Scenario("kafka/produce/test_kafka_produce.json")
    public void testProduce() throws Exception {
        // No code needed here.
    }

}
```

In the above code 

- `test_kafka_produce.json` is the Test Case which contains the JSON step(s). See a sample below.
- `kafka_test_server.properties` contains the "Broker" details and Producer/Consumer configs
- `@RunWith(ZeroCodeUnitRunner.class)` is a JUnit custom runner to run the test


e.g.
```json
{
    "scenarioName": "Simple Produce and Consume  a record to-from a kafka topic",
    "steps": [
        {
            "name": "produce_step",
            "url": "kafka-topic:demo-topic1",
            "operation": "produce",
            "request": {
                "records":[
                    {
                        "key": "${RANDOM.NUMBER}",
                        "value": "Hello World"
                    }
                ]
            },
            "assertions": {
                "status" : "Ok"
            }
        },
        {
            "name": "consume_step",
            "url": "kafka-topic:demo-topic1",
            "operation": "consume",
            "request": {
            },
            "assertions": {
                "size": 1,
                "records": [
                    {
                        "key" : "$NOT.NULL",
                        "value": "Hello World"
                    }
                ]
            }
        }
    ]
}

```

Now you can see the-
* Reports @ `target`
* Logs @ `target/logs/test_logs.log`
* Test coverage CSV Report @ `target/zerocode-junit-granular-report.csv`
* Test coverage Chart @ `target/zerocode-junit-interactive-fuzzy-search.html`
* More [reports](https://github.com/authorjapps/zerocode#generated-reports-and-charts)

## IDE References:

### IntelliJ(General key-board shotcuts):
More keys - See more [IntelliJ keys](https://www.jetbrains.com/help/idea/mastering-intellij-idea-keyboard-shortcuts.html)
1. Open a matching java file -> <kbd>Ctrl</kbd> + <kbd>n</kbd>
1. Open a matching JSON or XML file -> <kbd>Ctrl</kbd> + <kbd>Shift</kbd> + <kbd>n</kbd>
1. To navigate to file -> <kbd>Ctrl</kbd> + <kbd>Click</kbd>
1. Usage/invocation of a JSON file or Java File or Java method/variable etc -> <kbd>Alt</kbd> + <kbd>F7</kbd>

### Eclipse(General key-board shotcuts):
For quick reference only - See more [eclipse keys](https://www.linkedin.com/pulse/top-30-eclipse-keyboard-shortcuts-java-programmer-jayveersinh-solanki/)
1. Open a matching java file -> <kbd>Ctrl</kbd> + <kbd>Shift</kbd> + <kbd>R</kbd>
1. Open a matching JSON file -> <kbd>Ctrl</kbd> + <kbd>Shift</kbd> + <kbd>R</kbd>
1. To navigate to file -> <kbd>Ctrl</kbd> + <kbd>Click</kbd>
1. Clik a JSON file and navigate to it's JUnit Test -> <kbd>Alt</kbd>+<kbd>Cmd</kbd>+<kbd>G</kbd>(Mac: <kbd>⌥</kbd>+<kbd>⌘</kbd>+<kbd>G</kbd>), Windows(<kbd>Alt</kbd>+<kbd>Ctrl</kbd>+<kbd>G</kbd>)
