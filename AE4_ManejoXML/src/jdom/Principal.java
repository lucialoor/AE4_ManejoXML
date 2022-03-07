package jdom;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class Principal {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DocumentBuilderFactory fabrica = DocumentBuilderFactory.newInstance();
		DocumentBuilder analizador; 
		Document doc; 
		
		try {
			analizador = fabrica.newDocumentBuilder();
			doc = analizador.newDocument();
			Element concierto = doc.createElement("concierto");
			doc.appendChild(concierto);
			
			agregarParticipantes(concierto, doc);
			
			guardar(doc);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		
		
	}
	
	public static void agregarParticipantes(Element concierto, Document doc) {
		Element fecha = doc.createElement("fecha"); 
		concierto.appendChild(fecha);
		Text fechaConcierto = doc.createTextNode("21-oct-2018");
		fecha.appendChild(fechaConcierto);
		
		Element hora = doc.createElement("hora"); 
		concierto.appendChild(hora);
		Text horaConcierto = doc.createTextNode("21:30");
		hora.appendChild(horaConcierto);

		Element participantes = doc.createElement("participantes");
		concierto.appendChild(participantes);
		// Agregamos primer participante
		Element participante = doc.createElement("participante");
		Element entrada = doc.createElement("entrada");
		Text entradaConcierto = doc.createTextNode("21:30");
		entrada.appendChild(entradaConcierto);
		participante.appendChild(entrada);
		Element grupo = doc.createElement("grupo");
		Text grupoConcierto = doc.createTextNode("Las Ardillas de Dakota");
		grupo.appendChild(grupoConcierto);
		participante.appendChild(grupo);
		participantes.appendChild(participante);	
		// Agregamos segundo participante
		participante = doc.createElement("participante");
		entrada = doc.createElement("entrada");
		entradaConcierto = doc.createTextNode("22:30");
		entrada.appendChild(entradaConcierto);
		participante.appendChild(entrada);
		grupo = doc.createElement("grupo");
		grupoConcierto = doc.createTextNode("Fito y Fitipaldis");
		grupo.appendChild(grupoConcierto);
		participante.appendChild(grupo);
		participantes.appendChild(participante);
		
		// Agregamos tercer participante
		participante = doc.createElement("participante");
		entrada = doc.createElement("entrada");
		entradaConcierto = doc.createTextNode("23:00");
		entrada.appendChild(entradaConcierto);
		participante.appendChild(entrada);
		grupo = doc.createElement("grupo");
		grupoConcierto = doc.createTextNode("Coldplay");
		grupo.appendChild(grupoConcierto);		
		participante.appendChild(grupo);
		participantes.appendChild(participante);
	}
	
	private static void guardar(Document doc) throws TransformerException{
		
		TransformerFactory fabricaConversor = TransformerFactory.newInstance();
		
		Transformer conversor = fabricaConversor.newTransformer();
		
		DOMSource fuente = new DOMSource(doc);
		
		StreamResult resultado = new StreamResult(new File("concierto.xml"));
		
		conversor.transform(fuente, resultado);
		
	}

}
