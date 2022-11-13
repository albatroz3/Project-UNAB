package project.reto345.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import project.reto345.model.Admin;
import project.reto345.model.Category;
import project.reto345.service.AdminService;
import project.reto345.service.CategoryService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/Admin")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class  AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/All*")
    public List<Admin> getAdmin() {
        return adminService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Admin> getAdmin(@PathVariable("id") int id) {
        return adminService.getAdmin(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Admin save(@RequestBody Admin admin) {
        return adminService.save(admin);
    }

    @PutMapping("/update")
    public Admin update(@RequestBody Admin admin) {
        return adminService.update(admin);
    }
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") int id) {
        return adminService.delete(id);
    }
}
