package ge.gela.coordinate_full.controllers;

import ge.gela.coordinate_full.repositories.VehicleLocationHistoryRepository;
import ge.gela.coordinate_full.repositories.VehicleLocationRepository;
import ge.gela.coordinate_full.repositories.VehiclesRepository;
import ge.gela.coordinate_full.services.VehicleLocationHistoryService;
import ge.gela.coordinate_full.services.VehicleService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("newvehicle")
public class NewVehicleRequestController {
    private final VehiclesRepository vehiclesRepository;
    private final VehicleService vehicleService;
    private final VehicleLocationRepository vehicleLocationRepository;
    private final VehicleLocationHistoryRepository vehicleLocationHistoryRepository;
    private final VehicleLocationHistoryService vehicleLocationHistoryService;
    @GetMapping("vehicle")
    public void NewVehicle(@RequestBody Double latitude1, Double longitude1, String carNum1){
        var carNum = vehiclesRepository.findAllByVehNum(carNum1);
        if(!carNum.isEmpty()){
            var carId2 = carNum.get(0).getVehId();
            var vehId1 = vehicleLocationRepository.findALLbyVehId(carId2);
            if(!vehId1.isEmpty()){
                var vehId3 = vehId1.get(0);
                vehId3.setLatitude(latitude1);
                vehId3.setLongitude(longitude1);
                vehicleLocationRepository.saveAll(vehId3);

                vehicleLocationHistoryService.vehicleHistoryCreateNew(latitude1,longitude1,vehId1);
            }else {
                ResponseEntity.notFound();
            }
        }else
        {ResponseEntity.notFound();}
        }

}
