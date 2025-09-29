import java.util.Scanner;
public class HealthKiosk {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        char choice;
        char randomChar;
        char firstCharOfName;
        char shiftedLetter;
        int healthMetric = 0;
        int givenDosage = 0;
        int randNum1;
        int randNum2;
        int randNum3;
        int randNum4;
        double weight;
        double height;
        double bmi = 0;
        double requiredDosage;
        double angleDegrees;
        double angleRadians;
        double sinAngle = 0;
        double cosAngle = 0;
        String studentID = "";
        String studentFirstName;
        String lastTwoChars = "";
        String codeOnSlip = "";
        final int TABLET_DOSE = 250;

        // Task 0
        System.out.println("Welcome to Ashesi Health Center Kiosk!");

        // Task 1
        System.out.print("Enter choice. ( P -> Pharmacy, L -> Lab, T -> Triage, C -> Counselling): ");
        choice = (input.next()).charAt(0);
        choice = Character.toUpperCase(choice);

        switch (choice){
            case 'P':
                System.out.println("Go to: Pharmacy Desk");
                break;
            case 'L':
                System.out.println("Go to: Lab Desk");
                break;
            case 'T':
                System.out.println("Go to: Triage Desk");
                break;
            case 'C':
                System.out.println("Go to: Counselling Desk");
                break;
            default:
                System.out.println("Invalid Service Code");
                break;
        }

        // Task 2
        if (choice == 'T'){
            System.out.print("Enter health metric. (1 -> BMI, 2 -> Dosage round-up, 3 -> Trig helper): ");
            healthMetric = input.nextInt();

            switch (healthMetric){
                case 1:
                    System.out.print("Enter your height in metres: ");
                    height = input.nextDouble();
                    System.out.print("Enter your weight in kilograms: ");
                    weight = input.nextDouble();

                    bmi = weight / Math.pow(height, 2);
                    bmi = Math.round(bmi * 10) / 10.0;

                    if (bmi < 18.5){
                        System.out.printf("BMI: %.1f Category : Underweight \n", bmi);
                    } else if (bmi <= 24.9){
                        System.out.printf("BMI: %.1f Category : Normal \n", bmi);
                    } else if (bmi <=29.9) {
                        System.out.printf("BMI: %.1f Category : Overweight \n", bmi);
                    } else {
                        System.out.printf("BMI: %.1f Category : Obese \n", bmi);
                    }
                    break;

                case 2:
                    System.out.print("Enter required dosage in milligrams: ");
                    requiredDosage = input.nextDouble();
                    givenDosage = (int) Math.ceil((requiredDosage / TABLET_DOSE));
                    System.out.printf("Number of tablets: %d \n", givenDosage);
                    break;

                case 3:
                    System.out.print("Enter angle in degrees: ");
                    angleDegrees = input.nextDouble();
                    angleRadians =Math.toRadians(angleDegrees);

                    sinAngle = Math.sin(angleRadians);
                    cosAngle = Math.cos(angleRadians);

                    sinAngle = Math.round(sinAngle * 1000) / 1000.0;
                    cosAngle = Math.round(cosAngle * 1000) / 1000.0;

                    System.out.printf("Sine of angle: %f \n", sinAngle);
                    System.out.printf("Cosine of angle: %f \n", cosAngle);
                    break;
            }
        }

        // Task 3
        randomChar = (char)((int)(Math.random() * 26) + 65);
        randNum1 = (int)(Math.random() * 7) + 3;
        randNum2 = (int)(Math.random() * 7) + 3;
        randNum3 = (int)(Math.random() * 7) + 3;
        randNum4 = (int)(Math.random() * 7) + 3;

        studentID += randomChar;
        studentID += randNum1;
        studentID += randNum2;
        studentID += randNum3;
        studentID += randNum4;

        if (studentID.length() == 5){
            if (Character.isLetter(studentID.charAt(0))){
                if (Character.isDigit(studentID.charAt(1)) && Character.isDigit(studentID.charAt(2)) && Character.isDigit(studentID.charAt(3)) && Character.isDigit(studentID.charAt(4))){
                    System.out.println("ID OK");
                } else {
                    System.out.println("Last 4 digits must be integers");
                }
            } else {
                System.out.println("First character must be a letter");
            }
        } else {
            System.out.println("Invalid length");
        }

        // Task 4

        if (choice == 'T') {
            System.out.print("Enter your first name: ");
            studentFirstName = input.next();

            firstCharOfName = Character.toUpperCase(studentFirstName.charAt(0));
            shiftedLetter = (char) ('A' + (firstCharOfName - 'A' + 2) % 26);
            lastTwoChars = lastTwoChars + studentID.charAt(3) + studentID.charAt(4);

            codeOnSlip = codeOnSlip + shiftedLetter + lastTwoChars + "-" + healthMetric;
            System.out.printf("Display Code: <%S>", codeOnSlip);
        }

        // Task 5

        System.out.print("\nSummary: ");

        switch (choice) {
            case 'P':
                System.out.printf("PHARMACY | ID=%s | Code=%s \n", studentID, codeOnSlip);
                break;
            case 'L':
                System.out.printf("LAB | ID=%s | Code=%s \n", studentID, codeOnSlip);
                break;
            case 'T':
                // For Triage, include the specific metric that was calculated
                System.out.print("TRIAGE | ID=" + studentID + " | ");

                switch (healthMetric) {
                    case 1:
                        System.out.printf("BMI=%.1f | Code=%s%n", bmi, codeOnSlip);
                        break;
                    case 2:
                        System.out.printf("Dosage=%d tablets | Code=%s \n", givenDosage, codeOnSlip);
                        break;
                    case 3:
                        System.out.printf("Sin=%.3f, Cos=%.3f | Code=%s \n", sinAngle, cosAngle, codeOnSlip);
                        break;
                }
                break;
            case 'C':
                System.out.printf("COUNSELING | ID=%s | Code=%s \n", studentID, codeOnSlip);
                break;
            default:
                System.out.printf("INVALID SERVICE | ID=%s | Code=%s \n", studentID, codeOnSlip);
                break;
        }

    }
}
