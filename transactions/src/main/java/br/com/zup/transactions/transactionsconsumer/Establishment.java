package br.com.zup.transactions.transactionsconsumer;

import javax.persistence.*;

@Embeddable
public class Establishment {

    private String name;
    private String city;
    private String address;

    public Establishment(String name, String city, String address) {
        this.name = name;
        this.city = city;
        this.address = address;
    }

    @Deprecated
    public Establishment() {
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getAddress() {
        return address;
    }
}
