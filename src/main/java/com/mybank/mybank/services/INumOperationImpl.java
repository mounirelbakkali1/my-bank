package com.mybank.mybank.services;

import org.springframework.stereotype.Service;

@Service
public class INumOperationImpl implements INumOperation {

    private long numOperation =100; // intitial

    @Override
    public long generateNumOperation() {
        numOperation++;
        return numOperation;
    }
}
