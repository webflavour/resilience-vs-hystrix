import React from 'react';
import { Alert } from 'react-bootstrap';


export default class Warning extends React.Component {
    constructor(props, context) {
        super(props, context);
    }

    render() {
        return this.props.items.length === 0 ? (
            <Alert bsStyle="warning">
                <h5>
                    <strong>Es ist etwas schief gelaufen!</strong>
                </h5>{' '}
                Es gibt keine Einträge in der Einkaufsliste. Füge welche hinzu!
            </Alert>
        ) : null;
    }
}
