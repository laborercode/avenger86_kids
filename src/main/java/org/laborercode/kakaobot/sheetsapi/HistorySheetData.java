package org.laborercode.kakaobot.sheetsapi;

import java.util.List;

public class HistorySheetData {
    private String range;
    private String majorDimension;
    private List<String[]> values;

    public HistorySheetData() {
    }

    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }

    public String getMajorDimension() {
        return majorDimension;
    }

    public void setMajorDimension(String majorDimension) {
        this.majorDimension = majorDimension;
    }

    public List<String[]> getValues() {
        return values;
    }

    public void setValues(List<String[]> values) {
        this.values = values;
    }
}
