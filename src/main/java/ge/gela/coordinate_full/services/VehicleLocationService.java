package ge.gela.coordinate_full.services;

import ge.gela.coordinate_full.entities.VehicleLocation;
import ge.gela.coordinate_full.repositories.VehicleLocationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VehicleLocationService {

    List<VehicleLocation> findAllByVehId(Integer vehId);


    void vehicleLocationAdd(Double latitude1, Double longitude1,vehId4);
}
