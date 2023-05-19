package lv.venta.models;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Table(name = "course_table")
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Course {
	
	@Setter(value = AccessLevel.NONE)
	@Column(name = "Idc")//DB puse būs kolonna "idp" un būs kā auto increment PK
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idc;
	
	@Column(name = "Title")//DB puse būs kolonna title
	@NotNull
	@Pattern(regexp = "[A-ZĒŪĪĻĶŠĀŽČŅ]{1}[a-zēūīļķšāžčņ\\ ]+", message = "Pirmajam burtam jābūt lielajam")
	@Size(min = 5, max = 25, message = "Jabūt vismaz 5 un ne vairāk kā 25 simboliem")
	private String title;
	
	@Column(name = "CreditPoints")
	@Min(value = 1)
	@Max(value = 20)
	private int creditPoints;
	
	@ManyToMany
	@JoinTable(name = "course_prof_table", joinColumns = @JoinColumn(name = "Idp"), inverseJoinColumns  = @JoinColumn(name = "Idc"))
	private Collection<Professor> professors = new ArrayList<>();
	
	@OneToMany(mappedBy = "course")
	@ToString.Exclude
	private Collection<Grade> grades;

	public Course(
			@NotNull @Pattern(regexp = "[A-ZĒŪĪĻĶŠĀŽČŅ]{1}[a-zēūīļķšāžčņ\\ ]+", message = "Pirmajam burtam jābūt lielajam") @Size(min = 5, max = 25, message = "Jabūt vismaz 5 un ne vairāk kā 25 simboliem") String title,
			@Min(1) @Max(20) int creditPoints, Professor professor) {
		this.title = title;
		this.creditPoints = creditPoints;
		//this.professor = professor;
	}
	
	
	public void addProfessor(Professor inputProfessor) {
		if(!professors.contains(inputProfessor))
		{
			professors.add(inputProfessor);
		}
	}

	
	
	
}
