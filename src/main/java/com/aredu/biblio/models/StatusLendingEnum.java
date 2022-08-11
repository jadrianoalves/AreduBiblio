package com.aredu.biblio.models;

public enum StatusLendingEnum {

    AVALIABLE(1), NOT_AVALIABLE(0);

    public int statusLending;

    StatusLendingEnum(int value){
        statusLending = value;
    }

}
