import React from 'react';
import {Button} from 'antd';

import './App.css';
import AddItem from "./Components/addItem";
import EditItem from "./Components/editItem";
import RequestService from "./requestService";

const requestService = new RequestService('http://localhost:8080/');

class App extends React.Component {
    constructor(props, context) {
        super(props, context);
        this.state = {
            items: [],
            errorOnRequest: false,
            renderAddItem: AddItem,
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


    addItemToShoppingList(item) {
        requestService
            .addItemToShoppingList(item)
            .then(res => {
                this.loadCompleteShoppingList();
                this.setState({errorOnRequest: false});
            })
            .catch(error => {

                this.setState({errorOnRequest: true});
            });
    }

    removeItemFromShoppingList(itemId) {
        requestService
            .removeItem(itemId)
            .then(res => {
                this.loadCompleteShoppingList();
                this.setState({errorOnRequest: false});
            })
            .catch(error => {
                this.setState({errorOnRequest: true});
                this.loadCompleteShoppingList();
            });
    }

    loadCompleteShoppingList() {
        requestService
            .getCompleteShoppingList()
            .then(res => {
                this.setState({items: res.data, errorOnRequest: false});
            })
            .catch(error => {
                this.setState({errorOnRequest: true});
            });
    }

    render() {
        return (
            <div className="App">
                <header className="App-header">

                    <p>Welcome to our</p>

                    <div>
                        <h1>React.js Shopping List Application</h1>
                    </div>

                    <div>
                        <AddItem onClick={item => this.addItemToShoppingList(item)}/>
                        <EditItem
                            items={this.state.items}
                            errorOnRequest={this.state.errorOnRequest}
                            onClick={itemId => this.removeItemFromShoppingList(itemId)}
                        />
                        <Button type="primary">Primary</Button>
                    </div>
                </header>
            </div>
        );
    }
}

export default App
