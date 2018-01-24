
class Main {
    public static void main(String[] args) {

        System.out.println(getCallerClassAndMethodName());

        anotherMethod();
    }

   private static void anotherMethod(){

       System.out.println(getCallerClassAndMethodName());

   }

    public static String getCallerClassAndMethodName() {

        StackTraceElement[] stEle = new Throwable().getStackTrace();
        if(stEle.length >= 3 ){

         return stEle[2].getClassName() + "#" + stEle[2].getMethodName();
        }
        return null;

    }
}
