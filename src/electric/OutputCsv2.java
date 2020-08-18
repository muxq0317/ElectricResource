package electric;

public class OutputCsv2 {

	/** 电表id **/
	private String eid;
	/** 日期 **/
	private String date;
	/** 日使用量 **/
	private Integer usebyday;

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

    public Integer getUsebyday() {
        return usebyday;
    }
    public void setUsebyday(Integer usebyday) {
        this.usebyday = usebyday;
    }
/**
    @Override
    public String toString() {
        return roomid.toString();
    }
    **/
}
