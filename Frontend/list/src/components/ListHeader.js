import React from "react";

const ListHeaders = props => {
    return (
        <li className="list-group-item">
            <div className="row">
                <div className="col-2">Aufgeschrieben am</div>
                <div className="col">Wird benötigt:</div>
                <div className="col-2 text-right">Im Einkaufswagen hinterlegt</div>
                <div className="col-2" />
            </div>
        </li>
    );
};
export default ListHeaders;
