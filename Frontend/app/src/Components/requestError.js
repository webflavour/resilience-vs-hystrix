import React from 'react';
import { Alert } from 'antd';


class RequestError extends React.Component {
    state = {

    };

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

export default RequestError;