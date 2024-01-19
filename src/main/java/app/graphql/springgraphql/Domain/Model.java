package app.graphql.springgraphql.Domain;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

/**
 * @author MJ Makki
 * @version 1.0
 * @license SkyLimits, LLC (<a href="https://www.skylimits.tech">SkyLimits, LLC</a>)
 * @email m.makki@skylimits.tech
 * @since long time ago
 */

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Model implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int modelName;

    @ManyToOne(cascade = CascadeType.ALL)
    private Brand brand;
}


