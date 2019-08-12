package sneakerstore.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sneakerstore.dtos.SneakerDTO;
import sneakerstore.dtos.StockDTO;
import sneakerstore.entities.Sneaker;
import sneakerstore.entities.Stock;

@Component
public class Mapper {

    @Autowired
    private ModelMapper mapper;

    public SneakerDTO convertToDTO(Sneaker sneaker) {
        return mapper.map(sneaker, SneakerDTO.class);
    }

    public Sneaker convertToEntity(SneakerDTO sneakerDTO){
        return mapper.map(sneakerDTO, Sneaker.class);
    }

    public StockDTO convertToDTO(Stock stock) {
        return mapper.map(stock, StockDTO.class);
    }

    public Stock convertToEntity(StockDTO stockDTO){
        return mapper.map(stockDTO, Stock.class);
    }
}
