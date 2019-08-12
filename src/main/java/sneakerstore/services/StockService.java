package sneakerstore.services;

        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;
        import sneakerstore.dtos.SneakerDTO;
        import sneakerstore.dtos.StockDTO;
        import sneakerstore.entities.Sneaker;
        import sneakerstore.entities.Stock;
        import sneakerstore.mapper.Mapper;
        import sneakerstore.repositories.SneakerRepository;
        import sneakerstore.repositories.StockRepository;

        import java.util.ArrayList;
        import java.util.List;
        import java.util.stream.Collectors;

@Service
public class StockService {

    @Autowired
    private StockRepository stockRepository;

    @Autowired
    private SneakerRepository sneakerRepository;

    @Autowired
    private Mapper mapper;

    public void saveStock(StockDTO stockDTO) {
        Sneaker sneaker = sneakerRepository.findById(stockDTO.getSneakerId()).orElse(null);
        Stock stock = mapper.convertToEntity(stockDTO);
        stock.setSneaker(sneaker);
        stock.setSize(stockDTO.getSize());
        stock.setQuantity(stockDTO.getQuantity());
        stockRepository.save(stock);
    }

    public List<StockDTO> findAll() {
        List<Stock> list = new ArrayList<>();
        stockRepository.findAll().forEach(list::add);
        return list.stream()
                .map(stock -> mapper.convertToDTO(stock))
                .collect(Collectors.toList());
    }

}
