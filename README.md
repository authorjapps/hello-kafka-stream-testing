# Kafka Testing Hello World examples

Most simple way to test Kafka Streaming e.g. Read/Write during HBase/Hadoop BigData store or any other Data Ingestion Pipe Lines. 

<details>
  <summary>Try-at-home examples and much more(click to exapnd)</summary>

+ [Kafka testing - Examples to run at home](https://github.com/authorjapps/hello-kafka-stream-testing/tree/master/src/test/resources/kafka)

+ [Kafka testing - An Intro](https://github.com/authorjapps/zerocode/wiki/Kafka-Testing-Introduction)

+ [Database persistence testing](https://github.com/authorjapps/zerocode/wiki/Sample-DB-SQL-Executor)

+ [OAuth2 testing](https://github.com/authorjapps/zerocode-hello-world/blob/master/src/test/java/org/jsmart/zerocode/testhelp/tests/OAuth2/OAuth2Test.java)

+ [Many more HelloWorld examples](https://github.com/authorjapps/zerocode/blob/master/README.md#hello-world-), such as Spring boot app testing, Performance testing, Kotlin app testing etc.

</details>

<br/>

e.g.
```javascript
{
    "scenarioName": "Unload - Consume a message from kafka",
    "steps": [
        {
            "name": "load_kafka",
            "url": "kafka-topic:demo-c1",
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
            "name": "onload_kafka",
            "url": "kafka-topic:demo-c1",
            "operation": "consume",
            "request": {
            },
            "assertions": {
                "size" : "$GT.0"
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
