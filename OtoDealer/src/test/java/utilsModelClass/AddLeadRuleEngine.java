package utilsModelClass;

import com.google.gson.annotations.SerializedName;

public class AddLeadRuleEngine {
	@SerializedName("name")
	private String name;
	@SerializedName("phone")
	private String phone;
	@SerializedName("application_type")
	private String applicationType;
	@SerializedName("lead_source_id")
	private Integer leadSourceId;
	@SerializedName("financier_id")
	private Integer financierId;
	@SerializedName("branch_id")
	private Integer branchId;
	@SerializedName("already_po")
	private String alreadyPo;
	@SerializedName("notes")
	private String notes;
	@SerializedName("car_id")
	private Integer carId;
	@SerializedName("make_id")
	private Integer makeId;
	@SerializedName("model_id")
	private Integer modelId;
	@SerializedName("version_id")
	private Integer versionId;
	@SerializedName("mmv_name")
	private String mmvName;
	@SerializedName("reg_number")
	private String regNumber;
	@SerializedName("region_id")
	private Integer regionId;
	@SerializedName("reg_date")
	private String regDate;
	@SerializedName("make_year")
	private Integer makeYear;
	@SerializedName("created_on_gcloud")
	private String createdOnGcloud;
	@SerializedName("transmission")
	private String transmission;
	@SerializedName("loan_type")
	private String loanType;
	@SerializedName("make")
	private String make;
	@SerializedName("model")
	private String model;
	@SerializedName("modelVersion")
	private String modelVersion;
	@SerializedName("other_colour")
	private String otherColour;
	@SerializedName("uc_colour")
	private String ucColour;
	@SerializedName("is_multiquote")
	private Integer isMultiquote;
	@SerializedName("user_id")
	private String userId;
	@SerializedName("user_type")
	private String userType;
	@SerializedName("agent_id")
	private Integer agentId;
	@SerializedName("car_body_type")
	private String carBodyType;
	@SerializedName("rule_engine")
	private RuleEngine ruleEngine;
	@SerializedName("car_price")
	private Integer carPrice;
	@SerializedName("first_tdp")
	private Integer firstTdp;
	@SerializedName("emi")
	private Integer emi;
	@SerializedName("tenure")
	private Integer tenure;
	@SerializedName("approved_amount")
	private Integer approvedAmount;
	@SerializedName("amount_needed")
	private String amountNeeded;
	@SerializedName("real_tdp")
	private Integer realTdp;
	@SerializedName("has_rule_engine")
	private Integer hasRuleEngine;
	@SerializedName("is_active_calculator")
	private Integer isActiveCalculator;
	@SerializedName("is_deviation")
	private Integer isDeviation;
	@SerializedName("deviation_percentage")
	private Integer deviationPercentage;
	@SerializedName("is_mrp")
	private Integer isMrp;
	@SerializedName("dealer_id")
	private String dealerId;

	public String getName() {
	return name;
	}

	public void setName(String name) {
	this.name = name;
	}

	public String getPhone() {
	return phone;
	}

	public void setPhone(String phone) {
	this.phone = phone;
	}

	public String getApplicationType() {
	return applicationType;
	}

	public void setApplicationType(String applicationType) {
	this.applicationType = applicationType;
	}

	public Integer getLeadSourceId() {
	return leadSourceId;
	}

	public void setLeadSourceId(Integer leadSourceId) {
	this.leadSourceId = leadSourceId;
	}

	public Integer getFinancierId() {
	return financierId;
	}

	public void setFinancierId(Integer financierId) {
	this.financierId = financierId;
	}

	public Integer getBranchId() {
	return branchId;
	}

	public void setBranchId(Integer branchId) {
	this.branchId = branchId;
	}

	public String getAlreadyPo() {
	return alreadyPo;
	}

	public void setAlreadyPo(String alreadyPo) {
	this.alreadyPo = alreadyPo;
	}

	public String getNotes() {
	return notes;
	}

	public void setNotes(String notes) {
	this.notes = notes;
	}

	public Integer getCarId() {
	return carId;
	}

	public void setCarId(Integer carId) {
	this.carId = carId;
	}

	public Integer getMakeId() {
	return makeId;
	}

	public void setMakeId(Integer makeId) {
	this.makeId = makeId;
	}

	public Integer getModelId() {
	return modelId;
	}

	public void setModelId(Integer modelId) {
	this.modelId = modelId;
	}

	public Integer getVersionId() {
	return versionId;
	}

	public void setVersionId(Integer versionId) {
	this.versionId = versionId;
	}

	public String getMmvName() {
	return mmvName;
	}

	public void setMmvName(String mmvName) {
	this.mmvName = mmvName;
	}

	public String getRegNumber() {
	return regNumber;
	}

