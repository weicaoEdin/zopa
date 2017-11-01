import java.math.MathContext;
import java.math.RoundingMode;

public class RateCalculateSystem {


    private SourceProcessServiceInterface sourceProcessor;
    private CalculateServiceInterface calculatorService;
    private DisplayInformationService displayInformationService;

    private static String csvFileLocatoin = "src/main/resources/TestCSV";
    public static final MathContext mathContext = new MathContext(7, RoundingMode.HALF_UP);

    public RateCalculateSystem() {
        Initialise();
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        RateCalculateSystem rateCalculateSystem = new RateCalculateSystem();
        try{
            //int requestAmount = Integer.parseInt(args[0]);
            int requestAmount = Integer.parseInt("1000");

            DisplayDTO displayDTO = rateCalculateSystem.quote(requestAmount);
            rateCalculateSystem.display(displayDTO);

            System.out.println(requestAmount);
        }catch ( NumberFormatException e){
            System.out.println("Please provide a valid integer number ");
        }




    }

    private void display(DisplayDTO displayDTO) {
        this.displayInformationService.displayLoanInfor(displayDTO);
    }

    private DisplayDTO quote(int requestAmount) {
         return calculatorService.quote(requestAmount);

    }

    private void Initialise(){

        this.sourceProcessor = new CsvScourceProcessor();
        LendersDAO dataManager = sourceProcessor.readSource(csvFileLocatoin);

        this.calculatorService = new CalculateServiceImp(dataManager);
        this.displayInformationService = new DisplayInformationService();

    }


}
