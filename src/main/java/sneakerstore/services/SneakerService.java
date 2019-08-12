package sneakerstore.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sneakerstore.dtos.SneakerDTO;
import sneakerstore.dtos.StockDTO;
import sneakerstore.entities.Sneaker;
import sneakerstore.mapper.Mapper;
import sneakerstore.repositories.SneakerRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SneakerService {

    @Autowired
    private SneakerRepository sneakerRepository;

    @Autowired
    private Mapper mapper;

    public void saveSneaker(SneakerDTO sneakerDTO) {
        sneakerRepository.save(mapper.convertToEntity(sneakerDTO));
    }

    public List<SneakerDTO> findAll() {
        List<Sneaker> list = new ArrayList<>();
        sneakerRepository.findAll().forEach(list::add);
        return list.stream()
                .map(sneaker -> mapper.convertToDTO(sneaker))
                .collect(Collectors.toList());
    }

    public SneakerDTO findById(Long id) {
        return mapper.convertToDTO(sneakerRepository.findById(id).orElse(null));
    }

    public List<SneakerDTO> findByModel(String model) {
        List<Sneaker> list = new ArrayList<>();
        sneakerRepository.findByModel(model).forEach(list::add);
        return list.stream()
                .map(sneaker -> mapper.convertToDTO(sneaker))
                .collect(Collectors.toList());
    }

    public void delete(Long id) {
        sneakerRepository.deleteById(id);
    }

    public Boolean doesExists(Long id){
        return sneakerRepository.existsById(id);
    }

}
