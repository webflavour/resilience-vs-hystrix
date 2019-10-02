import React from 'react';
import { Alert } from 'react-bootstrap';


export default class RequestError extends React.Component {
    constructor(props, context) {
        super(props, context);
    }

    render() {
        return this.props.errorOnRequest ? (
            <Alert bsStyle="danger">
                <h5>
                    <strong>Da ist etwas schief gelaufen!</strong>
                </h5>{' '}
                An error has occurred. Try it again!
            </Alert>
        ) : null;
    }
}
