package com.zabdev.sistemaestudiantes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zabdev.sistemaestudiantes.model.Estudiante;
import com.zabdev.sistemaestudiantes.repository.EstudianteRepository;

@Service
public class EstudianteServiceImpl implements EstudianteService {

	@Autowired
	private EstudianteRepository estudianteRepository;

	@Override
	public Estudiante guardarEstudiante(Estudiante estudiante) {
		return estudianteRepository.save(estudiante);
	}

	@Override
	public List<Estudiante> listarEstudiantes() {
		return estudianteRepository.findAll();
	}

	@Override
	public Estudiante obtenerEstudiantePorId(Long id) {
		Estudiante estudiante = estudianteRepository.findById(id).orElse(null);
		return estudiante;
	}

	@Override
	public Estudiante actualizarEstudiante(Estudiante estudiante, Long id) {
		Estudiante estudianteEncontrado = estudianteRepository.findById(id).orElse(null);

		estudianteEncontrado.setNombre(estudiante.getNombre());
		estudianteEncontrado.setDireccion(estudiante.getDireccion());

		Estudiante estudianteActualizado = estudianteRepository.save(estudianteEncontrado);

		return estudianteActualizado;
	}

	@Override
	public void eliminarEstudiante(Long id) {
		Estudiante estudianteEncontrado = estudianteRepository.findById(id).orElse(null);
		estudianteRepository.delete(estudianteEncontrado);
	}

}
