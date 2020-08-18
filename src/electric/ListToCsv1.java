package electric;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.List;


public class ListToCsv1 {

    public  File createCSVFile(List<OutputCsv1> exportData,
            String outPutPath, String filename) {

        File csvFile = null;
        BufferedWriter csvFileOutputStream = null;
        try {
            csvFile = new File(outPutPath + filename + ".csv");
            File parent = csvFile.getParentFile();
            if (parent != null && !parent.exists()) {
                parent.mkdirs();
            }
            csvFile.createNewFile();

            // GB2312 正确读取分隔符","
            csvFileOutputStream = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(csvFile), "GB2312"), 1024);

            // 写入文件内容
            for (Iterator<OutputCsv1> iterator = exportData.iterator(); iterator.hasNext();) {

            	OutputCsv1 csv1 = iterator.next();
            	String eid = csv1.getEid();
            	csvFileOutputStream.write(eid);
            	csvFileOutputStream.write(",");

            	String date = csv1.getDate();
            	csvFileOutputStream.write(date);
            	csvFileOutputStream.write(",");

            	String time = csv1.getTime();
            	csvFileOutputStream.write(time);
            	csvFileOutputStream.write(",");

            	Integer use30 = csv1.getUse30();
            	csvFileOutputStream.write(use30);
            	csvFileOutputStream.write("\n");
  //          	csvFileOutputStream.newLine();


           }
            csvFileOutputStream.flush();
        } catch (Exception e) {
           e.printStackTrace();
        } finally {
           try {
                csvFileOutputStream.close();
            } catch (IOException e) {
               e.printStackTrace();
           }
       }
        return csvFile;
    }
}