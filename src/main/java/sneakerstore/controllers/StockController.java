package sneakerstore.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sneakerstore.dtos.StockDTO;
import sneakerstore.services.StockService;

import java.util.List;

@RestController
@RequestMapping("/stock")
public class StockController {

    @Autowired
    private StockService stockService;

    @PostMapping("/save")
    public void saveStock(@RequestBody StockDTO stockDTO) {
        stockService.saveStock(stockDTO);
    }

    @GetMapping("/all")
    public List<StockDTO> findAll() {
        return stockService.findAll();
    }
}
