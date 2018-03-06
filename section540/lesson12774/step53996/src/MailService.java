/*
интерфейс, который задаёт класс, который может каим-либо образом обработать почтовый объект.
 */
public interface MailService {
    Sendable processMail(Sendable mail);
}
