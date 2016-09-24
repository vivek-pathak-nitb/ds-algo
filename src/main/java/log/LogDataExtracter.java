package log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by vivek.pathak on 17/09/15.
 */
public class LogDataExtracter {



    private static String TRANSACTION_ID = "";
    private static final String QUEUE = " \"Queue\" : {" +
            "    \"ID\" : 181" + "  },";

    public static void main(String[] args) {
        System.out.println(getData());
    }

    private static String getData() {

        final StringBuilder stringBuilder = new StringBuilder();

        try {
            File folder = new File("/Users/vivek.pathak/machhine 1/skynet-error.log");
            final FileInputStream fstream = new FileInputStream(folder);
            final BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            boolean flag = false;

            String strLine;
            while ((strLine = br.readLine()) != null) {
                if (strLine.contains("body {")) {
                    if (strLine.contains("HEADER_FLP_X_TRANSACTION_ID")) {
                        setTransactionId(strLine);
                    }
                    stringBuilder.append("{");

                    // start filling in data
                    while ((strLine = br.readLine()) != null) {
                        if (strLine.contains("PrimaryContact")) {
                            stringBuilder.append(strLine);
                            for (int i = 1; i <= 5; i++) {
                                stringBuilder.append(br.readLine());
                            }
                            flag = true;
                            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                            break;
                        } else if (strLine.contains("Queue")) {
                            appendQueue(stringBuilder, br);
                        } else {
                            stringBuilder.append(strLine);
                        }
                    }
                }

                if (flag) {
                    break;
                }
            }

            fstream.close();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }

        return stringBuilder.toString();
    }

    private static void appendQueue(final StringBuilder stringBuilder, final BufferedReader br) throws IOException {
        stringBuilder.append(QUEUE);
        for (int i = 1; i <= 2; i++) {
            br.readLine();
        }
    }

    private static void setTransactionId(String string) {
        int index1 = string.indexOf("HEADER_FLP_X_TRANSACTION_ID");
        string = string.substring(index1 + "HEADER_FLP_X_TRANSACTION_ID".length()+1);
        int index2 = string.indexOf("}");
        TRANSACTION_ID = string.substring(0, index2);
        System.out.println(TRANSACTION_ID);
    }
}
