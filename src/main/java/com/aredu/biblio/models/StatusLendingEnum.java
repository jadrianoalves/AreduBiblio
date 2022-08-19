package com.aredu.biblio.models;

public enum StatusLendingEnum {

    BORROWED(1), RETURNED(0);

    public int statusLending;

    StatusLendingEnum(int value){
        statusLending = value;
    }

}
