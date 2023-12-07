package ge.gela.coordinate_full.controllers;

import ge.gela.coordinate_full.entities.VehicleLocation;
import ge.gela.coordinate_full.repositories.VehicleLocationRepository;
import ge.gela.coordinate_full.services.VehicleLocationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor

public class VehicleLocationController {
    public final VehicleLocationRepository vehicleLocationRepository;
    public final VehicleLocationService vehicleLocationService;
    @GetMapping("vehicleLoc/{vehId}")
    public List<VehicleLocation> search(@PathVariable Integer vehId){
        return vehicleLocationService.findAllByVehId(vehId);
    }
}
