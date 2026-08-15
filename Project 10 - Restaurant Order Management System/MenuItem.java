import java.math.BigDecimal;

public class MenuItem {
    private String itemId;
    private String itemName;
    private MenuCategory category;
    private BigDecimal price;
    private AvailabilityStatus availability = AvailabilityStatus.AVAILABLE;

    public MenuItem(String itemId, String itemName, MenuCategory category, BigDecimal price) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.category = category;
        this.price = price;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public MenuCategory getCategory() {
        return category;
    }

    public void setCategory(MenuCategory category) {
        this.category = category;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public AvailabilityStatus getAvailability() {
        return availability;
    }

    public void setAvailability(AvailabilityStatus availability) {
        this.availability = availability;
    }

    @Override
    public String toString()
    {
        return 
        "Item{Item id : " + itemId + " Item Name : " + itemName + " Category : " + category + 
        " Price : " + price + " Availability : " + availability + "}";  
    }
}