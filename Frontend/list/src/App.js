import React from "react";
import List from './requestService';

import './App.css';

function App() {
  return (
      <div className="App">
          <div className="list">
            <h1>Einkaufsliste</h1>
            <hr />
              <List />
          </div>
      </div>
  );
}

export default App;
