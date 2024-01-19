package app.graphql.springgraphql.DTO;

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
public class ModelDTO {
    private int brand_id;
    private String modelName;
}
