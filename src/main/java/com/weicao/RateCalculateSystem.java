package com.weicao;

import java.math.MathContext;
import java.math.RoundingMode;

public class RateCalculateSystem {


    private static RateCalculateSystem rateCalculateSystem;
    private static SourceProcessServiceInterface sourceProcessor;
    private static CalculateServiceInterface calculatorService;
    private static DisplayInformationServiceInterface displayInformationService;

    private static final String CSV_FILE = "TestCSV";
    public static final MathContext mathContext = new MathContext(7, RoundingMode.HALF_UP);

    private RateCalculateSystem() {
        sourceProcessor = new CsvScourceProcessor();
        displayInformationService = new DisplayInformationService();
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        rateCalculateSystem = new RateCalculateSystem();
        try{

            int requestAmount = Integer.parseInt("1000");//used for IDE test

            LendersDAO dataManager = sourceProcessor.readSource(CSV_FILE);
            calculatorService = new CalculateServiceImp(dataManager);



            DisplayDTO displayDTO = rateCalculateSystem.quote(requestAmount);
            rateCalculateSystem.display(displayDTO);


        }catch ( NumberFormatException e){
            System.out.println("Please provide a valid integer number for amount");
        }catch ( InvalidSourceFileException e){
            System.out.println("CSV sources file is invalid");
        }




    }

    private void display(DisplayDTO displayDTO) {
        displayInformationService.displayLoanInfor(displayDTO);
    }

    private DisplayDTO quote(int requestAmount) {
         return calculatorService.quote(requestAmount);

    }

}
