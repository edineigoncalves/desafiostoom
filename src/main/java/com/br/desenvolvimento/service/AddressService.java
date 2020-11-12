package com.br.desenvolvimento.service;

import java.util.List;
import java.util.Optional;

import com.br.desenvolvimento.entity.Address;

public interface AddressService {
	
	public List<Address> findAll();
	
	public Address saveAddress(Address address);
	
	public Optional<Address> findById(Long id);
	
	public List<Address> findByZipCode(String zipCode);
	
	public Address findByStreetNameAndNumber(String streetName, Integer number);
	
	public Address deleteByAddressId(Long userId);
	
	public Address update(Address address);

}
