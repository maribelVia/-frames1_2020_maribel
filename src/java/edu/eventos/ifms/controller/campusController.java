package edu.eventos.ifms.controller;
/*
import edu.eventos.ifms.model.campusModel;
import edu.eventos.ifms.model.estadoModel;
import edu.eventos.ifms.repository.campusRepository;
import edu.eventos.ifms.repository.estadoRepository;
*/
import edu.eventos.ifms.model.campusModel;
import edu.eventos.ifms.model.cidadeModel;
import edu.eventos.ifms.model.estadoModel;
import edu.eventos.ifms.repository.campusRepository;
import edu.eventos.ifms.repository.cidadeRepository;
import edu.eventos.ifms.repository.estadoRepository;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

@ManagedBean
@ViewScoped
public class campusController {

    private estadoRepository estadoRepository;
    private campusModel campusModel;
    private campusRepository campusRepository;
    private cidadeRepository cidadeRepository;
    private List<SelectItem> listaDeCidades;
    //private List<campusModel> listaDeCampus;
    
    public campusController(){
    /*    this.campusNome = "";
        this.campusCidadeId = 0;
        this.campusEstadoId = 0;
        */
        this.campusModel =new campusModel();
        this.campusRepository = new campusRepository();
        this.estadoRepository = new estadoRepository();
        this.cidadeRepository = new cidadeRepository();
        this.listaDeCidades = this.getCidades(1);
        //this.listaDeCampus = new Arraylist<>();
    }
    
    public void salvar(){

        this.campusRepository.salvar(this.campusModel);
        //this.cidadeRepository.salvar(this.cidadeModel);
    }
    
    public List<SelectItem> getEstados() {
        ArrayList<SelectItem> itens = new ArrayList<SelectItem>();
        List<estadoModel> listaDeEstados = this.estadoRepository.buscar();
        for(estadoModel estado : listaDeEstados){
            itens.add(new SelectItem(estado.getIdEstado(), estado.getEstadoNome()));
        }  
        return itens;
    }
    
    public void onChangeEstado() {
        this.listaDeCidades = this.getCidades(this.campusModel.getCampusEstadoId());
    }

    public estadoRepository getEstadoRepository() {
        return estadoRepository;
    }

    public void setEstadoRepository(estadoRepository estadoRepository) {
        this.estadoRepository = estadoRepository;
    }

    public cidadeRepository getCidadeRepository() {
        return cidadeRepository;
    }

    public void setCidadeRepository(cidadeRepository cidadeRepository) {
        this.cidadeRepository = cidadeRepository;
    }

    public List<SelectItem> getListaDeCidades() {
        return listaDeCidades;
    }

    public void setListaDeCidades(List<SelectItem> listaDeCidades) {
        this.listaDeCidades = listaDeCidades;
    }

    
    public List<SelectItem> getCidades(long idEstado) {
        ArrayList<SelectItem> itens = new ArrayList<SelectItem>();
        List<cidadeModel> listaDeCidades = this.cidadeRepository.buscar(idEstado);
        for (cidadeModel cidade : listaDeCidades) {
            itens.add(new SelectItem(cidade.getIdCidade(), cidade.getCidadeNome()));
        }
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
