package ge.gela.coordinate_full.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(schema = "public", name = "vehicle_location_history")
public class VehicleLocationHistory {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="vehicle_location_history_seq_generation")
    @SequenceGenerator(name="vehicle_location_history_seq_generation", sequenceName="vehicle_location_history_id_seq", allocationSize = 1)
    private Integer id;

    @Column(name = "veh_id")
    private Integer vehId;

    @Column(name = "latitude")
    private Double latitude;

    @Column(name = "longitude")
    private Double longitude;

    @Column(name = "intime")
    private LocalDateTime intime;
}
