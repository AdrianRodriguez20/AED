import axios from 'axios';
import { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';
import { useNavigate } from 'react-router-dom';
import { Mesa } from '../../interfaces/Mesa';


export default function CrearDetalleFactura() {

    return (
        <>
            <section className="book_section layout_padding">
                <div className="container">
                    <div className="heading_container heading_center">
                        <h2>
                            Crear Detalle Factura
                        </h2>
                    </div>
                </div>
            </section>

        </>
    )
}
