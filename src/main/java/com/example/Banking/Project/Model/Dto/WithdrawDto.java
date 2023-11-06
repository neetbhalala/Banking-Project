package com.example.Banking.Project.Model.Dto;

import lombok.Data;

@Data
public class WithdrawDto {

    private double current_balance;
    private double withdraw;
    private double after_withdraw;
    private String status;
}
