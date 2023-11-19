package ge.gela.coordinate_full.controllers;

import ge.gela.coordinate_full.entities.Vehicles;
import ge.gela.coordinate_full.models.VehiclesCreateModel;
import ge.gela.coordinate_full.repositories.VehiclesRepository;
import ge.gela.coordinate_full.services.VehicleService;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor

public class VehicleController {
    private final VehicleService vehicleService;

    @PostMapping("vehicle")
    public Vehicles vehiclesCreateNew(@RequestBody VehiclesCreateModel vehiclesCreateModel){
        return vehicleService.vehiclesCreateNew(vehiclesCreateModel);
    }
    @GetMapping("vehicle")
    public List<Vehicles> search(@PathVariable String vehNum){
        return vehicleService.search(vehNum);
        }

    @GetMapping("vehicle")
    public List<Vehicles> search(@PathVariable Integer vehId){
        return vehicleService.search(vehId);
    }
}
