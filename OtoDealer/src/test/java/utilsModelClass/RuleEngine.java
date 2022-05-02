package utilsModelClass;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class RuleEngine {

		@SerializedName("dealer_id")
		private Integer dealerId;
		@SerializedName("make_id")
		private Integer makeId;
		@SerializedName("model_id")
		private Integer modelId;
		@SerializedName("version_id")
		private Integer versionId;
		@SerializedName("make_year")
		private Integer makeYear;
		@SerializedName("financier_id")
		private Integer financierId;
		@SerializedName("applicant_type_id")
		private Integer applicantTypeId;
		@SerializedName("customer_area_id")
		private Integer customerAreaId;
		@SerializedName("plate_area_id")
		private Integer plateAreaId;
		@SerializedName("vehicle_type_id")
		private Integer vehicleTypeId;
		@SerializedName("insurance_type_id")
		private Integer insuranceTypeId;
		@SerializedName("mrp")
		private Integer mrp;
		@SerializedName("price_upping_id")
		private Integer priceUppingId;
		@SerializedName("mrp_with_upping")
		private Integer mrpWithUpping;
		@SerializedName("olx_mrp")
		private Integer olxMrp;
		@SerializedName("tenure")
		private Integer tenure;
		@SerializedName("loan_needed")
		private String loanNeeded;
		@SerializedName("actual_dp_per")
		private Integer actualDpPer;
		@SerializedName("user_id")
		private Integer userId;
		@SerializedName("user_type")
		private String userType;
		@SerializedName("occupation")
		private String occupation;
		@SerializedName("insurance_per")
		private Double insurancePer;
		@SerializedName("insurance_amount")
		private Integer insuranceAmount;
		@SerializedName("loading_fee")
		private List<Object> loadingFee = null;
		@SerializedName("depreciation")
		private List<Depreciation> depreciation = null;
		@SerializedName("insurance_on_loan")
		private Integer insuranceOnLoan;
		@SerializedName("insurance_on_loan_per")
		private Integer insuranceOnLoanPer;
		@SerializedName("insurance_in_cash_per")
		private Integer insuranceInCashPer;
		@SerializedName("insurance_in_cash")
		private Integer insuranceInCash;
		@SerializedName("insurance_income")
		private Integer insuranceIncome;
		@SerializedName("dp_amount")
		private Integer dpAmount;
		@SerializedName("dp_per")
		private Double dpPer;
		@SerializedName("ltv_per")
		private Integer ltvPer;
		@SerializedName("ltv_max_per")
		private Integer ltvMaxPer;
		@SerializedName("principal_amount")
		private Integer principalAmount;
		@SerializedName("total_loan_amount")
		private Integer totalLoanAmount;
		@SerializedName("provisional_per")
		private Integer provisionalPer;
		@SerializedName("provisional_fee")
		private Integer provisionalFee;
		@SerializedName("provision_in_cash")
		private Integer provisionInCash;
		@SerializedName("provision_on_loan")
		private Integer provisionOnLoan;
		@SerializedName("provision_in_cash_per")
		private Integer provisionInCashPer;
		@SerializedName("interest_rate")
		private Double interestRate;
		@SerializedName("reducing_rate")
		private Integer reducingRate;
		@SerializedName("interest_amount")
		private Integer interestAmount;
		@SerializedName("installment")
		private Integer installment;
		@SerializedName("admin_fee")
		private Integer adminFee;
		@SerializedName("admin_fee_on_loan")
		private Integer adminFeeOnLoan;
		@SerializedName("admin_fee_in_cash")
		private Integer adminFeeInCash;
		@SerializedName("legal_fee")
		private Integer legalFee;
		@SerializedName("total_dp")
		private Integer totalDp;
		@SerializedName("disbursement")
		private Integer disbursement;
		@SerializedName("assistant_fee")
		private Integer assistantFee;
		@SerializedName("palp_amount_cash")
		private Integer palpAmountCash;
		@SerializedName("cpr_per")
		private Integer cprPer;
		@SerializedName("cpr_fee")
		private Integer cprFee;
		@SerializedName("installment_2nd")
		private Integer installment2nd;
		@SerializedName("max_ntf")
		private Integer maxNtf;
		@SerializedName("life_insurance_amount")
		private Integer lifeInsuranceAmount;
		@SerializedName("tmp_data")
		private Integer tmpData;
		@SerializedName("admin_fee_insurance")
		private Integer adminFeeInsurance;
		@SerializedName("payment_type")
		private String paymentType;
		@SerializedName("additional_fee")
		private Integer additionalFee;
		@SerializedName("booster_scheme")
		private Integer boosterScheme;
		@SerializedName("is_deviation")
		private Integer isDeviation;
		@SerializedName("deviation_per")
		private Integer deviationPer;
		@SerializedName("refund_on_insurance")
		private Integer refundOnInsurance;
		@SerializedName("interest_income_for_refund")
		private Integer interestIncomeForRefund;
		@SerializedName("min_income_for_oto")
		private String minIncomeForOto;
		@SerializedName("refund_on_interest")
		private Integer refundOnInterest;
		@SerializedName("refund_on_admin_fee")
		private Integer refundOnAdminFee;
		@SerializedName("refund_on_provision")
		private Double refundOnProvision;
		@SerializedName("total_refund_to_oto")
		private Integer totalRefundToOto;
		@SerializedName("refund_to_oto_per")
		private Integer refundToOtoPer;
		@SerializedName("total_income")
		private Integer totalIncome;
		@SerializedName("refund_to_dealer_by_refund")
		private Integer refundToDealerByRefund;
		@SerializedName("refund_to_dealer_by_oto")
		private Integer refundToDealerByOto;
		@SerializedName("actual_refund_to_dealer")
		private Integer actualRefundToDealer;
		@SerializedName("total_payment_to_dealer")
		private Integer totalPaymentToDealer;
		@SerializedName("deviation_amount")
		private Integer deviationAmount;
		@SerializedName("reward_price")
		private Integer rewardPrice;
		@SerializedName("refund_insurance_rate")
		private Integer refundInsuranceRate;
		@SerializedName("refund_rate")
		private Integer refundRate;
		@SerializedName("refund_amount")
		private Integer refundAmount;
		@SerializedName("total_refund_to_oto_before_ct")
		private Integer totalRefundToOtoBeforeCt;
		@SerializedName("refund_on_interest_per")
		private Integer refundOnInterestPer;
		@SerializedName("refund_on_provision_per")
		private Integer refundOnProvisionPer;
		@SerializedName("refund_on_insurance_per")
		private Integer refundOnInsurancePer;
		@SerializedName("refund_tax_per")
		private Integer refundTaxPer;
		@SerializedName("refund_tax")
		private Double refundTax;
		@SerializedName("refund_after_tax")
		private Double refundAfterTax;
		@SerializedName("refund_on_admin_per")
		private Integer refundOnAdminPer;
		@SerializedName("refund_insurance_after_tax")
		private Integer refundInsuranceAfterTax;
		@SerializedName("updatedLoanNeeded")
		private String updatedLoanNeeded;

		public Integer getDealerId() {
		return dealerId;
		}

		public void setDealerId(Integer dealerId) {
		this.dealerId = dealerId;
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

		public Integer getMakeYear() {
		return makeYear;
		}

		public void setMakeYear(Integer makeYear) {
		this.makeYear = makeYear;
		}

		public Integer getFinancierId() {
		return financierId;
		}

		public void setFinancierId(Integer financierId) {
		this.financierId = financierId;
		}

		public Integer getApplicantTypeId() {
		return applicantTypeId;
		}

		public void setApplicantTypeId(Integer applicantTypeId) {
		this.applicantTypeId = applicantTypeId;
		}

		public Integer getCustomerAreaId() {
		return customerAreaId;
		}

		public void setCustomerAreaId(Integer customerAreaId) {
		this.customerAreaId = customerAreaId;
		}

		public Integer getPlateAreaId() {
		return plateAreaId;
		}

		public void setPlateAreaId(Integer plateAreaId) {
		this.plateAreaId = plateAreaId;
		}

		public Integer getVehicleTypeId() {
		return vehicleTypeId;
		}

		public void setVehicleTypeId(Integer vehicleTypeId) {
		this.vehicleTypeId = vehicleTypeId;
		}

		public Integer getInsuranceTypeId() {
		return insuranceTypeId;
		}

		public void setInsuranceTypeId(Integer insuranceTypeId) {
		this.insuranceTypeId = insuranceTypeId;
		}

		public Integer getMrp() {
		return mrp;
		}

		public void setMrp(Integer mrp) {
		this.mrp = mrp;
		}

		public Integer getPriceUppingId() {
		return priceUppingId;
		}

		public void setPriceUppingId(Integer priceUppingId) {
		this.priceUppingId = priceUppingId;
		}

		public Integer getMrpWithUpping() {
		return mrpWithUpping;
		}

		public void setMrpWithUpping(Integer mrpWithUpping) {
		this.mrpWithUpping = mrpWithUpping;
		}

		public Integer getOlxMrp() {
		return olxMrp;
		}

		public void setOlxMrp(Integer olxMrp) {
		this.olxMrp = olxMrp;
		}

		public Integer getTenure() {
		return tenure;
		}

		public void setTenure(Integer tenure) {
		this.tenure = tenure;
		}

		public String getLoanNeeded() {
		return loanNeeded;
		}

		public void setLoanNeeded(String loanNeeded) {
		this.loanNeeded = loanNeeded;
		}

		public Integer getActualDpPer() {
		return actualDpPer;
		}

		public void setActualDpPer(Integer actualDpPer) {
		this.actualDpPer = actualDpPer;
		}

		public Integer getUserId() {
		return userId;
		}

		public void setUserId(Integer userId) {
		this.userId = userId;
		}

		public String getUserType() {
		return userType;
		}

		public void setUserType(String userType) {
		this.userType = userType;
		}

		public String getOccupation() {
		return occupation;
		}

		public void setOccupation(String occupation) {
		this.occupation = occupation;
		}

		public Double getInsurancePer() {
		return insurancePer;
		}

		public void setInsurancePer(Double insurancePer) {
		this.insurancePer = insurancePer;
		}

		public Integer getInsuranceAmount() {
		return insuranceAmount;
		}

		public void setInsuranceAmount(Integer insuranceAmount) {
		this.insuranceAmount = insuranceAmount;
		}

		public List<Object> getLoadingFee() {
		return loadingFee;
		}

		public void setLoadingFee(List<Object> loadingFee) {
		this.loadingFee = loadingFee;
		}

		public List<Depreciation> getDepreciation() {
		return depreciation;
		}

		public void setDepreciation(List<Depreciation> depreciation) {
		this.depreciation = depreciation;
		}

		public Integer getInsuranceOnLoan() {
		return insuranceOnLoan;
		}

		public void setInsuranceOnLoan(Integer insuranceOnLoan) {
		this.insuranceOnLoan = insuranceOnLoan;
		}

		public Integer getInsuranceOnLoanPer() {
		return insuranceOnLoanPer;
		}

		public void setInsuranceOnLoanPer(Integer insuranceOnLoanPer) {
		this.insuranceOnLoanPer = insuranceOnLoanPer;
		}

		public Integer getInsuranceInCashPer() {
		return insuranceInCashPer;
		}

		public void setInsuranceInCashPer(Integer insuranceInCashPer) {
		this.insuranceInCashPer = insuranceInCashPer;
		}

		public Integer getInsuranceInCash() {
		return insuranceInCash;
		}

		public void setInsuranceInCash(Integer insuranceInCash) {
		this.insuranceInCash = insuranceInCash;
		}

		public Integer getInsuranceIncome() {
		return insuranceIncome;
		}

		public void setInsuranceIncome(Integer insuranceIncome) {
		this.insuranceIncome = insuranceIncome;
		}

		public Integer getDpAmount() {
		return dpAmount;
		}

		public void setDpAmount(Integer dpAmount) {
		this.dpAmount = dpAmount;
		}

		public Double getDpPer() {
		return dpPer;
		}

		public void setDpPer(Double dpPer) {
		this.dpPer = dpPer;
		}

		public Integer getLtvPer() {
		return ltvPer;
		}

		public void setLtvPer(Integer ltvPer) {
		this.ltvPer = ltvPer;
		}

		public Integer getLtvMaxPer() {
		return ltvMaxPer;
		}

		public void setLtvMaxPer(Integer ltvMaxPer) {
		this.ltvMaxPer = ltvMaxPer;
		}

		public Integer getPrincipalAmount() {
		return principalAmount;
		}

		public void setPrincipalAmount(Integer principalAmount) {
		this.principalAmount = principalAmount;
		}

		public Integer getTotalLoanAmount() {
		return totalLoanAmount;
		}

		public void setTotalLoanAmount(Integer totalLoanAmount) {
		this.totalLoanAmount = totalLoanAmount;
		}

		public Integer getProvisionalPer() {
		return provisionalPer;
		}

		public void setProvisionalPer(Integer provisionalPer) {
		this.provisionalPer = provisionalPer;
		}

		public Integer getProvisionalFee() {
		return provisionalFee;
		}

		public void setProvisionalFee(Integer provisionalFee) {
		this.provisionalFee = provisionalFee;
		}

		public Integer getProvisionInCash() {
		return provisionInCash;
		}

		public void setProvisionInCash(Integer provisionInCash) {
		this.provisionInCash = provisionInCash;
		}

		public Integer getProvisionOnLoan() {
		return provisionOnLoan;
		}

		public void setProvisionOnLoan(Integer provisionOnLoan) {
		this.provisionOnLoan = provisionOnLoan;
		}

		public Integer getProvisionInCashPer() {
		return provisionInCashPer;
		}

		public void setProvisionInCashPer(Integer provisionInCashPer) {
		this.provisionInCashPer = provisionInCashPer;
		}

		public Double getInterestRate() {
		return interestRate;
		}

		public void setInterestRate(Double interestRate) {
		this.interestRate = interestRate;
		}

		public Integer getReducingRate() {
		return reducingRate;
		}

		public void setReducingRate(Integer reducingRate) {
		this.reducingRate = reducingRate;
		}

		public Integer getInterestAmount() {
		return interestAmount;
		}

		public void setInterestAmount(Integer interestAmount) {
		this.interestAmount = interestAmount;
		}

		public Integer getInstallment() {
		return installment;
		}

		public void setInstallment(Integer installment) {
		this.installment = installment;
		}

		public Integer getAdminFee() {
		return adminFee;
		}

		public void setAdminFee(Integer adminFee) {
		this.adminFee = adminFee;
		}

		public Integer getAdminFeeOnLoan() {
		return adminFeeOnLoan;
		}

		public void setAdminFeeOnLoan(Integer adminFeeOnLoan) {
		this.adminFeeOnLoan = adminFeeOnLoan;
		}

		public Integer getAdminFeeInCash() {
		return adminFeeInCash;
		}

		public void setAdminFeeInCash(Integer adminFeeInCash) {
		this.adminFeeInCash = adminFeeInCash;
		}

		public Integer getLegalFee() {
		return legalFee;
		}

		public void setLegalFee(Integer legalFee) {
		this.legalFee = legalFee;
		}

		public Integer getTotalDp() {
		return totalDp;
		}

		public void setTotalDp(Integer totalDp) {
		this.totalDp = totalDp;
		}

		public Integer getDisbursement() {
		return disbursement;
		}

		public void setDisbursement(Integer disbursement) {
		this.disbursement = disbursement;
		}

		public Integer getAssistantFee() {
		return assistantFee;
		}

		public void setAssistantFee(Integer assistantFee) {
		this.assistantFee = assistantFee;
		}

		public Integer getPalpAmountCash() {
		return palpAmountCash;
		}

		public void setPalpAmountCash(Integer palpAmountCash) {
		this.palpAmountCash = palpAmountCash;
		}

		public Integer getCprPer() {
		return cprPer;
		}

		public void setCprPer(Integer cprPer) {
		this.cprPer = cprPer;
		}

		public Integer getCprFee() {
		return cprFee;
		}

		public void setCprFee(Integer cprFee) {
		this.cprFee = cprFee;
		}

		public Integer getInstallment2nd() {
		return installment2nd;
		}

		public void setInstallment2nd(Integer installment2nd) {
		this.installment2nd = installment2nd;
		}

		public Integer getMaxNtf() {
		return maxNtf;
		}

		public void setMaxNtf(Integer maxNtf) {
		this.maxNtf = maxNtf;
		}

		public Integer getLifeInsuranceAmount() {
		return lifeInsuranceAmount;
		}

		public void setLifeInsuranceAmount(Integer lifeInsuranceAmount) {
		this.lifeInsuranceAmount = lifeInsuranceAmount;
		}

		public Integer getTmpData() {
		return tmpData;
		}

		public void setTmpData(Integer tmpData) {
		this.tmpData = tmpData;
		}

		public Integer getAdminFeeInsurance() {
		return adminFeeInsurance;
		}

		public void setAdminFeeInsurance(Integer adminFeeInsurance) {
		this.adminFeeInsurance = adminFeeInsurance;
		}

		public String getPaymentType() {
		return paymentType;
		}

		public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
		}

		public Integer getAdditionalFee() {
		return additionalFee;
		}

		public void setAdditionalFee(Integer additionalFee) {
		this.additionalFee = additionalFee;
		}

		public Integer getBoosterScheme() {
		return boosterScheme;
		}

		public void setBoosterScheme(Integer boosterScheme) {
		this.boosterScheme = boosterScheme;
		}

		public Integer getIsDeviation() {
		return isDeviation;
		}

		public void setIsDeviation(Integer isDeviation) {
		this.isDeviation = isDeviation;
		}

		public Integer getDeviationPer() {
		return deviationPer;
		}

		public void setDeviationPer(Integer deviationPer) {
		this.deviationPer = deviationPer;
		}

		public Integer getRefundOnInsurance() {
		return refundOnInsurance;
		}

		public void setRefundOnInsurance(Integer refundOnInsurance) {
		this.refundOnInsurance = refundOnInsurance;
		}

		public Integer getInterestIncomeForRefund() {
		return interestIncomeForRefund;
		}

		public void setInterestIncomeForRefund(Integer interestIncomeForRefund) {
		this.interestIncomeForRefund = interestIncomeForRefund;
		}

		public String getMinIncomeForOto() {
		return minIncomeForOto;
		}

		public void setMinIncomeForOto(String minIncomeForOto) {
		this.minIncomeForOto = minIncomeForOto;
		}

		public Integer getRefundOnInterest() {
		return refundOnInterest;
		}

		public void setRefundOnInterest(Integer refundOnInterest) {
		this.refundOnInterest = refundOnInterest;
		}

		public Integer getRefundOnAdminFee() {
		return refundOnAdminFee;
		}

		public void setRefundOnAdminFee(Integer refundOnAdminFee) {
		this.refundOnAdminFee = refundOnAdminFee;
		}

		public Double getRefundOnProvision() {
		return refundOnProvision;
		}

		public void setRefundOnProvision(Double refundOnProvision) {
		this.refundOnProvision = refundOnProvision;
		}

		public Integer getTotalRefundToOto() {
		return totalRefundToOto;
		}

		public void setTotalRefundToOto(Integer totalRefundToOto) {
		this.totalRefundToOto = totalRefundToOto;
		}

		public Integer getRefundToOtoPer() {
		return refundToOtoPer;
		}

		public void setRefundToOtoPer(Integer refundToOtoPer) {
		this.refundToOtoPer = refundToOtoPer;
		}

		public Integer getTotalIncome() {
		return totalIncome;
		}

		public void setTotalIncome(Integer totalIncome) {
		this.totalIncome = totalIncome;
		}

		public Integer getRefundToDealerByRefund() {
		return refundToDealerByRefund;
		}

		public void setRefundToDealerByRefund(Integer refundToDealerByRefund) {
		this.refundToDealerByRefund = refundToDealerByRefund;
		}

		public Integer getRefundToDealerByOto() {
		return refundToDealerByOto;
		}

		public void setRefundToDealerByOto(Integer refundToDealerByOto) {
		this.refundToDealerByOto = refundToDealerByOto;
		}

		public Integer getActualRefundToDealer() {
		return actualRefundToDealer;
		}

		public void setActualRefundToDealer(Integer actualRefundToDealer) {
		this.actualRefundToDealer = actualRefundToDealer;
		}

		public Integer getTotalPaymentToDealer() {
		return totalPaymentToDealer;
		}

		public void setTotalPaymentToDealer(Integer totalPaymentToDealer) {
		this.totalPaymentToDealer = totalPaymentToDealer;
		}

		public Integer getDeviationAmount() {
		return deviationAmount;
		}

		public void setDeviationAmount(Integer deviationAmount) {
		this.deviationAmount = deviationAmount;
		}

		public Integer getRewardPrice() {
		return rewardPrice;
		}

		public void setRewardPrice(Integer rewardPrice) {
		this.rewardPrice = rewardPrice;
		}

		public Integer getRefundInsuranceRate() {
		return refundInsuranceRate;
		}

		public void setRefundInsuranceRate(Integer refundInsuranceRate) {
		this.refundInsuranceRate = refundInsuranceRate;
		}

		public Integer getRefundRate() {
		return refundRate;
		}

		public void setRefundRate(Integer refundRate) {
		this.refundRate = refundRate;
		}

		public Integer getRefundAmount() {
		return refundAmount;
		}

		public void setRefundAmount(Integer refundAmount) {
		this.refundAmount = refundAmount;
		}

		public Integer getTotalRefundToOtoBeforeCt() {
		return totalRefundToOtoBeforeCt;
		}

		public void setTotalRefundToOtoBeforeCt(Integer totalRefundToOtoBeforeCt) {
		this.totalRefundToOtoBeforeCt = totalRefundToOtoBeforeCt;
		}

		public Integer getRefundOnInterestPer() {
		return refundOnInterestPer;
		}

		public void setRefundOnInterestPer(Integer refundOnInterestPer) {
		this.refundOnInterestPer = refundOnInterestPer;
		}

		public Integer getRefundOnProvisionPer() {
		return refundOnProvisionPer;
		}

		public void setRefundOnProvisionPer(Integer refundOnProvisionPer) {
		this.refundOnProvisionPer = refundOnProvisionPer;
		}

		public Integer getRefundOnInsurancePer() {
		return refundOnInsurancePer;
		}

		public void setRefundOnInsurancePer(Integer refundOnInsurancePer) {
		this.refundOnInsurancePer = refundOnInsurancePer;
		}

		public Integer getRefundTaxPer() {
		return refundTaxPer;
		}

		public void setRefundTaxPer(Integer refundTaxPer) {
		this.refundTaxPer = refundTaxPer;
		}

		public Double getRefundTax() {
		return refundTax;
		}

		public void setRefundTax(Double refundTax) {
		this.refundTax = refundTax;
		}

		public Double getRefundAfterTax() {
		return refundAfterTax;
		}

		public void setRefundAfterTax(Double refundAfterTax) {
		this.refundAfterTax = refundAfterTax;
		}

		public Integer getRefundOnAdminPer() {
		return refundOnAdminPer;
		}

		public void setRefundOnAdminPer(Integer refundOnAdminPer) {
		this.refundOnAdminPer = refundOnAdminPer;
		}

		public Integer getRefundInsuranceAfterTax() {
		return refundInsuranceAfterTax;
		}

		public void setRefundInsuranceAfterTax(Integer refundInsuranceAfterTax) {
		this.refundInsuranceAfterTax = refundInsuranceAfterTax;
		}

		public String getUpdatedLoanNeeded() {
		return updatedLoanNeeded;
		}

		public void setUpdatedLoanNeeded(String updatedLoanNeeded) {
		this.updatedLoanNeeded = updatedLoanNeeded;
		}

		}
