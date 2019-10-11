import React from "react";
import ReactDOM from "react-dom";
import List from './requestService';
import "./index.css";
import 'bootstrap/dist/css/bootstrap.min.css';

function App() {
    return (
        <div className="container">
            <div className="row">
                <div className="col">
                    <h1>Einkaufsliste</h1>
                    <hr />
                </div>
            </div>
            <List />
        </div>
    );
}

const rootElement = document.getElementById("root");
ReactDOM.render(<App />, rootElement);