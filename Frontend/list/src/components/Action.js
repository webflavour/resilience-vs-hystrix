import React from "react";
import { Button } from 'react-bootstrap';
const Action = props => {
    const { completeItem, removeItem, item } = props;
    const iconClass =
        "fa " + (item.done ? "fa-check green" : "fa-exclamation orange");

    return (
        <span>
      <Button
          variant="primary"
          class="btn btn-light"
          onClick={() => completeItem(item)}
          title="Complete Item"
      >
        <i className={iconClass} />
      </Button>
      <Button
          variant="danger"
          className="btn btn-light"
          title="Remove Item"
          onClick={() => removeItem(item)}
      >
        <i className="fa fa-trash red" />
      </Button>
    </span>
    );
};

export default Action;
