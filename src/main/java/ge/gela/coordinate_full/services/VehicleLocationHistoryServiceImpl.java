package ge.gela.coordinate_full.services;

import ge.gela.coordinate_full.entities.VehicleLocation;
import ge.gela.coordinate_full.entities.VehicleLocationHistory;
import ge.gela.coordinate_full.models.HistoryCreateModel;
import ge.gela.coordinate_full.repositories.VehicleLocationHistoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor

public class VehicleLocationHistoryServiceImpl implements VehicleLocationHistoryService {
    private final VehicleLocationHistoryRepository vehicleLocationHistoryRepository;
       @Override
    public void vehicleHistoryCreateNew(Double latitude1, Double longitude1, List<VehicleLocation> vehId1) {
        VehicleLocationHistory vehicleLocationHistory= new VehicleLocationHistory();
        VehicleLocation carId3 = vehId1.get(0);
        vehicleLocationHistory.setLatitude(latitude1);
        vehicleLocationHistory.setLongitude(longitude1);
        vehicleLocationHistory.setVehId(carId3.getId());
        vehicleLocationHistory.setIntime(LocalDateTime.now());
        vehicleLocationHistoryRepository.save(vehicleLocationHistory);

    }
}
