package ge.gela.coordinate_full.controllers;

import ge.gela.coordinate_full.entities.VehicleLocation;
import ge.gela.coordinate_full.repositories.VehicleLocationRepository;
import ge.gela.coordinate_full.repositories.VehiclesRepository;
import ge.gela.coordinate_full.services.ExcelService;
import ge.gela.coordinate_full.services.ExcelServiceImpl;
import ge.gela.coordinate_full.services.VehicleService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@AllArgsConstructor

@ResponseBody
@RequestMapping("/file")
public class ReadExcelController {
    private final ExcelService excelService;
          @PostMapping("/updload")
    public ResponseEntity<?> uploadExcelFile(@RequestParam("file")MultipartFile file){
        if(file.isEmpty()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("select an Excel file to upload");
                    }
        try {
            List<VehicleLocation> ExcelList = excelService.readExcelFile(file.getInputStream());
            excelService.saveDataToDatabase(ExcelList);
            return ResponseEntity.status(HttpStatus.OK).body("File upload and data saved to the database");
        } catch (IOException e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while processing the file");
        }
    }

}
