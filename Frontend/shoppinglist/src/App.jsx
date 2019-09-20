import React, {Component} from 'react';
import {Route} from 'react-router-dom';
import Dashboard from './Screens/Dashboard';

class App extends Component {
    render() {
        return (
            <div >
                <Route exact path="/" component={Dashboard} />
            </div>
        );
    }
}
export default App;