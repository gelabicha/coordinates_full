package ge.gela.coordinate_full.services;

import ge.gela.coordinate_full.entities.Vehicles;
import ge.gela.coordinate_full.models.VehiclesCreateModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VehicleService {

    Vehicles vehiclesCreateNew(VehiclesCreateModel vehiclesCreateModel);

    List<Vehicles> search(String vehNum);

    List<Vehicles> search(Integer vehId);
}
