# Studienarbeit - Vergleich zwischen Hystrix und Resilience4j an einem Beispiel.

In diesem Repository ist die komplette Studienarbeit gespeichert.

Unter "Backend" befinden sich die beiden Varianten Hystrix und Resilience4j wieder. Backend läuft unter http://localhost:8080
Unter "Frontend" befindet sich ein Beispiel Anwendung umgesetzt mit ReactJS. Frontend läuft utner http://localhost:3000

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

> npm start

### Alternative: How to generate a React Project from scratch ###

- Run Command "npm init" to generate a package.json file in the correct folder. (/Frontend/shoppinglist)
- Write down all important informations about the project (version, author, license, description, ...)
- Open the package.json file and check it. Add a line with "private:true,"
- We used "parcel" for the react project. So we added also the line {"start": "parcel index.html", "build": "parcel build index.html"} after "scripts"
- Now we installed all important react things
>  npm install --save react

>  npm install --save react-dom

>  npm install --save-dev babel-preset-env

>  npm install --save-dev babel-preset-react / npm install --save-dev @babel/preset-react

>  npm install --save-dev parcel-bundler / npm install parcel-bundler --save-dev / npm install -g parcel-bundler

>  npm install --save-dev sass

>  npm install --save react-router-dom

> npm install axios für RestAPI

Einbinden von Fontawesome und SVG Icons:

> npm i --save @fortawesome/react-fontawesome

> npm i --save @fortawesome/free-solid-svg-icons




- We need then a .babelrc, index.html and index.js file
- We generated a "src" folder, inside of this folder we generated a App.js and App.css file.
- With "npm start" we can start the frontend. It is running on http://localhost:1234



