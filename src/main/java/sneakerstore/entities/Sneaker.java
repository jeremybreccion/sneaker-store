package sneakerstore.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity
public class Sneaker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sneaker_id")
    private Long id;

    @NotNull
    @Column(nullable = false)
    private String brand;

    @NotNull
    @Column(nullable = false)
    private String model;

    @NotNull
    @Column(nullable = false, unique = true)
    private String name;

    @NotNull
    @Column(nullable = false)
    private String colorway;

    @Temporal(TemporalType.DATE)
    private Date releaseDate;

    @NotNull
    @Column(nullable = false)
    private String sizeType;

    private Double retailPrice;

    private Double discount;

    private Double sellingPrice;

    @OneToMany(mappedBy = "sneaker", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Stock> stockDTO;

    public Sneaker() {
    }

    public Sneaker(@NotNull String brand, @NotNull String model, @NotNull String name, @NotNull String colorway, @NotNull String sizeType) {
        this.brand = brand;
        this.model = model;
        this.name = name;
        this.colorway = colorway;
        this.sizeType = sizeType;
    }

    public Sneaker(@NotNull String brand, @NotNull String model, @NotNull String name, @NotNull String colorway, Date releaseDate, @NotNull String sizeType, Double retailPrice) {
        this.brand = brand;
        this.model = model;
        this.name = name;
        this.colorway = colorway;
        this.releaseDate = releaseDate;
        this.sizeType = sizeType;
        this.retailPrice = retailPrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColorway() {
        return colorway;
    }

    public void setColorway(String colorway) {
        this.colorway = colorway;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getSizeType() {
        return sizeType;
    }

    public void setSizeType(String sizeType) {
        this.sizeType = sizeType;
    }

    public Double getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(Double retailPrice) {
        this.retailPrice = retailPrice;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Double getSellingPrice() {
        return sellingPrice = retailPrice * (1 - discount);
    }

    public List<Stock> getStockDTO() {
        return stockDTO;
    }

    public void setStockDTO(List<Stock> stockDTO) {
        this.stockDTO = stockDTO;
    }
}
