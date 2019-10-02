import React from 'react';
import { ListGroup, ListGroupItem } from 'react-bootstrap';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faMinusCircle } from '@fortawesome/free-solid-svg-icons';
import Warning from './warning';
import RequestError from './requestError';
import './editItem.css';

export default class EditItem extends React.Component {
    constructor(props, context) {
        super(props, context);
    }

    render() {
        const listItems = this.props.items.map(item => (
            <ListGroupItem key={item.id} className="wrap-list">
                <span className="float left">{item.description}</span>
                <FontAwesomeIcon
                    className="delete-button float float-right"
                    icon={faMinusCircle}
                    onClick={() => {
                        this.props.onClick(item.id);
                    }}
                />
            </ListGroupItem>
        ));

        return this.props.errorOnRequest === false ? (
            <div className="list">
                <Warning items={this.props.items} />
                <ListGroup>{listItems}</ListGroup>
            </div>
        ) : (
            <RequestError errorOnRequest={this.props.errorOnRequest} />
        );
    }
}
