package Websample;

public class Account {
	private int RequestNumber;
	private String RequestOffice;
	private String RequestName;
	private String Inday;
	private String Outday;
	private String SalesPerson;
	private String CreatePerson;
	private String EditPerson;
	private String MemoBox;
	private String ProgressNumber;
	private String ProgressName;

	public int getRequestNumber(){
		return RequestNumber;
	}
	public void setRequestNumber(int RequestNumber){
		this.RequestNumber=RequestNumber;
	}
	public String getRequestName(){
		return RequestName;
	}
	public void setRequestName(String RequestName){
		this.RequestName = RequestName;
	}
	public String getRequestOffice(){
		return RequestOffice ;
	}
	public void setRequestOffice(String RequestOffice){
		this.RequestOffice = RequestOffice;
	}

	public String getInday(){
		return Inday ;
	}
	public void setInday(String Inday){
		this.Inday = Inday;
	}

	public String getOutday(){
		return Outday ;
	}
	public void setOutday(String Outday){
		this.Outday = Outday;
	}

	public String getSalesPerson(){
		return SalesPerson ;
	}
	public void setSalesPerson(String SalesPerson){
		this.SalesPerson = SalesPerson;
	}

	public String getCreatePerson(){
		return CreatePerson ;
	}
	public void setCreatePerson(String CreatePerson){
		this.CreatePerson = CreatePerson;
	}

	public String getEditPerson(){
		return EditPerson ;
	}
	public void setEditPerson(String EditPerson){
		this.EditPerson = EditPerson;
	}

	public String getMemoBox(){
		return MemoBox;
	}
	public void setMemoBox(String MemoBox){
		this.MemoBox = MemoBox;
	}

	public String getProgressNumber(){
		return ProgressNumber;
	}
	public void setProgressNumber(String ProgressNumber){
		this.ProgressNumber = ProgressNumber;
	}
	public String getProgressName(){
		return ProgressName;
	}
	public void setProgressName(String ProgressName){
		this.ProgressName = ProgressName;
	}

}
