# Kafka Testing Hello World examples

Visit the README file of [zerocode-tdd](https://github.com/authorjapps/zerocode) for declarative style testing and many flavours of [HelloWorld samples](https://github.com/authorjapps/zerocode/blob/master/README.md#hello-world-).

Let's learn about most simple and efficient way to test Kafka Streaming e.g. Read/Write during HBase/Hadoop BigData store or any other Data Pipe Lines or Micro-Services involving REST as well as Kafka. 

<details>
  <summary>Try-at-home examples and much more(click to exapnd)</summary>

+ [Kafka testing - Examples to run at home](https://github.com/authorjapps/hello-kafka-stream-testing/tree/master/src/test/resources/kafka)

+ [Kafka testing - An Intro](https://github.com/authorjapps/zerocode/wiki/Kafka-Testing-Introduction)

+ [Other HelloWorld examples](https://github.com/authorjapps/zerocode/blob/master/README.md#hello-world-), such as Spring boot app testing, Performance testing, Kotlin app testing etc.

</details>

<br/>

<br/>

For running the below test, please jump to the corresponding JUnit @Test.

```java
@TargetEnv("kafka_servers/kafka_test_server.properties")
@RunWith(ZeroCodeUnitRunner.class)
public class KafkaProduceTest {

    @Test
    @JsonTestCase("kafka/produce/test_kafka_produce.json")
    public void testProduce() throws Exception {
        // No node is needed here. What?
    }

}
```

In the above code 

a) 'test_kafka_produce.json' is the Test Case which contains the JSON step(s). See a sample below.

b) 'kafka_test_server.properties' contains the "Broker" details and Producer/Consumer configs

c) '@RunWith(ZeroCodeUnitRunner.class)' is a JUnit custom runner to run the test


e.g.
```javascript
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
* Logs @ `target/logs/zerocode_test_logs.log`
* Test coverage CSV Report @ `target/zerocode_full_report_YYYY-MM-DDTHH-MM-SS.SSS.csv`
* Test coverage Chart @ `target/zerocode_results_chart_YYYY-MM-DDTHH-MM-SS.SSS.html`
* More [reports](https://github.com/authorjapps/zerocode#generated-reports-and-charts)

References:
---
Eclipse(General key-board shotcuts):
=====
For quick reference only- See more eclipse keys https://www.linkedin.com/pulse/top-30-eclipse-keyboard-shortcuts-java-programmer-jayveersinh-solanki/
1. Open a matching java file -> Ctrl + Shift + R
1. Open a matching JSON file -> Ctrl + Shift + R
1. To navigate to file -> Ctrl + Click
1. Clik a JSON file and navigate to it's JUnit Test -> Alt+Cmd+G(Mac: ⌥+⌘+G), Windows(Alt+Ctrl+G)

IntelliJ(General key-board shotcuts):
=====
More keys: https://www.jetbrains.com/help/idea/mastering-intellij-idea-keyboard-shortcuts.html
1. Open a matching java file -> Ctrl + n
1. Open a matching JSON or XML file -> Ctrl + Shift + n
1. To navigate to file -> Ctrl + Click
1. Usage/invocation of a JSON file or Java File or Java method/variable etc -> Alt + F7
