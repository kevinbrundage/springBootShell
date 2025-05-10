package test.springBootShell.model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "person")
public class Person implements Serializable {

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   @Column(name = "id", nullable = false)
   private Long id;

   @Column(name = "name", nullable = false)
   private String name;

   @Column(name = "role", nullable = false)
   private String role;


  public Person(String name, String role) {
    this.name = name;
    this.role = role;
  }


  public Person() {}

  public Long getId() {
    return this.id;
  }
  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return this.name;
  }
  public void setName(String name) {
    this.name = name;
  }

  public String getRole() {
    return this.role;
  }
  public void setRole(String role) {
    this.role = role;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (!(o instanceof Person))
      return false;
    
    Person person = (Person) o;
    return Objects.equals(this.id, person.id) 
        && Objects.equals(this.name, person.name)
        && Objects.equals(this.role, person.role);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.id, this.name, this.role);
  }

  @Override
  public String toString() {
    return String.format("Person{id=%s; name='%s'; role='%s'}", this.id, this.name, this.role);
  }
}