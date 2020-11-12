package com.br.desenvolvimento.controller;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.br.desenvolvimento.entity.Address;
import com.br.desenvolvimento.service.impl.AddressServiceImpl;

@RestController
public class AddressController {
	
	@Autowired
	private AddressServiceImpl addressService;
	
	@GetMapping("/address/all")
	public ResponseEntity<List<Address>> findAll() {
		return ResponseEntity.ok().body(addressService.findAll());
	}

	@PostMapping("/address/save")
	public ResponseEntity<Address> saveAddress(@RequestBody @Valid Address address) {
		return Objects.isNull(addressService.findByStreetNameAndNumber(address.getStreetName(),address.getNumber())) ? ResponseEntity.ok().body(addressService.saveAddress(address)) : ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Address());
	}
	
	@PutMapping("/address/update")
	public ResponseEntity<Address> updateAddress(@RequestBody @Valid Address address) {
		return ResponseEntity.ok().body(addressService.saveAddress(address));
	}
	
	@GetMapping("/address/{streetname}/{number}")
	public ResponseEntity<Address> findByStreetNameAndNumber(@PathVariable(name = "streetname") String streetname,@PathVariable(name = "number") Integer number) {
		return ResponseEntity.ok().body(addressService.findByStreetNameAndNumber(streetname,number));
	}

	@GetMapping("/address/{id}")
	public ResponseEntity<Optional<Address>> findById(@PathVariable(name = "id") Long id) {
		return ResponseEntity.ok().body(addressService.findById(id));
	}

	@GetMapping("/address/zipcode/{zipcode}")
	public ResponseEntity<List<Address>> findByZipCode(@PathVariable(name = "zipcode") String zipCode) {
		return ResponseEntity.ok().body(addressService.findByZipCode(zipCode));
	}

	@DeleteMapping("/address/delete/{id}")
	public ResponseEntity<Address> delete(@PathVariable(name = "id") Long AddressId) {
		return ResponseEntity.ok().body(addressService.deleteByAddressId(AddressId));
	}
}
