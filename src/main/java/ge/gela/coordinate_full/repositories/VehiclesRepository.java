package ge.gela.coordinate_full.repositories;

import ge.gela.coordinate_full.entities.Vehicles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehiclesRepository extends JpaRepository<Vehicles, Integer> {
}
