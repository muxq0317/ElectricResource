package electric;

public class InputCsv {

	/** 电表id **/
	private String eid;
	/** 日期 **/
	private String date;
	/** 时间 **/
	private String time;
	/** 指示数  **/
	private Integer num;

    public String getEid() {
        return eid;
    }
    public void setEid(String eid) {
        this.eid = eid;
    }

    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }
    public void setTime(String time) {
        this.time = time;
    }

    public Integer getNum() {
        return num;
    }
    public void setNum(Integer num) {
        this.num = num;
    }
/**
    @Override
    public String toString() {
        return roomid.toString();
    }
    **/
}
