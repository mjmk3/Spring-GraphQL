package app.graphql.springgraphql.Service;

import app.graphql.springgraphql.Domain.Brand;
import app.graphql.springgraphql.Enums.Country;
import app.graphql.springgraphql.Repo.BrandRepo;
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

    @Autowired
    public BrandService(BrandRepo brandRepo) {
        this.brandRepo = brandRepo;
    }

    public List<Brand> findAllBrands(){
        return brandRepo.findAll();
    }

    public Brand findOneBrand(int id){
        return brandRepo.findById(id)
                .orElseThrow(()->new RuntimeException("id not exists"));
    }

    public Brand save(String brandName, Country country){
        Brand brand = Brand.builder().brandName(brandName).country(country).build();
        return brandRepo.save(brand);
    }

    @PostConstruct
    private void loadData(){
        save("Mercedes", Country.GER);
        save("BMW", Country.GER);
        save("Jaguar", Country.ENG);
    }
}
