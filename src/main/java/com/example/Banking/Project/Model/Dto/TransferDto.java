package com.example.Banking.Project.Model.Dto;

import lombok.Data;

@Data
public class TransferDto {

    //sender
    private String sendernum;
    private double senderbalance;
    private double aftersend;

    //receiver
    private String recenum;
    private double recebalance;
    private double afterrece;

    private String status;
}
