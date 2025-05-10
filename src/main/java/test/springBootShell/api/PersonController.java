package test.springBootShell.api;

import test.springBootShell.model.Person;
import test.springBootShell.service.PersonService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/person")
public class PersonController {
    
  private final PersonService personService;

  @Autowired
  public PersonController(PersonService personService) {
    this.personService = personService;
  }

  
  @GetMapping("")
  List<Person> all() {
    return personService.retrieveAll();
  }


  @PostMapping("")
  Person addPerson(@RequestBody Person newPerson) {
    return personService.insert(newPerson);
  }

  
  @GetMapping("/{id}")
  Person one(@PathVariable Long id) {
    return personService.retrieveById(id);
  }


  @PutMapping("/{id}")
  Person updateEmployee(@RequestBody Person newPerson, @PathVariable Long id) {
    return personService.upsert(newPerson, id);
  }


  @DeleteMapping("/{id}")
  void deleteEmployee(@PathVariable Long id) {
    personService.delete(id);
  }
}
