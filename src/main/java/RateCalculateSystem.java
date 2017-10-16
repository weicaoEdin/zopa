public class RateCalculateSystem {


    private SourceProcessServiceInterface sourceProcessor;
    private CalculateServiceInterface calculatorService;
    private LendersDAO dataManager;
    private DisplayDTO displayDTO;

    String csvFileLocatoin = "src/main/resources/TestCSV";

    public RateCalculateSystem() {
        Initialise();
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        RateCalculateSystem rateCalculateSystem = new RateCalculateSystem();
        int requestAmount = Integer.parseInt(args[0]);
        rateCalculateSystem.quote(requestAmount);
        System.out.println(requestAmount);


    }

    private void quote(int requestAmount) {
         this.displayDTO = this.calculatorService.quote(requestAmount);
         displayDTO.Display();
    }

    private void Initialise(){

        this.sourceProcessor = new CsvScourceProcessor();
        this.dataManager = sourceProcessor.readSource(csvFileLocatoin);
        LoanCalculatorInterface loanCalculator = new AmortizationCalculator();
        this.calculatorService = new CalculateServiceImp(dataManager, loanCalculator);

    }


}
