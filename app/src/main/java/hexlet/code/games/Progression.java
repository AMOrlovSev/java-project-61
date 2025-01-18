//package hexlet.code.games;
//
//import hexlet.code.Cli;
//
//import java.util.Arrays;
//import java.util.Random;
//
//public class Progression {
//    private static int numberOfCorrectAnswers = 0;
//    private static int numberOfAttempts = Engine.TOTAL_ATTEMP;
//
//    private static final int TOTAL_NUMS = 10;
//    private static String[] progression;
//    private static int unknownRandomValue;
//
//    private static final int MAX_VALUE = 10;
//    private static int randomValue1;
//
//    private static final int MAX_STEP = 10;
//    private static final int MIN_STEP = 2;
//    private static int randomStep;
//
//    private static String question;
//    private static String userAnswer;
//    private static String correctAnswer;
//
//    private static Random random = new Random();
//
//    public static void playGame() {
//        Cli.sayHello();
//
//        numberOfCorrectAnswers = 0;
//
//        Engine.sayTask("What number is missing in the progression?");
//
//        for (int i = 0; i < numberOfAttempts; i++) {
//            randomValue1 = random.nextInt(MAX_VALUE);
//            randomStep = MIN_STEP + (int) (Math.random() * ((MAX_STEP - MIN_STEP) + 1));
//
//            progression = createProgression(TOTAL_NUMS, randomValue1, randomStep);
//
//            unknownRandomValue = random.nextInt(TOTAL_NUMS);
//
//            var temp = String.valueOf(progression[unknownRandomValue]);
//
//            progression[unknownRandomValue] = "..";
//
//            question = Arrays.toString(progression);
//            question = question.replace("[", "").replace("]", "").replace(",", "");
//            System.out.println(question);
//
//            Engine.sayQuestion(question);
//
//            userAnswer = Engine.askAnswer();
//
//            correctAnswer = temp;
//
//            if (Engine.isCorrect(userAnswer, correctAnswer)) {
//                numberOfCorrectAnswers++;
//            } else {
//                break;
//            }
//        }
//
//        Engine.gameResult(numberOfCorrectAnswers, numberOfAttempts);
//    }
//
//    private static String[] createProgression(int totalNums, int firstNum, int step) {
//        String[] progres = new String[totalNums];
//        for (int i = 0; i < totalNums; i++) {
//            progres[i] = String.valueOf(firstNum + step * i);
//        }
//        return progres;
//    }
//
//}
