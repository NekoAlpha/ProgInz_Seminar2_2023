package lv.venta.models;

import java.util.ArrayList;
import java.util.Collection;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Table(name = "professor_table")
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Professor {
	
	//TODO uzlikt Data JPA anotācijas
	//TODO uzlikt atbilstošās validāciju anotācijas
	//TODO izveidot Student klasi
	//TODO izveidot Course klasi
	//TODO izveidot Grade klasi
	
	@Setter(value = AccessLevel.NONE)
	@Column(name = "Idp")//DB puse būs kolonna "idp" un būs kā auto increment PK
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idp;
	
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
	
	@Column(name = "Degree")//DB puse būs kolonna title
	@NotNull
	private Degree degree;

	@ManyToMany(mappedBy = "professors")
	private Collection<Course> courses = new ArrayList<>();
	
	public Professor(String name, String surname, Degree degree) {
		this.name = name;
		this.surname = surname;
		this.degree = degree;
	}
	
	
	public void addCourse(Course inputCourse) {
		if(!courses.contains(inputCourse))
		{
			courses.add(inputCourse);
		}
	}
	
	
	
	
}
