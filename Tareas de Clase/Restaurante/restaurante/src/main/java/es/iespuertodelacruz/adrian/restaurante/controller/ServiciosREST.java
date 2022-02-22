package es.iespuertodelacruz.adrian.restaurante.controller;


import es.iespuertodelacruz.adrian.restaurante.dto.detallefactura.DetalleFacturaPostDTO;
import es.iespuertodelacruz.adrian.restaurante.dto.servicios.ListadoServiciosDTO;

import es.iespuertodelacruz.adrian.restaurante.dto.servicios.ServicioDTO;
import es.iespuertodelacruz.adrian.restaurante.dto.servicios.ServicioDetallesDTO;
import es.iespuertodelacruz.adrian.restaurante.entity.Detallefactura;
import es.iespuertodelacruz.adrian.restaurante.entity.Plato;
import es.iespuertodelacruz.adrian.restaurante.entity.Servicio;
import es.iespuertodelacruz.adrian.restaurante.service.DetallefacturaService;
import es.iespuertodelacruz.adrian.restaurante.service.MesaService;
import es.iespuertodelacruz.adrian.restaurante.service.PlatoService;
import es.iespuertodelacruz.adrian.restaurante.service.ServicioService;
import es.iespuertodelacruz.adrian.restaurante.utils.ApiError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v2/servicios")
public class ServiciosREST {

    @Autowired
    ServicioService servicioService;
    @Autowired
    PlatoService platoService;
    @Autowired
    DetallefacturaService detallefacturaService;
    @Autowired
    MesaService mesaService;

