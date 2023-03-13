package POJO;

public class POJO_CarData {
    private String brandModel, color, type, price, description, location, engineCapacity, kilometers ;
     private POJO_SparePartsData availableCarSpareParts= new POJO_SparePartsData();

    public POJO_CarData() {
    }

    public POJO_CarData(String brandModel, String color, String type, String price,
                        String description, String location, String engineCapacity,
                        String kilometers, String partType, String partCondition, String partPrice) {
        this.brandModel = brandModel;
        this.color = color;
        this.type = type;
        this.price = price;
        this.description = description;
        this.location = location;
        this.engineCapacity = engineCapacity;
        this.kilometers = kilometers;
        this.availableCarSpareParts.type = partType;
        this.availableCarSpareParts.condition = partCondition;
        this.availableCarSpareParts.price= partPrice;

    }


    public String getBrandModel() {
        return brandModel;
    }

    public void setBrandModel(String brandModel) {
        this.brandModel = brandModel;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(String engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    public String getKilometers() {
        return kilometers;
    }

    public void setKilometers(String kilometers) {
        this.kilometers = kilometers;
    }

    public void setAvailableCarSpareParts(String partType, String partCondition, String partPrice) {
        this.availableCarSpareParts.type = partType;
        this.availableCarSpareParts.condition = partCondition;
        this.availableCarSpareParts.price= partPrice;
    }

    public POJO_SparePartsData getAvailableCarSpareParts() {
        return availableCarSpareParts;
    }
}
