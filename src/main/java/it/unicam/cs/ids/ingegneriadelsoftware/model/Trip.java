package it.unicam.cs.ids.ingegneriadelsoftware.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Set;

@Entity
@Table(name = "TRIP")
@Getter
@Setter
@NoArgsConstructor
public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Long id;

    @Column
    @NotEmpty
    @PositiveOrZero
    @Max(value = 100)
    @NotNull
    private int minimumNumberOfPeople;

    @Column
    @NotEmpty
    @PositiveOrZero
    @Max(value = 100)
    @NotNull
    private int maximumNumberOfPeople;

    @Column
    @NotEmpty
    @PositiveOrZero
    @NotNull
    private double cost;

    @Column
    @NotEmpty
    @PositiveOrZero
    @NotNull
    private int currentNumberOfReservations;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "TRIP_STAGES",
            joinColumns = @JoinColumn(name = "TRIP_ID"),
            inverseJoinColumns = @JoinColumn(name = "STAGE_ID"))
    private Set<Stage> tripStages;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "TRIP_GUIDES",
            joinColumns = @JoinColumn(name = "TRIP_ID"),
            inverseJoinColumns = @JoinColumn(name = "USER_ID"))
    private Set<User> tripGuides;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "TRIP_PARTICIPANTS",
            joinColumns = @JoinColumn(name = "TRIP_ID"),
            inverseJoinColumns = @JoinColumn(name = "USER_ID"))
    private Set<User> tripParticipants;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trip trip = (Trip) o;
        if (minimumNumberOfPeople != trip.minimumNumberOfPeople) return false;
        if (maximumNumberOfPeople != trip.maximumNumberOfPeople) return false;
        if (Double.compare(trip.cost, cost) != 0) return false;
        if (currentNumberOfReservations != trip.currentNumberOfReservations) return false;
        return id.equals(trip.id);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id.hashCode();
        result = 31 * result + minimumNumberOfPeople;
        result = 31 * result + maximumNumberOfPeople;
        temp = Double.doubleToLongBits(cost);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + currentNumberOfReservations;
        return result;
    }
}
