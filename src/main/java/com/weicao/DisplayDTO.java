package com.weicao;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class DisplayDTO {

    private ArrayList<LenderDTO> lenders;
    private int requestAmount;
    private BigDecimal rate;
    private BigDecimal monthlyRepayment;
    private int terms;

    public ERROR getError() {
        return error;
    }

    public void setError(ERROR error) {
        this.error = error;
    }

    ERROR error;

    public int getTerms() {
        return terms;
    }

    public void setTerms(int terms) {
        this.terms = terms;
    }


    public ArrayList<LenderDTO> getLenders() {
        return lenders;
    }

    public void setLenders(ArrayList<LenderDTO> lenders) {
        this.lenders = lenders;
    }

    public int getRequestAmount() {
        return requestAmount;
    }

    public void setRequestAmount(int requestAmount) {
        this.requestAmount = requestAmount;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public BigDecimal getMonthlyRepayment() {
        return monthlyRepayment;
    }

    public void setMonthlyRepayment(BigDecimal monthlyRepayment) {
        this.monthlyRepayment = monthlyRepayment;
    }

    public BigDecimal getTotalRepayment() {
        return monthlyRepayment.multiply(new BigDecimal(terms));
    }


}
