/**
 * логика работы метода следующая, при удачном установлении соединения с роботом выходим из
 * цикла for командой break, в противном случае пытаемся подключится три раза, вызывая
 * метод .getConnection(). Важно игнорировть исключение получаемое из метода close().
 * После третьей неудачной попытки установить соединение кидаем исключение.
 */
class Main {
    //Stepik code: start
    public static void moveRobot(RobotConnectionManager robotConnectionManager, int toX, int toY) {

        for (int i = 0; i < 3 ; i++) {

            try (RobotConnection rCon = robotConnectionManager.getConnection()) {
                rCon.moveRobotTo(toX, toY);
                i=3;
            } catch (RobotConnectionException e) {
                 if (i == 2)
                    throw e;
            }
        }
    }
//Stepik code: end
}
