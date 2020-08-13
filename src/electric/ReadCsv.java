package electric;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class ReadCsv {

    /**

    * @param inpath csv文件存储路径

    * @return 返回List<taskRule>对象

    */

    public static List<InputCsv> readCsv(String inpath) {

    List<InputCsv> list = new ArrayList<InputCsv>(); // 保存读取到的CSV数据

    try {
        File file = new File(inpath); // 判断文件是否存在
        if (file.exists())  {
            BufferedReader reader = new BufferedReader(new FileReader(inpath)); // 读取CSV文件
            String line = null;// 循环读取每行
            while ((line = reader.readLine()) != null) {
                String[] row = line.split("\\|", -1);
                String[] rows=row[0].split(",");
                InputCsv infos = new InputCsv();
                infos.setEid(rows[0]);
                infos.setDate(rows[1]);
                infos.setTime(rows[2]);
                infos.setNum(Integer.parseInt(rows[3]));
                list.add(infos);
            }
        }
    } catch (Exception e) {
    e.printStackTrace();
    }
    return list;
    }

    //csvtoList
    public static List<InputCsv> csvtoList(String fileurl){
        String inpath=fileurl;
        List<InputCsv> list=ReadCsv.readCsv(inpath);
        if(list.size()>0) {
            return list;
        }
        return null;
    }

    //main
    public static void main(String[] args) {
    	List<InputCsv> list = csvtoList("D:\\muxq\\111.csv");

    	//sort
    	List<InputCsv> collect=list.stream().sorted(
    			Comparator.comparing(InputCsv::getEid).
    			thenComparing(InputCsv::getDate).
    			thenComparing(InputCsv::getTime)).
    			collect(Collectors.toList());

    	//csv1
    	List<OutputCsv1> outputcsv1 = new ArrayList<OutputCsv1>();
    	for(int i=1;i<=collect.size()-1;i++) {
    		OutputCsv1 csv1 = new OutputCsv1();
    		csv1.setEid(collect.get(i).getEid());
    		csv1.setDate(collect.get(i).getDate());
    		csv1.setTime(collect.get(i).getTime());
    		csv1.setUse30(collect.get(i).getNum()-collect.get(i-1).getNum());
    		outputcsv1.add(csv1);

    	}

    	//csv2
    	Map<String, Map<String, IntSummaryStatistics>> group =
    			outputcsv1.stream().collect(
    					Collectors.groupingBy(OutputCsv1::getEid,
    							Collectors.groupingBy(OutputCsv1::getDate,
    									Collectors.summarizingInt(OutputCsv1::getUse30))));


    	List<OutputCsv2> outputcsv2 = new ArrayList<OutputCsv2>();
    	for (String eid : group.keySet()) {
    		  for (String date : group.get(eid).keySet()) {

    		           Integer sum = (int) group.get(eid).get(date).getSum();
    		           OutputCsv2 csv2 = new OutputCsv2();
    		           csv2.setEid(eid);
    		           csv2.setDate(date);
    		           csv2.setUsebyday(sum);
    		           outputcsv2.add(csv2);
    		  }
    	}
//    	System.out.println(group);
    	for(OutputCsv1 t:outputcsv1) {
		System.out.println(t.getEid()+','+t.getDate()+','+t.getTime()+','+t.getUse30());
		}
    	System.out.println("=====================================");
    	for(OutputCsv2 t:outputcsv2) {
		System.out.println(t.getEid()+','+t.getDate()+','+t.getUsebyday());
		}

    	ListToCsv1 csv1=new ListToCsv1();
    	ListToCsv2 csv2=new ListToCsv2();

    	csv1.createCSVFile( outputcsv1, "D:\\muxq\\", "outputcsv1.csv");
    	csv2.createCSVFile( outputcsv2, "D:\\muxq\\", "outputcsv2.csv");
    }
}
