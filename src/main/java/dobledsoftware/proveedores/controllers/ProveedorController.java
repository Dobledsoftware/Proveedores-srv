package dobledsoftware.proveedores.controllers;

import dobledsoftware.proveedores.features.proveedores.data.ProveedorDto;
import dobledsoftware.proveedores.features.proveedores.services.ProveedorServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

@RestController
@RequestMapping("/providers")
public class ProveedorController {

    private final ProveedorServiceImpl providerService;
    private final ResourceBundle messages;

    public ProveedorController(ProveedorServiceImpl providerService) {
        this.providerService = providerService;
        this.messages = ResourceBundle.getBundle("messages_en");
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> createProvider(@RequestBody ProveedorDto providerDto) {
        try {
            ProveedorDto createdProvider = providerService.createProvider(providerDto);
            Map<String, Object> response = new HashMap<>();
            response.put("message", messages.getString("provider.create.success"));
            response.put("provider", createdProvider);
            return ResponseEntity.ok(response);
        } catch (IllegalArgumentException e) {
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("error", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProveedorDto> updateProvider(@PathVariable Long id, @RequestBody ProveedorDto providerDto) {
        providerDto.setId(id);
        return ResponseEntity.ok(providerService.createProvider(providerDto));
    }

    @GetMapping
    public ResponseEntity<List<ProveedorDto>> listProviders() {
        return ResponseEntity.ok(providerService.listProviders());
    }

    @GetMapping("/search")
    public ResponseEntity<List<ProveedorDto>> searchByName(@RequestParam String name) {
        return ResponseEntity.ok(providerService.searchByName(name));
    }
}
