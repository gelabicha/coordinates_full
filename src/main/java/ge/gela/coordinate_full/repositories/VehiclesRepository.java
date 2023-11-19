package ge.gela.coordinate_full.repositories;

import ge.gela.coordinate_full.entities.Vehicles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehiclesRepository extends JpaRepository<Vehicles, Integer> {
    List<Vehicles> findAllByVehNum(String vehNum);
    List<Vehicles> findAllByvehId(Integer vehId);

}
