package com.example

enum PhoneType {
    HOME("H", "Home"),
    MOBILE("M", "Mobile"),
    WORK("W", "Work"),

    final String id
    final String displayValue

    PhoneType(String id, String displayValue) {
        this.id = id
        this.displayValue = displayValue
    }
}