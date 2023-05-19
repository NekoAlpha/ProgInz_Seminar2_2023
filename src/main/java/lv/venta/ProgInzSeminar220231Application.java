package lv.venta;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import lv.venta.models.Course;
import lv.venta.models.Degree;
import lv.venta.models.Grade;
import lv.venta.models.Professor;
import lv.venta.models.Student;
import lv.venta.repos.ICourseRepo;
import lv.venta.repos.IGradeRepo;
import lv.venta.repos.IProfessorRepo;
import lv.venta.repos.IStudentRepo;

@SpringBootApplication
public class ProgInzSeminar220231Application {

	public static void main(String[] args) {
		SpringApplication.run(ProgInzSeminar220231Application.class, args);
	}
	
	@Bean//izsauks funkciju automātiski, kad startēsies sistēma
	public CommandLineRunner testModel(IProfessorRepo profRepo, IStudentRepo stRepo, ICourseRepo courRepo, IGradeRepo grRepo) {
		
		return new CommandLineRunner() {
			
			@Override
			public void run(String... args) throws Exception {
				
				Professor pr1 = new Professor("Karina", "Skirmante", Degree.mg);
				Professor pr2 = new Professor("Martins", "Saulitis", Degree.mg);
				Professor pr3 = new Professor("Raita", "Rollande", Degree.phd);
				//TODO izveidot velvienu profesoru
				profRepo.save(pr1);
				profRepo.save(pr2);
				profRepo.save(pr3);
				
				Student st1 = new Student("Renārs", "Geriksons");
				Student st2 = new Student("Janis", "Berzins");
				stRepo.save(st1);
				stRepo.save(st2);
				
				//TODO uztaisīt kursu, kuram ir divi profesori piesaistīti
				//TODO uztaisīt gadījumu, kad viens profesors pasbiedz divus kursus
				Course c1 = new Course("Proginz", 4, new ArrayList<>(Arrays.asList(pr1, pr3)));
				Course c2 = new Course("Datubazes", 4, new ArrayList<>(Arrays.asList(pr2)));
				Course c3 = new Course("Datu struktūras", 2, new ArrayList<>(Arrays.asList(pr1)));
				courRepo.save(c1);
				courRepo.save(c2);
				courRepo.save(c3);
				
				c1.addProfessor(pr1);
				c1.addProfessor(pr3);
				c2.addProfessor(pr2);
				c3.addProfessor(pr1);
				courRepo.save(c1);
				courRepo.save(c2);
				courRepo.save(c3);
				
				
				
				
				grRepo.save(new Grade(10, st1, c1));//Janis nopelnija 10 JAVA
				grRepo.save(new Grade(6, st1, c2));//Janis nopelnija 10 Datubazes
				grRepo.save(new Grade(8, st2, c1));
				grRepo.save(new Grade(10, st2, c2));

				//TODO izveidot jaunu zaru un pāriet uz to (git branch xxxxx, git checkout xxxxx)
				//TODO pārveidot saiti starp professoru un kursu uz ManyRoMany
				//TODO pamainīt testModel funkciju, ieliekot 1.professoram divus kursus un 1.kursam, ka to pasniedz abi professori
				
				
				
			}
		};
		
	}
	
	

}
