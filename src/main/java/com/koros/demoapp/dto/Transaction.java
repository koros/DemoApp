package com.koros.demoapp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Map;

@Data
public class Transaction {

    private String id;

    private String accountid;

    private String counterpartyAccount;

    private String counterpartyName;

    private String counterPartyLogoPath;

    private Double instructedAmount;

    private String instructedCurrency;

    private Double transactionAmount;

    private String transactionCurrency;

    private String transactionType;

    private String description;

    @SuppressWarnings("unchecked")
    @JsonProperty("this_account")
    private void unpackThisAccount(Map<String,Object> this_account) {
        this.accountid = (String)this_account.get("id");
    }

    @SuppressWarnings("unchecked")
    @JsonProperty("other_account")
    private void unpackOtherAccount(Map<String,Object> other_account) {
        this.counterpartyAccount = (String)other_account.get("number");
        Map<String,String> holder = (Map<String,String>)other_account.get("holder");
        this.counterpartyName = holder.get("name");
        Map<String,String> metadata = (Map<String,String>)other_account.get("metadata");
        this.counterPartyLogoPath = metadata.get("image_URL");
    }

    @SuppressWarnings("unchecked")
    @JsonProperty("details")
    private void unpackDetails(Map<String,Object> details) {
        Map<String,String> value = (Map<String,String>)details.get("value");
        this.instructedAmount = Double.valueOf(value.get("amount"));
        this.transactionAmount = instructedAmount;

        this.instructedCurrency = value.get("currency");
        this.transactionCurrency = instructedCurrency;

        this.transactionType = (String) details.get("type");
        this.description = (String) details.get("description");
    }

}
