package jdom;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class LecturaXML {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DocumentBuilderFactory fabrica = DocumentBuilderFactory.newInstance();
		DocumentBuilder analizador; 
		Document doc; 
		Node raiz;
		
		try {
			analizador = fabrica.newDocumentBuilder();
			doc = analizador.parse("concierto.xml");
			raiz = doc.getDocumentElement();
			recorrerNodos(raiz);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	private static void recorrerNodos(Node raiz) {
		
		//Este metodo devuelve todos los nodos hijos directos del elemento conciertos
		NodeList nodos = raiz.getChildNodes();
		System.out.println("Elementos en el nodo raíz: " + nodos.getLength());
		//System.out.println(nodos);
	
		for(int i= 0; i< nodos.getLength(); i++) {
			Node nodoHijo  = nodos.item(i);;
			//System.out.println(nodoHijo.getLastChild());
			if(nodoHijo.getNodeType() == Node.ELEMENT_NODE) {
				Node fecha = nodoHijo.getChildNodes().item(0);
				Node hora = nodoHijo.getChildNodes().item(1);
				System.out.println("Fecha y hora del concierto: " + fecha.getTextContent() + " " + hora.getTextContent());
				Node participante = nodoHijo.getChildNodes().item(2);
				System.out.println("  Participantes:");
				recorrerParticipantes(participante);
			}
		}
		
		
	}
	
	
	private static void recorrerParticipantes(Node participantes) {
		NodeList nodos = participantes.getChildNodes();
		
		for (int i=0; i<nodos.getLength();i++) {
			Node participante = nodos.item(i);
			if (participante.getNodeType() == Node.ELEMENT_NODE) {
				//dame los atriburos del nodo escala, y quiero el atributo 0, es decir
				//el prierm atributo, a continuacion de pido el valor de ese nodo atributo
				Node entrada = participante.getChildNodes().item(0);
				Node grupo = participante.getChildNodes().item(1);
		
				System.out.print("                        ");
				System.out.print("Participan los siguientes grupos: ");
				System.out.print(entrada.getTextContent() + " ");
				System.out.print(grupo.getTextContent() + " - ");
				System.out.print("\bn");
	
			}
		}
		System.out.println();
	}

}
