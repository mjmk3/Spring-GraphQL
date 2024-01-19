package app.graphql.springgraphql.Resource;

import app.graphql.springgraphql.DTO.BrandDTO;
import app.graphql.springgraphql.DTO.ModelDTO;
import app.graphql.springgraphql.Domain.Brand;
import app.graphql.springgraphql.Domain.Model;
import app.graphql.springgraphql.Service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.*;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * @author MJ Makki
 * @version 1.0
 * @license SkyLimits, LLC (<a href="https://www.skylimits.tech">SkyLimits, LLC</a>)
 * @email m.makki@skylimits.tech
 * @since long time ago
 */

@Controller
public class BrandResource {

    private BrandService brandService;

    @Autowired
    public BrandResource(BrandService brandService) {
        this.brandService = brandService;
    }

    @QueryMapping
    public List<Brand> findAllBrands(){
        return brandService.findAllBrands();
    }

    @QueryMapping
    public Brand findOneBrand(@Argument int id){
        return brandService.findOneBrand(id);
    }

    @MutationMapping
    public Brand saveBrand(@Argument BrandDTO dto){
        return brandService.saveBrand(dto);
    }

    @MutationMapping
    public Brand updateBrand(@Argument int id, @Argument BrandDTO dto){
        return brandService.updateBrand(id,dto);
    }

    @MutationMapping
    public Brand deleteBrand(@Argument int id){
        return brandService.deleteBrand(id);
    }

    // MODEL

    @QueryMapping
    public List<Model> findAllModels(){
        return brandService.findAllModels();
    }

    @QueryMapping
    public Model findOneModel(@Argument int id){
        return brandService.findOneModel(id);
    }

    @MutationMapping
    public Model saveModel(@Argument ModelDTO dto){
        return brandService.saveModel(dto);
    }

    @MutationMapping
    public Model updateModel(@Argument int id, @Argument String name){
        return brandService.updateModel(id, name);
    }

    @MutationMapping
    public Model deleteModel(@Argument int id){
        return brandService.deleteModel(id);
    }
}
