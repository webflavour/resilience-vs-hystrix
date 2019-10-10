import React from "react";

const AddItem = props => {
    const { addItem, newItem, setNewItem } = props;

    const keyUpHandler = event => {
        if (event.key === "Enter") addItem();
    };
    return (
        <input
            className="form-control"
            value={newItem}
            placeholder="Add New Task"
            onKeyUp={keyUpHandler}
            onChange={event => setNewItem(event.target.value)}
        />
    );
};

export default AddItem;
