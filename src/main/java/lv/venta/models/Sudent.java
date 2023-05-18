package lv.venta.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Table(name = "student_table")
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Sudent {
	
	@Setter(value = AccessLevel.NONE)
	@Column(name = "Idst")//DB puse būs kolonna "idp" un būs kā auto increment PK
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idst;
	
	@Column(name = "Name")//DB puse būs kolonna title
	@NotNull
	@Pattern(regexp = "[A-ZĒŪĪĻĶŠĀŽČŅ]{1}[a-zēūīļķšāžčņ\\ ]+", message = "Pirmajam burtam jābūt lielajam")
	@Size(min = 3, max = 15, message = "Jabūt vismaz 3 un ne vairāk kā 15 simboliem")
	private String name;
	
	@Column(name = "Surname")//DB puse būs kolonna title
	@NotNull
	@Pattern(regexp = "[A-ZĒŪĪĻĶŠĀŽČŅ]{1}[a-zēūīļķšāžčņ\\ ]+", message = "Pirmajam burtam jābūt lielajam")
	@Size(min = 3, max = 15, message = "Jabūt vismaz 3 un ne vairāk kā 15 simboliem")
	private String surname;

	public Sudent(String name, String surname) {
		this.name = name;
		this.surname = surname;
	}
	
	
	
	
	
	
	
}
