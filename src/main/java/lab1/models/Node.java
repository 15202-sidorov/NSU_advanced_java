package lab1.models;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@EqualsAndHashCode(callSuper=false)
@Table(name = "Nodes")
@Entity
public class Node extends OSMObject {
    @Column
    private double latitude;

    @Column
    private double longtitude;
}
