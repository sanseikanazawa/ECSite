package com.internousdev.casablanca.action;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.casablanca.dao.MCategoryDAO;
import com.internousdev.casablanca.dto.MCategoryDTO;
import com.internousdev.casablanca.util.InputChecker;
import com.opensymphony.xwork2.ActionSupport;

public class CreateDestinationConfirmAction extends ActionSupport implements SessionAware {
	private String familyName;
	private String firstName;
	private String familyNameKana;
	private String firstNameKana;
	private String sex;
	private String email;
	private String telNumber;
	private String userAddress;
	private List<String> familyNameErrorMessageList;
	private List<String> firstNameErrorMessageList;
	private List<String> familyNameKanaErrorMessageList;
	private List<String> firstNameKanaErrorMessageList;
	private List<String> emailErrorMessageList;
	private List<String> telNumberErrorMessageList;
	private List<String> userAddressErrorMessageList;
	private Map<String,Object> session;

	public String execute(){
		String result=ERROR;
		if (familyName == null ||
			firstName == null ||
			familyNameKana == null ||
			firstNameKana == null ||
			email == null ||
			telNumber == null ||
			userAddress == null) {
		} else {
			if(Objects.equals(session.get("logined"),"1")){
				InputChecker inputChecker=new InputChecker();

				//フォームの内容をinputCheckerを使ってチェックする。
					familyNameErrorMessageList=inputChecker.doCheck("姓", familyName, 1, 16, true, true, true, false,false,false,false,false,false);
					firstNameErrorMessageList=inputChecker.doCheck("名", firstName, 1, 16, true, true, true, false,false,false,false,false,false);
					familyNameKanaErrorMessageList=inputChecker.doCheck("姓ふりがな", familyNameKana, 1, 16,false,false,true,false,false,false,false,false,false);
					firstNameKanaErrorMessageList=inputChecker.doCheck("名ふりがな", firstNameKana, 1, 16, false, false, true, false, false, false, false,false,false);
					userAddressErrorMessageList=inputChecker.doCheck("住所", userAddress, 15, 50, true, true, true, true,true,true,false,false,false);
					telNumberErrorMessageList=inputChecker.doCheck("電話番号", telNumber,10, 13, false, false, false, true, false, false, false,false,false);
					emailErrorMessageList=inputChecker.doCheck("メールアドレス", email, 14, 32, true, false, false, true, true,false,false,false,false);

					if(familyNameErrorMessageList.size()==0
				    && firstNameErrorMessageList.size()==0
				    && familyNameKanaErrorMessageList.size()==0
				    && firstNameKanaErrorMessageList.size()==0
				    && emailErrorMessageList.size()==0
				    && telNumberErrorMessageList.size()==0
				    && userAddressErrorMessageList.size()==0){
						result = SUCCESS;
					} else {
						result = INPUT;
					}
				} else {
					result = "timeout";
				}
		}
		if(!session.containsKey("mCategoryDtoList")) {
			MCategoryDAO mCategoryDAO=new MCategoryDAO();
			List<MCategoryDTO> mCategoryDtoList= mCategoryDAO.getMCategoryList();
			session.put("mCategoryDtoList", mCategoryDtoList);
		}
		return result;
	}

	public String getFamilyName(){
		return familyName;
	}

	public void setFamilyName(String familyName){
		this.familyName=familyName;
	}

	public String getFirstName(){
		return firstName;
	}

	public void setFirstName(String firstName){
		this.firstName=firstName;
	}

	public String getFamilyNameKana(){
		return familyNameKana;
	}

	public void setFamilyNameKana(String familyNameKana){
		this.familyNameKana=familyNameKana;
	}

	public String getFirstNameKana(){
		return firstNameKana;
	}

	public void setFirstNameKana(String firstNameKana){
		this.firstNameKana=firstNameKana;
	}

	public String getEmail(){
		return email;
	}

	public void setEmail(String email){
		this.email=email;
	}

	public String getTelNumber(){
		return telNumber;
	}

	public void setTelNumber(String telNumber){
		this.telNumber=telNumber;
	}

	public String getUserAddress(){
		return userAddress;
	}

	public void setUserAddress(String userAddress){
		this.userAddress=userAddress;
	}

	public String getSex(){
		return sex;
	}

	public void setSex(String sex){
		this.sex=sex;
	}

	public List<String> getFamilyNameErrorMessageList(){
		return familyNameErrorMessageList;
	}

	public List<String> getFirstNameErrorMessageList(){
		return firstNameErrorMessageList;
	}

	public List<String> getFamilyNameKanaErrorMessageList(){
		return familyNameKanaErrorMessageList;
	}

	public List<String> getFirstNameKanaErrorMessageList(){
		return firstNameKanaErrorMessageList;
	}

	public List<String> getEmailErrorMessageList(){
		return emailErrorMessageList;
	}

	public List<String> getTelNumberErrorMessageList(){
		return telNumberErrorMessageList;
	}

	public List<String> getUserAddressErrorMessageList(){
		return userAddressErrorMessageList;
	}

	public void setSession(Map<String,Object> session){
		this.session=session;
	}

}
