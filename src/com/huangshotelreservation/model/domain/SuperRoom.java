package com.huangshotelreservation.model.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * This class is introduced just to demonstrate how to persist and map in
 * Hibernate, domain objects that are associated via a 'IsA' relationship.
 *
 * @author Zhijie huang
 * 
 */
@Entity
@Table(name = "rooms")
@DiscriminatorColumn(name="discriminator")
@DiscriminatorValue("S")
public class SuperRoom implements Serializable {

    /**
     * Car ID
     */
    private Integer roomId;

    /**
     * Indicates country of origin of engine
     */
    String bedType;

    public SuperRoom() {
        super();
        // TODO Auto-generated constructor stub
    }

    public SuperRoom(String bedType) {
        super();
        this.bedType = bedType;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "idROOM", unique = true, nullable = false)
    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    @Column(name = "bed_type", length = 20)
    public String getBedType() {
        return bedType;
    }

    public void setBedType(String bedType) {
        this.bedType = bedType;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\t\n\nSuperRoom[");
        stringBuilder.append("\t\t\nroomId = ").append(roomId);
        stringBuilder.append("\t\t\nbedType = ").append(bedType);
        stringBuilder.append("]\n");
        return stringBuilder.toString();
    }

}
