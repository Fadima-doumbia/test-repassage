package com.farima.demo.controller;
import com.farima.demo.entity.Project;
import com.farima.demo.service.ProjetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/projets")
public class ProjetController {
    @Autowired
    private ProjetService projetService;

    @GetMapping
    public Iterable<Project> getProjects(){
        return projetService.getProjets();
    }

    @GetMapping("/{id}")
    public Project getProjet(@PathVariable("id") final Long id) {
        Optional<Project> projet = projetService.getProjet(id);
        if (projet.isPresent()) {
            return projet.get();
        } else {
            return null;
        }
    }

    @PostMapping
    public Project createProjet(@RequestBody Project p){
        return projetService.saveProjet(p);
    }

    @DeleteMapping("/{id}")
    public void deleteProjet(@PathVariable("id") final Long id) {
        projetService.deleteProject(id);
    }

    @PutMapping
    public Project updateProjet(@RequestBody Project p){
        Optional<Project> project = projetService.getProjet(p.getId());
        return projetService.saveProjet(p);
    }

/*    @PutMapping("/{id}")
    public Project  updateDemo(
            @RequestBody("project")) {
        return projet;
    @PutMapping("/demos")
    public Demo  updateDemo(
            @RequestPart(value = "img", required = false) MultipartFile file,
            @RequestPart("demo") DemoDto demoDto ) {
        Demo demo = upload(file,demoDto);
        return demo;
    }*/
}
