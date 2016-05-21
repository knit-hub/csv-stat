import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.bean.BeanToCsv;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.FileFilterUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Main {

    private static final String[] HEADER_INPUT = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l"};
    private static final String[] HEADER_OUTPUT = new String[]{"id", "b", "k"};
    private static final int ID_MAX = 15;

    public static void main(String[] args) {
        if (args.length <= 1) {
            System.out.println("file path required.");
            return;
        }

        final List<File> fileList = (List<File>) FileUtils.listFiles(new File(args[0])
                , FileFilterUtils.suffixFileFilter(".csv")
                , FileFilterUtils.trueFileFilter());

        final List<OutputCsvRow> output = new ArrayList<OutputCsvRow>();

        for (final File file : fileList) {
            if (isMatchArgs(file.getPath(), args[1])) {
                System.out.println(file.getPath());
                System.out.println(getIdByPath(file.getPath()));
                final List<InputCsvRow> input = readCsv(new File(file.getPath()));
                final InputCsv inputCsv = new InputCsv(input);
                final int id = getIdByPath(file.getPath());
                final float b = Collections.max(inputCsv.getColumB()) - Collections.min(inputCsv.getColumB());
                final float k = Collections.max(inputCsv.getColumK()) - Collections.min(inputCsv.getColumK());

                final OutputCsvRow outputRow = new OutputCsvRow(id, b, k);
                output.add(outputRow);
            }
        }

        writeCsv(output, "output.csv");
    }

    //Ç©Ç»ÇËñ≥óùÇ‚ÇËÉ}ÉbÉ`Ç∑ÇÈcsvÇÇ∆Ç¡ÇƒÇ¢ÇÈ
    private static boolean isMatchArgs(String path, String arg) {
        return path.contains(arg);
    }

    private static int getIdByPath(String path) {
        return Integer.parseInt(path.split("\\\\")[1]);
    }

    private static List<InputCsvRow> readCsv(File file) {
        try {
            CSVReader reader = new CSVReader(new InputStreamReader(new FileInputStream(file), "SJIS"), ',', '"', 1);
            ColumnPositionMappingStrategy<InputCsvRow> strat = new ColumnPositionMappingStrategy<InputCsvRow>();
            strat.setType(InputCsvRow.class);
            strat.setColumnMapping(HEADER_INPUT);
            CsvToBean<InputCsvRow> csv = new CsvToBean<InputCsvRow>();
            return csv.parse(strat, reader);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static void writeCsv(List<OutputCsvRow> list, String fileName) {
        CSVWriter csvWriter = null;
        try {
            csvWriter = new CSVWriter(new FileWriter(fileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        ColumnPositionMappingStrategy<OutputCsvRow> strat = new ColumnPositionMappingStrategy<OutputCsvRow>();
        strat.setType(OutputCsvRow.class);
        strat.setColumnMapping(HEADER_OUTPUT);
        BeanToCsv<OutputCsvRow> bc = new BeanToCsv<OutputCsvRow>();
        bc.write(strat, csvWriter, list);
        try {
            csvWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
