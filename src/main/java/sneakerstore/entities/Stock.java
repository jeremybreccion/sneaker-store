package sneakerstore.entities;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"sneaker_id", "size"}))
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stock_id")
    private Long id;

    @Column(nullable = false)
    private Float size;

    @Column(nullable = false)
    private Integer quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sneaker_id", nullable = false)
    private Sneaker sneaker;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getSize() {
        return size;
    }

    public void setSize(Float size) {
        this.size = canBeStocked() ? size : null;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = canBeStocked() ? quantity : null;
    }

    public Sneaker getSneaker() {
        return sneaker;
    }

    public void setSneaker(Sneaker sneaker) {
        this.sneaker = sneaker;
    }

    private boolean canBeStocked() {
        return sneaker != null && sneaker.getReleaseDate() != null && sneaker.getRetailPrice() != null;
    }
}
