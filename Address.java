class Address {
    String country;
    String city;

    public Address(String country, String city) {
        this.country = country;
        this.city = city;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Address address = (Address) obj;
        return country.equals(address.country) && city.equals(address.city);
    }

    @Override
    public int hashCode() {
        return country.hashCode() + city.hashCode();
    }
}

