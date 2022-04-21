package com.proyecto.cita.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.proyecto.cita.service.ICitaService;
import com.proyecto.cita.service.IDoctorService;
import com.proyecto.cita.service.IEspecialidadService;
import com.proyecto.cita.entity.Cita;
import com.proyecto.cita.entity.Especialidad;
import com.proyecto.cita.entity.Doctor;


@Controller
@RequestMapping("/views/citas")
public class CitaController {

	@Autowired
	private IDoctorService servicedoctor; 
	
	
	@Autowired
	private IEspecialidadService serviceEspecialidad;
	
	@Autowired
	private ICitaService servicecita;
	
	
	@GetMapping("/")
	public String listarCitas(Model model) {
		List<Cita> listadoCitas = servicecita.listarTodos();

		model.addAttribute("titulo", "Lista de CitasMedicas");
		model.addAttribute("citas", listadoCitas);

		return "/views/citas/listar";
	}

	@GetMapping("/create")
	public String crear(Model model) {

		Cita cita = new Cita();
		List<Doctor> listarDoctores = servicedoctor.listarDoctores();
		List<Especialidad> listarEspecialidad = serviceEspecialidad.listarEspecialidad();

		model.addAttribute("titulo", "Formulario: Nueva Cita Medica");
		model.addAttribute("cita", cita);
		model.addAttribute("doctores", listarDoctores);
		model.addAttribute("especialidades", listarEspecialidad);

		return "/views/citas/frmCrear";
	}

	@PostMapping("/save")
	public String guardar(@Validated @ModelAttribute Cita cita, BindingResult result,
			Model model, RedirectAttributes attribute) {
		List<Doctor> listarDoctores = servicedoctor.listarDoctores();
		List<Especialidad> listarEspecialidad = serviceEspecialidad.listarEspecialidad();

		if (result.hasErrors()) {
			model.addAttribute("titulo", "Formulario: Nueva Cita Medica");
			model.addAttribute("cita", cita);
			model.addAttribute("doctores", listarDoctores);
			model.addAttribute("especialidades", listarEspecialidad);
			System.out.println("Existieron errores en el formulario");			
			return "/views/citas/frmCrear";
		}

		servicecita.guardar(cita);
		System.out.println("Cita Medica guardada con exito!");
		attribute.addFlashAttribute("success", "Cita guardado con exito!");
		return "redirect:/views/citas/";
	}

	@GetMapping("/edit/{idcita}")
	public String editar(@PathVariable("idcita") Long idCita, Model model, RedirectAttributes attribute) {
			
		Cita cita = null;
		
		if (idCita > 0) {
			cita = servicecita.buscarPorId(idCita);
			
			if (cita == null) {
				System.out.println("Error: El ID de la Cita  no existe!");
				attribute.addFlashAttribute("error", "ATENCION: El ID del Cita no existe!");
				return "redirect:/views/citas/";
			}
		}else {
			System.out.println("Error: Error con el ID del Cita");
			attribute.addFlashAttribute("error", "ATENCION: Error con el ID del Cita");
			return "redirect:/views/citas/";
		}
		
		List<Doctor> listarDoctores = servicedoctor.listarDoctores();
		List<Especialidad> listarEspecialidad = serviceEspecialidad.listarEspecialidad();

		model.addAttribute("titulo", "Formulario: Editar Cita Medica");
		model.addAttribute("cita", cita);
		model.addAttribute("doctores", listarDoctores);
		model.addAttribute("especialidades", listarEspecialidad);
		return "/views/citas/frmCrear";
	}

	@GetMapping("/delete/{id}")
	public String eliminar(@PathVariable("id") Long idCita, RedirectAttributes attribute) {

		Cita cita = null;
		
		if (idCita > 0) {
			cita = servicecita.buscarPorId(idCita);
			
			if (cita == null) {
				System.out.println("Error: El ID del Cita no existe!");
				attribute.addFlashAttribute("error", "ATENCION: El ID del Cita no existe!");
				return "redirect:/views/citas/";
			}
		}else {
			System.out.println("Error: Error con el ID del Cita");
			attribute.addFlashAttribute("error", "ATENCION: Error con el ID del Cita!");
			return "redirect:/views/citas/";
		}		
		
		servicecita.eliminar(idCita);
		System.out.println("Registro Eliminado con Exito!");
		attribute.addFlashAttribute("warning", "Registro Eliminado con Exito!");

		return "redirect:/views/citas/";
	}
	
}
