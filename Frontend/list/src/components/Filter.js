import React from "react";

const Filter = props => {
    const { filter, setFilter } = props;
    return (
        <select
            className="custom-select"
            value={filter}
            onChange={event => setFilter(event.target.value)}
        >
            <option value="all">Alle</option>
            <option value="done">Im Einkaufswagen</option>
            <option value="pending">Noch einzukaufen</option>
        </select>
    );
};
export default Filter;
