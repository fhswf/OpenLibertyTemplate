# FH SWF - Open Liberty Template
Template Anwendung für den Jakarta EE Server [Open Liberty](https://openliberty.io/). Die Anwendung soll mit einer aktuellen Beta Version, welche Jakarta EE 9 unterstützt, funktionieren.
Dieses muss vor dem Start in der pom.xml hinterlegt werden. Eine Installation von Maven
wird vorausgesetzt (getestet mit Maven 3). 
## Installation und Start
1. Installation des Open Liberty Servers mit Jakarta EE 9 Unterstützung. Beispiel: [21.0.0.10-beta](https://openliberty.io/downloads/#runtime_betas)
2. Abändern der samplePom.xml in pom.xml.
3. Ändern der Plugin Configuration in der pom.xml auf die installierte Open Liberty Version. 
```xml
<configuration>
    <installDirectory>{Pfad zum WLP Ordner der Open Liberty Installation}</installDirectory>
</configuration>
```
4. Starten des Server über mvn liberty:dev im Hauptverzeichnis mit der pom.xml.
5. Die Server ist nun bereit für Programmierung mit Jakarta EE 9.