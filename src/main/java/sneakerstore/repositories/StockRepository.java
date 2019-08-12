package sneakerstore.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sneakerstore.entities.Sneaker;
import sneakerstore.entities.Stock;

@Repository
public interface StockRepository extends CrudRepository<Stock, Long> {
    //is this the right place? // does not work!
    Sneaker findBySneakerId(Long id);
}
