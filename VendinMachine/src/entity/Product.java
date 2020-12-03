package entity;

public class Product{
    private String productName;
    private long productPrice;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public long getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(long productPrice) {
        this.productPrice = productPrice;
    }

    @Override
    public boolean equals(Object o)
    {
        if(o==this)
            return true;
        if(!(o instanceof  Product))
            return false;

        Product product=(Product)o;

        if(product.getProductName()==this.getProductName())
            return  true;
        else
            return false;

    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + productName.hashCode();
        return result;
    }
}
