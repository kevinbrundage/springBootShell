package test.springBootShell.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test.springBootShell.model.Person;
import test.springBootShell.repository.PersonRepository;

@Service
public class PersonService {

    @Autowired
    private PersonRepository repository;


    public List<Person> retrieveAll() {
        return StreamSupport
            .stream(repository.findAll().spliterator(), false)
            .collect(Collectors.toList());
    }


    public Person retrieveById(Long id) {
        return repository.findById(id).get();
    }


    public Person insert(Person newPerson) {
        return repository.save(newPerson);
    }


    public Person upsert(Person newPerson, Long id) {
        return repository.findById(id)
            .map(person -> {
                person.setName(newPerson.getName());
                person.setRole(newPerson.getRole());
            return repository.save(person);
            })
            .orElseGet(() -> {
                return insert(newPerson);
            });
    }


    public void delete(Long id) {
        repository.deleteById(id);
    }
}
