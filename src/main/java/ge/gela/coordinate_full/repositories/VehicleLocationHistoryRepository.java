package ge.gela.coordinate_full.repositories;

import ge.gela.coordinate_full.entities.VehicleLocationHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleLocationHistoryRepository extends JpaRepository<VehicleLocationHistory,Integer> {
}
