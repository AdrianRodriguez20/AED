import React from "react";
import PracticarTabla from "./PracticarTabla";
;

const TodasLasTablas = (props) => {
    let tablas = [2, 3, 4, 5, 6, 7, 8, 9, 10]
    return (
        <>
            {
                tablas.map((numero) => {
                    return (
                        <>
                            <PracticarTabla tabla={numero} />
                        </>
                    );
                })
        }
        </>
    );


}
export default TodasLasTablas;