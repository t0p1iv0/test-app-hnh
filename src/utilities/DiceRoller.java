package utilities;

public class DiceRoller {

    //Бросок кубика на успех действия. Для расчета в метод нужно передать
    //число сторон кубика и число, от которого действие считается успешным
    public static boolean isActionSuccessful(int sidesOfDice, int successfulNumber) {
        if (successfulNumber > sidesOfDice)
            throw new IllegalArgumentException
                    ("Successful number cannot be greater then the number of sides of dice");

        //Для расчета берем случайное число в промежутке от 1 до числа сторон кубика
        //и сравниваем с успешным числом
        return (1 + Math.random() * sidesOfDice) >= successfulNumber;
    }
}
