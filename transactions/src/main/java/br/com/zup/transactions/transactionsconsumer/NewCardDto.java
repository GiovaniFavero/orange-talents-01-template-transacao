package br.com.zup.transactions.transactionsconsumer;

public class NewCardDto {

    private String id;
    private String email;

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "NewCardDto{" +
                "id='" + id + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
