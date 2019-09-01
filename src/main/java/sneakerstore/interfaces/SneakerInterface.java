package sneakerstore.interfaces;

import sneakerstore.dtos.SneakerDTO;

import java.util.List;

public interface SneakerInterface {
    void saveSneaker(SneakerDTO sneakerDTO);
    SneakerDTO findById(Long id);
    List<SneakerDTO> findAll();
    List<SneakerDTO> findByModel(String model);
    void delete(Long id);
    Boolean doesExists(Long id);
}
