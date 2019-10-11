import React from "react";

const ListHeaders = props => {
    return (
        <li className="list-group-item">
            <div className="row">
                <div className="col-2">Hinzugefügt am</div>
                <div className="col">Wird benötigt:</div>
                <div className="col-2 text-right">Änderung</div>
                <div className="col-2" />
            </div>
        </li>
    );
};
export default ListHeaders;
