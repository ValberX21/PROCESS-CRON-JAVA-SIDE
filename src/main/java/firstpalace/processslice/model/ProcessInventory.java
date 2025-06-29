package firstpalace.processslice.model;

import jakarta.persistence.*;

@Entity
@Table(name = "process_inventory")
public class ProcessInventory
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double sumTotal;

    // Constructors
    public ProcessInventory() {
    }

    public ProcessInventory(double sumTotal) {
        this.sumTotal = sumTotal;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public double getSumTotal() {
        return sumTotal;
    }

    public void setSumTotal(double sumTotal) {
        this.sumTotal = sumTotal;
    }
}
