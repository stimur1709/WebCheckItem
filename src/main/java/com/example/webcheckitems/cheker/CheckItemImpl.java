package com.example.webcheckitems.cheker;

public class CheckItemImpl implements CheckItem {

    private final char startItem;
    private final char endItem;

    protected CheckItemImpl(char startItem, char endItem) {
        this.startItem = startItem;
        this.endItem = endItem;
    }

    @Override
    public boolean check(String text) {
        int openCount = 0;
        StringBuilder isInsideItem = new StringBuilder();
        char[] charArray = text.toCharArray();
        for (char c : charArray) {
            if (c == startItem) {
                openCount++;
                isInsideItem = new StringBuilder();
            } else if (c == endItem) {
                if (openCount == 0 || isInsideItem.toString().isBlank()) {
                    return false;
                } else {
                    openCount--;
                }
            } else {
                isInsideItem.append(c);
            }
        }
        return openCount == 0;
    }

}
