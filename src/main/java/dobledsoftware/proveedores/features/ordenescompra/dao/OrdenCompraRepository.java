package dobledsoftware.proveedores.features.ordenescompra.dao;

import dobledsoftware.proveedores.features.ordenescompra.entities.OrdenCompraEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdenCompraRepository extends JpaRepository<OrdenCompraEntity, Integer> {
    List<OrdenCompraEntity> findByProveedorId(Long proveedorId);
    boolean existsByNroOrdenCompra(String nroOrdenCompra);
}
