import java.util.logging.Level;
import java.util.logging.Logger;
// implement UntrustworthyMailWorker, Spy, Inspector, Thief, StolenPackageException, IllegalPackageException as public static classes here


class UntrustworthyMailWorker implements MailService{

    RealMailService rms = new RealMailService();

    MailService [] arr;

    public UntrustworthyMailWorker(MailService [] arr) {
    this.arr=arr;
    }

    @Override
    public Sendable processMail(Sendable mail) {

        Sendable tempMail = mail;


        for (MailService anArr : arr) {
            tempMail = anArr.processMail(tempMail);
        }
        return rms.processMail(tempMail);
    }

   public RealMailService  getRealMailService(){
      return rms;
    }
}


class Spy implements MailService{

    public static final String AUSTIN_POWERS = "Austin Powers";
    private Logger LOGGER;
    MailMessage mm;

    Spy(Logger log){
     this.LOGGER = log;
 }

    @Override
    public Sendable processMail(Sendable mail) {

        if (!(mail instanceof MailMessage))
            return mail;

        mm = (MailMessage) mail;
            if (mail.getFrom().equals(AUSTIN_POWERS)  || mail.getTo().equals(AUSTIN_POWERS))
                    LOGGER.log(Level.WARNING,String.format("Detected target mail correspondence:" +
                            " from %s to %s \"%s\"",mm.getFrom(),mm.getTo(),mm.getMessage()));

            else
             LOGGER.log(Level.INFO,String.format("Usual correspondence: from %s to %s",
                     mm.getFrom(),mm.getTo()));
           return mail;
    }
}

class Thief implements MailService{

    int minForSteal;
    static int stolenValue;


    public Thief(int minForSteal) {
        this.minForSteal = minForSteal;
    }

    @Override
    public Sendable processMail(Sendable mail) {

        if (mail instanceof MailPackage ) {

            Package p = ((MailPackage) mail).getContent();
            int price = p.getPrice();
            if (price < minForSteal)
                return mail;

            String from =  mail.getFrom();
            String to = mail.getTo();
            String cont = p.getContent();

            stolenValue += price;
                return new MailPackage(from,to,new Package(String.format("stones instead of %s", cont), 0));
        }

        return mail;
    }

    public int getStolenValue(){
       return stolenValue;
    }

}


 class IllegalPackageException extends RuntimeException {
     public IllegalPackageException() {
     }
 }

 class StolenPackageException extends RuntimeException{
     public StolenPackageException() {
     }
 }


 class Inspector implements MailService{

    public static final String WEAPON = "weapons";
    public static final String BANNED_SUBSTANCE = "banned substance";




     @Override
     public Sendable processMail(Sendable mail) {

         if (mail instanceof MailPackage)
               {
                   Package p = ((MailPackage) mail).getContent();
                   String s = p.getContent();
                   if(s.contains(WEAPON) || s.contains((BANNED_SUBSTANCE)))
                           throw new IllegalPackageException();

                           if (s.contains("stones"))
                           throw  new StolenPackageException();
                   }

               return mail;
     }

 }