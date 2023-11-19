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
}
