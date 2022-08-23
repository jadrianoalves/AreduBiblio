package com.aredu.biblio.models;

public enum StatusLendingEnum {

    RETURNED(0), LOANED(1);

    public int statusLending;

    StatusLendingEnum(int value){
        statusLending = value;
    }

}
