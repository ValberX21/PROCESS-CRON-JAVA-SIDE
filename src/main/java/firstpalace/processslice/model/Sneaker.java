package firstpalace.processslice.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Entity
@Table(name = "sneaker")
public class Sneaker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    private String modelName;
    private String sku;
    private String sizesAvailable;
    private String colors;
    private String material;
    private double price;
    private boolean isActive;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Sneaker(int id,String modelName, String sku, String sizesAvailable, String colors, String material, double price, boolean isActive, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.modelName = modelName;
        this.sku = sku;
        this.sizesAvailable = sizesAvailable;
        this.colors = colors;
        this.material = material;
        this.price = price;
        this.isActive = isActive;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.id = id;
    }

    public Sneaker() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getSizesAvailable() {
        return sizesAvailable;
    }

    public void setSizesAvailable(String sizesAvailable) {
        this.sizesAvailable = sizesAvailable;
    }

    public String getColors() {
        return colors;
    }

    public void setColors(String colors) {
        this.colors = colors;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public List<String> getSizesAvailableList() {
        return sizesAvailable != null ? Arrays.asList(sizesAvailable.split(",")) : List.of();
    }

    public void setSizesAvailableList(List<String> sizes) {
        this.sizesAvailable = String.join(",", sizes);
    }

    public List<String> getColorsList() {
        return colors != null ? Arrays.asList(colors.split(",")) : List.of();
    }

    public void setColorsList(List<String> colorsList) {
        this.colors = String.join(",", colorsList);
    }
}
