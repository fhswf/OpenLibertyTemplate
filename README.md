# FH SWF - Open Liberty Template

Template Anwendung für den Jakarta EE Server [Open Liberty](https://openliberty.io/).
Wir verwenden die aktuelle Beta Version `21.0.0.10-beta`, welche Jakarta EE 9 unterstützt.
Eine Installation von Maven wird vorausgesetzt (getestet mit Maven 3).

## Installation und Start

1. Download und Starten des Open Liberty Servers über Maven:

```shell
mvn liberty:dev
```

2. Wenn der Server gestartet ist, sollte folgende Meldung auf der Konsole erscheinen:

```
[INFO] [AUDIT   ] CWWKF0011I: Der Server defaultServer ist für die Ausführung von Smarter Planet bereit. Der Server defaultServer ist nach 8,605 Sekunden gestartet.
```

3. Die Server ist nun bereit für Programmierung mit Jakarta EE 9.
   Unter [http://localhost:9080/](http://localhost:9080/) kann die Anwendung aufgerufen werden.
