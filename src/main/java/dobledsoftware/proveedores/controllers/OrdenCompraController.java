package dobledsoftware.proveedores.controllers;

import dobledsoftware.proveedores.features.ordenescompra.data.OrdenCompraDto;
import dobledsoftware.proveedores.features.ordenescompra.services.OrdenCompraService;
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
@RequestMapping("/api/ordenes-compra")
@Tag(name = "Ordenes de Compra", description = "API para la gestión de órdenes de compra")
public class OrdenCompraController {

    private final OrdenCompraService ordenCompraService;

    @Autowired
    public OrdenCompraController(OrdenCompraService ordenCompraService) {
        this.ordenCompraService = ordenCompraService;
    }

    @Operation(summary = "Obtener todas las órdenes de compra", description = "Retorna una lista de todas las órdenes de compra registradas")
    @ApiResponse(responseCode = "200", description = "Operación exitosa", content = @Content(mediaType = "application/json", schema = @Schema(implementation = OrdenCompraDto.class)))
    @GetMapping
    public ResponseEntity<List<OrdenCompraDto>> getAll() {
        return ResponseEntity.ok(ordenCompraService.getAll());
    }

    @Operation(summary = "Obtener orden de compra por ID", description = "Retorna una orden de compra específica basada en su ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Orden encontrada", content = @Content(mediaType = "application/json", schema = @Schema(implementation = OrdenCompraDto.class))),
            @ApiResponse(responseCode = "404", description = "Orden no encontrada", content = @Content)
    })
    @GetMapping("/{id}")
    public ResponseEntity<OrdenCompraDto> getById(@Parameter(description = "ID de la orden de compra a buscar") @PathVariable Integer id) {
        return ordenCompraService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Crear nueva orden de compra", description = "Crea una nueva orden de compra y la guarda en la base de datos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Orden creada exitosamente", content = @Content(mediaType = "application/json", schema = @Schema(implementation = OrdenCompraDto.class))),
            @ApiResponse(responseCode = "400", description = "Datos inválidos o proveedor no encontrado", content = @Content)
    })
    @PostMapping
    public ResponseEntity<OrdenCompraDto> create(@RequestBody OrdenCompraDto dto) {
        OrdenCompraDto created = ordenCompraService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @Operation(summary = "Actualizar orden de compra", description = "Actualiza los datos de una orden de compra existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Orden actualizada exitosamente", content = @Content(mediaType = "application/json", schema = @Schema(implementation = OrdenCompraDto.class))),
            @ApiResponse(responseCode = "404", description = "Orden no encontrada", content = @Content)
    })
    @PutMapping("/{id}")
    public ResponseEntity<OrdenCompraDto> update(@Parameter(description = "ID de la orden de compra a actualizar") @PathVariable Integer id, @RequestBody OrdenCompraDto dto) {
        try {
            OrdenCompraDto updated = ordenCompraService.update(id, dto);
            return ResponseEntity.ok(updated);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Eliminar orden de compra", description = "Elimina una orden de compra del sistema")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Orden eliminada exitosamente"),
            @ApiResponse(responseCode = "404", description = "Orden no encontrada", content = @Content)
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@Parameter(description = "ID de la orden de compra a eliminar") @PathVariable Integer id) {
        try {
            ordenCompraService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
