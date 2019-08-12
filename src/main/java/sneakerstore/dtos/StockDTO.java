package sneakerstore.dtos;

public class StockDTO {
    private Long id;

    private Float size;

    private Integer quantity;

    private Long sneakerId;

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
        this.size = size;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Long getSneakerId() {
        return sneakerId;
    }

    public void setSneakerId(Long sneakerId) {
        this.sneakerId = sneakerId;
    }
}
