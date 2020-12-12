package puce.web.controller;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.*;
import org.primefaces.event.RowEditEvent;

import puce.web.model.Persona;
import puce.web.util.MemoryStore;

@Named
@RequestScoped
public class PersonasController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	//inyeccion de dependencia o la conexion a nuestra capa de datos
	// memory store
	@Inject
	private MemoryStore ms;
	
	//metodo para listar las personas
	public List<Persona> getPersonas(){
		return ms.getPersonas();
	}
	
	public void onRowEdit(RowEditEvent<Persona> event) {
        FacesMessage msg = new FacesMessage("Car Edited", event.getObject().getIdentificacion());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
     
    public void onRowCancel(RowEditEvent<Persona> event) {
        FacesMessage msg = new FacesMessage("Edit Cancelled", event.getObject().getIdentificacion());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
     
    public void onCellEdit(@SuppressWarnings("rawtypes") CellEditEvent event) {
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();
         
        if(newValue != null && !newValue.equals(oldValue)) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cell Changed", "Old: " + oldValue + ", New:" + newValue);
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }

}
