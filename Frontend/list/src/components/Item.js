import React from "react";
import Action from "./Action";

const Item = props => {
    const { item,completeItem, removeItem } = props;

    return (
        <li className="list-group-item">
            <div className="row">
                <div className="col-2">{new Date(item.createdAt).toLocaleString()}</div>
                <div className="col">{item.description}</div>
                <div className="col-2 text-right">
                    {item.done ? new Date(item.updatedAt).toLocaleString() : ""}
                </div>
                <div className="col-2 text-right">
                    <Action
                        item={item}
                        completeItem={completeItem}
                        removeItem={removeItem}
                    />
                </div>
            </div>
        </li>
    );
};
export default Item;
