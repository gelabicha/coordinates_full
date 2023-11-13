package ge.gela.coordinate_full.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(schema = "public", name = "vehicle_location")
public class VehicleLocation {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="VehiclesLocation_seq_generation")
    @SequenceGenerator(name="VehiclesLocation_seq_generation", sequenceName="vehicle_location_id_seq", allocationSize = 1)
    private Integer id;

    @Column(name = "veh_id")
    private Integer vehId;

    @Column(name = "latitude")
    private Double latitude;

    @Column(name = "longitude")
    private Double longitude;
}
