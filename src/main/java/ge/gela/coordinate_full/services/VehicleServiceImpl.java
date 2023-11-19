package ge.gela.coordinate_full.services;

import ge.gela.coordinate_full.entities.Vehicles;
import ge.gela.coordinate_full.models.VehiclesCreateModel;
import ge.gela.coordinate_full.repositories.VehiclesRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.hibernate.type.TrueFalseConverter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor

public class VehicleServiceImpl implements VehicleService {
    private final VehiclesRepository vehiclesRepository;

    @Override
    public Vehicles vehiclesCreateNew(VehiclesCreateModel vehiclesCreateModel) {
        Vehicles vehicles = new Vehicles();
        vehicles.setVehNum(vehiclesCreateModel.vehNum());
        vehicles.setDriver(vehiclesCreateModel.driver());
        vehicles.setVehType(vehiclesCreateModel.vehType());
        vehicles.setLength(vehiclesCreateModel.length());
        vehicles.setWidth(vehiclesCreateModel.width());
        vehicles.setHeught(vehiclesCreateModel.heught());
        vehicles.setGravity(vehiclesCreateModel.gravity());
        vehiclesRepository.save(vehicles);
        return vehicles;
    }

    @Override
    public List<Vehicles> search(String vehNum) {
        List<Vehicles> allByvehNum = vehiclesRepository.findAllByVehNum(vehNum);
        return allByvehNum;
       }

    @Override
    public List<Vehicles> search(Integer vehId) {
        List<Vehicles> allByvehId = vehiclesRepository.findAllByvehId(vehId);
        return allByvehId;
    }
}
