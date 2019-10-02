import React from 'react';
import ReactDOM from 'react-dom';
/*import {BrowserRouter} from 'react-router-dom';*/
import App from './src/App';
import './index.css';
import * as serviceWorker from './serviceWorker';

ReactDOM.render(<App />, document.getElementById('root'));
serviceWorker.unregister();