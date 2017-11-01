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

    private boolean error;
    private boolean inValidAmount;
    private boolean sufficientAmount;

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

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }


    public BigDecimal getTotalRepayment() {
        return monthlyRepayment.multiply(new BigDecimal(terms));
    }

    public boolean isInValidAmount() {
        return inValidAmount;
    }

    public boolean isSufficientAmount() {
        return sufficientAmount;
    }

    public void setInvalidAmountError() {
        this.inValidAmount = true;
    }

    public void setSufficientAmountError() {
        this.sufficientAmount =true;
    }
}
