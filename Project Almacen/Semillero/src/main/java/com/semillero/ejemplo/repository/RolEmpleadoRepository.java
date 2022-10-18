package com.semillero.ejemplo.repository;
import com.semillero.ejemplo.entity.RolEmpleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface RolEmpleadoRepository extends JpaRepository<RolEmpleado, Long>{



}
