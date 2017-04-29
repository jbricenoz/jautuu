package com.mcmcg.gbs.bluefin.pages.factory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.support.ui.Select;

import com.mcmcg.gbs.bluefin.pages.object.SalePage;

public class Sale {

	public static String getSaleTransactionTitle() {
		if (SalePage.lblPageTitle.isDisplayed()) {
			return SalePage.lblPageTitle.getText().toString();
		}
		return "Missing Title";
	}

	public static boolean cleanForm() throws InterruptedException {

		Map<String, Boolean> states = new HashMap<String, Boolean>();

		states.put("Basic", BasicInformation.clearTxtFields());
		states.put("Billing", BillingInformation.clearTxtFields());
		states.put("Card", CreditDebitCardInformation.clearTxtFields());

		Long count = states.values().stream().filter(s -> s == true).count();

		Thread.sleep(3000);
		return (count == 3) ? true : false;

	}

	protected static class BasicInformation {

		public static boolean setMerchantId(String merchantId) {
			if (SalePage.BasicInformation.txtMerchantID.isDisplayed()) {
				SalePage.BasicInformation.txtMerchantID.sendKeys(merchantId.toString().toLowerCase());
				return true;
			}
			return true;
		}

		public static boolean setAccountingPeriodforTransaction(int indexAccountingPeriodforTransaction) {
			Select AccountingPeriodforTransaction = new Select(
					SalePage.BasicInformation.ddlAccountingPeriodforTransaction);
			AccountingPeriodforTransaction.selectByIndex(indexAccountingPeriodforTransaction);
			return true;
		}

		public static boolean setLegalEntityApp(int indexLegalEntityApp) {
			Select LegalEntityApp = new Select(SalePage.BasicInformation.ddlLegalEntityApp);
			LegalEntityApp.selectByIndex(indexLegalEntityApp);
			return true;
		}

		public static boolean setlOrigin(int indexOrigin) {
			Select Origin = new Select(SalePage.BasicInformation.ddlOrigin);
			Origin.selectByIndex(indexOrigin);
			return true;
		}

		public static boolean setTextForTxtLatitudeDesk(String LatitudeDesk) {
			if (SalePage.BasicInformation.txtLatitudeDesk.isDisplayed()) {
				SalePage.BasicInformation.txtLatitudeDesk.sendKeys(LatitudeDesk.toLowerCase());
				return true;
			}
			return false;
		}

		public static boolean setTextForTxtAccountNumber(String AccountNumber) {
			if (SalePage.BasicInformation.txtAccountNumber.isDisplayed()) {
				SalePage.BasicInformation.txtAccountNumber.sendKeys(AccountNumber.toLowerCase());
				return true;
			}
			return false;
		}

		public static boolean clearTxtFields() throws InterruptedException {
			SalePage.BasicInformation.txtMerchantID.clear();
			SalePage.BasicInformation.txtAccountNumber.clear();
			return true;
		}
	}

	public static boolean setBasicInformation(String merchantId, int indexLegalEntityApp, String AccountNumber)
			throws InterruptedException {

		Map<String, Boolean> states = new HashMap<String, Boolean>();
		states.put("MerchanId", BasicInformation.setMerchantId(merchantId));
		// states.put("LatitudeDesk",
		// BasicInformation.setTextForTxtLatitudeDesk(LatitudeDesk));
		states.put("LegalEntityApp", BasicInformation.setLegalEntityApp(indexLegalEntityApp));
		// states.put("Origin", BasicInformation.setlOrigin(indexOrigin));
		states.put("AccountNumber", BasicInformation.setTextForTxtAccountNumber(AccountNumber));
		// states.put("AccountingPeriod",
		// BasicInformation.setAccountingPeriodforTransaction(indexAccountingPeriod));

		Long count = states.values().stream().filter(s -> s == true).count();

		Thread.sleep(1000);
		return (count == 3) ? true : false;
	}

	public static boolean setBasicInformation(String merchantId, int indexLegalEntityApp, int indexOrigin,
			String AccountNumber, int indexAccountingPeriod) throws InterruptedException {

		Map<String, Boolean> states = new HashMap<String, Boolean>();
		states.put("MerchanId", BasicInformation.setMerchantId(merchantId));
		states.put("LegalEntityApp", BasicInformation.setLegalEntityApp(indexLegalEntityApp));
		states.put("Origin", BasicInformation.setlOrigin(indexOrigin));
		states.put("AccountNumber", BasicInformation.setTextForTxtAccountNumber(AccountNumber));
		states.put("AccountingPeriod", BasicInformation.setAccountingPeriodforTransaction(indexAccountingPeriod));

		int count = Collections.frequency(new ArrayList<Boolean>(states.values()), true);

		Thread.sleep(1000);
		return (count == 5) ? true : false;
	}

	protected static class BillingInformation {

		public static boolean setFirstName(String firstName) {
			if (SalePage.BillingInformation.txtFirstName.isDisplayed()) {
				SalePage.BillingInformation.txtFirstName.sendKeys(firstName.toLowerCase());
				return true;
			}
			return false;
		}

		public static boolean setLastName(String lastName) {
			if (SalePage.BillingInformation.txtLastName.isDisplayed()) {
				SalePage.BillingInformation.txtLastName.sendKeys(lastName.toLowerCase());
				return true;
			}
			return false;
		}

		public static boolean setEmail(String email) {
			if (SalePage.BillingInformation.txtEmail.isDisplayed()) {
				SalePage.BillingInformation.txtEmail.sendKeys(email.toLowerCase());
				return true;
			}
			return false;
		}

