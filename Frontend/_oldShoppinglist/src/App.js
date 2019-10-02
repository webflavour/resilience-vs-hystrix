import React, { Component } from 'react';
import RequestService from '../requestService';
import AddItem from './Components/addItem';
import EditItem from './Components/editItem';

import 'bootstrap/dist/css/bootstrap.css';
import { Jumbotron } from 'react-bootstrap';
import './App.css';

const requestService = new RequestService('http://localhost:8080/');

class App extends Component {
    constructor(props, context) {
        super(props, context);
        this.state = {
            items: [],
            errorOnRequest: false
        };
        this.loadCompleteShoppingList();
    }

    reloadItems() {
        this.loadCompleteShoppingList();
    }

    componentDidMount() {
        this.interval = setInterval(() => this.reloadItems(), 3000);
    }

    componentWillUnmount() {
        clearInterval(this.interval);
    }

    renderAddItem() {
        return <AddItem />;
    }

    addItemToShoppingList(item) {
        requestService
            .addItemToShoppingList(item)
            .then(res => {
                this.loadCompleteShoppingList();
                this.setState({ errorOnRequest: false });
            })
            .catch(error => {
                this.state.errorOnRequest = true;
            });
    }

    removeItemFromShoppingList(itemId) {
        requestService
            .removeItem(itemId)
            .then(res => {
                this.loadCompleteShoppingList();
                this.setState({ errorOnRequest: false });
            })
            .catch(error => {
                this.setState({ errorOnRequest: true });
                this.loadCompleteShoppingList();
            });
    }

    loadCompleteShoppingList() {
        requestService
            .getCompleteShoppingList()
            .then(res => {
                this.setState({ items: res.data, errorOnRequest: false });
            })
            .catch(error => {
                this.setState({ errorOnRequest: true });
            });
    }

    render() {
        return (
            <div>
                <p>Hello</p>
                <Jumbotron className="jumbotron">
                    <div className="container">
                        <h1>React.js Shopping List Application</h1>
                    </div>
                </Jumbotron>
                <div className="container">
                    <AddItem onClick={item => this.addItemToShoppingList(item)} />
                    <EditItem
                        items={this.state.items}
                        errorOnRequest={this.state.errorOnRequest}
                        onClick={itemId => this.removeItemFromShoppingList(itemId)}
                    />
                </div>
            </div>
        );
    }
}
export default App;
