package com.br.desenvolvimento.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name="ADDRESS")
public class Address {
	
	@Id
	@GeneratedValue
	private Long id;
	@NotBlank(message="{streetname.not.blank}")
	private String streetName;
	@NotNull(message="{number.not.blank}")
	private Integer number;
	private String complement;
	@NotBlank(message="{neighbourhood.not.blank}")
	private String neighbourhood;
	@NotBlank(message="{city.not.blank}")
	private String city;
	@NotBlank(message="{state.not.blank}")
	private String state;
	@NotBlank(message="{country.not.blank}")
	private String country;
	@NotBlank(message="{zipcode.not.blank}")
	private String zipCode;
	private String latitude;
	private String longitude;

}
