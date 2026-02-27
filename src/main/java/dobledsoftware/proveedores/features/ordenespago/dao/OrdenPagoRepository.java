package dobledsoftware.proveedores.features.ordenespago.dao;

import dobledsoftware.proveedores.features.ordenespago.entities.OrdenPagoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdenPagoRepository extends JpaRepository<OrdenPagoEntity, Integer> {
    List<OrdenPagoEntity> findByProveedorId(Long proveedorId);
    boolean existsByNroOperacion(String nroOperacion);
}
