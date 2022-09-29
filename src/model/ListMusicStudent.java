/**
 * @author Kaitlyn Briggs - krbriggs
 * CIS175 - Fall 2022
 * Sep 15, 2022
 */
package model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="students")
public class ListMusicStudent {
	@Id
	@GeneratedValue
	@Column(name="ID")
	private int id;
	@Column(name="NAME")
	private String name;
	@Column(name="INSTRUMENT")
	private String instrument;
	
	//Constructors
	public ListMusicStudent() {
		super();
	}
	public ListMusicStudent(String name, String instrument) {
		super();
		this.name = name;
		this.instrument = instrument;
	}
	
	//Getters and Setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getInstrument() {
		return instrument;
	}
	public void setInstrument(String instrument) {
		this.instrument = instrument;
	}
	
	//Methods
		public String returnStudentDetails( ) {
			return this.name+ ": " + this.instrument;
			}
}
