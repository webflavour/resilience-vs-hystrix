import React from "react";

const Action = props => {
    const { completeItem, removeItem, item } = props;
    const iconClass =
        "fa " + (item.done ? "fa-check green" : "fa-exclamation orange");

    return (
        <span>
      <button
          class="btn btn-light"
          onClick={() => completeItem(item)}
          title="Complete Item"
      >
        <i className={iconClass} />
      </button>
      <button
          className="btn btn-light"
          title="Remove Item"
          onClick={() => removeItem(item)}
      >
        <i className="fa fa-trash red" />
      </button>
    </span>
    );
};

export default Action;
