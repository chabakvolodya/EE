package com.goit.ee.mod_1;

import com.goit.ee.mod_1.api.Collector;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by Администратор on 26.03.2016.
 */
public class CollectorUtils {

    private static Map<String, Long> map;

    static void writeResult(List<Collector> collectors, int size) throws IOException {

        String fileName = "SpeedTest_Size_" + size + ".txt";
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName));) {

            bufferedWriter.write(String.format("+----------------------------------------------------[%10d ]---------------------------------------------------------+\n", size));
            bufferedWriter.write("+--------------------------------------------------------------------------------------------------------------------------+\n");


            for (Collector c : collectors) {

                map = c.getResults();

                bufferedWriter.write(String.format("| %-15s ", c.getNameCollector()));
                bufferedWriter.write(String.format("| %12.2f ", getValue("Add")));
                bufferedWriter.write(String.format("| %12.2f ", getValue("Get")));
                bufferedWriter.write(String.format("| %12.2f ", getValue("Remove")));
                bufferedWriter.write(String.format("| %12.2f ", getValue("Contains")));
                bufferedWriter.write(String.format("| %12.2f ", getValue("Populate")));
                bufferedWriter.write(String.format("| %12.2f ", getValue("Iter.Add")));
                bufferedWriter.write(String.format("| %12.2f |\n", getValue("Iter.Rem")));
            }

            bufferedWriter.write("+--------------------------------------------------------------------------------------------------------------------------+\n\n");

            bufferedWriter.flush();
            System.out.println("Write file size test: " + size);
        }
    }

    static double getValue(String str) {

        if (map.containsKey(str)) {
            return convertNSToMs(map.get(str));
        } else {
            return -1;
        }
    }

    static double convertNSToMs(Long input) {

        return Math.round(input / 1_000_000) ;
    }

}
