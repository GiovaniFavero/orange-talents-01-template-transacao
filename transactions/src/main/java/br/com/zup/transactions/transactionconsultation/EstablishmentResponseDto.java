package br.com.zup.transactions.transactionconsultation;

import br.com.zup.transactions.transactionsconsumer.Establishment;

public class EstablishmentResponseDto {

    private String name;
    private String city;
    private String address;

    public EstablishmentResponseDto(Establishment establishment) {
        this.name = establishment.getName();
        this.city = establishment.getCity();
        this.address = establishment.getAddress();
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

    @Override
    public String toString() {
        return "NewEstablishmentDto{" +
                "nome='" + name + '\'' +
                ", cidade='" + city + '\'' +
                ", endereco='" + address + '\'' +
                '}';
    }
}
