package com.br.desenvolvimento;
import java.util.ArrayList;
import java.util.List;

import com.br.desenvolvimento.entity.Address;

public abstract class Builders {
	
	public static Address buildAddress() {
		return Address.builder()
				.city("Campinas")
				.country("Brasil")
				.neighbourhood("Jardins")
				.complement("Bloco C")
				.state("São Paulo")
				.number(Integer.MIN_VALUE)
				.streetName("Rua 7")
				.zipCode("13050812")
				.build();
	}
	
	public static List<Address> buildListAddress(){
		List<Address> listAddress = new ArrayList<>();
		listAddress.add(buildAddress());
		listAddress.add(buildAddress());
		return listAddress;
	}
	
	public static Address buildAddressWithId() {
		return Address.builder()
				.city("Campinas")
				.country("Brasil")
				.id(Long.MIN_VALUE)
				.neighbourhood("Jardins")
				.complement("Bloco C")
				.state("São Paulo")
				.number(Integer.MIN_VALUE)
				.streetName("Rua 7")
				.zipCode("13050812")
				.build();
	}
	
	public static Address buildAddressWithNumber() {
		return Address.builder()
				.city("Campinas")
				.country("Brasil")
				.id(Long.MIN_VALUE)
				.neighbourhood("Jardins")
				.complement("Bloco C")
				.state("São Paulo")
				.number(207)
				.streetName("Rua 7")
				.zipCode("13050812")
				.build();
	}

}
