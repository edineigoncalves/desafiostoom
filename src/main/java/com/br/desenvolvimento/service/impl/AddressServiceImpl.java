package com.br.desenvolvimento.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.br.desenvolvimento.entity.Address;
import com.br.desenvolvimento.repository.AddressRepository;
import com.br.desenvolvimento.service.AddressService;

@Component
public class AddressServiceImpl implements AddressService{

	@Autowired
	private AddressRepository addressRepository;
	
	@Override
	public List<Address> findAll() {
		return addressRepository.findAll();
	}


	@Override
	public Address saveAddress(Address address) {
		return addressRepository.save(address);
	}


	@Override
	public Optional<Address> findById(Long id) {
		return addressRepository.findById(id);
	}


	@Override
	public List<Address> findByZipCode(String zipCode) {
		return addressRepository.findByZipCode(zipCode);
	}


	@Override
	public Address findByStreetNameAndNumber(String streetName, Integer number) {
		return addressRepository.findByStreetNameAndNumber(streetName, number);
	}


	@Override
	public Address deleteByAddressId(Long id) {
		return addressRepository.deleteAddressById(id);
	}
	
	@Override
	public Address update(Address address) {
		return addressRepository.save(address);
	}
	
	
}
