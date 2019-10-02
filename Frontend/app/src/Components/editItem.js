import React from 'react';
import {List} from 'antd';
import {FontAwesomeIcon} from '@fortawesome/react-fontawesome';
import {faMinusCircle} from '@fortawesome/free-solid-svg-icons';
import Warning from './warning';
import RequestError from './requestError';
import './editItem.css';

class EditItem extends React.Component {
    state = {};


    render() {
        const listItems = this.props.items.map(item => (
            <List.Item key={item.id} className="wrap-list">
                <span className="float left">{item.description}</span>
                <FontAwesomeIcon
                    className="delete-button float float-right"
                    icon={faMinusCircle}
                    onClick={() => {
                        this.props.onClick(item.id);
                    }}
                />
            </List.Item>
        ));

        return this.props.errorOnRequest === false ? (
            <div className="list">
                <Warning items={this.props.items}/>
                <List>{listItems}</List>
            </div>
        ) : (
            <RequestError errorOnRequest={this.props.errorOnRequest}/>
        );
    }
}

export default EditItem;
