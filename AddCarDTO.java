package com.crs.dto.car;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AddCarDTO {

    private String vehicleNo;

    private String brand;

    private String model;

    private LocalDate makeYear;

    private String fuelType;

    private String driveType;

    private String category;

    private Integer seatingCapacity;

    private boolean haveABS;

    private boolean haveAirBags;

    private Double baseFare;

    private Long branchId =1L;

    private String imageUrl;

	public String getVehicleNo() {
		return vehicleNo;
	}

	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
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

	public LocalDate getMakeYear() {
		return makeYear;
	}

	public void setMakeYear(LocalDate makeYear) {
		this.makeYear = makeYear;
	}

	public String getFuelType() {
		return fuelType;
	}

	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}

	public String getDriveType() {
		return driveType;
	}

	public void setDriveType(String driveType) {
		this.driveType = driveType;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Integer getSeatingCapacity() {
		return seatingCapacity;
	}

	public void setSeatingCapacity(Integer seatingCapacity) {
		this.seatingCapacity = seatingCapacity;
	}

	public boolean isHaveABS() {
		return haveABS;
	}

	public void setHaveABS(boolean haveABS) {
		this.haveABS = haveABS;
	}

	public boolean isHaveAirBags() {
		return haveAirBags;
	}

	public void setHaveAirBags(boolean haveAirBags) {
		this.haveAirBags = haveAirBags;
	}

	public Double getBaseFare() {
		return baseFare;
	}

	public void setBaseFare(Double baseFare) {
		this.baseFare = baseFare;
	}

	public Long getBranchId() {
		return branchId;
	}

	public void setBranchId(Long branchId) {
		this.branchId = branchId;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
    
    
}
