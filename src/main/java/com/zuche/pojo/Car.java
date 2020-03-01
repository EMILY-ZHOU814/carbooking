package com.zuche.pojo;

/**
 * Describe the basic information of a car, includes car model and scheduled car-using time
 * created by emily on 2020/02/29
 */
public class Car {
    /**
     * id
     */
    private int id;
    /**
     * such as :Toyota Camry
     */
    private String carModel;
    /**
     * such as :001
     */
    private String carNumber;
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

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getBookDate() {
        return bookDate;
    }

    public void setBookDate(String bookDate) {
        this.bookDate = bookDate;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Car{");
        sb.append("id=").append(id);
        sb.append(", carModel='").append(carModel).append('\'');
        sb.append(", carNumber='").append(carNumber).append('\'');
        sb.append(", bookDate='").append(bookDate).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
