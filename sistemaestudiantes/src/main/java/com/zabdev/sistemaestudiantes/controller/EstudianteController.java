package com.zabdev.sistemaestudiantes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zabdev.sistemaestudiantes.model.Estudiante;
import com.zabdev.sistemaestudiantes.service.EstudianteService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class EstudianteController {

	@Autowired
	private EstudianteService estudianteService;

	@GetMapping("/estudiantes")
	public List<Estudiante> listarEstudiantes() {
		return estudianteService.listarEstudiantes();
	}

	@GetMapping("/estudiantes/{id}")
	public Estudiante obtenerEstudiantePorId(@PathVariable(name = "id") Long id) {
		return estudianteService.obtenerEstudiantePorId(id);
	}

	@PostMapping("/estudiantes/add")
	public String add(@RequestBody Estudiante estudiante) {
		estudianteService.guardarEstudiante(estudiante);
		return "nuevo estudiante agregado";
	}

	@PutMapping("estudiantes/{id}")
	public Estudiante actualizarEstudiante(@RequestBody Estudiante estudiante, @PathVariable(name = "id") Long id) {
		Estudiante estudianteRespuesta = estudianteService.actualizarEstudiante(estudiante, id);
		return estudianteRespuesta;
	}

	@DeleteMapping("/estudiantes/{id}")
	public String eliminarEstudiante(@PathVariable(name = "id") Long id) {
		estudianteService.eliminarEstudiante(id);
		return "estudiante eliminado correctamente";
	}

}
