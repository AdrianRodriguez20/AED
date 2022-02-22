import axios from 'axios';
import { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';
import { useNavigate } from 'react-router-dom';
import { Mesa } from '../../interfaces/Mesa';


export default function UpdateDetalleFactura() {

    return (
        <>
            <section className="book_section layout_padding">
                <div className="container">
                    <div className="heading_container heading_center">
                        <h2>
                            Actualizar Plato Factura
                        </h2>
                    </div>
                </div>
            </section>

        </>
    )
}
