# README #

This README is about how we generated a test Frontend for the Backend Examples "Hystrix and Resilience4j.

## Frontend ##
### How to generate a React Project from scratch ###

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


- We need then a .babelrc, index.html and index.js file
- We generated a "src" folder, inside of this folder we generated a App.js and App.css file.
- With "npm start" we can start the frontend. It is running on http://localhost:1234

### Alternative Installation ###

> npx create-react-app shoppinglist 

> cd shoppinglist 

> npm start