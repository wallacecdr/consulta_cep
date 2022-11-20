package br.com.fawtech.consultacep.model;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Entity(name = "cep")
public class Cep {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cep;
    private String address;
    private String district;
    private String city;

    public Cep() {

    }

    public Cep(Builder builder) {
        this.id = builder.id;
        this.cep = builder.cep;
        this.address = builder.address;
        this.district = builder.district;
        this.city = builder.city;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {

        private Long id;
        private String cep;
        private String address;
        private String district;
        private String city;

        public Builder() {

        }

        public Builder(Cep cep) {
            this.id = cep.id;
            this.cep = cep.cep;
            this.address = cep.address;
            this.district = cep.district;
            this.city = cep.city;
        }

        public Builder withId(Long id) {
            this.id = id;
            return this;
        }

        public Builder withCep(String cep) {
            this.cep = cep;
            return this;
        }

        public Builder withAddress(String address) {
            this.address = address;
            return this;
        }

        public Builder withDistrict(String district) {
            this.district = district;
            return this;
        }

        public Builder withCity(String city) {
            this.city = city;
            return this;
        }

        public Cep build() {
            return new Cep(this);
        }
    }
}
