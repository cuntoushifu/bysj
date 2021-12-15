package bean;

import java.util.Date;

/**
 * 
 * @instruction
 * 咨询记录 clientArchive ,对应的实体类
 */
public class ClientArchive {

	/**
	 * 咨询记录Id
	 */
	private Integer archivesId;
	
	/**
	 * 本次咨询的，来访者的id
	 */
	private Integer clientId;
	
	/**
	 * 本次咨询的，咨询师的id
	 */
	private Integer doctorId;
	
	/**
	 * 申请人(client)做的问卷 内容
	 */
	private String questionContext = "";
	
	
	/**
	 * 申请人主观描述
	 */
	private String clientDescription;
	
	/**
	 * 评测结果,等级分数
	 * 
	 */
	private Integer level;
	
	/**
	 * 申请时间
	 */
	private Date applyTime;
	
	/**
	 * 申请人期望的咨询地点，最终只是一个参考
	 */
	private String expectPlace = "";
	
	/**
	 * 申请人期望的咨询时间，最终只是一个参考
	 */
	private String expectTime = "";
	
	/**
	 * 咨询开始时间，几月几日几时
	 */
	private Date startDatetime;
	
	/**
	 * 咨询结束时间，几月几日几时
	 */
	private Date endDatetime;
	
	/**
	 * 咨询地点
	 */
	private String subPlace = "未定";
	
	/**
	 * -1 失败，0 申请中，1 通过申请但未完成，2完成咨询但未完善资料, 3全部完成
	 */
	private Integer status = 0;
	
	/**
	 * 一次咨询的记录文档
	 */
	private String docPath = "";
	
	/**
	 * 咨询师
	 */
	private Doctor doctor;
	
	/**
	 * 来访者
	 */
	private Client client;
	
	/**
	 * 回访记录内容
	 */
	private String secondQuestionContext = "";
	
	/**
	 * 是否回访，0否，1是
	 */
	private Integer isSecondDo = 0;

	public Integer getArchivesId() {
		return archivesId;
	}

	public void setArchivesId(Integer archivesId) {
		this.archivesId = archivesId;
	}

	public Integer getClientId() {
		return clientId;
	}

	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}

	public Integer getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(Integer doctorId) {
		this.doctorId = doctorId;
	}

	public String getQuestionContext() {
		return questionContext;
	}

	public void setQuestionContext(String questionContext) {
		this.questionContext = questionContext;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Date getApplyTime() {
		return applyTime;
	}

	public void setApplyTime(Date applyTime) {
		this.applyTime = applyTime;
	}

	public String getExpectPlace() {
		return expectPlace;
	}

	public void setExpectPlace(String expectPlace) {
		this.expectPlace = expectPlace;
	}

	public String getExpectTime() {
		return expectTime;
	}

	public void setExpectTime(String expectTime) {
		this.expectTime = expectTime;
	}

	public Date getStartDatetime() {
		return startDatetime;
	}

	public void setStartDatetime(Date startDatetime) {
		this.startDatetime = startDatetime;
	}

	public Date getEndDatetime() {
		return endDatetime;
	}

	public void setEndDatetime(Date endDatetime) {
		this.endDatetime = endDatetime;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getDocPath() {
		return docPath;
	}

	public void setDocPath(String doc_path) {
		this.docPath = doc_path;
	}

	public String getSecondQuestionContext() {
		return secondQuestionContext;
	}

	public void setSecondQuestionContext(String secondQuestionContext) {
		this.secondQuestionContext = secondQuestionContext;
	}

	public Integer getIsSecondDo() {
		return isSecondDo;
	}

	public void setIsSecondDo(Integer isSendDo) {
		this.isSecondDo = isSendDo;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public String getClientDescription() {
		return clientDescription;
	}

	public void setClientDescription(String clientDescription) {
		this.clientDescription = clientDescription;
	}

	public String getSubPlace() {
		return subPlace;
	}

	public void setSubPlace(String subPlace) {
		this.subPlace = subPlace;
	}
	
	
	
}
