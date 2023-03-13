package POJO;

 public class POJO_SparePartsData {
    String type, condition, price;

     public POJO_SparePartsData() {
     }

     public POJO_SparePartsData(String type, String condition, String price) {
        this.type = type;
        this.condition = condition;
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
