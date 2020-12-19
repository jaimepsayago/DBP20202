package controller;

import javax.inject.Inject;
import javax.inject.Named;

import dao.PersonaService;
import model.Persona;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.faces.event.ActionEvent;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

@Named
@RequestScoped
public class PersonaController implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	//conectarme a la capa de negocio
	@Inject
	private PersonaService personaService;
	
	
	//objeto persona
	private Persona persona;
	
	//dataModel donde se carga la informacion de persona
	DataModel<Persona> lista;
	
	Long idSelecionado;
	
	//constructor
	public PersonaController() {
		if(persona == null) {
			persona = new Persona();
		}
	}
	
	//guardar
	public String guardar() {
		try {
			System.out.println("service: " + personaService);
		
			personaService.save(persona);
			
		} catch (Exception ex) {
			System.out.print("error" + ex.getMessage());
			return "";
		}
		return "listaPersona";
	}
	
	//editar
	public void editar() {
		if(idSelecionado == null) {
			return;
		}
	persona = personaService.find(idSelecionado);
	
	}

	//remover
	public String remover (ActionEvent e) {
		try {
			persona = new Persona();
			String i = e.getComponent().getAttributes().get("postEliminar").toString();
			Long l= new Long(i);
			persona.setId(l);
			personaService.remove(persona);
		} catch (Exception e2) {
			System.out.println(e2.getMessage());
			return "";
		}
		return "listaPersona";
	}
	
	//getters and setters
	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	
	//cargar los datos iniciales
	public DataModel<Persona> getLista() {
		lista = new ListDataModel<Persona>(personaService.findAll());
		return lista;
	}

	public void setLista(DataModel<Persona> lista) {
		this.lista = lista;
	}

	public Long getIdSelecionado() {
		return idSelecionado;
	}

	public void setIdSelecionado(Long idSelecionado) {
		this.idSelecionado = idSelecionado;
	}
	
}