	public void setRegNumber(String regNumber) {
	this.regNumber = regNumber;
	}

	public Integer getRegionId() {
	return regionId;
	}

	public void setRegionId(Integer regionId) {
	this.regionId = regionId;
	}

	public String getRegDate() {
	return regDate;
	}

	public void setRegDate(String regDate) {
	this.regDate = regDate;
	}

	public Integer getMakeYear() {
	return makeYear;
	}

	public void setMakeYear(Integer makeYear) {
	this.makeYear = makeYear;
	}

	public String getCreatedOnGcloud() {
	return createdOnGcloud;
	}

	public void setCreatedOnGcloud(String createdOnGcloud) {
	this.createdOnGcloud = createdOnGcloud;
	}

	public String getTransmission() {
	return transmission;
	}

	public void setTransmission(String transmission) {
	this.transmission = transmission;
	}

	public String getLoanType() {
	return loanType;
	}

	public void setLoanType(String loanType) {
	this.loanType = loanType;
	}

	public String getMake() {
	return make;
	}

	public void setMake(String make) {
	this.make = make;
	}

	public String getModel() {
	return model;
	}

	public void setModel(String model) {
	this.model = model;
	}

	public String getModelVersion() {
	return modelVersion;
	}

	public void setModelVersion(String modelVersion) {
	this.modelVersion = modelVersion;
	}

	public String getOtherColour() {
	return otherColour;
	}

	public void setOtherColour(String otherColour) {
	this.otherColour = otherColour;
	}

	public String getUcColour() {
	return ucColour;
	}

	public void setUcColour(String ucColour) {
	this.ucColour = ucColour;
	}

	public Integer getIsMultiquote() {
	return isMultiquote;
	}

	public void setIsMultiquote(Integer isMultiquote) {
	this.isMultiquote = isMultiquote;
	}

	public String getUserId() {
	return userId;
	}

	public void setUserId(String userId) {
	this.userId = userId;
	}

	public String getUserType() {
	return userType;
	}

	public void setUserType(String userType) {
	this.userType = userType;
	}

	public Integer getAgentId() {
	return agentId;
	}

	public void setAgentId(Integer agentId) {
	this.agentId = agentId;
	}

	public String getCarBodyType() {
	return carBodyType;
	}

	public void setCarBodyType(String carBodyType) {
	this.carBodyType = carBodyType;
	}

	public RuleEngine getRuleEngine() {
	return ruleEngine;
	}

	public void setRuleEngine(RuleEngine ruleEngine) {
	this.ruleEngine = ruleEngine;
	}

	public Integer getCarPrice() {
	return carPrice;
	}

	public void setCarPrice(Integer carPrice) {
	this.carPrice = carPrice;
	}

	public Integer getFirstTdp() {
	return firstTdp;
	}

	public void setFirstTdp(Integer firstTdp) {
	this.firstTdp = firstTdp;
	}

	public Integer getEmi() {
	return emi;
	}

	public void setEmi(Integer emi) {
	this.emi = emi;
	}

	public Integer getTenure() {
	return tenure;
	}

	public void setTenure(Integer tenure) {
	this.tenure = tenure;
	}

	public Integer getApprovedAmount() {
	return approvedAmount;
	}

	public void setApprovedAmount(Integer approvedAmount) {
	this.approvedAmount = approvedAmount;
	}

	public String getAmountNeeded() {
	return amountNeeded;
	}

	public void setAmountNeeded(String amountNeeded) {
	this.amountNeeded = amountNeeded;
	}

	public Integer getRealTdp() {
	return realTdp;
	}

	public void setRealTdp(Integer realTdp) {
	this.realTdp = realTdp;
	}

	public Integer getHasRuleEngine() {
	return hasRuleEngine;
	}

	public void setHasRuleEngine(Integer hasRuleEngine) {
	this.hasRuleEngine = hasRuleEngine;
	}

	public Integer getIsActiveCalculator() {
	return isActiveCalculator;
	}

	public void setIsActiveCalculator(Integer isActiveCalculator) {
	this.isActiveCalculator = isActiveCalculator;
	}

	public Integer getIsDeviation() {
	return isDeviation;
	}

	public void setIsDeviation(Integer isDeviation) {
	this.isDeviation = isDeviation;
	}

	public Integer getDeviationPercentage() {
	return deviationPercentage;
	}

	public void setDeviationPercentage(Integer deviationPercentage) {
	this.deviationPercentage = deviationPercentage;
	}

	public Integer getIsMrp() {
	return isMrp;
	}

	public void setIsMrp(Integer isMrp) {
	this.isMrp = isMrp;
	}

	public String getDealerId() {
	return dealerId;
	}

	public void setDealerId(String dealerId) {
	this.dealerId = dealerId;
	}

	}