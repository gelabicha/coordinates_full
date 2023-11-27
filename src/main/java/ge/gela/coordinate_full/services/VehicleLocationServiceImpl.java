package ge.gela.coordinate_full.services;

import ge.gela.coordinate_full.entities.VehicleLocation;
import ge.gela.coordinate_full.repositories.VehicleLocationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class VehicleLocationServiceImpl implements VehicleLocationService {
    public final VehicleLocationRepository vehicleLocationRepository;
    @Override
    public List<VehicleLocation> findAllByVehId(Integer vehId) {
        return vehicleLocationRepository.findALLbyVehId(vehId);
    }

    @Override
    public void vehicleLocationAdd(Double latitude1, Double longitude1, vehId4) {
        VehicleLocation vehicleLocation = new VehicleLocation();
        vehicleLocation.setLatitude(latitude1);
        vehicleLocation.setLongitude(longitude1);
        vehicleLocation.setVehId(vehId4);

        vehicleLocationRepository.save(vehicleLocation);
         }
}
