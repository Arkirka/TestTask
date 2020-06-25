package ru.vorobyov;

import java.io.*;

public class MyApp implements DataConnection {

    private String y;
    private int count = 0;
    private int count1 = 1;
    protected int startYear = 1990;
    protected int endYear = 2020;

    public static void main(String[] args) {
        new MyApp().run();
    }

    public void run() {
        try {
            int sum = 0;

            System.out.println("app v.1.14");
            for (int i = startYear; i < endYear; i++) {
                setY(i + "");
                sum = loadDatas(sum);

                double qq = sum > 0 ? (double) sum / (double) count : 0;

                if (qq > 0) {
                    System.out.println(i + " " + qq);
                }

                saveData(i, qq);
            }
            System.out.println("Finished!");
        } catch (IOException e) {
            System.out.println("Warning! Exception!");
            e.printStackTrace();
        }
    }


    public int loadDatas(int sum) throws IOException {
        File file = new File(new PropertiesValue().getInputFilePath());
        FileInputStream fis = new FileInputStream(file);

        String s = "";
        int i;
        int begin = 0;

        while ( (i = fis.read()) != -1) {
            s = s + new String(new byte[]{(byte) i});
        }

        while (true) {
            int e = s.indexOf("\n", begin + 1);
            if (e == -1) {
                break;
            }

            String ss = s.substring(begin, e);
            String[] sss = ss.split(" ");

            char c = sss[2].charAt(0);

            if(sss.length > 2)
                if (sss[1].contains(y)) {
                    sum = sum + Integer.parseInt(String.valueOf(c));
                }

            count++;
            begin = e;

        }
        return sum;
    }


    public void saveData(int year, double qq) throws IOException {
        File file = new File(new PropertiesValue().getOutputFilePath());
        FileOutputStream fis = new FileOutputStream(file, true);
        String s;

        s = count1 + " " + year + " " + qq + "\n";
        fis.write(s.getBytes());
        count1++;
    }


    public String getY() {
        return y;
    }

    public void setY(String y) {
        this.y = y;
    }
}
