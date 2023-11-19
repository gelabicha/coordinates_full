package ge.gela.coordinate_full.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(schema = "public", name = "vehicles")
public class Vehicles {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="vehicles_seq_generation")
    @SequenceGenerator(name="vehicles_seq_generation", sequenceName="vehicles_veh_id_seq", allocationSize = 1)
    private Integer vehId;

    @Column(name = "veh_num")
    private String vehNum;

    @Column(name = "driver")
    private String driver;

    @Column(name = "veh_type")
    private String vehType;

    @Column(name = "length")
    private Double length;

    @Column(name = "width")
    private Double width;

    @Column(name = "heught")
    private Double heught;

    @Column(name = "gravity")
    private Double gravity;

    @Column(name = "status")
    private Boolean status;
}
