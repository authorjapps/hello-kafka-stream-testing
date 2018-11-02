# Kafka Testing Hello World examples

Most simple way to test Kafka Streaming e.g. Read/Write during HBase/Hadoop BigData store or any other Data Ingestion Pipe Lines

e.g.
```javascript
{
    "scenarioName": "Produce and consume a message",
    "steps": [
        {
            "name": "produce_now",
            "url": "kafka-topic:hello-demo",
            "operation": "produce",
            "request": {
                "key": "${RANDOM.NUMBER}",
                "value": "Hello World"
            },
            "assertions": {
                "status" : "Ok"
            }
        },
        {
            "name": "consume_now",
            "url": "kafka-topic:hello-demo",
            "operation": "consume",
            "request": {
            },
            "assertions": {
                "records.SIZE" : 1
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

IntelliJ(General key-board shotcuts):
=====
More keys: https://www.jetbrains.com/help/idea/mastering-intellij-idea-keyboard-shortcuts.html
1. Open a matching java file -> Ctrl + n
1. Open a matching JSON or XML file -> Ctrl + Shift + n
1. To navigate to file -> Ctrl + Click
1. Usage/invocation of a JSON file or Java File or Java method/variable etc -> Alt + F7
