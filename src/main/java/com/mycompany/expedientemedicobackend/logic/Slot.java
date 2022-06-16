package com.mycompany.expedientemedicobackend.logic;


public class Slot {
    
    private boolean checked;
    private int from;
    private int to;

    public Slot(boolean checked, int from, int to) {
        this.checked = checked;
        this.from = from;
        this.to = to;
    }

    public Slot() {
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public int getFrom() {
        return from;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public int getTo() {
        return to;
    }

    public void setTo(int to) {
        this.to = to;
    }
    
    
}
