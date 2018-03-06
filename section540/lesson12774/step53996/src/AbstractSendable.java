/*Абстрактный класс, котороый позволяет абстрогировать логику хранения
источника и получателся письмав соотсветвующих полях класса.*/

public abstract class AbstractSendable implements Sendable{

  protected final String form;
  protected final String to;

    public AbstractSendable(String form, String to) {
        this.form = form;
        this.to = to;
    }

    @Override
    public String getFrom() {
        return form;
    }

    @Override
    public String getTo() {
        return to;
    }

     @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass())
            return false;
        AbstractSendable that = (AbstractSendable)o;

       if(!form.equals(that.form))
           return false;
       if(!to.equals(that.to))
           return  false;
       return true;
    }

}

