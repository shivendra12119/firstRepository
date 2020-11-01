package com.freefood.dto;

import com.freefood.entity.Account;
import com.freefood.entity.Person;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AccountDto {
    private Long balance;
    private Person accountHolder;

    public static AccountDto fromAccount(Account account){
        return AccountDto.builder()
                .balance(account.getBalance())
                .accountHolder(account.getAccountHolder())
                .build();
    }
}


