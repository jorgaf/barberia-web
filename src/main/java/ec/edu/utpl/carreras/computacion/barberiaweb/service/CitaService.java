package ec.edu.utpl.carreras.computacion.barberiaweb.service;

import ec.edu.utpl.carreras.computacion.barberiaweb.model.Cita;
import ec.edu.utpl.carreras.computacion.barberiaweb.repository.CitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CitaService {
    private final CitaRepository citaRepository;

    @Autowired
    CitaService(CitaRepository citaRepository) {
        this.citaRepository = citaRepository;
    }

    public List<Cita> getAllCitas() {
        return citaRepository.findAll();
    }

    public Cita getCitaById(Long id) {
        return citaRepository.findById(id).orElse(null);
    }

    public Cita saveCita(Cita cita) {
        return citaRepository.save(cita);
    }
}