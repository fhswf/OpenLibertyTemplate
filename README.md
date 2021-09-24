# FH SWF - Open Liberty Template

Template Anwendung für den Jakarta EE Server [Open Liberty](https://openliberty.io/). Die Anwendung soll mit einer aktuellen Beta Version, welche Jakarta EE 9 unterstützt, funktionieren.
Dieses muss vor dem Start in der pom.xml hinterlegt werden. Eine Installation von Maven
wird vorausgesetzt (getestet mit Maven 3).

## Installation und Start

1. Download und Starten des Open Liberty Servers

```shell
mvn liberty:run
```

2. Wenn der Server gestartet ist, sollte folgende Meldung auf der Konsole erscheinen:

```
[INFO] [AUDIT   ] CWWKF0011I: Der Server defaultServer ist für die Ausführung von Smarter Planet bereit. Der Server defaultServer ist nach 8,605 Sekunden gestartet.
```

3. Die Server ist nun bereit für Programmierung mit Jakarta EE 9.
   Unter [http://localhost:9080/FIT/](http://localhost:9080/FIT/) kann die Anwendung aufgerufen werden.
