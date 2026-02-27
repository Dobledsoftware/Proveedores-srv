package dobledsoftware.proveedores.controllers;

import dobledsoftware.proveedores.features.ordenespago.data.OrdenPagoDto;
import dobledsoftware.proveedores.features.ordenespago.services.OrdenPagoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ordenes-pago")
@Tag(name = "Ordenes de Pago", description = "API para la gestión de órdenes de pago")
public class OrdenPagoController {

    private final OrdenPagoService ordenPagoService;

    @Autowired
    public OrdenPagoController(OrdenPagoService ordenPagoService) {
        this.ordenPagoService = ordenPagoService;
    }

    @Operation(summary = "Obtener todas las órdenes de pago", description = "Retorna una lista de todas las órdenes de pago registradas")
    @ApiResponse(responseCode = "200", description = "Operación exitosa", content = @Content(mediaType = "application/json", schema = @Schema(implementation = OrdenPagoDto.class)))
    @GetMapping
    public ResponseEntity<List<OrdenPagoDto>> getAll() {
        return ResponseEntity.ok(ordenPagoService.getAll());
    }

    @Operation(summary = "Obtener orden de pago por ID", description = "Retorna una orden de pago específica basada en su ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Orden encontrada", content = @Content(mediaType = "application/json", schema = @Schema(implementation = OrdenPagoDto.class))),
            @ApiResponse(responseCode = "404", description = "Orden no encontrada", content = @Content)
    })
    @GetMapping("/{id}")
    public ResponseEntity<OrdenPagoDto> getById(@Parameter(description = "ID de la orden de pago a buscar") @PathVariable Integer id) {
        return ordenPagoService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Crear nueva orden de pago", description = "Crea una nueva orden de pago y la guarda en la base de datos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Orden creada exitosamente", content = @Content(mediaType = "application/json", schema = @Schema(implementation = OrdenPagoDto.class))),
            @ApiResponse(responseCode = "400", description = "Datos inválidos o proveedor no encontrado", content = @Content)
    })
    @PostMapping
    public ResponseEntity<OrdenPagoDto> create(@RequestBody OrdenPagoDto dto) {
        OrdenPagoDto created = ordenPagoService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @Operation(summary = "Actualizar orden de pago", description = "Actualiza los datos de una orden de pago existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Orden actualizada exitosamente", content = @Content(mediaType = "application/json", schema = @Schema(implementation = OrdenPagoDto.class))),
            @ApiResponse(responseCode = "404", description = "Orden no encontrada", content = @Content)
    })
    @PutMapping("/{id}")
    public ResponseEntity<OrdenPagoDto> update(@Parameter(description = "ID de la orden de pago a actualizar") @PathVariable Integer id, @RequestBody OrdenPagoDto dto) {
        try {
            OrdenPagoDto updated = ordenPagoService.update(id, dto);
            return ResponseEntity.ok(updated);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Eliminar orden de pago", description = "Elimina una orden de pago del sistema")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Orden eliminada exitosamente"),
            @ApiResponse(responseCode = "404", description = "Orden no encontrada", content = @Content)
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@Parameter(description = "ID de la orden de pago a eliminar") @PathVariable Integer id) {
        try {
            ordenPagoService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
