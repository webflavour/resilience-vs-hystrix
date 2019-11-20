# Studienarbeit - Vergleich zwischen Hystrix und Resilience4j an einem Beispiel.

In diesem Repository ist die komplette Studienarbeit von Patrick Auer und Heiko Fischer gespeichert. Das Reposiotry beinhaltet:
> Backend Entwicklung für Hystrix und Resilience4j

> Frontend Entwicklung einer Beispielanwendung

> Dokumentation der Studienarbeit

> Unter "Backend" befinden sich die beiden Varianten Hystrix und Resilience4j wieder. 

> Unter "Frontend" befindet sich ein Beispiel Anwendung umgesetzt mit ReactJS. 

## Frontend ##
Um den Client zu starten wird NodeJS auf der lokalen Maschine benoetigt. In der Konsole unter dem korrekten Ordner /Frontend/list sind die Befehle npm install und npm start auszufuehren.

### Installation von ReactJS Application ###

> npx create-react-app app 

> cd app

Zusätzlich eingebunden wurde:
> npm install axios für RestAPI

> npm i --save @fortawesome/react-fontawesome

> npm i --save @fortawesome/free-solid-svg-icons

Sowie die Library Ant.Design
> npm install antd

### Start der ReactJS Application ###
> npm install

> npm start (http://localhost:3000)


## Backend ##
Um das jeweilige Backend Hystrix oder Resilience4j zu starten, wird Apache Maven Project benötigt, sowie eine Java SDK auf dem lokalen System. 

### Start einer Backendanwendung ###
> entsprechenden Pfad des Backends öffnen

> mvn clean 

> mvn install

> mvn package
