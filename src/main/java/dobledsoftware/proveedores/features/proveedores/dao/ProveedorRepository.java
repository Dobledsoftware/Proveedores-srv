package dobledsoftware.proveedores.features.proveedores.dao;

import dobledsoftware.proveedores.features.proveedores.entities.ProveedorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProveedorRepository extends JpaRepository<ProveedorEntity, Long> {
    List<ProveedorEntity> findByNameContainingIgnoreCase(String name);
    boolean existsByEmail(String email);
}
