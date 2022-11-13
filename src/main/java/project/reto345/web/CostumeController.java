package project.reto345.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import project.reto345.model.Costume;
import project.reto345.service.CostumeService;

import java.util.List;
import java.util.Optional;

public class CostumeController {

    @Autowired
    private CostumeService costumeService;

    @GetMapping("/all")
    public List<Costume> getCostumes() {
        return costumeService.getAll();
    }
    @GetMapping("/{id}")
    public Optional<Costume> getCostume(@PathVariable("id") int id){
        return costumeService.getCostume(id);
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Costume save(@RequestBody Costume costume){
        return costumeService.save(costume);
    }
    @PutMapping("/update")
    public Costume update(@RequestBody Costume costume){
        return costumeService.update(costume);
    }
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") int id){
        return costumeService.delete(id);
    }
}
