import java.math.MathContext;
import java.math.RoundingMode;

public class RateCalculateSystem {


/*    private SourceProcessServiceInterface sourceProcessor;
    private CalculateServiceInterface calculatorService;
    private DisplayInformationService displayInformationService;*/

    private static String csvFileLocatoin = "File/TestCSV.csv";

    public static final MathContext mathContext = new MathContext(7, RoundingMode.HALF_UP);

    public RateCalculateSystem() {
        Initialise();
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        RateCalculateSystem rateCalculateSystem = new RateCalculateSystem();
        try{
            String csvFileLocation = args[0];
            int requestAmount = Integer.parseInt(args[1]);
/*            String csvFileLocation = csvFileLocatoin;
            int requestAmount = Integer.parseInt("1000");*/




            CsvScourceProcessor sourceProcessor = new CsvScourceProcessor();
            LendersDAO dataManager = sourceProcessor.readSource(csvFileLocation);

            CalculateServiceImp calculatorService = new CalculateServiceImp(dataManager);
            DisplayInformationService displayInformationService = new DisplayInformationService();

            //int requestAmount = Integer.parseInt("1000");

            DisplayDTO displayDTO = rateCalculateSystem.quote(calculatorService , requestAmount);
            rateCalculateSystem.display(displayInformationService ,displayDTO);

        }catch ( NumberFormatException e){
            System.out.println("Please provide a valid integer number ");
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Not enough parameter to process, please check readme to see how to use it.");
        }




    }

    private void display(DisplayInformationService displayInformationService, DisplayDTO displayDTO) {
        displayInformationService.displayLoanInfor(displayDTO);
    }

    private DisplayDTO quote(CalculateServiceImp calculatorService, int requestAmount) {
         return calculatorService.quote(requestAmount);

    }

    private void Initialise(){


    }


}
