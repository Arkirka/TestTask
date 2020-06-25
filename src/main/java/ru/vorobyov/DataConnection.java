package ru.vorobyov;

import java.io.IOException;

public interface DataConnection {
    int loadDatas(int sum) throws Exception;
    void saveData(int year, double qq) throws IOException;
}
