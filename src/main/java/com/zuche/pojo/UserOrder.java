package com.zuche.pojo;

/**
 * Store user's car booking order info
 * created by emily on 2020/02/29
 */
public class UserOrder {
    /**
     * such as :Emily
     */
    private String carModel;
    /**
     * such as :1
     */
    private String carNumber;
    /**
     * multiple date combined with comma
     * such as: 20200101,20200102
     */
    private String bookDate;

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public String getBookDate() {
        return bookDate;
    }

    public void setBookDate(String bookDate) {
        this.bookDate = bookDate;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("UserOrder{");
        sb.append("carModel='").append(carModel).append('\'');
        sb.append(", carNumber='").append(carNumber).append('\'');
        sb.append(", bookDate='").append(bookDate).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
