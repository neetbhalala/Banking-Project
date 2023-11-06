package com.example.Banking.Project.Controller;

import com.example.Banking.Project.Model.Account;
import com.example.Banking.Project.Model.Dto.TransferDto;
import com.example.Banking.Project.Model.Dto.WithdrawDto;
import com.example.Banking.Project.Service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/addaccount")
    private Account addaccount(@RequestBody Account a) {
        return accountService.addaccount(a);
    }

    @GetMapping("/getaccount")
    private List<Account> getaccount() {
        return accountService.getaccount();
    }

    @PutMapping("/deposit")
    private Double deposit(@RequestParam String accountNumber, @RequestParam Double balance) {
        return accountService.deposit(accountNumber, balance);
    }

    @PutMapping("/withdraw")
    private WithdrawDto withdraw(@RequestParam String accountNumber, @RequestParam Double balance) {
        return  accountService.withdraw(accountNumber, balance);
    }

    @PutMapping("/transfer")
    private TransferDto transfer(@RequestParam String sender, @RequestParam double balance, @RequestParam String receiver) {
        return accountService.transfer(sender,balance,receiver);
    }

    @DeleteMapping("/delete")
    private String delete(@RequestParam Long id) {
        accountService.delete(id);
        return "deleted";
    }
}
