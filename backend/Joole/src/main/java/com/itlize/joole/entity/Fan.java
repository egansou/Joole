package com.itlize.joole.entity;

import java.util.Date;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="fan")
public class Fan {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="fan_id")
	private int fanId;
	
	@Column(name="fan_image")
	private String fanImage;
	
	@Column(name="verified_date")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT-5")
	private Date verifiedDate;
	
	@JoinColumn (name="manuf_id")
	@ManyToOne (fetch=FetchType.EAGER)
	private Manufacturer manufacturer;
	
	@JoinColumn (name="type_id")
	@ManyToOne (fetch=FetchType.EAGER)
	private Type type;
	
	@Column(name="firm_spec")
	private int firmSpec;
	
	@Column(name="global_spec")
	private int globalSpec;
	
	@Column(name="series")
	private String series;
	
	@Column(name="model")
	private String model;
	
	@Column(name="use_type")
	private String useType;
	
	@Column(name="application")
	private String application;
	
	@Column(name="mounting_location")
	private String mountingLocation;
	
	@Column(name="accessories")
	private String accessories;
	
	@Column(name="model_year")
	private int modelYear;
	
	@Column(name="airflow")
	private int airflow;
	
	@Column(name="power_min")
	private double powerMin;
	
	@Column(name="power_max")
	private double powerMax;
	
	@Column(name="voltage_min")
	private double voltageMin;
	
	@Column(name="voltage_max")
	private double voltageMax;
	
	@Column(name="fan_speed_min")
	private double fanSpeedMin;
	
	@Column(name="fan_speed_max")
	private double fanSpeedMax;
	
	@Column(name="number_fan_speed")
	private int numberFanSpeed;
	
	@Column(name="sound_max_speed")
	private int soundMaxSpeed;

	@Column(name="fan_diameter")
	private int fanDiameter;
	
	@Column(name="height_min")
	private double heightMin;
	
	@Column(name="height_max")
	private double heightMax;
	
	@Column(name="weight")
	private double weight;
	
	@Column(name="information")
	private String information;
	
	@Column(name="documentation")
	private String documentation;
	
	public Fan() {
		verifiedDate = new Date();
	}

	public int getFanId() {
		return fanId;
	}

	public void setFanId(int fanId) {
		this.fanId = fanId;
	}

	public String getFanImage() {
		return fanImage;
	}

	public void setFanImage(String fanImage) {
		this.fanImage = fanImage;
	}

	public Date getVerifiedDate() {
		return verifiedDate;
	}

	public void setVerifiedDate(Date verifiedDate) {
		this.verifiedDate = verifiedDate;
	}

	public Manufacturer getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(Manufacturer manufacturer) {
		this.manufacturer = manufacturer;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public int getFirmSpec() {
		return firmSpec;
	}

	public void setFirmSpec(int firmSpec) {
		this.firmSpec = firmSpec;
	}

	public int getGlobalSpec() {
		return globalSpec;
	}

	public void setGlobalSpec(int globalSpec) {
		this.globalSpec = globalSpec;
	}

	public String getSeries() {
		return series;
	}

	public void setSeries(String series) {
		this.series = series;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getUseType() {
		return useType;
	}

	public void setUseType(String useType) {
		this.useType = useType;
	}

	public String getApplication() {
		return application;
	}

	public void setApplication(String application) {
		this.application = application;
	}

	public String getMountingLocation() {
		return mountingLocation;
	}

	public void setMountingLocation(String mountingLocation) {
		this.mountingLocation = mountingLocation;
	}

	public String getAccessories() {
		return accessories;
	}

	public void setAccessories(String accessories) {
		this.accessories = accessories;
	}

	public int getModelYear() {
		return modelYear;
	}

	public void setModelYear(int modelYear) {
		this.modelYear = modelYear;
	}

	public int getAirflow() {
		return airflow;
	}

	public void setAirflow(int airflow) {
		this.airflow = airflow;
	}

	public double getPowerMin() {
		return powerMin;
	}

	public void setPowerMin(double powerMin) {
		this.powerMin = powerMin;
	}

	public double getPowerMax() {
		return powerMax;
	}

	public void setPowerMax(double powerMax) {
		this.powerMax = powerMax;
	}

	public double getVoltageMin() {
		return voltageMin;
	}

	public void setVoltageMin(double voltageMin) {
		this.voltageMin = voltageMin;
	}

	public double getVoltageMax() {
		return voltageMax;
	}

	public void setVoltageMax(double voltageMax) {
		this.voltageMax = voltageMax;
	}

	public double getFanSpeedMin() {
		return fanSpeedMin;
	}

	public void setFanSpeedMin(double fanSpeedMin) {
		this.fanSpeedMin = fanSpeedMin;
	}

	public double getFanSpeedMax() {
		return fanSpeedMax;
	}

	public void setFanSpeedMax(double fanSpeedMax) {
		this.fanSpeedMax = fanSpeedMax;
	}

	public int getNumberFanSpeed() {
		return numberFanSpeed;
	}

	public void setNumberFanSpeed(int numberFanSpeed) {
		this.numberFanSpeed = numberFanSpeed;
	}

	public int getSoundMaxSpeed() {
		return soundMaxSpeed;
	}

	public void setSoundMaxSpeed(int soundMaxSpeed) {
		this.soundMaxSpeed = soundMaxSpeed;
	}

	public int getFanDiameter() {
		return fanDiameter;
	}

	public void setFanDiameter(int fanDiameter) {
		this.fanDiameter = fanDiameter;
	}

	public double getHeightMin() {
		return heightMin;
	}

	public void setHeightMin(double heightMin) {
		this.heightMin = heightMin;
	}

	public double getHeightMax() {
		return heightMax;
	}

	public void setHeightMax(double heightMax) {
		this.heightMax = heightMax;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public String getInformation() {
		return information;
	}

	public void setInformation(String information) {
		this.information = information;
	}

	public String getDocumentation() {
		return documentation;
	}

	public void setDocumentation(String documentation) {
		this.documentation = documentation;
	}

	@Override
	public String toString() {
		return "Fan [fanId=" + fanId + ", fanImage=" + fanImage + ", verifiedDate=" + verifiedDate + ", manufacturer="
				+ manufacturer + ", type=" + type + ", firmSpec=" + firmSpec + ", globalSpec=" + globalSpec
				+ ", series=" + series + ", model=" + model + ", useType=" + useType + ", application=" + application
				+ ", mountingLocation=" + mountingLocation + ", accessories=" + accessories + ", modelYear=" + modelYear
				+ ", airflow=" + airflow + ", powerMin=" + powerMin + ", powerMax=" + powerMax + ", voltageMin="
				+ voltageMin + ", voltageMax=" + voltageMax + ", fanSpeedMin=" + fanSpeedMin + ", fanSpeedMax="
				+ fanSpeedMax + ", numberFanSpeed=" + numberFanSpeed + ", soundMaxSpeed=" + soundMaxSpeed
				+ ", fanDiameter=" + fanDiameter + ", heightMin=" + heightMin + ", heightMax=" + heightMax + ", weight="
				+ weight + ", information=" + information + ", documentation=" + documentation + "]";
	}


}

