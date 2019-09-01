package sneakerstore.repositories;

        import org.springframework.data.jpa.repository.JpaRepository;
        import org.springframework.data.repository.CrudRepository;
        import org.springframework.stereotype.Repository;
        import sneakerstore.entities.Sneaker;

        import java.util.List;

@Repository
public interface SneakerRepository extends JpaRepository<Sneaker, Long> {
    List<Sneaker> findByModel(String model);
}
