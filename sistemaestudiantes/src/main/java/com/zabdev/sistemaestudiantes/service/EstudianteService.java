package com.zabdev.sistemaestudiantes.service;

import java.util.List;

import com.zabdev.sistemaestudiantes.model.Estudiante;

public interface EstudianteService {

	public Estudiante guardarEstudiante(Estudiante estudiante);

	public List<Estudiante> listarEstudiantes();
	
	public Estudiante obtenerEstudiantePorId(Long id);

	public Estudiante actualizarEstudiante(Estudiante estudiante, Long id);

	public void eliminarEstudiante(Long id);
}
