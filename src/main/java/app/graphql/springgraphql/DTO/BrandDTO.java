package app.graphql.springgraphql.DTO;

import app.graphql.springgraphql.Enums.Country;
import lombok.*;

/**
 * @author MJ Makki
 * @version 1.0
 * @license SkyLimits, LLC (<a href="https://www.skylimits.tech">SkyLimits, LLC</a>)
 * @email m.makki@skylimits.tech
 * @since long time ago
 */

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BrandDTO {
    private String brandName;
    private Country country;
}