		public static boolean setCity(String city) {
			if (SalePage.BillingInformation.txtCity.isDisplayed()) {
				SalePage.BillingInformation.txtCity.sendKeys(city.toLowerCase());
				return true;
			}
			return false;
		}

		public static boolean setStreetAddress(String streetAddress) {
			if (SalePage.BillingInformation.txtStreetAddress.isDisplayed()) {
				SalePage.BillingInformation.txtStreetAddress.sendKeys(streetAddress.toLowerCase());
				return true;
			}
			return false;
		}

		public static boolean setStateProvince(String state) {
			if (SalePage.BillingInformation.txtState.isDisplayed()) {
				SalePage.BillingInformation.txtState.sendKeys(state.toString().toLowerCase());
				return true;
			}
			return false;
		}

		public static boolean setZipPostalCode(String zipCode) {
			if (SalePage.BillingInformation.txtPostalCode.isDisplayed()) {
				SalePage.BillingInformation.txtPostalCode.sendKeys(zipCode.toLowerCase());
				return true;
			}
			return false;
		}

		public static boolean setCountry(int indexCountry) {
			Select Country = new Select(SalePage.BillingInformation.ddlCountry);
			Country.selectByIndex(indexCountry);
			return true;
		}

		public static boolean clearTxtFields() {
			SalePage.BillingInformation.txtFirstName.clear();
			SalePage.BillingInformation.txtLastName.clear();
			SalePage.BillingInformation.txtEmail.clear();
			SalePage.BillingInformation.txtState.clear();
			SalePage.BillingInformation.txtStreetAddress.clear();
			SalePage.BillingInformation.txtCity.clear();
			SalePage.BillingInformation.txtPostalCode.clear();
			return true;
		}

	}

	public static boolean setBillingInformation(String firstName, String lastName, String email, String streetAddress,
			String city, String state, String zipCode, int indexCountry) throws InterruptedException {

		Map<String, Boolean> states = new HashMap<String, Boolean>();
		states.put("FirstName", BillingInformation.setFirstName(firstName));
		states.put("LastName", BillingInformation.setLastName(lastName));
		states.put("Email", BillingInformation.setEmail(email));
		states.put("StreetAddress", BillingInformation.setStreetAddress(streetAddress));
		states.put("City", BillingInformation.setCity(city));
		states.put("StateProvince", BillingInformation.setStateProvince(state));
		states.put("zipCode", BillingInformation.setZipPostalCode(zipCode));
		states.put("Country", BillingInformation.setCountry(indexCountry));

		Long count = states.values().stream().filter(s -> s == true).count();

		Thread.sleep(1000);
		return (count == 8) ? true : false;
	}

	protected static class CreditDebitCardInformation {

		public static boolean setCardNumber(String cardNumber) {
			if (SalePage.CreditDebitCardInformation.txtCard.isDisplayed()) {
				SalePage.CreditDebitCardInformation.txtCard.sendKeys(cardNumber.toLowerCase());
				return true;
			}
			return false;
		}

		public static boolean setExpirationDate(String expirationDate) {
			if (SalePage.CreditDebitCardInformation.txtExpirationDate.isDisplayed()) {
				SalePage.CreditDebitCardInformation.txtExpirationDate.sendKeys(expirationDate.toLowerCase());
				return true;
			}
			return false;
		}

		public static boolean setCurrency(int indexCurrency) {
			Select Currency = new Select(SalePage.CreditDebitCardInformation.ddlCurrency);
			Currency.selectByIndex(indexCurrency);
			return true;
		}

		public static boolean setAmount(String amount) {
			if (SalePage.CreditDebitCardInformation.txtAmount.isDisplayed()) {
				SalePage.CreditDebitCardInformation.txtAmount.sendKeys(amount.toLowerCase());
				return true;
			}
			return false;
		}

		public static boolean setCVV(String cvv) {
			if (SalePage.CreditDebitCardInformation.txtCVV.isDisplayed()) {
				SalePage.CreditDebitCardInformation.txtCVV.sendKeys(cvv.toLowerCase());
				return true;
			}
			return false;
		}

		public static boolean clearTxtFields() throws InterruptedException {
			SalePage.CreditDebitCardInformation.txtCard.clear();
			SalePage.CreditDebitCardInformation.txtAmount.clear();
			SalePage.CreditDebitCardInformation.txtCVV.clear();
			Thread.sleep(1000);
			return true;
		}

	}

	public static boolean setCreditDebitCardInformation(String cardNumber, String expirationDate, int indexCurrency,
			String amount, String cvv) throws InterruptedException {

		Map<String, Boolean> states = new HashMap<String, Boolean>();
		states.put("cardNumber", CreditDebitCardInformation.setCardNumber(cardNumber));
		states.put("expirationDate", CreditDebitCardInformation.setExpirationDate(expirationDate));
		states.put("indexCurrency", CreditDebitCardInformation.setCurrency(indexCurrency));
		states.put("amount", CreditDebitCardInformation.setAmount(amount));
		states.put("cvv", CreditDebitCardInformation.setCVV(cvv));

		Long count = states.values().stream().filter(s -> s == true).count();

		Thread.sleep(1000);
		return (count == 5) ? true : false;
	}

	public static boolean submit() {
		if (SalePage.btnSubmit.isEnabled()) {
			SalePage.btnSubmit.click();
			return true;
		}
		return false;
	}
}
