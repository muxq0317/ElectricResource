package electric;

public class OutputCsv1 {

	/** 电表id **/
	private String eid;
	/** 日期 **/
	private String date;
	/** 时间 **/
	private String time;
	/** 30分钟使用量 **/
	private Integer use30;

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

    public Integer getUse30() {
        return use30;
    }
    public void setUse30(Integer use30) {
        this.use30 = use30;
    }
/**
    @Override
    public String toString() {
        return roomid.toString();
    }
    **/
}
