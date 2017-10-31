public class RateCalculateSystem {


    private SourceProcessServiceInterface sourceProcessor;
    private CalculateServiceInterface calculatorService;
    private LendersDAO dataManager;
    private DisplayDTO displayDTO;

    private static String csvFileLocatoin = "src/main/resources/TestCSV";

    public RateCalculateSystem() {
        Initialise();
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        RateCalculateSystem rateCalculateSystem = new RateCalculateSystem();
        try{
            int requestAmount = Integer.parseInt(args[0]);
            rateCalculateSystem.quote(requestAmount);
            rateCalculateSystem.display();

            System.out.println(requestAmount);
        }catch ( NumberFormatException e){
            System.out.println("Please provide a valid integer number ");
        }




    }

    private void display() {
        //this.displayDTO.generateLoanInformation();
        this.displayDTO.displayLoanInfor();
    }

    private void quote(int requestAmount) {
         this.displayDTO = this.calculatorService.quote(requestAmount);
         return;
    }

    private void Initialise(){

        this.sourceProcessor = new CsvScourceProcessor();
        this.dataManager = sourceProcessor.readSource(csvFileLocatoin);

        LoanCalculatorInterface loanCalculator = new AmortizationCalculator();

        this.calculatorService = new CalculateServiceImp(dataManager, loanCalculator);
        this.displayDTO = null;

    }


}
