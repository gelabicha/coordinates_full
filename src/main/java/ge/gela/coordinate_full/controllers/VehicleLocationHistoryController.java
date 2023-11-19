package ge.gela.coordinate_full.controllers;

import ge.gela.coordinate_full.models.HistoryCreateModel;
import ge.gela.coordinate_full.repositories.VehicleLocationHistoryRepository;
import ge.gela.coordinate_full.services.VehicleLocationHistoryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class VehicleLocationHistoryController {
    public final VehicleLocationHistoryRepository vehicleLocationHistoryRepository;
    private final VehicleLocationHistoryService vehicleLocationHistoryService;

       }


