import java.util.ArrayList;
import java.util.List;

public class CalculateServiceImp implements CaculateServiceInterface {

    private static final int MAX_LOAN = 15000;
    private static final int MIN_LOAN = 1000;
    private static final int INCREMENT = 100;
    private static final int TERM = 36;

    private LoanCalculorInterface loanCalculator;
    private LendersDAO lendersDAO;

    public CalculateServiceImp(LendersDAO lendersDAO) {
        this.lendersDAO = lendersDAO;
    }

    public LendersDAO getLendersDAO() {
        return lendersDAO;
    }

    public void setLendersDAO(LendersDAO lendersDAO) {
        this.lendersDAO = lendersDAO;
    }

    @Override
    public void quote(int loanAmount) {

        if(isValidAmount(loanAmount) && hasSufficientFund(loanAmount) ){

        }

    }

    @Override
    public String generateInfo() {
        return null;
    }

    @Override
    public boolean hasSufficientFund(int loanAmount) {
        if(isValidAmount(loanAmount)){
            return loanAmount <= getLendersDAO().getTotalAvailableAmount();
        }
        return false;
    }

    @Override
    public boolean isValidAmount(int loanAmount) {
        return loanAmount%INCREMENT==0 && loanAmount <= MAX_LOAN && loanAmount >= MIN_LOAN?true:false;
    }

    public List<LenderDTO> getLoan(int loanAmount){

        int leftAmount = loanAmount;
        ArrayList<LenderDTO> lenders = new ArrayList<LenderDTO>();
        for(LenderDTO lender :lendersDAO.getAllLenderList()){
            if(leftAmount > 0){
                lenders.add(lender);
                if(leftAmount > lender.getAvailableFund()){
                    leftAmount = leftAmount-lender.getAvailableFund();
                    lender.setAvailableFund(0);
                }else{
                    lender.setAvailableFund(lender.getAvailableFund()-leftAmount);
                    leftAmount = 0;
                    break;
                }
            }
        }
        return lenders;
    }

    public DisplayDTO GetDisplayDTO(List<LenderDTO> lenders){
        DisplayDTO displayDTO = new DisplayDTO();

        return displayDTO;
    }

}
