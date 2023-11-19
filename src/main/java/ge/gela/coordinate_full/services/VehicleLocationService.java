package ge.gela.coordinate_full.services;

import ge.gela.coordinate_full.entities.VehicleLocation;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VehicleLocationService {
    List<VehicleLocation> findAllByVehId(Integer vehId);
}
