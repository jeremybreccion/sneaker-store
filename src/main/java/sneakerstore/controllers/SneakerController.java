package sneakerstore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sneakerstore.dtos.SneakerDTO;
import sneakerstore.interfaces.SneakerInterface;

import java.util.List;

@RestController
@RequestMapping("/sneaker")
public class SneakerController {

    @Autowired
    private SneakerInterface sneakerService;

    @PostMapping("/save")
    public void save(@RequestBody SneakerDTO sneakerDTO) {
        sneakerService.saveSneaker(sneakerDTO);
    }

    @GetMapping("/findAll")
    public List<SneakerDTO> findAll() {
        return sneakerService.findAll();
    }

    @GetMapping("/model")
    public List<SneakerDTO> findByModel(@RequestParam String model) {
        return sneakerService.findByModel(model);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestParam Long id) {
        sneakerService.delete(id);
    }
}
