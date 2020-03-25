package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;

public class Controladora {

	@FXML
	private ListView<String> listCandidates;
	@FXML
	private ListView<String> listSelected;
	@FXML
	private Button botonIzquierda;
	@FXML
	private Button botonDerecha;
	@FXML
	private Button botonIzquierda1;
	@FXML
	private Button botonDerecha1;
	@FXML
	private final ObservableList<String> datostabla = FXCollections.observableArrayList("David Perez","Pedro Camacho","Juan Palomo");
	@FXML
	private final ObservableList<String> datostabla2 = FXCollections.observableArrayList();

	public void initialize(){

		listCandidates.setItems(this.datostabla);

	}


	public void pasarDerecha(ActionEvent event){

		int index = listCandidates.getSelectionModel().getSelectedIndex();
		System.out.println(index);
		if( index >= 0){
			String seleccionada = listCandidates.getSelectionModel().getSelectedItem();	
			datostabla2.add(seleccionada);
			datostabla.remove(seleccionada);
			listCandidates.setItems(this.datostabla);
			listSelected.setItems(this.datostabla2);
		}else{

			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText("Error en selección de datos");
			alert.setContentText("NO HAY NINGUN ELEMENTO SELECCIONADO!");
			alert.showAndWait();

		}

	}
	public void pasarDerechaTodo(ActionEvent event){

		listSelected.setItems(datostabla);
		listCandidates.setItems(datostabla2);
		
	}
	public void pasarIzquierdaTodo(ActionEvent event){

		listCandidates.setItems(datostabla);
		listSelected.setItems(datostabla2);
		
	}
	public void pasarIzquierda(ActionEvent event){

		int index = listSelected.getSelectionModel().getSelectedIndex();
		System.out.println(index);
		if( index >= 0){
			String seleccionada = listSelected.getSelectionModel().getSelectedItem();	
			datostabla.add(seleccionada);
			datostabla2.remove(seleccionada);
			listSelected.setItems(this.datostabla2);
			listCandidates.setItems(this.datostabla);
		}else{

			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText("Error en selección de datos");
			alert.setContentText("NO HAY NINGUN ELEMENTO SELECCIONADO!");
			alert.showAndWait();

		}

	}



}
