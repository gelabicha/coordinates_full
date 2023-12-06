package ge.gela.coordinate_full.services;

import ge.gela.coordinate_full.entities.VehicleLocation;
import ge.gela.coordinate_full.models.HistoryCreateModel;
import ge.gela.coordinate_full.repositories.VehicleLocationHistoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public interface VehicleLocationHistoryService {

    void vehicleHistoryCreateNew(Double latitude1, Double longitude1, Integer carId2);
}
