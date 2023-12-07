package ge.gela.coordinate_full.repositories;

import ge.gela.coordinate_full.entities.VehicleLocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface VehicleLocationRepository extends JpaRepository<VehicleLocation,Integer> {
    List<VehicleLocation> findAllByVehId(Integer vehId);
}
