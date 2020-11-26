package edu.eventos.ifms.controller;
/*
import edu.eventos.ifms.model.campusModel;
import edu.eventos.ifms.model.estadoModel;
import edu.eventos.ifms.repository.campusRepository;
import edu.eventos.ifms.repository.estadoRepository;
*/
import edu.eventos.ifms.model.campusModel;
import edu.eventos.ifms.model.estadoModel;
import edu.eventos.ifms.repository.campusRepository;
import edu.eventos.ifms.repository.estadoRepository;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

@ManagedBean
@ViewScoped
public class campusController {
   /* private String campusNome;
    private int campusCidadeId;
    private int campusEstadoId;
    */
    private estadoRepository estadoRepository;
    private campusModel campusModel;
    private campusRepository campusRepository;
    
    public campusController(){
    /*    this.campusNome = "";
        this.campusCidadeId = 0;
        this.campusEstadoId = 0;
        */
        this.campusModel =new campusModel();
        this.campusRepository = new campusRepository();
        this.estadoRepository = new estadoRepository();
    }
    
    public void salvar(){
        /*System.out.println("Campus nome: "+this.campusNome+
                " - Estado e Cidade Id´s: " + this.campusEstadoId +
                " - " + this.campusCidadeId);
                */
        this.campusRepository.salvar(this.campusModel);
    }
    
    public List<SelectItem> getEstados() {
        ArrayList<SelectItem> itens = new ArrayList<SelectItem>();
        List<estadoModel> listaDeEstados = this.estadoRepository.buscar();
        for(estadoModel estado : listaDeEstados){
            itens.add(new SelectItem(estado.getIdEstado(), estado.getEstadoNome()));
        }  
        return itens;
    }
    
    public List<SelectItem> getCidades() {
        ArrayList<SelectItem> itens = new ArrayList<SelectItem>();
        itens.add(new SelectItem(1, "Cidade 1"));
        itens.add(new SelectItem(2, "Cidade 2"));
        itens.add(new SelectItem(3, "Cidade 3"));
        return itens;
    }

    public campusModel getCampusModel() {
        return campusModel;
    }

    public void setCampusModel(campusModel campusModel) {
        this.campusModel = campusModel;
    }

    public campusRepository getCampusRepository() {
        return campusRepository;
    }

    public void setCampusRepository(campusRepository campusRepository) {
        this.campusRepository = campusRepository;
    }
    
}
