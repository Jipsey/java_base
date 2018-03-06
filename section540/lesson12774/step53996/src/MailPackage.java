/*
Посылка, содержимое которой можно получить с помощью метода "getContent"
*/

public class MailPackage extends AbstractSendable {

    private final Package content;

    public MailPackage(String form, String to, Package content) {
        super(form, to);
        this.content = content;
    }

    public Package getContent(){
        return content;
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;

        MailPackage that = (MailPackage)o;
        if(!content.equals((that.content))) return false;

        return true;
    }
}
