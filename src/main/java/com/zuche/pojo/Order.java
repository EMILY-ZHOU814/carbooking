package com.zuche.pojo;

/**
 * Car booking order info
 * created by emily on 2020/02/29
 */
public class Order {
    /**
     * id
     */
    private int id;
    /**
     * such as :Emily
     */
    private String userName;
    /**
     * such as :1
     */
    private int carId;
    /**
     * multiple date combined with comma
     * such as: 20200101,20200102
     */
    private String bookDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public String getBookDate() {
        return bookDate;
    }

    public void setBookDate(String bookDate) {
        this.bookDate = bookDate;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Order{");
        sb.append("id=").append(id);
        sb.append(", userName='").append(userName).append('\'');
        sb.append(", carId='").append(carId).append('\'');
        sb.append(", bookDate='").append(bookDate).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