    @GetMapping
    public ArrayList<ListadoServiciosDTO> getAll() {
        ArrayList<ListadoServiciosDTO> listadoServiciosDTOS = new ArrayList<ListadoServiciosDTO>();
        servicioService.findAll().forEach(p -> {
            Servicio s = (Servicio) p;
            ListadoServiciosDTO sDTO = new ListadoServiciosDTO(s);
            listadoServiciosDTOS.add(sDTO);
        });
        return listadoServiciosDTOS;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Integer id) {
        Optional<Servicio> optS = servicioService.findById(id);
        if (optS.isPresent()) {
            ServicioDetallesDTO sDTO = new ServicioDetallesDTO(optS.get());
            return ResponseEntity.ok().body(sDTO);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiError(HttpStatus.BAD_REQUEST, "El id de servicio no se encuentra"));
        }

    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody ServicioDTO sDTO) {

        if (mesaService.findById(sDTO.getNummesa()).isPresent()) {
            Servicio optS = servicioService.save(sDTO.toEntity());
            if (optS != null) {
                sDTO.setIdservicio(optS.getIdservicio());
                return ResponseEntity.ok().body(sDTO);
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiError(HttpStatus.BAD_REQUEST, "Error al guardar el servicio"));
            }
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiError(HttpStatus.BAD_REQUEST, "El id de mesa no se encuentra"));
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Integer id, @RequestBody ServicioDTO sDTO) {
        Optional<Servicio> optS = servicioService.findById(id);
        if (optS.isPresent()) {
            if (mesaService.findById(sDTO.getNummesa()).isPresent()) {
                sDTO.setIdservicio(id);
                Servicio servicio = servicioService.save(sDTO.toEntity());
                if (servicio != null) {
                    return ResponseEntity.ok().body(sDTO);
                } else {
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiError(HttpStatus.BAD_REQUEST, "Error al actualizar el servicio"));
                }
            }else{
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiError(HttpStatus.BAD_REQUEST, "El id de mesa no se encuentra"));
            }


        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiError(HttpStatus.BAD_REQUEST, "El id de servicio no se encuentra"));
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
        Optional<Servicio> optS = servicioService.findById(id);
        if (optS.isPresent()) {
            if (optS.get().getDetallefacturas().size() > 0) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                        new ApiError(HttpStatus.BAD_REQUEST, "No se puede eliminar , esta mesa está asociada a una factura."));
            }else{
                servicioService.delete(optS.get());
                return ResponseEntity.ok().body(new ApiError(HttpStatus.OK, "Servicio eliminado"));
            }
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiError(HttpStatus.BAD_REQUEST, "El id de servicio no se encuentra"));
        }

    }

    @PostMapping("/{id}/platos")
    public ResponseEntity<?> save(@PathVariable("id") Integer id, @RequestBody List<DetalleFacturaPostDTO> dsDTO) {
        Optional<Servicio> optS = servicioService.findById(id);

        if (optS.isPresent()) {

            List<DetalleFacturaPostDTO> listaValidada = new ArrayList<>();
            for (DetalleFacturaPostDTO dDTO : dsDTO) {
                if (platoService.findById(dDTO.getIdplato()).isPresent() && platoService.findById(dDTO.getIdplato()).get().getDisponible()) {
                    Plato plato = platoService.findById(dDTO.getIdplato()).get();
                    DetalleFacturaPostDTO platoValidado = new DetalleFacturaPostDTO();
                    platoValidado.setIdplato(plato.getIdplato());
                    platoValidado.setCantidad(dDTO.getCantidad());
                    platoValidado.setPreciounidad(plato.getPreciounidad());
                    platoValidado.setIdservicio(id);
                    listaValidada.add(platoValidado);
                }
            }
            if (listaValidada.size() == dsDTO.size()) {
                Servicio servicio = optS.get();

                List<Detallefactura> detallefacturas = servicio.getDetallefacturas();
                for (DetalleFacturaPostDTO dDTO : listaValidada) {
                    Optional<Detallefactura> optD = detallefacturas.stream().filter(d -> d.getPlato().getIdplato() == dDTO.getIdplato()).findFirst();
                    if (optD.isPresent()) {
                        detallefacturas.forEach(p -> {
                            Detallefactura detalleFactura = (Detallefactura) p;
                            if (detalleFactura.getPlato().getIdplato() == dDTO.getIdplato()) {
                                detalleFactura.setCantidad(detalleFactura.getCantidad() + dDTO.getCantidad());
                                detallefacturaService.save(detalleFactura);

                            }
                        });
                    }else{
                        detallefacturaService.save(dDTO.toEntity());

                    }

                }
               return ResponseEntity.ok().body("todo ok");

            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiError(HttpStatus.BAD_REQUEST, "Error al guardar el detalle de factura"));
            }
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiError(HttpStatus.BAD_REQUEST, "El id de servicio no se encuentra"));
        }

    }


    @PutMapping("/{id}/platos/{idplato}")
    public ResponseEntity <?> update (@PathVariable("id") Integer id, @PathVariable("idplato") Integer idplato, @RequestBody DetalleFacturaPostDTO dDTO){
        Optional<Servicio> optS = servicioService.findById(id);
        if (optS.isPresent()) {
            Detallefactura detallefactura = detallefacturaService.findByPlato(idplato, id);
            if (detallefactura != null) {
                detallefactura.setCantidad(dDTO.getCantidad());
                detallefacturaService.save(detallefactura);
                return ResponseEntity.ok().body("");
            }else{
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiError(HttpStatus.BAD_REQUEST, "El plato no se encuentra en esta factura"));
            }
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiError(HttpStatus.BAD_REQUEST, "El id de servicio no se encuentra"));
        }
    }

    @DeleteMapping("/{id}/platos/{idplato}")
    public ResponseEntity <?> delete (@PathVariable("id") Integer id, @PathVariable("idplato") Integer idplato){
        Optional<Servicio> optS = servicioService.findById(id);
        if (optS.isPresent()) {
            Detallefactura detallefactura = detallefacturaService.findByPlato(idplato, id);
            if (detallefactura != null) {
                detallefacturaService.delete(detallefactura);
                return ResponseEntity.ok().body("");
            }else{
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiError(HttpStatus.BAD_REQUEST, "El plato no se encuentra en el servicio"));
            }

        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiError(HttpStatus.BAD_REQUEST, "El id de servicio no se encuentra"));
        }

    }




}
