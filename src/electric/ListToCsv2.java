package electric;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.List;


public class ListToCsv2 {

    public  File createCSVFile(List<OutputCsv2> exportData,
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

            csvFileOutputStream = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(csvFile), "GB2312"), 1024);

            for (Iterator<OutputCsv2> iterator = exportData.iterator(); iterator.hasNext();) {

            	OutputCsv2 csv2 = iterator.next();
            	String eid = csv2.getEid();
            	csvFileOutputStream.write(eid);
            	csvFileOutputStream.write(",");

            	String date = csv2.getDate();
            	csvFileOutputStream.write(date);
            	csvFileOutputStream.write(",");

            	Integer usebyday = csv2.getUsebyday();
            	csvFileOutputStream.write(usebyday);
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