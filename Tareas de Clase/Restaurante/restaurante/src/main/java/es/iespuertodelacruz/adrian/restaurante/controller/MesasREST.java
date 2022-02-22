package es.iespuertodelacruz.adrian.restaurante.controller;

import es.iespuertodelacruz.adrian.restaurante.dto.mesas.MesaDTO;
import es.iespuertodelacruz.adrian.restaurante.dto.mesas.MesaUpdateDTO;
import es.iespuertodelacruz.adrian.restaurante.dto.platos.PlatoDTO;
import es.iespuertodelacruz.adrian.restaurante.entity.Mesa;
import es.iespuertodelacruz.adrian.restaurante.entity.Plato;
import es.iespuertodelacruz.adrian.restaurante.service.MesaService;
import es.iespuertodelacruz.adrian.restaurante.utils.ApiError;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

@RestController
@RequestMapping("/api/v2/mesas")
@Api(value="API REST Mesas")
public class MesasREST {


    @Autowired
    MesaService mesaService;

    @GetMapping
    @ApiOperation(value="Retorna todas las mesas o las mesas disponibles.")
    public ArrayList<MesaDTO> getAll(
            @ApiParam( name="disponible",
                    value="Si es true, se retornan las mesas disponibles.", required=false)
            @RequestParam(required = false, name = "disponible") Boolean disponible,
            @ApiParam( name="fecha", value = "Fecha de la reserva.", required=false)
             @RequestParam(required = false, name = "fecha") Long fecha,
            @ApiParam( name="comensales", value = "Numero de personas que asistiran.", required=false)
                                     @RequestParam(required = false, name = "comensales") Integer comensales) {

        ArrayList<MesaDTO> mesas = new ArrayList<>();
        if (disponible == null) {
            mesaService.findAll().forEach(p -> {
                Mesa m = (Mesa) p;
                MesaDTO mDTO = new MesaDTO(m);
                mesas.add(mDTO);
            });
        } else if (disponible) {
            mesaService.findMesasDisponibles(fecha, new Date().getTime(), comensales).forEach(p -> {
                Mesa m = (Mesa) p;
                MesaDTO mDTO = new MesaDTO(m);
                mesas.add(mDTO);
            });
        }
        return mesas;
    }

    @GetMapping("/{id}")
    @ApiOperation(value="Retorna la mesa con el id indicado.")
    public ResponseEntity<?> getById(
            @ApiParam( name="id", value="Id de la mesa.", required=true)
            @PathVariable("id") int id) {
        Optional<Mesa> optP = mesaService.findById(id);
        if (optP.isPresent()) {
            Mesa m = optP.get();
            return ResponseEntity.ok().body(new MesaDTO(m));
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiError(HttpStatus.BAD_REQUEST, "La mesa no existe"));
        }
    }

    @PostMapping
    @ApiOperation(value="Crea una nueva mesa.")
    public ResponseEntity<?> save(
            @ApiParam( name="mesa", value="Mesa a crear.", required=true)
            @RequestBody Mesa m) {
        Optional<Mesa> optP = mesaService.findById(m.getNummesa());
        if (!optP.isPresent()) {
            MesaDTO mDTO = new MesaDTO(m);
            Mesa save = mesaService.save(mDTO.toMesa());
            if (save != null) {
                return ResponseEntity.ok().body(new MesaDTO(save));
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiError(HttpStatus.BAD_REQUEST, "No se ha podido guardar"));
            }
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiError(HttpStatus.BAD_REQUEST, "La mesa ya existe"));
        }
    }

    @PutMapping("/{id}")
    @ApiOperation(value="Actualiza la mesa con el id indicado.")
    public ResponseEntity<?> update (
            @ApiParam( name="id", value="Id de la mesa.", required=true)
            @PathVariable Integer id ,
            @ApiParam( name="mesa", value="Mesa a actualizar.", required=true)
            @RequestBody Mesa m ) {
        Optional<Mesa> optP = mesaService.findById(id);
        if (optP.isPresent()) {
            MesaUpdateDTO mDTO = new MesaUpdateDTO(m);
            mDTO.setNummesa(id);
            Mesa save = mesaService.save(mDTO.toEntity());
            if (save != null) {
                return ResponseEntity.ok().body(new MesaDTO(save));
            }else{
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiError(HttpStatus.BAD_REQUEST, "No se ha podido guardar"));
            }
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiError(HttpStatus.BAD_REQUEST, "La mesa no existe"));
        }

    }
}
