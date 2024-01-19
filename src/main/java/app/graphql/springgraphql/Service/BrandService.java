package app.graphql.springgraphql.Service;

import app.graphql.springgraphql.DTO.BrandDTO;
import app.graphql.springgraphql.DTO.ModelDTO;
import app.graphql.springgraphql.Domain.Brand;
import app.graphql.springgraphql.Domain.Model;
import app.graphql.springgraphql.Enums.Country;
import app.graphql.springgraphql.Repo.BrandRepo;
import app.graphql.springgraphql.Repo.ModelRepo;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author MJ Makki
 * @version 1.0
 * @license SkyLimits, LLC (<a href="https://www.skylimits.tech">SkyLimits, LLC</a>)
 * @email m.makki@skylimits.tech
 * @since long time ago
 */

@Service
@Transactional
public class BrandService {

    private BrandRepo brandRepo;
    private ModelRepo modelRepo;

    @Autowired
    public BrandService(BrandRepo brandRepo, ModelRepo modelRepo) {
        this.brandRepo = brandRepo;
        this.modelRepo = modelRepo;
    }

    public List<Brand> findAllBrands(){
        return brandRepo.findAll();
    }

    public Brand findOneBrand(int id){
        return brandRepo.findById(id)
                .orElseThrow(()->new RuntimeException("id not exists"));
    }

    public Brand saveBrand(BrandDTO dto){
        Brand brand = Brand.builder().brandName(dto.getBrandName()).country(dto.getCountry()).build();
        return brandRepo.save(brand);
    }

    public Brand updateBrand(int id, BrandDTO dto){
        Brand brand = brandRepo.findById(id)
                .orElseThrow(()->new RuntimeException("id not exists"));
        brand.setBrandName(dto.getBrandName());
        brand.setCountry(dto.getCountry());
        return brandRepo.save(brand);
    }

    public Brand deleteBrand(int id){
        Brand brand = brandRepo.findById(id)
                .orElseThrow(()->new RuntimeException("id not exists"));
        brandRepo.delete(brand);
        return brand;
    }

    // MODEL

    public List<Model> findAllModels(){
        return modelRepo.findAll();
    }

    public Model findOneModel(int id){
        return modelRepo.findById(id)
                .orElseThrow(()->new RuntimeException("id not exists"));
    }

    public Model saveModel(ModelDTO dto){
        Brand brand = brandRepo.findById(dto.getBrand_id())
                .orElseThrow(()->new RuntimeException("id not exists"));
        return modelRepo.save(Model.builder().modelName(dto.getModelName()).brand(brand).build());
    }

    public Model updateModel(int id, String modelName){
        Model model = modelRepo.findById(id)
                .orElseThrow(()->new RuntimeException("id not exists"));
        model.setModelName(modelName);
        return modelRepo.save(model);
    }

    public Model deleteModel(int id){
        Model model = modelRepo.findById(id)
                .orElseThrow(()->new RuntimeException("id not exists"));
        modelRepo.delete(model);
        return model;
    }


    @PostConstruct
    private void loadData(){
        saveBrand(new BrandDTO("Mercedes", Country.GER));
        saveBrand(new BrandDTO("BMW", Country.GER));
        saveBrand(new BrandDTO("Jaguar", Country.ENG));
        saveModel(new ModelDTO(1, "Clase S"));
        saveModel(new ModelDTO(2, "Serie 5"));
        saveModel(new ModelDTO(3, "F Pace"));
    }
}
