public class CalculateServiceImp implements CaculateServiceInterface {


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
        return loanAmount%1000==0?true:false;
    }
}
