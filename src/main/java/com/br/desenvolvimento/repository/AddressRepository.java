package com.br.desenvolvimento.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.br.desenvolvimento.entity.Address;

@Repository
@Transactional
public interface AddressRepository extends JpaRepository<Address, Long> {
	
	public List<Address> findByZipCode(String zipCode);
	
	public Address findByStreetNameAndNumber(String streetName, Integer number);
	
	public Address deleteAddressById(Long id);

}
