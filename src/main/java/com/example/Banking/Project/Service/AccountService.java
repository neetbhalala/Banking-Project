package com.example.Banking.Project.Service;

import com.example.Banking.Project.Model.Account;
import com.example.Banking.Project.Model.Dto.TransferDto;
import com.example.Banking.Project.Model.Dto.WithdrawDto;
import com.example.Banking.Project.Repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public Account addaccount(Account a) {
        return accountRepository.save(a);
    }

    public List<Account> getaccount() {
        return accountRepository.findAll();
    }

    public void delete(Long id) {
        accountRepository.deleteById(id);
    }

    public WithdrawDto withdraw(String accountNumber, Double balance) {
        Account a = accountRepository.findByAccountNumber(accountNumber);

        WithdrawDto wd = new WithdrawDto();

        double current_balance = a.getBalance();

        if(current_balance < balance) {
            wd.setCurrent_balance(current_balance);
            wd.setWithdraw(balance);
            wd.setAfter_withdraw(0.0);
            wd.setStatus("Insufficient Balance: \"NOT TRANSFER\" ");
            return wd;
        }
        double after_withdraw = current_balance - balance;
        a.setBalance(after_withdraw);
        accountRepository.save(a);

        wd.setCurrent_balance(current_balance);
        wd.setWithdraw(balance);
        wd.setAfter_withdraw(after_withdraw);
        wd.setStatus("\"WITHDRAW SUCCESS\" ");
        return wd;
    }

    public TransferDto transfer(String sender, double balance, String receiver) {
        Account s = accountRepository.findByAccountNumber(sender);
        Account r = accountRepository.findByAccountNumber(receiver);

        TransferDto td = new TransferDto();

        double s_balance = s.getBalance();
        double r_balance = r.getBalance();

        if(s_balance < balance) {
            td.setSendernum(s.getAccountNumber());
            td.setSenderbalance(s_balance);
            td.setAftersend(s_balance);
            td.setRecenum(r.getAccountNumber());
            td.setRecebalance(r_balance);
            td.setAfterrece(r_balance);

            td.setStatus("Unsuccessful Transfer!");
            return td;
        }
        s.setBalance(s_balance - balance);
        r.setBalance(r_balance + balance);

        accountRepository.save(s);
        accountRepository.save(r);

        td.setSendernum(s.getAccountNumber());
        td.setSenderbalance(s_balance);
        td.setAftersend(s_balance - balance);
        td.setRecenum(r.getAccountNumber());
        td.setRecebalance(r_balance);
        td.setAfterrece(r_balance + balance);

        td.setStatus("Successful Transfer!");
        return td;
    }

    public Double deposit(String accountNumber, Double balance) {
        Account a = accountRepository.findByAccountNumber(accountNumber);

        double current_balance = a.getBalance();
        double after_deposit = current_balance + balance;
        a.setBalance(after_deposit);
        accountRepository.save(a);
        return after_deposit;
    }
}
